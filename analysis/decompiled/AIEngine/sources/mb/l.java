package mb;

import androidx.datastore.preferences.protobuf.b1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class l extends b1 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> implements fc.i<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object[] f10559a;

        public a(Object[] objArr) {
            this.f10559a = objArr;
        }

        @Override // fc.i
        public final Iterator<T> iterator() {
            return b1.O(this.f10559a);
        }
    }

    public static <T> fc.i<T> Z(T[] tArr) {
        return tArr.length == 0 ? fc.e.f8799a : new a(tArr);
    }

    public static boolean a0(Object obj, Object[] objArr) {
        kotlin.jvm.internal.g.f(objArr, "<this>");
        return h0(obj, objArr) >= 0;
    }

    public static boolean b0(char[] cArr, char c9) {
        kotlin.jvm.internal.g.f(cArr, "<this>");
        int length = cArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            if (c9 == cArr[i10]) {
                break;
            }
            i10++;
        }
        return i10 >= 0;
    }

    public static <T> List<T> c0(T[] tArr, int i10) {
        kotlin.jvm.internal.g.f(tArr, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Requested element count ", " is less than zero.").toString());
        }
        int length = tArr.length - i10;
        if (length < 0) {
            length = 0;
        }
        if (length < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(length, "Requested element count ", " is less than zero.").toString());
        }
        if (length == 0) {
            return EmptyList.f10001a;
        }
        int length2 = tArr.length;
        if (length >= length2) {
            return q0(tArr);
        }
        if (length == 1) {
            return b1.P(tArr[length2 - 1]);
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i11 = length2 - length; i11 < length2; i11++) {
            arrayList.add(tArr[i11]);
        }
        return arrayList;
    }

    public static ArrayList d0(Object[] objArr) {
        kotlin.jvm.internal.g.f(objArr, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static <T> T e0(T[] tArr) {
        kotlin.jvm.internal.g.f(tArr, "<this>");
        if (tArr.length == 0) {
            return null;
        }
        return tArr[0];
    }

    public static int f0(long[] jArr) {
        kotlin.jvm.internal.g.f(jArr, "<this>");
        return jArr.length - 1;
    }

    public static <T> T g0(T[] tArr, int i10) {
        kotlin.jvm.internal.g.f(tArr, "<this>");
        if (i10 < 0 || i10 >= tArr.length) {
            return null;
        }
        return tArr[i10];
    }

    public static int h0(Object obj, Object[] objArr) {
        kotlin.jvm.internal.g.f(objArr, "<this>");
        int i10 = 0;
        if (obj == null) {
            int length = objArr.length;
            while (i10 < length) {
                if (objArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        int length2 = objArr.length;
        while (i10 < length2) {
            if (obj.equals(objArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static String i0(float[] fArr) {
        kotlin.jvm.internal.g.f(fArr, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "");
        int i10 = 0;
        for (float f8 : fArr) {
            i10++;
            if (i10 > 1) {
                sb2.append((CharSequence) ",");
            }
            sb2.append((CharSequence) String.valueOf(f8));
        }
        sb2.append((CharSequence) "");
        return sb2.toString();
    }

    public static String j0(Object[] objArr, zb.l lVar, int i10) {
        String str = (i10 & 1) != 0 ? ", " : ",";
        String str2 = (i10 & 2) != 0 ? "" : "innermostOf(";
        String str3 = (i10 & 4) == 0 ? ")" : "";
        if ((i10 & 32) != 0) {
            lVar = null;
        }
        kotlin.jvm.internal.g.f(objArr, "<this>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) str2);
        int i11 = 0;
        for (Object obj : objArr) {
            i11++;
            if (i11 > 1) {
                sb2.append((CharSequence) str);
            }
            b1.f(sb2, obj, lVar);
        }
        sb2.append((CharSequence) str3);
        return sb2.toString();
    }

    public static <T> List<T> k0(T[] tArr, Comparator<? super T> comparator) {
        kotlin.jvm.internal.g.f(tArr, "<this>");
        if (tArr.length != 0) {
            tArr = (T[]) Arrays.copyOf(tArr, tArr.length);
            kotlin.jvm.internal.g.e(tArr, "copyOf(...)");
            b1.V(tArr, comparator);
        }
        return b1.g(tArr);
    }

    public static List<Byte> l0(byte[] bArr, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Requested element count ", " is less than zero.").toString());
        }
        if (i10 == 0) {
            return EmptyList.f10001a;
        }
        int i11 = 0;
        if (i10 >= bArr.length) {
            int length = bArr.length;
            if (length == 0) {
                return EmptyList.f10001a;
            }
            if (length == 1) {
                return b1.P(Byte.valueOf(bArr[0]));
            }
            ArrayList arrayList = new ArrayList(bArr.length);
            int length2 = bArr.length;
            while (i11 < length2) {
                arrayList.add(Byte.valueOf(bArr[i11]));
                i11++;
            }
            return arrayList;
        }
        if (i10 == 1) {
            return b1.P(Byte.valueOf(bArr[0]));
        }
        ArrayList arrayList2 = new ArrayList(i10);
        int length3 = bArr.length;
        int i12 = 0;
        while (i11 < length3) {
            arrayList2.add(Byte.valueOf(bArr[i11]));
            i12++;
            if (i12 == i10) {
                break;
            }
            i11++;
        }
        return arrayList2;
    }

    public static List m0(Object[] objArr) {
        kotlin.jvm.internal.g.f(objArr, "<this>");
        if (8 >= objArr.length) {
            return q0(objArr);
        }
        ArrayList arrayList = new ArrayList(8);
        int i10 = 0;
        for (Object obj : objArr) {
            arrayList.add(obj);
            i10++;
            if (i10 == 8) {
                break;
            }
        }
        return arrayList;
    }

    public static final void n0(Object[] objArr, LinkedHashSet linkedHashSet) {
        kotlin.jvm.internal.g.f(objArr, "<this>");
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
    }

    public static List<Float> o0(float[] fArr) {
        kotlin.jvm.internal.g.f(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            return EmptyList.f10001a;
        }
        if (length == 1) {
            return b1.P(Float.valueOf(fArr[0]));
        }
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f8 : fArr) {
            arrayList.add(Float.valueOf(f8));
        }
        return arrayList;
    }

    public static List<Integer> p0(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return EmptyList.f10001a;
        }
        if (length == 1) {
            return b1.P(Integer.valueOf(iArr[0]));
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i10 : iArr) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    public static <T> List<T> q0(T[] tArr) {
        kotlin.jvm.internal.g.f(tArr, "<this>");
        int length = tArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new j(tArr, false)) : b1.P(tArr[0]) : EmptyList.f10001a;
    }

    public static long[] r0(Long[] lArr) {
        kotlin.jvm.internal.g.f(lArr, "<this>");
        int length = lArr.length;
        long[] jArr = new long[length];
        for (int i10 = 0; i10 < length; i10++) {
            jArr[i10] = lArr[i10].longValue();
        }
        return jArr;
    }

    public static <T> Set<T> s0(T[] tArr) {
        kotlin.jvm.internal.g.f(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            return EmptySet.f10003a;
        }
        if (length == 1) {
            return y.M(tArr[0]);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(v.a0(tArr.length));
        n0(tArr, linkedHashSet);
        return linkedHashSet;
    }
}
