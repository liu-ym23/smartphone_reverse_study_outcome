package com.ss.android.socialbase.downloader.segment;

/* JADX INFO: loaded from: classes4.dex */
public final class Buffer {
    public final byte[] data;
    public Buffer next;
    IOutput output;
    public int size;

    public Buffer(int r1) {
        this.data = new byte[r1];
    }
}
