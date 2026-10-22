package e6;

import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n implements h5.k {

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashMap f3587c;

    public h5.j b(p5.j jVar) {
        jVar.getClass();
        return (h5.j) this.f3587c.remove(jVar);
    }

    public List c(String str) {
        str.getClass();
        LinkedHashMap linkedHashMap = this.f3587c;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (yb.k.a(((p5.j) entry.getKey()).f9734a, str)) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap2.keySet().iterator();
        while (it.hasNext()) {
            linkedHashMap.remove((p5.j) it.next());
        }
        return kb.l.L0(linkedHashMap2.values());
    }

    public h5.j d(p5.j jVar) {
        LinkedHashMap linkedHashMap = this.f3587c;
        Object obj = linkedHashMap.get(jVar);
        Object obj2 = obj;
        if (obj == null) {
            h5.j jVar2 = new h5.j();
            jVar2.f5348a = jVar;
            VarHandle.storeStoreFence();
            linkedHashMap.put(jVar, jVar2);
            obj2 = jVar2;
        }
        return (h5.j) obj2;
    }
}
