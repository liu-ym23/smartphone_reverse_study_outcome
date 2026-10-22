package androidx.camera.camera2.impl;

import K.C0874b0;
import P.m;
import Y8.t;
import Z8.C1172u;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.r;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import o.C4983o;
import t.InterfaceC5494v;
import t.Q;
import t.Z;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u000278B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001dH\u0003¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u00069"}, d2 = {"Landroidx/camera/camera2/impl/e;", "Landroidx/camera/core/UseCase;", "Lt/v;", "cameraProperties", "Landroidx/camera/camera2/impl/e$b;", "config", "Lt/Q;", "displayInfoManager", "<init>", "(Lt/v;Landroidx/camera/camera2/impl/e$b;Lt/Q;)V", "", "applyDefaultConfig", "Landroidx/camera/core/impl/UseCaseConfigFactory;", "factory", "n0", "(ZLandroidx/camera/core/impl/UseCaseConfigFactory;)Landroidx/camera/camera2/impl/e$b;", "Landroidx/camera/core/impl/Config;", "Landroidx/camera/camera2/impl/e$a;", "o0", "(Landroidx/camera/core/impl/Config;)Landroidx/camera/camera2/impl/e$a;", "Landroidx/camera/core/impl/y;", "primaryStreamSpec", "secondaryStreamSpec", "U", "(Landroidx/camera/core/impl/y;Landroidx/camera/core/impl/y;)Landroidx/camera/core/impl/y;", "LY8/t;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()V", "p0", "Landroid/util/Size;", "resolution", "Landroidx/camera/core/impl/SessionConfig$b;", "l0", "(Landroid/util/Size;)Landroidx/camera/core/impl/SessionConfig$b;", "Landroidx/camera/core/impl/DeferrableSurface;", "j0", "(Landroid/util/Size;)Landroidx/camera/core/impl/DeferrableSurface;", "v", "Lt/v;", "w", "Lt/Q;", "x", "Landroid/util/Size;", "meteringSurfaceSize", "", "y", "Ljava/lang/Object;", "deferrableSurfaceLock", "Landroidx/camera/core/impl/SessionConfig$c;", "z", "Landroidx/camera/core/impl/SessionConfig$c;", "closeableErrorListener", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroidx/camera/core/impl/DeferrableSurface;", "deferrableSurface", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class e extends UseCase {

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public DeferrableSurface deferrableSurface;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5494v cameraProperties;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public final Q displayInfoManager;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final Size meteringSurfaceSize;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final Object deferrableSurfaceLock;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public SessionConfig.c closeableErrorListener;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/camera/camera2/impl/e$a;", "Landroidx/camera/core/impl/z$b;", "Landroidx/camera/camera2/impl/e;", "Landroidx/camera/camera2/impl/e$b;", "Lt/v;", "cameraProperties", "Lt/Q;", "displayInfoManager", "<init>", "(Lt/v;Lt/Q;)V", "Landroidx/camera/core/impl/u;", "c", "()Landroidx/camera/core/impl/u;", "e", "()Landroidx/camera/camera2/impl/e$b;", Const.INTENT_KEY_PKGNAME, "()Landroidx/camera/camera2/impl/e;", Const.INTENT_KEY_APIKEY, "Lt/v;", "Lt/Q;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements z.b<e, b, a> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5494v cameraProperties;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Q displayInfoManager;

        public a(InterfaceC5494v cameraProperties, Q displayInfoManager) {
            p.i(cameraProperties, "cameraProperties");
            p.i(displayInfoManager, "displayInfoManager");
            this.cameraProperties = cameraProperties;
            this.displayInfoManager = displayInfoManager;
        }

        public e b() {
            return new e(this.cameraProperties, d(), this.displayInfoManager);
        }

        @Override // D.C
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public u a() {
            u uVarK0 = u.k0();
            p.h(uVarK0, "create(...)");
            return uVarK0;
        }

        @Override // androidx.camera.core.impl.z.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b d() {
            return new b();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/camera/camera2/impl/e$b;", "Landroidx/camera/core/impl/z;", "Landroidx/camera/camera2/impl/e;", "Landroidx/camera/core/impl/r;", "<init>", "()V", "Landroidx/camera/core/impl/UseCaseConfigFactory$CaptureType;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()Landroidx/camera/core/impl/UseCaseConfigFactory$CaptureType;", "Landroidx/camera/core/impl/u;", "h0", "()Landroidx/camera/core/impl/u;", "", "o", "()I", "R", "Landroidx/camera/core/impl/u;", "config", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements z<e>, r {

        /* renamed from: R, reason: collision with root package name and from kotlin metadata */
        public final u config;

        public b() {
            u uVarK0 = u.k0();
            uVarK0.t(z.f11542C, C4983o.c.f37423a);
            uVarK0.t(m.f5353b, "MeteringRepeating");
            uVarK0.t(z.f11551L, UseCaseConfigFactory.CaptureType.METERING_REPEATING);
            p.h(uVarK0, "apply(...)");
            this.config = uVarK0;
        }

        @Override // androidx.camera.core.impl.z
        public UseCaseConfigFactory.CaptureType V() {
            return UseCaseConfigFactory.CaptureType.METERING_REPEATING;
        }

        @Override // androidx.camera.core.impl.x
        /* renamed from: h0, reason: from getter */
        public u getConfig() {
            return this.config;
        }

        @Override // androidx.camera.core.impl.r
        public int o() {
            return 34;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(InterfaceC5494v cameraProperties, b config, Q displayInfoManager) {
        super(config);
        p.i(cameraProperties, "cameraProperties");
        p.i(config, "config");
        p.i(displayInfoManager, "displayInfoManager");
        this.cameraProperties = cameraProperties;
        this.displayInfoManager = displayInfoManager;
        this.meteringSurfaceSize = Z.c(cameraProperties, displayInfoManager);
        this.deferrableSurfaceLock = new Object();
    }

    public static final void k0(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    public static final void m0(e eVar, Size size, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        p.i(sessionConfig, "<unused var>");
        p.i(sessionError, "<unused var>");
        eVar.e0(C1172u.e(eVar.l0(size).o()));
        eVar.L();
    }

    @Override // androidx.camera.core.UseCase
    public y U(y primaryStreamSpec, y secondaryStreamSpec) {
        p.i(primaryStreamSpec, "primaryStreamSpec");
        e0(C1172u.e(l0(this.meteringSurfaceSize).o()));
        y yVarA = primaryStreamSpec.i().f(this.meteringSurfaceSize).a();
        p.h(yVarA, "build(...)");
        return yVarA;
    }

    @Override // androidx.camera.core.UseCase
    public void V() {
        SessionConfig.c cVar = this.closeableErrorListener;
        if (cVar != null) {
            cVar.b();
        }
        this.closeableErrorListener = null;
        synchronized (this.deferrableSurfaceLock) {
            try {
                DeferrableSurface deferrableSurface = this.deferrableSurface;
                if (deferrableSurface != null) {
                    deferrableSurface.d();
                }
                this.deferrableSurface = null;
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final DeferrableSurface j0(Size resolution) {
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(resolution.getWidth(), resolution.getHeight());
        final Surface surface = new Surface(surfaceTexture);
        DeferrableSurface deferrableSurface = this.deferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.d();
        }
        C0874b0 c0874b0 = new C0874b0(surface, resolution, p());
        this.deferrableSurface = c0874b0;
        c0874b0.k().a(new Runnable() { // from class: t.Y
            @Override // java.lang.Runnable
            public final void run() {
                androidx.camera.camera2.impl.e.k0(surface, surfaceTexture);
            }
        }, N.a.a());
        return c0874b0;
    }

    public final SessionConfig.b l0(final Size resolution) {
        DeferrableSurface deferrableSurfaceJ0;
        synchronized (this.deferrableSurfaceLock) {
            deferrableSurfaceJ0 = j0(resolution);
        }
        SessionConfig.c cVar = this.closeableErrorListener;
        if (cVar != null) {
            cVar.b();
        }
        SessionConfig.c cVar2 = new SessionConfig.c(new SessionConfig.d() { // from class: t.X
            @Override // androidx.camera.core.impl.SessionConfig.d
            public final void a(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
                androidx.camera.camera2.impl.e.m0(this.f41860a, resolution, sessionConfig, sessionError);
            }
        });
        this.closeableErrorListener = cVar2;
        SessionConfig.b bVarP = SessionConfig.b.p(new b(), resolution);
        p.h(bVarP, "createFrom(...)");
        bVarP.x(1);
        bVarP.l(deferrableSurfaceJ0);
        bVarP.q(cVar2);
        return bVarP;
    }

    @Override // androidx.camera.core.UseCase
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b m(boolean applyDefaultConfig, UseCaseConfigFactory factory) {
        p.i(factory, "factory");
        return new a(this.cameraProperties, this.displayInfoManager).d();
    }

    @Override // androidx.camera.core.UseCase
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public a D(Config config) {
        p.i(config, "config");
        return new a(this.cameraProperties, this.displayInfoManager);
    }

    public final void p0() {
        f0(y.a(Z.f41864a).a(), null);
    }
}
