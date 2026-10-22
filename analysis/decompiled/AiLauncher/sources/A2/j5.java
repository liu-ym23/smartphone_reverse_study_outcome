package A2;

/* loaded from: classes2.dex */
public final class j5 extends n5 {

    /* renamed from: a, reason: collision with root package name */
    public final String f736a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f737b;

    /* renamed from: c, reason: collision with root package name */
    public final int f738c;

    public /* synthetic */ j5(String str, boolean z10, int i10, C0624h5 c0624h5) {
        this.f736a = str;
        this.f737b = z10;
        this.f738c = i10;
    }

    @Override // A2.n5
    public final int a() {
        return this.f738c;
    }

    @Override // A2.n5
    public final String b() {
        return this.f736a;
    }

    @Override // A2.n5
    public final boolean c() {
        return this.f737b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n5) {
            n5 n5Var = (n5) obj;
            if (this.f736a.equals(n5Var.b()) && this.f737b == n5Var.c() && this.f738c == n5Var.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.f736a.hashCode() ^ 1000003;
        return this.f738c ^ (((iHashCode * 1000003) ^ (true != this.f737b ? 1237 : 1231)) * 1000003);
    }

    public final String toString() {
        return "MLKitLoggingOptions{libraryName=" + this.f736a + ", enableFirelog=" + this.f737b + ", firelogEventType=" + this.f738c + "}";
    }
}
