package androidx.compose.foundation.layout;

import o2.f;
import u1.y0;
import w.i0;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class OffsetElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public float f881c;

    /* renamed from: f, reason: collision with root package name */
    public float f882f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f883g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetElement offsetElement = obj instanceof OffsetElement ? (OffsetElement) obj : null;
        return offsetElement != null && f.b(this.f881c, offsetElement.f881c) && f.b(this.f882f, offsetElement.f882f) && this.f883g == offsetElement.f883g;
    }

    @Override // u1.y0
    public final l g() {
        float f5 = this.f881c;
        float f10 = this.f882f;
        boolean z10 = this.f883g;
        i0 i0Var = new i0();
        i0Var.f14983s = f5;
        i0Var.f14984t = f10;
        i0Var.f14985u = z10;
        return i0Var;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f883g) + k0.a.g(Float.hashCode(this.f881c) * 31, this.f882f, 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        i0 i0Var = (i0) lVar;
        i0Var.f14983s = this.f881c;
        i0Var.f14984t = this.f882f;
        i0Var.f14985u = this.f883g;
    }

    public final String toString() {
        return "OffsetModifierElement(x=" + ((Object) f.c(this.f881c)) + ", y=" + ((Object) f.c(this.f882f)) + ", rtlAware=" + this.f883g + ')';
    }
}
