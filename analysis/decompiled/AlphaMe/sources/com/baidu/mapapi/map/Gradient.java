package com.baidu.mapapi.map;

import android.graphics.Color;
import com.stepos.alphame.utils.Property;
import java.util.HashMap;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class Gradient {

    /* renamed from: a, reason: collision with root package name */
    private final int f6350a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f6351b;

    /* renamed from: c, reason: collision with root package name */
    private final float[] f6352c;

    /* renamed from: d, reason: collision with root package name */
    float[] f6353d;

    public class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f6354a;

        /* renamed from: b, reason: collision with root package name */
        private final int f6355b;

        /* renamed from: c, reason: collision with root package name */
        private final float f6356c;

        private b(int i4, int i5, float f4) {
            this.f6354a = i4;
            this.f6355b = i5;
            this.f6356c = f4;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    private HashMap<Integer, b> a() {
        HashMap<Integer, b> map = new HashMap<>();
        if (this.f6352c[0] != Property.DEFAULT_FLOAT_VALUE) {
            map.put(0, new b(Color.argb(0, Color.red(this.f6351b[0]), Color.green(this.f6351b[0]), Color.blue(this.f6351b[0])), this.f6351b[0], this.f6350a * this.f6352c[0]));
        }
        for (int i4 = 1; i4 < this.f6351b.length; i4++) {
            int i5 = i4 - 1;
            Integer numValueOf = Integer.valueOf((int) (this.f6350a * this.f6352c[i5]));
            int[] iArr = this.f6351b;
            int i6 = iArr[i5];
            int i7 = iArr[i4];
            float f4 = this.f6350a;
            float[] fArr = this.f6352c;
            map.put(numValueOf, new b(i6, i7, (fArr[i4] - fArr[i5]) * f4));
        }
        float[] fArr2 = this.f6352c;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer numValueOf2 = Integer.valueOf((int) (this.f6350a * fArr2[length]));
            int i8 = this.f6351b[length];
            map.put(numValueOf2, new b(i8, i8, (1.0f - this.f6352c[length]) * this.f6350a));
        }
        return map;
    }

    public float[] b() {
        float[] fArr = this.f6353d;
        if (fArr != null) {
            return fArr;
        }
        this.f6353d = new float[this.f6350a];
        int i4 = 0;
        while (i4 < this.f6350a) {
            int i5 = i4 + 1;
            this.f6353d[i4] = i5 * 0.001f;
            i4 = i5;
        }
        return this.f6353d;
    }

    public int[] getColors() {
        return this.f6351b;
    }

    public float[] getStartPoints() {
        return this.f6352c;
    }

    private Gradient(int[] iArr, float[] fArr, int i4) {
        int[] iArrA = com.baidu.platform.comapi.util.d.a(iArr);
        if (iArrA == null || fArr == null) {
            throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should not be null");
        }
        if (iArrA.length != fArr.length) {
            throw new IllegalArgumentException("BDMapSDKException: colors and startPoints should be same length");
        }
        if (iArrA.length == 0) {
            throw new IllegalArgumentException("BDMapSDKException: No colors have been defined");
        }
        for (int i5 = 1; i5 < fArr.length; i5++) {
            if (fArr[i5] <= fArr[i5 - 1]) {
                throw new IllegalArgumentException("BDMapSDKException: startPoints should be in increasing order");
            }
        }
        this.f6350a = i4;
        int[] iArr2 = new int[iArrA.length];
        this.f6351b = iArr2;
        float[] fArr2 = new float[fArr.length];
        this.f6352c = fArr2;
        System.arraycopy(iArrA, 0, iArr2, 0, iArrA.length);
        System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
    }

    public int[] a(double d4) {
        HashMap<Integer, b> mapA = a();
        int[] iArr = new int[this.f6350a];
        b bVar = mapA.get(0);
        int i4 = 0;
        for (int i5 = 0; i5 < this.f6350a; i5++) {
            if (mapA.containsKey(Integer.valueOf(i5))) {
                bVar = mapA.get(Integer.valueOf(i5));
                i4 = i5;
            }
            iArr[i5] = a(bVar.f6354a, bVar.f6355b, (i5 - i4) / bVar.f6356c);
        }
        if (d4 != 1.0d) {
            for (int i6 = 0; i6 < this.f6350a; i6++) {
                int i7 = iArr[i6];
                iArr[i6] = Color.argb((int) (Color.alpha(i7) * d4), Color.red(i7), Color.green(i7), Color.blue(i7));
            }
        }
        return iArr;
    }

    private static int a(int i4, int i5, float f4) {
        int iAlpha = (int) (((Color.alpha(i5) - Color.alpha(i4)) * f4) + Color.alpha(i4));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i4), Color.green(i4), Color.blue(i4), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i5), Color.green(i5), Color.blue(i5), fArr2);
        float f5 = fArr[0];
        float f6 = fArr2[0];
        if (f5 - f6 > 180.0f) {
            fArr2[0] = f6 + 360.0f;
        } else if (f6 - f5 > 180.0f) {
            fArr[0] = f5 + 360.0f;
        }
        float[] fArr3 = new float[3];
        for (int i6 = 0; i6 < 3; i6++) {
            float f7 = fArr2[i6];
            float f8 = fArr[i6];
            fArr3[i6] = AbstractC0831a.c(f7, f8, f4, f8);
        }
        return Color.HSVToColor(iAlpha, fArr3);
    }
}
