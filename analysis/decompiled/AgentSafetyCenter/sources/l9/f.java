package l9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f7777a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7778b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f7779c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f7780d;

    /* renamed from: e, reason: collision with root package name */
    public final xb.a f7781e;

    public f(String str, String str2, Integer num, Integer num2, xb.a aVar, int i) {
        num = (i & 8) != 0 ? null : num;
        num2 = (i & 16) != 0 ? null : num2;
        str2.getClass();
        this.f7777a = str;
        this.f7778b = str2;
        this.f7779c = num;
        this.f7780d = num2;
        this.f7781e = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f7777a.equals(fVar.f7777a) && yb.k.a(this.f7778b, fVar.f7778b) && yb.k.a(this.f7779c, fVar.f7779c) && yb.k.a(this.f7780d, fVar.f7780d) && yb.k.a(this.f7781e, fVar.f7781e);
    }

    public final int hashCode() {
        int iD = androidx.activity.b.d(this.f7777a.hashCode() * 31, 961, this.f7778b);
        Integer num = this.f7779c;
        int iHashCode = (iD + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f7780d;
        int iH = k0.a.h((iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31, 31, true);
        xb.a aVar = this.f7781e;
        return iH + (aVar != null ? aVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbP = androidx.activity.b.p("GongkongListRow(key=", this.f7777a, ", title=", this.f7778b, ", subtitle=null, iconRes=");
        sbP.append(this.f7779c);
        sbP.append(", iconSizeDp=");
        sbP.append(this.f7780d);
        sbP.append(", showAccessory=true, onClick=");
        sbP.append(this.f7781e);
        sbP.append(")");
        return sbP.toString();
    }
}
