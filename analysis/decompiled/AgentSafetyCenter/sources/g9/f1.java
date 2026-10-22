package g9;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f1 {

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashMap f4449a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedHashMap f4450b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashMap f4451c;

    /* renamed from: d, reason: collision with root package name */
    public nc.j0 f4452d;

    /* renamed from: e, reason: collision with root package name */
    public nc.t0 f4453e;

    /* renamed from: f, reason: collision with root package name */
    public nc.e0 f4454f;

    /* renamed from: g, reason: collision with root package name */
    public nc.f0 f4455g;

    public final void a(LinkedHashMap linkedHashMap) {
        LinkedHashMap linkedHashMap2 = this.f4450b;
        boolean z10 = false;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            z0 z0Var = (z0) entry.getValue();
            if (linkedHashMap2.get(str) != z0Var) {
                linkedHashMap2.put(str, z0Var);
                z10 = true;
            }
        }
        if (z10) {
            nc.t0 t0Var = this.f4453e;
            m1 m1VarB = b();
            t0Var.getClass();
            t0Var.g(null, m1VarB);
        }
    }

    public final m1 b() {
        LinkedHashMap linkedHashMap = this.f4451c;
        LinkedHashMap linkedHashMap2 = this.f4450b;
        List list = t.f4612c;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            kb.q.p0(((l1) it.next()).f4524b, arrayList);
        }
        ArrayList arrayList2 = new ArrayList(kb.m.m0(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (true) {
            long jLongValue = 0;
            if (i >= size) {
                break;
            }
            Object obj = arrayList.get(i);
            i++;
            w0 w0Var = (w0) obj;
            String str = w0Var.f4637a;
            z0 z0Var = (z0) linkedHashMap2.get(str);
            if (z0Var == null) {
                z0Var = w0Var.f4644h;
            }
            s0 s0Var = w0Var.f4642f;
            boolean z10 = w0Var.i;
            Long l2 = (Long) linkedHashMap.get(w0Var.f4637a);
            if (l2 != null) {
                jLongValue = l2.longValue();
            }
            arrayList2.add(new n1(str, z0Var, s0Var, z10, jLongValue));
        }
        Set setKeySet = this.f4449a.keySet();
        Set setKeySet2 = linkedHashMap2.keySet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : setKeySet2) {
            if (!setKeySet.contains((String) obj2)) {
                arrayList3.add(obj2);
            }
        }
        List<String> listH0 = kb.l.H0(arrayList3);
        ArrayList arrayList4 = new ArrayList(kb.m.m0(listH0, 10));
        for (String str2 : listH0) {
            z0 z0Var2 = (z0) kb.w.M(linkedHashMap2, str2);
            s0 s0Var2 = s0.f4608f;
            Long l10 = (Long) linkedHashMap.get(str2);
            arrayList4.add(new n1(str2, z0Var2, s0Var2, true, l10 != null ? l10.longValue() : 0L));
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayListF0 = kb.l.F0(arrayList2, arrayList4);
        m1 m1Var = new m1();
        m1Var.f4535a = jCurrentTimeMillis;
        m1Var.f4536b = arrayListF0;
        VarHandle.storeStoreFence();
        return m1Var;
    }

    public final void c(u0 u0Var, String str, z0 z0Var, z0 z0Var2, s0 s0Var) {
        nc.j0 j0Var = this.f4452d;
        String string = UUID.randomUUID().toString();
        string.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        str.getClass();
        s0Var.getClass();
        t0 t0Var = new t0();
        t0Var.f4615a = string;
        t0Var.f4616b = u0Var;
        t0Var.f4617c = str;
        t0Var.f4618d = z0Var;
        t0Var.f4619e = z0Var2;
        t0Var.f4620f = s0Var;
        t0Var.f4621g = jCurrentTimeMillis;
        t0Var.f4622h = "permission_manager";
        VarHandle.storeStoreFence();
        j0Var.o(t0Var);
    }
}
