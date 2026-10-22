package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.internal.compat.workaround.CaptureFailedRetryEnabler;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TakePictureRequest {
    private int mRemainingRetires;

    public interface RetryControl {
        void retryRequest(TakePictureRequest r100);
    }

    public static /* synthetic */ void a(TakePictureRequest r100, ImageCaptureException r101) {
        r100.lambda$onError$0(r101);
    }

    public static /* synthetic */ void b(TakePictureRequest r100, int r101) {
        r100.lambda$onCaptureProcessProgressed$3(r101);
    }

    public static /* synthetic */ void c(TakePictureRequest r100, Bitmap r101) {
        r100.lambda$onPostviewBitmapAvailable$4(r101);
    }

    public static /* synthetic */ void d(TakePictureRequest r100, ImageCapture.OutputFileResults r101) {
        r100.lambda$onResult$1(r101);
    }

    public static /* synthetic */ void e(TakePictureRequest r100, ImageProxy r101) {
        r100.lambda$onResult$2(r101);
    }

    public abstract Executor getAppExecutor();

    public abstract int getCaptureMode();

    public abstract Rect getCropRect();

    public abstract ImageCapture.OnImageCapturedCallback getInMemoryCallback();

    public abstract int getJpegQuality();

    public abstract ImageCapture.OnImageSavedCallback getOnDiskCallback();

    public abstract ImageCapture.OutputFileOptions getOutputFileOptions();

    public abstract int getRotationDegrees();

    public abstract Matrix getSensorToBufferTransform();

    public abstract List<CameraCaptureCallback> getSessionConfigCameraCaptureCallbacks();

    public TakePictureRequest() {
        this.mRemainingRetires = new CaptureFailedRetryEnabler().getRetryCount();
    }

    public boolean decrementRetryCounter() {
        Threads.checkMainThread();
        int r100 = this.mRemainingRetires;
        if (r100 <= 0) goto L6;
        this.mRemainingRetires = r100 - 1;
        return true;
    L6:
        return false;
    }

    public int getRemainingRetries() {
        Threads.checkMainThread();
        return this.mRemainingRetires;
    }

    public void incrementRetryCounter() {
        Threads.checkMainThread();
        this.mRemainingRetires++;
    }

    private /* synthetic */ void lambda$onCaptureProcessProgressed$3(int r100) {
        if (getOnDiskCallback() == null) goto L6;
        getOnDiskCallback().onCaptureProcessProgressed(r100);
        return;
    L6:
        if (getInMemoryCallback() == null) goto L10;
        getInMemoryCallback().onCaptureProcessProgressed(r100);
        return;
    }

    private /* synthetic */ void lambda$onError$0(ImageCaptureException r100) {
        boolean r101 = true;
        if (getInMemoryCallback() == null) goto L5;
        boolean r102 = true;
    L7:
        if (getOnDiskCallback() != null) goto L10;
        r101 = false;
    L10:
        if (r102 == false) goto L13;
        if (r101 == true) goto L13;
        ImageCapture.OnImageCapturedCallback r103 = getInMemoryCallback();
        Objects.requireNonNull(r103);
        r103.onError(r100);
        return;
    L13:
        if (r101 == false) goto L18;
        if (r102 == true) goto L18;
        ImageCapture.OnImageSavedCallback r104 = getOnDiskCallback();
        Objects.requireNonNull(r104);
        r104.onError(r100);
        return;
    L18:
        throw new IllegalStateException("One and only one callback is allowed.");
    L5:
        r102 = false;
        goto L7
    }

    private /* synthetic */ void lambda$onPostviewBitmapAvailable$4(Bitmap r100) {
        if (getOnDiskCallback() == null) goto L6;
        getOnDiskCallback().onPostviewBitmapAvailable(r100);
        return;
    L6:
        if (getInMemoryCallback() == null) goto L10;
        getInMemoryCallback().onPostviewBitmapAvailable(r100);
        return;
    }

    private /* synthetic */ void lambda$onResult$1(ImageCapture.OutputFileResults r100) {
        ImageCapture.OnImageSavedCallback r101 = getOnDiskCallback();
        Objects.requireNonNull(r101);
        Objects.requireNonNull(r100);
        r101.onImageSaved(r100);
    }

    private /* synthetic */ void lambda$onResult$2(ImageProxy r100) {
        ImageCapture.OnImageCapturedCallback r101 = getInMemoryCallback();
        Objects.requireNonNull(r101);
        Objects.requireNonNull(r100);
        r101.onCaptureSuccess(r100);
    }

    public void onCaptureProcessProgressed(final int r100) {
        getAppExecutor().execute(new x(this, r100));
    }

    public void onError(final ImageCaptureException r100) {
        getAppExecutor().execute(new a0(this, r100));
    }

    public void onPostviewBitmapAvailable(final Bitmap r100) {
        getAppExecutor().execute(new y(this, r100));
    }

    public void onResult(final ImageCapture.OutputFileResults r100) {
        getAppExecutor().execute(new z(this, r100));
    }

    public void onResult(final ImageProxy r100) {
        getAppExecutor().execute(new b0(this, r100));
    }

    public static TakePictureRequest of(Executor r110, ImageCapture.OnImageCapturedCallback r111, ImageCapture.OnImageSavedCallback r112, ImageCapture.OutputFileOptions r113, Rect r114, Matrix r115, int r116, int r117, int r210, List<CameraCaptureCallback> r211) {
        boolean r100 = true;
        if (r112 != null) goto L5;
        boolean r101 = true;
    L6:
        if (r113 != null) goto L8;
        boolean r102 = true;
    L9:
        if (r101 != r102) goto L11;
        boolean r103 = true;
    L12:
        Preconditions.checkArgument(r103, "onDiskCallback and outputFileOptions should be both null or both non-null.");
        if (r112 != null) goto L15;
        boolean r104 = true;
    L16:
        if (r111 == null) goto L19;
        r100 = false;
    L19:
        Preconditions.checkArgument(r100 ^ r104, "One and only one on-disk or in-memory callback should be present.");
        return new AutoValue_TakePictureRequest(r110, r111, r112, r113, r114, r115, r116, r117, r210, r211);
    L15:
        r104 = false;
        goto L16
    L11:
        r103 = false;
        goto L12
    L8:
        r102 = false;
        goto L9
    L5:
        r101 = false;
        goto L6
    }
}
