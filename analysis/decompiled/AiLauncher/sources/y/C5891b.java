package y;

import A.StreamGraph;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.Camera2CameraController;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\fH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001fR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010 R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010!R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\"R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010#R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010$R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006'"}, d2 = {"Ly/b;", "", "Landroidx/camera/camera2/pipe/b;", "cameraBackend", "Landroidx/camera/camera2/pipe/e;", "graphId", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "LA/e;", "graphListener", "Landroidx/camera/camera2/pipe/v;", "streamGraph", "Lw/T;", "surfaceTracker", "Landroidx/camera/camera2/pipe/compat/Camera2CameraController$b;", "shutdownListener", "<init>", "(Landroidx/camera/camera2/pipe/b;Landroidx/camera/camera2/pipe/e;Landroidx/camera/camera2/pipe/CameraGraph$b;LA/e;Landroidx/camera/camera2/pipe/v;Lw/T;Landroidx/camera/camera2/pipe/compat/Camera2CameraController$b;)V", Const.INTENT_KEY_APIKEY, "()Landroidx/camera/camera2/pipe/CameraGraph$b;", Const.INTENT_KEY_PKGNAME, "()Landroidx/camera/camera2/pipe/e;", "LA/q;", "e", "()LA/q;", "c", "()LA/e;", "f", "()Lw/T;", Const.INTENT_KEY_UMID, "()Landroidx/camera/camera2/pipe/compat/Camera2CameraController$b;", "Landroidx/camera/camera2/pipe/b;", "Landroidx/camera/camera2/pipe/e;", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "LA/e;", "Landroidx/camera/camera2/pipe/v;", "Lw/T;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/camera2/pipe/compat/Camera2CameraController$b;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: y.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C5891b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.b cameraBackend;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.e graphId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final CameraGraph.b graphConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final A.e graphListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.v streamGraph;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final w.T surfaceTracker;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Camera2CameraController.b shutdownListener;

    public C5891b(androidx.camera.camera2.pipe.b cameraBackend, androidx.camera.camera2.pipe.e graphId, CameraGraph.b graphConfig, A.e graphListener, androidx.camera.camera2.pipe.v streamGraph, w.T surfaceTracker, Camera2CameraController.b shutdownListener) {
        kotlin.jvm.internal.p.i(cameraBackend, "cameraBackend");
        kotlin.jvm.internal.p.i(graphId, "graphId");
        kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
        kotlin.jvm.internal.p.i(graphListener, "graphListener");
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        kotlin.jvm.internal.p.i(surfaceTracker, "surfaceTracker");
        kotlin.jvm.internal.p.i(shutdownListener, "shutdownListener");
        this.cameraBackend = cameraBackend;
        this.graphId = graphId;
        this.graphConfig = graphConfig;
        this.graphListener = graphListener;
        this.streamGraph = streamGraph;
        this.surfaceTracker = surfaceTracker;
        this.shutdownListener = shutdownListener;
    }

    /* renamed from: a, reason: from getter */
    public final CameraGraph.b getGraphConfig() {
        return this.graphConfig;
    }

    /* renamed from: b, reason: from getter */
    public final androidx.camera.camera2.pipe.e getGraphId() {
        return this.graphId;
    }

    /* renamed from: c, reason: from getter */
    public final A.e getGraphListener() {
        return this.graphListener;
    }

    /* renamed from: d, reason: from getter */
    public final Camera2CameraController.b getShutdownListener() {
        return this.shutdownListener;
    }

    public final StreamGraph e() {
        androidx.camera.camera2.pipe.v vVar = this.streamGraph;
        kotlin.jvm.internal.p.g(vVar, "null cannot be cast to non-null type androidx.camera.camera2.pipe.graph.StreamGraphImpl");
        return (StreamGraph) vVar;
    }

    /* renamed from: f, reason: from getter */
    public final w.T getSurfaceTracker() {
        return this.surfaceTracker;
    }
}
