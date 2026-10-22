package androidx.camera.core.impl;

import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DeferrableSurface {
    private static final boolean DEBUG = false;
    public static final Size SIZE_UNDEFINED = null;
    private static final String TAG = "DeferrableSurface";
    private static final AtomicInteger TOTAL_COUNT = null;
    private static final AtomicInteger USED_COUNT = null;
    private CallbackToFutureAdapter.Completer<Void> mCloseCompleter;
    private final ListenableFuture<Void> mCloseFuture;
    private boolean mClosed;
    Class<?> mContainerClass;
    private final Object mLock;
    private final Size mPrescribedSize;
    private final int mPrescribedStreamFormat;
    private CallbackToFutureAdapter.Completer<Void> mTerminationCompleter;
    private final ListenableFuture<Void> mTerminationFuture;
    private int mUseCount;

    public static final class SurfaceClosedException extends Exception {
        DeferrableSurface mDeferrableSurface;

        public DeferrableSurface getDeferrableSurface() {
            return this.mDeferrableSurface;
        }

        public SurfaceClosedException(String r100, DeferrableSurface r101) {
            super(r100);
            this.mDeferrableSurface = r101;
        }
    }

    public static final class SurfaceUnavailableException extends Exception {
        public SurfaceUnavailableException(String r100) {
            super(r100);
        }
    }

    public static /* synthetic */ void a(DeferrableSurface r100, String r101) {
        r100.lambda$new$2(r101);
    }

    public static /* synthetic */ Object b(DeferrableSurface r100, CallbackToFutureAdapter.Completer r101) {
        return r100.lambda$new$1(r101);
    }

    public static /* synthetic */ Object c(DeferrableSurface r100, CallbackToFutureAdapter.Completer r101) {
        return r100.lambda$new$0(r101);
    }

    public abstract ListenableFuture<Surface> provideSurface();

    static {
        SIZE_UNDEFINED = new Size(0, 0);
        DEBUG = Logger.isDebugEnabled(TAG);
        USED_COUNT = new AtomicInteger(0);
        TOTAL_COUNT = new AtomicInteger(0);
    }

    public DeferrableSurface() {
        this(SIZE_UNDEFINED, 0);
    }

    public void close() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == true) goto L13;
        this.mClosed = true;     // Catch: Throwable -> L18
        this.mCloseCompleter.set(null);     // Catch: Throwable -> L18
        if (this.mUseCount != 0) goto L9;
        CallbackToFutureAdapter.Completer<Void> r101 = this.mTerminationCompleter;     // Catch: Throwable -> L18
        this.mTerminationCompleter = null;     // Catch: Throwable -> L18
    L11:
        if (Logger.isDebugEnabled(TAG) == false) goto L14;
        Logger.d(TAG, "surface closed,  useCount=" + this.mUseCount + " closed=true " + this);     // Catch: Throwable -> L18
    L14:
        monitor-exit(r100);     // Catch: Throwable -> L18
        if (r101 == null) goto L23;
        r101.set(null);
        return;
    L23:
        return;
    L9:
        r101 = null;
        goto L11
    L13:
        r101 = null;
        goto L14
    }

    public void decrementUseCount() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mUseCount;     // Catch: Throwable -> L23
        if (r101 == 0) goto L22;
        int r102 = r101 - 1;     // Catch: Throwable -> L23
        this.mUseCount = r102;     // Catch: Throwable -> L23
        if (r102 == 0) goto L9;
    L11:
        CallbackToFutureAdapter.Completer<Void> r103 = null;
    L13:
        if (Logger.isDebugEnabled(TAG) == false) goto L17;
        Logger.d(TAG, "use count-1,  useCount=" + this.mUseCount + " closed=" + this.mClosed + " " + this);     // Catch: Throwable -> L23
        if (this.mUseCount != 0) goto L17;
        printGlobalDebugCounts("Surface no longer in use", TOTAL_COUNT.get(), USED_COUNT.decrementAndGet());     // Catch: Throwable -> L23
    L17:
        monitor-exit(r100);     // Catch: Throwable -> L23
        if (r103 == null) goto L27;
        r103.set(null);
        return;
    L27:
        return;
    L9:
        if (this.mClosed == false) goto L11;
        r103 = this.mTerminationCompleter;     // Catch: Throwable -> L23
        this.mTerminationCompleter = null;     // Catch: Throwable -> L23
        goto L13
    L22:
        throw new IllegalStateException("Decrementing use count occurs more times than incrementing");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public ListenableFuture<Void> getCloseFuture() {
        return Futures.nonCancellationPropagating(this.mCloseFuture);
    }

    public final ListenableFuture<Surface> getSurface() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mClosed == false) goto L9;
        ListenableFuture<Surface> r101 = Futures.immediateFailedFuture(new SurfaceClosedException("DeferrableSurface already closed.", this));     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101;
    L9:
        ListenableFuture<Surface> r102 = provideSurface();     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r102;
    }

    public ListenableFuture<Void> getTerminationFuture() {
        return Futures.nonCancellationPropagating(this.mTerminationFuture);
    }

    public int getUseCount() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mUseCount;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public void incrementUseCount() throws SurfaceClosedException {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mUseCount;     // Catch: Throwable -> L19
        if (r101 == 0) goto L7;
    L11:
        this.mUseCount = r101 + 1;     // Catch: Throwable -> L19
        if (Logger.isDebugEnabled(TAG) == true) goto L14;
    L17:
        monitor-exit(r100);     // Catch: Throwable -> L19
        return;
    L14:
        if (this.mUseCount != 1) goto L16;
        printGlobalDebugCounts("New surface in use", TOTAL_COUNT.get(), USED_COUNT.incrementAndGet());     // Catch: Throwable -> L19
    L16:
        Logger.d(TAG, "use count+1, useCount=" + this.mUseCount + " " + this);     // Catch: Throwable -> L19
        goto L17
    L7:
        if (this.mClosed == false) goto L11;
        throw new SurfaceClosedException("Cannot begin use on a closed surface.", this);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public boolean isClosed() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        boolean r101 = this.mClosed;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public Class<?> getContainerClass() {
        return this.mContainerClass;
    }

    public Size getPrescribedSize() {
        return this.mPrescribedSize;
    }

    public int getPrescribedStreamFormat() {
        return this.mPrescribedStreamFormat;
    }

    private /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer r100) throws Exception {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mTerminationCompleter = r100;     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return "DeferrableSurface-termination(" + this + ")";
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ Object lambda$new$1(CallbackToFutureAdapter.Completer r100) throws Exception {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mCloseCompleter = r100;     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        return "DeferrableSurface-close(" + this + ")";
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$2(String r100) {
        this.mTerminationFuture.get();     // Catch: Exception -> L4
        printGlobalDebugCounts("Surface terminated", TOTAL_COUNT.decrementAndGet(), USED_COUNT.get());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Logger.e(TAG, "Unexpected surface termination for " + this + "\nStack Trace:\n" + r100);
        monitor-enter(this.mLock);
    L9:
        th = move-exception;
        throw th;
    L8:
        throw new IllegalArgumentException(String.format("DeferrableSurface %s [closed: %b, use_count: %s] terminated with unexpected exception.", new Object[]{this, Boolean.valueOf(this.mClosed), Integer.valueOf(this.mUseCount)}), e);     // Catch: Throwable -> L9
    }

    public void setContainerClass(Class<?> r100) {
        this.mContainerClass = r100;
    }

    public DeferrableSurface(Size r100, int r101) {
        this.mLock = new Object();
        this.mUseCount = 0;
        this.mClosed = false;
        this.mPrescribedSize = r100;
        this.mPrescribedStreamFormat = r101;
        ListenableFuture<Void> r102 = CallbackToFutureAdapter.getFuture(new j(this));
        this.mTerminationFuture = r102;
        this.mCloseFuture = CallbackToFutureAdapter.getFuture(new k(this));
        if (Logger.isDebugEnabled(TAG) == false) goto L6;
        printGlobalDebugCounts("Surface created", TOTAL_COUNT.incrementAndGet(), USED_COUNT.get());
        final String r103 = Log.getStackTraceString(new Exception());
        r102.addListener(new l(this, r103), CameraXExecutors.directExecutor());
        return;
    }

    private void printGlobalDebugCounts(String r100, int r101, int r102) {
        if (DEBUG == false) goto L5;
    L7:
        Logger.d(TAG, r100 + "[total_surfaces=" + r101 + ", used_surfaces=" + r102 + "](" + this + com.alipay.sdk.m.u.i.f25855d);
        return;
    L5:
        if (Logger.isDebugEnabled(TAG) == false) goto L7;
        Logger.d(TAG, "DeferrableSurface usage statistics may be inaccurate since debug logging was not enabled at static initialization time. App restart may be required to enable accurate usage statistics.");
        goto L7
    }
}
