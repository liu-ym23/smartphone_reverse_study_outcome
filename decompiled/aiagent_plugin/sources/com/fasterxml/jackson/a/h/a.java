package com.fasterxml.jackson.a.h;

import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: BufferRecycler.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f12087c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f12088d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AtomicReferenceArray<byte[]> f12089a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final AtomicReferenceArray<char[]> f12090b;

    static {
        f12087c = new int[]{8000, 8000, DownloadErrorCode.ERROR_CRONET_ERROR_BASE, DownloadErrorCode.ERROR_CRONET_ERROR_BASE};
        f12088d = new int[]{DownloadErrorCode.ERROR_CRONET_HTTP_ERROR_END, DownloadErrorCode.ERROR_CRONET_HTTP_ERROR_END, 200, 200};
    }

    public a() {
        this(4, 4);
    }

    public a(int r2, int r3) {
        this.f12089a = new AtomicReferenceArray(r2);
        this.f12090b = new AtomicReferenceArray(r3);
    }

    public final byte[] a(int r2) {
        return a(r2, 0);
    }

    public byte[] a(int r3, int r4) {
        int r0 = c(r3);
        if (r4 >= r0) goto L5;
        r4 = r0;
    L5:
        byte[] r5 = (byte[]) ZeusTransformUtils.preCheckCast(this.f12089a.getAndSet(r3, null), byte[].class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L10;
        if (r5.length < r4) goto L10;
        return r5;
    L10:
        return e(r4);
    }

    public void a(int r1, byte[] r2) {
        this.f12089a.set(r1, r2);
    }

    public final char[] b(int r2) {
        return b(r2, 0);
    }

    public char[] b(int r3, int r4) {
        int r0 = d(r3);
        if (r4 >= r0) goto L5;
        r4 = r0;
    L5:
        char[] r5 = (char[]) ZeusTransformUtils.preCheckCast(this.f12090b.getAndSet(r3, null), char[].class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L10;
        if (r5.length < r4) goto L10;
        return r5;
    L10:
        return f(r4);
    }

    public void a(int r1, char[] r2) {
        this.f12090b.set(r1, r2);
    }

    public int c(int r1) {
        return f12087c[r1];
    }

    public int d(int r1) {
        return f12088d[r1];
    }

    public byte[] e(int r1) {
        return new byte[r1];
    }

    public char[] f(int r1) {
        return new char[r1];
    }
}
