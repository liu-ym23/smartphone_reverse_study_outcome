package androidx.camera.camera2.pipe.graph;

import A.StreamGraph;
import A.e;
import A.f;
import A.r;
import Ua.M;
import Ua.Q;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Trace;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.j;
import androidx.camera.camera2.pipe.g;
import androidx.camera.camera2.pipe.internal.GraphSessionLock;
import androidx.camera.camera2.pipe.s;
import androidx.camera.camera2.pipe.v;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import w.C5695a;
import w.C5696b;
import w.C5697c;
import w.InterfaceC5703i;
import w.Result3A;
import z.h;
import z.k;
import z.z;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u008b\u0001\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0001\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b'\u0010(JE\u0010/\u001a\b\u0012\u0004\u0012\u00028\u00000,\"\u0004\b\u0000\u0010)2(\u0010.\u001a$\b\u0001\u0012\u0004\u0012\u00020\u001e\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0+\u0012\u0006\u0012\u0004\u0018\u00010-0*H\u0002¢\u0006\u0004\b/\u00100J\u000f\u00102\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u0010\u00105\u001a\u000204H\u0096@¢\u0006\u0004\b5\u00106J!\u0010;\u001a\u0002012\u0006\u00108\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b;\u0010<Jc\u0010I\u001a\b\u0012\u0004\u0012\u00020H0,2\b\u0010>\u001a\u0004\u0018\u00010=2\b\u0010@\u001a\u0004\u0018\u00010?2\b\u0010B\u001a\u0004\u0018\u00010A2\u000e\u0010E\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010C2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010C2\u000e\u0010G\u001a\n\u0012\u0004\u0012\u00020D\u0018\u00010CH\u0016¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u000201H\u0016¢\u0006\u0004\bK\u00103J\u000f\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\bM\u0010NR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010WR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u001a\u0010\u0017\u001a\u00020\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u001a\u0010\u0019\u001a\u00020\u00188\u0016X\u0096\u0004¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010iR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010lR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010mR\u0014\u0010q\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR*\u0010v\u001a\u00020r2\u0006\u0010s\u001a\u00020r8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\b\\\u0010xR\u0014\u0010{\u001a\u00020y8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bU\u0010z¨\u0006|"}, d2 = {"Landroidx/camera/camera2/pipe/graph/CameraGraphImpl;", "Landroidx/camera/camera2/pipe/CameraGraph;", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "Landroidx/camera/camera2/pipe/g;", "metadata", "LA/f;", "graphProcessor", "LA/e;", "graphListener", "LA/q;", "streamGraph", "LA/r;", "surfaceGraph", "Lw/i;", "cameraController", "Landroidx/camera/camera2/pipe/internal/b;", "frameDistributor", "Landroidx/camera/camera2/pipe/internal/a;", "frameCaptureQueue", "Landroidx/camera/camera2/pipe/compat/j;", "audioRestrictionController", "Landroidx/camera/camera2/pipe/e;", "id", "LB/d;", "parameters", "LB/e;", "listeners", "Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", "sessionLock", "LUa/M;", "graphScope", "Landroidx/camera/camera2/pipe/graph/Controller3A;", "controller3A", "<init>", "(Landroidx/camera/camera2/pipe/CameraGraph$b;Landroidx/camera/camera2/pipe/g;LA/f;LA/e;LA/q;LA/r;Lw/i;Landroidx/camera/camera2/pipe/internal/b;Landroidx/camera/camera2/pipe/internal/a;Landroidx/camera/camera2/pipe/compat/j;Landroidx/camera/camera2/pipe/e;LB/d;LB/e;Landroidx/camera/camera2/pipe/internal/GraphSessionLock;LUa/M;Landroidx/camera/camera2/pipe/graph/Controller3A;)V", "Lz/z;", M5.b.CREDENTIAL_TOKEN, "LA/a;", "m", "(Lz/z;)LA/a;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Le9/c;", "LUa/Q;", "", "block", "J", "(Lp9/p;)LUa/Q;", "LY8/t;", "start", "()V", "Landroidx/camera/camera2/pipe/CameraGraph$f;", "A0", "(Le9/c;)Ljava/lang/Object;", "Lw/Q;", "stream", "Landroid/view/Surface;", "surface", "a0", "(ILandroid/view/Surface;)V", "Lw/a;", "aeMode", "Lw/b;", "afMode", "Lw/c;", "awbMode", "", "Landroid/hardware/camera2/params/MeteringRectangle;", "aeRegions", "afRegions", "awbRegions", "Lw/N;", "e", "(Lw/a;Lw/b;Lw/c;Ljava/util/List;Ljava/util/List;Ljava/util/List;)LUa/Q;", "close", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "LA/f;", Const.INTENT_KEY_PKGNAME, "LA/e;", "c", "LA/q;", Const.INTENT_KEY_UMID, "LA/r;", "Lw/i;", "f", "Landroidx/camera/camera2/pipe/internal/b;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/camera2/pipe/internal/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Landroidx/camera/camera2/pipe/compat/j;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroidx/camera/camera2/pipe/e;", "n", "()Landroidx/camera/camera2/pipe/e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LB/d;", "G", "()LB/d;", "k", "LB/e;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()LB/e;", "l", "Landroidx/camera/camera2/pipe/internal/GraphSessionLock;", "LUa/M;", "Landroidx/camera/camera2/pipe/graph/Controller3A;", "LOa/a;", "o", "LOa/a;", AlipayXuiIsland.REASON_CLOSED, "", UxipConstants.f30680s, "p", "Z", "isForeground", "()Z", "(Z)V", "Landroidx/camera/camera2/pipe/v;", "()Landroidx/camera/camera2/pipe/v;", "streams", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CameraGraphImpl implements CameraGraph {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final f graphProcessor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final e graphListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final StreamGraph streamGraph;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final r surfaceGraph;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5703i cameraController;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.internal.b frameDistributor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.internal.a frameCaptureQueue;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final j audioRestrictionController;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.e id;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final B.d parameters;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final B.e listeners;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final GraphSessionLock sessionLock;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final M graphScope;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final Controller3A controller3A;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public final Oa.a closed;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public boolean isForeground;

    public CameraGraphImpl(CameraGraph.b graphConfig, g metadata, f graphProcessor, e graphListener, StreamGraph streamGraph, r surfaceGraph, InterfaceC5703i cameraController, androidx.camera.camera2.pipe.internal.b frameDistributor, androidx.camera.camera2.pipe.internal.a frameCaptureQueue, j audioRestrictionController, androidx.camera.camera2.pipe.e id, B.d parameters, B.e listeners, GraphSessionLock sessionLock, M graphScope, Controller3A controller3A) {
        CameraGraph.b bVar;
        p.i(graphConfig, "graphConfig");
        p.i(metadata, "metadata");
        p.i(graphProcessor, "graphProcessor");
        p.i(graphListener, "graphListener");
        p.i(streamGraph, "streamGraph");
        p.i(surfaceGraph, "surfaceGraph");
        p.i(cameraController, "cameraController");
        p.i(frameDistributor, "frameDistributor");
        p.i(frameCaptureQueue, "frameCaptureQueue");
        p.i(audioRestrictionController, "audioRestrictionController");
        p.i(id, "id");
        p.i(parameters, "parameters");
        p.i(listeners, "listeners");
        p.i(sessionLock, "sessionLock");
        p.i(graphScope, "graphScope");
        p.i(controller3A, "controller3A");
        this.graphProcessor = graphProcessor;
        this.graphListener = graphListener;
        this.streamGraph = streamGraph;
        this.surfaceGraph = surfaceGraph;
        this.cameraController = cameraController;
        this.frameDistributor = frameDistributor;
        this.frameCaptureQueue = frameCaptureQueue;
        this.audioRestrictionController = audioRestrictionController;
        this.id = id;
        this.parameters = parameters;
        this.listeners = listeners;
        this.sessionLock = sessionLock;
        this.graphScope = graphScope;
        this.controller3A = controller3A;
        this.closed = Oa.b.a(false);
        if (k.f44508a.c()) {
            bVar = graphConfig;
            Log.i("CXCP", h.f44503a.d(metadata, bVar, this));
        } else {
            bVar = graphConfig;
        }
        if (CameraGraph.e.f(bVar.getSessionMode(), CameraGraph.e.INSTANCE.c())) {
            if (streamGraph.e().isEmpty()) {
                throw new IllegalArgumentException("Cannot create a HIGH_SPEED CameraGraph without outputs.");
            }
            if (streamGraph.e().size() > 2) {
                throw new IllegalArgumentException(("Cannot create a HIGH_SPEED CameraGraph with more than two outputs. Configured outputs are " + streamGraph.e()).toString());
            }
            List<s> listE = streamGraph.e();
            if (!(listE instanceof Collection) || !listE.isEmpty()) {
                Iterator<T> it = listE.iterator();
                while (it.hasNext()) {
                    if (!((s) it.next()).f()) {
                        throw new IllegalArgumentException(("HIGH_SPEED CameraGraph must only contain Preview and/or Video streams. Configured outputs are " + this.streamGraph.e()).toString());
                    }
                }
            }
        }
        if (bVar.k() != null && bVar.k().isEmpty()) {
            throw new IllegalArgumentException("At least one InputConfiguration is required for reprocessing");
        }
        if (!this.streamGraph.k0().isEmpty()) {
            this.surfaceGraph.i();
        }
        this.isForeground = true;
    }

    /* renamed from: A, reason: from getter */
    public B.e getListeners() {
        return this.listeners;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.camera.camera2.pipe.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object A0(e9.InterfaceC4014c<? super androidx.camera.camera2.pipe.CameraGraph.f> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.camera.camera2.pipe.graph.CameraGraphImpl$acquireSession$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.camera.camera2.pipe.graph.CameraGraphImpl$acquireSession$1 r0 = (androidx.camera.camera2.pipe.graph.CameraGraphImpl$acquireSession$1) r0
            int r1 = r0.f10796c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10796c = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.graph.CameraGraphImpl$acquireSession$1 r0 = new androidx.camera.camera2.pipe.graph.CameraGraphImpl$acquireSession$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f10794a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10796c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.C4849c.b(r5)
            goto L3f
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r5)
            androidx.camera.camera2.pipe.internal.GraphSessionLock r5 = r4.sessionLock
            r0.f10796c = r3
            java.lang.Object r5 = r5.d(r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            z.z r5 = (z.z) r5
            A.a r4 = r4.m(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.graph.CameraGraphImpl.A0(e9.c):java.lang.Object");
    }

    /* renamed from: G, reason: from getter */
    public B.d getParameters() {
        return this.parameters;
    }

    public final <T> Q<T> J(p9.p<? super M, ? super InterfaceC4014c<? super Q<? extends T>>, ? extends Object> block) {
        return this.sessionLock.h(this.graphScope, new CameraGraphImpl$withSessionLockAsync$1(block, null));
    }

    @Override // androidx.camera.camera2.pipe.d
    public void a0(int stream, Surface surface) throws Exception {
        h hVar = h.f44503a;
        Trace.beginSection(((Object) w.Q.f(stream)) + "#setSurface");
        if (surface != null && !surface.isValid() && k.f44508a.d()) {
            Log.w("CXCP", this + "#setSurface: " + surface + " is invalid");
        }
        this.surfaceGraph.l(stream, surface);
        Trace.endSection();
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        if (this.closed.a(false, true)) {
            h hVar = h.f44503a;
            Trace.beginSection(this + "#close");
            if (k.f44508a.c()) {
                Log.i("CXCP", "Closing " + this);
            }
            this.graphProcessor.close();
            this.cameraController.close();
            this.frameDistributor.close();
            this.frameCaptureQueue.close();
            this.surfaceGraph.close();
            this.streamGraph.close();
            this.audioRestrictionController.b(this);
            kotlinx.coroutines.d.e(this.graphScope, null, 1, null);
            Trace.endSection();
        }
    }

    @Override // androidx.camera.camera2.pipe.d
    public v d() {
        return this.streamGraph;
    }

    @Override // w.InterfaceC5704j
    public Q<Result3A> e(C5695a aeMode, C5696b afMode, C5697c awbMode, List<MeteringRectangle> aeRegions, List<MeteringRectangle> afRegions, List<MeteringRectangle> awbRegions) {
        return J(new CameraGraphImpl$update3A$1(this, aeMode, afMode, awbMode, aeRegions, afRegions, awbRegions, null));
    }

    @Override // androidx.camera.camera2.pipe.d
    public void h(boolean z10) {
        this.isForeground = z10;
        this.cameraController.h(z10);
    }

    public final A.a m(z token) {
        return new A.a(token, this.graphProcessor, this.controller3A, this.frameCaptureQueue, getParameters(), getListeners());
    }

    /* renamed from: n, reason: from getter */
    public androidx.camera.camera2.pipe.e getId() {
        return this.id;
    }

    @Override // androidx.camera.camera2.pipe.d
    public void start() {
        if (this.closed.b()) {
            throw new IllegalStateException(("Cannot start " + this + " after calling close()").toString());
        }
        h hVar = h.f44503a;
        Trace.beginSection(this + "#start");
        if (k.f44508a.c()) {
            Log.i("CXCP", "Starting " + this);
        }
        this.graphListener.b();
        this.cameraController.start();
        Trace.endSection();
    }

    public String toString() {
        return getId().getName();
    }
}
