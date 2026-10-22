package O2;

import H4.o;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f1033a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final int b;
    public static final char[] c;

    static {
        int iPow = (int) Math.pow(10.0d, 4.0d);
        b = iPow;
        c = new char[(iPow * 4) + 10];
        int i = 0;
        for (int i6 = 0; i6 < b; i6++) {
            a(i, 4, c, i6);
            i += 4;
        }
    }

    public static void a(int i, int i6, char[] cArr, int i10) {
        char[] cArr2;
        int i11 = i + 10;
        int i12 = -i10;
        int i13 = i11;
        while (true) {
            cArr2 = f1033a;
            if (i12 > -10) {
                break;
            }
            int i14 = i12 / 10;
            cArr[i13] = cArr2[-(i12 - (i14 * 10))];
            i12 = i14;
            i13--;
        }
        cArr[i13] = cArr2[-i12];
        int i15 = i11 - i13;
        while (true) {
            i15++;
            if (i15 >= i6) {
                System.arraycopy(cArr, i13, cArr, i, i6);
                return;
            } else {
                i13--;
                cArr[i13] = '0';
            }
        }
    }

    public static int b(int i, int i6, String str) {
        int i10 = 0;
        for (int i11 = i; i11 < i6; i11++) {
            try {
                char cCharAt = str.charAt(i11);
                if (cCharAt < '0' || cCharAt > '9') {
                    o.T(str, new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}, i11);
                    throw null;
                }
                i10 = (i10 * 10) + (cCharAt - '0');
            } catch (StringIndexOutOfBoundsException unused) {
                throw new DateTimeParseException(B7.a.k("Unexpected end of input: ", str), str, i);
            }
        }
        return i10;
    }

    public static void c(int i, int i6, char[] cArr, int i10) {
        if (i >= b) {
            a(i6, i10, cArr, i);
            return;
        }
        int iMin = Math.min(4, i10);
        int i11 = i10 - iMin;
        int i12 = i10 > 4 ? 4 : 4 - i10;
        int i13 = i6 + i11;
        int i14 = i * 4;
        if (i10 >= 4) {
            i12 = 0;
        }
        System.arraycopy(c, i14 + i12, cArr, i13, iMin);
        if (i11 > 0) {
            Arrays.fill(cArr, i6, i13, '0');
        }
    }
}
