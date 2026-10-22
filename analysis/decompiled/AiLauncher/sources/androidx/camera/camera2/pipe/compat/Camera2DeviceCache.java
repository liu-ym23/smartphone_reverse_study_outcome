package androidx.camera.camera2.pipe.compat;

import Ua.CoroutineName;
import Ua.L0;
import Ua.M;
import Ua.Q;
import Z8.C1174w;
import Z8.F;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.util.Log;
import androidx.camera.camera2.pipe.compat.Camera2DeviceCache;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.internal.CameraPipeLifetime;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.Metadata;
import kotlinx.coroutines.channels.a;
import kotlinx.coroutines.flow.a;
import p9.InterfaceC5063a;
import w.C5708n;
import x.C5827m;
import x.InterfaceC5804a0;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001BY\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0086@¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u0015H\u0087@¢\u0006\u0004\b\u001b\u0010\u0019J\u0015\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010 \u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001f\u0018\u00010\u001f¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u001b\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001c0%H\u0002¢\u0006\u0004\b&\u0010'J/\u0010,\u001a\u00020\"*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001c0(2\u0006\u0010\u0016\u001a\u00020)2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J7\u00100\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001c2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001c2\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001cH\u0002¢\u0006\u0004\b0\u00101J-\u00103\u001a\u00020\"*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001c0(2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0002¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001cH\u0002¢\u0006\u0004\b5\u0010\u001eJ\u0017\u00107\u001a\u0002062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b7\u00108J\u001d\u00109\u001a\u00020*2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0002¢\u0006\u0004\b9\u0010:R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010<R\u0014\u0010G\u001a\u00020D8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001c8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bK\u0010LR$\u0010P\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001f\u0018\u00010\u001f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bN\u0010OR(\u0010U\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170R0Q8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bS\u0010TR(\u0010W\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0R0Q8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bV\u0010TR\u0014\u0010Z\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR#\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001c0%8\u0006¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010'R#\u0010b\u001a\n ^*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010_\u001a\u0004\b`\u0010a¨\u0006c"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2DeviceCache;", "", "LX8/a;", "Landroid/hardware/camera2/CameraManager;", "cameraManager", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Landroid/content/Context;", "context", "Landroid/content/pm/PackageManager;", "packageManager", "LB/c;", "cameraErrorListener", "LZ/f;", "cameraDeviceSetupCompatFactoryProvider", "Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;", "cameraPipeLifetime", "Lkotlinx/coroutines/g;", "cameraPipeJob", "<init>", "(LX8/a;Landroidx/camera/camera2/pipe/core/Threads;Landroid/content/Context;Landroid/content/pm/PackageManager;LB/c;LX8/a;Landroidx/camera/camera2/pipe/internal/CameraPipeLifetime;Lkotlinx/coroutines/g;)V", "Lw/n;", "cameraId", "LZ/e;", "u", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "Lx/a0;", "v", "", "n", "()Ljava/util/List;", "", "o", "()Ljava/util/Set;", "LY8/t;", "B", "()V", "LXa/b;", "q", "()LXa/b;", "LWa/p;", "", "", "isAvailable", "y", "(LWa/p;Ljava/lang/String;Z)V", "cachedCameraIds", "cameraIdsRead", "w", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "cameraIds", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(LWa/p;Ljava/util/List;)V", "z", "", "r", "(Landroid/content/pm/PackageManager;)I", "x", "(Ljava/util/List;)Z", Const.INTENT_KEY_APIKEY, "LX8/a;", Const.INTENT_KEY_PKGNAME, "Landroidx/camera/camera2/pipe/core/Threads;", "c", "Landroid/content/Context;", Const.INTENT_KEY_UMID, "LB/c;", "e", "LUa/M;", "f", "LUa/M;", "scope", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/lang/Object;", "lock", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/List;", "openableCameras", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/util/Set;", "concurrentCameras", "", "LUa/Q;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/util/Map;", "cameraDeviceSetupCache", "k", "camera2DeviceSetupWrapperCache", "l", "I", "minimumCameraCount", "m", "LXa/b;", "t", "kotlin.jvm.PlatformType", "LY8/h;", "s", "()LZ/f;", "cameraDeviceSetupCompatFactory", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2DeviceCache {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final X8.a<CameraManager> cameraManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final B.c cameraErrorListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final X8.a<Z.f> cameraDeviceSetupCompatFactoryProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final M scope;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public List<C5708n> openableCameras;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public Set<? extends Set<C5708n>> concurrentCameras;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final Map<C5708n, Q<Z.e>> cameraDeviceSetupCache;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final Map<C5708n, Q<InterfaceC5804a0>> camera2DeviceSetupWrapperCache;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final int minimumCameraCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final Xa.b<List<C5708n>> cameraIds;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final Y8.h cameraDeviceSetupCompatFactory;

    public Camera2DeviceCache(X8.a<CameraManager> cameraManager, Threads threads, Context context, PackageManager packageManager, B.c cameraErrorListener, X8.a<Z.f> cameraDeviceSetupCompatFactoryProvider, CameraPipeLifetime cameraPipeLifetime, kotlinx.coroutines.g cameraPipeJob) {
        kotlin.jvm.internal.p.i(cameraManager, "cameraManager");
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(packageManager, "packageManager");
        kotlin.jvm.internal.p.i(cameraErrorListener, "cameraErrorListener");
        kotlin.jvm.internal.p.i(cameraDeviceSetupCompatFactoryProvider, "cameraDeviceSetupCompatFactoryProvider");
        kotlin.jvm.internal.p.i(cameraPipeLifetime, "cameraPipeLifetime");
        kotlin.jvm.internal.p.i(cameraPipeJob, "cameraPipeJob");
        this.cameraManager = cameraManager;
        this.threads = threads;
        this.context = context;
        this.cameraErrorListener = cameraErrorListener;
        this.cameraDeviceSetupCompatFactoryProvider = cameraDeviceSetupCompatFactoryProvider;
        M mA = kotlinx.coroutines.d.a(L0.a(cameraPipeJob).plus(threads.getLightweightDispatcher()).plus(new CoroutineName("Camera2DeviceCache")));
        this.scope = mA;
        this.lock = new Object();
        this.cameraDeviceSetupCache = new LinkedHashMap();
        this.camera2DeviceSetupWrapperCache = new LinkedHashMap();
        this.minimumCameraCount = r(packageManager);
        if (z.k.f44508a.a()) {
            Log.d("CXCP", "Camera2DeviceCache: Expected minimum camera count = " + this.minimumCameraCount);
        }
        cameraPipeLifetime.d(CameraPipeLifetime.ShutdownType.SCOPE, new Runnable() { // from class: x.S
            @Override // java.lang.Runnable
            public final void run() {
                Camera2DeviceCache.c(this.f43355a);
            }
        });
        this.cameraIds = Xa.d.L(Xa.d.q(q()), mA, a.Companion.b(kotlinx.coroutines.flow.a.INSTANCE, 0L, 0L, 3, null), 1);
        this.cameraDeviceSetupCompatFactory = C4848b.b(new InterfaceC5063a() { // from class: x.T
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Camera2DeviceCache.p(this.f43356a);
            }
        });
    }

    public static final void c(Camera2DeviceCache camera2DeviceCache) {
        kotlinx.coroutines.d.e(camera2DeviceCache.scope, null, 1, null);
    }

    public static final Z.f p(Camera2DeviceCache camera2DeviceCache) {
        return camera2DeviceCache.cameraDeviceSetupCompatFactoryProvider.get();
    }

    public final void A(Wa.p<? super List<C5708n>> pVar, List<C5708n> list) {
        z.k kVar = z.k.f44508a;
        if (kVar.a()) {
            Log.d("CXCP", "Emitting camera ID list: " + list);
        }
        Object objB = Wa.l.b(pVar, list);
        if (objB instanceof a.c) {
            kotlinx.coroutines.channels.a.e(objB);
            if (kVar.b()) {
                Log.e("CXCP", "Failed to send camera ID list: " + list + '!');
            }
        }
    }

    public final void B() {
        kotlinx.coroutines.d.e(this.scope, null, 1, null);
    }

    public final List<C5708n> n() {
        List<C5708n> list;
        synchronized (this.lock) {
            list = this.openableCameras;
        }
        return list != null ? list : z();
    }

    public final Set<Set<C5708n>> o() {
        Set set;
        synchronized (this.lock) {
            set = this.concurrentCameras;
        }
        Set set2 = set;
        if (set2 != null && !set2.isEmpty()) {
            return set;
        }
        CameraManager cameraManager = this.cameraManager.get();
        try {
            kotlin.jvm.internal.p.f(cameraManager);
            Set<Set<String>> setA = C5827m.a(cameraManager);
            if (z.k.f44508a.a()) {
                Log.d("CXCP", "Loaded ConcurrentCameraIdsSet " + setA);
            }
            Set<Set<String>> set3 = setA;
            ArrayList arrayList = new ArrayList(C1174w.x(set3, 10));
            Iterator<T> it = set3.iterator();
            while (it.hasNext()) {
                Set set4 = (Set) it.next();
                ArrayList arrayList2 = new ArrayList(C1174w.x(set4, 10));
                Iterator it2 = set4.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(C5708n.a(C5708n.b((String) it2.next())));
                }
                arrayList.add(F.r1(arrayList2));
            }
            return F.r1(arrayList);
        } catch (CameraAccessException e10) {
            if (!z.k.f44508a.d()) {
                return null;
            }
            Log.w("CXCP", "Failed to query CameraManager#getConcurrentStreamingCameraIds", e10);
            return null;
        }
    }

    public final Xa.b<List<C5708n>> q() {
        return Xa.d.f(new Camera2DeviceCache$createCameraIdListFlow$1(this, null));
    }

    public final int r(PackageManager packageManager) {
        boolean zHasSystemFeature = packageManager.hasSystemFeature("android.hardware.camera");
        return packageManager.hasSystemFeature("android.hardware.camera.front") ? (zHasSystemFeature ? 1 : 0) + 1 : zHasSystemFeature ? 1 : 0;
    }

    public final Z.f s() {
        return (Z.f) this.cameraDeviceSetupCompatFactory.getValue();
    }

    public final Xa.b<List<C5708n>> t() {
        return this.cameraIds;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(java.lang.String r14, e9.InterfaceC4014c<? super Z.e> r15) throws java.lang.Throwable {
        /*
            r13 = this;
            boolean r0 = r15 instanceof androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupCompat$1
            if (r0 == 0) goto L13
            r0 = r15
            androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupCompat$1 r0 = (androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupCompat$1) r0
            int r1 = r0.f10375e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10375e = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupCompat$1 r0 = new androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupCompat$1
            r0.<init>(r13, r15)
        L18:
            java.lang.Object r15 = r0.f10373c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10375e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r14 = r0.f10372b
            Ua.Q r14 = (Ua.Q) r14
            java.lang.Object r0 = r0.f10371a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.C4849c.b(r15)
            r2 = r14
            r14 = r0
            goto L81
        L33:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L3b:
            kotlin.C4849c.b(r15)
            int r15 = android.os.Build.VERSION.SDK_INT
            r2 = 35
            r4 = 0
            if (r15 >= r2) goto L46
            return r4
        L46:
            java.lang.Object r15 = r13.lock
            monitor-enter(r15)
            java.util.Map<w.n, Ua.Q<Z.e>> r2 = r13.cameraDeviceSetupCache     // Catch: java.lang.Throwable -> L6d
            w.n r5 = w.C5708n.a(r14)     // Catch: java.lang.Throwable -> L6d
            java.lang.Object r6 = r2.get(r5)     // Catch: java.lang.Throwable -> L6d
            if (r6 != 0) goto L70
            Ua.M r7 = r13.scope     // Catch: java.lang.Throwable -> L6d
            androidx.camera.camera2.pipe.core.Threads r6 = r13.threads     // Catch: java.lang.Throwable -> L6d
            Ua.I r8 = r6.getBackgroundDispatcher()     // Catch: java.lang.Throwable -> L6d
            androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupCompat$deferred$1$1$1 r10 = new androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupCompat$deferred$1$1$1     // Catch: java.lang.Throwable -> L6d
            r10.<init>(r14, r13, r4)     // Catch: java.lang.Throwable -> L6d
            r11 = 2
            r12 = 0
            r9 = 0
            Ua.Q r6 = Ua.C1056g.b(r7, r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L6d
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L6d
            goto L70
        L6d:
            r0 = move-exception
            r13 = r0
            goto Lba
        L70:
            r2 = r6
            Ua.Q r2 = (Ua.Q) r2     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r15)
            r0.f10371a = r14
            r0.f10372b = r2
            r0.f10375e = r3
            java.lang.Object r15 = r2.a1(r0)
            if (r15 != r1) goto L81
            return r1
        L81:
            Z.e r15 = (Z.e) r15
            if (r15 != 0) goto Lb9
            z.k r0 = z.k.f44508a
            boolean r0 = r0.a()
            if (r0 == 0) goto La7
            java.lang.String r0 = "CXCP"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Removing null CameraDeviceSetupCompat from cache for "
            r1.append(r3)
            java.lang.String r3 = w.C5708n.f(r14)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        La7:
            java.lang.Object r1 = r13.lock
            monitor-enter(r1)
            java.util.Map<w.n, Ua.Q<Z.e>> r13 = r13.cameraDeviceSetupCache     // Catch: java.lang.Throwable -> Lb5
            w.n r14 = w.C5708n.a(r14)     // Catch: java.lang.Throwable -> Lb5
            r13.remove(r14, r2)     // Catch: java.lang.Throwable -> Lb5
            monitor-exit(r1)
            return r15
        Lb5:
            r0 = move-exception
            r13 = r0
            monitor-exit(r1)
            throw r13
        Lb9:
            return r15
        Lba:
            monitor-exit(r15)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.Camera2DeviceCache.u(java.lang.String, e9.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(java.lang.String r13, e9.InterfaceC4014c<? super x.InterfaceC5804a0> r14) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r14 instanceof androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1
            if (r0 == 0) goto L13
            r0 = r14
            androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1 r0 = (androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1) r0
            int r1 = r0.f10383e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f10383e = r1
            goto L18
        L13:
            androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1 r0 = new androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.f10381c
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f10383e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r13 = r0.f10380b
            Ua.Q r13 = (Ua.Q) r13
            java.lang.Object r0 = r0.f10379a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.C4849c.b(r14)
            r2 = r13
            r13 = r0
            goto L7a
        L33:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L3b:
            kotlin.C4849c.b(r14)
            java.lang.Object r14 = r12.lock
            monitor-enter(r14)
            java.util.Map<w.n, Ua.Q<x.a0>> r2 = r12.camera2DeviceSetupWrapperCache     // Catch: java.lang.Throwable -> L66
            w.n r4 = w.C5708n.a(r13)     // Catch: java.lang.Throwable -> L66
            java.lang.Object r5 = r2.get(r4)     // Catch: java.lang.Throwable -> L66
            if (r5 != 0) goto L69
            Ua.M r6 = r12.scope     // Catch: java.lang.Throwable -> L66
            androidx.camera.camera2.pipe.core.Threads r5 = r12.threads     // Catch: java.lang.Throwable -> L66
            Ua.I r7 = r5.getBackgroundDispatcher()     // Catch: java.lang.Throwable -> L66
            androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$deferred$1$1$1 r9 = new androidx.camera.camera2.pipe.compat.Camera2DeviceCache$getOrInitializeDeviceSetupWrapper$deferred$1$1$1     // Catch: java.lang.Throwable -> L66
            r5 = 0
            r9.<init>(r13, r12, r5)     // Catch: java.lang.Throwable -> L66
            r10 = 2
            r11 = 0
            r8 = 0
            Ua.Q r5 = Ua.C1056g.b(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L66
            r2.put(r4, r5)     // Catch: java.lang.Throwable -> L66
            goto L69
        L66:
            r0 = move-exception
            r12 = r0
            goto Lb3
        L69:
            r2 = r5
            Ua.Q r2 = (Ua.Q) r2     // Catch: java.lang.Throwable -> L66
            monitor-exit(r14)
            r0.f10379a = r13
            r0.f10380b = r2
            r0.f10383e = r3
            java.lang.Object r14 = r2.a1(r0)
            if (r14 != r1) goto L7a
            return r1
        L7a:
            x.a0 r14 = (x.InterfaceC5804a0) r14
            if (r14 != 0) goto Lb2
            z.k r0 = z.k.f44508a
            boolean r0 = r0.a()
            if (r0 == 0) goto La0
            java.lang.String r0 = "CXCP"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Removing null camera2DeviceSetupWrapper from cache for "
            r1.append(r3)
            java.lang.String r3 = w.C5708n.f(r13)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
        La0:
            java.lang.Object r1 = r12.lock
            monitor-enter(r1)
            java.util.Map<w.n, Ua.Q<x.a0>> r12 = r12.camera2DeviceSetupWrapperCache     // Catch: java.lang.Throwable -> Lae
            w.n r13 = w.C5708n.a(r13)     // Catch: java.lang.Throwable -> Lae
            r12.remove(r13, r2)     // Catch: java.lang.Throwable -> Lae
            monitor-exit(r1)
            return r14
        Lae:
            r0 = move-exception
            r12 = r0
            monitor-exit(r1)
            throw r12
        Lb2:
            return r14
        Lb3:
            monitor-exit(r14)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.Camera2DeviceCache.v(java.lang.String, e9.c):java.lang.Object");
    }

    public final List<C5708n> w(List<C5708n> cachedCameraIds, List<C5708n> cameraIdsRead) {
        return (cameraIdsRead == null || !(x(cameraIdsRead) || cachedCameraIds == null)) ? cachedCameraIds : cameraIdsRead;
    }

    public final boolean x(List<C5708n> cameraIds) {
        return cameraIds.size() >= this.minimumCameraCount;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y(Wa.p<? super java.util.List<w.C5708n>> r4, java.lang.String r5, boolean r6) throws android.hardware.camera2.CameraAccessException {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            java.util.List<w.n> r1 = r3.openableCameras     // Catch: java.lang.Throwable -> Lc7
            monitor-exit(r0)
            r0 = 1
            r2 = 0
            if (r6 != r0) goto L61
            if (r1 == 0) goto L39
            r6 = r1
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L1d
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L1d
            goto L39
        L1d:
            java.util.Iterator r6 = r6.iterator()
        L21:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L39
            java.lang.Object r0 = r6.next()
            w.n r0 = (w.C5708n) r0
            java.lang.String r0 = r0.getValue()
            boolean r0 = kotlin.jvm.internal.p.d(r0, r5)
            if (r0 == 0) goto L21
            goto Lb7
        L39:
            z.k r6 = z.k.f44508a
            boolean r6 = r6.c()
            if (r6 == 0) goto L5c
            java.lang.String r6 = "CXCP"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "New camera "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = " detected"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            android.util.Log.i(r6, r5)
        L5c:
            java.util.List r2 = r3.z()
            goto Lb7
        L61:
            if (r6 != 0) goto Lc1
            if (r1 == 0) goto L90
            r6 = r1
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r0 = r6 instanceof java.util.Collection
            if (r0 == 0) goto L76
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L76
            goto Lb7
        L76:
            java.util.Iterator r6 = r6.iterator()
        L7a:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto Lb7
            java.lang.Object r0 = r6.next()
            w.n r0 = (w.C5708n) r0
            java.lang.String r0 = r0.getValue()
            boolean r0 = kotlin.jvm.internal.p.d(r0, r5)
            if (r0 == 0) goto L7a
        L90:
            z.k r6 = z.k.f44508a
            boolean r6 = r6.c()
            if (r6 == 0) goto Lb3
            java.lang.String r6 = "CXCP"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Unavailable camera "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = " detected"
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            android.util.Log.i(r6, r5)
        Lb3:
            java.util.List r2 = r3.z()
        Lb7:
            java.util.List r5 = r3.w(r1, r2)
            if (r5 == 0) goto Lc0
            r3.A(r4, r5)
        Lc0:
            return
        Lc1:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        Lc7:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.Camera2DeviceCache.y(Wa.p, java.lang.String, boolean):void");
    }

    public final List<C5708n> z() throws CameraAccessException {
        try {
            String[] cameraIdList = this.cameraManager.get().getCameraIdList();
            kotlin.jvm.internal.p.h(cameraIdList, "getCameraIdList(...)");
            ArrayList arrayList = new ArrayList();
            for (String str : cameraIdList) {
                kotlin.jvm.internal.p.f(str);
                String strB = C5708n.b(str);
                C5708n c5708nA = strB != null ? C5708n.a(strB) : null;
                if (c5708nA != null) {
                    arrayList.add(c5708nA);
                }
            }
            if (x(arrayList)) {
                synchronized (this.lock) {
                    this.openableCameras = arrayList;
                    Y8.t tVar = Y8.t.f7040a;
                }
                if (z.k.f44508a.c()) {
                    Log.i("CXCP", "Loaded CameraIdList " + arrayList);
                    return arrayList;
                }
            } else if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to query camera ID list: Invalid list returned: " + arrayList + '.');
            }
            return arrayList;
        } catch (CameraAccessException e10) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to query CameraManager#getCameraIdList!", e10);
            }
            return null;
        } catch (ArrayIndexOutOfBoundsException e11) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to query CameraManager#getCameraIdList!Unexpected ArrayIndexOutOfBoundsException thrown by framework.", e11);
            }
            return null;
        } catch (NullPointerException e12) {
            if (z.k.f44508a.d()) {
                Log.w("CXCP", "Failed to query CameraManager#getCameraIdList!Null was returned by framework.", e12);
            }
            return null;
        }
    }
}
