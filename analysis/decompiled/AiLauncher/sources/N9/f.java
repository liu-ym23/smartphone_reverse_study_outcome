package N9;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4937a;

    public f(Object obj) {
        this.f4937a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && kotlin.jvm.internal.p.d(this.f4937a, ((f) obj).f4937a);
    }

    public int hashCode() {
        Object obj = this.f4937a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "KmConstantValue(value=" + this.f4937a + ')';
    }
}
