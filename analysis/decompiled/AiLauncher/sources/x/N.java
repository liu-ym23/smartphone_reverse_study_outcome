package x;

import android.view.Surface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001JG\u0010\u000b\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lx/N;", "", "Landroidx/camera/camera2/pipe/compat/o;", "session", "", "Lw/Q;", "Landroid/view/Surface;", "streamToSurfaceMap", "Lw/G;", "outputToSurfaceMap", "Landroidx/camera/camera2/pipe/m;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/compat/o;Ljava/util/Map;Ljava/util/Map;)Landroidx/camera/camera2/pipe/m;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public interface N {
    androidx.camera.camera2.pipe.m<?, ?> a(androidx.camera.camera2.pipe.compat.o session, Map<w.Q, ? extends Surface> streamToSurfaceMap, Map<w.G, ? extends Surface> outputToSurfaceMap);
}
