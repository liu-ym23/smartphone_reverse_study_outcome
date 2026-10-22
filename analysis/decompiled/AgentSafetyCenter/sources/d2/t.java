package d2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t implements b {

    /* renamed from: a, reason: collision with root package name */
    public final int f3169a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3170b;

    /* renamed from: c, reason: collision with root package name */
    public final long f3171c;

    /* renamed from: d, reason: collision with root package name */
    public final n2.q f3172d;

    /* renamed from: e, reason: collision with root package name */
    public final v f3173e;

    /* renamed from: f, reason: collision with root package name */
    public final n2.i f3174f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3175g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3176h;
    public final n2.s i;

    public t(int i, int i3, long j10, n2.q qVar, v vVar, n2.i iVar, int i10, int i11, n2.s sVar) {
        this.f3169a = i;
        this.f3170b = i3;
        this.f3171c = j10;
        this.f3172d = qVar;
        this.f3173e = vVar;
        this.f3174f = iVar;
        this.f3175g = i10;
        this.f3176h = i11;
        this.i = sVar;
        if (o2.n.b(j10, o2.n.f9128c) || o2.n.d(j10) >= 0.0f) {
            return;
        }
        i2.a.b("lineHeight can't be negative (" + o2.n.d(j10) + ')');
    }

    public final t a(t tVar) {
        return tVar == null ? this : u.a(this, tVar.f3169a, tVar.f3170b, tVar.f3171c, tVar.f3172d, tVar.f3173e, tVar.f3174f, tVar.f3175g, tVar.f3176h, tVar.i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f3169a == tVar.f3169a && this.f3170b == tVar.f3170b && o2.n.b(this.f3171c, tVar.f3171c) && yb.k.a(this.f3172d, tVar.f3172d) && yb.k.a(this.f3173e, tVar.f3173e) && yb.k.a(this.f3174f, tVar.f3174f) && this.f3175g == tVar.f3175g && this.f3176h == tVar.f3176h && yb.k.a(this.i, tVar.i);
    }

    public final int hashCode() {
        int iB = s.f.b(this.f3170b, Integer.hashCode(this.f3169a) * 31, 31);
        o2.o[] oVarArr = o2.n.f9127b;
        int i = k0.a.i(this.f3171c, iB, 31);
        n2.q qVar = this.f3172d;
        int iHashCode = (i + (qVar != null ? qVar.hashCode() : 0)) * 31;
        v vVar = this.f3173e;
        int iHashCode2 = (iHashCode + (vVar != null ? vVar.hashCode() : 0)) * 31;
        n2.i iVar = this.f3174f;
        int iB2 = s.f.b(this.f3176h, s.f.b(this.f3175g, (iHashCode2 + (iVar != null ? iVar.hashCode() : 0)) * 31, 31), 31);
        n2.s sVar = this.i;
        return iB2 + (sVar != null ? sVar.hashCode() : 0);
    }

    public final String toString() {
        return "ParagraphStyle(textAlign=" + ((Object) n2.k.b(this.f3169a)) + ", textDirection=" + ((Object) n2.m.a(this.f3170b)) + ", lineHeight=" + ((Object) o2.n.e(this.f3171c)) + ", textIndent=" + this.f3172d + ", platformStyle=" + this.f3173e + ", lineHeightStyle=" + this.f3174f + ", lineBreak=" + ((Object) n2.e.a(this.f3175g)) + ", hyphens=" + ((Object) n2.d.a(this.f3176h)) + ", textMotion=" + this.i + ')';
    }
}
