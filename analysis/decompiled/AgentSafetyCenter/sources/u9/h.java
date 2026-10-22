package u9;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public float f14266a;

    /* renamed from: b, reason: collision with root package name */
    public float f14267b;

    /* renamed from: c, reason: collision with root package name */
    public float f14268c;

    /* renamed from: d, reason: collision with root package name */
    public float f14269d;

    /* renamed from: e, reason: collision with root package name */
    public float f14270e;

    /* renamed from: f, reason: collision with root package name */
    public float f14271f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14272g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return Float.compare(this.f14266a, hVar.f14266a) == 0 && Float.compare(this.f14267b, hVar.f14267b) == 0 && Float.compare(this.f14268c, hVar.f14268c) == 0 && Float.compare(this.f14269d, hVar.f14269d) == 0 && Float.compare(this.f14270e, hVar.f14270e) == 0 && Float.compare(this.f14271f, hVar.f14271f) == 0 && this.f14272g == hVar.f14272g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int iG = k0.a.g(k0.a.g(k0.a.g(k0.a.g(k0.a.g(Float.hashCode(this.f14266a) * 31, this.f14267b, 31), this.f14268c, 31), this.f14269d, 31), this.f14270e, 31), this.f14271f, 31);
        boolean z10 = this.f14272g;
        int i = z10;
        if (z10 != 0) {
            i = 1;
        }
        return iG + i;
    }

    public final String toString() {
        return "SmoothPathParams(left=" + this.f14266a + ", top=" + this.f14267b + ", right=" + this.f14268c + ", bottom=" + this.f14269d + ", smoothness=" + this.f14270e + ", radius=" + this.f14271f + ", useNativeRoundCornerWhileParamsInvalid=" + this.f14272g + ')';
    }
}
