package org.apache.commons.compress.archivers.examples;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.Enumeration;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
public class Expander {

    private interface ArchiveEntrySupplier {
        ArchiveEntry getNextReadableEntry() throws IOException;
    }

    private interface EntryWriter {
        void writeEntryDataTo(ArchiveEntry r1, OutputStream r2) throws IOException;
    }

    public Expander() {
    }

    public void expand(File archive, File targetDirectory) throws IOException, ArchiveException {
        InputStream i = new BufferedInputStream(Files.newInputStream(archive.toPath(), new OpenOption[0]));
        new ArchiveStreamFactory();     // Catch: Throwable -> L6
        String format = ArchiveStreamFactory.detect(i);     // Catch: Throwable -> L6
        i.close();
        expand(format, archive, targetDirectory);
        return;
    L6:
        th = move-exception;
        i.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    public void expand(String format, File archive, File targetDirectory) throws IOException, ArchiveException {
        if (prefersSeekableByteChannel(format) == false) goto L16;
        SeekableByteChannel c = FileChannel.open(archive.toPath(), new OpenOption[]{StandardOpenOption.READ});
        expand(format, c, targetDirectory);     // Catch: Throwable -> L9
        if (c == null) goto L34;
        c.close();
        return;
    L34:
        return;
    L9:
        th = move-exception;
        if (c != null) goto L30;
    L15:
        throw th;
    L30:
        c.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    L16:
        InputStream i = new BufferedInputStream(Files.newInputStream(archive.toPath(), new OpenOption[0]));
        expand(format, i, targetDirectory);     // Catch: Throwable -> L20
        i.close();
        return;
    L20:
        th = move-exception;
        i.close();     // Catch: Throwable -> L23
    L25:
        throw th;
    L23:
        th = move-exception;
        th.addSuppressed(th);
        goto L25
    }

    public void expand(InputStream archive, File targetDirectory) throws IOException, ArchiveException {
        expand(new ArchiveStreamFactory().createArchiveInputStream(archive), targetDirectory);
    }

    public void expand(String format, InputStream archive, File targetDirectory) throws IOException, ArchiveException {
        expand(new ArchiveStreamFactory().createArchiveInputStream(format, archive), targetDirectory);
    }

    public void expand(String format, SeekableByteChannel archive, File targetDirectory) throws IOException, ArchiveException {
        if (prefersSeekableByteChannel(format) == true) goto L6;
        expand(format, Channels.newInputStream(archive), targetDirectory);
        return;
    L6:
        if (ArchiveStreamFactory.ZIP.equalsIgnoreCase(format) == false) goto L9;
        expand(new ZipFile(archive), targetDirectory);
        return;
    L9:
        if (ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(format) == false) goto L13;
        expand(new SevenZFile(archive), targetDirectory);
        return;
    L13:
        throw new ArchiveException("don't know how to handle format " + format);
    }

    public void expand(final ArchiveInputStream archive, File targetDirectory) throws IOException, ArchiveException {
        expand(new AnonymousClass1(this, archive), new AnonymousClass2(this, archive), targetDirectory);
    }

    public void expand(final ZipFile archive, File targetDirectory) throws IOException, ArchiveException {
        final Enumeration<ZipArchiveEntry> entries = archive.getEntries();
        expand(new AnonymousClass3(this, entries, archive), new AnonymousClass4(this, archive), targetDirectory);
    }

    public void expand(final SevenZFile archive, File targetDirectory) throws IOException, ArchiveException {
        expand(new AnonymousClass5(this, archive), new AnonymousClass6(this, archive), targetDirectory);
    }

    private boolean prefersSeekableByteChannel(String format) {
        if (ArchiveStreamFactory.ZIP.equalsIgnoreCase(format) == false) goto L5;
    L8:
        return true;
    L5:
        if (ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(format) == true) goto L8;
        return false;
    }

    private void expand(ArchiveEntrySupplier supplier, EntryWriter writer, File targetDirectory) throws IOException {
        String targetDirPath = targetDirectory.getCanonicalPath();
        if (targetDirPath.endsWith(File.separator) == true) goto L5;
        targetDirPath = targetDirPath + File.separator;
    L5:
        ArchiveEntry nextEntry = supplier.getNextReadableEntry();
    L6:
        if (nextEntry == null) goto L39;
        File f = new File(targetDirectory, nextEntry.getName());
        if (f.getCanonicalPath().startsWith(targetDirPath) == false) goto L38;
        if (nextEntry.isDirectory() == true) goto L12;
        File parent = f.getParentFile();
        if (parent.isDirectory() == false) goto L21;
    L25:
        OutputStream o = Files.newOutputStream(f.toPath(), new OpenOption[0]);
        writer.writeEntryDataTo(nextEntry, o);     // Catch: Throwable -> L30
        if (o == null) goto L29;
        o.close();
    L29:
        nextEntry = supplier.getNextReadableEntry();
    L30:
        th = move-exception;
        if (o != null) goto L40;
    L36:
        throw th;
    L40:
        o.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.addSuppressed(th);
        goto L36
    L21:
        if (parent.mkdirs() == true) goto L25;
        throw new IOException("failed to create directory " + parent);
    L12:
        if (f.isDirectory() == true) goto L29;
        if (f.mkdirs() == true) goto L29;
        throw new IOException("failed to create directory " + f);
    L38:
        throw new IOException("expanding " + nextEntry.getName() + " would create file outside of " + targetDirectory);
    }
}
