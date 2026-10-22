package y;

import android.view.ViewGroup;
import v.C0944d;
import v.C0948h;

/* loaded from: classes.dex */
public final class e extends ViewGroup.MarginLayoutParams {

    /* renamed from: A, reason: collision with root package name */
    public int f15953A;

    /* renamed from: B, reason: collision with root package name */
    public int f15954B;

    /* renamed from: C, reason: collision with root package name */
    public int f15955C;

    /* renamed from: D, reason: collision with root package name */
    public int f15956D;

    /* renamed from: E, reason: collision with root package name */
    public float f15957E;

    /* renamed from: F, reason: collision with root package name */
    public float f15958F;

    /* renamed from: G, reason: collision with root package name */
    public String f15959G;

    /* renamed from: H, reason: collision with root package name */
    public float f15960H;

    /* renamed from: I, reason: collision with root package name */
    public float f15961I;

    /* renamed from: J, reason: collision with root package name */
    public int f15962J;

    /* renamed from: K, reason: collision with root package name */
    public int f15963K;

    /* renamed from: L, reason: collision with root package name */
    public int f15964L;

    /* renamed from: M, reason: collision with root package name */
    public int f15965M;

    /* renamed from: N, reason: collision with root package name */
    public int f15966N;

    /* renamed from: O, reason: collision with root package name */
    public int f15967O;

    /* renamed from: P, reason: collision with root package name */
    public int f15968P;

    /* renamed from: Q, reason: collision with root package name */
    public int f15969Q;

    /* renamed from: R, reason: collision with root package name */
    public float f15970R;

    /* renamed from: S, reason: collision with root package name */
    public float f15971S;
    public int T;

    /* renamed from: U, reason: collision with root package name */
    public int f15972U;

    /* renamed from: V, reason: collision with root package name */
    public int f15973V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f15974W;

    /* renamed from: X, reason: collision with root package name */
    public boolean f15975X;

    /* renamed from: Y, reason: collision with root package name */
    public String f15976Y;

    /* renamed from: Z, reason: collision with root package name */
    public int f15977Z;

    /* renamed from: a, reason: collision with root package name */
    public int f15978a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f15979a0;

    /* renamed from: b, reason: collision with root package name */
    public int f15980b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f15981b0;

    /* renamed from: c, reason: collision with root package name */
    public float f15982c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f15983c0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15984d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f15985d0;

    /* renamed from: e, reason: collision with root package name */
    public int f15986e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f15987e0;

    /* renamed from: f, reason: collision with root package name */
    public int f15988f;

    /* renamed from: f0, reason: collision with root package name */
    public int f15989f0;

    /* renamed from: g, reason: collision with root package name */
    public int f15990g;

    /* renamed from: g0, reason: collision with root package name */
    public int f15991g0;

    /* renamed from: h, reason: collision with root package name */
    public int f15992h;

    /* renamed from: h0, reason: collision with root package name */
    public int f15993h0;

    /* renamed from: i, reason: collision with root package name */
    public int f15994i;

    /* renamed from: i0, reason: collision with root package name */
    public int f15995i0;

    /* renamed from: j, reason: collision with root package name */
    public int f15996j;

    /* renamed from: j0, reason: collision with root package name */
    public int f15997j0;

    /* renamed from: k, reason: collision with root package name */
    public int f15998k;

    /* renamed from: k0, reason: collision with root package name */
    public int f15999k0;

    /* renamed from: l, reason: collision with root package name */
    public int f16000l;

    /* renamed from: l0, reason: collision with root package name */
    public float f16001l0;

    /* renamed from: m, reason: collision with root package name */
    public int f16002m;

    /* renamed from: m0, reason: collision with root package name */
    public int f16003m0;

    /* renamed from: n, reason: collision with root package name */
    public int f16004n;

    /* renamed from: n0, reason: collision with root package name */
    public int f16005n0;

    /* renamed from: o, reason: collision with root package name */
    public int f16006o;

    /* renamed from: o0, reason: collision with root package name */
    public float f16007o0;

    /* renamed from: p, reason: collision with root package name */
    public int f16008p;

    /* renamed from: p0, reason: collision with root package name */
    public C0944d f16009p0;

    /* renamed from: q, reason: collision with root package name */
    public int f16010q;

    /* renamed from: r, reason: collision with root package name */
    public float f16011r;

    /* renamed from: s, reason: collision with root package name */
    public int f16012s;

    /* renamed from: t, reason: collision with root package name */
    public int f16013t;

    /* renamed from: u, reason: collision with root package name */
    public int f16014u;

    /* renamed from: v, reason: collision with root package name */
    public int f16015v;

    /* renamed from: w, reason: collision with root package name */
    public int f16016w;

    /* renamed from: x, reason: collision with root package name */
    public int f16017x;

    /* renamed from: y, reason: collision with root package name */
    public int f16018y;

    /* renamed from: z, reason: collision with root package name */
    public int f16019z;

    public final void a() {
        this.f15985d0 = false;
        this.f15979a0 = true;
        this.f15981b0 = true;
        int i4 = ((ViewGroup.MarginLayoutParams) this).width;
        if (i4 == -2 && this.f15974W) {
            this.f15979a0 = false;
            if (this.f15964L == 0) {
                this.f15964L = 1;
            }
        }
        int i5 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i5 == -2 && this.f15975X) {
            this.f15981b0 = false;
            if (this.f15965M == 0) {
                this.f15965M = 1;
            }
        }
        if (i4 == 0 || i4 == -1) {
            this.f15979a0 = false;
            if (i4 == 0 && this.f15964L == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.f15974W = true;
            }
        }
        if (i5 == 0 || i5 == -1) {
            this.f15981b0 = false;
            if (i5 == 0 && this.f15965M == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.f15975X = true;
            }
        }
        if (this.f15982c == -1.0f && this.f15978a == -1 && this.f15980b == -1) {
            return;
        }
        this.f15985d0 = true;
        this.f15979a0 = true;
        this.f15981b0 = true;
        if (!(this.f16009p0 instanceof C0948h)) {
            this.f16009p0 = new C0948h();
        }
        ((C0948h) this.f16009p0).T(this.f15973V);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resolveLayoutDirection(int r11) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y.e.resolveLayoutDirection(int):void");
    }
}
