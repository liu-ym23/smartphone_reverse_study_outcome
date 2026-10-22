package org.tensorflow.contrib.android;

/* loaded from: classes2.dex */
public class RunStats implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public long f13827a = allocate();

    private static native long allocate();

    private static native void delete(long j4);

    @Override // java.lang.AutoCloseable
    public final void close() {
        long j4 = this.f13827a;
        if (j4 != 0) {
            delete(j4);
        }
        this.f13827a = 0L;
    }
}
