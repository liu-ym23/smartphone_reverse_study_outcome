package q7;

/* loaded from: classes.dex */
public abstract class q extends c implements w7.t {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f8815l;

    public q(int i2, Class cls, Object obj, String str, String str2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.f8815l = (i2 & 2) == 2;
    }

    @Override // q7.c
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final w7.t z() {
        if (this.f8815l) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        w7.c cVarA = a();
        if (cVarA != this) {
            return (w7.t) cVarA;
        }
        throw new c7.i();
    }

    @Override // q7.c
    public final w7.c a() {
        return this.f8815l ? this : super.a();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            return y().equals(qVar.y()) && this.f8803i.equals(qVar.f8803i) && this.f8804j.equals(qVar.f8804j) && k.a(this.f8801g, qVar.f8801g);
        }
        if (obj instanceof w7.t) {
            return obj.equals(a());
        }
        return false;
    }

    public final int hashCode() {
        return this.f8804j.hashCode() + m.x.g(this.f8803i, y().hashCode() * 31, 31);
    }

    public final String toString() {
        w7.c cVarA = a();
        return cVarA != this ? cVarA.toString() : a1.a.m(new StringBuilder("property "), this.f8803i, " (Kotlin reflection is not available)");
    }
}
