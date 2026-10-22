package p;

import androidx.datastore.preferences.protobuf.b1;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class o<K, V> {

    /* renamed from: a, reason: collision with root package name */
    public int[] f11383a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f11384b;

    /* renamed from: c, reason: collision with root package name */
    public int f11385c;

    public o() {
        this(0);
    }

    public final int a(V v3) {
        int i10 = this.f11385c * 2;
        Object[] objArr = this.f11384b;
        if (v3 == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (v3.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i10) {
        int i11 = this.f11385c;
        int[] iArr = this.f11383a;
        if (iArr.length < i10) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
            kotlin.jvm.internal.g.e(iArrCopyOf, "copyOf(...)");
            this.f11383a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11384b, i10 * 2);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            this.f11384b = objArrCopyOf;
        }
        if (this.f11385c != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i10, Object obj) {
        int i11 = this.f11385c;
        if (i11 == 0) {
            return -1;
        }
        int iA = q.a.a(i11, i10, this.f11383a);
        if (iA < 0 || kotlin.jvm.internal.g.b(obj, this.f11384b[iA << 1])) {
            return iA;
        }
        int i12 = iA + 1;
        while (i12 < i11 && this.f11383a[i12] == i10) {
            if (kotlin.jvm.internal.g.b(obj, this.f11384b[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iA - 1; i13 >= 0 && this.f11383a[i13] == i10; i13--) {
            if (kotlin.jvm.internal.g.b(obj, this.f11384b[i13 << 1])) {
                return i13;
            }
        }
        return ~i12;
    }

    public final void clear() {
        if (this.f11385c > 0) {
            this.f11383a = q.a.f11482a;
            this.f11384b = q.a.f11484c;
            this.f11385c = 0;
        }
        if (this.f11385c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(K k9) {
        return e(k9) >= 0;
    }

    public boolean containsValue(V v3) {
        return a(v3) >= 0;
    }

    public final int e(K k9) {
        return k9 == null ? f() : c(k9.hashCode(), k9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof o) {
                int i10 = this.f11385c;
                if (i10 != ((o) obj).f11385c) {
                    return false;
                }
                o oVar = (o) obj;
                for (int i11 = 0; i11 < i10; i11++) {
                    K kG = g(i11);
                    V vJ = j(i11);
                    Object obj2 = oVar.get(kG);
                    if (vJ == null) {
                        if (obj2 != null || !oVar.containsKey(kG)) {
                            return false;
                        }
                    } else if (!vJ.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f11385c != ((Map) obj).size()) {
                return false;
            }
            int i12 = this.f11385c;
            for (int i13 = 0; i13 < i12; i13++) {
                K kG2 = g(i13);
                V vJ2 = j(i13);
                Object obj3 = ((Map) obj).get(kG2);
                if (vJ2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(kG2)) {
                        return false;
                    }
                } else if (!vJ2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final int f() {
        int i10 = this.f11385c;
        if (i10 == 0) {
            return -1;
        }
        int iA = q.a.a(i10, 0, this.f11383a);
        if (iA < 0 || this.f11384b[iA << 1] == null) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.f11383a[i11] == 0) {
            if (this.f11384b[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.f11383a[i12] == 0; i12--) {
            if (this.f11384b[i12 << 1] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public final K g(int i10) {
        boolean z = false;
        if (i10 >= 0 && i10 < this.f11385c) {
            z = true;
        }
        if (z) {
            return (K) this.f11384b[i10 << 1];
        }
        q.a.c("Expected index to be within 0..size()-1, but was " + i10);
        throw null;
    }

    public V get(K k9) {
        int iE = e(k9);
        if (iE >= 0) {
            return (V) this.f11384b[(iE << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V getOrDefault(Object obj, V v3) {
        int iE = e(obj);
        return iE >= 0 ? (V) this.f11384b[(iE << 1) + 1] : v3;
    }

    public final V h(int i10) {
        int i11;
        if (i10 < 0 || i10 >= (i11 = this.f11385c)) {
            q.a.c("Expected index to be within 0..size()-1, but was " + i10);
            throw null;
        }
        Object[] objArr = this.f11384b;
        int i12 = i10 << 1;
        V v3 = (V) objArr[i12 + 1];
        if (i11 <= 1) {
            clear();
            return v3;
        }
        int i13 = i11 - 1;
        int[] iArr = this.f11383a;
        if (iArr.length <= 8 || i11 >= iArr.length / 3) {
            if (i10 < i13) {
                int i14 = i10 + 1;
                b1.o(i10, i14, iArr, iArr, i11);
                Object[] objArr2 = this.f11384b;
                b1.q(objArr2, objArr2, i12, i14 << 1, i11 << 1);
            }
            Object[] objArr3 = this.f11384b;
            int i15 = i13 << 1;
            objArr3[i15] = null;
            objArr3[i15 + 1] = null;
        } else {
            int i16 = i11 > 8 ? i11 + (i11 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i16);
            kotlin.jvm.internal.g.e(iArrCopyOf, "copyOf(...)");
            this.f11383a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11384b, i16 << 1);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            this.f11384b = objArrCopyOf;
            if (i11 != this.f11385c) {
                throw new ConcurrentModificationException();
            }
            if (i10 > 0) {
                b1.o(0, 0, iArr, this.f11383a, i10);
                b1.q(objArr, this.f11384b, 0, 0, i12);
            }
            if (i10 < i13) {
                int i17 = i10 + 1;
                b1.o(i10, i17, iArr, this.f11383a, i11);
                b1.q(objArr, this.f11384b, i12, i17 << 1, i11 << 1);
            }
        }
        if (i11 != this.f11385c) {
            throw new ConcurrentModificationException();
        }
        this.f11385c = i13;
        return v3;
    }

    public final int hashCode() {
        int[] iArr = this.f11383a;
        Object[] objArr = this.f11384b;
        int i10 = this.f11385c;
        int i11 = 1;
        int i12 = 0;
        int iHashCode = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return iHashCode;
    }

    public final V i(int i10, V v3) {
        boolean z = false;
        if (i10 >= 0 && i10 < this.f11385c) {
            z = true;
        }
        if (!z) {
            q.a.c("Expected index to be within 0..size()-1, but was " + i10);
            throw null;
        }
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.f11384b;
        V v7 = (V) objArr[i11];
        objArr[i11] = v3;
        return v7;
    }

    public final boolean isEmpty() {
        return this.f11385c <= 0;
    }

    public final V j(int i10) {
        boolean z = false;
        if (i10 >= 0 && i10 < this.f11385c) {
            z = true;
        }
        if (z) {
            return (V) this.f11384b[(i10 << 1) + 1];
        }
        q.a.c("Expected index to be within 0..size()-1, but was " + i10);
        throw null;
    }

    public final V put(K k9, V v3) {
        int i10 = this.f11385c;
        int iHashCode = k9 != null ? k9.hashCode() : 0;
        int iC = k9 != null ? c(iHashCode, k9) : f();
        if (iC >= 0) {
            int i11 = (iC << 1) + 1;
            Object[] objArr = this.f11384b;
            V v7 = (V) objArr[i11];
            objArr[i11] = v3;
            return v7;
        }
        int i12 = ~iC;
        int[] iArr = this.f11383a;
        if (i10 >= iArr.length) {
            int i13 = 8;
            if (i10 >= 8) {
                i13 = (i10 >> 1) + i10;
            } else if (i10 < 4) {
                i13 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i13);
            kotlin.jvm.internal.g.e(iArrCopyOf, "copyOf(...)");
            this.f11383a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f11384b, i13 << 1);
            kotlin.jvm.internal.g.e(objArrCopyOf, "copyOf(...)");
            this.f11384b = objArrCopyOf;
            if (i10 != this.f11385c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i12 < i10) {
            int[] iArr2 = this.f11383a;
            int i14 = i12 + 1;
            b1.o(i14, i12, iArr2, iArr2, i10);
            Object[] objArr2 = this.f11384b;
            b1.q(objArr2, objArr2, i14 << 1, i12 << 1, this.f11385c << 1);
        }
        int i15 = this.f11385c;
        if (i10 == i15) {
            int[] iArr3 = this.f11383a;
            if (i12 < iArr3.length) {
                iArr3[i12] = iHashCode;
                Object[] objArr3 = this.f11384b;
                int i16 = i12 << 1;
                objArr3[i16] = k9;
                objArr3[i16 + 1] = v3;
                this.f11385c = i15 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final V putIfAbsent(K k9, V v3) {
        V v7 = get(k9);
        return v7 == null ? put(k9, v3) : v7;
    }

    public V remove(K k9) {
        int iE = e(k9);
        if (iE >= 0) {
            return h(iE);
        }
        return null;
    }

    public final V replace(K k9, V v3) {
        int iE = e(k9);
        if (iE >= 0) {
            return i(iE, v3);
        }
        return null;
    }

    public final int size() {
        return this.f11385c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f11385c * 28);
        sb2.append('{');
        int i10 = this.f11385c;
        for (int i11 = 0; i11 < i10; i11++) {
            if (i11 > 0) {
                sb2.append(", ");
            }
            K kG = g(i11);
            if (kG != sb2) {
                sb2.append(kG);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            V vJ = j(i11);
            if (vJ != sb2) {
                sb2.append(vJ);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        kotlin.jvm.internal.g.e(string, "toString(...)");
        return string;
    }

    public o(int i10) {
        this.f11383a = i10 == 0 ? q.a.f11482a : new int[i10];
        this.f11384b = i10 == 0 ? q.a.f11484c : new Object[i10 << 1];
    }

    public final boolean remove(K k9, V v3) {
        int iE = e(k9);
        if (iE < 0 || !kotlin.jvm.internal.g.b(v3, j(iE))) {
            return false;
        }
        h(iE);
        return true;
    }

    public final boolean replace(K k9, V v3, V v7) {
        int iE = e(k9);
        if (iE < 0 || !kotlin.jvm.internal.g.b(v3, j(iE))) {
            return false;
        }
        i(iE, v7);
        return true;
    }
}
