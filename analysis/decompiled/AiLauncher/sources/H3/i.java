package H3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class i extends p {
    @Override // H3.m
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + o.b(str);
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            if (length != 13) {
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
            }
            try {
                if (!o.a(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        m.c(str);
        int i10 = h.f2981f[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iB = m.b(zArr, 0, o.f2987a, true);
        for (int i11 = 1; i11 <= 6; i11++) {
            int iDigit = Character.digit(str.charAt(i11), 10);
            if (((i10 >> (6 - i11)) & 1) == 1) {
                iDigit += 10;
            }
            iB += m.b(zArr, iB, o.f2991e[iDigit], false);
        }
        int iB2 = iB + m.b(zArr, iB, o.f2988b, false);
        for (int i12 = 7; i12 <= 12; i12++) {
            iB2 += m.b(zArr, iB2, o.f2990d[Character.digit(str.charAt(i12), 10)], true);
        }
        m.b(zArr, iB2, o.f2987a, true);
        return zArr;
    }

    @Override // H3.m
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.EAN_13);
    }
}
