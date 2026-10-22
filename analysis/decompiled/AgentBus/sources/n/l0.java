package n;

/* loaded from: classes.dex */
public final class l0 implements v {

    /* renamed from: a, reason: collision with root package name */
    public final float f6651a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6652b;

    public l0(float f10, Object obj) {
        this.f6651a = f10;
        this.f6652b = obj;
    }

    @Override // n.h
    public final h1 a(q6.b bVar) {
        Object obj = this.f6652b;
        return new a7.d(this.f6651a, obj == null ? null : (n) ((p7.k) bVar.f8788h).invoke(obj));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l0)) {
            return false;
        }
        l0 l0Var = (l0) obj;
        return l0Var.f6651a == this.f6651a && q7.k.a(l0Var.f6652b, this.f6652b);
    }

    public final int hashCode() {
        Object obj = this.f6652b;
        return Float.hashCode(this.f6651a) + m.x.d(1.0f, (obj != null ? obj.hashCode() : 0) * 31, 31);
    }
}
