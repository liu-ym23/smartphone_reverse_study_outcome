package ga;

import Y8.j;
import Z8.C1174w;
import Z8.Q;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import v9.C5685n;

/* loaded from: classes5.dex */
public final class i {
    public static final b l(String str) {
        c cVarB = h.f32812a.b();
        e eVarJ = e.j(str);
        p.h(eVarJ, "identifier(...)");
        return new b(cVarB, eVarJ);
    }

    public static final b m(String str) {
        c cVarD = h.f32812a.d();
        e eVarJ = e.j(str);
        p.h(eVarJ, "identifier(...)");
        return new b(cVarD, eVarJ);
    }

    public static final b n(String str) {
        c cVarG = h.f32812a.g();
        e eVarJ = e.j(str);
        p.h(eVarJ, "identifier(...)");
        return new b(cVarG, eVarJ);
    }

    public static final b o(String str) {
        c cVarC = h.f32812a.c();
        e eVarJ = e.j(str);
        p.h(eVarJ, "identifier(...)");
        return new b(cVarC, eVarJ);
    }

    public static final b p(String str) {
        c cVarE = h.f32812a.e();
        e eVarJ = e.j(str);
        p.h(eVarJ, "identifier(...)");
        return new b(cVarE, eVarJ);
    }

    public static final b q(String str) {
        c cVarF = h.f32812a.f();
        e eVarJ = e.j(str);
        p.h(eVarJ, "identifier(...)");
        return new b(cVarF, eVarJ);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<V, K> r(Map<K, ? extends V> map) {
        Set<Map.Entry<K, ? extends V>> setEntrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(C5685n.f(Q.e(C1174w.x(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pairA = j.a(entry.getValue(), entry.getKey());
            linkedHashMap.put(pairA.e(), pairA.f());
        }
        return linkedHashMap;
    }

    public static final b s(e eVar) {
        h hVar = h.f32812a;
        c cVarF = hVar.a().f();
        e eVarJ = e.j(eVar.e() + hVar.a().h().e());
        p.h(eVarJ, "identifier(...)");
        return new b(cVarF, eVarJ);
    }

    public static final b t(String str) {
        c cVarH = h.f32812a.h();
        e eVarJ = e.j(str);
        p.h(eVarJ, "identifier(...)");
        return new b(cVarH, eVarJ);
    }

    public static final b u(String str) {
        c cVarI = h.f32812a.i();
        e eVarJ = e.j(str);
        p.h(eVarJ, "identifier(...)");
        return new b(cVarI, eVarJ);
    }

    public static final b v(b bVar) {
        c cVarG = h.f32812a.g();
        e eVarJ = e.j('U' + bVar.h().e());
        p.h(eVarJ, "identifier(...)");
        return new b(cVarG, eVarJ);
    }
}
