package androidx.compose.foundation.layout;

import o2.f;
import u1.y0;
import w.u0;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class SizeElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public final float f891c;

    /* renamed from: f, reason: collision with root package name */
    public final float f892f;

    /* renamed from: g, reason: collision with root package name */
    public final float f893g;

    /* renamed from: h, reason: collision with root package name */
    public final float f894h;
    public final boolean i;

    public /* synthetic */ SizeElement(float f5, float f10, float f11, float f12, int i) {
        this((i & 1) != 0 ? Float.NaN : f5, (i & 2) != 0 ? Float.NaN : f10, (i & 4) != 0 ? Float.NaN : f11, (i & 8) != 0 ? Float.NaN : f12, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeElement)) {
            return false;
        }
        SizeElement sizeElement = (SizeElement) obj;
        return f.b(this.f891c, sizeElement.f891c) && f.b(this.f892f, sizeElement.f892f) && f.b(this.f893g, sizeElement.f893g) && f.b(this.f894h, sizeElement.f894h) && this.i == sizeElement.i;
    }

    @Override // u1.y0
    public final l g() {
        u0 u0Var = new u0();
        u0Var.f15050s = this.f891c;
        u0Var.f15051t = this.f892f;
        u0Var.f15052u = this.f893g;
        u0Var.f15053v = this.f894h;
        u0Var.f15054w = this.i;
        return u0Var;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.i) + k0.a.g(k0.a.g(k0.a.g(Float.hashCode(this.f891c) * 31, this.f892f, 31), this.f893g, 31), this.f894h, 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        u0 u0Var = (u0) lVar;
        u0Var.f15050s = this.f891c;
        u0Var.f15051t = this.f892f;
        u0Var.f15052u = this.f893g;
        u0Var.f15053v = this.f894h;
        u0Var.f15054w = this.i;
    }

    public SizeElement(float f5, float f10, float f11, float f12, boolean z10) {
        this.f891c = f5;
        this.f892f = f10;
        this.f893g = f11;
        this.f894h = f12;
        this.i = z10;
    }
}
