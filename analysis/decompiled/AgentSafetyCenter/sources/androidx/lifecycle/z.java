package androidx.lifecycle;

import android.os.Looper;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends q {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1455b;

    /* renamed from: c, reason: collision with root package name */
    public o.a f1456c = new o.a();

    /* renamed from: d, reason: collision with root package name */
    public p f1457d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference f1458e;

    /* renamed from: f, reason: collision with root package name */
    public int f1459f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1460g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1461h;
    public final ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public final nc.t0 f1462j;

    public z(x xVar, boolean z10) {
        this.f1455b = z10;
        p pVar = p.f1419f;
        this.f1457d = pVar;
        this.i = new ArrayList();
        this.f1458e = new WeakReference(xVar);
        this.f1462j = nc.k0.a(pVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.lifecycle.e] */
    /* JADX WARN: Type inference failed for: r2v8, types: [androidx.lifecycle.v] */
    @Override // androidx.lifecycle.q
    public final void a(w wVar) {
        h hVar;
        y yVar;
        x xVar;
        wVar.getClass();
        e("addObserver");
        p pVar = this.f1457d;
        p pVar2 = p.f1418c;
        if (pVar != pVar2) {
            pVar2 = p.f1419f;
        }
        y yVar2 = new y();
        HashMap map = b0.f1359a;
        boolean z10 = wVar instanceof v;
        boolean z11 = wVar instanceof f;
        int i = 2;
        if (z10 && z11) {
            hVar = new h((f) wVar, (v) wVar);
        } else if (z11) {
            hVar = new h((f) wVar, null);
        } else if (z10) {
            hVar = (v) wVar;
        } else {
            Class<?> cls = wVar.getClass();
            if (b0.b(cls) == 2) {
                Object obj = b0.f1360b.get(cls);
                obj.getClass();
                List list = (List) obj;
                if (list.size() == 1) {
                    b0.a((Constructor) list.get(0), wVar);
                    throw null;
                }
                int size = list.size();
                j[] jVarArr = new j[size];
                if (size > 0) {
                    b0.a((Constructor) list.get(0), wVar);
                    throw null;
                }
                ?? eVar = new e(i);
                eVar.f1379f = jVarArr;
                VarHandle.storeStoreFence();
                hVar = eVar;
            } else {
                h hVar2 = new h(i);
                hVar2.f1389f = wVar;
                d dVar = d.f1367c;
                Class<?> cls2 = wVar.getClass();
                b bVarA = (b) dVar.f1368a.get(cls2);
                if (bVarA == null) {
                    bVarA = dVar.a(cls2, null);
                }
                hVar2.f1390g = bVarA;
                VarHandle.storeStoreFence();
                hVar = hVar2;
            }
        }
        yVar2.f1453b = hVar;
        yVar2.f1452a = pVar2;
        o.a aVar = this.f1456c;
        o.c cVar = (o.c) aVar.i.get(wVar);
        if (cVar != null) {
            yVar = cVar.f8964f;
        } else {
            HashMap map2 = aVar.i;
            o.c cVar2 = new o.c();
            cVar2.f8963c = wVar;
            cVar2.f8964f = yVar2;
            VarHandle.storeStoreFence();
            aVar.f8973h++;
            o.c cVar3 = aVar.f8971f;
            if (cVar3 == null) {
                aVar.f8970c = cVar2;
                aVar.f8971f = cVar2;
            } else {
                cVar3.f8965g = cVar2;
                cVar2.f8966h = cVar3;
                aVar.f8971f = cVar2;
            }
            map2.put(wVar, cVar2);
            yVar = null;
        }
        if (yVar == null && (xVar = (x) this.f1458e.get()) != null) {
            i = (this.f1459f != 0 || this.f1460g) ? 1 : 0;
            p pVarD = d(wVar);
            this.f1459f++;
            while (yVar2.f1452a.compareTo(pVarD) < 0 && this.f1456c.i.containsKey(wVar)) {
                p pVar3 = yVar2.f1452a;
                ArrayList arrayList = this.i;
                arrayList.add(pVar3);
                m mVar = o.Companion;
                p pVar4 = yVar2.f1452a;
                mVar.getClass();
                pVar4.getClass();
                int iOrdinal = pVar4.ordinal();
                o oVar = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : o.ON_RESUME : o.ON_START : o.ON_CREATE;
                if (oVar == null) {
                    ad.o.n(yVar2.f1452a, "no event up from ");
                    return;
                } else {
                    yVar2.a(xVar, oVar);
                    arrayList.remove(arrayList.size() - 1);
                    pVarD = d(wVar);
                }
            }
            if (i == 0) {
                h();
            }
            this.f1459f--;
        }
    }

    @Override // androidx.lifecycle.q
    public final p b() {
        return this.f1457d;
    }

    @Override // androidx.lifecycle.q
    public final void c(w wVar) {
        wVar.getClass();
        e("removeObserver");
        o.a aVar = this.f1456c;
        WeakHashMap weakHashMap = aVar.f8972g;
        HashMap map = aVar.i;
        o.c cVar = (o.c) map.get(wVar);
        if (cVar != null) {
            aVar.f8973h--;
            if (!weakHashMap.isEmpty()) {
                Iterator it = weakHashMap.keySet().iterator();
                while (it.hasNext()) {
                    ((o.e) it.next()).a(cVar);
                }
            }
            o.c cVar2 = cVar.f8966h;
            o.c cVar3 = cVar.f8965g;
            if (cVar2 != null) {
                cVar2.f8965g = cVar3;
            } else {
                aVar.f8970c = cVar3;
            }
            o.c cVar4 = cVar.f8965g;
            if (cVar4 != null) {
                cVar4.f8966h = cVar2;
            } else {
                aVar.f8971f = cVar2;
            }
            cVar.f8965g = null;
            cVar.f8966h = null;
        }
        map.remove(wVar);
    }

    public final p d(w wVar) {
        HashMap map = this.f1456c.i;
        o.c cVar = map.containsKey(wVar) ? ((o.c) map.get(wVar)).f8966h : null;
        p pVar = cVar != null ? cVar.f8964f.f1452a : null;
        ArrayList arrayList = this.i;
        p pVar2 = arrayList.isEmpty() ? null : (p) arrayList.get(arrayList.size() - 1);
        p pVar3 = this.f1457d;
        pVar3.getClass();
        if (pVar == null || pVar.compareTo(pVar3) >= 0) {
            pVar = pVar3;
        }
        return (pVar2 == null || pVar2.compareTo(pVar) >= 0) ? pVar : pVar2;
    }

    public final void e(String str) {
        if (this.f1455b) {
            n.a.W().f8611c.getClass();
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                return;
            }
            b8.z.j(k0.a.C("Method ", str, " must be called on the main thread"));
        }
    }

    public final void f(o oVar) {
        oVar.getClass();
        e("handleLifecycleEvent");
        g(oVar.a());
    }

    public final void g(p pVar) {
        if (this.f1457d == pVar) {
            return;
        }
        x xVar = (x) this.f1458e.get();
        p pVar2 = this.f1457d;
        pVar2.getClass();
        if (pVar2 == p.f1419f && pVar == p.f1418c) {
            throw new IllegalStateException(("State must be at least '" + p.f1420g + "' to be moved to '" + pVar + "' in component " + xVar).toString());
        }
        p pVar3 = p.f1418c;
        if (pVar2 == pVar3 && pVar2 != pVar) {
            throw new IllegalStateException(("State is '" + pVar3 + "' and cannot be moved to `" + pVar + "` in component " + xVar).toString());
        }
        this.f1457d = pVar;
        if (this.f1460g || this.f1459f != 0) {
            this.f1461h = true;
            return;
        }
        this.f1460g = true;
        h();
        this.f1460g = false;
        if (this.f1457d == pVar3) {
            this.f1456c = new o.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        r9.f1461h = false;
        r0 = r9.f1457d;
        r9 = r9.f1462j;
        r9.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        if (r0 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        r0 = oc.c.f9367b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        r9.g(null, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.z.h():void");
    }
}
