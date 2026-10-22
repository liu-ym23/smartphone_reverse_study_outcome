package g2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f4242a;

    @Override // g2.p
    public final k a(k kVar) {
        int i = this.f4242a;
        return (i == 0 || i == Integer.MAX_VALUE) ? kVar : new k(p5.f.q(kVar.f4256c + i, 1, 1000));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f4242a == ((a) obj).f4242a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f4242a);
    }

    public final String toString() {
        return androidx.activity.b.l(new StringBuilder("AndroidFontResolveInterceptor(fontWeightAdjustment="), this.f4242a, ')');
    }
}
