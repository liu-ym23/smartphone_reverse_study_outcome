package io.objectbox.sync;

import Q8.d;
import V8.a;
import io.objectbox.BoxStore;
import io.objectbox.sync.listener.SyncChangeListener;

/* loaded from: classes4.dex */
public final class SyncClientImpl implements a {

    /* renamed from: a, reason: collision with root package name */
    public BoxStore f34386a;

    /* renamed from: b, reason: collision with root package name */
    public volatile long f34387b;

    public class InternalSyncClientListener {
    }

    private native void nativeAddLoginCredentials(long j10, long j11, byte[] bArr, boolean z10);

    private native void nativeAddLoginCredentialsUserPassword(long j10, long j11, String str, String str2, boolean z10);

    private native boolean nativeCancelUpdates(long j10);

    private static native long nativeCreate(long j10, String str, String[] strArr);

    private native void nativeDelete(long j10);

    private native int nativeGetState(long j10);

    private native void nativeObjectsMessageAddBytes(long j10, long j11, byte[] bArr, boolean z10);

    private native void nativeObjectsMessageAddString(long j10, long j11, String str);

    private native boolean nativeObjectsMessageSend(long j10, long j11);

    private native long nativeObjectsMessageStart(long j10, String str);

    private native void nativePutFilterVariable(long j10, String str, String str2);

    private native void nativeRemoveAllFilterVariables(long j10);

    private native void nativeRemoveFilterVariable(long j10, String str);

    private native boolean nativeRequestFullSync(long j10, boolean z10);

    private native boolean nativeRequestUpdates(long j10, boolean z10);

    private native long nativeRoundtripTime(long j10);

    private native long nativeServerTime(long j10);

    private native long nativeServerTimeDiff(long j10);

    private native void nativeSetListener(long j10, InternalSyncClientListener internalSyncClientListener);

    private native void nativeSetLoginInfo(long j10, long j11, byte[] bArr);

    private native void nativeSetLoginInfoUserPassword(long j10, long j11, String str, String str2);

    private native void nativeSetRequestUpdatesMode(long j10, boolean z10, boolean z11);

    private native void nativeSetSyncChangesListener(long j10, SyncChangeListener syncChangeListener);

    private native void nativeSetUncommittedAcks(long j10, boolean z10);

    private native void nativeStart(long j10);

    private native void nativeStop(long j10);

    private native boolean nativeTriggerReconnect(long j10);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j10;
        synchronized (this) {
            try {
                BoxStore boxStore = this.f34386a;
                if (boxStore != null) {
                    if (boxStore.D0() == this) {
                        d.a(boxStore, null);
                    }
                    this.f34386a = null;
                }
                j10 = this.f34387b;
                this.f34387b = 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (j10 != 0) {
            nativeDelete(j10);
        }
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }
}
