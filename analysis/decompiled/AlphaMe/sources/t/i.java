package t;

import com.stepos.alphame.utils.Property;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class i implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f15301a;

    /* renamed from: e, reason: collision with root package name */
    public float f15305e;

    /* renamed from: l, reason: collision with root package name */
    public int f15312l;

    /* renamed from: b, reason: collision with root package name */
    public int f15302b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f15303c = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f15304d = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15306f = false;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f15307g = new float[9];

    /* renamed from: h, reason: collision with root package name */
    public final float[] f15308h = new float[9];

    /* renamed from: i, reason: collision with root package name */
    public c[] f15309i = new c[16];

    /* renamed from: j, reason: collision with root package name */
    public int f15310j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f15311k = 0;

    public i(int i4) {
        this.f15312l = i4;
    }

    public final void a(c cVar) {
        int i4 = 0;
        while (true) {
            int i5 = this.f15310j;
            if (i4 >= i5) {
                c[] cVarArr = this.f15309i;
                if (i5 >= cVarArr.length) {
                    this.f15309i = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
                }
                c[] cVarArr2 = this.f15309i;
                int i6 = this.f15310j;
                cVarArr2[i6] = cVar;
                this.f15310j = i6 + 1;
                return;
            }
            if (this.f15309i[i4] == cVar) {
                return;
            } else {
                i4++;
            }
        }
    }

    public final void b(c cVar) {
        int i4 = this.f15310j;
        int i5 = 0;
        while (i5 < i4) {
            if (this.f15309i[i5] == cVar) {
                while (i5 < i4 - 1) {
                    c[] cVarArr = this.f15309i;
                    int i6 = i5 + 1;
                    cVarArr[i5] = cVarArr[i6];
                    i5 = i6;
                }
                this.f15310j--;
                return;
            }
            i5++;
        }
    }

    public final void c() {
        this.f15312l = 5;
        this.f15304d = 0;
        this.f15302b = -1;
        this.f15303c = -1;
        this.f15305e = Property.DEFAULT_FLOAT_VALUE;
        this.f15306f = false;
        int i4 = this.f15310j;
        for (int i5 = 0; i5 < i4; i5++) {
            this.f15309i[i5] = null;
        }
        this.f15310j = 0;
        this.f15311k = 0;
        this.f15301a = false;
        Arrays.fill(this.f15308h, Property.DEFAULT_FLOAT_VALUE);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f15302b - ((i) obj).f15302b;
    }

    public final void d(e eVar, float f4) {
        this.f15305e = f4;
        this.f15306f = true;
        int i4 = this.f15310j;
        this.f15303c = -1;
        for (int i5 = 0; i5 < i4; i5++) {
            this.f15309i[i5].h(eVar, this, false);
        }
        this.f15310j = 0;
    }

    public final void e(e eVar, c cVar) {
        int i4 = this.f15310j;
        for (int i5 = 0; i5 < i4; i5++) {
            this.f15309i[i5].i(eVar, cVar, false);
        }
        this.f15310j = 0;
    }

    public final String toString() {
        return "" + this.f15302b;
    }
}
