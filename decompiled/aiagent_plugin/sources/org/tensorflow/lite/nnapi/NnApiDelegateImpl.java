package org.tensorflow.lite.nnapi;

import org.tensorflow.lite.b;

/* JADX INFO: loaded from: classes5.dex */
public class NnApiDelegateImpl implements AutoCloseable, b, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f40592a;

    private static native long createDelegate(int r0, String r1, String r2, String r3, int r4, boolean r5, boolean r6, boolean r7, long r8);

    private static native void deleteDelegate(long r0);

    private static native int getNnapiErrno(long r0);

    @Override // java.lang.AutoCloseable, org.tensorflow.lite.b, java.io.Closeable
    public void close() {
        long r0 = this.f40592a;
        if (r0 == 0) goto L6;
        deleteDelegate(r0);
        this.f40592a = 0;
        return;
    }
}
