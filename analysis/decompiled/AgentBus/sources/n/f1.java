package n;

/* loaded from: classes.dex */
public final class f1 implements s {

    /* renamed from: a, reason: collision with root package name */
    public final int f6609a;

    /* renamed from: b, reason: collision with root package name */
    public final t f6610b;

    public f1(int i2, t tVar) {
        this.f6609a = i2;
        this.f6610b = tVar;
    }

    @Override // n.h
    public final h1 a(q6.b bVar) {
        return new d1.b(this.f6609a, this.f6610b);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f1)) {
            return false;
        }
        f1 f1Var = (f1) obj;
        return f1Var.f6609a == this.f6609a && q7.k.a(f1Var.f6610b, this.f6610b);
    }

    public final int hashCode() {
        return (this.f6610b.hashCode() + (this.f6609a * 31)) * 31;
    }

    @Override // n.s, n.h
    public final i1 a(q6.b bVar) {
        return new d1.b(this.f6609a, this.f6610b);
    }
}
