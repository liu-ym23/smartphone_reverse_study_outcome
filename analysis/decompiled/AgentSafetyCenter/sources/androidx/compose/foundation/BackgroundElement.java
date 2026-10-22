package androidx.compose.foundation;

import d1.f0;
import d1.j0;
import d1.p;
import d1.y;
import t.h;
import u1.y0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class BackgroundElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public final long f836c;

    /* renamed from: f, reason: collision with root package name */
    public final f0 f837f;

    /* renamed from: g, reason: collision with root package name */
    public final float f838g;

    /* renamed from: h, reason: collision with root package name */
    public final j0 f839h;

    public BackgroundElement(long j10, y yVar, j0 j0Var, int i) {
        j10 = (i & 1) != 0 ? p.f3024g : j10;
        yVar = (i & 2) != 0 ? null : yVar;
        this.f836c = j10;
        this.f837f = yVar;
        this.f838g = 1.0f;
        this.f839h = j0Var;
    }

    public final boolean equals(Object obj) {
        BackgroundElement backgroundElement = obj instanceof BackgroundElement ? (BackgroundElement) obj : null;
        return backgroundElement != null && p.d(this.f836c, backgroundElement.f836c) && k.a(this.f837f, backgroundElement.f837f) && this.f838g == backgroundElement.f838g && k.a(this.f839h, backgroundElement.f839h);
    }

    @Override // u1.y0
    public final l g() {
        h hVar = new h();
        hVar.f12986s = this.f836c;
        hVar.f12987t = this.f837f;
        hVar.f12988u = this.f838g;
        hVar.f12989v = this.f839h;
        hVar.f12990w = 9205357640488583168L;
        return hVar;
    }

    public final int hashCode() {
        int i = p.f3025h;
        int iHashCode = Long.hashCode(this.f836c) * 31;
        f0 f0Var = this.f837f;
        return this.f839h.hashCode() + k0.a.g((iHashCode + (f0Var != null ? f0Var.hashCode() : 0)) * 31, this.f838g, 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        h hVar = (h) lVar;
        hVar.f12986s = this.f836c;
        hVar.f12987t = this.f837f;
        hVar.f12988u = this.f838g;
        hVar.f12989v = this.f839h;
    }
}
