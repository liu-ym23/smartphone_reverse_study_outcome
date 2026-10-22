package androidx.compose.ui.draw;

import d1.l;
import h1.b;
import s1.j;
import u1.f;
import u1.y0;
import w0.e;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class PainterElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public b f947c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f948f;

    /* renamed from: g, reason: collision with root package name */
    public e f949g;

    /* renamed from: h, reason: collision with root package name */
    public j f950h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public l f951j;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PainterElement)) {
            return false;
        }
        PainterElement painterElement = (PainterElement) obj;
        return k.a(this.f947c, painterElement.f947c) && this.f948f == painterElement.f948f && k.a(this.f949g, painterElement.f949g) && k.a(this.f950h, painterElement.f950h) && Float.compare(this.i, painterElement.i) == 0 && k.a(this.f951j, painterElement.f951j);
    }

    @Override // u1.y0
    public final w0.l g() {
        b bVar = this.f947c;
        boolean z10 = this.f948f;
        e eVar = this.f949g;
        j jVar = this.f950h;
        float f5 = this.i;
        l lVar = this.f951j;
        a1.j jVar2 = new a1.j();
        jVar2.f23s = bVar;
        jVar2.f24t = z10;
        jVar2.f25u = eVar;
        jVar2.f26v = jVar;
        jVar2.f27w = f5;
        jVar2.f28x = lVar;
        return jVar2;
    }

    public final int hashCode() {
        int iG = k0.a.g((this.f950h.hashCode() + ((this.f949g.hashCode() + k0.a.h(this.f947c.hashCode() * 31, 31, this.f948f)) * 31)) * 31, this.i, 31);
        l lVar = this.f951j;
        return iG + (lVar == null ? 0 : lVar.hashCode());
    }

    @Override // u1.y0
    public final void i(w0.l lVar) {
        a1.j jVar = (a1.j) lVar;
        b bVar = this.f947c;
        boolean z10 = jVar.f24t;
        boolean z11 = this.f948f;
        boolean z12 = z10 != z11 || (z11 && !c1.e.b(jVar.f23s.h(), bVar.h()));
        jVar.f23s = bVar;
        jVar.f24t = z11;
        jVar.f25u = this.f949g;
        jVar.f26v = this.f950h;
        jVar.f27w = this.i;
        jVar.f28x = this.f951j;
        if (z12) {
            f.m(jVar);
        }
        f.l(jVar);
    }

    public final String toString() {
        return "PainterElement(painter=" + this.f947c + ", sizeToIntrinsics=" + this.f948f + ", alignment=" + this.f949g + ", contentScale=" + this.f950h + ", alpha=" + this.i + ", colorFilter=" + this.f951j + ')';
    }
}
