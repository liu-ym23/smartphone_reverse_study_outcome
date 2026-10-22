package androidx.camera.core;

import K.InterfaceC0896t;
import K.InterfaceC0897u;
import K.t0;
import android.os.Handler;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.v;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class f implements P.m<CameraX> {

    /* renamed from: S, reason: collision with root package name */
    public static final Config.a<InterfaceC0897u.b> f11287S = Config.a.a("camerax.core.appConfig.cameraFactoryProvider", InterfaceC0897u.b.class);

    /* renamed from: T, reason: collision with root package name */
    public static final Config.a<InterfaceC0896t.a> f11288T = Config.a.a("camerax.core.appConfig.deviceSurfaceManagerProvider", InterfaceC0896t.a.class);

    /* renamed from: U, reason: collision with root package name */
    public static final Config.a<UseCaseConfigFactory.b> f11289U = Config.a.a("camerax.core.appConfig.useCaseConfigFactoryProvider", UseCaseConfigFactory.b.class);

    /* renamed from: V, reason: collision with root package name */
    public static final Config.a<Executor> f11290V = Config.a.a("camerax.core.appConfig.cameraExecutor", Executor.class);

    /* renamed from: W, reason: collision with root package name */
    public static final Config.a<Handler> f11291W = Config.a.a("camerax.core.appConfig.schedulerHandler", Handler.class);

    /* renamed from: X, reason: collision with root package name */
    public static final Config.a<Integer> f11292X = Config.a.a("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE);

    /* renamed from: Y, reason: collision with root package name */
    public static final Config.a<CameraSelector> f11293Y = Config.a.a("camerax.core.appConfig.availableCamerasLimiter", CameraSelector.class);

    /* renamed from: Z, reason: collision with root package name */
    public static final Config.a<Long> f11294Z = Config.a.a("camerax.core.appConfig.cameraOpenRetryMaxTimeoutInMillisWhileResuming", Long.TYPE);

    /* renamed from: a0, reason: collision with root package name */
    public static final Config.a<k> f11295a0 = Config.a.a("camerax.core.appConfig.cameraProviderInitRetryPolicy", k.class);

    /* renamed from: b0, reason: collision with root package name */
    public static final Config.a<t0> f11296b0 = Config.a.a("camerax.core.appConfig.quirksSettings", t0.class);

    /* renamed from: c0, reason: collision with root package name */
    public static final Config.a<Boolean> f11297c0 = Config.a.a("camerax.core.appConfig.repeatingStreamForced", Boolean.TYPE);

    /* renamed from: R, reason: collision with root package name */
    public final v f11298R;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final u f11299a;

        public a() {
            this(u.k0());
        }

        public f a() {
            return new f(v.j0(this.f11299a));
        }

        public t b() {
            return this.f11299a;
        }

        public a c(InterfaceC0897u.b bVar) {
            b().t(f.f11287S, bVar);
            return this;
        }

        public a d(InterfaceC0896t.a aVar) {
            b().t(f.f11288T, aVar);
            return this;
        }

        public a e(boolean z10) {
            b().t(f.f11297c0, Boolean.valueOf(z10));
            return this;
        }

        public a f(Class<CameraX> cls) {
            b().t(P.m.f5354c, cls);
            if (b().g(P.m.f5353b, null) == null) {
                g(cls.getCanonicalName() + O6.l.DATE_SEPARATOR + UUID.randomUUID());
            }
            return this;
        }

        public a g(String str) {
            b().t(P.m.f5353b, str);
            return this;
        }

        public a h(UseCaseConfigFactory.b bVar) {
            b().t(f.f11289U, bVar);
            return this;
        }

        public a(u uVar) {
            this.f11299a = uVar;
            Class cls = (Class) uVar.g(P.m.f5354c, null);
            if (cls == null || cls.equals(CameraX.class)) {
                f(CameraX.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }
    }

    public interface b {
        f getCameraXConfig();
    }

    public f(v vVar) {
        this.f11298R = vVar;
    }

    @Override // androidx.camera.core.impl.x
    public Config getConfig() {
        return this.f11298R;
    }

    public CameraSelector h0(CameraSelector cameraSelector) {
        return (CameraSelector) this.f11298R.g(f11293Y, cameraSelector);
    }

    public Executor i0(Executor executor) {
        return (Executor) this.f11298R.g(f11290V, executor);
    }

    public InterfaceC0897u.b j0(InterfaceC0897u.b bVar) {
        return (InterfaceC0897u.b) this.f11298R.g(f11287S, bVar);
    }

    public long k0() {
        return ((Long) this.f11298R.g(f11294Z, -1L)).longValue();
    }

    public k l0() {
        k kVar = (k) this.f11298R.g(f11295a0, k.f11618b);
        Objects.requireNonNull(kVar);
        return kVar;
    }

    public InterfaceC0896t.a m0(InterfaceC0896t.a aVar) {
        return (InterfaceC0896t.a) this.f11298R.g(f11288T, aVar);
    }

    public t0 n0() {
        return (t0) this.f11298R.g(f11296b0, null);
    }

    public Handler o0(Handler handler) {
        return (Handler) this.f11298R.g(f11291W, handler);
    }

    public UseCaseConfigFactory.b p0(UseCaseConfigFactory.b bVar) {
        return (UseCaseConfigFactory.b) this.f11298R.g(f11289U, bVar);
    }

    public boolean q0() {
        return ((Boolean) this.f11298R.g(f11297c0, Boolean.TRUE)).booleanValue();
    }
}
