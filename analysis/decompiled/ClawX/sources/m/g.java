package m;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f3877a;

    /* renamed from: e, reason: collision with root package name */
    public float f3880e;

    /* renamed from: m, reason: collision with root package name */
    public int f3887m;

    /* renamed from: b, reason: collision with root package name */
    public int f3878b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f3879c = -1;
    public int d = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3881f = false;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f3882g = new float[9];

    /* renamed from: h, reason: collision with root package name */
    public final float[] f3883h = new float[9];

    /* renamed from: j, reason: collision with root package name */
    public b[] f3884j = new b[16];

    /* renamed from: k, reason: collision with root package name */
    public int f3885k = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f3886l = 0;

    public g(int i8) {
        this.f3887m = i8;
    }

    public final void a(b bVar) {
        int i8 = 0;
        while (true) {
            int i9 = this.f3885k;
            if (i8 >= i9) {
                b[] bVarArr = this.f3884j;
                if (i9 >= bVarArr.length) {
                    this.f3884j = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f3884j;
                int i10 = this.f3885k;
                bVarArr2[i10] = bVar;
                this.f3885k = i10 + 1;
                return;
            }
            if (this.f3884j[i8] == bVar) {
                return;
            } else {
                i8++;
            }
        }
    }

    public final void b(b bVar) {
        int i8 = this.f3885k;
        int i9 = 0;
        while (i9 < i8) {
            if (this.f3884j[i9] == bVar) {
                while (i9 < i8 - 1) {
                    b[] bVarArr = this.f3884j;
                    int i10 = i9 + 1;
                    bVarArr[i9] = bVarArr[i10];
                    i9 = i10;
                }
                this.f3885k--;
                return;
            }
            i9++;
        }
    }

    public final void c() {
        this.f3887m = 5;
        this.d = 0;
        this.f3878b = -1;
        this.f3879c = -1;
        this.f3880e = 0.0f;
        this.f3881f = false;
        int i8 = this.f3885k;
        for (int i9 = 0; i9 < i8; i9++) {
            this.f3884j[i9] = null;
        }
        this.f3885k = 0;
        this.f3886l = 0;
        this.f3877a = false;
        Arrays.fill(this.f3883h, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f3878b - ((g) obj).f3878b;
    }

    public final void d(c cVar, float f3) {
        this.f3880e = f3;
        this.f3881f = true;
        int i8 = this.f3885k;
        this.f3879c = -1;
        for (int i9 = 0; i9 < i8; i9++) {
            this.f3884j[i9].h(cVar, this, false);
        }
        this.f3885k = 0;
    }

    public final void e(c cVar, b bVar) {
        int i8 = this.f3885k;
        for (int i9 = 0; i9 < i8; i9++) {
            this.f3884j[i9].i(cVar, bVar, false);
        }
        this.f3885k = 0;
    }

    public final String toString() {
        return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID + this.f3878b;
    }
}
