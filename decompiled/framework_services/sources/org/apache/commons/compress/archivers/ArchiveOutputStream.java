package org.apache.commons.compress.archivers;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ArchiveOutputStream extends OutputStream {
    static final int BYTE_MASK = 255;
    private long bytesWritten;
    private final byte[] oneByte;

    public abstract void closeArchiveEntry() throws IOException;

    public abstract ArchiveEntry createArchiveEntry(File r1, String r2) throws IOException;

    public abstract void finish() throws IOException;

    public abstract void putArchiveEntry(ArchiveEntry r1) throws IOException;

    public ArchiveOutputStream() {
        this.oneByte = new byte[1];
        this.bytesWritten = 0;
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        this.oneByte[0] = (byte) (b & 255);
        write(this.oneByte, 0, 1);
    }

    protected void count(int written) {
        count(written);
    }

    protected void count(long written) {
        if (written == (-1)) goto L6;
        this.bytesWritten += written;
        return;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesWritten;
    }

    public long getBytesWritten() {
        return this.bytesWritten;
    }

    public boolean canWriteEntryData(ArchiveEntry archiveEntry) {
        return true;
    }
}
