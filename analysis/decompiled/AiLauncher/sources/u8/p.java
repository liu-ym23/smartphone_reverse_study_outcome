package u8;

/* loaded from: classes4.dex */
public class p<T> {

    /* renamed from: a, reason: collision with root package name */
    public final String f42502a;

    public p(String str) {
        this.f42502a = str;
    }

    public static <T> p<T> c(String str) {
        return new p<>(str);
    }

    public T a(r rVar) {
        return (T) rVar.b(this);
    }

    public T b(r rVar, T t10) {
        return (T) rVar.c(this, t10);
    }

    public T d(r rVar) {
        T tA = a(rVar);
        if (tA != null) {
            return tA;
        }
        throw new NullPointerException(this.f42502a);
    }

    public void e(r rVar, T t10) {
        rVar.a(this, t10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f42502a.equals(((p) obj).f42502a);
    }

    public int hashCode() {
        return this.f42502a.hashCode();
    }

    public String toString() {
        return "Prop{name='" + this.f42502a + "'}";
    }
}
