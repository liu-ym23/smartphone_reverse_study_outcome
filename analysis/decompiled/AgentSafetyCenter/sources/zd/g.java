package zd;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final yd.a f16587a;

    /* renamed from: b, reason: collision with root package name */
    public final yd.a f16588b;

    public g(yd.a aVar, yd.a aVar2) {
        this.f16587a = aVar;
        this.f16588b = aVar2;
    }

    public String a() {
        return "";
    }

    public abstract int b();

    public final boolean c(int i) {
        return b() == i;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        return "<" + getClass().getName() + "(" + a() + ")>";
    }
}
