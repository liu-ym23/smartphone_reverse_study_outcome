package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ByteArrayPool {
    protected static final Comparator<byte[]> BUF_COMPARATOR = null;
    private List<byte[]> mBuffersByLastUse;
    private List<byte[]> mBuffersBySize;
    private int mCurrentSize;
    private final int mSizeLimit;

    static {
        BUF_COMPARATOR = new AnonymousClass1();
    }

    public ByteArrayPool(int r10) {
        this.mBuffersByLastUse = new LinkedList();
        this.mBuffersBySize = new ArrayList(64);
        this.mCurrentSize = 0;
        this.mSizeLimit = r10;
    }

    private synchronized void trim() {
        monitor-enter(this);
    L13:
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.mCurrentSize <= this.mSizeLimit) goto L9;
        byte[] r10 = this.mBuffersByLastUse.remove(0);     // Catch: Throwable -> L7
        this.mBuffersBySize.remove(r10);     // Catch: Throwable -> L7
        this.mCurrentSize -= r10.length;     // Catch: Throwable -> L7
        goto L13
    L9:
        monitor-exit(this);
    }

    public synchronized byte[] getBuf(int r10) {
        monitor-enter(this);
        int r11 = 0;
    L19:
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r11 >= this.mBuffersBySize.size()) goto L14;
        byte[] r12 = this.mBuffersBySize.get(r11);     // Catch: Throwable -> L11
        if (r12.length >= r10) goto L8;
        r11 = r11 + 1;
        goto L19
    L8:
        this.mCurrentSize -= r12.length;     // Catch: Throwable -> L11
        this.mBuffersBySize.remove(r11);     // Catch: Throwable -> L11
        this.mBuffersByLastUse.remove(r12);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r12;
    L14:
        byte[] r13 = new byte[r10];     // Catch: Throwable -> L11
        monitor-exit(this);
        return r13;
    }

    public synchronized void returnBuf(byte[] r10) {
        monitor-enter(this);
        if (r10 != null) goto L18;
    L16:
        monitor-exit(this);
        return;
    L18:
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r10.length > this.mSizeLimit) goto L16;
        this.mBuffersByLastUse.add(r10);     // Catch: Throwable -> L13
        int r11 = Collections.binarySearch(this.mBuffersBySize, r10, BUF_COMPARATOR);     // Catch: Throwable -> L13
        if (r11 >= 0) goto L10;
        r11 = (-r11) - 1;     // Catch: Throwable -> L13
    L10:
        this.mBuffersBySize.add(r11, r10);     // Catch: Throwable -> L13
        this.mCurrentSize += r10.length;     // Catch: Throwable -> L13
        trim();     // Catch: Throwable -> L13
        monitor-exit(this);
    }
}
