package androidx.camera.camera2.pipe.compat;

import A.StreamGraph;
import Z8.F;
import android.hardware.camera2.params.InputConfiguration;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.r;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.p;
import androidx.camera.camera2.pipe.s;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import w.Q;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ3\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/camera/camera2/pipe/compat/f;", "Landroidx/camera/camera2/pipe/compat/r;", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "LA/q;", "streamGraph", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;LA/q;Landroidx/camera/camera2/pipe/CameraGraph$b;)V", "Landroidx/camera/camera2/pipe/compat/p;", "cameraDevice", "", "Lw/Q;", "Landroid/view/Surface;", "surfaces", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "captureSessionState", "Landroidx/camera/camera2/pipe/compat/r$a;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/compat/p;Ljava/util/Map;Landroidx/camera/camera2/pipe/compat/CaptureSessionState;)Landroidx/camera/camera2/pipe/compat/r$a;", "Landroidx/camera/camera2/pipe/core/Threads;", Const.INTENT_KEY_PKGNAME, "LA/q;", "c", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class f implements r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final StreamGraph streamGraph;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final CameraGraph.b graphConfig;

    public f(Threads threads, StreamGraph streamGraph, CameraGraph.b graphConfig) {
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
        this.threads = threads;
        this.streamGraph = streamGraph;
        this.graphConfig = graphConfig;
    }

    @Override // androidx.camera.camera2.pipe.compat.r
    public r.a a(p cameraDevice, Map<Q, ? extends Surface> surfaces, CaptureSessionState captureSessionState) {
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        kotlin.jvm.internal.p.i(surfaces, "surfaces");
        kotlin.jvm.internal.p.i(captureSessionState, "captureSessionState");
        if (this.graphConfig.k() != null) {
            s.a aVar = (s.a) F.X0(((p.a) F.X0(this.graphConfig.k())).getStream().b());
            InputConfiguration inputConfiguration = new InputConfiguration(aVar.getSize().getWidth(), aVar.getSize().getHeight(), aVar.getFormat());
            ArrayList arrayList = new ArrayList(surfaces.size());
            Iterator<Map.Entry<Q, ? extends Surface>> it = surfaces.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
            if (!cameraDevice.f1(inputConfiguration, arrayList, captureSessionState)) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to create reprocessable captures session from " + cameraDevice + " for " + captureSessionState + '!');
                }
                captureSessionState.a();
                return r.a.C0137a.f10670a;
            }
        } else {
            ArrayList arrayList2 = new ArrayList(surfaces.size());
            Iterator<Map.Entry<Q, ? extends Surface>> it2 = surfaces.entrySet().iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().getValue());
            }
            if (!cameraDevice.N0(arrayList2, captureSessionState)) {
                if (z.k.f44508a.d()) {
                    Log.w("CXCP", "Failed to create captures session from " + cameraDevice + " for " + captureSessionState + '!');
                }
                captureSessionState.a();
                return r.a.C0137a.f10670a;
            }
        }
        return new r.a.Success(kotlin.collections.a.i(), s.c(surfaces, this.streamGraph));
    }
}
