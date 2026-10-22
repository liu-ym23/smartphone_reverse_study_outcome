package z2;

/* renamed from: z2.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C6275u {
    public static int a(int i10) {
        return (i10 < 32 ? 4 : 2) * (i10 + 1);
    }

    public static int b(Object obj, Object obj2, int i10, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i11;
        int i12;
        int iA = C6285v.a(obj);
        int i13 = iA & i10;
        int iC = c(obj3, i13);
        if (iC != 0) {
            int i14 = ~i10;
            int i15 = iA & i14;
            int i16 = -1;
            while (true) {
                i11 = iC - 1;
                int i17 = iArr[i11];
                i12 = i17 & i10;
                if ((i17 & i14) != i15 || !C6175k.a(obj, objArr[i11]) || (objArr2 != null && !C6175k.a(obj2, objArr2[i11]))) {
                    if (i12 == 0) {
                        break;
                    }
                    i16 = i11;
                    iC = i12;
                } else {
                    break;
                }
            }
            if (i16 == -1) {
                e(obj3, i13, i12);
                return i11;
            }
            iArr[i16] = (iArr[i16] & i14) | (i12 & i10);
            return i11;
        }
        return -1;
    }

    public static int c(Object obj, int i10) {
        return obj instanceof byte[] ? ((byte[]) obj)[i10] & 255 : obj instanceof short[] ? (char) ((short[]) obj)[i10] : ((int[]) obj)[i10];
    }

    public static Object d(int i10) {
        if (i10 >= 2 && i10 <= 1073741824 && Integer.highestOneBit(i10) == i10) {
            return i10 <= 256 ? new byte[i10] : i10 <= 65536 ? new short[i10] : new int[i10];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i10);
    }

    public static void e(Object obj, int i10, int i11) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i10] = (byte) i11;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i10] = (short) i11;
        } else {
            ((int[]) obj)[i10] = i11;
        }
    }
}
