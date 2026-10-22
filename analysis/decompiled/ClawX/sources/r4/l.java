package r4;

import c5.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class l implements j {

    /* renamed from: c, reason: collision with root package name */
    public final Map f5104c;

    public l(Map values) {
        p.e(values, "values");
        b bVar = new b();
        for (Map.Entry entry : values.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i8 = 0; i8 < size; i8++) {
                arrayList.add((String) list.get(i8));
            }
            bVar.put(str, arrayList);
        }
        this.f5104c = bVar;
    }

    @Override // r4.j
    public final Set a() {
        Set setEntrySet = this.f5104c.entrySet();
        p.e(setEntrySet, "<this>");
        Set setUnmodifiableSet = Collections.unmodifiableSet(setEntrySet);
        p.d(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    @Override // r4.j
    public final void b(p5.p pVar) {
        for (Map.Entry entry : this.f5104c.entrySet()) {
            pVar.invoke((String) entry.getKey(), (List) entry.getValue());
        }
    }

    @Override // r4.j
    public final boolean c() {
        return true;
    }

    @Override // r4.j
    public final String d(String str) {
        List list = (List) this.f5104c.get(str);
        if (list != null) {
            return (String) m.v0(list);
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (true != jVar.c()) {
            return false;
        }
        return a().equals(jVar.a());
    }

    public final int hashCode() {
        Set setA = a();
        return setA.hashCode() + (Boolean.hashCode(true) * 961);
    }

    @Override // r4.j
    public final boolean isEmpty() {
        return this.f5104c.isEmpty();
    }
}
