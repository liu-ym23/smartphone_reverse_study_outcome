package o;

import D.C0761b0;
import K.InterfaceC0897u;
import android.content.Context;
import android.os.Trace;
import android.util.Log;
import androidx.camera.camera2.pipe.h;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.f;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Arrays;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import t.C5473b;
import t.C5491s;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJC\u0010\u0015\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u0019\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lo/f;", "LK/u$b;", "Landroidx/camera/camera2/pipe/h;", "sharedCameraPipe", "Landroid/content/Context;", "sharedAppContext", "LK/O;", "sharedThreadConfig", "<init>", "(Landroidx/camera/camera2/pipe/h;Landroid/content/Context;LK/O;)V", "context", "threadConfig", "Landroidx/camera/core/CameraSelector;", "availableCamerasLimiter", "", "cameraOpenRetryMaxTimeoutInMs", "Landroidx/camera/core/f;", "cameraXConfig", "LP/i;", "streamSpecsCalculator", "LK/u;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;LK/O;Landroidx/camera/core/CameraSelector;JLandroidx/camera/core/f;LP/i;)LK/u;", "Lz/i;", "openRetryMaxTimeout", "e", "(Landroid/content/Context;LK/O;Lz/i;)Landroidx/camera/camera2/pipe/h;", "Landroidx/camera/camera2/pipe/h;", Const.INTENT_KEY_PKGNAME, "Landroid/content/Context;", "c", "LK/O;", "Lt/s;", Const.INTENT_KEY_UMID, "Lt/s;", "sharedInteropCallbacks", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4974f implements InterfaceC0897u.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.h sharedCameraPipe;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Context sharedAppContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final K.O sharedThreadConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C5491s sharedInteropCallbacks = new C5491s();

    public C4974f(androidx.camera.camera2.pipe.h hVar, Context context, K.O o10) {
        this.sharedCameraPipe = hVar;
        this.sharedAppContext = context;
        this.sharedThreadConfig = o10;
    }

    public static final androidx.camera.camera2.pipe.h f(C4974f c4974f, Context context, K.O o10, z.i iVar) {
        if (c4974f.sharedCameraPipe == null) {
            return c4974f.e(context, o10, iVar);
        }
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "Using shared a " + c4974f.sharedCameraPipe + " instance.");
        }
        return c4974f.sharedCameraPipe;
    }

    @Override // K.InterfaceC0897u.b
    public InterfaceC0897u a(final Context context, final K.O threadConfig, CameraSelector availableCamerasLimiter, long cameraOpenRetryMaxTimeoutInMs, androidx.camera.core.f cameraXConfig, P.i streamSpecsCalculator) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(threadConfig, "threadConfig");
        kotlin.jvm.internal.p.i(streamSpecsCalculator, "streamSpecsCalculator");
        final z.i iVarA = cameraOpenRetryMaxTimeoutInMs == -1 ? null : z.i.a(z.i.c(cameraOpenRetryMaxTimeoutInMs));
        Y8.h hVarB = C4848b.b(new InterfaceC5063a() { // from class: o.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C4974f.f(this.f37372a, context, threadConfig, iVarA);
            }
        });
        Context context2 = this.sharedAppContext;
        Context context3 = context2 == null ? context : context2;
        K.O o10 = this.sharedThreadConfig;
        K.O o11 = o10 == null ? threadConfig : o10;
        C5491s c5491s = this.sharedInteropCallbacks;
        if (cameraXConfig == null) {
            cameraXConfig = new f.a().a();
            kotlin.jvm.internal.p.h(cameraXConfig, "build(...)");
        }
        return new C4972d(hVarB, context3, o11, c5491s, availableCamerasLimiter, streamSpecsCalculator, cameraXConfig);
    }

    public final androidx.camera.camera2.pipe.h e(Context context, K.O threadConfig, z.i openRetryMaxTimeout) {
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection("Create CameraPipe");
            z.t tVar = new z.t();
            z.y yVar = z.y.f44525a;
            long jA = tVar.a();
            Context contextF = M.e.f(context);
            kotlin.jvm.internal.p.h(contextF, "getPersistentApplicationContext(...)");
            androidx.camera.camera2.pipe.h hVarA = androidx.camera.camera2.pipe.j.a(new h.Config(contextF, new h.ThreadConfig(null, null, null, N.a.f(threadConfig.b()), null, null, null, 119, null), null, null, new h.CameraInteropConfig(this.sharedInteropCallbacks.get_deviceStateCallback(), this.sharedInteropCallbacks.b(), openRetryMaxTimeout, null), null, null, null, 236, null));
            C5473b c5473b = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                String str = C5473b.TRUNCATED_TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Created CameraPipe in ");
                String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(z.i.c(tVar.a() - jA) / 1000000.0d)}, 1));
                kotlin.jvm.internal.p.h(str2, "format(...)");
                sb2.append(str2);
                Log.d(str, sb2.toString());
            }
            return hVarA;
        } finally {
            Trace.endSection();
        }
    }
}
