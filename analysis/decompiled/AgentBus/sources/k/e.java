package k;

import androidx.datastore.preferences.protobuf.h1;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class e implements Map {

    /* renamed from: f, reason: collision with root package name */
    public int[] f5477f = l.a.f5724a;

    /* renamed from: g, reason: collision with root package name */
    public Object[] f5478g = l.a.f5726c;

    /* renamed from: h, reason: collision with root package name */
    public int f5479h;

    /* renamed from: i, reason: collision with root package name */
    public h1 f5480i;

    /* renamed from: j, reason: collision with root package name */
    public b f5481j;

    /* renamed from: k, reason: collision with root package name */
    public d f5482k;

    public final int a(Object obj) {
        int i2 = this.f5479h * 2;
        Object[] objArr = this.f5478g;
        if (obj == null) {
            for (int i10 = 1; i10 < i2; i10 += 2) {
                if (objArr[i10] == null) {
                    return i10 >> 1;
                }
            }
            return -1;
        }
        for (int i11 = 1; i11 < i2; i11 += 2) {
            if (obj.equals(objArr[i11])) {
                return i11 >> 1;
            }
        }
        return -1;
    }

    public final boolean b(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final boolean containsKey(Object obj) {
        return e(obj) >= 0;
    }

    @Override // java.util.Map
    public final void clear() {
        if (this.f5479h > 0) {
            this.f5477f = l.a.f5724a;
            this.f5478g = l.a.f5726c;
            this.f5479h = 0;
        }
        if (this.f5479h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public final int d(int i2, Object obj) {
        int i10 = this.f5479h;
        if (i10 == 0) {
            return -1;
        }
        int iA = l.a.a(i10, i2, this.f5477f);
        if (iA < 0 || q7.k.a(obj, this.f5478g[iA << 1])) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.f5477f[i11] == i2) {
            if (q7.k.a(obj, this.f5478g[i11 << 1])) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.f5477f[i12] == i2; i12--) {
            if (q7.k.a(obj, this.f5478g[i12 << 1])) {
                return i12;
            }
        }
        return ~i11;
    }

    public final int e(Object obj) {
        return obj == null ? f() : d(obj.hashCode(), obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        h1 h1Var = this.f5480i;
        if (h1Var != null) {
            return h1Var;
        }
        h1 h1Var2 = new h1(this, 3);
        this.f5480i = h1Var2;
        return h1Var2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof e) {
                int i2 = this.f5479h;
                if (i2 != ((e) obj).f5479h) {
                    return false;
                }
                e eVar = (e) obj;
                for (int i10 = 0; i10 < i2; i10++) {
                    Object objG = g(i10);
                    Object objK = k(i10);
                    Object obj2 = eVar.get(objG);
                    if (objK == null) {
                        if (obj2 != null || !eVar.containsKey(objG)) {
                            return false;
                        }
                    } else if (!objK.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f5479h != ((Map) obj).size()) {
                return false;
            }
            int i11 = this.f5479h;
            for (int i12 = 0; i12 < i11; i12++) {
                Object objG2 = g(i12);
                Object objK2 = k(i12);
                Object obj3 = ((Map) obj).get(objG2);
                if (objK2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objG2)) {
                        return false;
                    }
                } else if (!objK2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final int f() {
        int i2 = this.f5479h;
        if (i2 == 0) {
            return -1;
        }
        int iA = l.a.a(i2, 0, this.f5477f);
        if (iA < 0 || this.f5478g[iA << 1] == null) {
            return iA;
        }
        int i10 = iA + 1;
        while (i10 < i2 && this.f5477f[i10] == 0) {
            if (this.f5478g[i10 << 1] == null) {
                return i10;
            }
            i10++;
        }
        for (int i11 = iA - 1; i11 >= 0 && this.f5477f[i11] == 0; i11--) {
            if (this.f5478g[i11 << 1] == null) {
                return i11;
            }
        }
        return ~i10;
    }

    public final Object g(int i2) {
        boolean z4 = false;
        if (i2 >= 0 && i2 < this.f5479h) {
            z4 = true;
        }
        if (z4) {
            return this.f5478g[i2 << 1];
        }
        l.a.c("Expected index to be within 0..size()-1, but was " + i2);
        throw null;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return this.f5478g[(iE << 1) + 1];
        }
        return null;
    }

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        int iE = e(obj);
        return iE >= 0 ? this.f5478g[(iE << 1) + 1] : obj2;
    }

    @Override // java.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object remove(Object obj) {
        int iE = e(obj);
        if (iE >= 0) {
            return i(iE);
        }
        return null;
    }

    @Override // java.util.Map
    public final int hashCode() {
        int[] iArr = this.f5477f;
        Object[] objArr = this.f5478g;
        int i2 = this.f5479h;
        int i10 = 1;
        int i11 = 0;
        int iHashCode = 0;
        while (i11 < i2) {
            Object obj = objArr[i10];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i11];
            i11++;
            i10 += 2;
        }
        return iHashCode;
    }

    public final Object i(int i2) {
        int i10;
        if (i2 < 0 || i2 >= (i10 = this.f5479h)) {
            l.a.c("Expected index to be within 0..size()-1, but was " + i2);
            throw null;
        }
        Object[] objArr = this.f5478g;
        int i11 = i2 << 1;
        Object obj = objArr[i11 + 1];
        if (i10 <= 1) {
            clear();
            return obj;
        }
        int i12 = i10 - 1;
        int[] iArr = this.f5477f;
        if (iArr.length <= 8 || i10 >= iArr.length / 3) {
            if (i2 < i12) {
                int i13 = i2 + 1;
                d7.n.W(iArr, iArr, i2, i13, i10);
                Object[] objArr2 = this.f5478g;
                d7.n.Y(objArr2, objArr2, i11, i13 << 1, i10 << 1);
            }
            Object[] objArr3 = this.f5478g;
            int i14 = i12 << 1;
            objArr3[i14] = null;
            objArr3[i14 + 1] = null;
        } else {
            int i15 = i10 > 8 ? i10 + (i10 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i15);
            q7.k.d(iArrCopyOf, "copyOf(...)");
            this.f5477f = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f5478g, i15 << 1);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            this.f5478g = objArrCopyOf;
            if (i10 != this.f5479h) {
                throw new ConcurrentModificationException();
            }
            if (i2 > 0) {
                d7.n.W(iArr, this.f5477f, 0, 0, i2);
                d7.n.Y(objArr, this.f5478g, 0, 0, i11);
            }
            if (i2 < i12) {
                int i16 = i2 + 1;
                d7.n.W(iArr, this.f5477f, i2, i16, i10);
                d7.n.Y(objArr, this.f5478g, i11, i16 << 1, i10 << 1);
            }
        }
        if (i10 != this.f5479h) {
            throw new ConcurrentModificationException();
        }
        this.f5479h = i12;
        return obj;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f5479h <= 0;
    }

    public final Object j(int i2, Object obj) {
        boolean z4 = false;
        if (i2 >= 0 && i2 < this.f5479h) {
            z4 = true;
        }
        if (!z4) {
            l.a.c("Expected index to be within 0..size()-1, but was " + i2);
            throw null;
        }
        int i10 = (i2 << 1) + 1;
        Object[] objArr = this.f5478g;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        return obj2;
    }

    public final Object k(int i2) {
        boolean z4 = false;
        if (i2 >= 0 && i2 < this.f5479h) {
            z4 = true;
        }
        if (z4) {
            return this.f5478g[(i2 << 1) + 1];
        }
        l.a.c("Expected index to be within 0..size()-1, but was " + i2);
        throw null;
    }

    @Override // java.util.Map
    public final Set keySet() {
        b bVar = this.f5481j;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(this);
        this.f5481j = bVar2;
        return bVar2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        int i2 = this.f5479h;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iD = obj != null ? d(iHashCode, obj) : f();
        if (iD >= 0) {
            int i10 = (iD << 1) + 1;
            Object[] objArr = this.f5478g;
            Object obj3 = objArr[i10];
            objArr[i10] = obj2;
            return obj3;
        }
        int i11 = ~iD;
        int[] iArr = this.f5477f;
        if (i2 >= iArr.length) {
            int i12 = 8;
            if (i2 >= 8) {
                i12 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i12 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i12);
            q7.k.d(iArrCopyOf, "copyOf(...)");
            this.f5477f = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f5478g, i12 << 1);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            this.f5478g = objArrCopyOf;
            if (i2 != this.f5479h) {
                throw new ConcurrentModificationException();
            }
        }
        if (i11 < i2) {
            int[] iArr2 = this.f5477f;
            int i13 = i11 + 1;
            d7.n.W(iArr2, iArr2, i13, i11, i2);
            Object[] objArr2 = this.f5478g;
            d7.n.Y(objArr2, objArr2, i13 << 1, i11 << 1, this.f5479h << 1);
        }
        int i14 = this.f5479h;
        if (i2 == i14) {
            int[] iArr3 = this.f5477f;
            if (i11 < iArr3.length) {
                iArr3[i11] = iHashCode;
                Object[] objArr3 = this.f5478g;
                int i15 = i11 << 1;
                objArr3[i15] = obj;
                objArr3[i15 + 1] = obj2;
                this.f5479h = i14 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        int size = map.size() + this.f5479h;
        int i2 = this.f5479h;
        int[] iArr = this.f5477f;
        if (iArr.length < size) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, size);
            q7.k.d(iArrCopyOf, "copyOf(...)");
            this.f5477f = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f5478g, size * 2);
            q7.k.d(objArrCopyOf, "copyOf(...)");
            this.f5478g = objArrCopyOf;
        }
        if (this.f5479h != i2) {
            throw new ConcurrentModificationException();
        }
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    @Override // java.util.Map
    public final Object replace(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE >= 0) {
            return j(iE, obj2);
        }
        return null;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f5479h;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f5479h * 28);
        sb2.append('{');
        int i2 = this.f5479h;
        for (int i10 = 0; i10 < i2; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object objG = g(i10);
            if (objG != sb2) {
                sb2.append(objG);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            Object objK = k(i10);
            if (objK != sb2) {
                sb2.append(objK);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        d dVar = this.f5482k;
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(this);
        this.f5482k = dVar2;
        return dVar2;
    }

    @Override // java.util.Map
    public final boolean remove(Object obj, Object obj2) {
        int iE = e(obj);
        if (iE < 0 || !q7.k.a(obj2, k(iE))) {
            return false;
        }
        i(iE);
        return true;
    }

    @Override // java.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iE = e(obj);
        if (iE < 0 || !q7.k.a(obj2, k(iE))) {
            return false;
        }
        j(iE, obj3);
        return true;
    }
}
