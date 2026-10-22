package Z1;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f7112a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: b, reason: collision with root package name */
    public static final int f7113b;

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f7114c;

    static {
        int iPow = (int) Math.pow(10.0d, 4.0d);
        f7113b = iPow;
        f7114c = new char[(iPow * 4) + 10];
        int i10 = 0;
        for (int i11 = 0; i11 < f7113b; i11++) {
            c(f7114c, i10, 4, i11);
            i10 += 4;
        }
    }

    public static void a(char[] cArr, int i10, int i11, int i12) {
        b(cArr, i10, cArr, i11, i12);
    }

    public static void b(char[] cArr, int i10, char[] cArr2, int i11, int i12) {
        System.arraycopy(cArr, i10, cArr2, i11, i12);
    }

    public static void c(char[] cArr, int i10, int i11, int i12) {
        int i13 = i10 + 10;
        int i14 = -i12;
        int i15 = i13;
        while (i14 <= -10) {
            int i16 = i14 / 10;
            cArr[i15] = f7112a[-(i14 - (i16 * 10))];
            i14 = i16;
            i15--;
        }
        cArr[i15] = f7112a[-i14];
        int i17 = i13 - i15;
        while (true) {
            i17++;
            if (i17 >= i11) {
                a(cArr, i15, i10, i11);
                return;
            } else {
                i15--;
                cArr[i15] = '0';
            }
        }
    }

    public static int d(String str, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i10; i13 < i11; i13++) {
            try {
                char cCharAt = str.charAt(i13);
                if (cCharAt < '0' || cCharAt > '9') {
                    d.d(str, i13, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
                }
                i12 = (i12 * 10) + (cCharAt - '0');
            } catch (StringIndexOutOfBoundsException unused) {
                d.e(str, i10);
            }
        }
        return i12;
    }

    public static void e(int i10, char[] cArr, int i11, int i12) {
        if (i10 >= f7113b) {
            c(cArr, i11, i12, i10);
            return;
        }
        int iMin = Math.min(4, i12);
        int i13 = i12 - iMin;
        int i14 = i12 > 4 ? 4 : 4 - i12;
        int i15 = i11 + i13;
        int i16 = i10 * 4;
        if (i12 >= 4) {
            i14 = 0;
        }
        b(f7114c, i16 + i14, cArr, i15, iMin);
        if (i13 > 0) {
            f(cArr, i11, i13);
        }
    }

    public static void f(char[] cArr, int i10, int i11) {
        Arrays.fill(cArr, i10, i11 + i10, '0');
    }
}
