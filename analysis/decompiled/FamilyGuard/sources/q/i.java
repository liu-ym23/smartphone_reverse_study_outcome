package q;

import W3.C0396g;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import r.C0990a;

/* loaded from: classes.dex */
public class i<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private int[] f19643a;

    /* renamed from: b, reason: collision with root package name */
    private Object[] f19644b;

    /* renamed from: c, reason: collision with root package name */
    private int f19645c;

    public i() {
        this(0, 1, null);
    }

    private final int c(K k5, int i5) {
        int i6 = this.f19645c;
        if (i6 == 0) {
            return -1;
        }
        int iA = C0990a.a(this.f19643a, i6, i5);
        if (iA < 0 || j4.k.b(k5, this.f19644b[iA << 1])) {
            return iA;
        }
        int i7 = iA + 1;
        while (i7 < i6 && this.f19643a[i7] == i5) {
            if (j4.k.b(k5, this.f19644b[i7 << 1])) {
                return i7;
            }
            i7++;
        }
        for (int i8 = iA - 1; i8 >= 0 && this.f19643a[i8] == i5; i8--) {
            if (j4.k.b(k5, this.f19644b[i8 << 1])) {
                return i8;
            }
        }
        return ~i7;
    }

    private final int e() {
        int i5 = this.f19645c;
        if (i5 == 0) {
            return -1;
        }
        int iA = C0990a.a(this.f19643a, i5, 0);
        if (iA < 0 || this.f19644b[iA << 1] == null) {
            return iA;
        }
        int i6 = iA + 1;
        while (i6 < i5 && this.f19643a[i6] == 0) {
            if (this.f19644b[i6 << 1] == null) {
                return i6;
            }
            i6++;
        }
        for (int i7 = iA - 1; i7 >= 0 && this.f19643a[i7] == 0; i7--) {
            if (this.f19644b[i7 << 1] == null) {
                return i7;
            }
        }
        return ~i6;
    }

    public final int a(V v5) {
        int i5 = this.f19645c * 2;
        Object[] objArr = this.f19644b;
        if (v5 == null) {
            for (int i6 = 1; i6 < i5; i6 += 2) {
                if (objArr[i6] == null) {
                    return i6 >> 1;
                }
            }
            return -1;
        }
        for (int i7 = 1; i7 < i5; i7 += 2) {
            if (j4.k.b(v5, objArr[i7])) {
                return i7 >> 1;
            }
        }
        return -1;
    }

    public void b(int i5) {
        int i6 = this.f19645c;
        int[] iArr = this.f19643a;
        if (iArr.length < i5) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i5);
            j4.k.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f19643a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f19644b, i5 * 2);
            j4.k.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f19644b = objArrCopyOf;
        }
        if (this.f19645c != i6) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        if (this.f19645c > 0) {
            this.f19643a = C0990a.f19951a;
            this.f19644b = C0990a.f19953c;
            this.f19645c = 0;
        }
        if (this.f19645c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K k5) {
        return d(k5) >= 0;
    }

    public boolean containsValue(V v5) {
        return a(v5) >= 0;
    }

    public int d(K k5) {
        return k5 == null ? e() : c(k5, k5.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof i) {
                if (size() != ((i) obj).size()) {
                    return false;
                }
                i iVar = (i) obj;
                int i5 = this.f19645c;
                for (int i6 = 0; i6 < i5; i6++) {
                    K kF = f(i6);
                    V vJ = j(i6);
                    Object obj2 = iVar.get(kF);
                    if (vJ == null) {
                        if (obj2 != null || !iVar.containsKey(kF)) {
                            return false;
                        }
                    } else if (!j4.k.b(vJ, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i7 = this.f19645c;
            for (int i8 = 0; i8 < i7; i8++) {
                K kF2 = f(i8);
                V vJ2 = j(i8);
                Object obj3 = ((Map) obj).get(kF2);
                if (vJ2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(kF2)) {
                        return false;
                    }
                } else if (!j4.k.b(vJ2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public K f(int i5) {
        if (i5 >= 0 && i5 < this.f19645c) {
            return (K) this.f19644b[i5 << 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
    }

    public void g(i<? extends K, ? extends V> iVar) {
        j4.k.g(iVar, "map");
        int i5 = iVar.f19645c;
        b(this.f19645c + i5);
        if (this.f19645c != 0) {
            for (int i6 = 0; i6 < i5; i6++) {
                put(iVar.f(i6), iVar.j(i6));
            }
        } else if (i5 > 0) {
            C0396g.d(iVar.f19643a, this.f19643a, 0, 0, i5);
            C0396g.f(iVar.f19644b, this.f19644b, 0, 0, i5 << 1);
            this.f19645c = i5;
        }
    }

    public V get(K k5) {
        int iD = d(k5);
        if (iD >= 0) {
            return (V) this.f19644b[(iD << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object obj, V v5) {
        int iD = d(obj);
        return iD >= 0 ? (V) this.f19644b[(iD << 1) + 1] : v5;
    }

    public V h(int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this.f19645c)) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        Object[] objArr = this.f19644b;
        int i7 = i5 << 1;
        V v5 = (V) objArr[i7 + 1];
        if (i6 <= 1) {
            clear();
            return v5;
        }
        int i8 = i6 - 1;
        int[] iArr = this.f19643a;
        if (iArr.length <= 8 || i6 >= iArr.length / 3) {
            if (i5 < i8) {
                int i9 = i5 + 1;
                C0396g.d(iArr, iArr, i5, i9, i6);
                Object[] objArr2 = this.f19644b;
                C0396g.f(objArr2, objArr2, i7, i9 << 1, i6 << 1);
            }
            Object[] objArr3 = this.f19644b;
            int i10 = i8 << 1;
            objArr3[i10] = null;
            objArr3[i10 + 1] = null;
        } else {
            int i11 = i6 > 8 ? i6 + (i6 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i11);
            j4.k.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f19643a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f19644b, i11 << 1);
            j4.k.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f19644b = objArrCopyOf;
            if (i6 != this.f19645c) {
                throw new ConcurrentModificationException();
            }
            if (i5 > 0) {
                C0396g.d(iArr, this.f19643a, 0, 0, i5);
                C0396g.f(objArr, this.f19644b, 0, 0, i7);
            }
            if (i5 < i8) {
                int i12 = i5 + 1;
                C0396g.d(iArr, this.f19643a, i5, i12, i6);
                C0396g.f(objArr, this.f19644b, i7, i12 << 1, i6 << 1);
            }
        }
        if (i6 != this.f19645c) {
            throw new ConcurrentModificationException();
        }
        this.f19645c = i8;
        return v5;
    }

    public int hashCode() {
        int[] iArr = this.f19643a;
        Object[] objArr = this.f19644b;
        int i5 = this.f19645c;
        int i6 = 1;
        int i7 = 0;
        int iHashCode = 0;
        while (i7 < i5) {
            Object obj = objArr[i6];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i7];
            i7++;
            i6 += 2;
        }
        return iHashCode;
    }

    public V i(int i5, V v5) {
        if (i5 < 0 || i5 >= this.f19645c) {
            throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
        }
        int i6 = (i5 << 1) + 1;
        Object[] objArr = this.f19644b;
        V v6 = (V) objArr[i6];
        objArr[i6] = v5;
        return v6;
    }

    public boolean isEmpty() {
        return this.f19645c <= 0;
    }

    public V j(int i5) {
        if (i5 >= 0 && i5 < this.f19645c) {
            return (V) this.f19644b[(i5 << 1) + 1];
        }
        throw new IllegalArgumentException(("Expected index to be within 0..size()-1, but was " + i5).toString());
    }

    public V put(K k5, V v5) {
        int i5 = this.f19645c;
        int iHashCode = k5 != null ? k5.hashCode() : 0;
        int iC = k5 != null ? c(k5, iHashCode) : e();
        if (iC >= 0) {
            int i6 = (iC << 1) + 1;
            Object[] objArr = this.f19644b;
            V v6 = (V) objArr[i6];
            objArr[i6] = v5;
            return v6;
        }
        int i7 = ~iC;
        int[] iArr = this.f19643a;
        if (i5 >= iArr.length) {
            int i8 = 8;
            if (i5 >= 8) {
                i8 = (i5 >> 1) + i5;
            } else if (i5 < 4) {
                i8 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i8);
            j4.k.f(iArrCopyOf, "copyOf(this, newSize)");
            this.f19643a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f19644b, i8 << 1);
            j4.k.f(objArrCopyOf, "copyOf(this, newSize)");
            this.f19644b = objArrCopyOf;
            if (i5 != this.f19645c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i7 < i5) {
            int[] iArr2 = this.f19643a;
            int i9 = i7 + 1;
            C0396g.d(iArr2, iArr2, i9, i7, i5);
            Object[] objArr2 = this.f19644b;
            C0396g.f(objArr2, objArr2, i9 << 1, i7 << 1, this.f19645c << 1);
        }
        int i10 = this.f19645c;
        if (i5 == i10) {
            int[] iArr3 = this.f19643a;
            if (i7 < iArr3.length) {
                iArr3[i7] = iHashCode;
                Object[] objArr3 = this.f19644b;
                int i11 = i7 << 1;
                objArr3[i11] = k5;
                objArr3[i11 + 1] = v5;
                this.f19645c = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k5, V v5) {
        V v6 = get(k5);
        return v6 == null ? put(k5, v5) : v6;
    }

    public V remove(K k5) {
        int iD = d(k5);
        if (iD >= 0) {
            return h(iD);
        }
        return null;
    }

    public V replace(K k5, V v5) {
        int iD = d(k5);
        if (iD >= 0) {
            return i(iD, v5);
        }
        return null;
    }

    public int size() {
        return this.f19645c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f19645c * 28);
        sb.append('{');
        int i5 = this.f19645c;
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            K kF = f(i6);
            if (kF != sb) {
                sb.append(kF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vJ = j(i6);
            if (vJ != sb) {
                sb.append(vJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        j4.k.f(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public i(int i5) {
        this.f19643a = i5 == 0 ? C0990a.f19951a : new int[i5];
        this.f19644b = i5 == 0 ? C0990a.f19953c : new Object[i5 << 1];
    }

    public boolean remove(K k5, V v5) {
        int iD = d(k5);
        if (iD < 0 || !j4.k.b(v5, j(iD))) {
            return false;
        }
        h(iD);
        return true;
    }

    public boolean replace(K k5, V v5, V v6) {
        int iD = d(k5);
        if (iD < 0 || !j4.k.b(v5, j(iD))) {
            return false;
        }
        i(iD, v6);
        return true;
    }

    public /* synthetic */ i(int i5, int i6, j4.g gVar) {
        this((i6 & 1) != 0 ? 0 : i5);
    }

    public i(i<? extends K, ? extends V> iVar) {
        this(0, 1, null);
        if (iVar != null) {
            g(iVar);
        }
    }
}
