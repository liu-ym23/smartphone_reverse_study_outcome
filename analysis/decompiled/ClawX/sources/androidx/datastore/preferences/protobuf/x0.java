package androidx.datastore.preferences.protobuf;

import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x0 implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f581a;

    /* renamed from: b, reason: collision with root package name */
    public Object f582b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0 f583c;

    public x0(w0 w0Var, Comparable comparable, Object obj) {
        this.f583c = w0Var;
        this.f581a = comparable;
        this.f582b = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f581a.compareTo(((x0) obj).f581a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f581a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f582b;
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
        return this.f581a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f582b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f581a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f582b;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f583c.b();
        Object obj2 = this.f582b;
        this.f582b = obj;
        return obj2;
    }

    public final String toString() {
        return this.f581a + "=" + this.f582b;
    }
}
