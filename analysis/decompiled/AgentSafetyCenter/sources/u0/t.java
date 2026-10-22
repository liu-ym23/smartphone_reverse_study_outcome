package u0;

import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import k0.i0;
import p.f0;
import p.g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final yb.l f13700a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f13701b = new AtomicReference(null);

    /* renamed from: c, reason: collision with root package name */
    public boolean f13702c;

    /* renamed from: d, reason: collision with root package name */
    public final e9.m f13703d;

    /* renamed from: e, reason: collision with root package name */
    public final a9.e f13704e;

    /* renamed from: f, reason: collision with root package name */
    public final m0.e f13705f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f13706g;

    /* renamed from: h, reason: collision with root package name */
    public b.b f13707h;
    public s i;

    /* renamed from: j, reason: collision with root package name */
    public long f13708j;

    /* JADX WARN: Multi-variable type inference failed */
    public t(xb.l lVar) {
        this.f13700a = (yb.l) lVar;
        e9.m mVar = new e9.m(14);
        mVar.f3688f = this;
        VarHandle.storeStoreFence();
        this.f13703d = mVar;
        a9.e eVar = new a9.e(16);
        eVar.f257f = this;
        VarHandle.storeStoreFence();
        this.f13704e = eVar;
        this.f13705f = new m0.e(new s[16]);
        this.f13706g = new Object();
        this.f13708j = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a() {
        boolean z10;
        Set set;
        Set set2;
        synchronized (this.f13706g) {
            z10 = this.f13702c;
        }
        if (z10) {
            return false;
        }
        boolean z11 = false;
        while (true) {
            AtomicReference atomicReference = this.f13701b;
            while (true) {
                Object obj = atomicReference.get();
                set = null;
                List list = null;
                List listSubList = null;
                if (obj == null) {
                    break;
                }
                if (obj instanceof Set) {
                    set2 = (Set) obj;
                } else {
                    if (!(obj instanceof List)) {
                        k0.t.d("Unexpected notification");
                        throw new androidx.fragment.app.d();
                    }
                    List list2 = (List) obj;
                    Set set3 = (Set) list2.get(0);
                    if (list2.size() == 2) {
                        listSubList = list2.get(1);
                    } else if (list2.size() > 2) {
                        listSubList = list2.subList(1, list2.size());
                    }
                    set2 = set3;
                    list = listSubList;
                }
                if (atomicReference.compareAndSet(obj, list)) {
                    set = set2;
                    break;
                }
            }
            if (set == null) {
                return z11;
            }
            synchronized (this.f13706g) {
                m0.e eVar = this.f13705f;
                Object[] objArr = eVar.f8158c;
                int i = eVar.f8160g;
                for (int i3 = 0; i3 < i; i3++) {
                    z11 = ((s) objArr[i3]).b(set) || z11;
                }
            }
        }
    }

    public final s b(xb.l lVar) {
        Object obj;
        m0.e eVar = this.f13705f;
        Object[] objArr = eVar.f8158c;
        int i = eVar.f8160g;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                obj = null;
                break;
            }
            obj = objArr[i3];
            if (((s) obj).f13689a == lVar) {
                break;
            }
            i3++;
        }
        s sVar = (s) obj;
        if (sVar != null) {
            return sVar;
        }
        lVar.getClass();
        yb.x.c(1, lVar);
        s sVar2 = new s();
        sVar2.f13689a = lVar;
        sVar2.f13692d = -1;
        sVar2.f13693e = h5.t.t();
        sVar2.f13694f = new f0();
        sVar2.f13695g = new g0();
        sVar2.f13696h = new m0.e(new i0[16]);
        k0.q qVar = new k0.q(1);
        qVar.f7023b = sVar2;
        VarHandle.storeStoreFence();
        sVar2.i = qVar;
        sVar2.f13698k = h5.t.t();
        sVar2.f13699l = new HashMap();
        VarHandle.storeStoreFence();
        eVar.b(sVar2);
        return sVar2;
    }

    public final void c() {
        e9.m mVar = this.f13703d;
        m.f(m.f13674a);
        synchronized (m.f13676c) {
            m.f13681h = kb.l.G0((List) m.f13681h, mVar);
        }
        b.b bVar = new b.b(7);
        bVar.f1685f = mVar;
        VarHandle.storeStoreFence();
        this.f13707h = bVar;
    }
}
