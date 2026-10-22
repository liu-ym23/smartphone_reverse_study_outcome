package y;

import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public t0.c f15825a;

    /* renamed from: b, reason: collision with root package name */
    public b0.j f15826b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashMap f15827c;

    public final xb.p a(int i, Object obj, Object obj2) {
        LinkedHashMap linkedHashMap = this.f15827c;
        t tVar = (t) linkedHashMap.get(obj);
        int i3 = 10;
        if (tVar != null && tVar.f15822c == i && yb.k.a(tVar.f15821b, obj2)) {
            s0.c cVar = tVar.f15823d;
            if (cVar != null) {
                return cVar;
            }
            s0.c cVar2 = new s0.c(1403994769, true, new h0.k(i3, tVar.f15824e, tVar));
            tVar.f15823d = cVar2;
            return cVar2;
        }
        t tVar2 = new t();
        tVar2.f15824e = this;
        tVar2.f15820a = obj;
        tVar2.f15821b = obj2;
        tVar2.f15822c = i;
        VarHandle.storeStoreFence();
        linkedHashMap.put(obj, tVar2);
        s0.c cVar3 = tVar2.f15823d;
        if (cVar3 != null) {
            return cVar3;
        }
        s0.c cVar4 = new s0.c(1403994769, true, new h0.k(i3, this, tVar2));
        tVar2.f15823d = cVar4;
        return cVar4;
    }

    public final Object b(Object obj) {
        if (obj == null) {
            return null;
        }
        t tVar = (t) this.f15827c.get(obj);
        if (tVar != null) {
            return tVar.f15821b;
        }
        x.h hVar = (x.h) this.f15826b.invoke();
        int iB = hVar.f15415d.b(obj);
        if (iB != -1) {
            return hVar.b(iB);
        }
        return null;
    }
}
