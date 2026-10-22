package H3;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class j extends p {
    @Override // H3.m
    public boolean[] d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + o.b(str);
            } catch (FormatException e10) {
                throw new IllegalArgumentException(e10);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got " + length);
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
        boolean[] zArr = new boolean[67];
        int iB = m.b(zArr, 0, o.f2987a, true);
        for (int i10 = 0; i10 <= 3; i10++) {
            iB += m.b(zArr, iB, o.f2990d[Character.digit(str.charAt(i10), 10)], false);
        }
        int iB2 = iB + m.b(zArr, iB, o.f2988b, false);
        for (int i11 = 4; i11 <= 7; i11++) {
            iB2 += m.b(zArr, iB2, o.f2990d[Character.digit(str.charAt(i11), 10)], true);
        }
        m.b(zArr, iB2, o.f2987a, true);
        return zArr;
    }

    @Override // H3.m
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.EAN_8);
    }
}
