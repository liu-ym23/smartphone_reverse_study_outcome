package f2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class d implements r4.k {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2554a;

    public d(Class cls) {
        this.f2554a = cls;
    }

    @Override // r4.k
    public Set a() {
        Set setEntrySet = ((Map) this.f2554a).entrySet();
        kotlin.jvm.internal.p.e(setEntrySet, "<this>");
        Set setUnmodifiableSet = Collections.unmodifiableSet(setEntrySet);
        kotlin.jvm.internal.p.d(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public void b(String name, String value) {
        kotlin.jvm.internal.p.e(name, "name");
        kotlin.jvm.internal.p.e(value, "value");
        m(value);
        e(name).add(value);
    }

    public void c(k4.o oVar) {
        oVar.b(new com.stepos.stepclaw.c(6, this));
    }

    public abstract com.google.crypto.tink.shaded.protobuf.a d(com.google.crypto.tink.shaded.protobuf.a aVar);

    public List e(String str) {
        Map map = (Map) this.f2554a;
        List list = (List) map.get(str);
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        l(str);
        map.put(str, arrayList);
        return arrayList;
    }

    public String f(String str) {
        List listG = g(str);
        if (listG != null) {
            return (String) c5.m.v0(listG);
        }
        return null;
    }

    public List g(String name) {
        kotlin.jvm.internal.p.e(name, "name");
        return (List) ((Map) this.f2554a).get(name);
    }

    public Map h() {
        return Collections.EMPTY_MAP;
    }

    public abstract com.google.crypto.tink.shaded.protobuf.a i(com.google.crypto.tink.shaded.protobuf.i iVar);

    @Override // r4.k
    public void j(String name, List values) {
        kotlin.jvm.internal.p.e(name, "name");
        kotlin.jvm.internal.p.e(values, "values");
        List listE = e(name);
        Iterator it = values.iterator();
        while (it.hasNext()) {
            m((String) it.next());
        }
        c5.m.p0(listE, values);
    }

    public abstract void k(com.google.crypto.tink.shaded.protobuf.a aVar);

    public void l(String name) {
        kotlin.jvm.internal.p.e(name, "name");
    }

    public void m(String value) {
        kotlin.jvm.internal.p.e(value, "value");
    }

    public d(int i8) {
        switch (i8) {
            case 2:
                this.f2554a = new LinkedHashMap();
                break;
            default:
                this.f2554a = new r4.b();
                break;
        }
    }
}
