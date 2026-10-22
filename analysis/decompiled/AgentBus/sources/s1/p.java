package s1;

/* loaded from: classes.dex */
public final class p implements b {

    /* renamed from: a, reason: collision with root package name */
    public final int f9293a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9294b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9295c;

    /* renamed from: d, reason: collision with root package name */
    public final c2.q f9296d;

    /* renamed from: e, reason: collision with root package name */
    public final r f9297e;

    /* renamed from: f, reason: collision with root package name */
    public final c2.i f9298f;

    /* renamed from: g, reason: collision with root package name */
    public final int f9299g;

    /* renamed from: h, reason: collision with root package name */
    public final int f9300h;

    /* renamed from: i, reason: collision with root package name */
    public final c2.s f9301i;

    public p(int i2, int i10, long j2, c2.q qVar, r rVar, c2.i iVar, int i11, int i12, c2.s sVar) {
        this.f9293a = i2;
        this.f9294b = i10;
        this.f9295c = j2;
        this.f9296d = qVar;
        this.f9297e = rVar;
        this.f9298f = iVar;
        this.f9299g = i11;
        this.f9300h = i12;
        this.f9301i = sVar;
        if (d2.n.a(j2, d2.n.f2798c) || d2.n.c(j2) >= 0.0f) {
            return;
        }
        x1.a.b("lineHeight can't be negative (" + d2.n.c(j2) + ')');
    }

    public final p a(p pVar) {
        return pVar == null ? this : q.a(this, pVar.f9293a, pVar.f9294b, pVar.f9295c, pVar.f9296d, pVar.f9297e, pVar.f9298f, pVar.f9299g, pVar.f9300h, pVar.f9301i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f9293a == pVar.f9293a && this.f9294b == pVar.f9294b && d2.n.a(this.f9295c, pVar.f9295c) && q7.k.a(this.f9296d, pVar.f9296d) && q7.k.a(this.f9297e, pVar.f9297e) && q7.k.a(this.f9298f, pVar.f9298f) && this.f9299g == pVar.f9299g && this.f9300h == pVar.f9300h && q7.k.a(this.f9301i, pVar.f9301i);
    }

    public final int hashCode() {
        int iB = n.f.b(this.f9294b, Integer.hashCode(this.f9293a) * 31, 31);
        d2.o[] oVarArr = d2.n.f2797b;
        int iF = m.x.f(this.f9295c, iB, 31);
        c2.q qVar = this.f9296d;
        int iHashCode = (iF + (qVar != null ? qVar.hashCode() : 0)) * 31;
        r rVar = this.f9297e;
        int iHashCode2 = (iHashCode + (rVar != null ? rVar.hashCode() : 0)) * 31;
        c2.i iVar = this.f9298f;
        int iB2 = n.f.b(this.f9300h, n.f.b(this.f9299g, (iHashCode2 + (iVar != null ? iVar.hashCode() : 0)) * 31, 31), 31);
        c2.s sVar = this.f9301i;
        return iB2 + (sVar != null ? sVar.hashCode() : 0);
    }

    public final String toString() {
        return "ParagraphStyle(textAlign=" + ((Object) c2.k.a(this.f9293a)) + ", textDirection=" + ((Object) c2.m.a(this.f9294b)) + ", lineHeight=" + ((Object) d2.n.d(this.f9295c)) + ", textIndent=" + this.f9296d + ", platformStyle=" + this.f9297e + ", lineHeightStyle=" + this.f9298f + ", lineBreak=" + ((Object) c2.e.a(this.f9299g)) + ", hyphens=" + ((Object) c2.d.a(this.f9300h)) + ", textMotion=" + this.f9301i + ')';
    }
}
