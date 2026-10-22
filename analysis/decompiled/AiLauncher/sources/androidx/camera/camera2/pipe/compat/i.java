package androidx.camera.camera2.pipe.compat;

import A.StreamGraph;
import Z8.C1174w;
import Z8.F;
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
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import w.Q;
import x.InputConfigData;
import x.OutputConfigurations;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ3\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/camera/camera2/pipe/compat/i;", "Landroidx/camera/camera2/pipe/compat/r;", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "LA/q;", "streamGraph", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/CameraGraph$b;LA/q;)V", "Landroidx/camera/camera2/pipe/compat/p;", "cameraDevice", "", "Lw/Q;", "Landroid/view/Surface;", "surfaces", "Landroidx/camera/camera2/pipe/compat/CaptureSessionState;", "captureSessionState", "Landroidx/camera/camera2/pipe/compat/r$a;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/camera2/pipe/compat/p;Ljava/util/Map;Landroidx/camera/camera2/pipe/compat/CaptureSessionState;)Landroidx/camera/camera2/pipe/compat/r$a;", "Landroidx/camera/camera2/pipe/core/Threads;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/CameraGraph$b;", "c", "LA/q;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class i implements r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CameraGraph.b graphConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final StreamGraph streamGraph;

    public i(Threads threads, CameraGraph.b graphConfig, StreamGraph streamGraph) {
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        this.threads = threads;
        this.graphConfig = graphConfig;
        this.streamGraph = streamGraph;
    }

    @Override // androidx.camera.camera2.pipe.compat.r
    public r.a a(p cameraDevice, Map<Q, ? extends Surface> surfaces, CaptureSessionState captureSessionState) {
        int sessionMode;
        ArrayList arrayList;
        kotlin.jvm.internal.p.i(cameraDevice, "cameraDevice");
        kotlin.jvm.internal.p.i(surfaces, "surfaces");
        kotlin.jvm.internal.p.i(captureSessionState, "captureSessionState");
        int sessionMode2 = this.graphConfig.getSessionMode();
        CameraGraph.e.Companion companion = CameraGraph.e.INSTANCE;
        if (CameraGraph.e.f(sessionMode2, companion.d())) {
            sessionMode = 0;
        } else if (CameraGraph.e.f(sessionMode2, companion.c())) {
            sessionMode = 1;
        } else {
            if (CameraGraph.e.f(sessionMode2, companion.b())) {
                throw new IllegalArgumentException("Unsupported session mode: " + ((Object) CameraGraph.e.h(this.graphConfig.getSessionMode())));
            }
            sessionMode = this.graphConfig.getSessionMode();
        }
        OutputConfigurations outputConfigurationsB = s.b(this.graphConfig, this.streamGraph, surfaces);
        if (outputConfigurationsB.a().isEmpty()) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to create OutputConfigurations for " + this.graphConfig);
            }
            captureSessionState.a();
            return r.a.C0137a.f10670a;
        }
        List<p.a> listK = this.graphConfig.k();
        if (listK != null) {
            List<p.a> list = listK;
            arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                s.a aVar = (s.a) F.X0(((p.a) it.next()).getStream().b());
                arrayList.add(new InputConfigData(aVar.getSize().getWidth(), aVar.getSize().getHeight(), aVar.getFormat()));
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (((InputConfigData) it2.next()).getFormat() != ((InputConfigData) arrayList.get(0)).getFormat()) {
                    throw new IllegalStateException("All InputStream.Config objects must have the same format for multi resolution");
                }
            }
        }
        if (cameraDevice.V(new v(sessionMode, arrayList, outputConfigurationsB.a(), this.threads.h(), captureSessionState, this.graphConfig.getSessionTemplate(), this.graphConfig.p(), this.graphConfig.getSessionColorSpace(), null))) {
            return new r.a.Success(outputConfigurationsB.b(), outputConfigurationsB.c());
        }
        if (z.k.f44508a.d()) {
            Log.w("CXCP", "Failed to create capture session from " + cameraDevice + " for " + captureSessionState + '!');
        }
        captureSessionState.a();
        return r.a.C0137a.f10670a;
    }
}
