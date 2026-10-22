package androidx.compose.foundation;

import o1.i0;
import t.v;
import u1.y0;
import v.k;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class CombinedClickableElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public final k f848c;

    /* renamed from: f, reason: collision with root package name */
    public final xb.a f849f;

    public CombinedClickableElement(k kVar, xb.a aVar) {
        this.f848c = kVar;
        this.f849f = aVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CombinedClickableElement.class != obj.getClass()) {
            return false;
        }
        CombinedClickableElement combinedClickableElement = (CombinedClickableElement) obj;
        return yb.k.a(this.f848c, combinedClickableElement.f848c) && this.f849f == combinedClickableElement.f849f;
    }

    @Override // u1.y0
    public final l g() {
        return new v(this.f848c, null, true, null, null, this.f849f);
    }

    public final int hashCode() {
        k kVar = this.f848c;
        return (this.f849f.hashCode() + k0.a.h((kVar != null ? kVar.hashCode() : 0) * 961, 29791, true)) * 29791;
    }

    @Override // u1.y0
    public final void i(l lVar) {
        i0 i0Var;
        v vVar = (v) lVar;
        vVar.getClass();
        boolean z10 = !vVar.f12954y;
        vVar.I0(this.f848c, null, true, null, null, this.f849f);
        if (!z10 || (i0Var = vVar.C) == null) {
            return;
        }
        i0Var.C0();
    }
}
