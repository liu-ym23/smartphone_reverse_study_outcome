package o;

import D.C0761b0;
import K.AbstractC0889l;
import android.app.Application;
import android.content.Context;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.util.Log;
import android.util.Size;
import androidx.camera.camera2.compat.quirk.PreviewUnderExposureQuirk;
import androidx.camera.camera2.impl.a;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.l;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import r.C5193k;
import t.C5473b;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u000e\u0011\u0012\u000bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lo/o;", "Landroidx/camera/core/impl/UseCaseConfigFactory;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroidx/camera/core/impl/UseCaseConfigFactory$CaptureType;", "captureType", "", "captureMode", "Landroidx/camera/core/impl/Config;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/UseCaseConfigFactory$CaptureType;I)Landroidx/camera/core/impl/Config;", "Lt/Q;", Const.INTENT_KEY_PKGNAME, "Lt/Q;", "displayInfoManager", Const.INTENT_KEY_UMID, "c", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4983o implements UseCaseConfigFactory {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final t.Q displayInfoManager;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\u0006B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lo/o$a;", "LK/l;", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "captureCallback", "<init>", "(Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)V", Const.INTENT_KEY_APIKEY, "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "f", "()Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", Const.INTENT_KEY_PKGNAME, "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.o$a */
    public static final class a extends AbstractC0889l {

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final CameraCaptureSession.CaptureCallback captureCallback;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lo/o$a$a;", "", "<init>", "()V", "Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;", "captureCallback", "Lo/o$a;", Const.INTENT_KEY_APIKEY, "(Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;)Lo/o$a;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: o.o$a$a, reason: collision with other inner class name and from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final a a(CameraCaptureSession.CaptureCallback captureCallback) {
                kotlin.jvm.internal.p.i(captureCallback, "captureCallback");
                return new a(captureCallback, null);
            }

            public Companion() {
            }
        }

        public /* synthetic */ a(CameraCaptureSession.CaptureCallback captureCallback, kotlin.jvm.internal.i iVar) {
            this(captureCallback);
        }

        /* renamed from: f, reason: from getter */
        public final CameraCaptureSession.CaptureCallback getCaptureCallback() {
            return this.captureCallback;
        }

        public a(CameraCaptureSession.CaptureCallback captureCallback) {
            this.captureCallback = captureCallback;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lo/o$b;", "Landroidx/camera/core/impl/l$b;", "<init>", "()V", "Landroidx/camera/core/impl/z;", "config", "Landroidx/camera/core/impl/l$a;", "builder", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/z;Landroidx/camera/core/impl/l$a;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.o$b */
    public static class b implements l.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: b, reason: collision with root package name */
        public static final b f37422b = new b();

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lo/o$b$a;", "", "<init>", "()V", "Lo/o$b;", "INSTANCE", "Lo/o$b;", Const.INTENT_KEY_APIKEY, "()Lo/o$b;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: o.o$b$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final b a() {
                return b.f37422b;
            }

            public Companion() {
            }
        }

        @Override // androidx.camera.core.impl.l.b
        public void a(androidx.camera.core.impl.z<?> config, l.a builder) {
            kotlin.jvm.internal.p.i(config, "config");
            kotlin.jvm.internal.p.i(builder, "builder");
            androidx.camera.core.impl.l lVarU = config.u(null);
            Config configI0 = androidx.camera.core.impl.v.i0();
            kotlin.jvm.internal.p.h(configI0, "emptyBundle(...)");
            int iJ = androidx.camera.core.impl.l.b().j();
            if (lVarU != null) {
                iJ = lVarU.j();
                builder.a(lVarU.c());
                configI0 = lVarU.f();
                kotlin.jvm.internal.p.h(configI0, "getImplementationOptions(...)");
                builder.s(lVarU.l());
                builder.b(lVarU.i());
                List<DeferrableSurface> listH = lVarU.h();
                kotlin.jvm.internal.p.h(listH, "getSurfaces(...)");
                Iterator<T> it = listH.iterator();
                while (it.hasNext()) {
                    builder.f((DeferrableSurface) it.next());
                }
            }
            builder.o(configI0);
            androidx.camera.camera2.impl.a aVar = new androidx.camera.camera2.impl.a(config);
            builder.r(aVar.i0(iJ));
            CameraCaptureSession.CaptureCallback captureCallbackO0 = androidx.camera.camera2.impl.a.o0(aVar, null, 1, null);
            if (captureCallbackO0 != null) {
                builder.c(a.INSTANCE.a(captureCallbackO0));
            }
            builder.e(aVar.h0());
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0017¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lo/o$c;", "Landroidx/camera/core/impl/SessionConfig$e;", "<init>", "()V", "Landroid/util/Size;", "resolution", "Landroidx/camera/core/impl/z;", "config", "Landroidx/camera/core/impl/SessionConfig$b;", "builder", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/util/Size;Landroidx/camera/core/impl/z;Landroidx/camera/core/impl/SessionConfig$b;)V", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.o$c */
    public static final class c implements SessionConfig.e {

        /* renamed from: a, reason: collision with root package name */
        public static final c f37423a = new c();

        @Override // androidx.camera.core.impl.SessionConfig.e
        public void a(Size resolution, androidx.camera.core.impl.z<?> config, SessionConfig.b builder) {
            kotlin.jvm.internal.p.i(resolution, "resolution");
            kotlin.jvm.internal.p.i(config, "config");
            kotlin.jvm.internal.p.i(builder, "builder");
            SessionConfig sessionConfigP = config.p(null);
            Config configI0 = androidx.camera.core.impl.v.i0();
            kotlin.jvm.internal.p.h(configI0, "emptyBundle(...)");
            int iQ = SessionConfig.b().q();
            if (sessionConfigP != null) {
                iQ = sessionConfigP.q();
                builder.b(sessionConfigP.c());
                builder.d(sessionConfigP.m());
                builder.c(sessionConfigP.k());
                configI0 = sessionConfigP.g();
                kotlin.jvm.internal.p.h(configI0, "getImplementationOptions(...)");
            }
            builder.s(configI0);
            if (config instanceof androidx.camera.core.impl.w) {
                r.z.b(builder, resolution);
            }
            androidx.camera.camera2.impl.a aVar = new androidx.camera.camera2.impl.a(config);
            builder.x(aVar.i0(iQ));
            CameraDevice.StateCallback stateCallbackK0 = androidx.camera.camera2.impl.a.k0(aVar, null, 1, null);
            if (stateCallbackK0 != null) {
                builder.f(stateCallbackK0);
            }
            CameraCaptureSession.StateCallback stateCallbackQ0 = androidx.camera.camera2.impl.a.q0(aVar, null, 1, null);
            if (stateCallbackQ0 != null) {
                builder.k(stateCallbackQ0);
            }
            CameraCaptureSession.CaptureCallback captureCallbackO0 = androidx.camera.camera2.impl.a.o0(aVar, null, 1, null);
            if (captureCallbackO0 != null) {
                builder.e(a.INSTANCE.a(captureCallbackO0));
            }
            builder.v(config.F());
            builder.y(config.z());
            androidx.camera.core.impl.u uVarK0 = androidx.camera.core.impl.u.k0();
            String strM0 = androidx.camera.camera2.impl.a.m0(aVar, null, 1, null);
            if (strM0 != null) {
                uVarK0.t(androidx.camera.camera2.impl.a.f10037a0, strM0);
            }
            Long lS0 = androidx.camera.camera2.impl.a.s0(aVar, null, 1, null);
            if (lS0 != null) {
                uVarK0.t(androidx.camera.camera2.impl.a.f10034X, Long.valueOf(lS0.longValue()));
            }
            kotlin.jvm.internal.p.h(uVarK0, "apply(...)");
            builder.g(uVarK0);
            builder.g(aVar.h0());
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lo/o$d;", "Lo/o$b;", "<init>", "()V", "Landroidx/camera/core/impl/z;", "config", "Landroidx/camera/core/impl/l$a;", "builder", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroidx/camera/core/impl/z;Landroidx/camera/core/impl/l$a;)V", "c", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.o$d */
    public static final class d extends b {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name */
        public static final d f37425d = new d();

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lo/o$d$a;", "", "<init>", "()V", "Lo/o$d;", "INSTANCE", "Lo/o$d;", Const.INTENT_KEY_APIKEY, "()Lo/o$d;", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: o.o$d$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final d a() {
                return d.f37425d;
            }

            public Companion() {
            }
        }

        @Override // o.C4983o.b, androidx.camera.core.impl.l.b
        public void a(androidx.camera.core.impl.z<?> config, l.a builder) {
            kotlin.jvm.internal.p.i(config, "config");
            kotlin.jvm.internal.p.i(builder, "builder");
            super.a(config, builder);
            if (!(config instanceof androidx.camera.core.impl.q)) {
                throw new IllegalArgumentException("config is not ImageCaptureConfig");
            }
            a.C0131a c0131a = new a.C0131a();
            C5193k.a(c0131a, (androidx.camera.core.impl.q) config);
            builder.e(c0131a.c());
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: o.o$e */
    public static final /* synthetic */ class e {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37426a;

        static {
            int[] iArr = new int[UseCaseConfigFactory.CaptureType.values().length];
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.STREAM_SHARING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.METERING_REPEATING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.IMAGE_ANALYSIS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f37426a = iArr;
        }
    }

    public C4983o(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        this.displayInfoManager = t.Q.INSTANCE.a(context);
        if (context instanceof Application) {
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.h("CXCP")) {
                Log.i(C5473b.TRUNCATED_TAG, "The provided context (" + context + ") is application scoped and will be used to infer the default display for computing the default preview size, orientation, and default aspect ratio for UseCase outputs.");
            }
        }
        C5473b c5473b2 = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Created UseCaseConfigurationMap");
        }
    }

    @Override // androidx.camera.core.impl.UseCaseConfigFactory
    public Config a(UseCaseConfigFactory.CaptureType captureType, int captureMode) {
        kotlin.jvm.internal.p.i(captureType, "captureType");
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Creating config for " + captureType);
        }
        androidx.camera.core.impl.u uVarK0 = androidx.camera.core.impl.u.k0();
        kotlin.jvm.internal.p.h(uVarK0, "create(...)");
        SessionConfig.b bVar = new SessionConfig.b();
        int[] iArr = e.f37426a;
        switch (iArr[captureType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                bVar.x(1);
                break;
            case 6:
                bVar.x(q.f.f38470a.c(PreviewUnderExposureQuirk.class) != null ? 1 : 3);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        uVarK0.t(androidx.camera.core.impl.z.f11540A, bVar.o());
        l.a aVar = new l.a();
        switch (iArr[captureType.ordinal()]) {
            case 1:
                aVar.r(captureMode == 2 ? 5 : 2);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                aVar.r(1);
                break;
            case 6:
                aVar.r(q.f.f38470a.c(PreviewUnderExposureQuirk.class) != null ? 1 : 3);
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        uVarK0.t(androidx.camera.core.impl.z.f11541B, aVar.h());
        uVarK0.t(androidx.camera.core.impl.z.f11543D, captureType == UseCaseConfigFactory.CaptureType.IMAGE_CAPTURE ? d.INSTANCE.a() : b.INSTANCE.a());
        uVarK0.t(androidx.camera.core.impl.z.f11542C, c.f37423a);
        if (captureType == UseCaseConfigFactory.CaptureType.PREVIEW) {
            uVarK0.t(androidx.camera.core.impl.s.f11492w, this.displayInfoManager.k());
        }
        uVarK0.t(androidx.camera.core.impl.s.f11487r, Integer.valueOf(t.Q.j(this.displayInfoManager, false, 1, null).getRotation()));
        androidx.camera.core.impl.v vVarJ0 = androidx.camera.core.impl.v.j0(uVarK0);
        kotlin.jvm.internal.p.h(vVarJ0, "from(...)");
        return vVarJ0;
    }
}
