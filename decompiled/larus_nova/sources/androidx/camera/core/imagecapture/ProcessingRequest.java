package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
class ProcessingRequest {
    static final int PROGRESS_NOT_RECEIVED = -1;
    private final TakePictureCallback mCallback;
    final ListenableFuture<Void> mCaptureFuture;
    private final Rect mCropRect;
    private final int mJpegQuality;
    private int mLastCaptureProcessProgressed;
    private final ImageCapture.OutputFileOptions mOutputFileOptions;
    private final int mRequestId;
    private final int mRotationDegrees;
    private final Matrix mSensorToBufferTransform;
    private final List<Integer> mStageIds;
    private final String mTagBundleKey;

    public boolean isAborted() {
        return this.mCallback.isAborted();
    }

    public void onCaptureStarted() {
        this.mCallback.onCaptureStarted();
    }

    public void onImageCaptured() {
        if (this.mLastCaptureProcessProgressed == (-1)) goto L5;
        onCaptureProcessProgressed(100);
    L5:
        this.mCallback.onImageCaptured();
    }

    public boolean isInMemoryCapture() {
        if (getOutputFileOptions() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public ListenableFuture<Void> getCaptureFuture() {
        return this.mCaptureFuture;
    }

    public Rect getCropRect() {
        return this.mCropRect;
    }

    public int getJpegQuality() {
        return this.mJpegQuality;
    }

    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.mOutputFileOptions;
    }

    public int getRequestId() {
        return this.mRequestId;
    }

    public int getRotationDegrees() {
        return this.mRotationDegrees;
    }

    public Matrix getSensorToBufferTransform() {
        return this.mSensorToBufferTransform;
    }

    public List<Integer> getStageIds() {
        return this.mStageIds;
    }

    public String getTagBundleKey() {
        return this.mTagBundleKey;
    }

    public void onCaptureFailure(ImageCaptureException r100) {
        this.mCallback.onCaptureFailure(r100);
    }

    public void onCaptureProcessProgressed(int r100) {
        if (this.mLastCaptureProcessProgressed == r100) goto L6;
        this.mLastCaptureProcessProgressed = r100;
        this.mCallback.onCaptureProcessProgressed(r100);
        return;
    }

    public void onFinalResult(ImageCapture.OutputFileResults r100) {
        this.mCallback.onFinalResult(r100);
    }

    public void onPostviewBitmapAvailable(Bitmap r100) {
        this.mCallback.onPostviewBitmapAvailable(r100);
    }

    public void onProcessFailure(ImageCaptureException r100) {
        this.mCallback.onProcessFailure(r100);
    }

    public void onFinalResult(ImageProxy r100) {
        this.mCallback.onFinalResult(r100);
    }

    public ProcessingRequest(CaptureBundle r110, ImageCapture.OutputFileOptions r111, Rect r112, int r113, int r114, Matrix r115, TakePictureCallback r116, ListenableFuture<Void> r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, 0);
    }

    public ProcessingRequest(CaptureBundle r100, ImageCapture.OutputFileOptions r101, Rect r102, int r103, int r104, Matrix r105, TakePictureCallback r106, ListenableFuture<Void> r107, int r110) {
        this.mLastCaptureProcessProgressed = -1;
        this.mRequestId = r110;
        this.mOutputFileOptions = r101;
        this.mJpegQuality = r104;
        this.mRotationDegrees = r103;
        this.mCropRect = r102;
        this.mSensorToBufferTransform = r105;
        this.mCallback = r106;
        this.mTagBundleKey = String.valueOf(r100.hashCode());
        this.mStageIds = new ArrayList();
        List<CaptureStage> r108 = r100.getCaptureStages();
        Objects.requireNonNull(r108);
        Iterator<CaptureStage> r109 = r108.iterator();
    L4:
        if (r109.hasNext() == false) goto L6;
        CaptureStage r111 = r109.next();
        this.mStageIds.add(Integer.valueOf(r111.getId()));
        goto L4
    L6:
        this.mCaptureFuture = r107;
    }
}
