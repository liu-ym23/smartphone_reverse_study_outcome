package o7;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends Number {

    /* renamed from: c, reason: collision with root package name */
    public final String f9258c;

    public j(String str) {
        this.f9258c = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f9258c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof j) {
            return this.f9258c.equals(((j) obj).f9258c);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f9258c);
    }

    public final int hashCode() {
        return this.f9258c.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f9258c;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return h.j(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f9258c;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return h.j(str).longValue();
        }
    }

    public final String toString() {
        return this.f9258c;
    }
}
