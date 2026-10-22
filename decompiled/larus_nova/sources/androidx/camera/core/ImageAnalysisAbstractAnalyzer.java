package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ImageWriter;
import android.os.Build;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.OperationCanceledException;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
abstract class ImageAnalysisAbstractAnalyzer implements ImageReaderProxy.OnImageAvailableListener {
    private static final String TAG = "ImageAnalysisAnalyzer";
    private final Object mAnalyzerLock;
    protected boolean mIsAttached;
    private volatile boolean mOnePixelShiftEnabled;
    private Matrix mOriginalSensorToBufferTransformMatrix;
    private Rect mOriginalViewPortCropRect;
    private volatile int mOutputImageFormat;
    private volatile boolean mOutputImageRotationEnabled;
    private volatile int mPrevBufferRotationDegrees;
    private SafeCloseImageReaderProxy mProcessedImageReaderProxy;
    private ImageWriter mProcessedImageWriter;
    ByteBuffer mRGBConvertedBuffer;
    private volatile int mRelativeRotation;
    private ImageAnalysis.Analyzer mSubscribedAnalyzer;
    ByteBuffer mURotatedBuffer;
    private Matrix mUpdatedSensorToBufferTransformMatrix;
    private Rect mUpdatedViewPortCropRect;
    private Executor mUserExecutor;
    ByteBuffer mVRotatedBuffer;
    ByteBuffer mYRotatedBuffer;

    public static /* synthetic */ Object a(ImageAnalysisAbstractAnalyzer r100, Executor r101, ImageProxy r102, Matrix r103, ImageProxy r104, Rect r105, ImageAnalysis.Analyzer r106, CallbackToFutureAdapter.Completer r107) {
        return r100.lambda$analyzeImage$1(r101, r102, r103, r104, r105, r106, r107);
    }

    public static /* synthetic */ void b(ImageAnalysisAbstractAnalyzer r100, ImageProxy r101, Matrix r102, ImageProxy r103, Rect r104, ImageAnalysis.Analyzer r105, CallbackToFutureAdapter.Completer r106) {
        r100.lambda$analyzeImage$0(r101, r102, r103, r104, r105, r106);
    }

    public abstract ImageProxy acquireImage(ImageReaderProxy r100);

    public void attach() {
        this.mIsAttached = true;
    }

    public abstract void clearCache();

    public void detach() {
        this.mIsAttached = false;
        clearCache();
    }

    public abstract void onValidImageAvailable(ImageProxy r100);

    public ImageAnalysisAbstractAnalyzer() {
        this.mOutputImageFormat = 1;
        this.mOriginalViewPortCropRect = new Rect();
        this.mUpdatedViewPortCropRect = new Rect();
        this.mOriginalSensorToBufferTransformMatrix = new Matrix();
        this.mUpdatedSensorToBufferTransformMatrix = new Matrix();
        this.mAnalyzerLock = new Object();
        this.mIsAttached = true;
    }

    private void createHelperBuffer(ImageProxy r100) {
        if (this.mOutputImageFormat != 1) goto L15;
        if (this.mYRotatedBuffer != null) goto L7;
        this.mYRotatedBuffer = ByteBuffer.allocateDirect(r100.getWidth() * r100.getHeight());
    L7:
        this.mYRotatedBuffer.position(0);
        if (this.mURotatedBuffer != null) goto L10;
        this.mURotatedBuffer = ByteBuffer.allocateDirect((r100.getWidth() * r100.getHeight()) / 4);
    L10:
        this.mURotatedBuffer.position(0);
        if (this.mVRotatedBuffer != null) goto L13;
        this.mVRotatedBuffer = ByteBuffer.allocateDirect((r100.getWidth() * r100.getHeight()) / 4);
    L13:
        this.mVRotatedBuffer.position(0);
        return;
    L15:
        if (this.mOutputImageFormat == 2) goto L17;
        return;
    L17:
        if (this.mRGBConvertedBuffer != null) goto L22;
        this.mRGBConvertedBuffer = ByteBuffer.allocateDirect((r100.getWidth() * r100.getHeight()) * 4);
        return;
    }

    public ListenableFuture<Void> analyzeImage(final ImageProxy r110) {
        boolean r100 = false;
        if (this.mOutputImageRotationEnabled == false) goto L5;
        int r101 = this.mRelativeRotation;
    L6:
        Object r102 = this.mAnalyzerLock;
        monitor-enter(r102);
        final Executor r103 = this.mUserExecutor;     // Catch: Throwable -> L58
        final ImageAnalysis.Analyzer r111 = this.mSubscribedAnalyzer;     // Catch: Throwable -> L58
        if (this.mOutputImageRotationEnabled == true) goto L11;
    L13:
        boolean r112 = false;
    L14:
        if (r112 == false) goto L17;
        recreateImageReaderProxy(r110, r101);     // Catch: Throwable -> L58
    L17:
        if (this.mOutputImageRotationEnabled == false) goto L19;
        createHelperBuffer(r110);     // Catch: Throwable -> L58
    L19:
        SafeCloseImageReaderProxy r104 = this.mProcessedImageReaderProxy;     // Catch: Throwable -> L58
        ImageWriter r105 = this.mProcessedImageWriter;     // Catch: Throwable -> L58
        ByteBuffer r106 = this.mRGBConvertedBuffer;     // Catch: Throwable -> L58
        ByteBuffer r107 = this.mYRotatedBuffer;     // Catch: Throwable -> L58
        ByteBuffer r108 = this.mURotatedBuffer;     // Catch: Throwable -> L58
        ByteBuffer r109 = this.mVRotatedBuffer;     // Catch: Throwable -> L58
        monitor-exit(r102);     // Catch: Throwable -> L58
        if (r111 == null) goto L57;
        if (r103 == null) goto L57;
        if (this.mIsAttached == false) goto L57;
        if (r104 != null) goto L27;
    L39:
        ImageProxy r113 = null;
    L40:
        if (r113 != null) goto L42;
        r100 = true;
    L42:
        if (r100 == false) goto L44;
        final ImageProxy r114 = r110;
    L45:
        final Rect r115 = new Rect();
        final Matrix r116 = new Matrix();
        Object r117 = this.mAnalyzerLock;
        monitor-enter(r117);
        if (r112 == false) goto L50;
        if (r100 == true) goto L50;
        recalculateTransformMatrixAndCropRect(r110.getWidth(), r110.getHeight(), r114.getWidth(), r114.getHeight());     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    L50:
        this.mPrevBufferRotationDegrees = r101;     // Catch: Throwable -> L53
        r115.set(this.mUpdatedViewPortCropRect);     // Catch: Throwable -> L53
        r116.set(this.mUpdatedSensorToBufferTransformMatrix);     // Catch: Throwable -> L53
        monitor-exit(r117);     // Catch: Throwable -> L53
        return CallbackToFutureAdapter.getFuture(new m(this, r103, r110, r116, r114, r115, r111));
    L44:
        r114 = r113;
        goto L45
    L27:
        if (this.mOutputImageFormat != 2) goto L30;
        r113 = ImageProcessingUtil.convertYUVToRGB(r110, r104, r106, r101, this.mOnePixelShiftEnabled);
        goto L40
    L30:
        if (this.mOutputImageFormat != 1) goto L39;
        if (this.mOnePixelShiftEnabled == false) goto L34;
        ImageProcessingUtil.applyPixelShiftForYUV(r110);
    L34:
        if (r105 == null) goto L39;
        if (r107 == null) goto L39;
        if (r108 == null) goto L39;
        if (r109 == null) goto L39;
        r113 = ImageProcessingUtil.rotateYUV(r110, r104, r105, r107, r108, r109, r101);
    L57:
        return Futures.immediateFailedFuture(new OperationCanceledException("No analyzer or executor currently set."));
    L11:
        if (r101 == this.mPrevBufferRotationDegrees) goto L13;
        r112 = true;
    L58:
        th = move-exception;
        throw th;
    L5:
        r101 = 0;
        goto L6
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
    public void onImageAvailable(ImageReaderProxy r100) {
        ImageProxy r101 = acquireImage(r100);     // Catch: IllegalStateException -> L6
        if (r101 == null) goto L11;
        onValidImageAvailable(r101);     // Catch: IllegalStateException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        Logger.e(TAG, "Failed to acquire image.", e);
    }

    public void setOnePixelShiftEnabled(boolean r100) {
        this.mOnePixelShiftEnabled = r100;
    }

    public void setOutputImageFormat(int r100) {
        this.mOutputImageFormat = r100;
    }

    public void setOutputImageRotationEnabled(boolean r100) {
        this.mOutputImageRotationEnabled = r100;
    }

    public void setProcessedImageReaderProxy(SafeCloseImageReaderProxy r100) {
        Object r101 = this.mAnalyzerLock;
        monitor-enter(r101);
        this.mProcessedImageReaderProxy = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setRelativeRotation(int r100) {
        this.mRelativeRotation = r100;
    }

    public void setSensorToBufferTransformMatrix(Matrix r100) {
        Object r101 = this.mAnalyzerLock;
        monitor-enter(r101);
        this.mOriginalSensorToBufferTransformMatrix = r100;     // Catch: Throwable -> L7
        this.mUpdatedSensorToBufferTransformMatrix = new Matrix(this.mOriginalSensorToBufferTransformMatrix);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setViewPortCropRect(Rect r100) {
        Object r101 = this.mAnalyzerLock;
        monitor-enter(r101);
        this.mOriginalViewPortCropRect = r100;     // Catch: Throwable -> L7
        this.mUpdatedViewPortCropRect = new Rect(this.mOriginalViewPortCropRect);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static Rect getUpdatedCropRect(Rect r100, Matrix r101) {
        RectF r102 = new RectF(r100);
        r101.mapRect(r102);
        Rect r103 = new Rect();
        r102.round(r103);
        return r103;
    }

    private void recreateImageReaderProxy(ImageProxy r100, int r101) {
        SafeCloseImageReaderProxy r102 = this.mProcessedImageReaderProxy;
        if (r102 != null) goto L5;
        return;
    L5:
        r102.safeClose();
        this.mProcessedImageReaderProxy = createImageReaderProxy(r100.getWidth(), r100.getHeight(), r101, this.mProcessedImageReaderProxy.getImageFormat(), this.mProcessedImageReaderProxy.getMaxImages());
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        return;
    L8:
        if (this.mOutputImageFormat != 1) goto L15;
        ImageWriter r103 = this.mProcessedImageWriter;
        if (r103 == null) goto L12;
        ImageWriterCompat.close(r103);
    L12:
        this.mProcessedImageWriter = ImageWriterCompat.newInstance(this.mProcessedImageReaderProxy.getSurface(), this.mProcessedImageReaderProxy.getMaxImages());
        return;
    }

    public void setAnalyzer(Executor r100, ImageAnalysis.Analyzer r101) {
        if (r101 != null) goto L4;
        clearCache();
    L4:
        Object r102 = this.mAnalyzerLock;
        monitor-enter(r102);
        this.mSubscribedAnalyzer = r101;     // Catch: Throwable -> L9
        this.mUserExecutor = r100;     // Catch: Throwable -> L9
        monitor-exit(r102);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void recalculateTransformMatrixAndCropRect(int r100, int r101, int r102, int r103) {
        Matrix r104 = getAdditionalTransformMatrixAppliedByProcessor(r100, r101, r102, r103, this.mRelativeRotation);
        this.mUpdatedViewPortCropRect = getUpdatedCropRect(this.mOriginalViewPortCropRect, r104);
        this.mUpdatedSensorToBufferTransformMatrix.setConcat(this.mOriginalSensorToBufferTransformMatrix, r104);
    }

    private static SafeCloseImageReaderProxy createImageReaderProxy(int r100, int r101, int r102, int r103, int r104) {
        if (r102 != 90) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L11;
        int r106 = r101;
    L12:
        if (r105 == true) goto L16;
        r100 = r101;
    L16:
        return new SafeCloseImageReaderProxy(ImageReaderProxys.createIsolatedReader(r106, r100, r103, r104));
    L11:
        r106 = r100;
        goto L12
    L5:
        if (r102 == 270) goto L8;
        r105 = false;
        goto L9
    }

    public static Matrix getAdditionalTransformMatrixAppliedByProcessor(int r100, int r101, int r102, int r103, int r104) {
        Matrix r105 = new Matrix();
        if (r104 <= 0) goto L5;
        r105.setRectToRect(new RectF(0.0f, 0.0f, r100, r101), TransformUtils.NORMALIZED_RECT, Matrix.ScaleToFit.FILL);
        r105.postRotate(r104);
        r105.postConcat(TransformUtils.getNormalizedToBuffer(new RectF(0.0f, 0.0f, r102, r103)));
    L5:
        return r105;
    }

    private /* synthetic */ void lambda$analyzeImage$0(ImageProxy r100, Matrix r101, ImageProxy r102, Rect r103, ImageAnalysis.Analyzer r104, CallbackToFutureAdapter.Completer r105) {
        if (this.mIsAttached == false) goto L12;
        TagBundle r106 = r100.getImageInfo().getTagBundle();
        long r107 = r100.getImageInfo().getTimestamp();
        if (this.mOutputImageRotationEnabled == false) goto L7;
        int r108 = 0;
    L8:
        SettableImageProxy r109 = new SettableImageProxy(r102, ImmutableImageInfo.create(r106, r107, r108, r101));
        if (r103.isEmpty() == true) goto L11;
        r109.setCropRect(r103);
    L11:
        r104.analyze(r109);
        r105.set(null);
        return;
    L7:
        r108 = this.mRelativeRotation;
        goto L8
    L12:
        r105.setException(new OperationCanceledException("ImageAnalysis is detached"));
    }

    private /* synthetic */ Object lambda$analyzeImage$1(Executor r110, final ImageProxy r111, final Matrix r112, final ImageProxy r113, final Rect r114, final ImageAnalysis.Analyzer r115, final CallbackToFutureAdapter.Completer r116) throws Exception {
        r110.execute(new n(this, r111, r112, r113, r114, r115, r116));
        return "analyzeImage";
    }
}
