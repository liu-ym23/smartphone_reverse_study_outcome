package e1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final double f3406a;

    /* renamed from: b, reason: collision with root package name */
    public final double f3407b;

    /* renamed from: c, reason: collision with root package name */
    public final double f3408c;

    /* renamed from: d, reason: collision with root package name */
    public final double f3409d;

    /* renamed from: e, reason: collision with root package name */
    public final double f3410e;

    /* renamed from: f, reason: collision with root package name */
    public final double f3411f;

    /* renamed from: g, reason: collision with root package name */
    public final double f3412g;

    public r(double d7, double d10, double d11, double d12, double d13, double d14, double d15) {
        this.f3406a = d7;
        this.f3407b = d10;
        this.f3408c = d11;
        this.f3409d = d12;
        this.f3410e = d13;
        this.f3411f = d14;
        this.f3412g = d15;
        if (Double.isNaN(d10) || Double.isNaN(d11) || Double.isNaN(d12) || Double.isNaN(d13) || Double.isNaN(d14) || Double.isNaN(d15) || Double.isNaN(d7)) {
            g5.f.s("Parameters cannot be NaN");
            throw null;
        }
        if (d7 == -2.0d || d7 == -3.0d) {
            return;
        }
        if (d13 < 0.0d || d13 > 1.0d) {
            throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + d13);
        }
        if (d13 == 0.0d && (d10 == 0.0d || d7 == 0.0d)) {
            g5.f.s("Parameter a or g is zero, the transfer function is constant");
            throw null;
        }
        if (d13 >= 1.0d && d12 == 0.0d) {
            g5.f.s("Parameter c is zero, the transfer function is constant");
            throw null;
        }
        if ((d10 == 0.0d || d7 == 0.0d) && d12 == 0.0d) {
            g5.f.s("Parameter a or g is zero, and c is zero, the transfer function is constant");
            throw null;
        }
        if (d12 < 0.0d) {
            g5.f.s("The transfer function must be increasing");
            throw null;
        }
        if (d10 < 0.0d || d7 < 0.0d) {
            g5.f.s("The transfer function must be positive or increasing");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Double.compare(this.f3406a, rVar.f3406a) == 0 && Double.compare(this.f3407b, rVar.f3407b) == 0 && Double.compare(this.f3408c, rVar.f3408c) == 0 && Double.compare(this.f3409d, rVar.f3409d) == 0 && Double.compare(this.f3410e, rVar.f3410e) == 0 && Double.compare(this.f3411f, rVar.f3411f) == 0 && Double.compare(this.f3412g, rVar.f3412g) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.f3412g) + ((Double.hashCode(this.f3411f) + ((Double.hashCode(this.f3410e) + ((Double.hashCode(this.f3409d) + ((Double.hashCode(this.f3408c) + ((Double.hashCode(this.f3407b) + (Double.hashCode(this.f3406a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TransferParameters(gamma=" + this.f3406a + ", a=" + this.f3407b + ", b=" + this.f3408c + ", c=" + this.f3409d + ", d=" + this.f3410e + ", e=" + this.f3411f + ", f=" + this.f3412g + ')';
    }

    public /* synthetic */ r(double d7, double d10, double d11, double d12, double d13) {
        this(d7, d10, d11, d12, d13, 0.0d, 0.0d);
    }
}
