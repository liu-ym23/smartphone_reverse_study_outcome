package n6;

import id.k;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import w2.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f8778a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: b, reason: collision with root package name */
    public static final int f8779b;

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f8780c;

    static {
        int iPow = (int) Math.pow(10.0d, 4.0d);
        f8779b = iPow;
        f8780c = new char[(iPow * 4) + 10];
        int i = 0;
        for (int i3 = 0; i3 < f8779b; i3++) {
            a(i, 4, f8780c, i3);
            i += 4;
        }
    }

    public static void a(int i, int i3, char[] cArr, int i10) {
        char[] cArr2;
        int i11 = i + 10;
        int i12 = -i10;
        int i13 = i11;
        while (true) {
            cArr2 = f8778a;
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
            if (i15 >= i3) {
                System.arraycopy(cArr, i13, cArr, i, i3);
                return;
            } else {
                i13--;
                cArr[i13] = '0';
            }
        }
    }

    public static int b(int i, int i3, String str) {
        int i10 = 0;
        for (int i11 = i; i11 < i3; i11++) {
            try {
                char cCharAt = str.charAt(i11);
                if (cCharAt < '0' || cCharAt > '9') {
                    k.M(str, i11, '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
                    throw null;
                }
                i10 = (i10 * 10) + (cCharAt - '0');
            } catch (StringIndexOutOfBoundsException unused) {
                throw new DateTimeParseException(c.b("Unexpected end of input: ", str), str, i);
            }
        }
        return i10;
    }

    public static void c(int i, int i3, char[] cArr, int i10) {
        if (i >= f8779b) {
            a(i3, i10, cArr, i);
            return;
        }
        int iMin = Math.min(4, i10);
        int i11 = i10 - iMin;
        int i12 = i10 > 4 ? 4 : 4 - i10;
        int i13 = i3 + i11;
        int i14 = i * 4;
        if (i10 >= 4) {
            i12 = 0;
        }
        System.arraycopy(f8780c, i14 + i12, cArr, i13, iMin);
        if (i11 > 0) {
            Arrays.fill(cArr, i3, i13, '0');
        }
    }
}
