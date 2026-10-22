package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.view.Surface;
import androidx.arch.core.util.Function;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.MatrixExt;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.util.GLUtils;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultSurfaceProcessor implements SurfaceProcessorInternal, SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = "DefaultSurfaceProcessor";
    private final Executor mGlExecutor;
    final Handler mGlHandler;
    private final OpenGlRenderer mGlRenderer;
    final HandlerThread mGlThread;
    private int mInputSurfaceCount;
    private final AtomicBoolean mIsReleaseRequested;
    private boolean mIsReleased;
    final Map<SurfaceOutput, Surface> mOutputSurfaces;
    private final List<PendingSnapshot> mPendingSnapshots;
    private final float[] mSurfaceOutputMatrix;
    private final float[] mTextureMatrix;

    public static class Factory {
        private static Function<DynamicRange, SurfaceProcessorInternal> sSupplier;

        static {
            sSupplier = new p();
        }

        private Factory() {
        }

        public static SurfaceProcessorInternal newInstance(DynamicRange r100) {
            return sSupplier.apply(r100);
        }

        public static void setSupplier(Function<DynamicRange, SurfaceProcessorInternal> r100) {
            sSupplier = r100;
        }
    }

    public static abstract class PendingSnapshot {
        public PendingSnapshot() {
        }

        public abstract CallbackToFutureAdapter.Completer<Void> getCompleter();

        public abstract int getJpegQuality();

        public abstract int getRotationDegrees();

        public static AutoValue_DefaultSurfaceProcessor_PendingSnapshot of(int r100, int r101, CallbackToFutureAdapter.Completer<Void> r102) {
            return new AutoValue_DefaultSurfaceProcessor_PendingSnapshot(r100, r101, r102);
        }
    }

    public static /* synthetic */ void a(DefaultSurfaceProcessor r100, SurfaceOutput r101) {
        r100.lambda$onOutputSurface$4(r101);
    }

    public static /* synthetic */ void b(DefaultSurfaceProcessor r100) {
        r100.lambda$release$5();
    }

    public static /* synthetic */ void c(DefaultSurfaceProcessor r100, SurfaceOutput r101, SurfaceOutput.Event r102) {
        r100.lambda$onOutputSurface$3(r101, r102);
    }

    public static /* synthetic */ void d(DefaultSurfaceProcessor r100, DynamicRange r101, Map r102, CallbackToFutureAdapter.Completer r103) {
        r100.lambda$initGlRenderer$9(r101, r102, r103);
    }

    public static /* synthetic */ Object e(DefaultSurfaceProcessor r100, int r101, int r102, CallbackToFutureAdapter.Completer r103) {
        return r100.lambda$snapshot$8(r101, r102, r103);
    }

    public static /* synthetic */ Object g(DefaultSurfaceProcessor r100, DynamicRange r101, Map r102, CallbackToFutureAdapter.Completer r103) {
        return r100.lambda$initGlRenderer$10(r101, r102, r103);
    }

    public static /* synthetic */ void i() {
        lambda$executeSafely$11();
    }

    public static /* synthetic */ void j(DefaultSurfaceProcessor r100, PendingSnapshot r101) {
        r100.lambda$snapshot$6(r101);
    }

    public static /* synthetic */ void k(DefaultSurfaceProcessor r100, SurfaceRequest r101, SurfaceTexture r102, Surface r103, SurfaceRequest.Result r104) {
        r100.lambda$onInputSurface$1(r101, r102, r103, r104);
    }

    public static /* synthetic */ void l(CallbackToFutureAdapter.Completer r100) {
        lambda$snapshot$7(r100);
    }

    private static /* synthetic */ void lambda$executeSafely$11() {
    }

    private /* synthetic */ void lambda$release$5() {
        this.mIsReleased = true;
        checkReadyToRelease();
    }

    public static /* synthetic */ void n(DefaultSurfaceProcessor r100, Runnable r101, Runnable r102) {
        r100.lambda$executeSafely$12(r101, r102);
    }

    public static /* synthetic */ void o(DefaultSurfaceProcessor r100, SurfaceRequest r101, SurfaceRequest.TransformationInfo r102) {
        r100.lambda$onInputSurface$0(r101, r102);
    }

    public static /* synthetic */ void p(DefaultSurfaceProcessor r100, SurfaceRequest r101) {
        r100.lambda$onInputSurface$2(r101);
    }

    private void checkReadyToRelease() {
        if (this.mIsReleased == true) goto L5;
        return;
    L5:
        if (this.mInputSurfaceCount != 0) goto L19;
        Iterator<SurfaceOutput> r100 = this.mOutputSurfaces.keySet().iterator();
    L8:
        if (r100.hasNext() == false) goto L10;
        r100.next().close();
        goto L8
    L10:
        Iterator<PendingSnapshot> r101 = this.mPendingSnapshots.iterator();
    L12:
        if (r101.hasNext() == false) goto L14;
        r101.next().getCompleter().setException(new Exception("Failed to snapshot: DefaultSurfaceProcessor is released."));
        goto L12
    L14:
        this.mOutputSurfaces.clear();
        this.mGlRenderer.release();
        this.mGlThread.quit();
        return;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public void release() {
        if (this.mIsReleaseRequested.getAndSet(true) == false) goto L5;
        return;
    L5:
        executeSafely(new n(this));
    }

    public DefaultSurfaceProcessor(DynamicRange r100) {
        this(r100, Collections.emptyMap());
    }

    private void executeSafely(Runnable r100) {
        executeSafely(r100, new o());
    }

    private void failAllPendingSnapshots(Throwable r100) {
        Iterator<PendingSnapshot> r101 = this.mPendingSnapshots.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().getCompleter().setException(r100);
        goto L4
    L6:
        this.mPendingSnapshots.clear();
    }

    private /* synthetic */ void lambda$onInputSurface$2(final SurfaceRequest r100) {
        this.mInputSurfaceCount++;
        final SurfaceTexture r101 = new SurfaceTexture(this.mGlRenderer.getTextureName());
        r101.setDefaultBufferSize(r100.getResolution().getWidth(), r100.getResolution().getHeight());
        final Surface r102 = new Surface(r101);
        r100.setTransformationInfoListener(this.mGlExecutor, new b(this, r100));
        r100.provideSurface(r102, this.mGlExecutor, new c(this, r100, r101, r102));
        r101.setOnFrameAvailableListener(this, this.mGlHandler);
    }

    private /* synthetic */ void lambda$onOutputSurface$4(final SurfaceOutput r100) {
        Surface r101 = r100.getSurface(this.mGlExecutor, new d(this, r100));
        this.mGlRenderer.registerOutputSurface(r101);
        this.mOutputSurfaces.put(r100, r101);
    }

    private /* synthetic */ void lambda$snapshot$6(PendingSnapshot r100) {
        this.mPendingSnapshots.add(r100);
    }

    private static /* synthetic */ void lambda$snapshot$7(CallbackToFutureAdapter.Completer r100) {
        r100.setException(new Exception("Failed to snapshot: OpenGLRenderer not ready."));
    }

    private void takeSnapshotAndDrawJpeg(Triple<Surface, Size, float[]> r110) {
        if (this.mPendingSnapshots.isEmpty() == false) goto L5;
        return;
    L5:
        if (r110 != null) goto L35;
        failAllPendingSnapshots(new Exception("Failed to snapshot: no JPEG Surface."));
        return;
    L35:
        ByteArrayOutputStream r100 = new ByteArrayOutputStream();     // Catch: IOException -> L32
        Iterator<PendingSnapshot> r101 = this.mPendingSnapshots.iterator();     // Catch: Throwable -> L26
        Bitmap r102 = null;
        byte[] r103 = null;
        int r104 = -1;
        int r105 = -1;
    L10:
        if (r101.hasNext() == false) goto L24;
        PendingSnapshot r106 = r101.next();     // Catch: Throwable -> L26
        if (r104 != r106.getRotationDegrees()) goto L15;
        if (r102 == null) goto L15;
    L20:
        if (r105 == r106.getJpegQuality()) goto L22;
        r100.reset();     // Catch: Throwable -> L26
        r105 = r106.getJpegQuality();     // Catch: Throwable -> L26
        r102.compress(Bitmap.CompressFormat.JPEG, r105, r100);     // Catch: Throwable -> L26
        r103 = r100.toByteArray();     // Catch: Throwable -> L26
    L22:
        Surface r107 = r110.getFirst();     // Catch: Throwable -> L26
        Objects.requireNonNull(r103);     // Catch: Throwable -> L26
        ImageProcessingUtil.writeJpegBytesToSurface(r107, r103);     // Catch: Throwable -> L26
        r106.getCompleter().set(null);     // Catch: Throwable -> L26
        r101.remove();     // Catch: Throwable -> L26
    L15:
        r104 = r106.getRotationDegrees();     // Catch: Throwable -> L26
        if (r102 == null) goto L18;
        r102.recycle();     // Catch: Throwable -> L26
    L18:
        r102 = getBitmap(r110.getSecond(), r110.getThird(), r104);     // Catch: Throwable -> L26
        r105 = -1;
        goto L20
    L24:
        r100.close();     // Catch: IOException -> L32
        return;
    L26:
        th = move-exception;
        r100.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: IOException -> L32
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L32
    L32:
        e = move-exception;
        failAllPendingSnapshots(e);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r110) {
        if (this.mIsReleaseRequested.get() == false) goto L5;
        return;
    L5:
        r110.updateTexImage();
        r110.getTransformMatrix(this.mTextureMatrix);
        Iterator<Map.Entry<SurfaceOutput, Surface>> r100 = this.mOutputSurfaces.entrySet().iterator();
        Triple<Surface, Size, float[]> r101 = null;
    L7:
        if (r100.hasNext() == false) goto L30;
        Map.Entry<SurfaceOutput, Surface> r102 = r100.next();
        Surface r103 = r102.getValue();
        SurfaceOutput r104 = r102.getKey();
        r104.updateTransformMatrix(this.mSurfaceOutputMatrix, this.mTextureMatrix);
        if (r104.getFormat() != 34) goto L14;
        this.mGlRenderer.render(r110.getTimestamp(), this.mSurfaceOutputMatrix, r103);     // Catch: RuntimeException -> L12
    L12:
        e = move-exception;
        Logger.e(TAG, "Failed to render with OpenGL.", e);
        goto L7
    L14:
        boolean r105 = true;
        if (r104.getFormat() != 256) goto L17;
        boolean r106 = true;
    L18:
        Preconditions.checkState(r106, "Unsupported format: " + r104.getFormat());
        if (r101 == null) goto L22;
        r105 = false;
    L22:
        Preconditions.checkState(r105, "Only one JPEG output is supported.");
        r101 = new Triple(r103, r104.getSize(), (float[]) this.mSurfaceOutputMatrix.clone());
        goto L7
    L17:
        r106 = false;
        goto L18
    L30:
        takeSnapshotAndDrawJpeg(r101);     // Catch: RuntimeException -> L25
        return;
    L25:
        e = move-exception;
        failAllPendingSnapshots(e);
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onInputSurface(final SurfaceRequest r100) {
        if (this.mIsReleaseRequested.get() == false) goto L6;
        r100.willNotProvideSurface();
        return;
    L6:
        Runnable r101 = new j(this, r100);
        Objects.requireNonNull(r100);
        executeSafely(r101, new k(r100));
    }

    @Override // androidx.camera.core.SurfaceProcessor
    public void onOutputSurface(final SurfaceOutput r100) {
        if (this.mIsReleaseRequested.get() == false) goto L6;
        r100.close();
        return;
    L6:
        Runnable r101 = new g(this, r100);
        Objects.requireNonNull(r100);
        executeSafely(r101, new h(r100));
    }

    public DefaultSurfaceProcessor(DynamicRange r100, Map<GLUtils.InputFormat, ShaderProvider> r101) {
        this.mIsReleaseRequested = new AtomicBoolean(false);
        this.mTextureMatrix = new float[16];
        this.mSurfaceOutputMatrix = new float[16];
        this.mOutputSurfaces = new LinkedHashMap();
        this.mInputSurfaceCount = 0;
        this.mIsReleased = false;
        this.mPendingSnapshots = new ArrayList();
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("GL Thread");
        this.mGlThread = r102;
        ThreadMethodProxy.start(r102);
        Handler r103 = new Handler(r102.getLooper());
        this.mGlHandler = r103;
        this.mGlExecutor = CameraXExecutors.newHandlerExecutor(r103);
        this.mGlRenderer = new OpenGlRenderer();
        initGlRenderer(r100, r101);     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        release();
        throw e;
    }

    private void executeSafely(final Runnable r100, final Runnable r101) {
        this.mGlExecutor.execute(new i(this, r101, r100));     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Logger.w(TAG, "Unable to executor runnable", e);
        r101.run();
    }

    private void initGlRenderer(final DynamicRange r100, final Map<GLUtils.InputFormat, ShaderProvider> r101) {
        CallbackToFutureAdapter.getFuture(new a(this, r100, r101)).get();     // Catch: Throwable -> L5 ExecutionException -> L7
        return;
    L5:
        e = move-exception;
        boolean r102 = e instanceof ExecutionException;
        Throwable r103 = e;
        if (r102 == false) goto L12;
        r103 = e.getCause();
    L12:
        if ((r103 instanceof RuntimeException) == false) goto L16;
        throw ((RuntimeException) r103);
    L16:
        throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", r103);
    }

    private /* synthetic */ void lambda$executeSafely$12(Runnable r100, Runnable r101) {
        if (this.mIsReleased == false) goto L5;
        r100.run();
        return;
    L5:
        r101.run();
    }

    private /* synthetic */ void lambda$onInputSurface$0(SurfaceRequest r100, SurfaceRequest.TransformationInfo r101) {
        GLUtils.InputFormat r102 = GLUtils.InputFormat.DEFAULT;
        if (r100.getDynamicRange().is10BitHdr() == true) goto L5;
    L7:
        this.mGlRenderer.setInputFormat(r102);
        return;
    L5:
        if (r101.hasCameraTransform() == false) goto L7;
        r102 = GLUtils.InputFormat.YUV;
        goto L7
    }

    private /* synthetic */ void lambda$onOutputSurface$3(SurfaceOutput r100, SurfaceOutput.Event r101) {
        r100.close();
        Surface r102 = this.mOutputSurfaces.remove(r100);
        if (r102 == null) goto L6;
        this.mGlRenderer.unregisterOutputSurface(r102);
        return;
    }

    @Override // androidx.camera.core.processing.SurfaceProcessorInternal
    public ListenableFuture<Void> snapshot(final int r100, final int r101) {
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.getFuture(new l(this, r100, r101)));
    }

    private Bitmap getBitmap(Size r100, float[] r101, int r102) {
        float[] r103 = (float[]) r101.clone();
        MatrixExt.preRotate(r103, r102, 0.5f, 0.5f);
        MatrixExt.preVerticalFlip(r103, 0.5f);
        return this.mGlRenderer.snapshot(TransformUtils.rotateSize(r100, r102), r103);
    }

    private /* synthetic */ Object lambda$initGlRenderer$10(final DynamicRange r100, final Map r101, final CallbackToFutureAdapter.Completer r102) throws Exception {
        executeSafely(new m(this, r100, r101, r102));
        return "Init GlRenderer";
    }

    private /* synthetic */ void lambda$initGlRenderer$9(DynamicRange r100, Map r101, CallbackToFutureAdapter.Completer r102) {
        this.mGlRenderer.init(r100, r101);     // Catch: RuntimeException -> L4
        r102.set(null);     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        r102.setException(e);
    }

    private /* synthetic */ Object lambda$snapshot$8(int r100, int r101, final CallbackToFutureAdapter.Completer r102) throws Exception {
        final AutoValue_DefaultSurfaceProcessor_PendingSnapshot r103 = PendingSnapshot.of(r100, r101, r102);
        executeSafely(new e(this, r103), new f(r102));
        return "DefaultSurfaceProcessor#snapshot";
    }

    private /* synthetic */ void lambda$onInputSurface$1(SurfaceRequest r100, SurfaceTexture r101, Surface r102, SurfaceRequest.Result r103) {
        r100.clearTransformationInfoListener();
        r101.setOnFrameAvailableListener(null);
        r101.release();
        r102.release();
        this.mInputSurfaceCount--;
        checkReadyToRelease();
    }
}
