package j9;

import D7.AbstractC0214f;
import D7.C0211c;

/* renamed from: j9.d, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1610d {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f4781a;
    public static final long[] b;

    static {
        int[] iArr = new int[256];
        int i = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            iArr[i6] = "0123456789abcdef".charAt(i6 & 15) | ("0123456789abcdef".charAt(i6 >> 4) << '\b');
        }
        f4781a = iArr;
        int[] iArr2 = new int[256];
        for (int i10 = 0; i10 < 256; i10++) {
            iArr2[i10] = "0123456789ABCDEF".charAt(i10 & 15) | ("0123456789ABCDEF".charAt(i10 >> 4) << '\b');
        }
        int[] iArr3 = new int[256];
        for (int i11 = 0; i11 < 256; i11++) {
            iArr3[i11] = -1;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i12)] = i13;
            i12++;
            i13++;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i14)] = i15;
            i14++;
            i15++;
        }
        long[] jArr = new long[256];
        for (int i16 = 0; i16 < 256; i16++) {
            jArr[i16] = -1;
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i17)] = i18;
            i17++;
            i18++;
        }
        int i19 = 0;
        while (i < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i)] = i19;
            i++;
            i19++;
        }
        b = jArr;
    }

    public static final void a(int i, int i6, String str) {
        int i10 = i6 - i;
        if (i10 < 1) {
            String strSubstring = str.substring(i, i6);
            kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
            StringBuilder sbK = androidx.constraintlayout.core.dsl.a.k(i, "Expected at least 1 hexadecimal digits at index ", ", but was \"", strSubstring, "\" of length ");
            sbK.append(i10);
            throw new NumberFormatException(sbK.toString());
        }
        if (i10 > 16) {
            int i11 = (i10 + i) - 16;
            while (i < i11) {
                if (str.charAt(i) != '0') {
                    StringBuilder sbU = B7.a.u(i, "Expected the hexadecimal digit '0' at index ", ", but was '");
                    sbU.append(str.charAt(i));
                    sbU.append("'.\nThe result won't fit the type being parsed.");
                    throw new NumberFormatException(sbU.toString());
                }
                i++;
            }
        }
    }

    public static long b(int i, int i6, String str) {
        C1613g format = C1613g.d;
        kotlin.jvm.internal.k.f(format, "format");
        C0211c c0211c = AbstractC0214f.Companion;
        int length = str.length();
        c0211c.getClass();
        C0211c.a(i, i6, length);
        if (format.c.f4783a) {
            a(i, i6, str);
            return c(i, i6, str);
        }
        if (i6 - i > 0) {
            a(i, i6, str);
            return c(i, i6, str);
        }
        String strSubstring = str.substring(i, i6);
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"\" and suffix \"\", but was ".concat(strSubstring));
    }

    public static final long c(int i, int i6, String str) {
        long j5 = 0;
        while (i < i6) {
            long j6 = j5 << 4;
            char cCharAt = str.charAt(i);
            if ((cCharAt >>> '\b') == 0) {
                long j10 = b[cCharAt];
                if (j10 >= 0) {
                    j5 = j6 | j10;
                    i++;
                }
            }
            StringBuilder sbU = B7.a.u(i, "Expected a hexadecimal digit at index ", ", but was ");
            sbU.append(str.charAt(i));
            throw new NumberFormatException(sbU.toString());
        }
        return j5;
    }
}
