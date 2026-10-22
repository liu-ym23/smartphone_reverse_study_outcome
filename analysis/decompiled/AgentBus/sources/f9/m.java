package f9;

/* loaded from: classes.dex */
public final class m implements Comparable {

    /* renamed from: f, reason: collision with root package name */
    public final int f3569f;

    /* renamed from: g, reason: collision with root package name */
    public final m0 f3570g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f3571h;

    public m(int i2, m0 m0Var, boolean z4) {
        this.f3569f = i2;
        this.f3570g = m0Var;
        this.f3571h = z4;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f3569f - ((m) obj).f3569f;
    }
}
