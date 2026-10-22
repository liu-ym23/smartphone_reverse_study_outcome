package com.ss.android.socialbase.downloader.utils;

import com.ss.android.a.b;
import java.io.Closeable;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes4.dex */
public class DownloadFileRandomAccess implements b {
    private static final int BUFFER_SIZE = 8192;
    private final FileChannel accessFile;
    private final ByteBuffer byteBuffer;
    private final FileInputStream inputStream;

    public DownloadFileRandomAccess(FileInputStream r1) {
        this.inputStream = r1;
        this.accessFile = r1.getChannel();
        this.byteBuffer = ByteBuffer.allocate(8192);
    }

    @Override // com.ss.android.a.b
    public long length() {
        return this.accessFile.size();
    }

    @Override // com.ss.android.a.b
    public int read(byte[] r2, int r3, int r4) {
        int r5 = this.accessFile.read(this.byteBuffer);
        if (r5 == (-1)) goto L5;
        this.byteBuffer.flip();
        this.byteBuffer.get(r2, 0, r5);
        this.byteBuffer.clear();
    L5:
        return r5;
    }

    @Override // com.ss.android.a.b
    public void seek(long r1, long r3) {
        this.accessFile.position(r1);
    }

    @Override // com.ss.android.a.b
    public void close() {
        DownloadUtils.safeClose(new Closeable[]{this.accessFile, this.inputStream});
    }
}
