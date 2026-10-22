package A;

import A.StreamGraph;
import Y8.t;
import Z8.F;
import android.view.Surface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiIsland;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import s.C5423E;
import w.C5711q;
import w.InterfaceC5703i;
import w.Q;
import w.T;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B9\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0086\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u001b\u0010\u0018J\u001b\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00120\u000bH\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010 R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010&R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00120(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b)\u0010$R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u0012\u0012\b\u0012\u00060\u0002j\u0002`\u00030(8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010$R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020,8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010.¨\u00061"}, d2 = {"LA/r;", "Lw/T;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "LA/q;", "streamGraphImpl", "LX8/a;", "Lw/i;", "cameraController", "Lw/q;", "surfaceManager", "", "Lw/Q;", "LC/l;", "imageSources", "<init>", "(LA/q;LX8/a;Lw/q;Ljava/util/Map;)V", "streamId", "Landroid/view/Surface;", "surface", "LY8/t;", "l", "(ILandroid/view/Surface;)V", Const.INTENT_KEY_PKGNAME, "()V", "e", "close", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/util/Map;", Const.INTENT_KEY_APIKEY, "LA/q;", "LX8/a;", "c", "Lw/q;", Const.INTENT_KEY_UMID, "Ljava/util/Map;", "", "Ljava/lang/Object;", "lock", "", "f", "surfaceMap", "surfaceUsageMap", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Z", "shouldRegisterSurfaces", AlipayXuiIsland.REASON_CLOSED, "camera-camera2-pipe"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class r implements T, AutoCloseable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final StreamGraph streamGraphImpl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final X8.a<InterfaceC5703i> cameraController;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C5711q surfaceManager;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Map<Q, C.l> imageSources;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Map<Q, Surface> surfaceMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final Map<Surface, AutoCloseable> surfaceUsageMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public boolean shouldRegisterSurfaces;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public boolean closed;

    /* JADX WARN: Multi-variable type inference failed */
    public r(StreamGraph streamGraphImpl, X8.a<InterfaceC5703i> cameraController, C5711q surfaceManager, Map<Q, ? extends C.l> imageSources) {
        kotlin.jvm.internal.p.i(streamGraphImpl, "streamGraphImpl");
        kotlin.jvm.internal.p.i(cameraController, "cameraController");
        kotlin.jvm.internal.p.i(surfaceManager, "surfaceManager");
        kotlin.jvm.internal.p.i(imageSources, "imageSources");
        this.streamGraphImpl = streamGraphImpl;
        this.cameraController = cameraController;
        this.surfaceManager = surfaceManager;
        this.imageSources = imageSources;
        this.lock = new Object();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : imageSources.entrySet()) {
            linkedHashMap.put(entry.getKey(), ((C.l) entry.getValue()).getSurface());
        }
        this.surfaceMap = linkedHashMap;
        this.surfaceUsageMap = new LinkedHashMap();
        this.shouldRegisterSurfaces = true;
    }

    @Override // w.T
    public void b() throws Exception {
        List listM1;
        synchronized (this.lock) {
            this.shouldRegisterSurfaces = false;
            listM1 = F.m1(this.surfaceUsageMap.values());
            this.surfaceUsageMap.clear();
        }
        Iterator it = listM1.iterator();
        while (it.hasNext()) {
            C5423E.a((AutoCloseable) it.next());
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() throws Exception {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.surfaceMap.clear();
            List listM1 = F.m1(this.surfaceUsageMap.values());
            this.surfaceUsageMap.clear();
            Iterator it = listM1.iterator();
            while (it.hasNext()) {
                C5423E.a((AutoCloseable) it.next());
            }
        }
    }

    @Override // w.T
    public void e() {
        synchronized (this.lock) {
            try {
                if (this.closed) {
                    throw new IllegalStateException("Check failed.");
                }
                for (Surface surface : this.surfaceMap.values()) {
                    this.surfaceUsageMap.put(surface, this.surfaceManager.d(surface));
                }
                this.shouldRegisterSurfaces = true;
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Map<Q, Surface> g() {
        synchronized (this.lock) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (StreamGraph.c cVar : this.streamGraphImpl.D0()) {
                for (androidx.camera.camera2.pipe.k kVar : cVar.k()) {
                    Surface surface = this.surfaceMap.get(Q.a(kVar.getId()));
                    if (surface != null) {
                        linkedHashMap.put(Q.a(kVar.getId()), surface);
                    } else if (!cVar.b()) {
                        return kotlin.collections.a.i();
                    }
                }
            }
            return linkedHashMap;
        }
    }

    public final void i() {
        Map<Q, Surface> mapG = g();
        if (mapG.isEmpty()) {
            return;
        }
        this.cameraController.get().c(mapG);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r5, android.view.Surface r6) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A.r.l(int, android.view.Surface):void");
    }
}
