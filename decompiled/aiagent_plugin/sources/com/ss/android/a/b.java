package com.ss.android.a;

/* JADX INFO: compiled from: IRandomAccess.java */
/* JADX INFO: loaded from: classes4.dex */
public interface b {
    void close();

    long length();

    int read(byte[] r1, int r2, int r3);

    void seek(long r1, long r3);
}
