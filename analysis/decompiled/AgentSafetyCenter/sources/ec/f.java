package ec;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class f implements Iterable, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final int f3758c;

    /* renamed from: f, reason: collision with root package name */
    public final int f3759f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3760g;

    public f(int i, int i3, int i10) {
        if (i10 == 0) {
            g5.f.s("Step must be non-zero.");
            throw null;
        }
        if (i10 == Integer.MIN_VALUE) {
            g5.f.s("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.f3758c = i;
        this.f3759f = com.stepos.statsrpk.h.r(i, i3, i10);
        this.f3760g = i10;
    }

    @Override // java.lang.Iterable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final a iterator() {
        boolean z10 = true;
        a aVar = new a(1);
        int i = this.f3760g;
        aVar.f3750f = i;
        int i3 = this.f3759f;
        aVar.f3751g = i3;
        int i10 = this.f3758c;
        if (i <= 0 ? i10 < i3 : i10 > i3) {
            z10 = false;
        }
        aVar.f3752h = z10;
        if (z10) {
            i3 = i10;
        }
        aVar.i = i3;
        VarHandle.storeStoreFence();
        return aVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        if (isEmpty() && ((f) obj).isEmpty()) {
            return true;
        }
        f fVar = (f) obj;
        return this.f3758c == fVar.f3758c && this.f3759f == fVar.f3759f && this.f3760g == fVar.f3760g;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3758c * 31) + this.f3759f) * 31) + this.f3760g;
    }

    public boolean isEmpty() {
        int i = this.f3759f;
        int i3 = this.f3760g;
        int i10 = this.f3758c;
        return i3 > 0 ? i10 > i : i10 < i;
    }

    public String toString() {
        StringBuilder sb2;
        int i = this.f3759f;
        int i3 = this.f3760g;
        int i10 = this.f3758c;
        if (i3 > 0) {
            sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append("..");
            sb2.append(i);
            sb2.append(" step ");
            sb2.append(i3);
        } else {
            sb2 = new StringBuilder();
            sb2.append(i10);
            sb2.append(" downTo ");
            sb2.append(i);
            sb2.append(" step ");
            sb2.append(-i3);
        }
        return sb2.toString();
    }
}
