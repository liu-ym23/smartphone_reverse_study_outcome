package androidx.camera.camera2.impl;

import D.C0761b0;
import J.InterfaceC0857l;
import K.z0;
import Ua.C1060i;
import Ua.C1087w;
import Y8.h;
import Y8.t;
import Z8.C1172u;
import Z8.F;
import android.util.Log;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.impl.UseCaseCameraImpl;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import e9.InterfaceC4014c;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import s.J;
import t.C5473b;
import t.InterfaceC5495w;
import t.i0;
import t.n0;
import t.y0;
import w.Q;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001BU\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ%\u0010!\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J(\u0010+\u001a\u00020*2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020&H\u0096@¢\u0006\u0004\b+\u0010,J\u0011\u0010.\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0004\b.\u0010/J!\u00103\u001a\u00020\u00132\b\u00100\u001a\u0004\u0018\u00010-2\u0006\u00102\u001a\u000201H\u0002¢\u0006\u0004\b3\u00104R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u00105R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u00106R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u00109\u001a\u0004\b7\u0010:R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010<R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010<R\u0014\u0010A\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR#\u0010K\u001a\n F*\u0004\u0018\u00010\u000b0\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR#\u0010O\u001a\n F*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010H\u001a\u0004\bM\u0010NR#\u0010S\u001a\n F*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010H\u001a\u0004\bQ\u0010R¨\u0006T"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseCameraImpl;", "Lt/i0;", "Ls/J;", "useCaseGraphContext", "Lt/y0;", "threads", "LK/z0;", "sessionProcessor", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "requestControl", "LX8/a;", "Landroidx/camera/camera2/impl/UseCaseSurfaceManager;", "useCaseSurfaceManagerProvider", "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "sessionConfigAdapterProvider", "Lt/w;", "capturePipelineProvider", "<init>", "(Ls/J;Lt/y0;LK/z0;Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;LX8/a;LX8/a;LX8/a;)V", "LY8/t;", "start", "()V", "Lkotlinx/coroutines/g;", "close", "()Lkotlinx/coroutines/g;", "", x5.d.EXTRA_ENABLED, Const.INTENT_KEY_UMID, "(Z)V", "isPrimary", "", "Landroidx/camera/core/UseCase;", "runningUseCases", Const.INTENT_KEY_PKGNAME, "(ZLjava/util/Collection;)Lkotlinx/coroutines/g;", "", "toString", "()Ljava/lang/String;", "", "captureMode", "flashMode", "flashType", "LJ/l;", Const.INTENT_KEY_APIKEY, "(IIILe9/c;)Ljava/lang/Object;", "Lw/Q;", "p", "()Lw/Q;", "stillCaptureStreamId", "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraGraph", "u", "(Lw/Q;Landroidx/camera/camera2/pipe/CameraGraph;)V", "Ls/J;", "Lt/y0;", "c", "LK/z0;", "Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "()Landroidx/camera/camera2/impl/UseCaseCameraRequestControl;", "e", "LX8/a;", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "I", "debugId", "LOa/a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LOa/a;", AlipayXuiIsland.REASON_CLOSED, "kotlin.jvm.PlatformType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "LY8/h;", "s", "()Landroidx/camera/camera2/impl/UseCaseSurfaceManager;", "useCaseSurfaceManager", "k", "r", "()Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "sessionConfigAdapter", "l", "q", "()Lt/w;", "capturePipeline", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UseCaseCameraImpl implements i0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final J useCaseGraphContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final z0 sessionProcessor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final UseCaseCameraRequestControl requestControl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final X8.a<UseCaseSurfaceManager> useCaseSurfaceManagerProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final X8.a<SessionConfigAdapter> sessionConfigAdapterProvider;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final X8.a<InterfaceC5495w> capturePipelineProvider;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final int debugId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Oa.a closed;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final h useCaseSurfaceManager;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final h sessionConfigAdapter;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final h capturePipeline;

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"androidx/camera/camera2/impl/UseCaseCameraImpl$a", "LK/z0$a;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements z0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q f9905a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CameraGraph f9906b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UseCaseCameraImpl f9907c;

        public a(Q q10, CameraGraph cameraGraph, UseCaseCameraImpl useCaseCameraImpl) {
            this.f9905a = q10;
            this.f9906b = cameraGraph;
            this.f9907c = useCaseCameraImpl;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class b implements InterfaceC5074l<Throwable, t> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f9908a = new b();

        public final void a(Throwable th) {
            if (th == null || (th instanceof CancellationException)) {
                return;
            }
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.g("CXCP")) {
                Log.e(C5473b.TRUNCATED_TAG, "Surface setup error!", th);
            }
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            a(th);
            return t.f7040a;
        }
    }

    public UseCaseCameraImpl(J useCaseGraphContext, y0 threads, z0 z0Var, UseCaseCameraRequestControl requestControl, X8.a<UseCaseSurfaceManager> useCaseSurfaceManagerProvider, X8.a<SessionConfigAdapter> sessionConfigAdapterProvider, X8.a<InterfaceC5495w> capturePipelineProvider) {
        p.i(useCaseGraphContext, "useCaseGraphContext");
        p.i(threads, "threads");
        p.i(requestControl, "requestControl");
        p.i(useCaseSurfaceManagerProvider, "useCaseSurfaceManagerProvider");
        p.i(sessionConfigAdapterProvider, "sessionConfigAdapterProvider");
        p.i(capturePipelineProvider, "capturePipelineProvider");
        this.useCaseGraphContext = useCaseGraphContext;
        this.threads = threads;
        this.sessionProcessor = z0Var;
        this.requestControl = requestControl;
        this.useCaseSurfaceManagerProvider = useCaseSurfaceManagerProvider;
        this.sessionConfigAdapterProvider = sessionConfigAdapterProvider;
        this.capturePipelineProvider = capturePipelineProvider;
        this.debugId = n0.b().d();
        this.closed = Oa.b.a(false);
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Configured " + this);
        }
        this.useCaseSurfaceManager = C4848b.b(new InterfaceC5063a() { // from class: t.k0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UseCaseCameraImpl.v(this.f41906a);
            }
        });
        this.sessionConfigAdapter = C4848b.b(new InterfaceC5063a() { // from class: t.l0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UseCaseCameraImpl.t(this.f41911a);
            }
        });
        this.capturePipeline = C4848b.b(new InterfaceC5063a() { // from class: t.m0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return UseCaseCameraImpl.o(this.f41916a);
            }
        });
    }

    public static final InterfaceC5495w o(UseCaseCameraImpl useCaseCameraImpl) {
        return useCaseCameraImpl.capturePipelineProvider.get();
    }

    public static final SessionConfigAdapter t(UseCaseCameraImpl useCaseCameraImpl) {
        return useCaseCameraImpl.sessionConfigAdapterProvider.get();
    }

    public static final UseCaseSurfaceManager v(UseCaseCameraImpl useCaseCameraImpl) {
        return useCaseCameraImpl.useCaseSurfaceManagerProvider.get();
    }

    @Override // t.i0
    public Object a(int i10, int i11, int i12, InterfaceC4014c<? super InterfaceC0857l> interfaceC4014c) {
        return q().a(i10, i11, i12, interfaceC4014c);
    }

    @Override // t.i0
    public kotlinx.coroutines.g b(boolean isPrimary, Collection<? extends UseCase> runningUseCases) {
        p.i(runningUseCases, "runningUseCases");
        return getRequestControl().b(isPrimary, runningUseCases);
    }

    @Override // t.i0
    /* renamed from: c, reason: from getter */
    public UseCaseCameraRequestControl getRequestControl() {
        return this.requestControl;
    }

    @Override // t.i0
    public kotlinx.coroutines.g close() {
        if (!this.closed.a(false, true)) {
            return C1087w.a(t.f7040a);
        }
        getRequestControl().close();
        return C1060i.d(this.threads.getSequentialScope(), null, null, new UseCaseCameraImpl$close$$inlined$confineLaunch$1(null, this), 3, null);
    }

    @Override // t.i0
    public void d(boolean enabled) {
        C1060i.d(this.threads.getSequentialScope(), null, null, new UseCaseCameraImpl$setActiveResumeMode$$inlined$confineLaunch$1(null, this, enabled), 3, null);
    }

    public final Q p() {
        Object next;
        SessionConfig sessionConfigN = r().n();
        if (sessionConfigN == null) {
            return null;
        }
        List<DeferrableSurface> listH = sessionConfigN.l().h();
        p.h(listH, "getSurfaces(...)");
        List<DeferrableSurface> listP = sessionConfigN.p();
        p.h(listP, "getSurfaces(...)");
        Iterator<T> it = listP.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!listH.contains((DeferrableSurface) next)) {
                break;
            }
        }
        DeferrableSurface deferrableSurface = (DeferrableSurface) next;
        if (deferrableSurface == null) {
            return null;
        }
        return (Q) F.r0(this.useCaseGraphContext.g(C1172u.e(deferrableSurface)));
    }

    public final InterfaceC5495w q() {
        return (InterfaceC5495w) this.capturePipeline.getValue();
    }

    public final SessionConfigAdapter r() {
        return (SessionConfigAdapter) this.sessionConfigAdapter.getValue();
    }

    public final UseCaseSurfaceManager s() {
        return (UseCaseSurfaceManager) this.useCaseSurfaceManager.getValue();
    }

    @Override // t.i0
    public void start() {
        C1060i.d(this.threads.getSequentialScope(), null, null, new UseCaseCameraImpl$start$$inlined$confineLaunch$1(null, this), 3, null);
    }

    public String toString() {
        return "UseCaseCamera-" + this.debugId;
    }

    public final void u(Q stillCaptureStreamId, CameraGraph cameraGraph) {
        z0 z0Var = this.sessionProcessor;
        if (z0Var != null) {
            z0Var.d(new a(stillCaptureStreamId, cameraGraph, this));
        }
    }
}
