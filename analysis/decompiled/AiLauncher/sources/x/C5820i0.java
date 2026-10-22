package x;

import androidx.camera.camera2.pipe.q;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\bR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\n\u0010\b¨\u0006\u0010"}, d2 = {"Lx/i0;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/q$a;", "", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/q$a;", "()Landroidx/camera/camera2/pipe/q$a;", "camera2ExtensionMode", "c", Const.INTENT_KEY_APIKEY, "camera2CaptureRequestTag", "", Const.INTENT_KEY_UMID, "ignore3ARequiredParameters", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: x.i0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5820i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final C5820i0 f43411a = new C5820i0();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final q.a<Integer> camera2ExtensionMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final q.a<Object> camera2CaptureRequestTag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final q.a<Boolean> ignore3ARequiredParameters;

    static {
        q.a.Companion companion = q.a.INSTANCE;
        camera2ExtensionMode = companion.a("androidx.camera.camera2.pipe.extensionMode", kotlin.jvm.internal.t.b(Integer.class));
        camera2CaptureRequestTag = companion.a("androidx.camera.camera2.pipe.captureRequestTag", kotlin.jvm.internal.t.b(Object.class));
        ignore3ARequiredParameters = companion.a("androidx.camera.camera2.pipe.ignore3ARequiredParameters", kotlin.jvm.internal.t.b(Boolean.class));
    }

    public final q.a<Object> a() {
        return camera2CaptureRequestTag;
    }

    public final q.a<Integer> b() {
        return camera2ExtensionMode;
    }

    public final q.a<Boolean> c() {
        return ignore3ARequiredParameters;
    }
}
