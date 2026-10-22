package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public final float f5769c;

    /* renamed from: d, reason: collision with root package name */
    public final float f5770d;

    /* renamed from: e, reason: collision with root package name */
    public final float f5771e;

    /* renamed from: f, reason: collision with root package name */
    public final float f5772f;

    public x(float f5, float f10, float f11, float f12) {
        super(2);
        this.f5769c = f5;
        this.f5770d = f10;
        this.f5771e = f11;
        this.f5772f = f12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Float.compare(this.f5769c, xVar.f5769c) == 0 && Float.compare(this.f5770d, xVar.f5770d) == 0 && Float.compare(this.f5771e, xVar.f5771e) == 0 && Float.compare(this.f5772f, xVar.f5772f) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.f5772f) + k0.a.g(k0.a.g(Float.hashCode(this.f5769c) * 31, this.f5770d, 31), this.f5771e, 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("RelativeReflectiveCurveTo(dx1=");
        sb2.append(this.f5769c);
        sb2.append(", dy1=");
        sb2.append(this.f5770d);
        sb2.append(", dx2=");
        sb2.append(this.f5771e);
        sb2.append(", dy2=");
        return k0.a.q(sb2, this.f5772f, ')');
    }
}
