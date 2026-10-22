package x;

import A.StreamGraph;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.Camera2CaptureSequenceProcessor;
import androidx.camera.camera2.pipe.core.Threads;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJO\u0010\u0019\u001a\u0012\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00162\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lx/J0;", "Lx/N;", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "LA/q;", "streamGraph", "Lx/d0;", "quirks", "Lw/S;", "strictMode", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/CameraGraph$b;LA/q;Lx/d0;Lw/S;)V", "Landroidx/camera/camera2/pipe/compat/o;", "session", "", "Lw/Q;", "Landroid/view/Surface;", "streamToSurfaceMap", "Lw/G;", "outputToSurfaceMap", "Landroidx/camera/camera2/pipe/m;", "Landroidx/camera/camera2/pipe/l;", "", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/compat/o;Ljava/util/Map;Ljava/util/Map;)Landroidx/camera/camera2/pipe/m;", "Landroidx/camera/camera2/pipe/core/Threads;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/CameraGraph$b;", "c", "LA/q;", Const.INTENT_KEY_UMID, "Lx/d0;", "e", "Lw/S;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class J0 implements N {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CameraGraph.b graphConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final StreamGraph streamGraph;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C5810d0 quirks;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final w.S strictMode;

    public J0(Threads threads, CameraGraph.b graphConfig, StreamGraph streamGraph, C5810d0 quirks, w.S strictMode) {
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        kotlin.jvm.internal.p.i(quirks, "quirks");
        kotlin.jvm.internal.p.i(strictMode, "strictMode");
        this.threads = threads;
        this.graphConfig = graphConfig;
        this.streamGraph = streamGraph;
        this.quirks = quirks;
        this.strictMode = strictMode;
    }

    @Override // x.N
    public androidx.camera.camera2.pipe.m<?, androidx.camera.camera2.pipe.l<Object>> a(androidx.camera.camera2.pipe.compat.o session, Map<w.Q, ? extends Surface> streamToSurfaceMap, Map<w.G, ? extends Surface> outputToSurfaceMap) {
        kotlin.jvm.internal.p.i(session, "session");
        kotlin.jvm.internal.p.i(streamToSurfaceMap, "streamToSurfaceMap");
        kotlin.jvm.internal.p.i(outputToSurfaceMap, "outputToSurfaceMap");
        return new Camera2CaptureSequenceProcessor(session, this.threads, this.graphConfig.getDefaultTemplate(), streamToSurfaceMap, outputToSurfaceMap, this.streamGraph, this.strictMode, this.quirks.f(this.graphConfig), null);
    }
}
