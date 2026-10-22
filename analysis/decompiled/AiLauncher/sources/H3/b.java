package H3;

import com.fasterxml.jackson.core.JsonPointer;
import com.google.zxing.BarcodeFormat;
import io.ktor.util.date.GMTDateParser;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class b extends m {

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f2972b;

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f2973c = {'T', 'N', GMTDateParser.ANY, 'E'};

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f2974d = {JsonPointer.SEPARATOR, ':', '+', '.'};

    /* renamed from: e, reason: collision with root package name */
    public static final char f2975e;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        f2972b = cArr;
        f2975e = cArr[0];
    }

    @Override // H3.m
    public boolean[] d(String str) {
        int i10;
        if (str.length() < 2) {
            StringBuilder sb2 = new StringBuilder();
            char c10 = f2975e;
            sb2.append(c10);
            sb2.append(str);
            sb2.append(c10);
            str = sb2.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = f2972b;
            boolean zA = a.a(cArr, upperCase);
            boolean zA2 = a.a(cArr, upperCase2);
            char[] cArr2 = f2973c;
            boolean zA3 = a.a(cArr2, upperCase);
            boolean zA4 = a.a(cArr2, upperCase2);
            if (zA) {
                if (!zA2) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
            } else if (!zA3) {
                if (zA2 || zA4) {
                    throw new IllegalArgumentException("Invalid start/end guards: " + str);
                }
                StringBuilder sb3 = new StringBuilder();
                char c11 = f2975e;
                sb3.append(c11);
                sb3.append(str);
                sb3.append(c11);
                str = sb3.toString();
            } else if (!zA4) {
                throw new IllegalArgumentException("Invalid start/end guards: " + str);
            }
        }
        int i11 = 20;
        for (int i12 = 1; i12 < str.length() - 1; i12++) {
            if (Character.isDigit(str.charAt(i12)) || str.charAt(i12) == '-' || str.charAt(i12) == '$') {
                i11 += 9;
            } else {
                if (!a.a(f2974d, str.charAt(i12))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i12) + '\'');
                }
                i11 += 10;
            }
        }
        boolean[] zArr = new boolean[i11 + (str.length() - 1)];
        int i13 = 0;
        for (int i14 = 0; i14 < str.length(); i14++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i14));
            if (i14 == 0 || i14 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i15 = 0;
            while (true) {
                char[] cArr3 = a.f2969a;
                if (i15 >= cArr3.length) {
                    i10 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i15]) {
                    i10 = a.f2970b[i15];
                    break;
                }
                i15++;
            }
            int i16 = 0;
            int i17 = 0;
            boolean z10 = true;
            while (i16 < 7) {
                zArr[i13] = z10;
                i13++;
                if (((i10 >> (6 - i16)) & 1) == 0 || i17 == 1) {
                    z10 = !z10;
                    i16++;
                    i17 = 0;
                } else {
                    i17++;
                }
            }
            if (i14 < str.length() - 1) {
                zArr[i13] = false;
                i13++;
            }
        }
        return zArr;
    }

    @Override // H3.m
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.CODABAR);
    }
}
