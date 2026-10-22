package w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f15002a;

    /* renamed from: b, reason: collision with root package name */
    public final float f15003b;

    /* renamed from: c, reason: collision with root package name */
    public final float f15004c;

    /* renamed from: d, reason: collision with root package name */
    public final float f15005d;

    public l0(float f5, float f10, float f11, float f12) {
        this.f15002a = f5;
        this.f15003b = f10;
        this.f15004c = f11;
        this.f15005d = f12;
        if (f5 < 0.0f) {
            g5.f.s("Start padding must be non-negative");
            throw null;
        }
        if (f10 < 0.0f) {
            g5.f.s("Top padding must be non-negative");
            throw null;
        }
        if (f11 < 0.0f) {
            g5.f.s("End padding must be non-negative");
            throw null;
        }
        if (f12 >= 0.0f) {
            return;
        }
        g5.f.s("Bottom padding must be non-negative");
        throw null;
    }

    public final float a() {
        return this.f15005d;
    }

    public final float b(o2.l lVar) {
        return lVar == o2.l.f9123c ? this.f15002a : this.f15004c;
    }

    public final float c(o2.l lVar) {
        return lVar == o2.l.f9123c ? this.f15004c : this.f15002a;
    }

    public final float d() {
        return this.f15003b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return o2.f.b(this.f15002a, l0Var.f15002a) && o2.f.b(this.f15003b, l0Var.f15003b) && o2.f.b(this.f15004c, l0Var.f15004c) && o2.f.b(this.f15005d, l0Var.f15005d);
    }

    public final int hashCode() {
        return Float.hashCode(this.f15005d) + k0.a.g(k0.a.g(Float.hashCode(this.f15002a) * 31, this.f15003b, 31), this.f15004c, 31);
    }

    public final String toString() {
        return "PaddingValues(start=" + ((Object) o2.f.c(this.f15002a)) + ", top=" + ((Object) o2.f.c(this.f15003b)) + ", end=" + ((Object) o2.f.c(this.f15004c)) + ", bottom=" + ((Object) o2.f.c(this.f15005d)) + ')';
    }
}
