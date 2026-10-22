package c5;

import com.stepos.stepclaw.SecurePrefs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class l extends b8.h {
    public static List S(Object[] objArr) {
        kotlin.jvm.internal.p.e(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        kotlin.jvm.internal.p.d(listAsList, "asList(...)");
        return listAsList;
    }

    public static boolean T(char[] cArr, char c3) {
        int length = cArr.length;
        int i8 = 0;
        while (true) {
            if (i8 >= length) {
                i8 = -1;
                break;
            }
            if (c3 == cArr[i8]) {
                break;
            }
            i8++;
        }
        return i8 >= 0;
    }

    public static void U(int i8, byte[] bArr, int i9, byte[] destination, int i10) {
        kotlin.jvm.internal.p.e(bArr, "<this>");
        kotlin.jvm.internal.p.e(destination, "destination");
        System.arraycopy(bArr, i9, destination, i8, i10 - i9);
    }

    public static void V(int i8, int[] iArr, int i9, int[] destination, int i10) {
        kotlin.jvm.internal.p.e(iArr, "<this>");
        kotlin.jvm.internal.p.e(destination, "destination");
        System.arraycopy(iArr, i9, destination, i8, i10 - i9);
    }

    public static void W(Object[] objArr, Object[] destination, int i8, int i9, int i10) {
        kotlin.jvm.internal.p.e(objArr, "<this>");
        kotlin.jvm.internal.p.e(destination, "destination");
        System.arraycopy(objArr, i9, destination, i8, i10 - i9);
    }

    public static /* synthetic */ void X(int i8, int i9, int[] iArr, int[] iArr2) {
        if ((i9 & 8) != 0) {
            i8 = iArr.length;
        }
        V(0, iArr, 0, iArr2, i8);
    }

    public static /* synthetic */ void Y(Object[] objArr, Object[] objArr2, int i8, int i9, int i10) {
        if ((i10 & 4) != 0) {
            i8 = 0;
        }
        if ((i10 & 8) != 0) {
            i9 = objArr.length;
        }
        W(objArr, objArr2, 0, i8, i9);
    }

    public static byte[] Z(byte[] bArr, int i8, int i9) {
        kotlin.jvm.internal.p.e(bArr, "<this>");
        b8.h.i(i9, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i8, i9);
        kotlin.jvm.internal.p.d(bArrCopyOfRange, "copyOfRange(...)");
        return bArrCopyOfRange;
    }

    public static Object[] a0(Object[] objArr, int i8, int i9) {
        kotlin.jvm.internal.p.e(objArr, "<this>");
        b8.h.i(i9, objArr.length);
        Object[] objArrCopyOfRange = Arrays.copyOfRange(objArr, i8, i9);
        kotlin.jvm.internal.p.d(objArrCopyOfRange, "copyOfRange(...)");
        return objArrCopyOfRange;
    }

    public static List b0(Object[] objArr) {
        kotlin.jvm.internal.p.e(objArr, "<this>");
        int length = objArr.length - 2;
        if (length < 0) {
            length = 0;
        }
        if (length < 0) {
            throw new IllegalArgumentException(a8.b.k(length, "Requested element count ", " is less than zero.").toString());
        }
        if (length == 0) {
            return s.f1092a;
        }
        int length2 = objArr.length;
        if (length >= length2) {
            return j0(objArr);
        }
        if (length == 1) {
            return a.a.S(objArr[length2 - 1]);
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i8 = length2 - length; i8 < length2; i8++) {
            arrayList.add(objArr[i8]);
        }
        return arrayList;
    }

    public static void c0(Object[] objArr, int i8, int i9) {
        kotlin.jvm.internal.p.e(objArr, "<this>");
        Arrays.fill(objArr, i8, i9, (Object) null);
    }

    public static ArrayList d0(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static Object e0(Object[] objArr) {
        if (objArr.length != 0) {
            return objArr[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static Object f0(Object[] objArr, int i8) {
        kotlin.jvm.internal.p.e(objArr, "<this>");
        if (i8 < 0 || i8 >= objArr.length) {
            return null;
        }
        return objArr[i8];
    }

    public static int g0(Object[] objArr, Object obj) {
        kotlin.jvm.internal.p.e(objArr, "<this>");
        int i8 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i8 < length) {
                if (objArr[i8] == null) {
                    return i8;
                }
                i8++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i8 < length2) {
            if (obj.equals(objArr[i8])) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public static String h0(byte[] bArr, String str, p5.l lVar, int i8) {
        int i9 = i8 & 2;
        String str2 = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        String str3 = i9 != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : "[";
        if ((i8 & 4) == 0) {
            str2 = "]";
        }
        if ((i8 & 32) != 0) {
            lVar = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str3);
        int i10 = 0;
        for (byte b9 : bArr) {
            i10++;
            if (i10 > 1) {
                sb.append((CharSequence) str);
            }
            if (lVar != null) {
                sb.append((CharSequence) lVar.invoke(Byte.valueOf(b9)));
            } else {
                sb.append((CharSequence) String.valueOf((int) b9));
            }
        }
        sb.append((CharSequence) str2);
        return sb.toString();
    }

    public static List i0(float[] fArr) {
        int i8 = 0;
        if (5 < fArr.length) {
            ArrayList arrayList = new ArrayList(5);
            int length = fArr.length;
            int i9 = 0;
            while (i8 < length) {
                arrayList.add(Float.valueOf(fArr[i8]));
                i9++;
                if (i9 == 5) {
                    break;
                }
                i8++;
            }
            return arrayList;
        }
        int length2 = fArr.length;
        if (length2 == 0) {
            return s.f1092a;
        }
        if (length2 == 1) {
            return a.a.S(Float.valueOf(fArr[0]));
        }
        ArrayList arrayList2 = new ArrayList(fArr.length);
        int length3 = fArr.length;
        while (i8 < length3) {
            arrayList2.add(Float.valueOf(fArr[i8]));
            i8++;
        }
        return arrayList2;
    }

    public static List j0(Object[] objArr) {
        kotlin.jvm.internal.p.e(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new i(objArr, false)) : a.a.S(objArr[0]) : s.f1092a;
    }

    public static Set k0(Object[] objArr) {
        kotlin.jvm.internal.p.e(objArr, "<this>");
        int length = objArr.length;
        if (length == 0) {
            return u.f1094a;
        }
        if (length == 1) {
            return a.a.a0(objArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(z.T(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }
}
