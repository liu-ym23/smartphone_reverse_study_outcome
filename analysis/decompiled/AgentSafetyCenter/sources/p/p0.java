package p;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class p0 {

    /* renamed from: c, reason: collision with root package name */
    public int[] f9608c;

    /* renamed from: f, reason: collision with root package name */
    public Object[] f9609f;

    /* renamed from: g, reason: collision with root package name */
    public int f9610g;

    public p0(int i) {
        this.f9608c = i == 0 ? q.a.f10064a : new int[i];
        this.f9609f = i == 0 ? q.a.f10066c : new Object[i << 1];
    }

    public final int a(Object obj) {
        int i = this.f9610g * 2;
        Object[] objArr = this.f9609f;
        if (obj == null) {
            for (int i3 = 1; i3 < i; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i10 = 1; i10 < i; i10 += 2) {
            if (obj.equals(objArr[i10])) {
                return i10 >> 1;
            }
        }
        return -1;
    }

    public final int b(int i, Object obj) {
        int i3 = this.f9610g;
        if (i3 == 0) {
            return -1;
        }
        int iA = q.a.a(i3, i, this.f9608c);
        if (iA < 0 || yb.k.a(obj, this.f9609f[iA << 1])) {
            return iA;
        }
        int i10 = iA + 1;
        while (i10 < i3 && this.f9608c[i10] == i) {
            if (yb.k.a(obj, this.f9609f[i10 << 1])) {
                return i10;
            }
            i10++;
        }
        for (int i11 = iA - 1; i11 >= 0 && this.f9608c[i11] == i; i11--) {
            if (yb.k.a(obj, this.f9609f[i11 << 1])) {
                return i11;
            }
        }
        return ~i10;
    }

    public final int c(Object obj) {
        return obj == null ? d() : b(obj.hashCode(), obj);
    }

    public final void clear() {
        if (this.f9610g > 0) {
            this.f9608c = q.a.f10064a;
            this.f9609f = q.a.f10066c;
            this.f9610g = 0;
        }
        if (this.f9610g > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return c(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public final int d() {
        int i = this.f9610g;
        if (i == 0) {
            return -1;
        }
        int iA = q.a.a(i, 0, this.f9608c);
        if (iA < 0 || this.f9609f[iA << 1] == null) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i && this.f9608c[i3] == 0) {
            if (this.f9609f[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i10 = iA - 1; i10 >= 0 && this.f9608c[i10] == 0; i10--) {
            if (this.f9609f[i10 << 1] == null) {
                return i10;
            }
        }
        return ~i3;
    }

    public final Object e(int i) {
        boolean z10 = false;
        if (i >= 0 && i < this.f9610g) {
            z10 = true;
        }
        if (z10) {
            return this.f9609f[i << 1];
        }
        g5.f.s(k0.a.j(i, "Expected index to be within 0..size()-1, but was "));
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof p0) {
                int i = this.f9610g;
                if (i != ((p0) obj).f9610g) {
                    return false;
                }
                p0 p0Var = (p0) obj;
                for (int i3 = 0; i3 < i; i3++) {
                    Object objE = e(i3);
                    Object objH = h(i3);
                    Object obj2 = p0Var.get(objE);
                    if (objH == null) {
                        if (obj2 != null || !p0Var.containsKey(objE)) {
                            return false;
                        }
                    } else if (!objH.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f9610g != ((Map) obj).size()) {
                return false;
            }
            int i10 = this.f9610g;
            for (int i11 = 0; i11 < i10; i11++) {
                Object objE2 = e(i11);
                Object objH2 = h(i11);
                Object obj3 = ((Map) obj).get(objE2);
                if (objH2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objE2)) {
                        return false;
                    }
                } else if (!objH2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i) {
        int i3;
        if (i < 0 || i >= (i3 = this.f9610g)) {
            g5.f.s(k0.a.j(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        Object[] objArr = this.f9609f;
        int i10 = i << 1;
        Object obj = objArr[i10 + 1];
        if (i3 <= 1) {
            clear();
            return obj;
        }
        int i11 = i3 - 1;
        int[] iArr = this.f9608c;
        if (iArr.length <= 8 || i3 >= iArr.length / 3) {
            if (i < i11) {
                int i12 = i + 1;
                kb.k.f0(i, i12, iArr, iArr, i3);
                Object[] objArr2 = this.f9609f;
                kb.k.i0(objArr2, objArr2, i10, i12 << 1, i3 << 1);
            }
            Object[] objArr3 = this.f9609f;
            int i13 = i11 << 1;
            objArr3[i13] = null;
            objArr3[i13 + 1] = null;
        } else {
            int i14 = i3 > 8 ? i3 + (i3 >> 1) : 8;
            this.f9608c = Arrays.copyOf(iArr, i14);
            this.f9609f = Arrays.copyOf(this.f9609f, i14 << 1);
            if (i3 != this.f9610g) {
                throw new ConcurrentModificationException();
            }
            if (i > 0) {
                kb.k.f0(0, 0, iArr, this.f9608c, i);
                kb.k.i0(objArr, this.f9609f, 0, 0, i10);
            }
            if (i < i11) {
                int i15 = i + 1;
                kb.k.f0(i, i15, iArr, this.f9608c, i3);
                kb.k.i0(objArr, this.f9609f, i10, i15 << 1, i3 << 1);
            }
        }
        if (i3 != this.f9610g) {
            throw new ConcurrentModificationException();
        }
        this.f9610g = i11;
        return obj;
    }

    public final Object g(int i, Object obj) {
        boolean z10 = false;
        if (i >= 0 && i < this.f9610g) {
            z10 = true;
        }
        if (!z10) {
            g5.f.s(k0.a.j(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        int i3 = (i << 1) + 1;
        Object[] objArr = this.f9609f;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    public Object get(Object obj) {
        int iC = c(obj);
        if (iC >= 0) {
            return this.f9609f[(iC << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iC = c(obj);
        return iC >= 0 ? this.f9609f[(iC << 1) + 1] : obj2;
    }

    public final Object h(int i) {
        boolean z10 = false;
        if (i >= 0 && i < this.f9610g) {
            z10 = true;
        }
        if (z10) {
            return this.f9609f[(i << 1) + 1];
        }
        g5.f.s(k0.a.j(i, "Expected index to be within 0..size()-1, but was "));
        return null;
    }

    public final int hashCode() {
        int[] iArr = this.f9608c;
        Object[] objArr = this.f9609f;
        int i = this.f9610g;
        int i3 = 1;
        int i10 = 0;
        int iHashCode = 0;
        while (i10 < i) {
            Object obj = objArr[i3];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i10];
            i10++;
            i3 += 2;
        }
        return iHashCode;
    }

    public final boolean isEmpty() {
        return this.f9610g <= 0;
    }

    public final Object put(Object obj, Object obj2) {
        int i = this.f9610g;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iB = obj != null ? b(iHashCode, obj) : d();
        if (iB >= 0) {
            int i3 = (iB << 1) + 1;
            Object[] objArr = this.f9609f;
            Object obj3 = objArr[i3];
            objArr[i3] = obj2;
            return obj3;
        }
        int i10 = ~iB;
        int[] iArr = this.f9608c;
        if (i >= iArr.length) {
            int i11 = 8;
            if (i >= 8) {
                i11 = (i >> 1) + i;
            } else if (i < 4) {
                i11 = 4;
            }
            this.f9608c = Arrays.copyOf(iArr, i11);
            this.f9609f = Arrays.copyOf(this.f9609f, i11 << 1);
            if (i != this.f9610g) {
                throw new ConcurrentModificationException();
            }
        }
        if (i10 < i) {
            int[] iArr2 = this.f9608c;
            int i12 = i10 + 1;
            kb.k.f0(i12, i10, iArr2, iArr2, i);
            Object[] objArr2 = this.f9609f;
            kb.k.i0(objArr2, objArr2, i12 << 1, i10 << 1, this.f9610g << 1);
        }
        int i13 = this.f9610g;
        if (i == i13) {
            int[] iArr3 = this.f9608c;
            if (i10 < iArr3.length) {
                iArr3[i10] = iHashCode;
                Object[] objArr3 = this.f9609f;
                int i14 = i10 << 1;
                objArr3[i14] = obj;
                objArr3[i14 + 1] = obj2;
                this.f9610g = i13 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iC = c(obj);
        if (iC < 0 || !yb.k.a(obj2, h(iC))) {
            return false;
        }
        f(iC);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iC = c(obj);
        if (iC < 0 || !yb.k.a(obj2, h(iC))) {
            return false;
        }
        g(iC, obj3);
        return true;
    }

    public final int size() {
        return this.f9610g;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f9610g * 28);
        sb2.append('{');
        int i = this.f9610g;
        for (int i3 = 0; i3 < i; i3++) {
            if (i3 > 0) {
                sb2.append(", ");
            }
            Object objE = e(i3);
            if (objE != sb2) {
                sb2.append(objE);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            Object objH = h(i3);
            if (objH != sb2) {
                sb2.append(objH);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public Object remove(Object obj) {
        int iC = c(obj);
        if (iC >= 0) {
            return f(iC);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iC = c(obj);
        if (iC >= 0) {
            return g(iC, obj2);
        }
        return null;
    }
}
