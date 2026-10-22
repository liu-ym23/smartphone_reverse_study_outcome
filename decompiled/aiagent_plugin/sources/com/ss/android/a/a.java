package com.ss.android.a;

import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import java.io.File;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: FileRandomAccess.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RandomAccessFile f37040a;

    public a(File r3) {
        this.f37040a = new RandomAccessFile(r3, DownloadFileUtils.MODE_READ);
    }

    @Override // com.ss.android.a.b
    public long length() {
        return this.f37040a.length();
    }

    @Override // com.ss.android.a.b
    public int read(byte[] r1, int r2, int r3) {
        return this.f37040a.read(r1, r2, r3);
    }

    @Override // com.ss.android.a.b
    public void seek(long r1, long r3) {
        this.f37040a.seek(r1);
    }

    @Override // com.ss.android.a.b
    public void close() {
        this.f37040a.close();
    }
}
