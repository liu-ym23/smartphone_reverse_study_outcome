package p5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f11412a;

    public d(List<q5.b> list, o5.e eVar) {
        HashMap map = new HashMap();
        for (q5.b bVar : list) {
            ArrayList arrayListB = eVar.b(bVar);
            int size = arrayListB.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayListB.get(i10);
                i10++;
                ((List) map.computeIfAbsent(o5.d.a((String) obj), new o5.a(1))).add(bVar);
            }
        }
        this.f11412a = map;
    }

    @Override // p5.e
    public final List<q5.a> a(String str, String str2) {
        HashMap map = this.f11412a;
        if (map.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        List list = (List) map.get(str2);
        if (list == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(q5.a.a((q5.b) it.next(), 0, str.length()));
        }
        return arrayList;
    }

    @Override // p5.e
    public final boolean b() {
        return false;
    }
}
