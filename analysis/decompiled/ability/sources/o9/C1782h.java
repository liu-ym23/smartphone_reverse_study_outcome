package o9;

/* renamed from: o9.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1782h {
    public static final C1781g b = new C1781g();

    /* renamed from: a, reason: collision with root package name */
    public final Object f5457a;

    public static final Object a(Object obj) {
        if (obj instanceof C1781g) {
            return null;
        }
        return obj;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1782h) {
            return kotlin.jvm.internal.k.b(this.f5457a, ((C1782h) obj).f5457a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f5457a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f5457a;
        if (obj instanceof C1780f) {
            return ((C1780f) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
