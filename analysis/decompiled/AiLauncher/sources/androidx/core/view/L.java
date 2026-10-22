package androidx.core.view;

/* loaded from: classes.dex */
public class L {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f13112a = new float[20];

    /* renamed from: b, reason: collision with root package name */
    public final long[] f13113b = new long[20];

    /* renamed from: c, reason: collision with root package name */
    public float f13114c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    public int f13115d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f13116e = 0;

    public static float c(float f10) {
        return (f10 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f10) * 2.0f));
    }

    public void a(int i10, float f10) {
        float fB = b() * i10;
        this.f13114c = fB;
        if (fB < (-Math.abs(f10))) {
            this.f13114c = -Math.abs(f10);
        } else if (this.f13114c > Math.abs(f10)) {
            this.f13114c = Math.abs(f10);
        }
    }

    public final float b() {
        long[] jArr;
        long j10;
        int i10 = this.f13115d;
        if (i10 < 2) {
            return 0.0f;
        }
        int i11 = this.f13116e;
        int i12 = ((i11 + 20) - (i10 - 1)) % 20;
        long j11 = this.f13113b[i11];
        while (true) {
            jArr = this.f13113b;
            j10 = jArr[i12];
            if (j11 - j10 <= 100) {
                break;
            }
            this.f13115d--;
            i12 = (i12 + 1) % 20;
        }
        int i13 = this.f13115d;
        if (i13 < 2) {
            return 0.0f;
        }
        if (i13 == 2) {
            int i14 = (i12 + 1) % 20;
            if (j10 == jArr[i14]) {
                return 0.0f;
            }
            return this.f13112a[i14] / (r2 - j10);
        }
        float fAbs = 0.0f;
        int i15 = 0;
        for (int i16 = 0; i16 < this.f13115d - 1; i16++) {
            int i17 = i16 + i12;
            long[] jArr2 = this.f13113b;
            long j12 = jArr2[i17 % 20];
            int i18 = (i17 + 1) % 20;
            if (jArr2[i18] != j12) {
                i15++;
                float fC = c(fAbs);
                float f10 = this.f13112a[i18] / (this.f13113b[i18] - j12);
                fAbs += (f10 - fC) * Math.abs(f10);
                if (i15 == 1) {
                    fAbs *= 0.5f;
                }
            }
        }
        return c(fAbs);
    }
}
