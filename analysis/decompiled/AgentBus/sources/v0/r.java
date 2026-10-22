package v0;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final double f10338a;

    /* renamed from: b, reason: collision with root package name */
    public final double f10339b;

    /* renamed from: c, reason: collision with root package name */
    public final double f10340c;

    /* renamed from: d, reason: collision with root package name */
    public final double f10341d;

    /* renamed from: e, reason: collision with root package name */
    public final double f10342e;

    /* renamed from: f, reason: collision with root package name */
    public final double f10343f;

    /* renamed from: g, reason: collision with root package name */
    public final double f10344g;

    public /* synthetic */ r(double d6, double d10, double d11, double d12, double d13) {
        this(d6, d10, d11, d12, d13, 0.0d, 0.0d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return Double.compare(this.f10338a, rVar.f10338a) == 0 && Double.compare(this.f10339b, rVar.f10339b) == 0 && Double.compare(this.f10340c, rVar.f10340c) == 0 && Double.compare(this.f10341d, rVar.f10341d) == 0 && Double.compare(this.f10342e, rVar.f10342e) == 0 && Double.compare(this.f10343f, rVar.f10343f) == 0 && Double.compare(this.f10344g, rVar.f10344g) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.f10344g) + ((Double.hashCode(this.f10343f) + ((Double.hashCode(this.f10342e) + ((Double.hashCode(this.f10341d) + ((Double.hashCode(this.f10340c) + ((Double.hashCode(this.f10339b) + (Double.hashCode(this.f10338a) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "TransferParameters(gamma=" + this.f10338a + ", a=" + this.f10339b + ", b=" + this.f10340c + ", c=" + this.f10341d + ", d=" + this.f10342e + ", e=" + this.f10343f + ", f=" + this.f10344g + ')';
    }

    public r(double d6, double d10, double d11, double d12, double d13, double d14, double d15) {
        this.f10338a = d6;
        this.f10339b = d10;
        this.f10340c = d11;
        this.f10341d = d12;
        this.f10342e = d13;
        this.f10343f = d14;
        this.f10344g = d15;
        if (Double.isNaN(d10) || Double.isNaN(d11) || Double.isNaN(d12) || Double.isNaN(d13) || Double.isNaN(d14) || Double.isNaN(d15) || Double.isNaN(d6)) {
            throw new IllegalArgumentException("Parameters cannot be NaN");
        }
        if (d6 == -2.0d || d6 == -3.0d) {
            return;
        }
        if (d13 < 0.0d || d13 > 1.0d) {
            throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + d13);
        }
        if (d13 == 0.0d && (d10 == 0.0d || d6 == 0.0d)) {
            throw new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
        }
        if (d13 >= 1.0d && d12 == 0.0d) {
            throw new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
        }
        if ((d10 == 0.0d || d6 == 0.0d) && d12 == 0.0d) {
            throw new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
        }
        if (d12 < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be increasing");
        }
        if (d10 < 0.0d || d6 < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be positive or increasing");
        }
    }
}
