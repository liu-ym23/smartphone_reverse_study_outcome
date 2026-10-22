package androidx.camera.camera2.pipe.compat;

import A.StreamGraph;
import Ua.C1060i;
import Ua.Q;
import Z8.F;
import android.content.Context;
import android.hardware.camera2.params.OutputConfiguration;
import android.util.Log;
import android.util.Size;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.compat.Camera2CameraController;
import androidx.camera.camera2.pipe.compat.h;
import androidx.camera.camera2.pipe.core.Threads;
import androidx.camera.camera2.pipe.k;
import androidx.camera.camera2.pipe.s;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import w.C5699e;
import w.C5708n;
import w.InterfaceC5702h;
import w.InterfaceC5703i;
import w.T;
import x.X;
import x.w0;
import y.C5891b;
import y.InterfaceC5890a;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B;\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0016\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0015\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0096@¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016¢\u0006\u0004\b#\u0010$J?\u00100\u001a\u00020/2\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+2\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\"2\u0006\u00102\u001a\u00020/H\u0016¢\u0006\u0004\b3\u00104J\u001d\u00106\u001a\b\u0012\u0004\u0012\u0002050\u00112\u0006\u0010\u001d\u001a\u00020\u001cH\u0003¢\u0006\u0004\b6\u00107R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u00108R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u00109R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010:R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010;R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010AR\u001a\u0010F\u001a\b\u0012\u0004\u0012\u00020/0C8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020G8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010HR \u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110J8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010K¨\u0006M"}, d2 = {"Landroidx/camera/camera2/pipe/compat/Camera2Backend;", "Landroidx/camera/camera2/pipe/b;", "Landroidx/camera/camera2/pipe/compat/Camera2CameraController$b;", "Landroidx/camera/camera2/pipe/core/Threads;", "threads", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceCache;", "camera2DeviceCache", "Landroidx/camera/camera2/pipe/compat/Camera2MetadataCache;", "camera2MetadataCache", "Lx/X;", "camera2DeviceManager", "Ly/a$a;", "camera2CameraControllerComponent", "Landroid/content/Context;", "cameraPipeContext", "<init>", "(Landroidx/camera/camera2/pipe/core/Threads;Landroidx/camera/camera2/pipe/compat/Camera2DeviceCache;Landroidx/camera/camera2/pipe/compat/Camera2MetadataCache;Lx/X;Ly/a$a;Landroid/content/Context;)V", "", "Lw/n;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/List;", "", "c", "()Ljava/util/Set;", "cameraId", "Landroidx/camera/camera2/pipe/g;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Landroidx/camera/camera2/pipe/g;", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "graphConfig", "Landroidx/camera/camera2/pipe/o;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/CameraGraph$b;Le9/c;)Ljava/lang/Object;", "LUa/Q;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()LUa/Q;", "Lw/h;", "cameraContext", "Landroidx/camera/camera2/pipe/e;", "graphId", "LA/e;", "graphListener", "Landroidx/camera/camera2/pipe/v;", "streamGraph", "Lw/T;", "surfaceTracker", "Lw/i;", Const.INTENT_KEY_UMID, "(Lw/h;Landroidx/camera/camera2/pipe/e;Landroidx/camera/camera2/pipe/CameraGraph$b;LA/e;Landroidx/camera/camera2/pipe/v;Lw/T;)Lw/i;", "cameraController", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw/i;)V", "Landroid/hardware/camera2/params/OutputConfiguration;", "n", "(Landroidx/camera/camera2/pipe/CameraGraph$b;)Ljava/util/List;", "Landroidx/camera/camera2/pipe/core/Threads;", "Landroidx/camera/camera2/pipe/compat/Camera2DeviceCache;", "Landroidx/camera/camera2/pipe/compat/Camera2MetadataCache;", "Lx/X;", "e", "Ly/a$a;", "f", "Landroid/content/Context;", "", "Ljava/lang/Object;", "lock", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/Set;", "activeCameraControllers", "Lw/e;", "()Ljava/lang/String;", "id", "LXa/b;", "()LXa/b;", "cameraIds", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Camera2Backend implements androidx.camera.camera2.pipe.b, Camera2CameraController.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Threads threads;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Camera2DeviceCache camera2DeviceCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Camera2MetadataCache camera2MetadataCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final X camera2DeviceManager;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5890a.InterfaceC0552a camera2CameraControllerComponent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Context cameraPipeContext;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final Set<InterfaceC5703i> activeCameraControllers;

    public Camera2Backend(Threads threads, Camera2DeviceCache camera2DeviceCache, Camera2MetadataCache camera2MetadataCache, X camera2DeviceManager, InterfaceC5890a.InterfaceC0552a camera2CameraControllerComponent, Context cameraPipeContext) {
        kotlin.jvm.internal.p.i(threads, "threads");
        kotlin.jvm.internal.p.i(camera2DeviceCache, "camera2DeviceCache");
        kotlin.jvm.internal.p.i(camera2MetadataCache, "camera2MetadataCache");
        kotlin.jvm.internal.p.i(camera2DeviceManager, "camera2DeviceManager");
        kotlin.jvm.internal.p.i(camera2CameraControllerComponent, "camera2CameraControllerComponent");
        kotlin.jvm.internal.p.i(cameraPipeContext, "cameraPipeContext");
        this.threads = threads;
        this.camera2DeviceCache = camera2DeviceCache;
        this.camera2MetadataCache = camera2MetadataCache;
        this.camera2DeviceManager = camera2DeviceManager;
        this.camera2CameraControllerComponent = camera2CameraControllerComponent;
        this.cameraPipeContext = cameraPipeContext;
        this.lock = new Object();
        this.activeCameraControllers = new LinkedHashSet();
    }

    @Override // androidx.camera.camera2.pipe.b
    public androidx.camera.camera2.pipe.g a(String cameraId) {
        kotlin.jvm.internal.p.i(cameraId, "cameraId");
        return this.camera2MetadataCache.a(cameraId);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.camera.camera2.pipe.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(androidx.camera.camera2.pipe.CameraGraph.b r8, e9.InterfaceC4014c<? super androidx.camera.camera2.pipe.o> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.pipe.compat.Camera2Backend.b(androidx.camera.camera2.pipe.CameraGraph$b, e9.c):java.lang.Object");
    }

    @Override // androidx.camera.camera2.pipe.b
    public Set<Set<C5708n>> c() {
        return this.camera2DeviceCache.o();
    }

    @Override // androidx.camera.camera2.pipe.b
    public InterfaceC5703i d(InterfaceC5702h cameraContext, androidx.camera.camera2.pipe.e graphId, CameraGraph.b graphConfig, A.e graphListener, androidx.camera.camera2.pipe.v streamGraph, T surfaceTracker) {
        kotlin.jvm.internal.p.i(cameraContext, "cameraContext");
        kotlin.jvm.internal.p.i(graphId, "graphId");
        kotlin.jvm.internal.p.i(graphConfig, "graphConfig");
        kotlin.jvm.internal.p.i(graphListener, "graphListener");
        kotlin.jvm.internal.p.i(streamGraph, "streamGraph");
        kotlin.jvm.internal.p.i(surfaceTracker, "surfaceTracker");
        InterfaceC5703i interfaceC5703iA = this.camera2CameraControllerComponent.a(new C5891b(this, graphId, graphConfig, graphListener, (StreamGraph) streamGraph, surfaceTracker, this)).build().a();
        synchronized (this.lock) {
            this.activeCameraControllers.add(interfaceC5703iA);
        }
        return interfaceC5703iA;
    }

    @Override // androidx.camera.camera2.pipe.b
    public String e() {
        return C5699e.b("CXCP-Camera2");
    }

    @Override // androidx.camera.camera2.pipe.b
    public Xa.b<List<C5708n>> f() {
        return this.camera2DeviceCache.t();
    }

    @Override // androidx.camera.camera2.pipe.b
    public List<C5708n> g() {
        return this.camera2DeviceCache.n();
    }

    @Override // androidx.camera.camera2.pipe.compat.Camera2CameraController.b
    public void i(InterfaceC5703i cameraController) {
        kotlin.jvm.internal.p.i(cameraController, "cameraController");
        if (z.k.f44508a.a()) {
            Log.d("CXCP", cameraController + " finalized");
        }
        synchronized (this.lock) {
            this.activeCameraControllers.remove(cameraController);
        }
    }

    @Override // androidx.camera.camera2.pipe.b
    public Q<Y8.t> j() {
        if (z.k.f44508a.a()) {
            Log.d("CXCP", "Camera2Backend#shutdownAsync");
        }
        this.camera2DeviceCache.B();
        return C1060i.b(this.threads.getCameraPipeScope(), null, null, new Camera2Backend$shutdownAsync$2(this, null), 3, null);
    }

    public final List<OutputConfiguration> n(CameraGraph.b graphConfig) {
        OutputConfiguration outputConfiguration;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<k.a> it = graphConfig.r().iterator();
        while (it.hasNext()) {
            for (s.a aVar : it.next().b()) {
                h.Companion companion = h.INSTANCE;
                Integer numValueOf = Integer.valueOf(aVar.getFormat());
                s.d dVarD = s.d.INSTANCE.d();
                s.c mirrorMode = aVar.getMirrorMode();
                aVar.i();
                s.b dynamicRangeProfile = aVar.getDynamicRangeProfile();
                s.f streamUseCase = aVar.getStreamUseCase();
                List<s.e> listE = aVar.e();
                Size size = aVar.getSize();
                String str = aVar.getCom.stepos.ailauncher.chat.voice.support.a.CAMERA_FOCUS java.lang.String();
                w0 w0VarB = h.Companion.b(companion, null, numValueOf, dVarD, mirrorMode, null, dynamicRangeProfile, streamUseCase, listE, size, false, 0, !(str == null ? false : C5708n.d(str, graphConfig.getCamera())) ? aVar.getCom.stepos.ailauncher.chat.voice.support.a.CAMERA_FOCUS java.lang.String() : null, 1536, null);
                if (w0VarB != null && (outputConfiguration = (OutputConfiguration) w0VarB.R0(kotlin.jvm.internal.t.b(OutputConfiguration.class))) != null) {
                    linkedHashSet.add(outputConfiguration);
                }
            }
        }
        return F.m1(linkedHashSet);
    }
}
