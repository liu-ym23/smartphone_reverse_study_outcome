package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Range;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.params.CaptureRequestParameterCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.Config;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
final class AndroidRZoomImpl implements ZoomControl.ZoomImpl {
    public static final float DEFAULT_ZOOM_RATIO = 1.0f;
    private final CameraCharacteristicsCompat mCameraCharacteristics;
    private float mCurrentZoomRatio;
    private float mPendingZoomRatio;
    private CallbackToFutureAdapter.Completer<Void> mPendingZoomRatioCompleter;
    private boolean mShouldOverrideZoom;
    private final Range<Float> mZoomRatioRange;

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public Rect getCropSensorRegion() {
        return (Rect) Preconditions.checkNotNull((Rect) this.mCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMaxZoom() {
        return ((Float) this.mZoomRatioRange.getUpper()).floatValue();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public float getMinZoom() {
        return ((Float) this.mZoomRatioRange.getLower()).floatValue();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void resetZoom() {
        this.mCurrentZoomRatio = 1.0f;
        CallbackToFutureAdapter.Completer<Void> r100 = this.mPendingZoomRatioCompleter;
        if (r100 == null) goto L6;
        r100.setException(new CameraControl.OperationCanceledException("Camera is not active."));
        this.mPendingZoomRatioCompleter = null;
        return;
    }

    public AndroidRZoomImpl(CameraCharacteristicsCompat r100) {
        this.mCurrentZoomRatio = 1.0f;
        this.mPendingZoomRatio = 1.0f;
        this.mShouldOverrideZoom = false;
        this.mCameraCharacteristics = r100;
        this.mZoomRatioRange = (Range) r100.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
        this.mShouldOverrideZoom = r100.isZoomOverrideAvailable();
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void addRequestOption(Camera2ImplConfig.Builder r100) {
        CaptureRequest.Key r101 = CaptureRequest.CONTROL_ZOOM_RATIO;
        Float r102 = Float.valueOf(this.mCurrentZoomRatio);
        Config.OptionPriority r103 = Config.OptionPriority.REQUIRED;
        r100.setCaptureRequestOptionWithPriority(r101, r102, r103);
        if (this.mShouldOverrideZoom == false) goto L6;
        CaptureRequestParameterCompat.setSettingsOverrideZoom(r100, r103);
        return;
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void onCaptureResult(TotalCaptureResult r100) {
        if (this.mPendingZoomRatioCompleter == null) goto L14;
        CaptureRequest r101 = r100.getRequest();
        if (r101 != null) goto L7;
        Float r102 = null;
    L8:
        if (r102 != null) goto L11;
        return;
    L11:
        if (this.mPendingZoomRatio != r102.floatValue()) goto L15;
        this.mPendingZoomRatioCompleter.set(null);
        this.mPendingZoomRatioCompleter = null;
        return;
    L15:
        return;
    L7:
        r102 = (Float) r101.get(CaptureRequest.CONTROL_ZOOM_RATIO);
        goto L8
    }

    @Override // androidx.camera.camera2.internal.ZoomControl.ZoomImpl
    public void setZoomRatio(float r100, CallbackToFutureAdapter.Completer<Void> r101) {
        this.mCurrentZoomRatio = r100;
        CallbackToFutureAdapter.Completer<Void> r102 = this.mPendingZoomRatioCompleter;
        if (r102 == null) goto L5;
        r102.setException(new CameraControl.OperationCanceledException("There is a new zoomRatio being set"));
    L5:
        this.mPendingZoomRatio = this.mCurrentZoomRatio;
        this.mPendingZoomRatioCompleter = r101;
    }
}
