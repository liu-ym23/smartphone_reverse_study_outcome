package y;

import androidx.camera.camera2.pipe.CameraGraph;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\r¨\u0006\u000e"}, d2 = {"Ly/m;", "", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "config", "Landroidx/camera/camera2/pipe/e;", "cameraGraphId", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraph$b;Landroidx/camera/camera2/pipe/e;)V", Const.INTENT_KEY_APIKEY, "()Landroidx/camera/camera2/pipe/CameraGraph$b;", Const.INTENT_KEY_PKGNAME, "()Landroidx/camera/camera2/pipe/e;", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "Landroidx/camera/camera2/pipe/e;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: y.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5902m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CameraGraph.b config;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.e cameraGraphId;

    public C5902m(CameraGraph.b config, androidx.camera.camera2.pipe.e cameraGraphId) {
        kotlin.jvm.internal.p.i(config, "config");
        kotlin.jvm.internal.p.i(cameraGraphId, "cameraGraphId");
        this.config = config;
        this.cameraGraphId = cameraGraphId;
    }

    /* renamed from: a, reason: from getter */
    public final CameraGraph.b getConfig() {
        return this.config;
    }

    /* renamed from: b, reason: from getter */
    public final androidx.camera.camera2.pipe.e getCameraGraphId() {
        return this.cameraGraphId;
    }
}
