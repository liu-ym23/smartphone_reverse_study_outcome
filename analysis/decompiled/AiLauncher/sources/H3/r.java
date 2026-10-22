package H3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class r extends p {
    @Override // H3.m
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + o.b(q.c(str));
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
            }
            try {
                if (!o.a(q.c(str))) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (FormatException unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        m.c(str);
        int iDigit = Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i10 = q.f2993g[iDigit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iB = m.b(zArr, 0, o.f2987a, true);
        for (int i11 = 1; i11 <= 6; i11++) {
            int iDigit2 = Character.digit(str.charAt(i11), 10);
            if (((i10 >> (6 - i11)) & 1) == 1) {
                iDigit2 += 10;
            }
            iB += m.b(zArr, iB, o.f2991e[iDigit2], false);
        }
        m.b(zArr, iB, o.f2989c, false);
        return zArr;
    }

    @Override // H3.m
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.UPC_E);
    }
}
