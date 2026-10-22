package j6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f6597a = new ConcurrentHashMap();

    public static Object a(String str, Class cls) {
        ConcurrentHashMap concurrentHashMap = f6597a;
        m7.e eVar = (m7.e) concurrentHashMap.get("delegateGson");
        if (eVar == null) {
            m7.e eVar2 = (m7.e) concurrentHashMap.get("defaultGson");
            if (eVar2 == null) {
                o7.d dVar = o7.d.f9247g;
                HashMap map = new HashMap();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                m7.a aVar = m7.e.f8250l;
                int i = m7.e.f8252n;
                int i3 = m7.e.f8253o;
                ArrayDeque arrayDeque = new ArrayDeque();
                ArrayList arrayList3 = new ArrayList(arrayList2.size() + arrayList.size() + 3);
                arrayList3.addAll(arrayList);
                Collections.reverse(arrayList3);
                ArrayList arrayList4 = new ArrayList(arrayList2);
                Collections.reverse(arrayList4);
                arrayList3.addAll(arrayList4);
                boolean z10 = s7.f.f11415a;
                m7.e eVar3 = new m7.e(dVar, 1, new HashMap(map), true, false, aVar, new ArrayList(arrayList), new ArrayList(arrayList2), arrayList3, i, i3, new ArrayList(arrayDeque));
                concurrentHashMap.put("defaultGson", eVar3);
                eVar = eVar3;
            } else {
                eVar = eVar2;
            }
        }
        return eVar.b(str, t7.a.get(cls));
    }
}
