package org.apache.commons.compress.archivers.ar;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.ArchiveUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ArArchiveOutputStream extends ArchiveOutputStream {
    public static final int LONGFILE_BSD = 1;
    public static final int LONGFILE_ERROR = 0;
    private long entryOffset;
    private boolean finished;
    private boolean haveUnclosedEntry;
    private int longFileMode;
    private final OutputStream out;
    private ArArchiveEntry prevEntry;

    public ArArchiveOutputStream(OutputStream pOut) {
        this.entryOffset = 0;
        this.haveUnclosedEntry = false;
        this.longFileMode = 0;
        this.finished = false;
        this.out = pOut;
    }

    public void setLongFileMode(int longFileMode) {
        this.longFileMode = longFileMode;
    }

    private long writeArchiveHeader() throws IOException {
        byte[] header = ArchiveUtils.toAsciiBytes(ArArchiveEntry.HEADER);
        this.out.write(header);
        return header.length;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void closeArchiveEntry() throws IOException {
        if (this.finished == true) goto L16;
        if (this.prevEntry == null) goto L14;
        if (this.haveUnclosedEntry == false) goto L14;
        if ((this.entryOffset % 2) == 0) goto L11;
        this.out.write(10);
    L11:
        this.haveUnclosedEntry = false;
        return;
    L14:
        throw new IOException("No current entry to close");
    L16:
        throw new IOException("Stream has already been finished");
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void putArchiveEntry(ArchiveEntry pEntry) throws IOException {
        if (this.finished == true) goto L17;
        ArArchiveEntry pArEntry = (ArArchiveEntry) pEntry;
        if (this.prevEntry != null) goto L8;
        writeArchiveHeader();
    L12:
        this.prevEntry = pArEntry;
        writeEntryHeader(pArEntry);
        this.entryOffset = 0;
        this.haveUnclosedEntry = true;
        return;
    L8:
        if (this.prevEntry.getLength() != this.entryOffset) goto L15;
        if (this.haveUnclosedEntry == false) goto L12;
        closeArchiveEntry();
        goto L12
    L15:
        throw new IOException("length does not match entry (" + this.prevEntry.getLength() + " != " + this.entryOffset);
    L17:
        throw new IOException("Stream has already been finished");
    }

    private long fill(long pOffset, long pNewOffset, char pFill) throws IOException {
        long diff = pNewOffset - pOffset;
        if (diff <= 0) goto L8;
        int i = 0;
    L6:
        if (i >= diff) goto L8;
        write(pFill);
        i = i + 1;
    L8:
        return pNewOffset;
    }

    private long write(String data) throws IOException {
        byte[] bytes = data.getBytes("ascii");
        write(bytes);
        return bytes.length;
    }

    private long writeEntryHeader(ArArchiveEntry pEntry) throws IOException {
        boolean mustAppendName = false;
        String n = pEntry.getName();
        if (this.longFileMode != 0) goto L10;
        if (n.length() <= 16) goto L10;
        throw new IOException("filename too long, > 16 chars: " + n);
    L10:
        if (1 == this.longFileMode) goto L12;
    L16:
        long offset = 0 + write(n);
        long offset2 = offset;
    L17:
        long offset3 = fill(offset2, 16, ' ');
        String m = "" + pEntry.getLastModified();
        if (m.length() > 12) goto L44;
        long offset4 = fill(write(m) + offset3, 28, ' ');
        String u = "" + pEntry.getUserId();
        if (u.length() > 6) goto L42;
        long offset5 = fill(write(u) + offset4, 34, ' ');
        String g = "" + pEntry.getGroupId();
        if (g.length() > 6) goto L40;
        long offset6 = fill(write(g) + offset5, 40, ' ');
        String fm = "" + Integer.toString(pEntry.getMode(), 8);
        if (fm.length() > 8) goto L38;
        long offset7 = fill(write(fm) + offset6, 48, ' ');
        long r5 = pEntry.getLength();
        if (mustAppendName == false) goto L28;
        int r7 = n.length();
    L29:
        String s = String.valueOf(r5 + ((long) r7));
        if (s.length() > 10) goto L36;
        long offset8 = fill(write(s) + offset7, 58, ' ') + write(ArArchiveEntry.TRAILER);
        if (mustAppendName == true) goto L34;
        return offset8;
    L34:
        return offset8 + write(n);
    L36:
        throw new IOException("size too long");
    L28:
        r7 = 0;
        goto L29
    L38:
        throw new IOException("filemode too long");
    L40:
        throw new IOException("groupid too long");
    L42:
        throw new IOException("userid too long");
    L44:
        throw new IOException("modified too long");
    L12:
        if (n.length() <= 16) goto L14;
    L15:
        mustAppendName = true;
        long offset9 = 0 + write("#1/" + String.valueOf(n.length()));
        offset2 = offset9;
        goto L17
    L14:
        if (n.contains(" ") == false) goto L16;
        goto L15
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) throws IOException {
        this.out.write(b, off, len);
        count(len);
        this.entryOffset += (long) len;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    L7:
        th = move-exception;
        this.out.close();
        this.prevEntry = null;
        throw th;
    L4:
        if (this.finished == true) goto L9;
        finish();     // Catch: Throwable -> L7
    L9:
        this.out.close();
        this.prevEntry = null;
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public ArchiveEntry createArchiveEntry(File inputFile, String entryName) throws IOException {
        if (this.finished == true) goto L7;
        return new ArArchiveEntry(inputFile, entryName);
    L7:
        throw new IOException("Stream has already been finished");
    }

    @Override // org.apache.commons.compress.archivers.ArchiveOutputStream
    public void finish() throws IOException {
        if (this.haveUnclosedEntry == true) goto L11;
        if (this.finished == true) goto L9;
        this.finished = true;
        return;
    L9:
        throw new IOException("This archive has already been finished");
    L11:
        throw new IOException("This archive contains unclosed entries.");
    }
}
