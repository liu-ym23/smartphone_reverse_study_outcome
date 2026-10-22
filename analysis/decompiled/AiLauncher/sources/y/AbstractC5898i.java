package y;

import Ua.CoroutineName;
import Ua.L0;
import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.Camera2CameraStatusMonitor;
import androidx.camera.camera2.pipe.core.Threads;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b!\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Ly/i;", "", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: y.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5898i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ7\u0010\u0011\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Ly/i$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Lkotlinx/coroutines/g;", "cameraPipeJob", "LUa/M;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/core/Threads;Lkotlinx/coroutines/g;)LUa/M;", "LX8/a;", "Landroid/hardware/camera2/CameraManager;", "cameraManager", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "LB/f;", Const.INTENT_KEY_APIKEY, "(LX8/a;Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/CameraGraph$b;Lkotlinx/coroutines/g;)LB/f;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: y.i$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final B.f a(X8.a<CameraManager> cameraManager, Threads threads, CameraGraph.b graphConfig, kotlinx.coroutines.g cameraPipeJob) {
            kotlin.jvm.internal.p.i(cameraManager, "cameraManager");
            kotlin.jvm.internal.p.i(threads, "threads");
            kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
            kotlin.jvm.internal.p.i(cameraPipeJob, "cameraPipeJob");
            return new Camera2CameraStatusMonitor(cameraManager, threads, graphConfig.getCamera(), cameraPipeJob, null);
        }

        public final Ua.M b(Threads threads, kotlinx.coroutines.g cameraPipeJob) {
            kotlin.jvm.internal.p.i(threads, "threads");
            kotlin.jvm.internal.p.i(cameraPipeJob, "cameraPipeJob");
            return kotlinx.coroutines.d.a(L0.a(cameraPipeJob).plus(threads.getLightweightDispatcher().plus(new CoroutineName("CXCP-Camera2Controller"))));
        }

        public Companion() {
        }
    }
}
