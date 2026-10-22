package X0;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private Class<?> f5796a;

    /* renamed from: b, reason: collision with root package name */
    private Class<?> f5797b;

    /* renamed from: c, reason: collision with root package name */
    private Class<?> f5798c;

    public i() {
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        this.f5796a = cls;
        this.f5797b = cls2;
        this.f5798c = cls3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f5796a.equals(iVar.f5796a) && this.f5797b.equals(iVar.f5797b) && k.d(this.f5798c, iVar.f5798c);
    }

    public int hashCode() {
        int iHashCode = ((this.f5796a.hashCode() * 31) + this.f5797b.hashCode()) * 31;
        Class<?> cls = this.f5798c;
        return iHashCode + (cls != null ? cls.hashCode() : 0);
    }

    public String toString() {
        return "MultiClassKey{first=" + this.f5796a + ", second=" + this.f5797b + '}';
    }

    public i(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        a(cls, cls2, cls3);
    }
}
