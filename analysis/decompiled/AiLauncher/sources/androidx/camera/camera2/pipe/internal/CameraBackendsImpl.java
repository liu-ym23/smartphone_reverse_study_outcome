package androidx.camera.camera2.pipe.internal;

import Ua.C1058h;
import Y8.t;
import android.content.Context;
import android.util.Log;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraBackendsImpl;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import f9.C4063a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.AwaitKt;
import w.C5699e;
import w.InterfaceC5698d;
import w.InterfaceC5700f;
import w.InterfaceC5702h;
import z.k;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0014B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130 8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b!\u0010\u0018R\u001a\u0010'\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraBackendsImpl;", "Lw/f;", "Lw/e;", "defaultBackendId", "", "Lw/d;", "cameraBackends", "Landroid/content/Context;", "cameraPipeContext", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "cameraPipeLifetime", "<init>", "(Ljava/lang/String;Ljava/util/Map;Landroid/content/Context;Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;Lkotlin/jvm/internal/i;)V", "LY8/t;", Const.INTENT_KEY_UMID, "(Le9/c;)Ljava/lang/Object;", "backendId", "Landroidx/camera/camera2/pipe/b;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/b;", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Ljava/util/Map;", "c", "Landroid/content/Context;", "Landroidx/camera/camera2/pipe/core/Threads;", "", "e", "Ljava/lang/Object;", "lock", "", "f", "activeCameraBackends", Const.INTENT_KEY_BACKGROUND_COMMAND, "Landroidx/camera/camera2/pipe/b;", "getDefault", "()Landroidx/camera/camera2/pipe/b;", "default", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CameraBackendsImpl implements InterfaceC5700f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String defaultBackendId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Map<C5699e, InterfaceC5698d> cameraBackends;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Context cameraPipeContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Map<C5699e, androidx.camera.camera2.pipe.b> activeCameraBackends;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.camera2.pipe.b default;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/camera/camera2/pipe/internal/CameraBackendsImpl$a;", "Lw/h;", "Landroid/content/Context;", "appContext", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Lw/f;", "cameraBackends", "<init>", "(Landroid/content/Context;Landroidx/camera/camera2/pipe/core/Threads;Lw/f;)V", Const.INTENT_KEY_APIKEY, "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/core/Threads;", "getThreads", "()Landroidx/camera/camera2/pipe/core/Threads;", "c", "Lw/f;", "getCameraBackends", "()Lw/f;", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements InterfaceC5702h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Context appContext;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Threads threads;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final InterfaceC5700f cameraBackends;

        public a(Context appContext, Threads threads, InterfaceC5700f cameraBackends) {
            p.i(appContext, "appContext");
            p.i(threads, "threads");
            p.i(cameraBackends, "cameraBackends");
            this.appContext = appContext;
            this.threads = threads;
            this.cameraBackends = cameraBackends;
        }
    }

    public /* synthetic */ CameraBackendsImpl(String str, Map map, Context context, Threads threads, CameraPipeLifetime cameraPipeLifetime, i iVar) {
        this(str, map, context, threads, cameraPipeLifetime);
    }

    public static final void c(CameraBackendsImpl cameraBackendsImpl) throws InterruptedException {
        C1058h.b(null, new CameraBackendsImpl$1$1(cameraBackendsImpl, null), 1, null);
    }

    @Override // w.InterfaceC5700f
    public androidx.camera.camera2.pipe.b a(String backendId) {
        p.i(backendId, "backendId");
        synchronized (this.lock) {
            try {
                androidx.camera.camera2.pipe.b bVar = this.activeCameraBackends.get(C5699e.a(backendId));
                if (bVar != null) {
                    return bVar;
                }
                InterfaceC5698d interfaceC5698d = this.cameraBackends.get(C5699e.a(backendId));
                androidx.camera.camera2.pipe.b bVarA = interfaceC5698d != null ? interfaceC5698d.a(new a(this.cameraPipeContext, this.threads, this)) : null;
                if (bVarA != null) {
                    if (!C5699e.d(backendId, bVarA.e())) {
                        throw new IllegalStateException(("Unexpected backend id! Expected " + ((Object) C5699e.f(backendId)) + " but it was actually " + ((Object) C5699e.f(bVarA.e()))).toString());
                    }
                    this.activeCameraBackends.put(C5699e.a(backendId), bVarA);
                }
                return bVarA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Object d(InterfaceC4014c<? super t> interfaceC4014c) throws Throwable {
        if (k.f44508a.a()) {
            Log.d("CXCP", "CameraBackends#shutdown");
        }
        Map<C5699e, androidx.camera.camera2.pipe.b> map = this.activeCameraBackends;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<C5699e, androidx.camera.camera2.pipe.b>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue().j());
        }
        Object objB = AwaitKt.b(arrayList, interfaceC4014c);
        return objB == C4063a.g() ? objB : t.f7040a;
    }

    @Override // w.InterfaceC5700f
    public androidx.camera.camera2.pipe.b getDefault() {
        return this.default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CameraBackendsImpl(String defaultBackendId, Map<C5699e, ? extends InterfaceC5698d> cameraBackends, Context cameraPipeContext, Threads threads, CameraPipeLifetime cameraPipeLifetime) {
        p.i(defaultBackendId, "defaultBackendId");
        p.i(cameraBackends, "cameraBackends");
        p.i(cameraPipeContext, "cameraPipeContext");
        p.i(threads, "threads");
        p.i(cameraPipeLifetime, "cameraPipeLifetime");
        this.defaultBackendId = defaultBackendId;
        this.cameraBackends = cameraBackends;
        this.cameraPipeContext = cameraPipeContext;
        this.threads = threads;
        this.lock = new Object();
        this.activeCameraBackends = new LinkedHashMap();
        cameraPipeLifetime.d(CameraPipeLifetime.ShutdownType.CAMERA, new Runnable() { // from class: B.a
            @Override // java.lang.Runnable
            public final void run() throws InterruptedException {
                CameraBackendsImpl.c(this.f1385a);
            }
        });
        androidx.camera.camera2.pipe.b bVarA = a(defaultBackendId);
        if (bVarA != null) {
            this.default = bVarA;
            return;
        }
        throw new IllegalStateException(("Failed to load the default backend for " + ((Object) C5699e.f(defaultBackendId)) + "! Available backends are " + cameraBackends.keySet()).toString());
    }
}
