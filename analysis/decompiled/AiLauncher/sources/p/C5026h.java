package p;

import D.C0761b0;
import Ua.Q;
import Z8.C1172u;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.util.Log;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import t.C5473b;
import t.InterfaceC5494v;
import u.C5565m;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0019¨\u0006\u001c"}, d2 = {"Lp/h;", "Lp/t;", "Lt/v;", "cameraProperties", "<init>", "(Lt/v;)V", "", "zoomRatio", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "LUa/Q;", "LY8/t;", "c", "(FLandroidx/camera/camera2/impl/UseCaseCameraRequestControl;)LUa/Q;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)LUa/Q;", "Landroid/graphics/Rect;", "sensorRect", "e", "(Landroid/graphics/Rect;F)Landroid/graphics/Rect;", Const.INTENT_KEY_APIKEY, "Lt/v;", "Landroid/graphics/Rect;", "currentCropRect", Const.INTENT_KEY_UMID, "()F", "minZoomRatio", "maxZoomRatio", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: p.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5026h implements t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Rect currentCropRect;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Rect sensorRect;

    public C5026h(InterfaceC5494v cameraProperties) {
        kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
        this.cameraProperties = cameraProperties;
        androidx.camera.camera2.pipe.g metadata = cameraProperties.getMetadata();
        CameraCharacteristics.Key SENSOR_INFO_ACTIVE_ARRAY_SIZE = CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE;
        kotlin.jvm.internal.p.h(SENSOR_INFO_ACTIVE_ARRAY_SIZE, "SENSOR_INFO_ACTIVE_ARRAY_SIZE");
        Object objE0 = metadata.e0(SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        kotlin.jvm.internal.p.f(objE0);
        this.sensorRect = (Rect) objE0;
    }

    @Override // p.t
    /* renamed from: a */
    public float getMaxZoomRatio() {
        androidx.camera.camera2.pipe.g metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key SCALER_AVAILABLE_MAX_DIGITAL_ZOOM = CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM;
        kotlin.jvm.internal.p.h(SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, "SCALER_AVAILABLE_MAX_DIGITAL_ZOOM");
        Float f10 = (Float) metadata.h1(SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, Float.valueOf(getMinZoomRatio()));
        C5565m c5565m = C5565m.f42386a;
        kotlin.jvm.internal.p.f(f10);
        if (!c5565m.a(f10.floatValue())) {
            return f10.floatValue();
        }
        C5473b c5473b = C5473b.f41865a;
        if (!C0761b0.k("CXCP")) {
            return 1.0f;
        }
        Log.w(C5473b.TRUNCATED_TAG, "Invalid max zoom ratio of " + f10 + " detected, defaulting to 1.0f");
        return 1.0f;
    }

    @Override // p.t
    public Q<Y8.t> b(UseCaseCameraRequestControl requestControl) {
        kotlin.jvm.internal.p.i(requestControl, "requestControl");
        return UseCaseCameraRequestControl.c(requestControl, C1172u.e(CaptureRequest.SCALER_CROP_REGION), null, 2, null);
    }

    @Override // p.t
    public Q<Y8.t> c(float zoomRatio, UseCaseCameraRequestControl requestControl) {
        kotlin.jvm.internal.p.i(requestControl, "requestControl");
        Rect rectE = e(this.sensorRect, zoomRatio);
        this.currentCropRect = rectE;
        CaptureRequest.Key key = CaptureRequest.SCALER_CROP_REGION;
        kotlin.jvm.internal.p.g(rectE, "null cannot be cast to non-null type kotlin.Any");
        return UseCaseCameraRequestControl.d(requestControl, Z8.Q.f(Y8.j.a(key, rectE)), null, null, 6, null);
    }

    @Override // p.t
    /* renamed from: d */
    public float getMinZoomRatio() {
        return 1.0f;
    }

    public final Rect e(Rect sensorRect, float zoomRatio) {
        if (C5565m.f42386a.a(zoomRatio)) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.k("CXCP")) {
                Log.w(C5473b.TRUNCATED_TAG, "ZoomCompat: Invalid zoom ratio of 0.0f passed in, defaulting to 1.0f");
            }
            zoomRatio = 1.0f;
        }
        float fWidth = sensorRect.width() / zoomRatio;
        float fHeight = sensorRect.height() / zoomRatio;
        float fWidth2 = (sensorRect.width() - fWidth) / 2.0f;
        float fHeight2 = (sensorRect.height() - fHeight) / 2.0f;
        return new Rect((int) fWidth2, (int) fHeight2, (int) (fWidth2 + fWidth), (int) (fHeight2 + fHeight));
    }
}
