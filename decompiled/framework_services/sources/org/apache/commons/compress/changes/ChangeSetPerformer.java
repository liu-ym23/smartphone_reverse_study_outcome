package org.apache.commons.compress.changes;

import com.android.server.slice.SliceClientPermissions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;
import org.apache.commons.compress.utils.IOUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ChangeSetPerformer {
    private final Set<Change> changes;

    interface ArchiveEntryIterator {
        InputStream getInputStream() throws IOException;

        boolean hasNext() throws IOException;

        ArchiveEntry next();
    }

    private static class ArchiveInputStreamIterator implements ArchiveEntryIterator {
        private final ArchiveInputStream in;
        private ArchiveEntry next;

        ArchiveInputStreamIterator(ArchiveInputStream in) {
            this.in = in;
        }

        @Override // org.apache.commons.compress.changes.ChangeSetPerformer.ArchiveEntryIterator
        public boolean hasNext() throws IOException {
            ArchiveEntry r0 = this.in.getNextEntry();
            this.next = r0;
            if (r0 == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // org.apache.commons.compress.changes.ChangeSetPerformer.ArchiveEntryIterator
        public ArchiveEntry next() {
            return this.next;
        }

        @Override // org.apache.commons.compress.changes.ChangeSetPerformer.ArchiveEntryIterator
        public InputStream getInputStream() {
            return this.in;
        }
    }

    private static class ZipFileIterator implements ArchiveEntryIterator {
        private ZipArchiveEntry current;
        private final ZipFile in;
        private final Enumeration<ZipArchiveEntry> nestedEnum;

        ZipFileIterator(ZipFile in) {
            this.in = in;
            this.nestedEnum = in.getEntriesInPhysicalOrder();
        }

        @Override // org.apache.commons.compress.changes.ChangeSetPerformer.ArchiveEntryIterator
        public boolean hasNext() {
            return this.nestedEnum.hasMoreElements();
        }

        @Override // org.apache.commons.compress.changes.ChangeSetPerformer.ArchiveEntryIterator
        public ArchiveEntry next() {
            this.current = this.nestedEnum.nextElement();
            return this.current;
        }

        @Override // org.apache.commons.compress.changes.ChangeSetPerformer.ArchiveEntryIterator
        public InputStream getInputStream() throws IOException {
            return this.in.getInputStream(this.current);
        }
    }

    public ChangeSetPerformer(ChangeSet changeSet) {
        this.changes = changeSet.getChanges();
    }

    public ChangeSetResults perform(ArchiveInputStream in, ArchiveOutputStream out) throws IOException {
        return perform(new ArchiveInputStreamIterator(in), out);
    }

    public ChangeSetResults perform(ZipFile in, ArchiveOutputStream out) throws IOException {
        return perform(new ZipFileIterator(in), out);
    }

    private ChangeSetResults perform(ArchiveEntryIterator entryIterator, ArchiveOutputStream out) throws IOException {
        ChangeSetResults results = new ChangeSetResults();
        Set<Change> workingSet = new LinkedHashSet(this.changes);
        Iterator<Change> it = workingSet.iterator();
    L4:
        if (it.hasNext() == false) goto L12;
        Change change = it.next();
        if (change.type() != 2) goto L4;
        if (change.isReplaceMode() == false) goto L4;
        copyStream(change.getInput(), out, change.getEntry());
        it.remove();
        results.addedFromChangeSet(change.getEntry().getName());
    L12:
        if (entryIterator.hasNext() == false) goto L36;
        ArchiveEntry entry = entryIterator.next();
        boolean copy = true;
        Iterator<Change> it2 = workingSet.iterator();
    L15:
        if (it2.hasNext() == false) goto L29;
        Change change2 = it2.next();
        int type = change2.type();
        String name = entry.getName();
        if (type != 1) goto L23;
        if (name == null) goto L23;
        if (name.equals(change2.targetFile()) == false) goto L15;
        copy = false;
        it2.remove();
        results.deleted(name);
    L23:
        if (type != 4) goto L15;
        if (name == null) goto L15;
        if (name.startsWith(change2.targetFile() + SliceClientPermissions.SliceAuthority.DELIMITER) == false) goto L15;
        copy = false;
        results.deleted(name);
    L29:
        if (copy == false) goto L12;
        if (isDeletedLater(workingSet, entry) == true) goto L12;
        if (results.hasBeenAdded(entry.getName()) == true) goto L12;
        copyStream(entryIterator.getInputStream(), out, entry);
        results.addedFromStream(entry.getName());
        goto L12
    L36:
        Iterator<Change> it3 = workingSet.iterator();
    L38:
        if (it3.hasNext() == false) goto L47;
        Change change3 = it3.next();
        if (change3.type() != 2) goto L38;
        if (change3.isReplaceMode() == true) goto L38;
        if (results.hasBeenAdded(change3.getEntry().getName()) == true) goto L38;
        copyStream(change3.getInput(), out, change3.getEntry());
        it3.remove();
        results.addedFromChangeSet(change3.getEntry().getName());
        goto L38
    L47:
        out.finish();
        return results;
    }

    private boolean isDeletedLater(Set<Change> workingSet, ArchiveEntry entry) {
        String source = entry.getName();
        if (workingSet.isEmpty() == true) goto L18;
        Iterator<Change> r1 = workingSet.iterator();
    L6:
        if (r1.hasNext() == false) goto L27;
        Change change = r1.next();
        int type = change.type();
        String target = change.targetFile();
        if (type != 1) goto L13;
        if (source.equals(target) == false) goto L13;
        return true;
    L13:
        if (type != 4) goto L6;
        if (source.startsWith(target + SliceClientPermissions.SliceAuthority.DELIMITER) == false) goto L6;
        return true;
    L27:
        return false;
    L18:
        return false;
    }

    private void copyStream(InputStream in, ArchiveOutputStream out, ArchiveEntry entry) throws IOException {
        out.putArchiveEntry(entry);
        IOUtils.copy(in, out);
        out.closeArchiveEntry();
    }
}
