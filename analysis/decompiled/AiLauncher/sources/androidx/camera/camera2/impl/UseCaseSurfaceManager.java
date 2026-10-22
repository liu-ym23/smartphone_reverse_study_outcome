package androidx.camera.camera2.impl;

import D.C0761b0;
import Ua.C1060i;
import Ua.C1087w;
import Ua.InterfaceC1083u;
import Ua.Q;
import Y8.t;
import android.util.Log;
import android.view.Surface;
import androidx.camera.camera2.adapter.SessionConfigAdapter;
import androidx.camera.camera2.impl.UseCaseSurfaceManager;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.h;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.n;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import r.InterfaceC5194l;
import t.C5473b;
import t.y0;
import w.C5711q;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJA\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b!\u0010 J\u000f\u0010\"\u001a\u00020\u0018H\u0003¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0018H\u0003¢\u0006\u0004\b$\u0010#J.\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000f0%2\u0006\u0010\u0013\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u0015*\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0%H\u0002¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010+R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010,R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u00107\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b5\u00106R \u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000f088\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b9\u0010:R$\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b<\u0010:R\u001e\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010>8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006B"}, d2 = {"Landroidx/camera/camera2/impl/UseCaseSurfaceManager;", "Lw/q$b;", "Lt/y0;", "threads", "Landroidx/camera/camera2/pipe/h;", "cameraPipe", "Lr/l;", "inactiveSurfaceCloser", "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "sessionConfigAdapter", "<init>", "(Lt/y0;Landroidx/camera/camera2/pipe/h;Lr/l;Landroidx/camera/camera2/adapter/SessionConfigAdapter;)V", "Landroidx/camera/camera2/pipe/CameraGraph;", "graph", "", "Landroidx/camera/core/impl/DeferrableSurface;", "Lw/Q;", "surfaceToStreamMap", "", "timeoutMillis", "LUa/Q;", "", "o", "(Landroidx/camera/camera2/pipe/CameraGraph;Landroidx/camera/camera2/adapter/SessionConfigAdapter;Ljava/util/Map;J)LUa/Q;", "LY8/t;", "r", "()LUa/Q;", "k", "(Le9/c;)Ljava/lang/Object;", "Landroid/view/Surface;", "surface", Const.INTENT_KEY_APIKEY, "(Landroid/view/Surface;)V", Const.INTENT_KEY_PKGNAME, "n", "()V", "s", "", "deferrableSurfaces", "m", "(Ljava/util/List;JLe9/c;)Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/List;)Z", "Lt/y0;", "Landroidx/camera/camera2/pipe/h;", "c", "Lr/l;", Const.INTENT_KEY_UMID, "Landroidx/camera/camera2/adapter/SessionConfigAdapter;", "", "e", "Ljava/lang/Object;", "lock", "f", "LUa/Q;", "setupDeferred", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/Map;", "activeSurfaceMap", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "configuredSurfaceMap", "LUa/u;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "LUa/u;", "stopDeferred", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public class UseCaseSurfaceManager implements C5711q.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final y0 threads;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final h cameraPipe;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5194l inactiveSurfaceCloser;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final SessionConfigAdapter sessionConfigAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Q<Boolean> setupDeferred;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Map<Surface, DeferrableSurface> activeSurfaceMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public Map<Surface, ? extends DeferrableSurface> configuredSurfaceMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public InterfaceC1083u<t> stopDeferred;

    public UseCaseSurfaceManager(y0 threads, h cameraPipe, InterfaceC5194l inactiveSurfaceCloser, SessionConfigAdapter sessionConfigAdapter) {
        p.i(threads, "threads");
        p.i(cameraPipe, "cameraPipe");
        p.i(inactiveSurfaceCloser, "inactiveSurfaceCloser");
        p.i(sessionConfigAdapter, "sessionConfigAdapter");
        this.threads = threads;
        this.cameraPipe = cameraPipe;
        this.inactiveSurfaceCloser = inactiveSurfaceCloser;
        this.sessionConfigAdapter = sessionConfigAdapter;
        this.lock = new Object();
        this.activeSurfaceMap = new LinkedHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ java.lang.Object l(androidx.camera.camera2.impl.UseCaseSurfaceManager r5, e9.InterfaceC4014c<? super java.lang.Boolean> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.camera.camera2.impl.UseCaseSurfaceManager$awaitSetupCompletion$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.camera.camera2.impl.UseCaseSurfaceManager$awaitSetupCompletion$1 r0 = (androidx.camera.camera2.impl.UseCaseSurfaceManager$awaitSetupCompletion$1) r0
            int r1 = r0.f10012c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10012c = r1
            goto L18
        L13:
            androidx.camera.camera2.impl.UseCaseSurfaceManager$awaitSetupCompletion$1 r0 = new androidx.camera.camera2.impl.UseCaseSurfaceManager$awaitSetupCompletion$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f10010a
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10012c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            kotlin.C4849c.b(r6)     // Catch: java.util.concurrent.CancellationException -> L4c
            return r6
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.C4849c.b(r6)
            java.lang.Object r6 = r5.lock
            monitor-enter(r6)
            Ua.Q<java.lang.Boolean> r2 = r5.setupDeferred     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L66
            Ua.u<Y8.t> r5 = r5.stopDeferred     // Catch: java.lang.Throwable -> L64
            if (r5 == 0) goto L41
            goto L66
        L41:
            monitor-exit(r6)
            r0.f10012c = r4     // Catch: java.util.concurrent.CancellationException -> L4c
            java.lang.Object r5 = r2.a1(r0)     // Catch: java.util.concurrent.CancellationException -> L4c
            if (r5 != r1) goto L4b
            return r1
        L4b:
            return r5
        L4c:
            t.b r5 = t.C5473b.f41865a
            java.lang.String r5 = "CXCP"
            boolean r5 = D.C0761b0.k(r5)
            if (r5 == 0) goto L5f
            java.lang.String r5 = t.C5473b.a()
            java.lang.String r6 = "Surface setup was cancelled"
            android.util.Log.w(r5, r6)
        L5f:
            java.lang.Boolean r5 = g9.C4109a.a(r3)
            return r5
        L64:
            r5 = move-exception
            goto L6c
        L66:
            java.lang.Boolean r5 = g9.C4109a.a(r3)     // Catch: java.lang.Throwable -> L64
            monitor-exit(r6)
            return r5
        L6c:
            monitor-exit(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseSurfaceManager.l(androidx.camera.camera2.impl.UseCaseSurfaceManager, e9.c):java.lang.Object");
    }

    public static /* synthetic */ Q p(UseCaseSurfaceManager useCaseSurfaceManager, CameraGraph cameraGraph, SessionConfigAdapter sessionConfigAdapter, Map map, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setupAsync");
        }
        if ((i10 & 8) != 0) {
            j10 = 5000;
        }
        return useCaseSurfaceManager.o(cameraGraph, sessionConfigAdapter, map, j10);
    }

    public static final t q(List list, Throwable th) {
        n.a(list);
        return t.f7040a;
    }

    @Override // w.C5711q.b
    public void a(Surface surface) {
        DeferrableSurface deferrableSurface;
        p.i(surface, "surface");
        synchronized (this.lock) {
            try {
                Map<Surface, ? extends DeferrableSurface> map = this.configuredSurfaceMap;
                if (map != null && (deferrableSurface = map.get(surface)) != null) {
                    if (!this.activeSurfaceMap.containsKey(surface)) {
                        C5473b c5473b = C5473b.f41865a;
                        if (C0761b0.f("CXCP")) {
                            Log.d(C5473b.TRUNCATED_TAG, "SurfaceActive " + deferrableSurface + " in " + this);
                        }
                        this.activeSurfaceMap.put(surface, deferrableSurface);
                        try {
                            deferrableSurface.l();
                        } catch (DeferrableSurface.SurfaceClosedException e10) {
                            C5473b c5473b2 = C5473b.f41865a;
                            if (C0761b0.k("CXCP")) {
                                Log.w(C5473b.TRUNCATED_TAG, "Error when " + surface + " going to increase the use count.", e10);
                            }
                            SessionConfigAdapter sessionConfigAdapter = this.sessionConfigAdapter;
                            DeferrableSurface deferrableSurfaceA = e10.a();
                            p.h(deferrableSurfaceA, "getDeferrableSurface(...)");
                            sessionConfigAdapter.q(deferrableSurfaceA);
                        }
                    }
                    t tVar = t.f7040a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w.C5711q.b
    public void b(Surface surface) {
        p.i(surface, "surface");
        synchronized (this.lock) {
            try {
                DeferrableSurface deferrableSurfaceRemove = this.activeSurfaceMap.remove(surface);
                if (deferrableSurfaceRemove != null) {
                    C5473b c5473b = C5473b.f41865a;
                    if (C0761b0.f("CXCP")) {
                        Log.d(C5473b.TRUNCATED_TAG, "SurfaceInactive " + deferrableSurfaceRemove + " in " + this);
                    }
                    this.inactiveSurfaceCloser.a(deferrableSurfaceRemove);
                    try {
                        deferrableSurfaceRemove.e();
                    } catch (IllegalStateException e10) {
                        C5473b c5473b2 = C5473b.f41865a;
                        if (C0761b0.k("CXCP")) {
                            Log.w(C5473b.TRUNCATED_TAG, "Error when " + surface + " going to decrease the use count.", e10);
                        }
                    }
                    s();
                    t tVar = t.f7040a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean j(List<? extends Surface> list) {
        return (list.isEmpty() || list.contains(null)) ? false : true;
    }

    public Object k(InterfaceC4014c<? super Boolean> interfaceC4014c) {
        return l(this, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.util.List<? extends androidx.camera.core.impl.DeferrableSurface> r5, long r6, e9.InterfaceC4014c<? super java.util.List<? extends android.view.Surface>> r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof androidx.camera.camera2.impl.UseCaseSurfaceManager$getSurfaces$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.camera.camera2.impl.UseCaseSurfaceManager$getSurfaces$1 r0 = (androidx.camera.camera2.impl.UseCaseSurfaceManager$getSurfaces$1) r0
            int r1 = r0.f10015c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10015c = r1
            goto L18
        L13:
            androidx.camera.camera2.impl.UseCaseSurfaceManager$getSurfaces$1 r0 = new androidx.camera.camera2.impl.UseCaseSurfaceManager$getSurfaces$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r4 = r0.f10013a
            java.lang.Object r8 = f9.C4063a.g()
            int r1 = r0.f10015c
            r2 = 1
            if (r1 == 0) goto L31
            if (r1 != r2) goto L29
            kotlin.C4849c.b(r4)
            goto L43
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.C4849c.b(r4)
            androidx.camera.camera2.impl.UseCaseSurfaceManager$getSurfaces$2 r4 = new androidx.camera.camera2.impl.UseCaseSurfaceManager$getSurfaces$2
            r1 = 0
            r4.<init>(r5, r1)
            r0.f10015c = r2
            java.lang.Object r4 = kotlinx.coroutines.TimeoutKt.e(r6, r4, r0)
            if (r4 != r8) goto L43
            return r8
        L43:
            java.util.List r4 = (java.util.List) r4
            if (r4 != 0) goto L4b
            java.util.List r4 = Z8.C1173v.m()
        L4b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.impl.UseCaseSurfaceManager.m(java.util.List, long, e9.c):java.lang.Object");
    }

    public final void n() {
        this.cameraPipe.c().b(this);
    }

    public final Q<Boolean> o(CameraGraph graph, SessionConfigAdapter sessionConfigAdapter, Map<DeferrableSurface, w.Q> surfaceToStreamMap, long timeoutMillis) {
        Q<Boolean> qA;
        p.i(graph, "graph");
        p.i(sessionConfigAdapter, "sessionConfigAdapter");
        p.i(surfaceToStreamMap, "surfaceToStreamMap");
        synchronized (this.lock) {
            try {
                if (this.setupDeferred != null) {
                    throw new IllegalStateException("Surfaces should only be set up once!");
                }
                if (this.stopDeferred != null) {
                    throw new IllegalStateException("Surfaces being setup after stopped!");
                }
                if (this.configuredSurfaceMap != null) {
                    throw new IllegalStateException("Check failed.");
                }
                final List<DeferrableSurface> listG = sessionConfigAdapter.g();
                try {
                    n.b(listG);
                    qA = C1060i.b(this.threads.getScope(), null, null, new UseCaseSurfaceManager$setupAsync$1$deferred$1(sessionConfigAdapter, this, listG, timeoutMillis, surfaceToStreamMap, graph, null), 3, null);
                    qA.J(new InterfaceC5074l() { // from class: t.v0
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj) {
                            return UseCaseSurfaceManager.q(listG, (Throwable) obj);
                        }
                    });
                    this.setupDeferred = qA;
                } catch (DeferrableSurface.SurfaceClosedException e10) {
                    C5473b c5473b = C5473b.f41865a;
                    if (C0761b0.k("CXCP")) {
                        Log.w(C5473b.TRUNCATED_TAG, "Failed to increment DeferrableSurfaces: Surfaces closed");
                    }
                    C1060i.d(this.threads.getScope(), null, null, new UseCaseSurfaceManager$setupAsync$1$4(sessionConfigAdapter, e10, null), 3, null);
                    qA = C1087w.a(Boolean.FALSE);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return qA;
    }

    public final Q<t> r() {
        InterfaceC1083u<t> interfaceC1083uC;
        synchronized (this.lock) {
            try {
                interfaceC1083uC = this.stopDeferred;
                if (interfaceC1083uC != null) {
                    C5473b c5473b = C5473b.f41865a;
                    if (C0761b0.k("CXCP")) {
                        Log.w(C5473b.TRUNCATED_TAG, "UseCaseSurfaceManager is already stopping!");
                    }
                } else {
                    Q<Boolean> q10 = this.setupDeferred;
                    if (q10 != null) {
                        kotlinx.coroutines.g.Y0(q10, null, 1, null);
                    }
                    this.inactiveSurfaceCloser.b();
                    this.configuredSurfaceMap = null;
                    interfaceC1083uC = C1087w.c(null, 1, null);
                    this.stopDeferred = interfaceC1083uC;
                    s();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return interfaceC1083uC;
    }

    public final void s() {
        synchronized (this.lock) {
            try {
                if (this.activeSurfaceMap.isEmpty() && this.configuredSurfaceMap == null) {
                    C5473b c5473b = C5473b.f41865a;
                    if (C0761b0.f("CXCP")) {
                        Log.d(C5473b.TRUNCATED_TAG, this + " remove surface listener");
                    }
                    this.cameraPipe.c().e(this);
                    InterfaceC1083u<t> interfaceC1083u = this.stopDeferred;
                    if (interfaceC1083u != null) {
                        interfaceC1083u.complete(t.f7040a);
                    }
                }
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
