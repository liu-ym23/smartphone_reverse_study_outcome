package o;

import D.C0761b0;
import D.C0777n;
import K.InterfaceC0897u;
import K.p0;
import Ua.C1071n0;
import Z8.C1173v;
import Z8.C1174w;
import android.content.Context;
import android.os.Trace;
import android.util.Log;
import androidx.camera.camera2.adapter.PipeCameraPresenceSource;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraUpdateException;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import s.C5427b;
import s.InterfaceC5426a;
import t.C5473b;
import t.C5491s;
import u.C5553a;
import u.C5554b;
import w.C5708n;
import w.InterfaceC5705k;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0018\u001a\u00020\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u001b\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u00140)H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010.J#\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00150 2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002¢\u0006\u0004\b/\u00100R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u00101R\u0016\u0010\r\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u00102R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u00103R\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u00104R\u0014\u00107\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u00109R\u001b\u0010>\u001a\u00020;8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u00101\u001a\u0004\b<\u0010=R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00150 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lo/d;", "LK/u;", "LK/u$a;", "LY8/h;", "Landroidx/camera/camera2/pipe/h;", "lazyCameraPipe", "Landroid/content/Context;", "context", "LK/O;", "threadConfig", "Lt/s;", "camera2InteropCallbacks", "Landroidx/camera/core/CameraSelector;", "availableCamerasSelector", "LP/i;", "streamSpecsCalculator", "Landroidx/camera/core/f;", "cameraXConfig", "<init>", "(LY8/h;Landroid/content/Context;LK/O;Lt/s;Landroidx/camera/core/CameraSelector;LP/i;Landroidx/camera/core/f;)V", "", "", "cameraIds", "LY8/t;", "e", "(Ljava/util/List;)V", Const.INTENT_KEY_UMID, "(Ljava/util/List;)Ljava/util/List;", "cameraId", "Landroidx/camera/core/impl/CameraInternal;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Landroidx/camera/core/impl/CameraInternal;", "", "c", "()Ljava/util/Set;", "LE/a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()LE/a;", "", "f", "()Ljava/lang/Object;", "LK/p0;", "LD/n;", Const.INTENT_KEY_PKGNAME, "()LK/p0;", "shutdown", "()V", "k", "(Ljava/util/List;)Ljava/util/Set;", "LY8/h;", "Landroidx/camera/core/CameraSelector;", "LP/i;", "Landroidx/camera/core/f;", "Lo/b;", "Lo/b;", "cameraCoordinator", "Landroidx/camera/camera2/adapter/PipeCameraPresenceSource;", "Landroidx/camera/camera2/adapter/PipeCameraPresenceSource;", "pipeCameraPresenceObservable", "Ls/a;", "l", "()Ls/a;", "appComponent", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/Set;", "availableCameraIds", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Ljava/lang/Object;", "lock", "Ljava/util/concurrent/atomic/AtomicBoolean;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/util/concurrent/atomic/AtomicBoolean;", "isShutdown", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4972d implements InterfaceC0897u, InterfaceC0897u.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<androidx.camera.camera2.pipe.h> lazyCameraPipe;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final CameraSelector availableCamerasSelector;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final P.i streamSpecsCalculator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final androidx.camera.core.f cameraXConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final C4970b cameraCoordinator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final PipeCameraPresenceSource pipeCameraPresenceObservable;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Y8.h appComponent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public Set<String> availableCameraIds;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final AtomicBoolean isShutdown;

    /* JADX WARN: Multi-variable type inference failed */
    public C4972d(Y8.h<? extends androidx.camera.camera2.pipe.h> lazyCameraPipe, final Context context, final K.O threadConfig, final C5491s camera2InteropCallbacks, CameraSelector cameraSelector, P.i streamSpecsCalculator, androidx.camera.core.f cameraXConfig) throws InitializationException {
        List<String> listM;
        kotlin.jvm.internal.p.i(lazyCameraPipe, "lazyCameraPipe");
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(threadConfig, "threadConfig");
        kotlin.jvm.internal.p.i(camera2InteropCallbacks, "camera2InteropCallbacks");
        kotlin.jvm.internal.p.i(streamSpecsCalculator, "streamSpecsCalculator");
        kotlin.jvm.internal.p.i(cameraXConfig, "cameraXConfig");
        this.lazyCameraPipe = lazyCameraPipe;
        this.availableCamerasSelector = cameraSelector;
        this.streamSpecsCalculator = streamSpecsCalculator;
        this.cameraXConfig = cameraXConfig;
        this.cameraCoordinator = new C4970b((androidx.camera.camera2.pipe.h) lazyCameraPipe.getValue(), ((androidx.camera.camera2.pipe.h) lazyCameraPipe.getValue()).a());
        this.appComponent = C4848b.b(new InterfaceC5063a() { // from class: o.c
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C4972d.j(context, threadConfig, this, camera2InteropCallbacks);
            }
        });
        this.availableCameraIds = Z8.Y.e();
        this.lock = new Object();
        this.isShutdown = new AtomicBoolean(false);
        List listG = InterfaceC5705k.g(l().b(), null, 1, null);
        if (listG != null) {
            List list = listG;
            listM = new ArrayList<>(C1174w.x(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                listM.add(((C5708n) it.next()).getValue());
            }
        } else {
            listM = C1173v.m();
        }
        Xa.b bVarH = InterfaceC5705k.h(this.lazyCameraPipe.getValue().a(), null, 1, null);
        Executor executorB = threadConfig.b();
        kotlin.jvm.internal.p.h(executorB, "getCameraExecutor(...)");
        this.pipeCameraPresenceObservable = new PipeCameraPresenceSource(bVarH, kotlinx.coroutines.d.a(C1071n0.b(executorB)), listM, context);
        e(listM);
    }

    public static final InterfaceC5426a j(Context context, K.O o10, C4972d c4972d, C5491s c5491s) {
        z.h hVar = z.h.f44503a;
        Trace.beginSection("CameraFactoryAdapter#appComponent");
        z.t tVar = new z.t();
        z.y yVar = z.y.f44525a;
        long jA = tVar.a();
        InterfaceC5426a interfaceC5426aBuild = s.u.a().a(new C5427b(context, o10, c4972d.lazyCameraPipe.getValue(), c5491s, c4972d.cameraCoordinator, c4972d.cameraXConfig)).build();
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            String str = C5473b.TRUNCATED_TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Created CameraFactoryAdapter in ");
            String str2 = String.format(null, "%.3f ms", Arrays.copyOf(new Object[]{Double.valueOf(z.i.c(tVar.a() - jA) / 1000000.0d)}, 1));
            kotlin.jvm.internal.p.h(str2, "format(...)");
            sb2.append(str2);
            Log.d(str, sb2.toString());
        }
        Trace.endSection();
        return interfaceC5426aBuild;
    }

    @Override // K.InterfaceC0897u
    public CameraInternal a(String cameraId) throws CameraUpdateException {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        if (this.isShutdown.get()) {
            throw new CameraUpdateException("CameraFactory has been shut down.");
        }
        return l().c().b(new s.m(C5708n.b(cameraId), null)).a(this.streamSpecsCalculator).build().a();
    }

    @Override // K.InterfaceC0897u
    public p0<List<C0777n>> b() {
        return this.pipeCameraPresenceObservable;
    }

    @Override // K.InterfaceC0897u
    public Set<String> c() {
        synchronized (this.lock) {
            if (this.isShutdown.get()) {
                return Z8.Y.e();
            }
            return new LinkedHashSet(this.availableCameraIds);
        }
    }

    @Override // K.InterfaceC0897u.a
    public List<String> d(List<String> cameraIds) {
        kotlin.jvm.internal.p.i(cameraIds, "cameraIds");
        return this.isShutdown.get() ? C1173v.m() : Z8.F.m1(k(cameraIds));
    }

    @Override // K.InterfaceC0900x
    public void e(List<String> cameraIds) throws InitializationException {
        kotlin.jvm.internal.p.i(cameraIds, "cameraIds");
        if (this.isShutdown.get()) {
            return;
        }
        Set<String> setK = k(cameraIds);
        synchronized (this.lock) {
            try {
                if (this.isShutdown.get()) {
                    return;
                }
                if (kotlin.jvm.internal.p.d(this.availableCameraIds, setK)) {
                    return;
                }
                C5473b c5473b = C5473b.f41865a;
                if (C0761b0.f("CXCP")) {
                    Log.d(C5473b.TRUNCATED_TAG, "Updated available camera list: " + this.availableCameraIds + " -> " + setK);
                }
                this.availableCameraIds = setK;
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // K.InterfaceC0897u
    public Object f() {
        return l();
    }

    @Override // K.InterfaceC0897u
    public E.a g() {
        return this.cameraCoordinator;
    }

    public final Set<String> k(List<String> cameraIds) throws InitializationException {
        return new LinkedHashSet(C5553a.a(l().b(), C5554b.INSTANCE.b(l(), this.availableCamerasSelector, Z8.F.m1(cameraIds), this.streamSpecsCalculator)));
    }

    public final InterfaceC5426a l() {
        return (InterfaceC5426a) this.appComponent.getValue();
    }

    @Override // K.InterfaceC0897u
    public void shutdown() {
        if (this.isShutdown.getAndSet(true)) {
            return;
        }
        this.cameraCoordinator.i();
        this.pipeCameraPresenceObservable.g();
        if (this.lazyCameraPipe.isInitialized()) {
            this.lazyCameraPipe.getValue().shutdown();
        }
    }
}
