package gc;

import mb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f9120a;

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f9121b;

    static {
        int[] iArr = new int[256];
        int i10 = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            iArr[i11] = "0123456789abcdef".charAt(i11 & 15) | ("0123456789abcdef".charAt(i11 >> 4) << '\b');
        }
        f9120a = iArr;
        int[] iArr2 = new int[256];
        for (int i12 = 0; i12 < 256; i12++) {
            iArr2[i12] = "0123456789ABCDEF".charAt(i12 & 15) | ("0123456789ABCDEF".charAt(i12 >> 4) << '\b');
        }
        int[] iArr3 = new int[256];
        for (int i13 = 0; i13 < 256; i13++) {
            iArr3[i13] = -1;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i14)] = i15;
            i14++;
            i15++;
        }
        int i16 = 0;
        int i17 = 0;
        while (i16 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i16)] = i17;
            i16++;
            i17++;
        }
        long[] jArr = new long[256];
        for (int i18 = 0; i18 < 256; i18++) {
            jArr[i18] = -1;
        }
        int i19 = 0;
        int i20 = 0;
        while (i19 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i19)] = i20;
            i19++;
            i20++;
        }
        int i21 = 0;
        while (i10 < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i10)] = i21;
            i10++;
            i21++;
        }
        f9121b = jArr;
    }

    public static final void a(int i10, int i11, String str) {
        int i12 = i11 - i10;
        if (i12 < 1) {
            String strSubstring = str.substring(i10, i11);
            kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
            StringBuilder sbE = h0.e.e("Expected at least 1 hexadecimal digits at index ", i10, ", but was \"", strSubstring, "\" of length ");
            sbE.append(i12);
            throw new NumberFormatException(sbE.toString());
        }
        if (i12 > 16) {
            int i13 = (i12 + i10) - 16;
            while (i10 < i13) {
                if (str.charAt(i10) != '0') {
                    StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Expected the hexadecimal digit '0' at index ", ", but was '");
                    sbK.append(str.charAt(i10));
                    sbK.append("'.\nThe result won't fit the type being parsed.");
                    throw new NumberFormatException(sbK.toString());
                }
                i10++;
            }
        }
    }

    public static long b(int i10, int i11, String str) {
        e format = e.f9122d;
        kotlin.jvm.internal.g.f(format, "format");
        c.a.a(i10, i11, str.length());
        if (format.f9125c.f9128a) {
            a(i10, i11, str);
            return c(i10, i11, str);
        }
        if (i11 - i10 > 0) {
            a(i10, i11, str);
            return c(i10, i11, str);
        }
        String strSubstring = str.substring(i10, i11);
        kotlin.jvm.internal.g.e(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"\" and suffix \"\", but was ".concat(strSubstring));
    }

    public static final long c(int i10, int i11, String str) {
        long j10 = 0;
        while (i10 < i11) {
            long j11 = j10 << 4;
            char cCharAt = str.charAt(i10);
            if ((cCharAt >>> '\b') == 0) {
                long j12 = f9121b[cCharAt];
                if (j12 >= 0) {
                    j10 = j11 | j12;
                    i10++;
                }
            }
            StringBuilder sbK = com.stepos.core.ota.d.k(i10, "Expected a hexadecimal digit at index ", ", but was ");
            sbK.append(str.charAt(i10));
            throw new NumberFormatException(sbK.toString());
        }
        return j10;
    }
}
