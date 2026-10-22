package o;

import D.InterfaceC0778o;
import android.annotation.SuppressLint;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraMetadata;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import t.InterfaceC5494v;
import v.C5645b;
import w9.InterfaceC5745d;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\fJ)\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0011*\u00020\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0017¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R!\u0010\u001f\u001a\u00020\u00188@X\u0081\u0084\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lo/G;", "LD/o;", "Lw/U;", "Lt/v;", "cameraProperties", "<init>", "(Lt/v;)V", "", "lensFacingInt", "F", "(I)I", "e", "()I", "relativeRotation", "z", "k", "", ExifInterface.GPS_DIRECTION_TRUE, "Lw9/d;", "type", "R0", "(Lw9/d;)Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "Lt/v;", "Lv/b;", Const.INTENT_KEY_PKGNAME, "LY8/h;", ExifInterface.LONGITUDE_EAST, "()Lv/b;", "getCamera2CameraInfo$camera_camera2$annotations", "()V", "camera2CameraInfo", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SuppressLint({"UnsafeOptInUsageError"})
/* renamed from: o.G, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4967G implements InterfaceC0778o, w.U {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Y8.h camera2CameraInfo;

    public C4967G(InterfaceC5494v cameraProperties) {
        kotlin.jvm.internal.p.i(cameraProperties, "cameraProperties");
        this.cameraProperties = cameraProperties;
        this.camera2CameraInfo = C4848b.b(new InterfaceC5063a() { // from class: o.F
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C4967G.D(this.f37309a);
            }
        });
    }

    public static final C5645b D(C4967G c4967g) {
        return C5645b.INSTANCE.a(c4967g.cameraProperties);
    }

    private final int F(int lensFacingInt) {
        if (lensFacingInt == 0) {
            return 0;
        }
        if (lensFacingInt == 1) {
            return 1;
        }
        if (lensFacingInt == 2) {
            return 2;
        }
        throw new IllegalArgumentException("The specified lens facing integer " + lensFacingInt + " can not be recognized.");
    }

    public final C5645b E() {
        return (C5645b) this.camera2CameraInfo.getValue();
    }

    @Override // w.U
    public <T> T R0(InterfaceC5745d<T> type) {
        kotlin.jvm.internal.p.i(type, "type");
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(C5645b.class))) {
            T t10 = (T) E();
            kotlin.jvm.internal.p.g(t10, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.PhysicalCameraInfoAdapter.unwrapAs");
            return t10;
        }
        if (kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(InterfaceC5494v.class))) {
            T t11 = (T) this.cameraProperties;
            kotlin.jvm.internal.p.g(t11, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.PhysicalCameraInfoAdapter.unwrapAs");
            return t11;
        }
        if (!kotlin.jvm.internal.p.d(type, kotlin.jvm.internal.t.b(CameraMetadata.class))) {
            return (T) this.cameraProperties.getMetadata().R0(type);
        }
        T t12 = (T) this.cameraProperties.getMetadata();
        kotlin.jvm.internal.p.g(t12, "null cannot be cast to non-null type T of androidx.camera.camera2.adapter.PhysicalCameraInfoAdapter.unwrapAs");
        return t12;
    }

    @Override // D.InterfaceC0778o
    public int e() {
        return z(0);
    }

    @Override // D.InterfaceC0778o
    public int k() {
        androidx.camera.camera2.pipe.g metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key LENS_FACING = CameraCharacteristics.LENS_FACING;
        kotlin.jvm.internal.p.h(LENS_FACING, "LENS_FACING");
        Object objE0 = metadata.e0(LENS_FACING);
        kotlin.jvm.internal.p.f(objE0);
        return F(((Number) objE0).intValue());
    }

    @Override // D.InterfaceC0778o
    public int z(int relativeRotation) {
        androidx.camera.camera2.pipe.g metadata = this.cameraProperties.getMetadata();
        CameraCharacteristics.Key SENSOR_ORIENTATION = CameraCharacteristics.SENSOR_ORIENTATION;
        kotlin.jvm.internal.p.h(SENSOR_ORIENTATION, "SENSOR_ORIENTATION");
        Object objE0 = metadata.e0(SENSOR_ORIENTATION);
        kotlin.jvm.internal.p.f(objE0);
        return M.c.a(M.c.b(relativeRotation), ((Number) objE0).intValue(), 1 == k());
    }
}
