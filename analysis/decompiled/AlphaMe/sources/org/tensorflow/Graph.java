package org.tensorflow;

import r3.b;

/* loaded from: classes2.dex */
public final class Graph implements AutoCloseable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13814a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public int f13816c = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f13815b = allocate();

    static {
        TensorFlow.a();
    }

    private static native long allocate();

    private static native void delete(long j4);

    private static native void importGraphDef(long j4, byte[] bArr, String str) throws IllegalArgumentException;

    private static native long operation(long j4, String str);

    public final void a(byte[] bArr) {
        synchronized (this.f13814a) {
            importGraphDef(this.f13815b, bArr, "");
        }
    }

    public final Operation b(String str) {
        synchronized (this.f13814a) {
            try {
                long jOperation = operation(this.f13815b, str);
                if (jOperation == 0) {
                    return null;
                }
                return new Operation(this, jOperation);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f13814a) {
            try {
                if (this.f13815b == 0) {
                    return;
                }
                while (this.f13816c > 0) {
                    try {
                        this.f13814a.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                delete(this.f13815b);
                this.f13815b = 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final b d() {
        return new b(this);
    }
}
