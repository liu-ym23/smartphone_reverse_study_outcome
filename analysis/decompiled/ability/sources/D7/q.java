package D7;

import i9.C1569d;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;

/* loaded from: classes3.dex */
public abstract class q extends z2.l {
    public static Object A0(Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return objArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static List B0(Object[] objArr, Y7.f indices) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        kotlin.jvm.internal.k.f(indices, "indices");
        return indices.isEmpty() ? EmptyList.f4893a : L(d0(objArr, indices.f1569a, indices.b + 1));
    }

    public static void C0(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        kotlin.jvm.internal.k.f(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }

    public static List D0(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, objArr.length);
            kotlin.jvm.internal.k.e(objArr, "copyOf(...)");
            C0(objArr, comparator);
        }
        return L(objArr);
    }

    public static List E0(Object[] objArr) {
        if (10 >= objArr.length) {
            return I0(objArr);
        }
        ArrayList arrayList = new ArrayList(10);
        int i = 0;
        for (Object obj : objArr) {
            arrayList.add(obj);
            i++;
            if (i == 10) {
                break;
            }
        }
        return arrayList;
    }

    public static final void F0(Object[] objArr, AbstractSet abstractSet) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        for (Object obj : objArr) {
            abstractSet.add(obj);
        }
    }

    public static List G0(byte[] bArr) {
        kotlin.jvm.internal.k.f(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            return EmptyList.f4893a;
        }
        if (length == 1) {
            return H4.o.M(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(Byte.valueOf(b));
        }
        return arrayList;
    }

    public static List H0(int[] iArr) {
        kotlin.jvm.internal.k.f(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            return EmptyList.f4893a;
        }
        if (length == 1) {
            return H4.o.M(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static List I0(Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new o(objArr, false)) : H4.o.M(objArr[0]) : EmptyList.f4893a;
    }

    public static long[] J0(Long[] lArr) {
        kotlin.jvm.internal.k.f(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    public static Iterable K(Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        return objArr.length == 0 ? EmptyList.f4893a : new s(objArr, 0);
    }

    public static Set K0(Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return EmptySet.f4895a;
        }
        if (length == 1) {
            return N.Q(objArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(kotlin.collections.a.P(objArr.length));
        F0(objArr, linkedHashSet);
        return linkedHashSet;
    }

    public static List L(Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        kotlin.jvm.internal.k.e(listAsList, "asList(...)");
        return listAsList;
    }

    public static ArrayList L0(Object[] objArr, Object[] other) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        kotlin.jvm.internal.k.f(other, "other");
        int iMin = Math.min(objArr.length, other.length);
        ArrayList arrayList = new ArrayList(iMin);
        for (int i = 0; i < iMin; i++) {
            arrayList.add(new Pair(objArr[i], other[i]));
        }
        return arrayList;
    }

    public static i9.i M(Object[] objArr) {
        return objArr.length == 0 ? C1569d.f4618a : new t(objArr, 0);
    }

    public static boolean N(Object obj, Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        return u0(objArr, obj) >= 0;
    }

    public static boolean O(int[] iArr, int i) {
        kotlin.jvm.internal.k.f(iArr, "<this>");
        return t0(iArr, i) >= 0;
    }

    public static boolean P(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        if (objArr.length == objArr2.length) {
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                Object obj = objArr[i];
                Object obj2 = objArr2[i];
                if (obj != obj2) {
                    if (obj != null && obj2 != null) {
                        if ((obj instanceof Object[]) && (obj2 instanceof Object[])) {
                            if (!P((Object[]) obj, (Object[]) obj2)) {
                            }
                        } else if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
                            if (!Arrays.equals((byte[]) obj, (byte[]) obj2)) {
                            }
                        } else if ((obj instanceof short[]) && (obj2 instanceof short[])) {
                            if (!Arrays.equals((short[]) obj, (short[]) obj2)) {
                            }
                        } else if ((obj instanceof int[]) && (obj2 instanceof int[])) {
                            if (!Arrays.equals((int[]) obj, (int[]) obj2)) {
                            }
                        } else if ((obj instanceof long[]) && (obj2 instanceof long[])) {
                            if (!Arrays.equals((long[]) obj, (long[]) obj2)) {
                            }
                        } else if ((obj instanceof float[]) && (obj2 instanceof float[])) {
                            if (!Arrays.equals((float[]) obj, (float[]) obj2)) {
                            }
                        } else if ((obj instanceof double[]) && (obj2 instanceof double[])) {
                            if (!Arrays.equals((double[]) obj, (double[]) obj2)) {
                            }
                        } else if ((obj instanceof char[]) && (obj2 instanceof char[])) {
                            if (!Arrays.equals((char[]) obj, (char[]) obj2)) {
                            }
                        } else if ((obj instanceof boolean[]) && (obj2 instanceof boolean[])) {
                            if (!Arrays.equals((boolean[]) obj, (boolean[]) obj2)) {
                            }
                        } else if ((obj instanceof C7.j) && (obj2 instanceof C7.j)) {
                            if (!Arrays.equals(((C7.j) obj).f309a, ((C7.j) obj2).f309a)) {
                            }
                        } else if ((obj instanceof C7.q) && (obj2 instanceof C7.q)) {
                            if (!Arrays.equals(((C7.q) obj).f316a, ((C7.q) obj2).f316a)) {
                            }
                        } else if ((obj instanceof C7.l) && (obj2 instanceof C7.l)) {
                            if (!Arrays.equals(((C7.l) obj).f311a, ((C7.l) obj2).f311a)) {
                            }
                        } else if ((obj instanceof C7.n) && (obj2 instanceof C7.n)) {
                            if (!Arrays.equals(((C7.n) obj).f313a, ((C7.n) obj2).f313a)) {
                            }
                        } else if (!obj.equals(obj2)) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static final void Q(Object[] objArr, StringBuilder sb, ArrayList arrayList) {
        if (arrayList.contains(objArr)) {
            sb.append("[...]");
            return;
        }
        arrayList.add(objArr);
        sb.append('[');
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            Object obj = objArr[i];
            if (obj == null) {
                sb.append("null");
            } else if (obj instanceof Object[]) {
                Q((Object[]) obj, sb, arrayList);
            } else if (obj instanceof byte[]) {
                String string = Arrays.toString((byte[]) obj);
                kotlin.jvm.internal.k.e(string, "toString(...)");
                sb.append(string);
            } else if (obj instanceof short[]) {
                String string2 = Arrays.toString((short[]) obj);
                kotlin.jvm.internal.k.e(string2, "toString(...)");
                sb.append(string2);
            } else if (obj instanceof int[]) {
                String string3 = Arrays.toString((int[]) obj);
                kotlin.jvm.internal.k.e(string3, "toString(...)");
                sb.append(string3);
            } else if (obj instanceof long[]) {
                String string4 = Arrays.toString((long[]) obj);
                kotlin.jvm.internal.k.e(string4, "toString(...)");
                sb.append(string4);
            } else if (obj instanceof float[]) {
                String string5 = Arrays.toString((float[]) obj);
                kotlin.jvm.internal.k.e(string5, "toString(...)");
                sb.append(string5);
            } else if (obj instanceof double[]) {
                String string6 = Arrays.toString((double[]) obj);
                kotlin.jvm.internal.k.e(string6, "toString(...)");
                sb.append(string6);
            } else if (obj instanceof char[]) {
                String string7 = Arrays.toString((char[]) obj);
                kotlin.jvm.internal.k.e(string7, "toString(...)");
                sb.append(string7);
            } else if (obj instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) obj);
                kotlin.jvm.internal.k.e(string8, "toString(...)");
                sb.append(string8);
            } else if (obj instanceof C7.j) {
                String strI0 = v.I0(new C7.j(((C7.j) obj).f309a), ", ", "[", "]", null, 56);
                sb.append(strI0 != null ? strI0 : "null");
            } else if (obj instanceof C7.q) {
                String strI02 = v.I0(new C7.q(((C7.q) obj).f316a), ", ", "[", "]", null, 56);
                sb.append(strI02 != null ? strI02 : "null");
            } else if (obj instanceof C7.l) {
                String strI03 = v.I0(new C7.l(((C7.l) obj).f311a), ", ", "[", "]", null, 56);
                sb.append(strI03 != null ? strI03 : "null");
            } else if (obj instanceof C7.n) {
                String strI04 = v.I0(new C7.n(((C7.n) obj).f313a), ", ", "[", "]", null, 56);
                sb.append(strI04 != null ? strI04 : "null");
            } else {
                sb.append(obj.toString());
            }
        }
        sb.append(']');
        arrayList.remove(H4.o.H(arrayList));
    }

    public static void R(int i, int i6, int[] iArr, int[] destination, int i10) {
        kotlin.jvm.internal.k.f(iArr, "<this>");
        kotlin.jvm.internal.k.f(destination, "destination");
        System.arraycopy(iArr, i6, destination, i, i10 - i6);
    }

    public static void S(byte[] bArr, int i, int i6, byte[] destination, int i10) {
        kotlin.jvm.internal.k.f(bArr, "<this>");
        kotlin.jvm.internal.k.f(destination, "destination");
        System.arraycopy(bArr, i6, destination, i, i10 - i6);
    }

    public static void T(char[] cArr, char[] destination, int i, int i6, int i10) {
        kotlin.jvm.internal.k.f(cArr, "<this>");
        kotlin.jvm.internal.k.f(destination, "destination");
        System.arraycopy(cArr, i6, destination, i, i10 - i6);
    }

    public static void U(double[] dArr, double[] destination, int i, int i6, int i10) {
        kotlin.jvm.internal.k.f(dArr, "<this>");
        kotlin.jvm.internal.k.f(destination, "destination");
        System.arraycopy(dArr, i6, destination, i, i10 - i6);
    }

    public static void V(float[] fArr, int i, float[] destination, int i6, int i10) {
        kotlin.jvm.internal.k.f(fArr, "<this>");
        kotlin.jvm.internal.k.f(destination, "destination");
        System.arraycopy(fArr, i6, destination, i, i10 - i6);
    }

    public static void W(long[] jArr, long[] destination, int i, int i6, int i10) {
        kotlin.jvm.internal.k.f(jArr, "<this>");
        kotlin.jvm.internal.k.f(destination, "destination");
        System.arraycopy(jArr, i6, destination, i, i10 - i6);
    }

    public static void X(Object[] objArr, Object[] destination, int i, int i6, int i10) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        kotlin.jvm.internal.k.f(destination, "destination");
        System.arraycopy(objArr, i6, destination, i, i10 - i6);
    }

    public static /* synthetic */ void Y(int i, int i6, int[] iArr, int[] iArr2, int i10) {
        if ((i10 & 2) != 0) {
            i = 0;
        }
        if ((i10 & 8) != 0) {
            i6 = iArr.length;
        }
        R(i, 0, iArr, iArr2, i6);
    }

    public static /* synthetic */ void Z(float[] fArr, int i, float[] fArr2, int i6) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        V(fArr, i, fArr2, 0, (i6 & 8) != 0 ? fArr.length : 6);
    }

    public static /* synthetic */ void b0(Object[] objArr, Object[] objArr2, int i, int i6, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i = 0;
        }
        if ((i11 & 4) != 0) {
            i6 = 0;
        }
        if ((i11 & 8) != 0) {
            i10 = objArr.length;
        }
        X(objArr, objArr2, i, i6, i10);
    }

    public static byte[] c0(byte[] bArr, int i, int i6) {
        kotlin.jvm.internal.k.f(bArr, "<this>");
        z2.l.q(i6, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i6);
        kotlin.jvm.internal.k.e(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] d0(Object[] objArr, int i, int i6) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        z2.l.q(i6, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i6);
        kotlin.jvm.internal.k.e(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static List e0(int i, Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(i, "Requested element count ", " is less than zero.").toString());
        }
        int length = objArr.length - i;
        if (length < 0) {
            length = 0;
        }
        if (length < 0) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.i(length, "Requested element count ", " is less than zero.").toString());
        }
        if (length == 0) {
            return EmptyList.f4893a;
        }
        int length2 = objArr.length;
        if (length >= length2) {
            return I0(objArr);
        }
        if (length == 1) {
            return H4.o.M(objArr[length2 - 1]);
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i6 = length2 - length; i6 < length2; i6++) {
            arrayList.add(objArr[i6]);
        }
        return arrayList;
    }

    public static void f0(Object obj, int i, Object[] objArr, int i6) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        Arrays.fill(objArr, i, i6, obj);
    }

    public static void g0(int[] iArr, int i, int i6, int i10) {
        if ((i10 & 4) != 0) {
            i6 = iArr.length;
        }
        kotlin.jvm.internal.k.f(iArr, "<this>");
        Arrays.fill(iArr, 0, i6, i);
    }

    public static void h0(long[] jArr, long j5) {
        int length = jArr.length;
        kotlin.jvm.internal.k.f(jArr, "<this>");
        Arrays.fill(jArr, 0, length, j5);
    }

    public static ArrayList j0(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object k0(Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Boolean l0(boolean[] zArr) {
        kotlin.jvm.internal.k.f(zArr, "<this>");
        if (zArr.length == 0) {
            return null;
        }
        return Boolean.valueOf(zArr[0]);
    }

    public static Long m0(long[] jArr) {
        kotlin.jvm.internal.k.f(jArr, "<this>");
        if (jArr.length == 0) {
            return null;
        }
        return Long.valueOf(jArr[0]);
    }

    public static Object n0(Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        if (objArr.length == 0) {
            return null;
        }
        return objArr[0];
    }

    public static Y7.f o0(int[] iArr) {
        return new Y7.f(0, iArr.length - 1, 1);
    }

    public static int p0(long[] jArr) {
        kotlin.jvm.internal.k.f(jArr, "<this>");
        return jArr.length - 1;
    }

    public static int q0(Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        return objArr.length - 1;
    }

    public static Integer r0(int[] iArr, int i) {
        kotlin.jvm.internal.k.f(iArr, "<this>");
        if (i < 0 || i >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i]);
    }

    public static Object s0(int i, Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        if (i < 0 || i >= objArr.length) {
            return null;
        }
        return objArr[i];
    }

    public static int t0(int[] iArr, int i) {
        kotlin.jvm.internal.k.f(iArr, "<this>");
        int length = iArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (i == iArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    public static int u0(Object[] objArr, Object obj) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        int i = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i < length) {
                if (objArr[i] == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i < length2) {
            if (obj.equals(objArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final void v0(Object[] objArr, StringBuilder sb, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, S7.k kVar) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        sb.append(charSequence2);
        int i = 0;
        for (Object obj : objArr) {
            i++;
            if (i > 1) {
                sb.append(charSequence);
            }
            com.stepos.statsrpk.d.h(sb, obj, kVar);
        }
        sb.append(charSequence3);
    }

    public static String w0(long[] jArr, int i) {
        String str = (i & 1) != 0 ? ", " : ",";
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i6 = 0;
        for (long j5 : jArr) {
            i6++;
            if (i6 > 1) {
                sb.append((CharSequence) str);
            }
            sb.append((CharSequence) String.valueOf(j5));
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public static String x0(Object[] objArr, String str, String str2, String str3, S7.k kVar, int i) {
        if ((i & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        if ((i & 32) != 0) {
            kVar = null;
        }
        kotlin.jvm.internal.k.f(objArr, "<this>");
        StringBuilder sb = new StringBuilder();
        v0(objArr, sb, str4, str5, str6, "...", kVar);
        return sb.toString();
    }

    public static Object y0(Object[] objArr) {
        kotlin.jvm.internal.k.f(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[objArr.length - 1];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static int z0(int[] iArr) {
        if (iArr.length == 0) {
            throw new NoSuchElementException();
        }
        int i = iArr[0];
        int i6 = 1;
        int length = iArr.length - 1;
        if (1 <= length) {
            while (true) {
                int i10 = iArr[i6];
                if (i < i10) {
                    i = i10;
                }
                if (i6 == length) {
                    break;
                }
                i6++;
            }
        }
        return i;
    }
}
