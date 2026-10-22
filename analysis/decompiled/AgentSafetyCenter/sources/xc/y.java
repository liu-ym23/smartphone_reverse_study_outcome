package xc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y implements tc.a {

    /* renamed from: a, reason: collision with root package name */
    public tc.a f15679a;

    /* renamed from: b, reason: collision with root package name */
    public h0 f15680b;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && y.class == obj.getClass() && this.f15679a.equals(((y) obj).f15679a);
    }

    @Override // tc.a
    public final vc.e getDescriptor() {
        return this.f15680b;
    }

    public final int hashCode() {
        return this.f15679a.hashCode();
    }
}
