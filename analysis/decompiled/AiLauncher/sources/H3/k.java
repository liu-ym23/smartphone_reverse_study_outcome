package H3;

import com.google.zxing.BarcodeFormat;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class k extends m {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f2982b = {1, 1, 1, 1};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f2983c = {3, 1, 1};

    /* renamed from: d, reason: collision with root package name */
    public static final int[][] f2984d = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // H3.m
    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
        m.c(str);
        boolean[] zArr = new boolean[(length * 9) + 9];
        int iB = m.b(zArr, 0, f2982b, true);
        for (int i10 = 0; i10 < length; i10 += 2) {
            int iDigit = Character.digit(str.charAt(i10), 10);
            int iDigit2 = Character.digit(str.charAt(i10 + 1), 10);
            int[] iArr = new int[10];
            for (int i11 = 0; i11 < 5; i11++) {
                int i12 = i11 * 2;
                int[][] iArr2 = f2984d;
                iArr[i12] = iArr2[iDigit][i11];
                iArr[i12 + 1] = iArr2[iDigit2][i11];
            }
            iB += m.b(zArr, iB, iArr, true);
        }
        m.b(zArr, iB, f2983c, true);
        return zArr;
    }

    @Override // H3.m
    public Collection<BarcodeFormat> g() {
        return Collections.singleton(BarcodeFormat.ITF);
    }
}
