package io.objectbox.internal;

import io.objectbox.Transaction;
import java.io.Closeable;

/* loaded from: classes4.dex */
public class DebugCursor implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final Transaction f34371a;

    /* renamed from: b, reason: collision with root package name */
    public final long f34372b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f34373c;

    public static native long nativeCreate(long j10);

    public static native void nativeDestroy(long j10);

    public static native byte[] nativeGet(long j10, byte[] bArr);

    public static native byte[] nativeSeekOrNext(long j10, byte[] bArr);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.f34373c) {
            this.f34373c = true;
            Transaction transaction = this.f34371a;
            if (transaction != null && !transaction.m().isClosed()) {
                nativeDestroy(this.f34372b);
            }
        }
    }

    public void finalize() throws Throwable {
        if (this.f34373c) {
            return;
        }
        close();
        super.finalize();
    }
}
