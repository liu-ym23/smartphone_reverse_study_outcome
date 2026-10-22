package y;

import androidx.camera.camera2.pipe.h;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000f¨\u0006\u0010"}, d2 = {"Ly/q;", "", "Landroidx/camera/camera2/pipe/h$e;", "config", "<init>", "(Landroidx/camera/camera2/pipe/h$e;)V", Const.INTENT_KEY_PKGNAME, "()Landroidx/camera/camera2/pipe/h$e;", "Landroidx/camera/camera2/pipe/h$f;", "c", "()Landroidx/camera/camera2/pipe/h$f;", "cameraPipeConfig", "Landroidx/camera/camera2/pipe/h$b;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/h$e;)Landroidx/camera/camera2/pipe/h$b;", "Landroidx/camera/camera2/pipe/h$e;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: y.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5906q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final h.Config config;

    public C5906q(h.Config config) {
        kotlin.jvm.internal.p.i(config, "config");
        this.config = config;
    }

    public final h.CameraInteropConfig a(h.Config cameraPipeConfig) {
        kotlin.jvm.internal.p.i(cameraPipeConfig, "cameraPipeConfig");
        return cameraPipeConfig.getCameraInteropConfig();
    }

    /* renamed from: b, reason: from getter */
    public final h.Config getConfig() {
        return this.config;
    }

    public final h.Flags c() {
        return this.config.getFlags();
    }
}
