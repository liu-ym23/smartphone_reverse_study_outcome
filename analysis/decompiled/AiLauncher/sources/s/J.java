package s;

import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.camera2.pipe.k;
import androidx.camera.core.impl.DeferrableSurface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.Metadata;
import o.C4961A;
import o.C4981m;
import p9.InterfaceC5063a;
import w.Q;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001BW\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u0002\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0011¢\u0006\u0004\b\u0019\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR&\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\"\u0010#\u001a\u0010\u0012\f\u0012\n !*\u0004\u0018\u00010\u00030\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\"R'\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\"\u001a\u0004\b%\u0010&R\u001b\u0010+\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\u001a\u0004\b$\u0010(*\u0004\b)\u0010*¨\u0006,"}, d2 = {"Ls/J;", "", "LX8/a;", "Landroidx/camera/camera2/pipe/CameraGraph;", "cameraGraphProvider", "Lo/m;", "cameraStateAdapter", "Lo/A;", "graphStateToCameraStateAdapter", "", "Landroidx/camera/camera2/pipe/k$a;", "Landroidx/camera/core/impl/DeferrableSurface;", "streamConfigMapProvider", "Lw/Q;", "defaultSurfaceToStreamMap", "<init>", "(LX8/a;Lo/m;Lo/A;LX8/a;Ljava/util/Map;)V", "LY8/t;", Const.INTENT_KEY_UMID, "()V", "", "deferrableSurfaces", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/util/Collection;)Ljava/util/Set;", "e", Const.INTENT_KEY_APIKEY, "LX8/a;", Const.INTENT_KEY_PKGNAME, "Lo/m;", "c", "Lo/A;", "LY8/h;", "kotlin.jvm.PlatformType", "LY8/h;", "_graph", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/util/Map;", "surfaceToStreamMap", "()Landroidx/camera/camera2/pipe/CameraGraph;", "getGraph$delegate", "(Ls/J;)Ljava/lang/Object;", "graph", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class J {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final X8.a<CameraGraph> cameraGraphProvider;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C4981m cameraStateAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final C4961A graphStateToCameraStateAdapter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final X8.a<Map<k.a, DeferrableSurface>> streamConfigMapProvider;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final Y8.h<CameraGraph> _graph;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final Y8.h surfaceToStreamMap;

    public J(X8.a<CameraGraph> cameraGraphProvider, C4981m cameraStateAdapter, C4961A graphStateToCameraStateAdapter, X8.a<Map<k.a, DeferrableSurface>> streamConfigMapProvider, final Map<DeferrableSurface, Q> map) {
        kotlin.jvm.internal.p.i(cameraGraphProvider, "cameraGraphProvider");
        kotlin.jvm.internal.p.i(cameraStateAdapter, "cameraStateAdapter");
        kotlin.jvm.internal.p.i(graphStateToCameraStateAdapter, "graphStateToCameraStateAdapter");
        kotlin.jvm.internal.p.i(streamConfigMapProvider, "streamConfigMapProvider");
        this.cameraGraphProvider = cameraGraphProvider;
        this.cameraStateAdapter = cameraStateAdapter;
        this.graphStateToCameraStateAdapter = graphStateToCameraStateAdapter;
        this.streamConfigMapProvider = streamConfigMapProvider;
        this._graph = C4848b.b(new InterfaceC5063a() { // from class: s.G
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return J.c(this.f39901a);
            }
        });
        this.surfaceToStreamMap = C4848b.b(new InterfaceC5063a() { // from class: s.H
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return J.i(map, this);
            }
        });
    }

    public static final CameraGraph c(J j10) {
        return j10.cameraGraphProvider.get();
    }

    public static final Map i(Map map, J j10) {
        if (map != null) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<k.a, DeferrableSurface> map2 = j10.streamConfigMapProvider.get();
        kotlin.jvm.internal.p.h(map2, "get(...)");
        for (Map.Entry<k.a, DeferrableSurface> entry : map2.entrySet()) {
            k.a key = entry.getKey();
            DeferrableSurface value = entry.getValue();
            androidx.camera.camera2.pipe.k kVarI = j10.f().d().i(key);
            if (kVarI != null) {
                linkedHashMap.put(value, Q.a(kVarI.getId()));
            }
        }
        return kotlin.collections.a.A(linkedHashMap);
    }

    public final void d() throws Exception {
        if (this._graph.isInitialized()) {
            C5423E.a(f());
        }
    }

    public final void e() {
        this.graphStateToCameraStateAdapter.g(f());
        this.cameraStateAdapter.h(f());
    }

    public final CameraGraph f() {
        CameraGraph value = this._graph.getValue();
        kotlin.jvm.internal.p.h(value, "getValue(...)");
        return value;
    }

    public final Set<Q> g(Collection<? extends DeferrableSurface> deferrableSurfaces) {
        kotlin.jvm.internal.p.i(deferrableSurfaces, "deferrableSurfaces");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = deferrableSurfaces.iterator();
        while (it.hasNext()) {
            Q q10 = h().get((DeferrableSurface) it.next());
            if (q10 != null) {
                linkedHashSet.add(Q.a(q10.getValue()));
            }
        }
        return linkedHashSet;
    }

    public final Map<DeferrableSurface, Q> h() {
        return (Map) this.surfaceToStreamMap.getValue();
    }

    public /* synthetic */ J(X8.a aVar, C4981m c4981m, C4961A c4961a, X8.a aVar2, Map map, int i10, kotlin.jvm.internal.i iVar) {
        this(aVar, c4981m, c4961a, aVar2, (i10 & 16) != 0 ? null : map);
    }
}
