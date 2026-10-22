package com.ss.android.socialbase.downloader.segment;

/* JADX INFO: loaded from: classes4.dex */
public interface IBufferPool {
    Buffer obtain();

    void recycle(Buffer r1);
}
