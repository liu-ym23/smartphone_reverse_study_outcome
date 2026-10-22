package y;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.os.Trace;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.h;
import androidx.camera.camera2.pipe.internal.CameraBackendsImpl;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.JobKt__JobKt;
import w.C5699e;
import w.C5711q;
import w.InterfaceC5698d;
import w.InterfaceC5700f;
import w.InterfaceC5702h;
import x.C5813f;
import x.s0;
import y.AbstractC5910v;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b!\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Ly/v;", "", Const.INTENT_KEY_APIKEY, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: y.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5910v {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00102\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u001d2\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001e\u0010\u001fJA\u0010%\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\b\b\u0001\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010$\u001a\u00020#H\u0007¢\u0006\u0004\b%\u0010&J\u001f\u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0004H\u0007¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0007¢\u0006\u0004\b.\u0010/J\u0017\u00103\u001a\u0002022\u0006\u00101\u001a\u000200H\u0007¢\u0006\u0004\b3\u00104J\u0019\u00106\u001a\u0002052\b\b\u0001\u0010\u000f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b6\u00107¨\u00068"}, d2 = {"Ly/v$a;", "", "<init>", "()V", "Landroidx/camera/camera2/pipe/h$e;", "config", "Landroid/content/Context;", "k", "(Landroidx/camera/camera2/pipe/h$e;)Landroid/content/Context;", "Lkotlinx/coroutines/g;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lkotlinx/coroutines/g;", "Landroidx/camera/camera2/pipe/h$c;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/camera/camera2/pipe/h$e;)Landroidx/camera/camera2/pipe/h$c;", "cameraPipeContext", "Landroid/hardware/camera2/CameraManager;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;)Landroid/hardware/camera2/CameraManager;", "Lx/s0;", "l", "(Landroid/content/Context;)Lx/s0;", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Lw/f;", "cameraBackends", "Lw/h;", "e", "(Landroid/content/Context;Landroidx/camera/camera2/pipe/core/Threads;Lw/f;)Lw/h;", "Landroid/content/pm/PackageManager;", "m", "(Landroid/content/Context;)Landroid/content/pm/PackageManager;", "LX8/a;", "Landroidx/camera/camera2/pipe/b;", "defaultCameraBackend", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "cameraPipeLifetime", "c", "(Landroidx/camera/camera2/pipe/h$e;LX8/a;Landroid/content/Context;Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;)Lw/f;", "LC/i;", "imageReaderImageSources", "cameraPipeConfig", "LC/m;", Const.INTENT_KEY_PKGNAME, "(LC/i;Landroidx/camera/camera2/pipe/h$e;)LC/m;", "Lw/q;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lw/q;", "Landroidx/camera/camera2/pipe/h$f;", "flags", "Lw/S;", "n", "(Landroidx/camera/camera2/pipe/h$f;)Lw/S;", "LZ/f;", "f", "(Landroid/content/Context;)LZ/f;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: y.v$a, reason: from kotlin metadata */
    public static final class Companion {

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\r\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"y/v$a$a", "Lw/h;", "Landroid/content/Context;", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "appContext", "Landroidx/camera/camera2/pipe/core/Threads;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/core/Threads;", "getThreads", "()Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Lw/f;", "c", "Lw/f;", "getCameraBackends", "()Lw/f;", "cameraBackends", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: y.v$a$a, reason: collision with other inner class name */
        public static final class C0553a implements InterfaceC5702h {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            public final Context appContext;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata */
            public final Threads threads;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata */
            public final InterfaceC5700f cameraBackends;

            public C0553a(Context context, Threads threads, InterfaceC5700f interfaceC5700f) {
                this.appContext = context;
                this.threads = threads;
                this.cameraBackends = interfaceC5700f;
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public static final androidx.camera.camera2.pipe.b d(androidx.camera.camera2.pipe.b bVar, InterfaceC5702h it) {
            kotlin.jvm.internal.p.i(it, "it");
            kotlin.jvm.internal.p.f(bVar);
            return bVar;
        }

        public final C.m b(C.i imageReaderImageSources, h.Config cameraPipeConfig) {
            kotlin.jvm.internal.p.i(imageReaderImageSources, "imageReaderImageSources");
            kotlin.jvm.internal.p.i(cameraPipeConfig, "cameraPipeConfig");
            return cameraPipeConfig.getImageSources() != null ? cameraPipeConfig.getImageSources() : imageReaderImageSources;
        }

        public final InterfaceC5700f c(h.Config config, X8.a<androidx.camera.camera2.pipe.b> defaultCameraBackend, Context cameraPipeContext, Threads threads, CameraPipeLifetime cameraPipeLifetime) {
            kotlin.jvm.internal.p.i(config, "config");
            kotlin.jvm.internal.p.i(defaultCameraBackend, "defaultCameraBackend");
            kotlin.jvm.internal.p.i(cameraPipeContext, "cameraPipeContext");
            kotlin.jvm.internal.p.i(threads, "threads");
            kotlin.jvm.internal.p.i(cameraPipeLifetime, "cameraPipeLifetime");
            final androidx.camera.camera2.pipe.b internalBackend = config.getCameraBackendConfig().getInternalBackend();
            if (internalBackend == null) {
                z.h hVar = z.h.f44503a;
                try {
                    Trace.beginSection("Initialize defaultCameraBackend");
                    internalBackend = defaultCameraBackend.get();
                } finally {
                    Trace.endSection();
                }
            }
            if (config.getCameraBackendConfig().a().containsKey(C5699e.a(internalBackend.e()))) {
                throw new IllegalStateException(("CameraBackendConfig#cameraBackends should not contain a backend with " + ((Object) C5699e.f(internalBackend.e())) + ". Use CameraBackendConfig#internalBackend field instead.").toString());
            }
            Map mapS = kotlin.collections.a.s(config.getCameraBackendConfig().a(), Y8.j.a(C5699e.a(internalBackend.e()), new InterfaceC5698d() { // from class: y.u
                @Override // w.InterfaceC5698d
                public final androidx.camera.camera2.pipe.b a(InterfaceC5702h interfaceC5702h) {
                    return AbstractC5910v.Companion.d(internalBackend, interfaceC5702h);
                }
            }));
            String defaultBackend = config.getCameraBackendConfig().getDefaultBackend();
            if (defaultBackend == null) {
                defaultBackend = internalBackend.e();
            }
            String str = defaultBackend;
            if (mapS.containsKey(C5699e.a(str))) {
                return new CameraBackendsImpl(str, mapS, cameraPipeContext, threads, cameraPipeLifetime, null);
            }
            throw new IllegalStateException(("Failed to find " + ((Object) C5699e.f(str)) + " in the list of available CameraPipe backends! Available values are " + mapS.keySet()).toString());
        }

        public final InterfaceC5702h e(Context cameraPipeContext, Threads threads, InterfaceC5700f cameraBackends) {
            kotlin.jvm.internal.p.i(cameraPipeContext, "cameraPipeContext");
            kotlin.jvm.internal.p.i(threads, "threads");
            kotlin.jvm.internal.p.i(cameraBackends, "cameraBackends");
            return new C0553a(cameraPipeContext, threads, cameraBackends);
        }

        public final Z.f f(Context cameraPipeContext) {
            kotlin.jvm.internal.p.i(cameraPipeContext, "cameraPipeContext");
            return new Z.f(cameraPipeContext);
        }

        public final CameraManager g(Context cameraPipeContext) {
            kotlin.jvm.internal.p.i(cameraPipeContext, "cameraPipeContext");
            Object systemService = cameraPipeContext.getSystemService(C3081a.CAMERA_FOCUS);
            kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            return (CameraManager) systemService;
        }

        public final h.c h(h.Config config) {
            kotlin.jvm.internal.p.i(config, "config");
            return config.getCameraMetadataConfig();
        }

        public final kotlinx.coroutines.g i() {
            return JobKt__JobKt.b(null, 1, null);
        }

        public final C5711q j() {
            return new C5711q();
        }

        public final Context k(h.Config config) {
            kotlin.jvm.internal.p.i(config, "config");
            return config.getAppContext();
        }

        public final s0 l(Context cameraPipeContext) {
            kotlin.jvm.internal.p.i(cameraPipeContext, "cameraPipeContext");
            Object systemService = cameraPipeContext.getSystemService("device_policy");
            kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
            return new C5813f((DevicePolicyManager) systemService);
        }

        public final PackageManager m(Context cameraPipeContext) {
            kotlin.jvm.internal.p.i(cameraPipeContext, "cameraPipeContext");
            PackageManager packageManager = cameraPipeContext.getPackageManager();
            kotlin.jvm.internal.p.h(packageManager, "getPackageManager(...)");
            return packageManager;
        }

        public final w.S n(h.Flags flags) {
            kotlin.jvm.internal.p.i(flags, "flags");
            return new w.S(flags.getStrictModeEnabled());
        }

        public Companion() {
        }
    }
}
