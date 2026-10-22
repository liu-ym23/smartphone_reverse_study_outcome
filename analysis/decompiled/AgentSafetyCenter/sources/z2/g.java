package z2;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public int[] f16243a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f16244b;

    /* renamed from: c, reason: collision with root package name */
    public int f16245c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f16246d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f16247e;

    /* renamed from: f, reason: collision with root package name */
    public int f16248f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f16249g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f16250h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f16251j;

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f16252k;

    /* renamed from: l, reason: collision with root package name */
    public int f16253l;

    public final void a(float f5, int i) {
        int i3 = this.f16248f;
        int[] iArr = this.f16246d;
        if (i3 >= iArr.length) {
            this.f16246d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f16247e;
            this.f16247e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f16246d;
        int i10 = this.f16248f;
        iArr2[i10] = i;
        float[] fArr2 = this.f16247e;
        this.f16248f = i10 + 1;
        fArr2[i10] = f5;
    }

    public final void b(int i, int i3) {
        int i10 = this.f16245c;
        int[] iArr = this.f16243a;
        if (i10 >= iArr.length) {
            this.f16243a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f16244b;
            this.f16244b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f16243a;
        int i11 = this.f16245c;
        iArr3[i11] = i;
        int[] iArr4 = this.f16244b;
        this.f16245c = i11 + 1;
        iArr4[i11] = i3;
    }

    public final void c(int i, String str) {
        int i3 = this.i;
        int[] iArr = this.f16249g;
        if (i3 >= iArr.length) {
            this.f16249g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f16250h;
            this.f16250h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f16249g;
        int i10 = this.i;
        iArr2[i10] = i;
        String[] strArr2 = this.f16250h;
        this.i = i10 + 1;
        strArr2[i10] = str;
    }

    public final void d(int i, boolean z10) {
        int i3 = this.f16253l;
        int[] iArr = this.f16251j;
        if (i3 >= iArr.length) {
            this.f16251j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f16252k;
            this.f16252k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f16251j;
        int i10 = this.f16253l;
        iArr2[i10] = i;
        boolean[] zArr2 = this.f16252k;
        this.f16253l = i10 + 1;
        zArr2[i10] = z10;
    }
}
