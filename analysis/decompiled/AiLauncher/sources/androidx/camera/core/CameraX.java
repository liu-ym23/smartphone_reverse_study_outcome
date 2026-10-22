package androidx.camera.core;

import D.C0761b0;
import D.ExecutorC0775l;
import D.InterfaceC0780q;
import D.r;
import K.InterfaceC0896t;
import K.InterfaceC0897u;
import K.K;
import K.N;
import K.O;
import K.t0;
import K.u0;
import K.v0;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.camera.core.CameraX;
import androidx.camera.core.f;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraValidator;
import androidx.camera.core.impl.MetadataHolderService;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.k;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.C4848b;
import m.InterfaceC4887a;
import o1.C4996a;
import p9.InterfaceC5063a;

/* loaded from: classes.dex */
public final class CameraX {

    /* renamed from: s, reason: collision with root package name */
    public static final Object f11150s = new Object();

    /* renamed from: t, reason: collision with root package name */
    public static final SparseArray<Integer> f11151t = new SparseArray<>();

    /* renamed from: a, reason: collision with root package name */
    public final N f11152a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11153b;

    /* renamed from: c, reason: collision with root package name */
    public final f f11154c;

    /* renamed from: d, reason: collision with root package name */
    public final Executor f11155d;

    /* renamed from: e, reason: collision with root package name */
    public final Handler f11156e;

    /* renamed from: f, reason: collision with root package name */
    public final HandlerThread f11157f;

    /* renamed from: g, reason: collision with root package name */
    public InterfaceC0897u f11158g;

    /* renamed from: h, reason: collision with root package name */
    public InterfaceC0896t f11159h;

    /* renamed from: i, reason: collision with root package name */
    public UseCaseConfigFactory f11160i;

    /* renamed from: j, reason: collision with root package name */
    public P.i f11161j;

    /* renamed from: k, reason: collision with root package name */
    public InterfaceC0780q f11162k;

    /* renamed from: l, reason: collision with root package name */
    public final k f11163l;

    /* renamed from: m, reason: collision with root package name */
    public final InterfaceFutureC4095a<Void> f11164m;

    /* renamed from: n, reason: collision with root package name */
    public final K f11165n;

    /* renamed from: o, reason: collision with root package name */
    public final Y8.h<l> f11166o;

    /* renamed from: p, reason: collision with root package name */
    public InternalInitState f11167p;

    /* renamed from: q, reason: collision with root package name */
    public InterfaceFutureC4095a<Void> f11168q;

    /* renamed from: r, reason: collision with root package name */
    public final Integer f11169r;

    public enum InternalInitState {
        UNINITIALIZED,
        INITIALIZING,
        INITIALIZING_ERROR,
        INITIALIZED,
        SHUTDOWN
    }

    public CameraX(Context context, f.b bVar) {
        this(context, bVar, new v0());
    }

    public static /* synthetic */ void a(CameraX cameraX, CallbackToFutureAdapter.a aVar) {
        cameraX.f11158g.shutdown();
        if (cameraX.f11157f != null) {
            Executor executor = cameraX.f11155d;
            if (executor instanceof ExecutorC0775l) {
                ((ExecutorC0775l) executor).g();
            }
            cameraX.f11157f.quit();
        }
        aVar.c(null);
    }

    public static /* synthetic */ l b(Context context) {
        return new l(context);
    }

    public static /* synthetic */ Object c(final CameraX cameraX, final CallbackToFutureAdapter.a aVar) {
        cameraX.f11165n.Q();
        if (cameraX.f11166o.isInitialized()) {
            cameraX.f11166o.getValue().f();
        }
        cameraX.f11152a.k().a(new Runnable() { // from class: D.v
            @Override // java.lang.Runnable
            public final void run() {
                CameraX.a(this.f2175a, aVar);
            }
        }, cameraX.f11155d);
        return "CameraX shutdownInternal";
    }

    public static /* synthetic */ Object d(CameraX cameraX, Context context, CallbackToFutureAdapter.a aVar) {
        cameraX.p(cameraX.f11155d, SystemClock.elapsedRealtime(), 1, context, aVar);
        return "CameraX initInternal";
    }

    public static /* synthetic */ void f(final CameraX cameraX, final Context context, final Executor executor, final int i10, final CallbackToFutureAdapter.a aVar, final long j10) {
        cameraX.getClass();
        C4996a.a("CX:initAndRetryRecursively");
        try {
            InterfaceC0897u.b bVarJ0 = cameraX.f11154c.j0(null);
            if (bVarJ0 == null) {
                throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory."));
            }
            O oA = O.a(cameraX.f11155d, cameraX.f11156e);
            CameraSelector cameraSelectorH0 = cameraX.f11154c.h0(null);
            CameraValidator cameraValidatorA = CameraValidator.a(context, cameraSelectorH0);
            long jK0 = cameraX.f11154c.k0();
            UseCaseConfigFactory.b bVarP0 = cameraX.f11154c.p0(null);
            if (bVarP0 == null) {
                throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory."));
            }
            cameraX.f11160i = bVarP0.a(context);
            androidx.camera.core.internal.b bVar = new androidx.camera.core.internal.b(cameraX.f11160i, null);
            cameraX.f11161j = bVar;
            cameraX.f11158g = bVarJ0.a(context, oA, cameraSelectorH0, jK0, cameraX.f11154c, bVar);
            InterfaceC0896t.a aVarM0 = cameraX.f11154c.m0(null);
            if (aVarM0 == null) {
                throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager."));
            }
            InterfaceC0896t interfaceC0896tA = aVarM0.a(context, cameraX.f11158g.f(), cameraX.f11158g.c());
            cameraX.f11159h = interfaceC0896tA;
            cameraX.f11161j.a(interfaceC0896tA);
            if (executor instanceof ExecutorC0775l) {
                ((ExecutorC0775l) executor).i(cameraX.f11158g);
            }
            cameraX.f11152a.n(cameraX.f11158g);
            E.a aVarG = cameraX.f11158g.g();
            aVarG.g(cameraX.f11152a);
            cameraX.f11162k = new r(cameraX.f11152a, aVarG, cameraX.f11160i, cameraX.f11161j);
            Iterator<CameraInternal> it = cameraX.f11152a.m().iterator();
            while (it.hasNext()) {
                it.next().getCameraInfo().x(cameraX.f11162k);
            }
            cameraX.f11165n.R(cameraValidatorA, cameraX.f11158g, cameraX.f11152a);
            cameraX.f11165n.v(cameraX.f11159h);
            cameraX.f11165n.v(cameraX.f11158g.g());
            cameraValidatorA.c(cameraX.f11152a);
            if (i10 > 1) {
                cameraX.u(null);
            }
            cameraX.r();
            aVar.c(null);
        } catch (InitializationException | CameraValidator.CameraIdListIncorrectException | RuntimeException e10) {
            androidx.camera.core.impl.i iVar = new androidx.camera.core.impl.i(j10, i10, e10);
            k.c cVarB = cameraX.f11163l.b(iVar);
            cameraX.u(iVar);
            if (!cVarB.d() || i10 >= Integer.MAX_VALUE) {
                synchronized (cameraX.f11153b) {
                    cameraX.f11167p = InternalInitState.INITIALIZING_ERROR;
                    if (cVarB.c()) {
                        cameraX.r();
                        aVar.c(null);
                    } else if (e10 instanceof CameraValidator.CameraIdListIncorrectException) {
                        String str = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((CameraValidator.CameraIdListIncorrectException) e10).getAvailableCameraCount();
                        C0761b0.d("CameraX", str, e10);
                        aVar.f(new InitializationException(new CameraUnavailableException(3, str)));
                    } else if (e10 instanceof InitializationException) {
                        aVar.f(e10);
                    } else {
                        aVar.f(new InitializationException(e10));
                    }
                }
            } else {
                C0761b0.p("CameraX", "Retry init. Start time " + j10 + " current time " + SystemClock.elapsedRealtime(), e10);
                x0.f.b(cameraX.f11156e, new Runnable() { // from class: D.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2187a.p(executor, j10, i10 + 1, context, aVar);
                    }
                }, "retry_token", cVarB.b());
            }
            cameraX.f11165n.Q();
        } finally {
            C4996a.b();
        }
    }

    public static void g(Integer num) {
        synchronized (f11150s) {
            try {
                if (num == null) {
                    return;
                }
                SparseArray<Integer> sparseArray = f11151t;
                int iIntValue = sparseArray.get(num.intValue()).intValue() - 1;
                if (iIntValue == 0) {
                    sparseArray.remove(num.intValue());
                } else {
                    sparseArray.put(num.intValue(), Integer.valueOf(iIntValue));
                }
                v();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static f.b l(Context context) {
        ComponentCallbacks2 componentCallbacks2A = M.e.a(context);
        if (componentCallbacks2A instanceof f.b) {
            return (f.b) componentCallbacks2A;
        }
        try {
            Context contextF = M.e.f(context);
            Bundle bundle = contextF.getPackageManager().getServiceInfo(new ComponentName(contextF, (Class<?>) MetadataHolderService.class), 640).metaData;
            String string = bundle != null ? bundle.getString("androidx.camera.core.impl.MetadataHolderService.DEFAULT_CONFIG_PROVIDER") : null;
            if (string != null) {
                return (f.b) Class.forName(string).getDeclaredConstructor(null).newInstance(null);
            }
            C0761b0.c("CameraX", "No default CameraXConfig.Provider specified in meta-data. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            return null;
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e10) {
            C0761b0.d("CameraX", "Failed to retrieve default CameraXConfig.Provider from meta-data", e10);
            return null;
        }
    }

    public static void o(Integer num) {
        synchronized (f11150s) {
            try {
                if (num == null) {
                    return;
                }
                B0.h.c(num.intValue(), 3, 6, "minLogLevel");
                SparseArray<Integer> sparseArray = f11151t;
                sparseArray.put(num.intValue(), Integer.valueOf(sparseArray.get(num.intValue()) != null ? 1 + sparseArray.get(num.intValue()).intValue() : 1));
                v();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void v() {
        SparseArray<Integer> sparseArray = f11151t;
        if (sparseArray.size() == 0) {
            C0761b0.l();
            return;
        }
        if (sparseArray.get(3) != null) {
            C0761b0.m(3);
            return;
        }
        if (sparseArray.get(4) != null) {
            C0761b0.m(4);
        } else if (sparseArray.get(5) != null) {
            C0761b0.m(5);
        } else if (sparseArray.get(6) != null) {
            C0761b0.m(6);
        }
    }

    public static void w(Context context, t0 t0Var, InterfaceC4887a<Context, t0> interfaceC4887a) {
        if (t0Var != null) {
            C0761b0.a("CameraX", "QuirkSettings from CameraXConfig: " + t0Var);
        } else {
            t0Var = interfaceC4887a.apply(context);
            C0761b0.a("CameraX", "QuirkSettings from app metadata: " + t0Var);
        }
        if (t0Var == null) {
            t0Var = u0.f4015b;
            C0761b0.a("CameraX", "QuirkSettings by default: " + t0Var);
        }
        u0.b().d(t0Var);
    }

    public K h() {
        return this.f11165n;
    }

    public InterfaceC0897u i() {
        InterfaceC0897u interfaceC0897u = this.f11158g;
        if (interfaceC0897u != null) {
            return interfaceC0897u;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public N j() {
        return this.f11152a;
    }

    public InterfaceC0780q k() {
        InterfaceC0780q interfaceC0780q = this.f11162k;
        if (interfaceC0780q != null) {
            return interfaceC0780q;
        }
        throw new IllegalStateException("CameraX not initialized yet.");
    }

    public InterfaceFutureC4095a<Void> m() {
        return this.f11164m;
    }

    public l n() {
        return this.f11166o.getValue();
    }

    public final void p(final Executor executor, final long j10, final int i10, final Context context, final CallbackToFutureAdapter.a<Void> aVar) {
        executor.execute(new Runnable() { // from class: D.w
            @Override // java.lang.Runnable
            public final void run() {
                CameraX.f(this.f2179a, context, executor, i10, aVar, j10);
            }
        });
    }

    public final InterfaceFutureC4095a<Void> q(final Context context) {
        InterfaceFutureC4095a<Void> interfaceFutureC4095aA;
        synchronized (this.f11153b) {
            B0.h.i(this.f11167p == InternalInitState.UNINITIALIZED, "CameraX.initInternal() should only be called once per instance");
            this.f11167p = InternalInitState.INITIALIZING;
            interfaceFutureC4095aA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: D.t
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                public final Object a(CallbackToFutureAdapter.a aVar) {
                    return CameraX.d(this.f2168a, context, aVar);
                }
            });
        }
        return interfaceFutureC4095aA;
    }

    public final void r() {
        synchronized (this.f11153b) {
            this.f11167p = InternalInitState.INITIALIZED;
        }
    }

    public InterfaceFutureC4095a<Void> s() {
        return t();
    }

    public final InterfaceFutureC4095a<Void> t() {
        synchronized (this.f11153b) {
            try {
                this.f11156e.removeCallbacksAndMessages("retry_token");
                int iOrdinal = this.f11167p.ordinal();
                if (iOrdinal == 0) {
                    this.f11167p = InternalInitState.SHUTDOWN;
                    return O.f.h(null);
                }
                if (iOrdinal == 1) {
                    throw new IllegalStateException("CameraX could not be shutdown when it is initializing.");
                }
                if (iOrdinal == 2 || iOrdinal == 3) {
                    this.f11167p = InternalInitState.SHUTDOWN;
                    g(this.f11169r);
                    this.f11168q = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: D.u
                        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
                        public final Object a(CallbackToFutureAdapter.a aVar) {
                            return CameraX.c(this.f2172a, aVar);
                        }
                    });
                }
                return this.f11168q;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void u(k.b bVar) {
        if (C4996a.c()) {
            C4996a.d("CX:CameraProvider-RetryStatus", bVar != null ? bVar.getStatus() : -1);
        }
    }

    public CameraX(Context context, f.b bVar, InterfaceC4887a<Context, t0> interfaceC4887a) {
        this.f11152a = new N();
        this.f11153b = new Object();
        this.f11167p = InternalInitState.UNINITIALIZED;
        this.f11168q = O.f.h(null);
        final Context contextF = M.e.f(context);
        if (bVar != null) {
            this.f11154c = bVar.getCameraXConfig();
        } else {
            f.b bVarL = l(context);
            if (bVarL == null) {
                throw new IllegalStateException("CameraX is not configured properly. The most likely cause is you did not include a default implementation in your build such as 'camera-camera2'.");
            }
            this.f11154c = bVarL.getCameraXConfig();
        }
        w(contextF, this.f11154c.n0(), interfaceC4887a);
        Executor executorI0 = this.f11154c.i0(null);
        Handler handlerO0 = this.f11154c.o0(null);
        executorI0 = executorI0 == null ? new ExecutorC0775l() : executorI0;
        this.f11155d = executorI0;
        if (handlerO0 == null) {
            HandlerThread handlerThread = new HandlerThread("CameraX-scheduler", 10);
            this.f11157f = handlerThread;
            handlerThread.start();
            this.f11156e = x0.f.a(handlerThread.getLooper());
        } else {
            this.f11157f = null;
            this.f11156e = handlerO0;
        }
        Integer num = (Integer) this.f11154c.g(f.f11292X, null);
        this.f11169r = num;
        o(num);
        this.f11163l = new k.a(this.f11154c.l0()).a();
        this.f11165n = new K(executorI0, N.a.e(this.f11156e));
        this.f11166o = C4848b.b(new InterfaceC5063a() { // from class: D.s
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return CameraX.b(contextF);
            }
        });
        this.f11164m = q(contextF);
    }
}
