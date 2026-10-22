package q;

import androidx.room.AbstractC0351g;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import r.AbstractC0827a;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public int[] f13968a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f13969b;

    /* renamed from: c, reason: collision with root package name */
    public int f13970c;

    public l() {
        this(0);
    }

    public final int a(Object obj) {
        int i4 = this.f13970c * 2;
        Object[] objArr = this.f13969b;
        if (obj == null) {
            for (int i5 = 1; i5 < i4; i5 += 2) {
                if (objArr[i5] == null) {
                    return i5 >> 1;
                }
            }
            return -1;
        }
        for (int i6 = 1; i6 < i4; i6 += 2) {
            if (Intrinsics.areEqual(obj, objArr[i6])) {
                return i6 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i4) {
        int i5 = this.f13970c;
        int[] iArr = this.f13968a;
        if (iArr.length < i4) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i4);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.f13968a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f13969b, i4 * 2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.f13969b = objArrCopyOf;
        }
        if (this.f13970c != i5) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(int i4, Object obj) {
        int i5 = this.f13970c;
        if (i5 == 0) {
            return -1;
        }
        int iA = AbstractC0827a.a(i5, i4, this.f13968a);
        if (iA < 0 || Intrinsics.areEqual(obj, this.f13969b[iA << 1])) {
            return iA;
        }
        int i6 = iA + 1;
        while (i6 < i5 && this.f13968a[i6] == i4) {
            if (Intrinsics.areEqual(obj, this.f13969b[i6 << 1])) {
                return i6;
            }
            i6++;
        }
        for (int i7 = iA - 1; i7 >= 0 && this.f13968a[i7] == i4; i7--) {
            if (Intrinsics.areEqual(obj, this.f13969b[i7 << 1])) {
                return i7;
            }
        }
        return ~i6;
    }

    public final void clear() {
        if (this.f13970c > 0) {
            this.f13968a = AbstractC0827a.f13997a;
            this.f13969b = AbstractC0827a.f13999c;
            this.f13970c = 0;
        }
        if (this.f13970c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj.hashCode(), obj);
    }

    public final int e() {
        int i4 = this.f13970c;
        if (i4 == 0) {
            return -1;
        }
        int iA = AbstractC0827a.a(i4, 0, this.f13968a);
        if (iA < 0 || this.f13969b[iA << 1] == null) {
            return iA;
        }
        int i5 = iA + 1;
        while (i5 < i4 && this.f13968a[i5] == 0) {
            if (this.f13969b[i5 << 1] == null) {
                return i5;
            }
            i5++;
        }
        for (int i6 = iA - 1; i6 >= 0 && this.f13968a[i6] == 0; i6--) {
            if (this.f13969b[i6 << 1] == null) {
                return i6;
            }
        }
        return ~i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof l) {
                int i4 = this.f13970c;
                if (i4 != ((l) obj).f13970c) {
                    return false;
                }
                l lVar = (l) obj;
                for (int i5 = 0; i5 < i4; i5++) {
                    Object objF = f(i5);
                    Object objI = i(i5);
                    Object obj2 = lVar.get(objF);
                    if (objI == null) {
                        if (obj2 != null || !lVar.containsKey(objF)) {
                            return false;
                        }
                    } else if (!Intrinsics.areEqual(objI, obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.f13970c != ((Map) obj).size()) {
                return false;
            }
            int i6 = this.f13970c;
            for (int i7 = 0; i7 < i6; i7++) {
                Object objF2 = f(i7);
                Object objI2 = i(i7);
                Object obj3 = ((Map) obj).get(objF2);
                if (objI2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objF2)) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(objI2, obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i4) {
        if (i4 < 0 || i4 >= this.f13970c) {
            throw new IllegalArgumentException(AbstractC0351g.m("Expected index to be within 0..size()-1, but was ", i4).toString());
        }
        return this.f13969b[i4 << 1];
    }

    public final Object g(int i4) {
        int i5;
        if (i4 < 0 || i4 >= (i5 = this.f13970c)) {
            throw new IllegalArgumentException(AbstractC0351g.m("Expected index to be within 0..size()-1, but was ", i4).toString());
        }
        Object[] objArr = this.f13969b;
        int i6 = i4 << 1;
        Object obj = objArr[i6 + 1];
        if (i5 <= 1) {
            clear();
        } else {
            int i7 = i5 - 1;
            int[] iArr = this.f13968a;
            if (iArr.length <= 8 || i5 >= iArr.length / 3) {
                if (i4 < i7) {
                    int i8 = i4 + 1;
                    ArraysKt___ArraysJvmKt.copyInto(iArr, iArr, i4, i8, i5);
                    Object[] objArr2 = this.f13969b;
                    ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i6, i8 << 1, i5 << 1);
                }
                Object[] objArr3 = this.f13969b;
                int i9 = i7 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                int i10 = i5 > 8 ? i5 + (i5 >> 1) : 8;
                int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
                Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
                this.f13968a = iArrCopyOf;
                Object[] objArrCopyOf = Arrays.copyOf(this.f13969b, i10 << 1);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
                this.f13969b = objArrCopyOf;
                if (i5 != this.f13970c) {
                    throw new ConcurrentModificationException();
                }
                if (i4 > 0) {
                    ArraysKt___ArraysJvmKt.copyInto(iArr, this.f13968a, 0, 0, i4);
                    ArraysKt___ArraysJvmKt.copyInto(objArr, this.f13969b, 0, 0, i6);
                }
                if (i4 < i7) {
                    int i11 = i4 + 1;
                    ArraysKt___ArraysJvmKt.copyInto(iArr, this.f13968a, i4, i11, i5);
                    ArraysKt___ArraysJvmKt.copyInto(objArr, this.f13969b, i6, i11 << 1, i5 << 1);
                }
            }
            if (i5 != this.f13970c) {
                throw new ConcurrentModificationException();
            }
            this.f13970c = i7;
        }
        return obj;
    }

    public Object get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.f13969b[(iD << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.f13969b[(iD << 1) + 1] : obj2;
    }

    public final Object h(int i4, Object obj) {
        if (i4 < 0 || i4 >= this.f13970c) {
            throw new IllegalArgumentException(AbstractC0351g.m("Expected index to be within 0..size()-1, but was ", i4).toString());
        }
        int i5 = (i4 << 1) + 1;
        Object[] objArr = this.f13969b;
        Object obj2 = objArr[i5];
        objArr[i5] = obj;
        return obj2;
    }

    public final int hashCode() {
        int[] iArr = this.f13968a;
        Object[] objArr = this.f13969b;
        int i4 = this.f13970c;
        int i5 = 1;
        int i6 = 0;
        int iHashCode = 0;
        while (i6 < i4) {
            Object obj = objArr[i5];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i6];
            i6++;
            i5 += 2;
        }
        return iHashCode;
    }

    public final Object i(int i4) {
        if (i4 < 0 || i4 >= this.f13970c) {
            throw new IllegalArgumentException(AbstractC0351g.m("Expected index to be within 0..size()-1, but was ", i4).toString());
        }
        return this.f13969b[(i4 << 1) + 1];
    }

    public final boolean isEmpty() {
        return this.f13970c <= 0;
    }

    public final Object put(Object obj, Object obj2) {
        int i4 = this.f13970c;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(iHashCode, obj) : e();
        if (iC >= 0) {
            int i5 = (iC << 1) + 1;
            Object[] objArr = this.f13969b;
            Object obj3 = objArr[i5];
            objArr[i5] = obj2;
            return obj3;
        }
        int i6 = ~iC;
        int[] iArr = this.f13968a;
        if (i4 >= iArr.length) {
            int i7 = 8;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i7 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i7);
            Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, newSize)");
            this.f13968a = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.f13969b, i7 << 1);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
            this.f13969b = objArrCopyOf;
            if (i4 != this.f13970c) {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 < i4) {
            int[] iArr2 = this.f13968a;
            int i8 = i6 + 1;
            ArraysKt___ArraysJvmKt.copyInto(iArr2, iArr2, i8, i6, i4);
            Object[] objArr2 = this.f13969b;
            ArraysKt___ArraysJvmKt.copyInto(objArr2, objArr2, i8 << 1, i6 << 1, this.f13970c << 1);
        }
        int i9 = this.f13970c;
        if (i4 == i9) {
            int[] iArr3 = this.f13968a;
            if (i6 < iArr3.length) {
                iArr3[i6] = iHashCode;
                Object[] objArr3 = this.f13969b;
                int i10 = i6 << 1;
                objArr3[i10] = obj;
                objArr3[i10 + 1] = obj2;
                this.f13970c = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return g(iD);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD >= 0) {
            return h(iD, obj2);
        }
        return null;
    }

    public final int size() {
        return this.f13970c;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f13970c * 28);
        sb.append('{');
        int i4 = this.f13970c;
        for (int i5 = 0; i5 < i4; i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            Object objF = f(i5);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objI = i(i5);
            if (objI != sb) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public l(int i4) {
        int[] iArr;
        Object[] objArr;
        if (i4 == 0) {
            iArr = AbstractC0827a.f13997a;
        } else {
            iArr = new int[i4];
        }
        this.f13968a = iArr;
        if (i4 == 0) {
            objArr = AbstractC0827a.f13999c;
        } else {
            objArr = new Object[i4 << 1];
        }
        this.f13969b = objArr;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0 || !Intrinsics.areEqual(obj2, i(iD))) {
            return false;
        }
        g(iD);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0 || !Intrinsics.areEqual(obj2, i(iD))) {
            return false;
        }
        h(iD, obj3);
        return true;
    }
}
