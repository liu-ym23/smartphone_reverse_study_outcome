package y;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public int[] f16031a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f16032b;

    /* renamed from: c, reason: collision with root package name */
    public int f16033c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f16034d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f16035e;

    /* renamed from: f, reason: collision with root package name */
    public int f16036f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f16037g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f16038h;

    /* renamed from: i, reason: collision with root package name */
    public int f16039i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f16040j;

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f16041k;

    /* renamed from: l, reason: collision with root package name */
    public int f16042l;

    public final void a(float f4, int i4) {
        int i5 = this.f16036f;
        int[] iArr = this.f16034d;
        if (i5 >= iArr.length) {
            this.f16034d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f16035e;
            this.f16035e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f16034d;
        int i6 = this.f16036f;
        iArr2[i6] = i4;
        float[] fArr2 = this.f16035e;
        this.f16036f = i6 + 1;
        fArr2[i6] = f4;
    }

    public final void b(int i4, int i5) {
        int i6 = this.f16033c;
        int[] iArr = this.f16031a;
        if (i6 >= iArr.length) {
            this.f16031a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f16032b;
            this.f16032b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f16031a;
        int i7 = this.f16033c;
        iArr3[i7] = i4;
        int[] iArr4 = this.f16032b;
        this.f16033c = i7 + 1;
        iArr4[i7] = i5;
    }

    public final void c(int i4, String str) {
        int i5 = this.f16039i;
        int[] iArr = this.f16037g;
        if (i5 >= iArr.length) {
            this.f16037g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f16038h;
            this.f16038h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f16037g;
        int i6 = this.f16039i;
        iArr2[i6] = i4;
        String[] strArr2 = this.f16038h;
        this.f16039i = i6 + 1;
        strArr2[i6] = str;
    }

    public final void d(int i4, boolean z4) {
        int i5 = this.f16042l;
        int[] iArr = this.f16040j;
        if (i5 >= iArr.length) {
            this.f16040j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f16041k;
            this.f16041k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f16040j;
        int i6 = this.f16042l;
        iArr2[i6] = i4;
        boolean[] zArr2 = this.f16041k;
        this.f16042l = i6 + 1;
        zArr2[i6] = z4;
    }
}
