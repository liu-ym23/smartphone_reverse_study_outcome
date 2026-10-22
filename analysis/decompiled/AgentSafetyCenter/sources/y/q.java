package y;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends w0.l implements u1.n {

    /* renamed from: s, reason: collision with root package name */
    public androidx.compose.foundation.lazy.layout.a f15815s;

    @Override // u1.n
    public final void b(u1.i0 i0Var) {
        ArrayList arrayList = this.f15815s.f922h;
        if (arrayList.size() <= 0) {
            i0Var.b();
        } else {
            w2.c.d(arrayList.get(0));
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q) && yb.k.a(this.f15815s, ((q) obj).f15815s);
    }

    public final int hashCode() {
        return this.f15815s.hashCode();
    }

    @Override // w0.l
    public final void t0() {
        this.f15815s.getClass();
    }

    public final String toString() {
        return "DisplayingDisappearingItemsNode(animator=" + this.f15815s + ')';
    }

    @Override // w0.l
    public final void u0() {
        this.f15815s.c();
    }
}
