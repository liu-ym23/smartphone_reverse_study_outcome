package kb;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class k extends a.a {
    public static boolean d0(Object[] objArr, Object obj) {
        objArr.getClass();
        return r0(objArr, obj) >= 0;
    }

    public static boolean e0(Object[] objArr, Object[] objArr2) {
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
                            if (!e0((Object[]) obj, (Object[]) obj2)) {
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
                        } else if (!obj.equals(obj2)) {
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static void f0(int i, int i3, int[] iArr, int[] iArr2, int i10) {
        iArr.getClass();
        iArr2.getClass();
        System.arraycopy(iArr, i3, iArr2, i, i10 - i3);
    }

    public static void g0(byte[] bArr, int i, int i3, byte[] bArr2, int i10) {
        bArr.getClass();
        bArr2.getClass();
        System.arraycopy(bArr, i3, bArr2, i, i10 - i3);
    }

    public static void h0(long[] jArr, long[] jArr2, int i, int i3, int i10) {
        jArr.getClass();
        jArr2.getClass();
        System.arraycopy(jArr, i3, jArr2, i, i10 - i3);
    }

    public static void i0(Object[] objArr, Object[] objArr2, int i, int i3, int i10) {
        objArr.getClass();
        objArr2.getClass();
        System.arraycopy(objArr, i3, objArr2, i, i10 - i3);
    }

    public static /* synthetic */ void j0(int i, int i3, int[] iArr, int[] iArr2, int i10) {
        if ((i10 & 2) != 0) {
            i = 0;
        }
        if ((i10 & 8) != 0) {
            i3 = iArr.length;
        }
        f0(i, 0, iArr, iArr2, i3);
    }

    public static /* synthetic */ void k0(Object[] objArr, Object[] objArr2, int i, int i3, int i10) {
        if ((i10 & 4) != 0) {
            i = 0;
        }
        if ((i10 & 8) != 0) {
            i3 = objArr.length;
        }
        i0(objArr, objArr2, 0, i, i3);
    }

    public static Object[] l0(Object[] objArr, int i, int i3) {
        objArr.getClass();
        a.a.n(i3, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i, i3);
        objArrCopyOfRange.getClass();
        return objArrCopyOfRange;
    }

    public static void m0(Object obj, int i, Object[] objArr, int i3) {
        objArr.getClass();
        Arrays.fill(objArr, i, i3, obj);
    }

    public static void n0(long[] jArr, long j10) {
        int length = jArr.length;
        jArr.getClass();
        Arrays.fill(jArr, 0, length, j10);
    }

    public static ArrayList p0(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static int q0(long[] jArr) {
        jArr.getClass();
        return jArr.length - 1;
    }

    public static int r0(Object[] objArr, Object obj) {
        objArr.getClass();
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

    public static String s0(Object[] objArr, int i) {
        String str = (i & 2) != 0 ? "" : "innermostOf(";
        String str2 = (i & 4) == 0 ? ")" : "";
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) str);
        int i3 = 0;
        for (Object obj : objArr) {
            i3++;
            if (i3 > 1) {
                sb2.append((CharSequence) ", ");
            }
            id.c.e(sb2, obj, null);
        }
        sb2.append((CharSequence) str2);
        return sb2.toString();
    }

    public static char t0(char[] cArr) {
        int length = cArr.length;
        if (length == 0) {
            g5.f.m("Array is empty.");
            return (char) 0;
        }
        if (length == 1) {
            return cArr[0];
        }
        g5.f.s("Array has more than one element.");
        return (char) 0;
    }

    public static List u0(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return s.f7404c;
        }
        if (length == 1) {
            return ac.a.E(objArr[0]);
        }
        i iVar = new i();
        iVar.f7397c = objArr;
        iVar.f7398f = false;
        VarHandle.storeStoreFence();
        return new ArrayList(iVar);
    }

    public static Set v0(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        if (length == 0) {
            return u.f7406c;
        }
        if (length == 1) {
            return h5.t.P(objArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(x.L(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }
}
