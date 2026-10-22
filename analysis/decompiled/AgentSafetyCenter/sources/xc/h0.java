package xc;

import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 implements vc.e, f {

    /* renamed from: a, reason: collision with root package name */
    public vc.e f15632a;

    /* renamed from: b, reason: collision with root package name */
    public String f15633b;

    /* renamed from: c, reason: collision with root package name */
    public Set f15634c;

    @Override // vc.e
    public final String a() {
        return this.f15633b;
    }

    @Override // xc.f
    public final Set b() {
        return this.f15634c;
    }

    @Override // vc.e
    public final boolean c() {
        return true;
    }

    @Override // vc.e
    public final int d() {
        return this.f15632a.d();
    }

    @Override // vc.e
    public final String e(int i) {
        return this.f15632a.e(i);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h0) && this.f15632a.equals(((h0) obj).f15632a);
    }

    @Override // vc.e
    public final vc.e f(int i) {
        return this.f15632a.f(i);
    }

    @Override // vc.e
    public final t.o getKind() {
        return this.f15632a.getKind();
    }

    public final int hashCode() {
        return this.f15632a.hashCode() * 31;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f15632a);
        sb2.append('?');
        return sb2.toString();
    }
}
