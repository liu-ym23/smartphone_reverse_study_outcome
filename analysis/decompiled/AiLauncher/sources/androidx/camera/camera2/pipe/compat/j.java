package androidx.camera.camera2.pipe.compat;

import androidx.camera.camera2.pipe.CameraGraph;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/j;", "", "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraGraph", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/CameraGraph;)V", "Landroidx/camera/camera2/pipe/compat/j$a;", "listener", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/compat/j$a;)V", "c", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface j {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Landroidx/camera/camera2/pipe/compat/j$a;", "", "Landroidx/camera/camera2/pipe/a;", "mode", "LY8/t;", Const.INTENT_KEY_APIKEY, "(I)V", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface a {
        void a(int mode);
    }

    void a(a listener);

    void b(CameraGraph cameraGraph);

    void c(a listener);
}
