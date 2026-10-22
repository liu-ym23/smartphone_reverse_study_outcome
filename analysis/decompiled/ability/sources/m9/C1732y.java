package m9;

/* renamed from: m9.y, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1732y extends H7.a {
    public static final b0 b = new b0();

    /* renamed from: a, reason: collision with root package name */
    public final String f5339a;

    public C1732y(String str) {
        super(b);
        this.f5339a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C1732y) && kotlin.jvm.internal.k.b(this.f5339a, ((C1732y) obj).f5339a);
    }

    public final int hashCode() {
        return this.f5339a.hashCode();
    }

    public final String toString() {
        return B7.a.g(')', this.f5339a, new StringBuilder("CoroutineName("));
    }
}
