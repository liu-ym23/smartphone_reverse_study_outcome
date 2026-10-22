package y1;

import android.util.StateSet;

/* renamed from: y1.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0986A {

    /* renamed from: a, reason: collision with root package name */
    public int f16174a;

    /* renamed from: b, reason: collision with root package name */
    public n f16175b;

    /* renamed from: c, reason: collision with root package name */
    public int[][] f16176c;

    /* renamed from: d, reason: collision with root package name */
    public n[] f16177d;

    /* renamed from: e, reason: collision with root package name */
    public z f16178e;

    /* renamed from: f, reason: collision with root package name */
    public z f16179f;

    /* renamed from: g, reason: collision with root package name */
    public z f16180g;

    /* renamed from: h, reason: collision with root package name */
    public z f16181h;

    public C0986A(n nVar) {
        c();
        a(StateSet.WILD_CARD, nVar);
    }

    public final void a(int[] iArr, n nVar) {
        int i4 = this.f16174a;
        if (i4 == 0 || iArr.length == 0) {
            this.f16175b = nVar;
        }
        int[][] iArr2 = this.f16176c;
        if (i4 >= iArr2.length) {
            int i5 = i4 + 10;
            int[][] iArr3 = new int[i5][];
            System.arraycopy(iArr2, 0, iArr3, 0, i4);
            this.f16176c = iArr3;
            n[] nVarArr = new n[i5];
            System.arraycopy(this.f16177d, 0, nVarArr, 0, i4);
            this.f16177d = nVarArr;
        }
        int[][] iArr4 = this.f16176c;
        int i6 = this.f16174a;
        iArr4[i6] = iArr;
        this.f16177d[i6] = nVar;
        this.f16174a = i6 + 1;
    }

    public final B b() {
        if (this.f16174a == 0) {
            return null;
        }
        return new B(this);
    }

    public final void c() {
        this.f16175b = new n();
        this.f16176c = new int[10][];
        this.f16177d = new n[10];
    }
}
