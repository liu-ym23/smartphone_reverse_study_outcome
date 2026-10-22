package org.apache.commons.compress.archivers;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ArchiveInputStream extends InputStream {
    private static final int BYTE_MASK = 255;
    private long bytesRead;
    private final byte[] single;

    public abstract ArchiveEntry getNextEntry() throws IOException;

    public ArchiveInputStream() {
        this.single = new byte[1];
        this.bytesRead = 0;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int num = read(this.single, 0, 1);
        if (num != (-1)) goto L6;
        return -1;
    L6:
        return this.single[0] & CecDeviceType.INACTIVE;
    }

    protected void count(int read) {
        count(read);
    }

    protected void count(long read) {
        if (read == (-1)) goto L6;
        this.bytesRead += read;
        return;
    }

    protected void pushedBackBytes(long pushedBack) {
        this.bytesRead -= pushedBack;
    }

    @Deprecated
    public int getCount() {
        return (int) this.bytesRead;
    }

    public long getBytesRead() {
        return this.bytesRead;
    }

    public boolean canReadEntryData(ArchiveEntry archiveEntry) {
        return true;
    }
}
