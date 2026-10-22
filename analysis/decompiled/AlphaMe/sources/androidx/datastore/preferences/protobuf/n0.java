package androidx.datastore.preferences.protobuf;

import com.stepos.alphame.utils.Consts;
import java.util.Map;

/* loaded from: classes.dex */
public final class n0 implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f3515a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3516b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k0 f3517c;

    public n0(k0 k0Var, Comparable comparable, Object obj) {
        this.f3517c = k0Var;
        this.f3515a = comparable;
        this.f3516b = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f3515a.compareTo(((n0) obj).f3515a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Comparable comparable = this.f3515a;
        if (comparable != null ? comparable.equals(key) : key == null) {
            Object obj2 = this.f3516b;
            Object value = entry.getValue();
            if (obj2 == null) {
                if (value == null) {
                    return true;
                }
            } else if (obj2.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f3515a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f3516b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f3515a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f3516b;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        int i4 = k0.f3500g;
        this.f3517c.b();
        Object obj2 = this.f3516b;
        this.f3516b = obj;
        return obj2;
    }

    public final String toString() {
        return this.f3515a + Consts.SPLITTER_EQUAL + this.f3516b;
    }
}
