package m0;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public class l extends C4890c {

    /* renamed from: d, reason: collision with root package name */
    public g f37126d;

    public l(String str) {
        this.f37053a = str;
        double[] dArr = new double[str.length() / 2];
        int iIndexOf = str.indexOf(40) + 1;
        int iIndexOf2 = str.indexOf(44, iIndexOf);
        int i10 = 0;
        while (iIndexOf2 != -1) {
            dArr[i10] = Double.parseDouble(str.substring(iIndexOf, iIndexOf2).trim());
            iIndexOf = iIndexOf2 + 1;
            iIndexOf2 = str.indexOf(44, iIndexOf);
            i10++;
        }
        dArr[i10] = Double.parseDouble(str.substring(iIndexOf, str.indexOf(41, iIndexOf)).trim());
        this.f37126d = d(Arrays.copyOf(dArr, i10 + 1));
    }

    public static g d(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d10 = 1.0d / length2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            double d11 = dArr[i10];
            int i11 = i10 + length2;
            dArr2[i11][0] = d11;
            double d12 = i10 * d10;
            dArr3[i11] = d12;
            if (i10 > 0) {
                int i12 = (length2 * 2) + i10;
                dArr2[i12][0] = d11 + 1.0d;
                dArr3[i12] = d12 + 1.0d;
                int i13 = i10 - 1;
                dArr2[i13][0] = (d11 - 1.0d) - d10;
                dArr3[i13] = (d12 - 1.0d) - d10;
            }
        }
        g gVar = new g(dArr3, dArr2);
        System.out.println(" 0 " + gVar.c(0.0d, 0));
        System.out.println(" 1 " + gVar.c(1.0d, 0));
        return gVar;
    }

    @Override // m0.C4890c
    public double a(double d10) {
        return this.f37126d.c(d10, 0);
    }

    @Override // m0.C4890c
    public double b(double d10) {
        return this.f37126d.k(d10, 0);
    }
}
