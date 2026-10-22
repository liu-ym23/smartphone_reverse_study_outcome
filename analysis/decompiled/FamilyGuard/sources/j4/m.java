package j4;

/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f17830a;

    /* renamed from: b, reason: collision with root package name */
    private final String f17831b;

    public m(Class<?> cls, String str) {
        k.g(cls, "jClass");
        k.g(str, "moduleName");
        this.f17830a = cls;
        this.f17831b = str;
    }

    @Override // j4.d
    public Class<?> d() {
        return this.f17830a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && k.b(d(), ((m) obj).d());
    }

    public int hashCode() {
        return d().hashCode();
    }

    public String toString() {
        return d().toString() + " (Kotlin reflection is not available)";
    }
}
