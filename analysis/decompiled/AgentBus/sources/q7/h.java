package q7;

/* loaded from: classes.dex */
public abstract class h extends c implements g, w7.g {

    /* renamed from: l, reason: collision with root package name */
    public final int f8810l;

    /* renamed from: m, reason: collision with root package name */
    public final int f8811m;

    public h(int i2) {
        this(i2, b.f8796f, null, null, null, 0);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return getName().equals(hVar.getName()) && A().equals(hVar.A()) && this.f8811m == hVar.f8811m && this.f8810l == hVar.f8810l && k.a(this.f8801g, hVar.f8801g) && k.a(y(), hVar.y());
        }
        if (obj instanceof w7.g) {
            return obj.equals(a());
        }
        return false;
    }

    @Override // q7.g
    public final int getArity() {
        return this.f8810l;
    }

    public final int hashCode() {
        return A().hashCode() + ((getName().hashCode() + (y() == null ? 0 : y().hashCode() * 31)) * 31);
    }

    public final String toString() {
        w7.c cVarA = a();
        if (cVarA != this) {
            return cVarA.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // q7.c
    public final w7.c x() {
        return w.f8821a.a(this);
    }

    @Override // q7.c
    public final w7.c z() {
        w7.c cVarA = a();
        if (cVarA != this) {
            return (w7.g) cVarA;
        }
        throw new c7.i();
    }

    public h(int i2, Object obj) {
        this(i2, obj, null, null, null, 0);
    }

    public h(int i2, Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.f8810l = i2;
        this.f8811m = 0;
    }
}
