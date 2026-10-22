package androidx.compose.foundation.layout;

import s.f;
import u1.y0;
import w.d1;
import xb.p;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class WrapContentElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public final int f898c;

    /* renamed from: f, reason: collision with root package name */
    public final l f899f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f900g;

    /* JADX WARN: Multi-variable type inference failed */
    public WrapContentElement(int i, p pVar, Object obj) {
        this.f898c = i;
        this.f899f = (l) pVar;
        this.f900g = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WrapContentElement.class != obj.getClass()) {
            return false;
        }
        WrapContentElement wrapContentElement = (WrapContentElement) obj;
        return this.f898c == wrapContentElement.f898c && this.f900g.equals(wrapContentElement.f900g);
    }

    @Override // u1.y0
    public final w0.l g() {
        d1 d1Var = new d1();
        d1Var.f14964s = this.f898c;
        d1Var.f14965t = this.f899f;
        return d1Var;
    }

    public final int hashCode() {
        return this.f900g.hashCode() + k0.a.h(f.c(this.f898c) * 31, 31, false);
    }

    @Override // u1.y0
    public final void i(w0.l lVar) {
        d1 d1Var = (d1) lVar;
        d1Var.f14964s = this.f898c;
        d1Var.f14965t = this.f899f;
    }
}
