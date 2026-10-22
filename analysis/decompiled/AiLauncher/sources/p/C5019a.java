package p;

import Ua.Q;
import Z8.C1173v;
import android.hardware.camera2.CaptureRequest;
import android.util.Range;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import t.InterfaceC5494v;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0016¨\u0006\u0019"}, d2 = {"Lp/a;", "Lp/t;", "Lt/v;", "cameraProperties", "Landroid/util/Range;", "", "range", "<init>", "(Lt/v;Landroid/util/Range;)V", "zoomRatio", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "LUa/Q;", "LY8/t;", "c", "(FLandroidx/camera/camera2/impl/UseCaseCameraRequestControl;)LUa/Q;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)LUa/Q;", Const.INTENT_KEY_APIKEY, "Lt/v;", "Landroid/util/Range;", Const.INTENT_KEY_UMID, "()F", "minZoomRatio", "maxZoomRatio", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: p.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5019a implements t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Range<Float> range;

    public C5019a(InterfaceC5494v cameraProperties, Range<Float> range) {
        kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
        kotlin.jvm.internal.p.i(range, "range");
        this.cameraProperties = cameraProperties;
        this.range = range;
    }

    @Override // p.t
    /* renamed from: a */
    public float getMaxZoomRatio() {
        Object upper = this.range.getUpper();
        kotlin.jvm.internal.p.h(upper, "getUpper(...)");
        return ((Number) upper).floatValue();
    }

    @Override // p.t
    public Q<Y8.t> b(UseCaseCameraRequestControl requestControl) {
        kotlin.jvm.internal.p.i(requestControl, "requestControl");
        CaptureRequest.Key CONTROL_ZOOM_RATIO = CaptureRequest.CONTROL_ZOOM_RATIO;
        kotlin.jvm.internal.p.h(CONTROL_ZOOM_RATIO, "CONTROL_ZOOM_RATIO");
        List listS = C1173v.s(CONTROL_ZOOM_RATIO);
        CaptureRequest.Key CONTROL_SETTINGS_OVERRIDE = CaptureRequest.CONTROL_SETTINGS_OVERRIDE;
        kotlin.jvm.internal.p.h(CONTROL_SETTINGS_OVERRIDE, "CONTROL_SETTINGS_OVERRIDE");
        listS.add(CONTROL_SETTINGS_OVERRIDE);
        return UseCaseCameraRequestControl.c(requestControl, listS, null, 2, null);
    }

    @Override // p.t
    public Q<Y8.t> c(float zoomRatio, UseCaseCameraRequestControl requestControl) {
        kotlin.jvm.internal.p.i(requestControl, "requestControl");
        float fD = getMinZoomRatio();
        if (zoomRatio > getMaxZoomRatio() || fD > zoomRatio) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        Map mapP = kotlin.collections.a.p(Y8.j.a(CaptureRequest.CONTROL_ZOOM_RATIO, Float.valueOf(zoomRatio)));
        if (androidx.camera.camera2.pipe.g.INSTANCE.j(this.cameraProperties.getMetadata())) {
            C5021c.b(mapP);
        }
        return UseCaseCameraRequestControl.d(requestControl, mapP, null, null, 6, null);
    }

    @Override // p.t
    /* renamed from: d */
    public float getMinZoomRatio() {
        Object lower = this.range.getLower();
        kotlin.jvm.internal.p.h(lower, "getLower(...)");
        return ((Number) lower).floatValue();
    }
}
