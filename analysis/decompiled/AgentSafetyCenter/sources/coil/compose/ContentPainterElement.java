package coil.compose;

import k0.a;
import s1.j;
import u1.f;
import u1.y0;
import u5.l;
import u5.s;
import w0.e;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ContentPainterElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public l f2281c;

    /* renamed from: f, reason: collision with root package name */
    public e f2282f;

    /* renamed from: g, reason: collision with root package name */
    public j f2283g;

    /* renamed from: h, reason: collision with root package name */
    public float f2284h;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentPainterElement)) {
            return false;
        }
        ContentPainterElement contentPainterElement = (ContentPainterElement) obj;
        return k.a(this.f2281c, contentPainterElement.f2281c) && k.a(this.f2282f, contentPainterElement.f2282f) && k.a(this.f2283g, contentPainterElement.f2283g) && Float.compare(this.f2284h, contentPainterElement.f2284h) == 0;
    }

    @Override // u1.y0
    public final w0.l g() {
        l lVar = this.f2281c;
        e eVar = this.f2282f;
        j jVar = this.f2283g;
        float f5 = this.f2284h;
        s sVar = new s();
        sVar.f14091s = lVar;
        sVar.f14092t = eVar;
        sVar.f14093u = jVar;
        sVar.f14094v = f5;
        return sVar;
    }

    public final int hashCode() {
        return a.g((this.f2283g.hashCode() + ((this.f2282f.hashCode() + (this.f2281c.hashCode() * 31)) * 31)) * 31, this.f2284h, 31);
    }

    @Override // u1.y0
    public final void i(w0.l lVar) {
        s sVar = (s) lVar;
        long jH = sVar.f14091s.h();
        l lVar2 = this.f2281c;
        boolean zB = c1.e.b(jH, lVar2.h());
        sVar.f14091s = lVar2;
        sVar.f14092t = this.f2282f;
        sVar.f14093u = this.f2283g;
        sVar.f14094v = this.f2284h;
        if (!zB) {
            f.m(sVar);
        }
        f.l(sVar);
    }

    public final String toString() {
        return "ContentPainterElement(painter=" + this.f2281c + ", alignment=" + this.f2282f + ", contentScale=" + this.f2283g + ", alpha=" + this.f2284h + ", colorFilter=null)";
    }
}
