package z2;

import android.view.ViewGroup;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends ViewGroup.MarginLayoutParams {
    public int A;
    public int B;
    public int C;
    public int D;
    public float E;
    public float F;
    public String G;
    public float H;
    public float I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public float R;
    public float S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public String Y;
    public int Z;

    /* renamed from: a, reason: collision with root package name */
    public int f16191a;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f16192a0;

    /* renamed from: b, reason: collision with root package name */
    public int f16193b;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f16194b0;

    /* renamed from: c, reason: collision with root package name */
    public float f16195c;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f16196c0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16197d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f16198d0;

    /* renamed from: e, reason: collision with root package name */
    public int f16199e;
    public boolean e0;

    /* renamed from: f, reason: collision with root package name */
    public int f16200f;
    public int f0;

    /* renamed from: g, reason: collision with root package name */
    public int f16201g;

    /* renamed from: g0, reason: collision with root package name */
    public int f16202g0;

    /* renamed from: h, reason: collision with root package name */
    public int f16203h;

    /* renamed from: h0, reason: collision with root package name */
    public int f16204h0;
    public int i;

    /* renamed from: i0, reason: collision with root package name */
    public int f16205i0;

    /* renamed from: j, reason: collision with root package name */
    public int f16206j;

    /* renamed from: j0, reason: collision with root package name */
    public int f16207j0;

    /* renamed from: k, reason: collision with root package name */
    public int f16208k;

    /* renamed from: k0, reason: collision with root package name */
    public int f16209k0;

    /* renamed from: l, reason: collision with root package name */
    public int f16210l;

    /* renamed from: l0, reason: collision with root package name */
    public float f16211l0;

    /* renamed from: m, reason: collision with root package name */
    public int f16212m;

    /* renamed from: m0, reason: collision with root package name */
    public int f16213m0;

    /* renamed from: n, reason: collision with root package name */
    public int f16214n;

    /* renamed from: n0, reason: collision with root package name */
    public int f16215n0;

    /* renamed from: o, reason: collision with root package name */
    public int f16216o;

    /* renamed from: o0, reason: collision with root package name */
    public float f16217o0;

    /* renamed from: p, reason: collision with root package name */
    public int f16218p;

    /* renamed from: p0, reason: collision with root package name */
    public w2.e f16219p0;

    /* renamed from: q, reason: collision with root package name */
    public int f16220q;

    /* renamed from: r, reason: collision with root package name */
    public float f16221r;

    /* renamed from: s, reason: collision with root package name */
    public int f16222s;

    /* renamed from: t, reason: collision with root package name */
    public int f16223t;

    /* renamed from: u, reason: collision with root package name */
    public int f16224u;

    /* renamed from: v, reason: collision with root package name */
    public int f16225v;

    /* renamed from: w, reason: collision with root package name */
    public int f16226w;

    /* renamed from: x, reason: collision with root package name */
    public int f16227x;

    /* renamed from: y, reason: collision with root package name */
    public int f16228y;

    /* renamed from: z, reason: collision with root package name */
    public int f16229z;

    public final void a() {
        this.f16198d0 = false;
        this.f16192a0 = true;
        this.f16194b0 = true;
        int i = ((ViewGroup.MarginLayoutParams) this).width;
        if (i == -2 && this.W) {
            this.f16192a0 = false;
            if (this.L == 0) {
                this.L = 1;
            }
        }
        int i3 = ((ViewGroup.MarginLayoutParams) this).height;
        if (i3 == -2 && this.X) {
            this.f16194b0 = false;
            if (this.M == 0) {
                this.M = 1;
            }
        }
        if (i == 0 || i == -1) {
            this.f16192a0 = false;
            if (i == 0 && this.L == 1) {
                ((ViewGroup.MarginLayoutParams) this).width = -2;
                this.W = true;
            }
        }
        if (i3 == 0 || i3 == -1) {
            this.f16194b0 = false;
            if (i3 == 0 && this.M == 1) {
                ((ViewGroup.MarginLayoutParams) this).height = -2;
                this.X = true;
            }
        }
        if (this.f16195c == -1.0f && this.f16191a == -1 && this.f16193b == -1) {
            return;
        }
        this.f16198d0 = true;
        this.f16192a0 = true;
        this.f16194b0 = true;
        if (!(this.f16219p0 instanceof w2.g)) {
            this.f16219p0 = new w2.g();
        }
        ((w2.g) this.f16219p0).O(this.V);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0082  */
    @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void resolveLayoutDirection(int r12) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.d.resolveLayoutDirection(int):void");
    }
}
