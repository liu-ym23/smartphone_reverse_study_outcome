package m7;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends g {

    /* renamed from: c, reason: collision with root package name */
    public final o7.n f8266c = new o7.n(false);

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof j) && ((j) obj).f8266c.equals(this.f8266c);
        }
        return true;
    }

    public final int hashCode() {
        return this.f8266c.hashCode();
    }

    public final void j(String str, g gVar) {
        if (gVar == null) {
            gVar = i.f8265c;
        }
        this.f8266c.put(str, gVar);
    }

    public final void k(String str, Long l2) {
        l lVar = new l();
        lVar.f8267c = l2;
        j(str, lVar);
    }

    public final void l(String str, String str2) {
        g gVar;
        if (str2 == null) {
            gVar = i.f8265c;
        } else {
            l lVar = new l();
            lVar.f8267c = str2;
            gVar = lVar;
        }
        j(str, gVar);
    }

    @Override // m7.g
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public final j a() {
        j jVar = new j();
        Iterator it = ((o7.l) this.f8266c.entrySet()).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            jVar.j((String) entry.getKey(), ((g) entry.getValue()).a());
        }
        return jVar;
    }

    public final g n(String str) {
        return (g) this.f8266c.get(str);
    }
}
