package t8;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f13226a;

    /* renamed from: b, reason: collision with root package name */
    public final List f13227b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13228c;

    /* renamed from: d, reason: collision with root package name */
    public final a f13229d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13230e;

    /* renamed from: f, reason: collision with root package name */
    public final long f13231f;

    /* renamed from: g, reason: collision with root package name */
    public final String f13232g;

    public e(String str, List list, boolean z10, a aVar, int i, long j10, String str2) {
        list.getClass();
        aVar.getClass();
        this.f13226a = str;
        this.f13227b = list;
        this.f13228c = z10;
        this.f13229d = aVar;
        this.f13230e = i;
        this.f13231f = j10;
        this.f13232g = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f13226a.equals(eVar.f13226a) && yb.k.a(this.f13227b, eVar.f13227b) && this.f13228c == eVar.f13228c && this.f13229d == eVar.f13229d && this.f13230e == eVar.f13230e && this.f13231f == eVar.f13231f && yb.k.a(this.f13232g, eVar.f13232g);
    }

    public final int hashCode() {
        int i = k0.a.i(this.f13231f, s.f.b(this.f13230e, (this.f13229d.hashCode() + k0.a.h(androidx.activity.b.e(this.f13227b, this.f13226a.hashCode() * 31, 31), 31, this.f13228c)) * 31, 31), 31);
        String str = this.f13232g;
        return i + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "LocalDeleteTruthRecord(truthId=" + this.f13226a + ", paths=" + this.f13227b + ", success=" + this.f13228c + ", deleteMethod=" + this.f13229d + ", affectedCount=" + this.f13230e + ", executedAtMs=" + this.f13231f + ", trashRealPath=" + this.f13232g + ")";
    }
}
