package h0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l1 {

    /* renamed from: a, reason: collision with root package name */
    public a0.d f5054a;

    /* renamed from: b, reason: collision with root package name */
    public a0.d f5055b;

    /* renamed from: c, reason: collision with root package name */
    public a0.d f5056c;

    /* renamed from: d, reason: collision with root package name */
    public a0.d f5057d;

    /* renamed from: e, reason: collision with root package name */
    public a0.d f5058e;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l1)) {
            return false;
        }
        l1 l1Var = (l1) obj;
        return yb.k.a(this.f5054a, l1Var.f5054a) && yb.k.a(this.f5055b, l1Var.f5055b) && yb.k.a(this.f5056c, l1Var.f5056c) && yb.k.a(this.f5057d, l1Var.f5057d) && yb.k.a(this.f5058e, l1Var.f5058e);
    }

    public final int hashCode() {
        return this.f5058e.hashCode() + ((this.f5057d.hashCode() + ((this.f5056c.hashCode() + ((this.f5055b.hashCode() + (this.f5054a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Shapes(extraSmall=" + this.f5054a + ", small=" + this.f5055b + ", medium=" + this.f5056c + ", large=" + this.f5057d + ", extraLarge=" + this.f5058e + ')';
    }
}
