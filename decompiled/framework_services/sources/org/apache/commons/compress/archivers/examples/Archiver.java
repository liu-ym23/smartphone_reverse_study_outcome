package org.apache.commons.compress.archivers.examples;

import com.android.server.slice.SliceClientPermissions;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class Archiver {

    private interface ArchiveEntryConsumer {
        void accept(File r1, ArchiveEntry r2) throws IOException;
    }

    private interface ArchiveEntryCreator {
        ArchiveEntry create(File r1, String r2) throws IOException;
    }

    private interface Finisher {
        void finish() throws IOException;
    }

    public Archiver() {
    }

    public void create(String format, File target, File directory) throws IOException, ArchiveException {
        if (prefersSeekableByteChannel(format) == false) goto L16;
        SeekableByteChannel c = FileChannel.open(target.toPath(), new OpenOption[]{StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING});
        create(format, c, directory);     // Catch: Throwable -> L9
        if (c == null) goto L36;
        c.close();
        return;
    L36:
        return;
    L9:
        th = move-exception;
        if (c != null) goto L28;
    L15:
        throw th;
    L28:
        c.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L16:
        OutputStream o = Files.newOutputStream(target.toPath(), new OpenOption[0]);
        create(format, o, directory);     // Catch: Throwable -> L21
        if (o == null) goto L37;
        o.close();
        return;
    L37:
        return;
    L21:
        th = move-exception;
        if (o != null) goto L34;
    L27:
        throw th;
    L34:
        o.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);
        goto L27
    }

    public void create(String format, OutputStream target, File directory) throws IOException, ArchiveException {
        create(new ArchiveStreamFactory().createArchiveOutputStream(format, target), directory);
    }

    public void create(String format, SeekableByteChannel target, File directory) throws IOException, ArchiveException {
        if (prefersSeekableByteChannel(format) == true) goto L6;
        create(format, Channels.newOutputStream(target), directory);
        return;
    L6:
        if (ArchiveStreamFactory.ZIP.equalsIgnoreCase(format) == false) goto L9;
        create(new ZipArchiveOutputStream(target), directory);
        return;
    L9:
        if (ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(format) == false) goto L13;
        create(new SevenZOutputFile(target), directory);
        return;
    L13:
        throw new ArchiveException("don't know how to handle format " + format);
    }

    public void create(final ArchiveOutputStream target, File directory) throws IOException, ArchiveException {
        create(directory, new AnonymousClass1(this, target), new AnonymousClass2(this, target), new AnonymousClass3(this, target));
    }

    public void create(final SevenZOutputFile target, File directory) throws IOException {
        create(directory, new AnonymousClass4(this, target), new AnonymousClass5(this, target), new AnonymousClass6(this, target));
    }

    private boolean prefersSeekableByteChannel(String format) {
        if (ArchiveStreamFactory.ZIP.equalsIgnoreCase(format) == false) goto L5;
    L8:
        return true;
    L5:
        if (ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(format) == true) goto L8;
        return false;
    }

    private void create(File directory, ArchiveEntryCreator creator, ArchiveEntryConsumer consumer, Finisher finisher) throws IOException {
        create("", directory, creator, consumer);
        finisher.finish();
    }

    private void create(String prefix, File directory, ArchiveEntryCreator creator, ArchiveEntryConsumer consumer) throws IOException {
        File[] children = directory.listFiles();
        if (children != null) goto L5;
        return;
    L5:
        int r1 = children.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L15;
        File f = children[r2];
        StringBuilder r4 = new StringBuilder();
        r4.append(prefix);
        r4.append(f.getName());
        if (f.isDirectory() == false) goto L10;
        String r5 = SliceClientPermissions.SliceAuthority.DELIMITER;
    L11:
        r4.append(r5);
        String entryName = r4.toString();
        consumer.accept(f, creator.create(f, entryName));
        if (f.isDirectory() == false) goto L14;
        create(entryName, f, creator, consumer);
    L14:
        r2 = r2 + 1;
        goto L6
    L10:
        r5 = "";
        goto L11
    }
}
