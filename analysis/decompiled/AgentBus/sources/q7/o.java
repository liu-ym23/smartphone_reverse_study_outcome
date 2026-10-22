package q7;

/* loaded from: classes.dex */
public final class o implements d {

    /* renamed from: f, reason: collision with root package name */
    public final Class f8814f;

    public o(Class cls, String str) {
        k.e(cls, "jClass");
        this.f8814f = cls;
    }

    @Override // q7.d
    public final Class c() {
        return this.f8814f;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return k.a(this.f8814f, ((o) obj).f8814f);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8814f.hashCode();
    }

    public final String toString() {
        return this.f8814f + " (Kotlin reflection is not available)";
    }
}
