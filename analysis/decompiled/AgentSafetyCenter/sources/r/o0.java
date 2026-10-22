package r;

import s.h1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final yb.l f10325a;

    /* renamed from: b, reason: collision with root package name */
    public final h1 f10326b;

    /* JADX WARN: Multi-variable type inference failed */
    public o0(xb.l lVar, h1 h1Var) {
        this.f10325a = (yb.l) lVar;
        this.f10326b = h1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return this.f10325a.equals(o0Var.f10325a) && this.f10326b.equals(o0Var.f10326b);
    }

    public final int hashCode() {
        return this.f10326b.hashCode() + (this.f10325a.hashCode() * 31);
    }

    public final String toString() {
        return "Slide(slideOffset=" + this.f10325a + ", animationSpec=" + this.f10326b + ')';
    }
}
