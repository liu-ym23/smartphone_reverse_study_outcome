package y;

import A.GraphProcessor;
import androidx.camera.camera2.pipe.CameraGraph;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import w.C5699e;
import w.C5708n;
import w.InterfaceC5698d;
import w.InterfaceC5700f;
import w.InterfaceC5702h;
import w.InterfaceC5703i;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b!\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Ly/J;", "", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: y.J, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5883J {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000f\u0010\u0010JG\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Ly/J$a;", "", "<init>", "()V", "Lw/f;", "cameraBackends", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "Lw/h;", "cameraContext", "Landroidx/camera/camera2/pipe/b;", Const.INTENT_KEY_APIKEY, "(Lw/f;Landroidx/camera/camera2/pipe/CameraGraph$b;Lw/h;)Landroidx/camera/camera2/pipe/b;", "cameraBackend", "Landroidx/camera/camera2/pipe/g;", "c", "(Landroidx/camera/camera2/pipe/CameraGraph$b;Landroidx/camera/camera2/pipe/b;)Landroidx/camera/camera2/pipe/g;", "Landroidx/camera/camera2/pipe/e;", "graphId", "LA/g;", "graphProcessor", "Landroidx/camera/camera2/pipe/v;", "streamGraph", "Lw/T;", "surfaceTracker", "Lw/i;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/e;Landroidx/camera/camera2/pipe/CameraGraph$b;Landroidx/camera/camera2/pipe/b;Lw/h;LA/g;Landroidx/camera/camera2/pipe/v;Lw/T;)Lw/i;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: y.J$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final androidx.camera.camera2.pipe.b a(InterfaceC5700f cameraBackends, CameraGraph.b graphConfig, InterfaceC5702h cameraContext) {
            kotlin.jvm.internal.p.i(cameraBackends, "cameraBackends");
            kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
            kotlin.jvm.internal.p.i(cameraContext, "cameraContext");
            InterfaceC5698d customCameraBackend = graphConfig.getCustomCameraBackend();
            if (customCameraBackend != null) {
                return customCameraBackend.a(cameraContext);
            }
            String cameraBackendId = graphConfig.getCameraBackendId();
            if (cameraBackendId == null) {
                return cameraBackends.getDefault();
            }
            androidx.camera.camera2.pipe.b bVarA = cameraBackends.a(cameraBackendId);
            if (bVarA != null) {
                return bVarA;
            }
            throw new IllegalStateException(("Failed to initialize " + ((Object) C5699e.f(cameraBackendId)) + " from " + graphConfig).toString());
        }

        public final InterfaceC5703i b(androidx.camera.camera2.pipe.e graphId, CameraGraph.b graphConfig, androidx.camera.camera2.pipe.b cameraBackend, InterfaceC5702h cameraContext, GraphProcessor graphProcessor, androidx.camera.camera2.pipe.v streamGraph, w.T surfaceTracker) {
            kotlin.jvm.internal.p.i(graphId, "graphId");
            kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
            kotlin.jvm.internal.p.i(cameraBackend, "cameraBackend");
            kotlin.jvm.internal.p.i(cameraContext, "cameraContext");
            kotlin.jvm.internal.p.i(graphProcessor, "graphProcessor");
            kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
            kotlin.jvm.internal.p.i(surfaceTracker, "surfaceTracker");
            return cameraBackend.d(cameraContext, graphId, graphConfig, graphProcessor, streamGraph, surfaceTracker);
        }

        public final androidx.camera.camera2.pipe.g c(CameraGraph.b graphConfig, androidx.camera.camera2.pipe.b cameraBackend) {
            kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
            kotlin.jvm.internal.p.i(cameraBackend, "cameraBackend");
            androidx.camera.camera2.pipe.g gVarA = cameraBackend.a(graphConfig.getCamera());
            if (gVarA != null) {
                return gVarA;
            }
            throw new IllegalStateException(("Failed to load metadata for " + ((Object) C5708n.f(graphConfig.getCamera())) + '!').toString());
        }

        public Companion() {
        }
    }
}
