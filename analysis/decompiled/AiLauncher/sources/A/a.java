package A;

import Ua.Q;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.graph.Controller3A;
import androidx.camera.camera2.pipe.t;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import g9.C4109a;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import w.C5694F;
import w.C5695a;
import w.C5696b;
import w.C5697c;
import w.Result3A;
import w.x;
import z.z;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001aJc\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00102\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00102\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0010H\u0016¢\u0006\u0004\b(\u0010)J\u0015\u0010*\u001a\b\u0012\u0004\u0012\u00020'0&H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b,\u0010-JÐ\u0001\u0010=\u001a\b\u0012\u0004\u0012\u00020'0&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00102\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00102\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00102\b\u0010/\u001a\u0004\u0018\u00010.2\b\u00100\u001a\u0004\u0018\u00010.2\b\u00101\u001a\u0004\u0018\u00010.2\b\u00102\u001a\u0004\u0018\u00010\u001c2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0018\u0001032\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0018\u0001032\u0006\u00109\u001a\u0002082\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:H\u0096@¢\u0006\u0004\b=\u0010>JZ\u0010D\u001a\b\u0012\u0004\u0012\u00020'0&2\b\u0010?\u001a\u0004\u0018\u0001052\b\u0010@\u001a\u0004\u0018\u0001052\b\u0010A\u001a\u0004\u0018\u0001052\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u000205\u0018\u0001032\u0006\u00109\u001a\u0002082\u0006\u0010C\u001a\u00020:H\u0096@¢\u0006\u0004\bD\u0010EJ6\u0010H\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010F\u001a\u0002052\u0006\u0010G\u001a\u0002052\u0006\u00109\u001a\u0002082\u0006\u0010C\u001a\u00020:H\u0096@¢\u0006\u0004\bH\u0010IJ\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00020'0&2\u0006\u0010J\u001a\u000205H\u0096@¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u00020MH\u0016¢\u0006\u0004\bN\u0010OR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010RR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010WR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\\\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006]"}, d2 = {"LA/a;", "Landroidx/camera/camera2/pipe/CameraGraph$f;", "Lz/z;", M5.b.CREDENTIAL_TOKEN, "LA/f;", "graphProcessor", "Landroidx/camera/camera2/pipe/graph/Controller3A;", "controller3A", "Landroidx/camera/camera2/pipe/internal/a;", "frameCaptureQueue", "LB/d;", "parameters", "LB/e;", "listeners", "<init>", "(Lz/z;LA/f;Landroidx/camera/camera2/pipe/graph/Controller3A;Landroidx/camera/camera2/pipe/internal/a;LB/d;LB/e;)V", "", "Landroidx/camera/camera2/pipe/t;", "requests", "LY8/t;", "o", "(Ljava/util/List;)V", "request", "i0", "(Landroidx/camera/camera2/pipe/t;)V", "stopRepeating", "()V", "close", "Lw/a;", "aeMode", "Lw/b;", "afMode", "Lw/c;", "awbMode", "Landroid/hardware/camera2/params/MeteringRectangle;", "aeRegions", "afRegions", "awbRegions", "LUa/Q;", "Lw/N;", "e", "(Lw/a;Lw/b;Lw/c;Ljava/util/List;Ljava/util/List;Ljava/util/List;)LUa/Q;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()LUa/Q;", Const.INTENT_KEY_PKGNAME, "(Lw/a;)LUa/Q;", "Lw/F;", "aeLockBehavior", "afLockBehavior", "awbLockBehavior", "afTriggerStartAeMode", "Lkotlin/Function1;", "Lw/x;", "", "convergedCondition", "lockedCondition", "", "frameLimit", "", "convergedTimeLimitNs", "lockedTimeLimitNs", "L0", "(Lw/a;Lw/b;Lw/c;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lw/F;Lw/F;Lw/F;Lw/a;Lp9/l;Lp9/l;IJJLe9/c;)Ljava/lang/Object;", "ae", "af", "awb", "unlockedCondition", "timeLimitNs", "v", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lp9/l;IJLe9/c;)Ljava/lang/Object;", "triggerAf", "waitForAwb", "i1", "(ZZIJLe9/c;)Ljava/lang/Object;", "cancelAf", "J0", "(ZLe9/c;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lz/z;", "LA/f;", "c", "Landroidx/camera/camera2/pipe/graph/Controller3A;", Const.INTENT_KEY_UMID, "Landroidx/camera/camera2/pipe/internal/a;", "LB/d;", "f", "LB/e;", Const.INTENT_KEY_BACKGROUND_COMMAND, "I", "debugId", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class a implements CameraGraph.f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final z token;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final f graphProcessor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Controller3A controller3A;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.internal.a frameCaptureQueue;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final B.d parameters;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final B.e listeners;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final int debugId;

    public a(z token, f graphProcessor, Controller3A controller3A, androidx.camera.camera2.pipe.internal.a frameCaptureQueue, B.d parameters, B.e listeners) {
        kotlin.jvm.internal.p.i(token, "token");
        kotlin.jvm.internal.p.i(graphProcessor, "graphProcessor");
        kotlin.jvm.internal.p.i(controller3A, "controller3A");
        kotlin.jvm.internal.p.i(frameCaptureQueue, "frameCaptureQueue");
        kotlin.jvm.internal.p.i(parameters, "parameters");
        kotlin.jvm.internal.p.i(listeners, "listeners");
        this.token = token;
        this.graphProcessor = graphProcessor;
        this.controller3A = controller3A;
        this.frameCaptureQueue = frameCaptureQueue;
        this.parameters = parameters;
        this.listeners = listeners;
        this.debugId = b.a().d();
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.f
    public Object J0(boolean z10, InterfaceC4014c<? super Q<Result3A>> interfaceC4014c) {
        if (!this.token.a()) {
            return this.controller3A.p(z10);
        }
        throw new IllegalStateException(("Cannot call unlock3APostCapture on " + this + " after close.").toString());
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.f
    public Object L0(C5695a c5695a, C5696b c5696b, C5697c c5697c, List<MeteringRectangle> list, List<MeteringRectangle> list2, List<MeteringRectangle> list3, C5694F c5694f, C5694F c5694f2, C5694F c5694f3, C5695a c5695a2, InterfaceC5074l<? super x, Boolean> interfaceC5074l, InterfaceC5074l<? super x, Boolean> interfaceC5074l2, int i10, long j10, long j11, InterfaceC4014c<? super Q<Result3A>> interfaceC4014c) {
        if (!this.token.a()) {
            return this.controller3A.i(list, list2, list3, c5694f, c5694f2, c5694f3, c5695a2, interfaceC5074l, interfaceC5074l2, i10, C4109a.g(j10), C4109a.g(j11), interfaceC4014c);
        }
        throw new IllegalStateException(("Cannot call lock3A on " + this + " after close.").toString());
    }

    @Override // w.InterfaceC5704j
    public Q<Result3A> b(C5695a aeMode) {
        if (!this.token.a()) {
            return this.controller3A.m(aeMode);
        }
        throw new IllegalStateException(("Cannot call setTorchOff on " + this + " after close.").toString());
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.parameters.a();
        List<t.a> listA = this.listeners.a();
        if (listA != null) {
            this.graphProcessor.q(listA);
        }
        this.token.release();
    }

    @Override // w.InterfaceC5704j
    public Q<Result3A> e(C5695a aeMode, C5696b afMode, C5697c awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        if (!this.token.a()) {
            return Controller3A.s(this.controller3A, aeMode, afMode, awbMode, null, aeRegions, afRegions, awbRegions, 8, null);
        }
        throw new IllegalStateException(("Cannot call update3A on " + this + " after close.").toString());
    }

    @Override // w.InterfaceC5704j
    public Q<Result3A> i() {
        if (!this.token.a()) {
            return this.controller3A.n();
        }
        throw new IllegalStateException(("Cannot call setTorchOn on " + this + " after close.").toString());
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.f
    public void i0(t request) {
        kotlin.jvm.internal.p.i(request, "request");
        if (!this.token.a()) {
            this.graphProcessor.r(request);
            return;
        }
        throw new IllegalStateException(("Cannot call startRepeating on " + this + " after close.").toString());
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.f
    public Object i1(boolean z10, boolean z11, int i10, long j10, InterfaceC4014c<? super Q<Result3A>> interfaceC4014c) {
        if (!this.token.a()) {
            return this.controller3A.k(z10, z11, i10, j10);
        }
        throw new IllegalStateException(("Cannot call lock3AForCapture on " + this + " after close.").toString());
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.f
    public void o(List<t> requests) {
        kotlin.jvm.internal.p.i(requests, "requests");
        if (!this.token.a()) {
            if (requests.isEmpty()) {
                throw new IllegalStateException("Cannot call submit with an empty list of Requests!");
            }
            this.graphProcessor.o(requests);
        } else {
            throw new IllegalStateException(("Cannot call submit on " + this + " after close.").toString());
        }
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.f
    public void stopRepeating() {
        if (!this.token.a()) {
            this.graphProcessor.r(null);
            return;
        }
        throw new IllegalStateException(("Cannot call stopRepeating on " + this + " after close.").toString());
    }

    public String toString() {
        return "CameraGraph.Session-" + this.debugId;
    }

    @Override // androidx.camera.camera2.pipe.CameraGraph.f
    public Object v(Boolean bool, Boolean bool2, Boolean bool3, InterfaceC5074l<? super x, Boolean> interfaceC5074l, int i10, long j10, InterfaceC4014c<? super Q<Result3A>> interfaceC4014c) {
        if (!this.token.a()) {
            return this.controller3A.o(bool, bool2, bool3, interfaceC5074l, i10, C4109a.g(j10));
        }
        throw new IllegalStateException(("Cannot call unlock3A on " + this + " after close.").toString());
    }
}
