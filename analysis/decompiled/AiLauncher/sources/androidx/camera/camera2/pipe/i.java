package androidx.camera.camera2.pipe;

import Z8.C1174w;
import Z8.F;
import Z8.Q;
import android.os.Trace;
import androidx.camera.camera2.pipe.CameraGraph;
import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import w.C5699e;
import w.C5708n;
import w.C5711q;
import w.ConcurrentCameraGraphs;
import w.InterfaceC5698d;
import w.InterfaceC5705k;
import y.C5902m;
import y.InterfaceC5905p;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0007\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0003¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010&R\u0014\u0010)\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010+R\u0016\u0010\u001a\u001a\u00020-8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010.¨\u0006/"}, d2 = {"Landroidx/camera/camera2/pipe/i;", "Landroidx/camera/camera2/pipe/h;", "Ly/p;", "component", "<init>", "(Ly/p;)V", "Landroidx/camera/camera2/pipe/CameraGraph$b;", "config", "Landroidx/camera/camera2/pipe/CameraGraph;", Const.INTENT_KEY_UMID, "(Landroidx/camera/camera2/pipe/CameraGraph$b;)Landroidx/camera/camera2/pipe/CameraGraph;", "Landroidx/camera/camera2/pipe/CameraGraph$a;", "", "e", "(Landroidx/camera/camera2/pipe/CameraGraph$a;)Ljava/util/List;", "Lw/k;", Const.INTENT_KEY_APIKEY, "()Lw/k;", "Lw/q;", "c", "()Lw/q;", "graphConfig", "Landroidx/camera/camera2/pipe/o;", Const.INTENT_KEY_PKGNAME, "(Landroidx/camera/camera2/pipe/CameraGraph$b;Le9/c;)Ljava/lang/Object;", "LY8/t;", "shutdown", "()V", "", "toString", "()Ljava/lang/String;", "Landroidx/camera/camera2/pipe/e;", "cameraGraphId", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroidx/camera/camera2/pipe/CameraGraph$b;Landroidx/camera/camera2/pipe/e;)Landroidx/camera/camera2/pipe/CameraGraph;", "Landroidx/camera/camera2/pipe/b;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroidx/camera/camera2/pipe/CameraGraph$b;)Landroidx/camera/camera2/pipe/b;", "Ly/p;", "", "I", "debugId", "", "Ljava/lang/Object;", "lock", "", "Z", "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class i implements h {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5905p component;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final int debugId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean shutdown;

    public i(InterfaceC5905p component) {
        kotlin.jvm.internal.p.i(component, "component");
        this.component = component;
        this.debugId = j.b().d();
        this.lock = new Object();
    }

    @Override // androidx.camera.camera2.pipe.h
    public InterfaceC5705k a() {
        InterfaceC5705k interfaceC5705kA;
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            interfaceC5705kA = this.component.a();
        }
        return interfaceC5705kA;
    }

    @Override // androidx.camera.camera2.pipe.h
    public Object b(CameraGraph.b bVar, InterfaceC4014c<? super o> interfaceC4014c) {
        b bVarH = h(bVar);
        if (bVarH != null) {
            return bVarH.b(bVar, interfaceC4014c);
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // androidx.camera.camera2.pipe.h
    public C5711q c() {
        C5711q c5711qC;
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            c5711qC = this.component.c();
        }
        return c5711qC;
    }

    @Override // androidx.camera.camera2.pipe.h
    public CameraGraph d(CameraGraph.b config) {
        CameraGraph cameraGraphG;
        kotlin.jvm.internal.p.i(config, "config");
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            cameraGraphG = g(config, e.INSTANCE.a());
        }
        return cameraGraphG;
    }

    @Override // androidx.camera.camera2.pipe.h
    public List<CameraGraph> e(CameraGraph.a config) {
        ArrayList arrayList;
        kotlin.jvm.internal.p.i(config, "config");
        synchronized (this.lock) {
            try {
                if (this.shutdown) {
                    throw new IllegalStateException("Check failed.");
                }
                Map mapC = Q.c();
                Iterator<CameraGraph.b> it = config.a().iterator();
                while (it.hasNext()) {
                    mapC.put(it.next(), e.INSTANCE.a());
                }
                Map mapB = Q.b(mapC);
                List<CameraGraph.b> listA = config.a();
                ArrayList arrayList2 = new ArrayList(C1174w.x(listA, 10));
                Iterator<T> it2 = listA.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(C5708n.a(((CameraGraph.b) it2.next()).getCamera()));
                }
                ConcurrentCameraGraphs concurrentCameraGraphs = new ConcurrentCameraGraphs(F.r1(mapB.values()), F.r1(arrayList2));
                List<CameraGraph.b> listA2 = config.a();
                arrayList = new ArrayList(C1174w.x(listA2, 10));
                for (CameraGraph.b bVar : listA2) {
                    bVar.s(concurrentCameraGraphs);
                    Object obj = mapB.get(bVar);
                    if (obj == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    arrayList.add(g(bVar, (e) obj));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return arrayList;
    }

    public final CameraGraph g(CameraGraph.b config, e cameraGraphId) {
        z.h hVar = z.h.f44503a;
        try {
            Trace.beginSection("CXCP#CameraGraph-" + ((Object) C5708n.f(config.getCamera())));
            return this.component.b().a(new C5902m(config, cameraGraphId)).build().a();
        } finally {
            Trace.endSection();
        }
    }

    public final b h(CameraGraph.b graphConfig) {
        b bVarA;
        synchronized (this.lock) {
            try {
                if (this.shutdown) {
                    throw new IllegalStateException("Check failed.");
                }
                InterfaceC5698d customCameraBackend = graphConfig.getCustomCameraBackend();
                if (customCameraBackend != null) {
                    bVarA = customCameraBackend.a(this.component.d());
                } else {
                    String cameraBackendId = graphConfig.getCameraBackendId();
                    if (cameraBackendId != null) {
                        bVarA = this.component.e().a(cameraBackendId);
                        if (bVarA == null) {
                            throw new IllegalStateException(("Failed to initialize " + ((Object) C5699e.f(cameraBackendId)) + " from " + graphConfig).toString());
                        }
                    } else {
                        bVarA = this.component.e().getDefault();
                    }
                }
            } finally {
            }
        }
        return bVarA;
    }

    @Override // androidx.camera.camera2.pipe.h
    public void shutdown() {
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new IllegalStateException("Check failed.");
            }
            this.component.f().f();
            this.shutdown = true;
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public String toString() {
        return "CameraPipe-" + this.debugId;
    }
}
