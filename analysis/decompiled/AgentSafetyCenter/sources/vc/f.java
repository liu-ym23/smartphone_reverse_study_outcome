package vc;

import gc.p;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jb.k;
import kb.l;
import kb.m;
import kb.v;
import kb.w;
import kb.x;
import t.o;
import xc.a0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements e, xc.f {

    /* renamed from: a, reason: collision with root package name */
    public final String f14883a;

    /* renamed from: b, reason: collision with root package name */
    public final o f14884b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14885c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f14886d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f14887e;

    /* renamed from: f, reason: collision with root package name */
    public final e[] f14888f;

    /* renamed from: g, reason: collision with root package name */
    public final List[] f14889g;

    /* renamed from: h, reason: collision with root package name */
    public final e[] f14890h;
    public final k i;

    public f(String str, o oVar, int i, List list, a aVar) {
        this.f14883a = str;
        this.f14884b = oVar;
        this.f14885c = i;
        ArrayList arrayList = aVar.f14868b;
        arrayList.getClass();
        HashSet hashSet = new HashSet(x.L(m.m0(arrayList, 12)));
        l.K0(arrayList, hashSet);
        this.f14886d = hashSet;
        int i3 = 0;
        this.f14887e = (String[]) arrayList.toArray(new String[0]);
        this.f14888f = a0.c(aVar.f14870d);
        this.f14889g = (List[]) aVar.f14871e.toArray(new List[0]);
        ArrayList arrayList2 = aVar.f14872f;
        arrayList2.getClass();
        boolean[] zArr = new boolean[arrayList2.size()];
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            zArr[i3] = ((Boolean) obj).booleanValue();
            i3++;
        }
        String[] strArr = this.f14887e;
        strArr.getClass();
        ab.e eVar = new ab.e(9);
        eVar.f393f = strArr;
        VarHandle.storeStoreFence();
        p pVar = new p(1);
        pVar.f4707f = eVar;
        VarHandle.storeStoreFence();
        ArrayList arrayList3 = new ArrayList(m.m0(pVar, 10));
        Iterator it = pVar.iterator();
        while (true) {
            gc.c cVar = (gc.c) it;
            if (!cVar.f4681f.hasNext()) {
                w.Q(arrayList3);
                this.f14890h = a0.c(list);
                ab.e eVar2 = new ab.e(20);
                eVar2.f393f = this;
                VarHandle.storeStoreFence();
                this.i = new k(eVar2);
                return;
            }
            v vVar = (v) cVar.next();
            arrayList3.add(new jb.g(vVar.f7408b, Integer.valueOf(vVar.f7407a)));
        }
    }

    @Override // vc.e
    public final String a() {
        return this.f14883a;
    }

    @Override // xc.f
    public final Set b() {
        return this.f14886d;
    }

    @Override // vc.e
    public final boolean c() {
        return false;
    }

    @Override // vc.e
    public final int d() {
        return this.f14885c;
    }

    @Override // vc.e
    public final String e(int i) {
        return this.f14887e[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            e eVar = (e) obj;
            if (this.f14883a.equals(eVar.a()) && Arrays.equals(this.f14890h, ((f) obj).f14890h)) {
                int iD = eVar.d();
                int i = this.f14885c;
                if (i == iD) {
                    for (int i3 = 0; i3 < i; i3++) {
                        e[] eVarArr = this.f14888f;
                        if (yb.k.a(eVarArr[i3].a(), eVar.f(i3).a()) && yb.k.a(eVarArr[i3].getKind(), eVar.f(i3).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // vc.e
    public final e f(int i) {
        return this.f14888f[i];
    }

    @Override // vc.e
    public final o getKind() {
        return this.f14884b;
    }

    public final int hashCode() {
        return ((Number) this.i.getValue()).intValue();
    }

    public final String toString() {
        ec.g gVarO = p5.f.O(0, this.f14885c);
        String strConcat = this.f14883a.concat("(");
        a9.e eVar = new a9.e(17);
        eVar.f257f = this;
        VarHandle.storeStoreFence();
        return l.B0(gVarO, ", ", strConcat, ")", eVar, 24);
    }
}
