package d7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class n extends w7.e0 {
    public static List S(Object[] objArr) {
        q7.k.e(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        q7.k.d(listAsList, "asList(...)");
        return listAsList;
    }

    public static fa.j T(Object[] objArr) {
        return objArr.length == 0 ? fa.d.f3617a : new q(0, objArr);
    }

    public static boolean U(Object[] objArr, Object obj) {
        q7.k.e(objArr, "<this>");
        return l0(objArr, obj) >= 0;
    }

    public static void V(int i2, int i10, int i11, byte[] bArr, byte[] bArr2) {
        q7.k.e(bArr, "<this>");
        q7.k.e(bArr2, "destination");
        System.arraycopy(bArr, i10, bArr2, i2, i11 - i10);
    }

    public static void W(int[] iArr, int[] iArr2, int i2, int i10, int i11) {
        q7.k.e(iArr, "<this>");
        q7.k.e(iArr2, "destination");
        System.arraycopy(iArr, i10, iArr2, i2, i11 - i10);
    }

    public static void X(long[] jArr, long[] jArr2, int i2, int i10, int i11) {
        q7.k.e(jArr, "<this>");
        q7.k.e(jArr2, "destination");
        System.arraycopy(jArr, i10, jArr2, i2, i11 - i10);
    }

    public static void Y(Object[] objArr, Object[] objArr2, int i2, int i10, int i11) {
        q7.k.e(objArr, "<this>");
        q7.k.e(objArr2, "destination");
        System.arraycopy(objArr, i10, objArr2, i2, i11 - i10);
    }

    public static /* synthetic */ void Z(int[] iArr, int[] iArr2, int i2, int i10, int i11) {
        if ((i11 & 2) != 0) {
            i2 = 0;
        }
        if ((i11 & 8) != 0) {
            i10 = iArr.length;
        }
        W(iArr, iArr2, i2, 0, i10);
    }

    public static /* synthetic */ void a0(Object[] objArr, Object[] objArr2, int i2, int i10, int i11) {
        if ((i11 & 4) != 0) {
            i2 = 0;
        }
        Y(objArr, objArr2, 0, i2, i10);
    }

    public static byte[] b0(byte[] bArr, int i2, int i10) {
        q7.k.e(bArr, "<this>");
        w7.e0.l(i10, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i2, i10);
        q7.k.d(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] c0(Object[] objArr, int i2, int i10) {
        q7.k.e(objArr, "<this>");
        w7.e0.l(i10, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i2, i10);
        q7.k.d(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static void d0(Object[] objArr, int i2, int i10) {
        q7.k.e(objArr, "<this>");
        Arrays.fill(objArr, i2, i10, (Object) null);
    }

    public static void e0(long[] jArr) {
        int length = jArr.length;
        q7.k.e(jArr, "<this>");
        Arrays.fill(jArr, 0, length, -9187201950435737472L);
    }

    public static Object g0(Object[] objArr) {
        q7.k.e(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object h0(Object[] objArr) {
        q7.k.e(objArr, "<this>");
        if (objArr.length == 0) {
            return null;
        }
        return objArr[0];
    }

    public static int i0(long[] jArr) {
        q7.k.e(jArr, "<this>");
        return jArr.length - 1;
    }

    public static Integer j0(int i2, int[] iArr) {
        q7.k.e(iArr, "<this>");
        if (i2 < 0 || i2 >= iArr.length) {
            return null;
        }
        return Integer.valueOf(iArr[i2]);
    }

    public static Object k0(int i2, Object[] objArr) {
        q7.k.e(objArr, "<this>");
        if (i2 < 0 || i2 >= objArr.length) {
            return null;
        }
        return objArr[i2];
    }

    public static int l0(Object[] objArr, Object obj) {
        q7.k.e(objArr, "<this>");
        int i2 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i2 < length) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i2 < length2) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final void m0(Object[] objArr, StringBuilder sb2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, p7.k kVar) {
        q7.k.e(objArr, "<this>");
        sb2.append(charSequence2);
        int i2 = 0;
        for (Object obj : objArr) {
            i2++;
            if (i2 > 1) {
                sb2.append(charSequence);
            }
            ib.k.f(sb2, obj, kVar);
        }
        sb2.append(charSequence3);
    }

    public static String n0(byte[] bArr, String str, p7.k kVar, int i2) {
        String str2 = (i2 & 2) != 0 ? "" : "[";
        String str3 = (i2 & 4) == 0 ? "]" : "";
        if ((i2 & 32) != 0) {
            kVar = null;
        }
        q7.k.e(bArr, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) str2);
        int i10 = 0;
        for (byte b10 : bArr) {
            i10++;
            if (i10 > 1) {
                sb2.append((CharSequence) str);
            }
            if (kVar != null) {
                sb2.append((CharSequence) kVar.invoke(Byte.valueOf(b10)));
            } else {
                sb2.append((CharSequence) String.valueOf((int) b10));
            }
        }
        sb2.append((CharSequence) str3);
        return sb2.toString();
    }

    public static String o0(Object[] objArr, String str, String str2, String str3, p7.k kVar, int i2) {
        if ((i2 & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i2 & 2) != 0 ? "" : str2;
        String str6 = (i2 & 4) != 0 ? "" : str3;
        if ((i2 & 32) != 0) {
            kVar = null;
        }
        q7.k.e(objArr, "<this>");
        StringBuilder sb2 = new StringBuilder();
        m0(objArr, sb2, str4, str5, str6, "...", kVar);
        return sb2.toString();
    }

    public static Object p0(Object[] objArr) {
        q7.k.e(objArr, "<this>");
        if (objArr.length != 0) {
            return objArr[objArr.length - 1];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static char q0(char[] cArr) {
        q7.k.e(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static Object r0(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return objArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static void s0(Object[] objArr, Comparator comparator) {
        q7.k.e(objArr, "<this>");
        q7.k.e(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }

    public static void t0(Object[] objArr, Comparator comparator, int i2, int i10) {
        q7.k.e(objArr, "<this>");
        q7.k.e(comparator, "comparator");
        Arrays.sort(objArr, i2, i10, comparator);
    }

    public static List u0(Object[] objArr, Comparator comparator) {
        if (objArr.length != 0) {
            objArr = Arrays.copyOf(objArr, objArr.length);
            q7.k.d(objArr, "copyOf(...)");
            s0(objArr, comparator);
        }
        return S(objArr);
    }

    public static final void v0(Object[] objArr, LinkedHashSet linkedHashSet) {
        q7.k.e(objArr, "<this>");
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
    }

    public static List w0(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new l(objArr, false)) : a.a.S(objArr[0]) : z.f2978f;
    }

    public static Set x0(Object[] objArr) {
        q7.k.e(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return b0.f2947f;
        }
        if (length == 1) {
            return ib.k.S(objArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(e0.S(objArr.length));
        v0(objArr, linkedHashSet);
        return linkedHashSet;
    }
}
