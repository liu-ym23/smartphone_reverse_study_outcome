package m2;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10480a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10481b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10482c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f10483d;

    public b(boolean z, boolean z3, boolean z10, boolean z11) {
        this.f10480a = z;
        this.f10481b = z3;
        this.f10482c = z10;
        this.f10483d = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f10480a == bVar.f10480a && this.f10481b == bVar.f10481b && this.f10482c == bVar.f10482c && this.f10483d == bVar.f10483d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f10483d) + ai.onnxruntime.a.f(ai.onnxruntime.a.f(Boolean.hashCode(this.f10480a) * 31, 31, this.f10481b), 31, this.f10482c);
    }

    public final String toString() {
        return "NetworkState(isConnected=" + this.f10480a + ", isValidated=" + this.f10481b + ", isMetered=" + this.f10482c + ", isNotRoaming=" + this.f10483d + ')';
    }
}
