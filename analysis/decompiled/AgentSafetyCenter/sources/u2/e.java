package u2;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements Comparable {

    /* renamed from: c, reason: collision with root package name */
    public boolean f14014c;
    public float i;

    /* renamed from: p, reason: collision with root package name */
    public int f14024p;

    /* renamed from: f, reason: collision with root package name */
    public int f14015f = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f14016g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f14017h = 0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14018j = false;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f14019k = new float[9];

    /* renamed from: l, reason: collision with root package name */
    public final float[] f14020l = new float[9];

    /* renamed from: m, reason: collision with root package name */
    public b[] f14021m = new b[16];

    /* renamed from: n, reason: collision with root package name */
    public int f14022n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f14023o = 0;

    public e(int i) {
        this.f14024p = i;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i3 = this.f14022n;
            b[] bVarArr = this.f14021m;
            if (i >= i3) {
                if (i3 >= bVarArr.length) {
                    this.f14021m = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f14021m;
                int i10 = this.f14022n;
                bVarArr2[i10] = bVar;
                this.f14022n = i10 + 1;
                return;
            }
            if (bVarArr[i] == bVar) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void b(b bVar) {
        int i = this.f14022n;
        int i3 = 0;
        while (i3 < i) {
            if (this.f14021m[i3] == bVar) {
                while (i3 < i - 1) {
                    b[] bVarArr = this.f14021m;
                    int i10 = i3 + 1;
                    bVarArr[i3] = bVarArr[i10];
                    i3 = i10;
                }
                this.f14022n--;
                return;
            }
            i3++;
        }
    }

    public final void c() {
        this.f14024p = 5;
        this.f14017h = 0;
        this.f14015f = -1;
        this.f14016g = -1;
        this.i = 0.0f;
        this.f14018j = false;
        int i = this.f14022n;
        for (int i3 = 0; i3 < i; i3++) {
            this.f14021m[i3] = null;
        }
        this.f14022n = 0;
        this.f14023o = 0;
        this.f14014c = false;
        Arrays.fill(this.f14020l, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f14015f - ((e) obj).f14015f;
    }

    public final void d(c cVar, float f5) {
        this.i = f5;
        this.f14018j = true;
        int i = this.f14022n;
        this.f14016g = -1;
        for (int i3 = 0; i3 < i; i3++) {
            this.f14021m[i3].h(cVar, this, false);
        }
        this.f14022n = 0;
    }

    public final void e(c cVar, b bVar) {
        int i = this.f14022n;
        for (int i3 = 0; i3 < i; i3++) {
            this.f14021m[i3].i(cVar, bVar, false);
        }
        this.f14022n = 0;
    }

    public final String toString() {
        return "" + this.f14015f;
    }
}
