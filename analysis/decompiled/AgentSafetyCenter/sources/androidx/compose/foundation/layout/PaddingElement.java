package androidx.compose.foundation.layout;

import o2.f;
import u1.y0;
import w.k0;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class PaddingElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public final float f886c;

    /* renamed from: f, reason: collision with root package name */
    public final float f887f;

    /* renamed from: g, reason: collision with root package name */
    public final float f888g;

    /* renamed from: h, reason: collision with root package name */
    public final float f889h;

    public PaddingElement(float f5, float f10, float f11, float f12) {
        this.f886c = f5;
        this.f887f = f10;
        this.f888g = f11;
        this.f889h = f12;
        if ((f5 >= 0.0f || f.b(f5, Float.NaN)) && ((f10 >= 0.0f || f.b(f10, Float.NaN)) && ((f11 >= 0.0f || f.b(f11, Float.NaN)) && (f12 >= 0.0f || f.b(f12, Float.NaN))))) {
            return;
        }
        g5.f.s("Padding must be non-negative");
        throw null;
    }

    public final boolean equals(Object obj) {
        PaddingElement paddingElement = obj instanceof PaddingElement ? (PaddingElement) obj : null;
        return paddingElement != null && f.b(this.f886c, paddingElement.f886c) && f.b(this.f887f, paddingElement.f887f) && f.b(this.f888g, paddingElement.f888g) && f.b(this.f889h, paddingElement.f889h);
    }

    @Override // u1.y0
    public final l g() {
        k0 k0Var = new k0();
        k0Var.f14995s = this.f886c;
        k0Var.f14996t = this.f887f;
        k0Var.f14997u = this.f888g;
        k0Var.f14998v = this.f889h;
        k0Var.f14999w = true;
        return k0Var;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + k0.a.g(k0.a.g(k0.a.g(Float.hashCode(this.f886c) * 31, this.f887f, 31), this.f888g, 31), this.f889h, 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        k0 k0Var = (k0) lVar;
        k0Var.f14995s = this.f886c;
        k0Var.f14996t = this.f887f;
        k0Var.f14997u = this.f888g;
        k0Var.f14998v = this.f889h;
        k0Var.f14999w = true;
    }
}
