package A;

import Xa.u;
import Z8.C1173v;
import Z8.F;
import android.util.Log;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.graph.GraphLoop;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import w.AbstractC5689A;
import w.InterfaceC5690B;
import x.C5810d0;
import x.C5820i0;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002BA\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u000e\b\u0001\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u0019\u0010\u001a\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001b\u0010\u0018J\u0017\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010#\u001a\u00020\"2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u000bH\u0016¢\u0006\u0004\b#\u0010$J#\u0010(\u001a\u00020\"2\u0012\u0010'\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010&0%H\u0016¢\u0006\u0004\b(\u0010)J#\u0010*\u001a\u00020\u00122\u0012\u0010'\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010&0%H\u0016¢\u0006\u0004\b*\u0010+J#\u0010,\u001a\u00020\u00122\u0012\u0010'\u001a\u000e\u0012\u0002\b\u0003\u0012\u0006\u0012\u0004\u0018\u00010&0%H\u0016¢\u0006\u0004\b,\u0010+J\u001d\u0010.\u001a\u00020\u00122\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0012H\u0016¢\u0006\u0004\b0\u0010\u0014J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u00104R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u00105R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u00107R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u0002090\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010:R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020=0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010>R(\u0010E\u001a\u0004\u0018\u00010 2\b\u0010@\u001a\u0004\u0018\u00010 8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D¨\u0006F"}, d2 = {"LA/g;", "LA/f;", "LA/e;", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Landroidx/camera/camera2/pipe/e;", "cameraGraphId", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "cameraGraphConfig", "Landroidx/camera/camera2/pipe/graph/c;", "graphListener3A", "", "Landroidx/camera/camera2/pipe/t$a;", "graphListeners", "Lx/d0;", "camera2Quirks", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/e;Landroidx/camera/camera2/pipe/CameraGraph$b;Landroidx/camera/camera2/pipe/graph/c;Ljava/util/List;Lx/d0;)V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "LA/h;", "requestProcessor", "f", "(LA/h;)V", Const.INTENT_KEY_APIKEY, "e", Const.INTENT_KEY_UMID, "Lw/A$a;", "graphStateError", "c", "(Lw/A$a;)V", "Landroidx/camera/camera2/pipe/t;", "requests", "", "o", "(Ljava/util/List;)Z", "", "", "parameters", "u", "(Ljava/util/Map;)Z", "p", "(Ljava/util/Map;)V", "t", "listeners", "q", "(Ljava/util/List;)V", "close", "", "toString", "()Ljava/lang/String;", "Landroidx/camera/camera2/pipe/e;", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "Landroidx/camera/camera2/pipe/graph/GraphLoop;", "Landroidx/camera/camera2/pipe/graph/GraphLoop;", "graphLoop", "Lw/B;", "Ljava/util/List;", "externalStateGraphListeners", "LXa/k;", "Lw/A;", "LXa/k;", "_graphState", UxipConstants.f30680s, "s", "()Landroidx/camera/camera2/pipe/t;", "r", "(Landroidx/camera/camera2/pipe/t;)V", "repeatingRequest", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: A.g, reason: from toString */
/* loaded from: classes.dex */
public final class GraphProcessor implements f, e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.e cameraGraphId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CameraGraph.b cameraGraphConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final GraphLoop graphLoop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final List<InterfaceC5690B> externalStateGraphListeners;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Xa.k<AbstractC5689A> _graphState;

    public GraphProcessor(Threads threads, androidx.camera.camera2.pipe.e cameraGraphId, CameraGraph.b cameraGraphConfig, androidx.camera.camera2.pipe.graph.c graphListener3A, List<t.a> graphListeners, C5810d0 camera2Quirks) {
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(cameraGraphId, "cameraGraphId");
        kotlin.jvm.internal.p.i(cameraGraphConfig, "cameraGraphConfig");
        kotlin.jvm.internal.p.i(graphListener3A, "graphListener3A");
        kotlin.jvm.internal.p.i(graphListeners, "graphListeners");
        kotlin.jvm.internal.p.i(camera2Quirks, "camera2Quirks");
        this.cameraGraphId = cameraGraphId;
        this.cameraGraphConfig = cameraGraphConfig;
        this.externalStateGraphListeners = cameraGraphConfig.j();
        Map<?, Object> mapF = cameraGraphConfig.f();
        Map<?, Object> mapM = cameraGraphConfig.m();
        C5820i0 c5820i0 = C5820i0.f43411a;
        Object obj = mapF.get(c5820i0.c());
        Boolean bool = Boolean.TRUE;
        if ((kotlin.jvm.internal.p.d(obj, bool) || kotlin.jvm.internal.p.d(mapM.get(c5820i0.c()), bool)) && z.k.f44508a.c()) {
            Log.i("CXCP", c5820i0.c() + " is set to true, ignoring GraphState3A parameters.");
        }
        int iB = camera2Quirks.b(cameraGraphConfig.getFlags());
        androidx.camera.camera2.pipe.graph.a aVar = iB != 0 ? new androidx.camera.camera2.pipe.graph.a(iB) : null;
        GraphLoop graphLoop = new GraphLoop(cameraGraphId, mapF, mapM, F.S0(graphListeners, C1173v.q(aVar)), C1173v.r(graphListener3A, aVar), threads.getCameraPipeScope(), threads.getLightweightDispatcher());
        this.graphLoop = graphLoop;
        if (aVar != null) {
            aVar.p(graphLoop);
        }
        this._graphState = u.a(AbstractC5689A.d.f42888b);
    }

    @Override // A.e
    public void a() {
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " onGraphStopping");
        }
        this._graphState.setValue(AbstractC5689A.e.f42889b);
        this.graphLoop.s1(null);
        Iterator<InterfaceC5690B> it = this.externalStateGraphListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // A.e
    public void b() {
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " onGraphStarting");
        }
        this._graphState.setValue(AbstractC5689A.c.f42887b);
        Iterator<InterfaceC5690B> it = this.externalStateGraphListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    @Override // A.e
    public void c(AbstractC5689A.a graphStateError) {
        AbstractC5689A value;
        AbstractC5689A abstractC5689A;
        kotlin.jvm.internal.p.i(graphStateError, "graphStateError");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " onGraphError(" + graphStateError + ')');
        }
        Xa.k<AbstractC5689A> kVar = this._graphState;
        do {
            value = kVar.getValue();
            abstractC5689A = value;
        } while (!kVar.d(value, ((abstractC5689A instanceof AbstractC5689A.e) || (abstractC5689A instanceof AbstractC5689A.d)) ? AbstractC5689A.d.f42888b : graphStateError));
        Iterator<InterfaceC5690B> it = this.externalStateGraphListeners.iterator();
        while (it.hasNext()) {
            it.next().c(graphStateError);
        }
    }

    @Override // A.f
    public void close() {
        this.graphLoop.close();
    }

    @Override // A.e
    public void d(h requestProcessor) {
        kotlin.jvm.internal.p.i(requestProcessor, "requestProcessor");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " onGraphModified");
        }
        this.graphLoop.U();
    }

    @Override // A.e
    public void e(h requestProcessor) {
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " onGraphStopped");
        }
        this._graphState.setValue(AbstractC5689A.d.f42888b);
        this.graphLoop.s1(null);
        Iterator<InterfaceC5690B> it = this.externalStateGraphListeners.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    @Override // A.e
    public void f(h requestProcessor) {
        kotlin.jvm.internal.p.i(requestProcessor, "requestProcessor");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", this + " onGraphStarted");
        }
        this._graphState.setValue(AbstractC5689A.b.f42886b);
        this.graphLoop.s1(requestProcessor);
        Iterator<InterfaceC5690B> it = this.externalStateGraphListeners.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    @Override // A.f
    public boolean o(List<t> requests) {
        Object next;
        kotlin.jvm.internal.p.i(requests, "requests");
        Iterator<T> it = requests.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((t) next).getInputRequest() != null) {
                break;
            }
        }
        t tVar = (t) next;
        if (tVar == null || this.cameraGraphConfig.k() != null) {
            return this.graphLoop.t1(requests);
        }
        throw new IllegalStateException(("Cannot submit " + tVar + " with input request " + tVar.getInputRequest() + " to " + this + " because CameraGraph was not configured to support reprocessing").toString());
    }

    @Override // A.f
    public void p(Map<?, ? extends Object> parameters) {
        kotlin.jvm.internal.p.i(parameters, "parameters");
        this.graphLoop.k1(parameters);
    }

    @Override // A.f
    public void q(List<? extends t.a> listeners) {
        kotlin.jvm.internal.p.i(listeners, "listeners");
        this.graphLoop.m1(listeners);
    }

    @Override // A.f
    public void r(t tVar) {
        this.graphLoop.l1(tVar);
    }

    @Override // A.f
    public t s() {
        return this.graphLoop.J();
    }

    @Override // A.f
    public void t(Map<?, ? extends Object> parameters) {
        kotlin.jvm.internal.p.i(parameters, "parameters");
        this.graphLoop.h1(parameters);
    }

    public String toString() {
        return "GraphProcessor(cameraGraph: " + this.cameraGraphId + ')';
    }

    @Override // A.f
    public boolean u(Map<?, ? extends Object> parameters) {
        kotlin.jvm.internal.p.i(parameters, "parameters");
        return this.graphLoop.u1(parameters);
    }
}
