package ka;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public static final m f5711b = new m();

    /* renamed from: a, reason: collision with root package name */
    public final Object f5712a;

    public static final Throwable a(Object obj) {
        l lVar = obj instanceof l ? (l) obj : null;
        if (lVar != null) {
            return lVar.f5710a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return q7.k.a(this.f5712a, ((n) obj).f5712a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f5712a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f5712a;
        if (obj instanceof l) {
            return ((l) obj).toString();
        }
        return "Value(" + obj + ')';
    }
}
