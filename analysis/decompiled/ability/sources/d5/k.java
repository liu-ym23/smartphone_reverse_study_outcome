package d5;

/* loaded from: classes3.dex */
public final class k extends l {

    /* renamed from: a, reason: collision with root package name */
    public final String f4301a;

    public k(String value) {
        kotlin.jvm.internal.k.f(value, "value");
        this.f4301a = value;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && kotlin.jvm.internal.k.b(this.f4301a, ((k) obj).f4301a);
    }

    public final int hashCode() {
        return this.f4301a.hashCode();
    }

    public final String toString() {
        return B7.a.m("StringValue(value=", this.f4301a, ")");
    }
}
