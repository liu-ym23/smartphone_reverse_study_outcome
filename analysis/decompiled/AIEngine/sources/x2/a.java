package x2;

import com.stepos.core.common.util.TraceIdKeys;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f13703a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f13704b;

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f13705c;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f13706d;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f13707e;

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f13708f;

    /* renamed from: g, reason: collision with root package name */
    public static final int[] f13709g;
    public static final int[] h;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f13710i;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: x2.a$a, reason: collision with other inner class name */
    public static class C0167a {

        /* renamed from: b, reason: collision with root package name */
        public static final C0167a f13711b;

        /* renamed from: a, reason: collision with root package name */
        public int[][] f13712a;

        static {
            C0167a c0167a = new C0167a();
            c0167a.f13712a = new int[TraceIdKeys.MAX_LENGTH][];
            f13711b = c0167a;
        }
    }

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        f13703a = charArray;
        int length = charArray.length;
        f13704b = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            f13704b[i10] = (byte) f13703a[i10];
        }
        int[] iArr = new int[256];
        for (int i11 = 0; i11 < 32; i11++) {
            iArr[i11] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f13705c = iArr;
        int length2 = iArr.length;
        int[] iArr2 = new int[length2];
        System.arraycopy(iArr, 0, iArr2, 0, length2);
        for (int i12 = 128; i12 < 256; i12++) {
            iArr2[i12] = (i12 & 224) == 192 ? 2 : (i12 & 240) == 224 ? 3 : (i12 & 248) == 240 ? 4 : -1;
        }
        f13706d = iArr2;
        int[] iArr3 = new int[256];
        Arrays.fill(iArr3, -1);
        for (int i13 = 33; i13 < 256; i13++) {
            if (Character.isJavaIdentifierPart((char) i13)) {
                iArr3[i13] = 0;
            }
        }
        iArr3[64] = 0;
        iArr3[35] = 0;
        iArr3[42] = 0;
        iArr3[45] = 0;
        iArr3[43] = 0;
        f13707e = iArr3;
        int[] iArr4 = new int[256];
        System.arraycopy(iArr3, 0, iArr4, 0, 256);
        Arrays.fill(iArr4, TraceIdKeys.MAX_LENGTH, TraceIdKeys.MAX_LENGTH, 0);
        f13708f = iArr4;
        int[] iArr5 = new int[256];
        int[] iArr6 = f13706d;
        System.arraycopy(iArr6, TraceIdKeys.MAX_LENGTH, iArr5, TraceIdKeys.MAX_LENGTH, TraceIdKeys.MAX_LENGTH);
        Arrays.fill(iArr5, 0, 32, -1);
        iArr5[9] = 0;
        iArr5[10] = 10;
        iArr5[13] = 13;
        iArr5[42] = 42;
        f13709g = iArr5;
        int[] iArr7 = new int[256];
        System.arraycopy(iArr6, TraceIdKeys.MAX_LENGTH, iArr7, TraceIdKeys.MAX_LENGTH, TraceIdKeys.MAX_LENGTH);
        Arrays.fill(iArr7, 0, 32, -1);
        iArr7[32] = 1;
        iArr7[9] = 1;
        iArr7[10] = 10;
        iArr7[13] = 13;
        iArr7[47] = 47;
        iArr7[35] = 35;
        int[] iArr8 = new int[TraceIdKeys.MAX_LENGTH];
        for (int i14 = 0; i14 < 32; i14++) {
            iArr8[i14] = -1;
        }
        iArr8[34] = 34;
        iArr8[92] = 92;
        iArr8[8] = 98;
        iArr8[9] = 116;
        iArr8[12] = 102;
        iArr8[10] = 110;
        iArr8[13] = 114;
        h = iArr8;
        int[] iArr9 = new int[256];
        f13710i = iArr9;
        Arrays.fill(iArr9, -1);
        for (int i15 = 0; i15 < 10; i15++) {
            f13710i[i15 + 48] = i15;
        }
        for (int i16 = 0; i16 < 6; i16++) {
            int[] iArr10 = f13710i;
            int i17 = i16 + 10;
            iArr10[i16 + 97] = i17;
            iArr10[i16 + 65] = i17;
        }
    }

    public static int[] a(int i10) {
        int[] iArr = h;
        if (i10 == 34) {
            return iArr;
        }
        int[][] iArr2 = C0167a.f13711b.f13712a;
        int[] iArr3 = iArr2[i10];
        if (iArr3 != null) {
            return iArr3;
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, TraceIdKeys.MAX_LENGTH);
        if (iArrCopyOf[i10] == 0) {
            iArrCopyOf[i10] = -1;
        }
        iArr2[i10] = iArrCopyOf;
        return iArrCopyOf;
    }
}
