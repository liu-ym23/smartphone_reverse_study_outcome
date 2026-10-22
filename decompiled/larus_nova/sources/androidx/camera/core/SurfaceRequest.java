package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class SurfaceRequest {
    public static final Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = null;
    private final CameraInternal mCamera;
    private final DynamicRange mDynamicRange;
    private final Range<Integer> mExpectedFrameRate;
    private final DeferrableSurface mInternalDeferrableSurface;
    private final boolean mIsPrimary;
    private final Object mLock;
    private final CallbackToFutureAdapter.Completer<Void> mRequestCancellationCompleter;
    private final Size mResolution;
    private final ListenableFuture<Void> mSessionStatusFuture;
    private final CallbackToFutureAdapter.Completer<Surface> mSurfaceCompleter;
    final ListenableFuture<Surface> mSurfaceFuture;
    private final CallbackToFutureAdapter.Completer<Void> mSurfaceRecreationCompleter;
    private TransformationInfo mTransformationInfo;
    private Executor mTransformationInfoExecutor;
    private TransformationInfoListener mTransformationInfoListener;

    public static final class RequestCancelledException extends RuntimeException {
        public RequestCancelledException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    public static abstract class Result {
        public static final int RESULT_INVALID_SURFACE = 2;
        public static final int RESULT_REQUEST_CANCELLED = 1;
        public static final int RESULT_SURFACE_ALREADY_PROVIDED = 3;
        public static final int RESULT_SURFACE_USED_SUCCESSFULLY = 0;
        public static final int RESULT_WILL_NOT_PROVIDE_SURFACE = 4;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        public abstract int getResultCode();

        public abstract Surface getSurface();

        public Result() {
        }

        public static Result of(int r100, Surface r101) {
            return new AutoValue_SurfaceRequest_Result(r100, r101);
        }
    }

    public static abstract class TransformationInfo {
        public abstract Rect getCropRect();

        public abstract int getRotationDegrees();

        public abstract Matrix getSensorToBufferTransform();

        public abstract int getTargetRotation();

        public abstract boolean hasCameraTransform();

        public abstract boolean isMirroring();

        public TransformationInfo() {
        }

        public static TransformationInfo of(Rect r100, int r101, int r110, boolean r111, Matrix r112, boolean r113) {
            return new AutoValue_SurfaceRequest_TransformationInfo(r100, r101, r110, r111, r112, r113);
        }
    }

    public interface TransformationInfoListener {
        void onTransformationInfoUpdate(TransformationInfo r100);
    }

    public static /* synthetic */ void a(Consumer r100, Surface r101) {
        lambda$provideSurface$4(r100, r101);
    }

    public static /* synthetic */ void b(TransformationInfoListener r100, TransformationInfo r101) {
        lambda$setTransformationInfoListener$8(r100, r101);
    }

    public static /* synthetic */ Object c(SurfaceRequest r100, AtomicReference r101, CallbackToFutureAdapter.Completer r102) {
        return r100.lambda$initialSurfaceRecreationCompleter$6(r101, r102);
    }

    public static /* synthetic */ void d(Consumer r100, Surface r101) {
        lambda$provideSurface$5(r100, r101);
    }

    public static /* synthetic */ void e(SurfaceRequest r100) {
        r100.lambda$new$3();
    }

    public static /* synthetic */ Object f(AtomicReference r100, String r101, CallbackToFutureAdapter.Completer r102) {
        return lambda$new$2(r100, r101, r102);
    }

    public static /* synthetic */ Object g(AtomicReference r100, String r101, CallbackToFutureAdapter.Completer r102) {
        return lambda$new$0(r100, r101, r102);
    }

    public static /* synthetic */ Object h(AtomicReference r100, String r101, CallbackToFutureAdapter.Completer r102) {
        return lambda$new$1(r100, r101, r102);
    }

    public static /* synthetic */ void i(TransformationInfoListener r100, TransformationInfo r101) {
        lambda$updateTransformationInfo$7(r100, r101);
    }

    static {
        FRAME_RATE_RANGE_UNSPECIFIED = StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
    }

    private /* synthetic */ void lambda$new$3() {
        this.mSurfaceFuture.cancel(true);
    }

    public void clearTransformationInfoListener() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        this.mTransformationInfoListener = null;     // Catch: Throwable -> L8
        this.mTransformationInfoExecutor = null;     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isServiced() {
        return this.mSurfaceFuture.isDone();
    }

    public boolean willNotProvideSurface() {
        return this.mSurfaceCompleter.setException(new DeferrableSurface.SurfaceUnavailableException("Surface request will not complete."));
    }

    public boolean invalidate() {
        willNotProvideSurface();
        return this.mSurfaceRecreationCompleter.set(null);
    }

    public CameraInternal getCamera() {
        return this.mCamera;
    }

    public DeferrableSurface getDeferrableSurface() {
        return this.mInternalDeferrableSurface;
    }

    public DynamicRange getDynamicRange() {
        return this.mDynamicRange;
    }

    public Range<Integer> getExpectedFrameRate() {
        return this.mExpectedFrameRate;
    }

    public Size getResolution() {
        return this.mResolution;
    }

    public boolean isPrimary() {
        return this.mIsPrimary;
    }

    public void updateTransformationInfo(final TransformationInfo r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mTransformationInfo = r100;     // Catch: Throwable -> L10
        final TransformationInfoListener r102 = this.mTransformationInfoListener;     // Catch: Throwable -> L10
        Executor r103 = this.mTransformationInfoExecutor;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        if (r102 == null) goto L15;
        if (r103 == null) goto L16;
        r103.execute(new o0(r102, r100));
        return;
    L16:
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private CallbackToFutureAdapter.Completer<Void> initialSurfaceRecreationCompleter(Executor r100, final Runnable r101) {
        final AtomicReference r102 = new AtomicReference(null);
        Futures.addCallback(CallbackToFutureAdapter.getFuture(new g0(this, r102)), new AnonymousClass5(this, r101), r100);
        return (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r102.get());
    }

    private /* synthetic */ Object lambda$initialSurfaceRecreationCompleter$6(AtomicReference r100, CallbackToFutureAdapter.Completer r101) throws Exception {
        r100.set(r101);
        return "SurfaceRequest-surface-recreation(" + hashCode() + ")";
    }

    private static /* synthetic */ void lambda$provideSurface$4(Consumer r100, Surface r101) {
        r100.accept(Result.of(3, r101));
    }

    private static /* synthetic */ void lambda$provideSurface$5(Consumer r100, Surface r101) {
        r100.accept(Result.of(4, r101));
    }

    private static /* synthetic */ void lambda$setTransformationInfoListener$8(TransformationInfoListener r100, TransformationInfo r101) {
        r100.onTransformationInfoUpdate(r101);
    }

    private static /* synthetic */ void lambda$updateTransformationInfo$7(TransformationInfoListener r100, TransformationInfo r101) {
        r100.onTransformationInfoUpdate(r101);
    }

    public void addRequestCancellationListener(Executor r100, Runnable r101) {
        this.mRequestCancellationCompleter.addCancellationListener(r101, r100);
    }

    public void setTransformationInfoListener(Executor r100, final TransformationInfoListener r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        this.mTransformationInfoListener = r101;     // Catch: Throwable -> L9
        this.mTransformationInfoExecutor = r100;     // Catch: Throwable -> L9
        final TransformationInfo r103 = this.mTransformationInfo;     // Catch: Throwable -> L9
        monitor-exit(r102);     // Catch: Throwable -> L9
        if (r103 == null) goto L14;
        r100.execute(new n0(r101, r103));
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public SurfaceRequest(Size r100, CameraInternal r101, Runnable r102) {
        this(r100, r101, DynamicRange.SDR, FRAME_RATE_RANGE_UNSPECIFIED, r102);
    }

    private static /* synthetic */ Object lambda$new$0(AtomicReference r100, String r101, CallbackToFutureAdapter.Completer r102) throws Exception {
        r100.set(r102);
        return r101 + "-cancellation";
    }

    private static /* synthetic */ Object lambda$new$1(AtomicReference r100, String r101, CallbackToFutureAdapter.Completer r102) throws Exception {
        r100.set(r102);
        return r101 + "-status";
    }

    private static /* synthetic */ Object lambda$new$2(AtomicReference r100, String r101, CallbackToFutureAdapter.Completer r102) throws Exception {
        r100.set(r102);
        return r101 + "-Surface";
    }

    public void provideSurface(final Surface r100, Executor r101, final Consumer<Result> r102) {
        if (this.mSurfaceCompleter.set(r100) == false) goto L5;
    L11:
        Futures.addCallback(this.mSessionStatusFuture, new AnonymousClass4(this, r102, r100), r101);
        return;
    L5:
        if (this.mSurfaceFuture.isCancelled() == true) goto L11;
        Preconditions.checkState(this.mSurfaceFuture.isDone());
        this.mSurfaceFuture.get();     // Catch: Throwable -> L10
        r101.execute(new h0(r102, r100));     // Catch: Throwable -> L10
        return;
    L10:
        r101.execute(new i0(r102, r100));
    }

    public SurfaceRequest(Size r100, CameraInternal r101, DynamicRange r110, Range<Integer> r111, Runnable r112) {
        this(r100, r101, true, r110, r111, r112);
    }

    public SurfaceRequest(final Size r100, CameraInternal r101, boolean r102, DynamicRange r103, Range<Integer> r104, Runnable r105) {
        this.mLock = new Object();
        this.mResolution = r100;
        this.mCamera = r101;
        this.mIsPrimary = r102;
        this.mDynamicRange = r103;
        this.mExpectedFrameRate = r104;
        final String r106 = "SurfaceRequest[size: " + r100 + ", id: " + hashCode() + "]";
        final AtomicReference r107 = new AtomicReference(null);
        final ListenableFuture r108 = CallbackToFutureAdapter.getFuture(new j0(r107, r106));
        final CallbackToFutureAdapter.Completer<Void> r109 = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r107.get());
        this.mRequestCancellationCompleter = r109;
        final AtomicReference r110 = new AtomicReference(null);
        ListenableFuture<Void> r111 = CallbackToFutureAdapter.getFuture(new k0(r110, r106));
        this.mSessionStatusFuture = r111;
        Futures.addCallback(r111, new AnonymousClass1(this, r109, r108), CameraXExecutors.directExecutor());
        final CallbackToFutureAdapter.Completer r112 = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r110.get());
        final AtomicReference r113 = new AtomicReference(null);
        ListenableFuture<Surface> r114 = CallbackToFutureAdapter.getFuture(new l0(r113, r106));
        this.mSurfaceFuture = r114;
        this.mSurfaceCompleter = (CallbackToFutureAdapter.Completer) Preconditions.checkNotNull((CallbackToFutureAdapter.Completer) r113.get());
        final int r115 = 34;
        DeferrableSurface r116 = new AnonymousClass2(this, r100, r115);
        this.mInternalDeferrableSurface = r116;
        final ListenableFuture<Void> r117 = r116.getTerminationFuture();
        Futures.addCallback(r114, new AnonymousClass3(this, r117, r112, r106), CameraXExecutors.directExecutor());
        r117.addListener(new m0(this), CameraXExecutors.directExecutor());
        this.mSurfaceRecreationCompleter = initialSurfaceRecreationCompleter(CameraXExecutors.directExecutor(), r105);
    }
}
