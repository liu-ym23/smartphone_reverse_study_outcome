package org.apache.commons.compress.changes;

import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;

/* JADX INFO: loaded from: classes3.dex */
public final class ChangeSet {
    private final Set<Change> changes;

    public ChangeSet() {
        this.changes = new LinkedHashSet();
    }

    public void delete(String filename) {
        addDeletion(new Change(filename, 1));
    }

    public void deleteDir(String dirName) {
        addDeletion(new Change(dirName, 4));
    }

    public void add(ArchiveEntry pEntry, InputStream pInput) {
        add(pEntry, pInput, true);
    }

    public void add(ArchiveEntry pEntry, InputStream pInput, boolean replace) {
        addAddition(new Change(pEntry, pInput, replace));
    }

    private void addAddition(Change pChange) {
        if (2 == pChange.type()) goto L5;
        return;
    L5:
        if (pChange.getInput() != null) goto L8;
        return;
    L8:
        if (this.changes.isEmpty() == true) goto L24;
        Iterator<Change> it = this.changes.iterator();
    L11:
        if (it.hasNext() == false) goto L24;
        Change change = it.next();
        if (change.type() != 2) goto L11;
        if (change.getEntry() == null) goto L11;
        ArchiveEntry entry = change.getEntry();
        if (entry.equals(pChange.getEntry()) == false) goto L11;
        if (pChange.isReplaceMode() == false) goto L22;
        it.remove();
        this.changes.add(pChange);
        return;
    L22:
        return;
    L24:
        this.changes.add(pChange);
    }

    private void addDeletion(Change pChange) {
        if (1 == pChange.type()) goto L7;
        if (4 == pChange.type()) goto L7;
        return;
    L7:
        if (pChange.targetFile() == null) goto L49;
        String source = pChange.targetFile();
        if (source != null) goto L12;
    L33:
        this.changes.add(pChange);
        return;
    L12:
        if (this.changes.isEmpty() == true) goto L33;
        Iterator<Change> it = this.changes.iterator();
    L15:
        if (it.hasNext() == false) goto L33;
        Change change = it.next();
        if (change.type() != 2) goto L15;
        if (change.getEntry() == null) goto L15;
        String target = change.getEntry().getName();
        if (target == null) goto L15;
        if (1 != pChange.type()) goto L28;
        if (source.equals(target) == false) goto L28;
    L31:
        it.remove();
    L28:
        if (4 != pChange.type()) goto L15;
        if (target.matches(source + "/.*") == false) goto L15;
    }

    Set<Change> getChanges() {
        return new LinkedHashSet(this.changes);
    }
}
