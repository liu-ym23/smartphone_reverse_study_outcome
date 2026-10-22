package u8;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f14213a;

    /* renamed from: b, reason: collision with root package name */
    public final p f14214b;

    /* renamed from: c, reason: collision with root package name */
    public final i f14215c;

    /* renamed from: d, reason: collision with root package name */
    public final List f14216d;

    /* renamed from: e, reason: collision with root package name */
    public final h f14217e;

    /* renamed from: f, reason: collision with root package name */
    public final List f14218f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kb.s] */
    public j(String str, p pVar, i iVar, ArrayList arrayList, h hVar, ArrayList arrayList2, int i) {
        int i3 = i & 8;
        ?? r12 = kb.s.f7404c;
        arrayList = i3 != 0 ? r12 : arrayList;
        hVar = (i & 16) != 0 ? null : hVar;
        arrayList2 = (i & 32) != 0 ? r12 : arrayList2;
        str.getClass();
        this.f14213a = str;
        this.f14214b = pVar;
        this.f14215c = iVar;
        this.f14216d = arrayList;
        this.f14217e = hVar;
        this.f14218f = arrayList2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return yb.k.a(this.f14213a, jVar.f14213a) && this.f14214b == jVar.f14214b && this.f14215c == jVar.f14215c && this.f14216d.equals(jVar.f14216d) && yb.k.a(this.f14217e, jVar.f14217e) && this.f14218f.equals(jVar.f14218f);
    }

    public final int hashCode() {
        int iE = androidx.activity.b.e(this.f14216d, (this.f14215c.hashCode() + ((this.f14214b.hashCode() + (this.f14213a.hashCode() * 31)) * 31)) * 31, 31);
        h hVar = this.f14217e;
        return this.f14218f.hashCode() + ((iE + (hVar == null ? 0 : hVar.f14208a.hashCode())) * 31);
    }

    public final String toString() {
        return "LocalUndoTruth(truthId=" + this.f14213a + ", domain=" + this.f14214b + ", state=" + this.f14215c + ", contacts=" + this.f14216d + ", file=" + this.f14217e + ", notes=" + this.f14218f + ")";
    }
}
