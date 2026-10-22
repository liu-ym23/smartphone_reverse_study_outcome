package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraCaptureCallback;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
final class AutoValue_TakePictureRequest extends TakePictureRequest {
    private final Executor appExecutor;
    private final int captureMode;
    private final Rect cropRect;
    private final ImageCapture.OnImageCapturedCallback inMemoryCallback;
    private final int jpegQuality;
    private final ImageCapture.OnImageSavedCallback onDiskCallback;
    private final ImageCapture.OutputFileOptions outputFileOptions;
    private final int rotationDegrees;
    private final Matrix sensorToBufferTransform;
    private final List<CameraCaptureCallback> sessionConfigCameraCaptureCallbacks;

    public int hashCode() {
        int r100 = (this.appExecutor.hashCode() ^ 1000003) * 1000003;
        ImageCapture.OnImageCapturedCallback r101 = this.inMemoryCallback;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 ^ r103) * 1000003;
        ImageCapture.OnImageSavedCallback r105 = this.onDiskCallback;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 ^ r106) * 1000003;
        ImageCapture.OutputFileOptions r108 = this.outputFileOptions;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((((((((((((r107 ^ r102) * 1000003) ^ this.cropRect.hashCode()) * 1000003) ^ this.sensorToBufferTransform.hashCode()) * 1000003) ^ this.rotationDegrees) * 1000003) ^ this.jpegQuality) * 1000003) ^ this.captureMode) * 1000003) ^ this.sessionConfigCameraCaptureCallbacks.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "TakePictureRequest{appExecutor=" + this.appExecutor + ", inMemoryCallback=" + this.inMemoryCallback + ", onDiskCallback=" + this.onDiskCallback + ", outputFileOptions=" + this.outputFileOptions + ", cropRect=" + this.cropRect + ", sensorToBufferTransform=" + this.sensorToBufferTransform + ", rotationDegrees=" + this.rotationDegrees + ", jpegQuality=" + this.jpegQuality + ", captureMode=" + this.captureMode + ", sessionConfigCameraCaptureCallbacks=" + this.sessionConfigCameraCaptureCallbacks + com.alipay.sdk.m.u.i.f25855d;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public Executor getAppExecutor() {
        return this.appExecutor;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public int getCaptureMode() {
        return this.captureMode;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public Rect getCropRect() {
        return this.cropRect;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OnImageCapturedCallback getInMemoryCallback() {
        return this.inMemoryCallback;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public int getJpegQuality() {
        return this.jpegQuality;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OnImageSavedCallback getOnDiskCallback() {
        return this.onDiskCallback;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public ImageCapture.OutputFileOptions getOutputFileOptions() {
        return this.outputFileOptions;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public int getRotationDegrees() {
        return this.rotationDegrees;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public Matrix getSensorToBufferTransform() {
        return this.sensorToBufferTransform;
    }

    @Override // androidx.camera.core.imagecapture.TakePictureRequest
    public List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks() {
        return this.sessionConfigCameraCaptureCallbacks;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof TakePictureRequest) == false) goto L45;
        TakePictureRequest r101 = (TakePictureRequest) r100;
        if (this.appExecutor.equals(r101.getAppExecutor()) == false) goto L43;
        ImageCapture.OnImageCapturedCallback r102 = this.inMemoryCallback;
        if (r102 != null) goto L15;
        if (r101.getInMemoryCallback() != null) goto L43;
    L16:
        ImageCapture.OnImageSavedCallback r103 = this.onDiskCallback;
        if (r103 != null) goto L22;
        if (r101.getOnDiskCallback() != null) goto L43;
    L23:
        ImageCapture.OutputFileOptions r104 = this.outputFileOptions;
        if (r104 != null) goto L29;
        if (r101.getOutputFileOptions() != null) goto L43;
    L31:
        if (this.cropRect.equals(r101.getCropRect()) == false) goto L43;
        if (this.sensorToBufferTransform.equals(r101.getSensorToBufferTransform()) == false) goto L43;
        if (this.rotationDegrees != r101.getRotationDegrees()) goto L43;
        if (this.jpegQuality != r101.getJpegQuality()) goto L43;
        if (this.captureMode != r101.getCaptureMode()) goto L43;
        if (this.sessionConfigCameraCaptureCallbacks.equals(r101.getSessionConfigCameraCaptureCallbacks()) == false) goto L43;
        return true;
    L29:
        if (r104.equals(r101.getOutputFileOptions()) == false) goto L43;
    L22:
        if (r103.equals(r101.getOnDiskCallback()) == false) goto L43;
    L15:
        if (r102.equals(r101.getInMemoryCallback()) == true) goto L16;
    L43:
        return false;
    L45:
        return false;
    }

    public AutoValue_TakePictureRequest(Executor r100, ImageCapture.OnImageCapturedCallback r101, ImageCapture.OnImageSavedCallback r102, ImageCapture.OutputFileOptions r103, Rect r104, Matrix r105, int r106, int r107, int r108, List<CameraCaptureCallback> r110) {
        if (r100 == null) goto L19;
        this.appExecutor = r100;
        this.inMemoryCallback = r101;
        this.onDiskCallback = r102;
        this.outputFileOptions = r103;
        if (r104 == null) goto L17;
        this.cropRect = r104;
        if (r105 == null) goto L15;
        this.sensorToBufferTransform = r105;
        this.rotationDegrees = r106;
        this.jpegQuality = r107;
        this.captureMode = r108;
        if (r110 == null) goto L13;
        this.sessionConfigCameraCaptureCallbacks = r110;
        return;
    L13:
        throw new NullPointerException("Null sessionConfigCameraCaptureCallbacks");
    L15:
        throw new NullPointerException("Null sensorToBufferTransform");
    L17:
        throw new NullPointerException("Null cropRect");
    L19:
        throw new NullPointerException("Null appExecutor");
    }
}
