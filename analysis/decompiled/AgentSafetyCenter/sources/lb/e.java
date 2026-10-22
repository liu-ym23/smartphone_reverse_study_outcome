package lb;

import java.util.ConcurrentModificationException;
import java.util.Map;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements Map.Entry, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public f f7834c;

    /* renamed from: f, reason: collision with root package name */
    public int f7835f;

    /* renamed from: g, reason: collision with root package name */
    public int f7836g;

    public final void a() {
        if (this.f7834c.f7844l != this.f7836g) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return k.a(entry.getKey(), getKey()) && k.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.f7834c.f7838c[this.f7835f];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.f7834c.f7839f;
        objArr.getClass();
        return objArr[this.f7835f];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        a();
        f fVar = this.f7834c;
        fVar.c();
        Object[] objArr = fVar.f7839f;
        if (objArr == null) {
            int length = fVar.f7838c.length;
            if (length < 0) {
                g5.f.s("capacity must be non-negative.");
                return null;
            }
            objArr = new Object[length];
            fVar.f7839f = objArr;
        }
        int i = this.f7835f;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getKey());
        sb2.append('=');
        sb2.append(getValue());
        return sb2.toString();
    }
}
