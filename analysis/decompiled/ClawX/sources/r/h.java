package r;

import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public int[] f4967a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f4968b;

    /* renamed from: c, reason: collision with root package name */
    public int f4969c;
    public int[] d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f4970e;

    /* renamed from: f, reason: collision with root package name */
    public int f4971f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f4972g;

    /* renamed from: h, reason: collision with root package name */
    public String[] f4973h;

    /* renamed from: i, reason: collision with root package name */
    public int f4974i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f4975j;

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f4976k;

    /* renamed from: l, reason: collision with root package name */
    public int f4977l;

    public final void a(int i8, float f3) {
        int i9 = this.f4971f;
        int[] iArr = this.d;
        if (i9 >= iArr.length) {
            this.d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f4970e;
            this.f4970e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.d;
        int i10 = this.f4971f;
        iArr2[i10] = i8;
        float[] fArr2 = this.f4970e;
        this.f4971f = i10 + 1;
        fArr2[i10] = f3;
    }

    public final void b(int i8, int i9) {
        int i10 = this.f4969c;
        int[] iArr = this.f4967a;
        if (i10 >= iArr.length) {
            this.f4967a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f4968b;
            this.f4968b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f4967a;
        int i11 = this.f4969c;
        iArr3[i11] = i8;
        int[] iArr4 = this.f4968b;
        this.f4969c = i11 + 1;
        iArr4[i11] = i9;
    }

    public final void c(int i8, String str) {
        int i9 = this.f4974i;
        int[] iArr = this.f4972g;
        if (i9 >= iArr.length) {
            this.f4972g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f4973h;
            this.f4973h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f4972g;
        int i10 = this.f4974i;
        iArr2[i10] = i8;
        String[] strArr2 = this.f4973h;
        this.f4974i = i10 + 1;
        strArr2[i10] = str;
    }

    public final void d(int i8, boolean z) {
        int i9 = this.f4977l;
        int[] iArr = this.f4975j;
        if (i9 >= iArr.length) {
            this.f4975j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f4976k;
            this.f4976k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f4975j;
        int i10 = this.f4977l;
        iArr2[i10] = i8;
        boolean[] zArr2 = this.f4976k;
        this.f4977l = i10 + 1;
        zArr2[i10] = z;
    }
}
