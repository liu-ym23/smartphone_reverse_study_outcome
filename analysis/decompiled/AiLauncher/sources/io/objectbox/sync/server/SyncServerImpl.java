package io.objectbox.sync.server;

import io.objectbox.sync.listener.SyncChangeListener;
import java.io.Closeable;

/* loaded from: classes4.dex */
public final class SyncServerImpl implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public volatile long f34388a;

    private static native long nativeCreateFromFlatOptions(long j10, byte[] bArr);

    private native void nativeDelete(long j10);

    private native int nativeGetPort(long j10);

    private native String nativeGetStatsString(long j10);

    private native boolean nativeIsRunning(long j10);

    private native void nativeSetSyncChangesListener(long j10, SyncChangeListener syncChangeListener);

    private native void nativeStart(long j10);

    private native void nativeStop(long j10);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j10 = this.f34388a;
        this.f34388a = 0L;
        if (j10 != 0) {
            nativeDelete(j10);
        }
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
