package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
final class CropRegionZoomImpl implements ZoomControl.ZoomImpl {
    public static final float MIN_DIGITAL_ZOOM = 1.0f;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private Rect mCurrentCropRect;
    private Rect mPendingZoomCropRegion;
    private CallbackToFutureAdapter.Completer<Void> mPendingZoomRatioCompleter;

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMinZoom() {
        return 1.0f;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void resetZoom() {
        this.mPendingZoomCropRegion = null;
        this.mCurrentCropRect = null;
        CallbackToFutureAdapter.Completer<Void> r100 = this.mPendingZoomRatioCompleter;
        if (r100 == null) goto L6;
        r100.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        this.mPendingZoomRatioCompleter = null;
        return;
    }

    private Rect getSensorRect() {
        return (Rect) Preconditions.checkNotNull((Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public Rect getCropSensorRegion() {
        Rect r100 = this.mCurrentCropRect;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return getSensorRect();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMaxZoom() {
        Float r100 = (Float) this.mCameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (r100 != null) goto L7;
        return 1.0f;
    L7:
        if (r100.floatValue() >= getMinZoom()) goto L11;
        return getMinZoom();
    L11:
        return r100.floatValue();
    }

    public CropRegionZoomImpl(CameraCharacteristicsCompat r100) {
        this.mCurrentCropRect = null;
        this.mPendingZoomCropRegion = null;
        this.mCameraCharacteristics = r100;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void addRequestOption(Camera2ImplConfig.Builder r100) {
        Rect r101 = this.mCurrentCropRect;
        if (r101 == null) goto L6;
        r100.setCaptureRequestOptionWithPriority(CaptureRequest.SCALER_CROP_REGION, r101, Config.OptionPriority.REQUIRED);
        return;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void onCaptureResult(TotalCaptureResult r100) {
        if (this.mPendingZoomRatioCompleter == null) goto L14;
        CaptureRequest r101 = r100.getRequest();
        if (r101 != null) goto L7;
        Rect r102 = null;
    L8:
        Rect r103 = this.mPendingZoomCropRegion;
        if (r103 != null) goto L11;
        return;
    L11:
        if (r103.equals(r102) == false) goto L16;
        this.mPendingZoomRatioCompleter.set(null);
        this.mPendingZoomRatioCompleter = null;
        this.mPendingZoomCropRegion = null;
        return;
    L16:
        return;
    L7:
        r102 = (Rect) r101.get(CaptureRequest.SCALER_CROP_REGION);
        goto L8
    }

    private static Rect getCropRectByRatio(Rect r100, float r101) {
        float r102 = r100.width() / r101;
        float r103 = r100.height() / r101;
        float r104 = (r100.width() - r102) / 2.0f;
        float r105 = (r100.height() - r103) / 2.0f;
        return new Rect((int) r104, (int) r105, (int) (r104 + r102), (int) (r105 + r103));
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void setZoomRatio(float r100, CallbackToFutureAdapter.Completer<Void> r101) {
        this.mCurrentCropRect = getCropRectByRatio(getSensorRect(), r100);
        CallbackToFutureAdapter.Completer<Void> r102 = this.mPendingZoomRatioCompleter;
        if (r102 == null) goto L5;
        r102.setException(new CameraControl.OperationCanceledException("There is a new zoomRatio being set"));
    L5:
        this.mPendingZoomCropRegion = this.mCurrentCropRect;
        this.mPendingZoomRatioCompleter = r101;
    }
}
