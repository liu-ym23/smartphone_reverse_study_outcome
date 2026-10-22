package androidx.lifecycle;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import la.u0;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1033a;

    /* renamed from: b, reason: collision with root package name */
    public j.a f1034b;

    /* renamed from: c, reason: collision with root package name */
    public q f1035c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f1036d;

    /* renamed from: e, reason: collision with root package name */
    public int f1037e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1038f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1039g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f1040h;

    /* renamed from: i, reason: collision with root package name */
    public final u0 f1041i;

    public x(v vVar) {
        new AtomicReference(null);
        this.f1033a = true;
        this.f1034b = new j.a();
        q qVar = q.f1021g;
        this.f1035c = qVar;
        this.f1040h = new ArrayList();
        this.f1036d = new WeakReference(vVar);
        this.f1041i = la.k0.c(qVar);
    }

    public final void a(u uVar) {
        t hVar;
        v vVar;
        q7.k.e(uVar, "observer");
        c("addObserver");
        q qVar = this.f1035c;
        q qVar2 = q.f1020f;
        if (qVar != qVar2) {
            qVar2 = q.f1021g;
        }
        w wVar = new w();
        HashMap map = y.f1042a;
        boolean z4 = uVar instanceof t;
        boolean z10 = uVar instanceof f;
        Object obj = null;
        if (z4 && z10) {
            hVar = new h((f) uVar, (t) uVar);
        } else if (z10) {
            hVar = new h((f) uVar, (t) null);
        } else if (z4) {
            hVar = (t) uVar;
        } else {
            Class<?> cls = uVar.getClass();
            if (y.b(cls) == 2) {
                Object obj2 = y.f1043b.get(cls);
                q7.k.b(obj2);
                List list = (List) obj2;
                if (list.size() == 1) {
                    y.a((Constructor) list.get(0), uVar);
                    throw null;
                }
                int size = list.size();
                j[] jVarArr = new j[size];
                if (size > 0) {
                    y.a((Constructor) list.get(0), uVar);
                    throw null;
                }
                hVar = new e(i, jVarArr);
            } else {
                hVar = new h(uVar);
            }
        }
        wVar.f1032b = hVar;
        wVar.f1031a = qVar2;
        j.a aVar = this.f1034b;
        j.c cVarA = aVar.a(uVar);
        if (cVarA != null) {
            obj = cVarA.f5056g;
        } else {
            HashMap map2 = aVar.f5051j;
            j.c cVar = new j.c(uVar, wVar);
            aVar.f5065i++;
            j.c cVar2 = aVar.f5063g;
            if (cVar2 == null) {
                aVar.f5062f = cVar;
                aVar.f5063g = cVar;
            } else {
                cVar2.f5057h = cVar;
                cVar.f5058i = cVar2;
                aVar.f5063g = cVar;
            }
            map2.put(uVar, cVar);
        }
        if (((w) obj) == null && (vVar = (v) this.f1036d.get()) != null) {
            i = (this.f1037e != 0 || this.f1038f) ? 1 : 0;
            q qVarB = b(uVar);
            this.f1037e++;
            while (wVar.f1031a.compareTo(qVarB) < 0 && this.f1034b.f5051j.containsKey(uVar)) {
                q qVar3 = wVar.f1031a;
                ArrayList arrayList = this.f1040h;
                arrayList.add(qVar3);
                n nVar = p.Companion;
                q qVar4 = wVar.f1031a;
                nVar.getClass();
                p pVarA = n.a(qVar4);
                if (pVarA == null) {
                    throw new IllegalStateException("no event up from " + wVar.f1031a);
                }
                wVar.a(vVar, pVarA);
                arrayList.remove(arrayList.size() - 1);
                qVarB = b(uVar);
            }
            if (i == 0) {
                g();
            }
            this.f1037e--;
        }
    }

    public final q b(u uVar) {
        HashMap map = this.f1034b.f5051j;
        j.c cVar = map.containsKey(uVar) ? ((j.c) map.get(uVar)).f5058i : null;
        q qVar = cVar != null ? ((w) cVar.f5056g).f1031a : null;
        ArrayList arrayList = this.f1040h;
        q qVar2 = arrayList.isEmpty() ? null : (q) arrayList.get(arrayList.size() - 1);
        q qVar3 = this.f1035c;
        q7.k.e(qVar3, "state1");
        if (qVar == null || qVar.compareTo(qVar3) >= 0) {
            qVar = qVar3;
        }
        return (qVar2 == null || qVar2.compareTo(qVar) >= 0) ? qVar : qVar2;
    }

    public final void c(String str) {
        if (this.f1033a) {
            i.a.S().f4389c.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(a1.a.j("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void d(p pVar) {
        q7.k.e(pVar, "event");
        c("handleLifecycleEvent");
        e(pVar.a());
    }

    public final void e(q qVar) {
        if (this.f1035c == qVar) {
            return;
        }
        v vVar = (v) this.f1036d.get();
        q qVar2 = this.f1035c;
        q7.k.e(qVar2, "current");
        if (qVar2 == q.f1021g && qVar == q.f1020f) {
            throw new IllegalStateException(("State must be at least '" + q.f1022h + "' to be moved to '" + qVar + "' in component " + vVar).toString());
        }
        q qVar3 = q.f1020f;
        if (qVar2 == qVar3 && qVar2 != qVar) {
            throw new IllegalStateException(("State is '" + qVar3 + "' and cannot be moved to `" + qVar + "` in component " + vVar).toString());
        }
        this.f1035c = qVar;
        if (this.f1038f || this.f1037e != 0) {
            this.f1039g = true;
            return;
        }
        this.f1038f = true;
        g();
        this.f1038f = false;
        if (this.f1035c == qVar3) {
            this.f1034b = new j.a();
        }
    }

    public final void f(u uVar) {
        q7.k.e(uVar, "observer");
        c("removeObserver");
        this.f1034b.f(uVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0030, code lost:
    
        r8.f1039g = false;
        r8.f1041i.f(r8.f1035c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.x.g():void");
    }
}
