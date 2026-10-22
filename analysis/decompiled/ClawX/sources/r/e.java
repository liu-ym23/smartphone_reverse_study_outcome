package r;

import android.view.ViewGroup;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends ViewGroup.MarginLayoutParams {
    public int A;
    public int B;
    public int C;
    public float D;
    public float E;
    public String F;
    public float G;
    public float H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public float R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;
    public String X;
    public int Y;
    public boolean Z;

    /* renamed from: a, reason: collision with root package name */
    public int f4919a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f4920a0;

    /* renamed from: b, reason: collision with root package name */
    public int f4921b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f4922b0;

    /* renamed from: c, reason: collision with root package name */
    public float f4923c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f4924c0;
    public int d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f4925d0;

    /* renamed from: e, reason: collision with root package name */
    public int f4926e;

    /* renamed from: e0, reason: collision with root package name */
    public int f4927e0;

    /* renamed from: f, reason: collision with root package name */
    public int f4928f;

    /* renamed from: f0, reason: collision with root package name */
    public int f4929f0;

    /* renamed from: g, reason: collision with root package name */
    public int f4930g;

    /* renamed from: g0, reason: collision with root package name */
    public int f4931g0;

    /* renamed from: h, reason: collision with root package name */
    public int f4932h;

    /* renamed from: h0, reason: collision with root package name */
    public int f4933h0;

    /* renamed from: i, reason: collision with root package name */
    public int f4934i;

    /* renamed from: i0, reason: collision with root package name */
    public int f4935i0;

    /* renamed from: j, reason: collision with root package name */
    public int f4936j;

    /* renamed from: j0, reason: collision with root package name */
    public int f4937j0;

    /* renamed from: k, reason: collision with root package name */
    public int f4938k;
    public float k0;

    /* renamed from: l, reason: collision with root package name */
    public int f4939l;

    /* renamed from: l0, reason: collision with root package name */
    public int f4940l0;

    /* renamed from: m, reason: collision with root package name */
    public int f4941m;

    /* renamed from: m0, reason: collision with root package name */
    public int f4942m0;

    /* renamed from: n, reason: collision with root package name */
    public int f4943n;

    /* renamed from: n0, reason: collision with root package name */
    public float f4944n0;

    /* renamed from: o, reason: collision with root package name */
    public int f4945o;

    /* renamed from: o0, reason: collision with root package name */
    public o.d f4946o0;

    /* renamed from: p, reason: collision with root package name */
    public int f4947p;

    /* renamed from: q, reason: collision with root package name */
    public float f4948q;

    /* renamed from: r, reason: collision with root package name */
    public int f4949r;

    /* renamed from: s, reason: collision with root package name */
    public int f4950s;

    /* renamed from: t, reason: collision with root package name */
    public int f4951t;

    /* renamed from: u, reason: collision with root package name */
    public int f4952u;

    /* renamed from: v, reason: collision with root package name */
    public int f4953v;

    /* renamed from: w, reason: collision with root package name */
    public int f4954w;

    /* renamed from: x, reason: collision with root package name */
    public int f4955x;
    public int y;
    public int z;

    public final void a() {
        this.f4924c0 = false;
        this.Z = true;
        this.f4920a0 = true;
        int i8 = ((ViewGroup.MarginLayoutParams) this).width;
        if (i8 == -2 && this.V) {
            this.Z = false;
            if (this.K == 0) {
                this.K = 1;
            }
        }
        int i9 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i9 == -2 && this.W) {
            this.f4920a0 = false;
            if (this.L == 0) {
                this.L = 1;
            }
        }
        if (i8 == 0 || i8 == -1) {
            this.Z = false;
            if (i8 == 0 && this.K == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.V = true;
            }
        }
        if (i9 == 0 || i9 == -1) {
            this.f4920a0 = false;
            if (i9 == 0 && this.L == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.W = true;
            }
        }
        if (this.f4923c == -1.0f && this.f4919a == -1 && this.f4921b == -1) {
            return;
        }
        this.f4924c0 = true;
        this.Z = true;
        this.f4920a0 = true;
        if (!(this.f4946o0 instanceof o.h)) {
            this.f4946o0 = new o.h();
        }
        ((o.h) this.f4946o0).N(this.U);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resolveLayoutDirection(int r11) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r.e.resolveLayoutDirection(int):void");
    }
}
