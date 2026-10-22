package androidx.camera.video.internal;

import androidx.camera.core.Logger;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class SharedByteBuffer implements Closeable {
    private static final String TAG = "SharedByteBuffer";
    private final Object mCloseLock;
    private boolean mClosed;
    private final Pair<Executor, Runnable> mFinalCloseAction;
    private final int mShareId;
    private final ByteBuffer mSharedByteBuffer;
    private final AtomicInteger mSharedRefCount;

    private boolean closeInternal() {
        Object r100 = this.mCloseLock;
        monitor-enter(r100);
    L25:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L25
        return false;
    L8:
        this.mClosed = true;     // Catch: Throwable -> L25
        int r101 = this.mSharedRefCount.decrementAndGet();     // Catch: Throwable -> L25
        monitor-exit(r100);     // Catch: Throwable -> L25
        if (Logger.isDebugEnabled(TAG) == false) goto L16;
        if (r101 < 0) goto L15;
        Logger.d(TAG, String.format(Locale.US, "Ref count decremented: %d [%s]", new Object[]{Integer.valueOf(r101), toString()}));
        goto L16
    L15:
        throw new AssertionError("Invalid ref count. close() should never produce a ref count below 0");
    L16:
        if (r101 == 0) goto L18;
    L24:
        return true;
    L18:
        if (Logger.isDebugEnabled(TAG) == false) goto L28;
        Logger.d(TAG, String.format(Locale.US, "Final reference released. Running final close action. [%s]", new Object[]{toString()}));
    L28:
        ((Executor) Preconditions.checkNotNull(this.mFinalCloseAction.first)).execute((Runnable) Preconditions.checkNotNull(this.mFinalCloseAction.second));     // Catch: RejectedExecutionException -> L22
    L22:
        e = move-exception;
        Logger.e(TAG, String.format(Locale.US, "Unable to execute final close action. [%s]", new Object[]{toString()}), e);
        goto L24
    }

    public ByteBuffer get() {
        Object r100 = this.mCloseLock;
        monitor-enter(r100);
        checkNotClosed("get()");     // Catch: Throwable -> L7
        ByteBuffer r101 = this.mSharedByteBuffer;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public SharedByteBuffer share() {
        Object r100 = this.mCloseLock;
        monitor-enter(r100);
        checkNotClosed("share()");     // Catch: Throwable -> L15
        int r101 = this.mSharedRefCount.incrementAndGet();     // Catch: Throwable -> L15
        AtomicInteger r102 = this.mSharedRefCount;     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        if (Logger.isDebugEnabled(TAG) == false) goto L14;
        if (r101 <= 1) goto L12;
        Logger.d(TAG, String.format(Locale.US, "Ref count incremented: %d [%s]", new Object[]{Integer.valueOf(r101), toString()}));
        goto L14
    L12:
        throw new AssertionError("Invalid ref count. share() should always produce a ref count of 2 or more.");
    L14:
        return new SharedByteBuffer(this.mSharedByteBuffer.asReadOnlyBuffer(), r102, this.mFinalCloseAction, this.mShareId);
    L15:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return String.format(Locale.US, "SharedByteBuffer[buf: %s, shareId: 0x%x, instanceId:0x%x]", new Object[]{this.mSharedByteBuffer, Integer.valueOf(this.mShareId), Integer.valueOf(System.identityHashCode(this))});
    }

    public void finalize() throws Throwable {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (closeInternal() == false) goto L5;
        Logger.w(TAG, String.format(Locale.US, "SharedByteBuffer closed by finalizer, but should have been closed manually with SharedByteBuffer.close() [%s]", new Object[]{toString()}));     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        closeInternal();
    }

    private void checkNotClosed(String r100) {
        if (this.mClosed == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Cannot call " + r100 + " on a closed SharedByteBuffer.");
    }

    public static SharedByteBuffer newSharedInstance(ByteBuffer r100, Executor r101, Runnable r102) {
        AtomicInteger r103 = new AtomicInteger(1);
        int r104 = System.identityHashCode(r100);
        return new SharedByteBuffer(((ByteBuffer) Preconditions.checkNotNull(r100)).asReadOnlyBuffer(), r103, new Pair((Executor) Preconditions.checkNotNull(r101), (Runnable) Preconditions.checkNotNull(r102)), r104);
    }

    private SharedByteBuffer(ByteBuffer r100, AtomicInteger r101, Pair<Executor, Runnable> r102, int r103) {
        this.mCloseLock = new Object();
        this.mClosed = false;
        this.mSharedByteBuffer = r100;
        this.mSharedRefCount = r101;
        this.mFinalCloseAction = r102;
        this.mShareId = r103;
        if (Logger.isDebugEnabled(TAG) == false) goto L9;
        int r104 = r101.get();
        if (r104 < 1) goto L8;
        return;
    L8:
        throw new AssertionError(String.format(Locale.US, "Cannot create new instance of SharedByteBuffer with invalid ref count %d. Ref count must be >= 1. [%s]", new Object[]{Integer.valueOf(r104), toString()}));
    }
}
