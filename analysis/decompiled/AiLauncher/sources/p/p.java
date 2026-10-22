package p;

import Ua.C1087w;
import Ua.Q;
import Z8.C1172u;
import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import androidx.camera.camera2.impl.UseCaseCameraRequestControl;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import t.InterfaceC5494v;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00068\u0016X\u0096D¢\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0010\u0010\u0014¨\u0006\u0017"}, d2 = {"Lp/p;", "Lp/t;", "Lt/v;", "cameraProperties", "<init>", "(Lt/v;)V", "", "zoomRatio", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "LUa/Q;", "LY8/t;", "c", "(FLandroidx/camera/camera2/impl/UseCaseCameraRequestControl;)LUa/Q;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;)LUa/Q;", Const.INTENT_KEY_APIKEY, "Lt/v;", "F", Const.INTENT_KEY_UMID, "()F", "minZoomRatio", "maxZoomRatio", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class p implements t {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    public static final List<CameraCharacteristics.Key<Rect>> f37995e = C1172u.e(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final float minZoomRatio;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final float maxZoomRatio;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R0\u0010\t\u001a\u001b\u0012\u0017\u0012\u0015\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\u0002\b\b0\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lp/p$a;", "", "<init>", "()V", "", "Landroid/hardware/camera2/CameraCharacteristics$Key;", "Landroid/graphics/Rect;", "kotlin.jvm.PlatformType", "Lkotlin/jvm/internal/EnhancedNullability;", "requiredCharacteristics", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: p.p$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final List<CameraCharacteristics.Key<Rect>> a() {
            return p.f37995e;
        }

        public Companion() {
        }
    }

    public p(InterfaceC5494v cameraProperties) {
        kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
        this.cameraProperties = cameraProperties;
        this.minZoomRatio = 1.0f;
        this.maxZoomRatio = 1.0f;
    }

    @Override // p.t
    /* renamed from: a, reason: from getter */
    public float getMaxZoomRatio() {
        return this.maxZoomRatio;
    }

    @Override // p.t
    public Q<Y8.t> b(UseCaseCameraRequestControl requestControl) {
        kotlin.jvm.internal.p.i(requestControl, "requestControl");
        return C1087w.a(Y8.t.f7040a);
    }

    @Override // p.t
    public Q<Y8.t> c(float zoomRatio, UseCaseCameraRequestControl requestControl) {
        kotlin.jvm.internal.p.i(requestControl, "requestControl");
        return C1087w.a(Y8.t.f7040a);
    }

    @Override // p.t
    /* renamed from: d, reason: from getter */
    public float getMinZoomRatio() {
        return this.minZoomRatio;
    }
}
