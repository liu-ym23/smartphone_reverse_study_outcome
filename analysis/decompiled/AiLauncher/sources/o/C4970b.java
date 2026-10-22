package o;

import D.C0761b0;
import D.InterfaceC0778o;
import K.InterfaceC0876c0;
import Z8.C1173v;
import Z8.C1174w;
import android.util.Log;
import androidx.camera.camera2.adapter.CameraInternalAdapter;
import androidx.camera.camera2.pipe.CameraGraph;
import androidx.camera.core.InitializationException;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraUpdateException;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import t.C5473b;
import u.C5553a;
import w.C5708n;
import w.InterfaceC5705k;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010&R*\u0010-\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0019\u0010(\u0012\u0004\b,\u0010\u000b\u001a\u0004\b)\u0010*\"\u0004\b+\u0010\u000fR4\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0.0.8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001b\u00100\u0012\u0004\b5\u0010\u000b\u001a\u0004\b1\u00102\"\u0004\b3\u00104R:\u0010>\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010078\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0013\u00108\u0012\u0004\b=\u0010\u000b\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R.\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00150\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u000e\u0010?\u0012\u0004\bC\u0010\u000b\u001a\u0004\b@\u0010A\"\u0004\bB\u0010\u0014R(\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00110E8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010?\u001a\u0004\bF\u0010A\"\u0004\bG\u0010\u0014R(\u0010M\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b \u0010I\u0012\u0004\bL\u0010\u000b\u001a\u0004\bJ\u0010\u001c\"\u0004\bK\u0010\u001fR(\u0010U\u001a\u00020N8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\n\u0010O\u0012\u0004\bT\u0010\u000b\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S¨\u0006V"}, d2 = {"Lo/b;", "LE/a;", "LK/c0;", "Landroidx/camera/camera2/pipe/h;", "cameraPipe", "Lw/k;", "cameraDevices", "<init>", "(Landroidx/camera/camera2/pipe/h;Lw/k;)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()V", "LK/N;", "repository", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LK/N;)V", "", "", "cameraIds", "f", "(Ljava/util/List;)V", "LD/o;", "cameraInfo", "c", "(LD/o;)V", Const.INTENT_KEY_UMID, "", "e", "()I", "cameraOperatingMode", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/h;", Const.INTENT_KEY_PKGNAME, "Lw/k;", "", "Ljava/lang/Object;", "lock", "LK/N;", "getCameraRepository", "()LK/N;", "setCameraRepository", "getCameraRepository$annotations", "cameraRepository", "", "Lw/n;", "Ljava/util/Set;", "getConcurrentCameraIdsSet", "()Ljava/util/Set;", "setConcurrentCameraIdsSet", "(Ljava/util/Set;)V", "getConcurrentCameraIdsSet$annotations", "concurrentCameraIdsSet", "", "Ljava/util/Map;", "getConcurrentCameraIdMap", "()Ljava/util/Map;", "setConcurrentCameraIdMap", "(Ljava/util/Map;)V", "getConcurrentCameraIdMap$annotations", "concurrentCameraIdMap", "Ljava/util/List;", "getActiveConcurrentCameraInfosList", "()Ljava/util/List;", "setActiveConcurrentCameraInfosList", "getActiveConcurrentCameraInfosList$annotations", "activeConcurrentCameraInfosList", "", "getPendingCameraIds", "setPendingCameraIds", "pendingCameraIds", "I", "getConcurrentMode", "setConcurrentMode", "getConcurrentMode$annotations", "concurrentMode", "", "Z", "getConcurrentModeOn", "()Z", "setConcurrentModeOn", "(Z)V", "getConcurrentModeOn$annotations", "concurrentModeOn", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: o.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4970b implements E.a, InterfaceC0876c0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public androidx.camera.camera2.pipe.h cameraPipe;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5705k cameraDevices;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object lock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public K.N cameraRepository;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public Set<? extends Set<C5708n>> concurrentCameraIdsSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public Map<String, ? extends List<String>> concurrentCameraIdMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public List<? extends InterfaceC0778o> activeConcurrentCameraInfosList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public List<String> pendingCameraIds;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public int concurrentMode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public boolean concurrentModeOn;

    public C4970b(androidx.camera.camera2.pipe.h hVar, InterfaceC5705k cameraDevices) {
        kotlin.jvm.internal.p.i(cameraDevices, "cameraDevices");
        this.cameraPipe = hVar;
        this.cameraDevices = cameraDevices;
        this.lock = new Object();
        this.concurrentCameraIdsSet = Z8.Y.e();
        this.concurrentCameraIdMap = kotlin.collections.a.i();
        this.activeConcurrentCameraInfosList = C1173v.m();
        this.pendingCameraIds = new ArrayList();
    }

    @Override // E.a
    public void c(InterfaceC0778o cameraInfo) {
        kotlin.jvm.internal.p.i(cameraInfo, "cameraInfo");
        synchronized (this.lock) {
            try {
                if (this.concurrentModeOn) {
                    List<String> list = this.pendingCameraIds;
                    String strA = C4978j.INSTANCE.a(cameraInfo);
                    C5708n c5708nA = strA != null ? C5708n.a(strA) : null;
                    if (c5708nA == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    list.add(c5708nA.getValue());
                    j();
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // E.a
    public void d(InterfaceC0778o cameraInfo) {
        kotlin.jvm.internal.p.i(cameraInfo, "cameraInfo");
        synchronized (this.lock) {
            try {
                if (this.concurrentModeOn) {
                    List<String> list = this.pendingCameraIds;
                    String strA = C4978j.INSTANCE.a(cameraInfo);
                    C5708n c5708nA = strA != null ? C5708n.a(strA) : null;
                    if (c5708nA == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    list.remove(c5708nA.getValue());
                }
                Y8.t tVar = Y8.t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // E.a
    public int e() {
        int i10;
        synchronized (this.lock) {
            i10 = this.concurrentMode;
        }
        return i10;
    }

    @Override // K.InterfaceC0876c0
    public void f(List<String> cameraIds) throws CameraUpdateException {
        kotlin.jvm.internal.p.i(cameraIds, "cameraIds");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Set<Set> setD = InterfaceC5705k.d(this.cameraDevices, null, 1, null);
            if (setD == null) {
                setD = Z8.Y.e();
            }
            for (Set set : setD) {
                Set set2 = set;
                ArrayList arrayList = new ArrayList(C1174w.x(set2, 10));
                Iterator it = set2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((C5708n) it.next()).getValue());
                }
                Set setR1 = Z8.F.r1(arrayList);
                if (cameraIds.containsAll(setR1)) {
                    List listM1 = Z8.F.m1(set);
                    if (listM1.size() >= 2) {
                        String value = ((C5708n) listM1.get(0)).getValue();
                        String value2 = ((C5708n) listM1.get(1)).getValue();
                        try {
                            if (C5553a.b(value, this.cameraDevices) && C5553a.b(value2, this.cameraDevices)) {
                                linkedHashSet.add(set);
                                if (!linkedHashMap.containsKey(value)) {
                                    linkedHashMap.put(value, new ArrayList());
                                }
                                Object obj = linkedHashMap.get(value);
                                kotlin.jvm.internal.p.f(obj);
                                ((List) obj).add(value2);
                                if (!linkedHashMap.containsKey(value2)) {
                                    linkedHashMap.put(value2, new ArrayList());
                                }
                                Object obj2 = linkedHashMap.get(value2);
                                kotlin.jvm.internal.p.f(obj2);
                                ((List) obj2).add(value);
                            }
                        } catch (InitializationException e10) {
                            C5473b c5473b = C5473b.f41865a;
                            if (C0761b0.k("CXCP")) {
                                Log.w(C5473b.TRUNCATED_TAG, "Skipping incompatible concurrent pair: " + set + " due to " + e10.getMessage());
                            }
                        }
                    }
                } else {
                    C5473b c5473b2 = C5473b.f41865a;
                    if (C0761b0.k("CXCP")) {
                        Log.w(C5473b.TRUNCATED_TAG, "Failed to retrieve concurrent camera: " + setR1 + " from " + cameraIds);
                    }
                }
            }
            synchronized (this.lock) {
                this.concurrentCameraIdsSet = linkedHashSet;
                this.concurrentCameraIdMap = linkedHashMap;
                Y8.t tVar = Y8.t.f7040a;
            }
        } catch (Exception e11) {
            throw new CameraUpdateException("Failed to retrieve concurrent camera id info for camera-pipe.", e11);
        }
    }

    @Override // E.a
    public void g(K.N repository) throws CameraUpdateException {
        List<String> listM;
        kotlin.jvm.internal.p.i(repository, "repository");
        synchronized (this.lock) {
            this.cameraRepository = repository;
            Y8.t tVar = Y8.t.f7040a;
        }
        List listG = InterfaceC5705k.g(this.cameraDevices, null, 1, null);
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
        f(listM);
    }

    @Override // E.a
    public void h(int cameraOperatingMode) {
        K.N n10;
        synchronized (this.lock) {
            this.concurrentMode = cameraOperatingMode;
            n10 = this.cameraRepository;
        }
        if (n10 == null) {
            return;
        }
        boolean z10 = cameraOperatingMode == 2;
        this.concurrentModeOn = z10;
        if (!z10) {
            this.activeConcurrentCameraInfosList = C1173v.m();
        }
        Iterator<CameraInternal> it = n10.m().iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            CameraInternal next = it.next();
            CameraInternalAdapter cameraInternalAdapter = next instanceof CameraInternalAdapter ? (CameraInternalAdapter) next : null;
            if (cameraInternalAdapter != null) {
                if (cameraOperatingMode == 1) {
                    cameraInternalAdapter.x(true);
                } else if (cameraOperatingMode == 2) {
                    cameraInternalAdapter.x(false);
                }
            }
        }
    }

    public void i() {
        this.cameraPipe = null;
        this.concurrentModeOn = false;
        synchronized (this.lock) {
            this.cameraRepository = null;
            this.concurrentCameraIdsSet = Z8.Y.e();
            this.concurrentCameraIdMap = kotlin.collections.a.i();
            this.activeConcurrentCameraInfosList = C1173v.m();
            this.concurrentMode = 0;
            this.pendingCameraIds.clear();
            Y8.t tVar = Y8.t.f7040a;
        }
    }

    public final void j() {
        CameraInternal cameraInternalL;
        synchronized (this.lock) {
            try {
                if (!this.activeConcurrentCameraInfosList.isEmpty() && !this.pendingCameraIds.isEmpty()) {
                    List<? extends InterfaceC0778o> list = this.activeConcurrentCameraInfosList;
                    ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            if (kotlin.jvm.internal.p.d(Z8.F.r1(arrayList), Z8.F.r1(this.pendingCameraIds))) {
                                this.pendingCameraIds.clear();
                                List<? extends InterfaceC0778o> list2 = this.activeConcurrentCameraInfosList;
                                synchronized (this.lock) {
                                    K.N n10 = this.cameraRepository;
                                    if (n10 == null) {
                                        C5473b c5473b = C5473b.f41865a;
                                        if (C0761b0.g("CXCP")) {
                                            Log.e(C5473b.TRUNCATED_TAG, "Coordinator has not been initialized with a CameraRepository.");
                                        }
                                        return;
                                    }
                                    ArrayList arrayList2 = new ArrayList();
                                    Iterator<T> it2 = list2.iterator();
                                    while (it2.hasNext()) {
                                        try {
                                            String strA = C4978j.INSTANCE.a((InterfaceC0778o) it2.next());
                                            kotlin.jvm.internal.p.f(strA);
                                            cameraInternalL = n10.l(strA);
                                        } catch (IllegalArgumentException unused) {
                                        }
                                        CameraInternalAdapter cameraInternalAdapter = cameraInternalL instanceof CameraInternalAdapter ? (CameraInternalAdapter) cameraInternalL : null;
                                        if (cameraInternalAdapter != null) {
                                            arrayList2.add(cameraInternalAdapter);
                                        }
                                    }
                                    ArrayList arrayList3 = new ArrayList(C1174w.x(arrayList2, 10));
                                    Iterator it3 = arrayList2.iterator();
                                    while (it3.hasNext()) {
                                        CameraGraph.b bVarV = ((CameraInternalAdapter) it3.next()).v();
                                        if (bVarV == null) {
                                            throw new IllegalStateException("Every CameraInternal instance is expected to have a deferred CameraGraph config");
                                        }
                                        arrayList3.add(bVarV);
                                    }
                                    androidx.camera.camera2.pipe.h hVar = this.cameraPipe;
                                    if (hVar == null) {
                                        throw new IllegalStateException("Required value was null.");
                                    }
                                    List<CameraGraph> listE = hVar.e(new CameraGraph.a(arrayList3));
                                    if (listE.size() != arrayList3.size()) {
                                        throw new IllegalStateException("Check failed.");
                                    }
                                    for (Pair pair : Z8.F.w1(arrayList2, listE)) {
                                        ((CameraInternalAdapter) pair.a()).w((CameraGraph) pair.b());
                                    }
                                    return;
                                }
                            }
                            return;
                        }
                        String strA2 = C4978j.INSTANCE.a((InterfaceC0778o) it.next());
                        C5708n c5708nA = strA2 != null ? C5708n.a(strA2) : null;
                        if (c5708nA == null) {
                            throw new IllegalStateException("Required value was null.");
                        }
                        arrayList.add(c5708nA.getValue());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
