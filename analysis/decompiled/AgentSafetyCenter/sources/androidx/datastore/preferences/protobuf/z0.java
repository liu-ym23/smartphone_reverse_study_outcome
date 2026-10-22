package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z0 implements Map.Entry, Comparable {

    /* renamed from: c, reason: collision with root package name */
    public final Comparable f1229c;

    /* renamed from: f, reason: collision with root package name */
    public Object f1230f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ y0 f1231g;

    public z0(y0 y0Var, Comparable comparable, Object obj) {
        this.f1231g = y0Var;
        this.f1229c = comparable;
        this.f1230f = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f1229c.compareTo(((z0) obj).f1229c);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f1229c;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f1230f;
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
        return this.f1229c;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f1230f;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f1229c;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f1230f;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f1231g.b();
        Object obj2 = this.f1230f;
        this.f1230f = obj;
        return obj2;
    }

    public final String toString() {
        return this.f1229c + "=" + this.f1230f;
    }
}
