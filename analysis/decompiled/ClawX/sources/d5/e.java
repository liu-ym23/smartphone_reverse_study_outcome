package d5;

import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements Map.Entry, q5.d {

    /* renamed from: a, reason: collision with root package name */
    public final g f1827a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1828b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1829c;

    public e(g map, int i8) {
        p.e(map, "map");
        this.f1827a = map;
        this.f1828b = i8;
        this.f1829c = map.f1840h;
    }

    public final void a() {
        if (this.f1827a.f1840h != this.f1829c) {
            throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
        }
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return p.a(entry.getKey(), getKey()) && p.a(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        a();
        return this.f1827a.f1834a[this.f1828b];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.f1827a.f1835b;
        p.b(objArr);
        return objArr[this.f1828b];
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
        g gVar = this.f1827a;
        gVar.c();
        Object[] objArr = gVar.f1835b;
        if (objArr == null) {
            int length = gVar.f1834a.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            gVar.f1835b = objArr;
        }
        int i8 = this.f1828b;
        Object obj2 = objArr[i8];
        objArr[i8] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
