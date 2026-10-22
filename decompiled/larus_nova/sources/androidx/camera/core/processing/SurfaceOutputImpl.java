package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class SurfaceOutputImpl implements SurfaceOutput {
    private static final String TAG = "SurfaceOutputImpl";
    private final float[] mAdditionalTransform;
    private final SurfaceOutput.CameraInputInfo mCameraInputInfo;
    private final ListenableFuture<Void> mCloseFuture;
    private CallbackToFutureAdapter.Completer<Void> mCloseFutureCompleter;
    private Consumer<SurfaceOutput.Event> mEventListener;
    private Executor mExecutor;
    private final int mFormat;
    private boolean mHasPendingCloseRequest;
    private final float[] mInvertedTextureTransform;
    private boolean mIsClosed;
    private final Object mLock;
    private final float[] mSecondaryAdditionalTransform;
    private final SurfaceOutput.CameraInputInfo mSecondaryCameraInputInfo;
    private final float[] mSecondaryInvertedTextureTransform;
    private Matrix mSensorToBufferTransform;
    private final Size mSize;
    private final Surface mSurface;
    private final int mTargets;

    public static /* synthetic */ void a(SurfaceOutputImpl r100, AtomicReference r101) {
        r100.lambda$requestClose$1(r101);
    }

    public static /* synthetic */ Object b(SurfaceOutputImpl r100, CallbackToFutureAdapter.Completer r101) {
        return r100.lambda$new$0(r101);
    }

    @Override // androidx.camera.core.SurfaceOutput, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Object r100 = this.mLock;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsClosed == true) goto L7;
        this.mIsClosed = true;     // Catch: Throwable -> L10
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L10
        this.mCloseFutureCompleter.set(null);
    }

    public CameraInternal getCamera() {
        return this.mCameraInputInfo.getCameraInternal();
    }

    public Rect getInputCropRect() {
        return this.mCameraInputInfo.getInputCropRect();
    }

    public Size getInputSize() {
        return this.mCameraInputInfo.getInputSize();
    }

    public int getRotationDegrees() {
        return this.mCameraInputInfo.getRotationDegrees();
    }

    @Override // androidx.camera.core.SurfaceOutput
    public Matrix getSensorToBufferTransform() {
        return new Matrix(this.mSensorToBufferTransform);
    }

    public boolean isClosed() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        boolean r101 = this.mIsClosed;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isMirroring() {
        return this.mCameraInputInfo.getMirroring();
    }

    public void requestClose() {
        final AtomicReference r100 = new AtomicReference();
        Object r101 = this.mLock;
        monitor-enter(r101);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mExecutor == null) goto L12;
        Consumer<SurfaceOutput.Event> r102 = this.mEventListener;     // Catch: Throwable -> L21
        if (r102 == null) goto L12;
        if (this.mIsClosed == true) goto L13;
        r100.set(r102);     // Catch: Throwable -> L21
        Executor r103 = this.mExecutor;     // Catch: Throwable -> L21
        this.mHasPendingCloseRequest = false;     // Catch: Throwable -> L21
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L21
        if (r103 == null) goto L28;
        r103.execute(new d0(this, r100));     // Catch: RejectedExecutionException -> L18
        return;
    L18:
        e = move-exception;
        Logger.d(TAG, "Processor executor closed. Close request not posted.", e);
        return;
    L28:
        return;
    L13:
        r103 = null;
    L12:
        this.mHasPendingCloseRequest = true;     // Catch: Throwable -> L21
        goto L13
    }

    public ListenableFuture<Void> getCloseFuture() {
        return this.mCloseFuture;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public int getFormat() {
        return this.mFormat;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public Size getSize() {
        return this.mSize;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public int getTargets() {
        return this.mTargets;
    }

    private /* synthetic */ Object lambda$new$0(CallbackToFutureAdapter.Completer r100) throws Exception {
        this.mCloseFutureCompleter = r100;
        return "SurfaceOutputImpl close future complete";
    }

    private /* synthetic */ void lambda$requestClose$1(AtomicReference r100) {
        ((Consumer) r100.get()).accept(SurfaceOutput.Event.of(0, this));
    }

    private static void calculateInvertedTextureTransform(float[] r100, CameraInternal r101) {
        android.opengl.Matrix.setIdentityM(r100, 0);
        MatrixExt.preVerticalFlip(r100, 0.5f);
        if (r101 == null) goto L7;
        Preconditions.checkState(r101.getHasTransform(), "Camera has no transform.");
        MatrixExt.preRotate(r100, r101.getCameraInfo().getSensorRotationDegrees(), 0.5f, 0.5f);
        if (r101.isFrontFacing() == false) goto L7;
        android.opengl.Matrix.translateM(r100, 0, 1.0f, 0.0f, 0.0f);
        android.opengl.Matrix.scaleM(r100, 0, -1.0f, 1.0f, 1.0f);
    L7:
        android.opengl.Matrix.invertM(r100, 0, r100, 0);
    }

    @Override // androidx.camera.core.SurfaceOutput
    public Surface getSurface(Executor r100, Consumer<SurfaceOutput.Event> r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        this.mExecutor = r100;     // Catch: Throwable -> L10
        this.mEventListener = r101;     // Catch: Throwable -> L10
        boolean r103 = this.mHasPendingCloseRequest;     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
        if (r103 == false) goto L9;
        requestClose();
    L9:
        return this.mSurface;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // androidx.camera.core.SurfaceOutput
    public void updateTransformMatrix(float[] r100, float[] r101) {
        updateTransformMatrix(r100, r101, true);
    }

    private static void calculateAdditionalTransform(float[] r100, float[] r110, SurfaceOutput.CameraInputInfo r111) {
        android.opengl.Matrix.setIdentityM(r100, 0);
        if (r111 != null) goto L5;
        return;
    L5:
        MatrixExt.preVerticalFlip(r100, 0.5f);
        MatrixExt.preRotate(r100, r111.getRotationDegrees(), 0.5f, 0.5f);
        if (r111.getMirroring() == false) goto L8;
        android.opengl.Matrix.translateM(r100, 0, 1.0f, 0.0f, 0.0f);
        android.opengl.Matrix.scaleM(r100, 0, -1.0f, 1.0f, 1.0f);
    L8:
        Size r101 = TransformUtils.rotateSize(r111.getInputSize(), r111.getRotationDegrees());
        Matrix r102 = TransformUtils.getRectToRect(TransformUtils.sizeToRectF(r111.getInputSize()), TransformUtils.sizeToRectF(r101), r111.getRotationDegrees(), r111.getMirroring());
        RectF r103 = new RectF(r111.getInputCropRect());
        r102.mapRect(r103);
        float r104 = r103.left / r101.getWidth();
        float r105 = ((r101.getHeight() - r103.height()) - r103.top) / r101.getHeight();
        float r106 = r103.width() / r101.getWidth();
        float r107 = r103.height() / r101.getHeight();
        android.opengl.Matrix.translateM(r100, 0, r104, r105, 0.0f);
        android.opengl.Matrix.scaleM(r100, 0, r106, r107, 1.0f);
        calculateInvertedTextureTransform(r110, r111.getCameraInternal());
        android.opengl.Matrix.multiplyMM(r100, 0, r110, 0, r100, 0);
    }

    @Override // androidx.camera.core.SurfaceOutput
    public void updateTransformMatrix(float[] r100, float[] r101, boolean r102) {
        if (r102 == false) goto L5;
        float[] r103 = this.mAdditionalTransform;
    L6:
        android.opengl.Matrix.multiplyMM(r100, 0, r101, 0, r103, 0);
        return;
    L5:
        r103 = this.mSecondaryAdditionalTransform;
        goto L6
    }

    public SurfaceOutputImpl(Surface r100, int r101, int r102, Size r103, SurfaceOutput.CameraInputInfo r110, SurfaceOutput.CameraInputInfo r111, Matrix r112) {
        this.mLock = new Object();
        float[] r104 = new float[16];
        this.mAdditionalTransform = r104;
        float[] r105 = new float[16];
        this.mSecondaryAdditionalTransform = r105;
        float[] r106 = new float[16];
        this.mInvertedTextureTransform = r106;
        float[] r107 = new float[16];
        this.mSecondaryInvertedTextureTransform = r107;
        this.mHasPendingCloseRequest = false;
        this.mIsClosed = false;
        this.mSurface = r100;
        this.mTargets = r101;
        this.mFormat = r102;
        this.mSize = r103;
        this.mCameraInputInfo = r110;
        this.mSecondaryCameraInputInfo = r111;
        this.mSensorToBufferTransform = r112;
        calculateAdditionalTransform(r104, r106, r110);
        calculateAdditionalTransform(r105, r107, r111);
        this.mCloseFuture = CallbackToFutureAdapter.getFuture(new c0(this));
    }
}
