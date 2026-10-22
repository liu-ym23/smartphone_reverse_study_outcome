package e7;

import java.util.ConcurrentModificationException;
import java.util.Map;
import q7.k;

/* loaded from: classes.dex */
public final class e implements Map.Entry, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final g f3091f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3092g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3093h;

    public e(g gVar, int i2) {
        k.e(gVar, "map");
        this.f3091f = gVar;
        this.f3092g = i2;
        this.f3093h = gVar.f3106m;
    }

    public final void a() {
        if (this.f3091f.f3106m != this.f3093h) {
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
        return this.f3091f.f3099f[this.f3092g];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        a();
        Object[] objArr = this.f3091f.f3100g;
        k.b(objArr);
        return objArr[this.f3092g];
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
        g gVar = this.f3091f;
        gVar.d();
        Object[] objArr = gVar.f3100g;
        if (objArr == null) {
            int length = gVar.f3099f.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            gVar.f3100g = objArr;
        }
        int i2 = this.f3092g;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
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
