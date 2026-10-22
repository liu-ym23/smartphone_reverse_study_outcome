package h3;

import java.util.AbstractSet;
import java.util.Map;
import java.util.Set;
import q7.k;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f4095a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4096b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f4097c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f4098d;

    public e(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        k.e(abstractSet, "foreignKeys");
        this.f4095a = str;
        this.f4096b = map;
        this.f4097c = abstractSet;
        this.f4098d = abstractSet2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x01da, code lost:
    
        r9 = ib.k.i(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01de, code lost:
    
        r3.close();
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final h3.e a(n3.c r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 509
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.e.a(n3.c, java.lang.String):h3.e");
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!this.f4095a.equals(eVar.f4095a) || !this.f4096b.equals(eVar.f4096b) || !k.a(this.f4097c, eVar.f4097c)) {
            return false;
        }
        Set set2 = this.f4098d;
        if (set2 == null || (set = eVar.f4098d) == null) {
            return true;
        }
        return set2.equals(set);
    }

    public final int hashCode() {
        return this.f4097c.hashCode() + ((this.f4096b.hashCode() + (this.f4095a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TableInfo{name='" + this.f4095a + "', columns=" + this.f4096b + ", foreignKeys=" + this.f4097c + ", indices=" + this.f4098d + '}';
    }
}
