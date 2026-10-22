package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* loaded from: classes.dex */
public final class f1 implements Map.Entry, Comparable {

    /* renamed from: f, reason: collision with root package name */
    public final Comparable f847f;

    /* renamed from: g, reason: collision with root package name */
    public Object f848g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b1 f849h;

    public f1(b1 b1Var, Comparable comparable, Object obj) {
        this.f849h = b1Var;
        this.f847f = comparable;
        this.f848g = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f847f.compareTo(((f1) obj).f847f);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f847f;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f848g;
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
        return this.f847f;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f848g;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f847f;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f848g;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f849h.b();
        Object obj2 = this.f848g;
        this.f848g = obj;
        return obj2;
    }

    public final String toString() {
        return this.f847f + "=" + this.f848g;
    }
}
