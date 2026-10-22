package f9;

import java.util.Map;

/* loaded from: classes.dex */
public final class e0 implements Comparable, Map.Entry {

    /* renamed from: f, reason: collision with root package name */
    public final Comparable f3548f;

    /* renamed from: g, reason: collision with root package name */
    public Object f3549g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a0 f3550h;

    public e0(a0 a0Var, Comparable comparable, Object obj) {
        this.f3550h = a0Var;
        this.f3548f = comparable;
        this.f3549g = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f3548f.compareTo(((e0) obj).f3548f);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f3548f;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f3549g;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f3548f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f3549g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f3548f;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f3549g;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f3550h.b();
        Object obj2 = this.f3549g;
        this.f3549g = obj;
        return obj2;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f3548f);
        String strValueOf2 = String.valueOf(this.f3549g);
        return m.x.n(new StringBuilder(strValueOf2.length() + strValueOf.length() + 1), strValueOf, "=", strValueOf2);
    }
}
