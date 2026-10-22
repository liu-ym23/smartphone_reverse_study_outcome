package y;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final t.d f11382a;

    /* renamed from: b, reason: collision with root package name */
    public final t.d f11383b;

    /* renamed from: c, reason: collision with root package name */
    public final t.d f11384c;

    /* renamed from: d, reason: collision with root package name */
    public final t.d f11385d;

    /* renamed from: e, reason: collision with root package name */
    public final t.d f11386e;

    public e0() {
        t.d dVar = d0.f11373a;
        t.d dVar2 = d0.f11374b;
        t.d dVar3 = d0.f11375c;
        t.d dVar4 = d0.f11376d;
        t.d dVar5 = d0.f11377e;
        this.f11382a = dVar;
        this.f11383b = dVar2;
        this.f11384c = dVar3;
        this.f11385d = dVar4;
        this.f11386e = dVar5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return q7.k.a(this.f11382a, e0Var.f11382a) && q7.k.a(this.f11383b, e0Var.f11383b) && q7.k.a(this.f11384c, e0Var.f11384c) && q7.k.a(this.f11385d, e0Var.f11385d) && q7.k.a(this.f11386e, e0Var.f11386e);
    }

    public final int hashCode() {
        return this.f11386e.hashCode() + ((this.f11385d.hashCode() + ((this.f11384c.hashCode() + ((this.f11383b.hashCode() + (this.f11382a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Shapes(extraSmall=" + this.f11382a + ", small=" + this.f11383b + ", medium=" + this.f11384c + ", large=" + this.f11385d + ", extraLarge=" + this.f11386e + ')';
    }
}
