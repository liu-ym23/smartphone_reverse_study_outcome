package bw7;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes23.dex */
public final class h {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d f21214r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f21217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView.ViewHolder f21218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f21219e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21220f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f21221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f21222h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f21223i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f21224j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f21225k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f21226l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f21227m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f21228n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f21229o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f21230p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f21231q;

    static {
        f21214r = new d();
    }

    public void update(int r100, int r110, int r111) {
        if (this.f21227m == r110) goto L5;
    L7:
        this.f21227m = r110;
        this.f21228n = r111;
        boolean r101 = this.f21216b;
        if (r101 == false) goto L10;
        r111 = this.f21230p;
    L11:
        int r112 = r110 + r111;
        if (r101 == false) goto L14;
        int r113 = this.f21224j;
    L15:
        if (r101 == false) goto L17;
        float r102 = this.f21225k;
    L18:
        if (r101 == false) goto L22;
        if (r112 <= 0) goto L21;
        int r103 = this.f21222h;
    L26:
        if (r103 != 1) goto L28;
        float r114 = Math.signum(r112) * f21214r.getInterpolation(Math.min(Math.abs(r112), r113) * r102);
    L32:
        this.f21217c.b(this.f21218d, r100, this.f21229o, r114, true, this.f21216b, false);
        this.f21229o = r114;
        return;
    L28:
        if (r103 == 2) goto L30;
        r114 = 0.0f;
        goto L32
    L30:
        r114 = Math.min(Math.max(r112 * r102, -1.0f), 1.0f);
        goto L32
    L21:
        r103 = this.f21220f;
        goto L26
    L22:
        if (r112 <= 0) goto L24;
        r103 = this.f21223i;
        goto L26
    L24:
        r103 = this.f21221g;
        goto L26
    L17:
        r102 = this.f21226l;
        goto L18
    L14:
        r113 = this.f21215a;
        goto L15
    L10:
        r110 = this.f21231q;
        goto L11
    L5:
        if (this.f21228n != r111) goto L7;
    }

    public h(b r100, RecyclerView.ViewHolder r101, int r102, boolean r103) {
        this.f21217c = r100;
        this.f21218d = r101;
        this.f21220f = (r102 >>> 0) & 3;
        this.f21221g = (r102 >>> 6) & 3;
        this.f21222h = (r102 >>> 12) & 3;
        this.f21223i = (r102 >>> 18) & 3;
        this.f21216b = r103;
        View r104 = g.a(r101);
        this.f21219e = r104;
        this.f21224j = r104.getWidth();
        int r105 = this.f21219e.getHeight();
        this.f21215a = r105;
        int r106 = this.f21224j;
        float r107 = 0.0f;
        if (r106 == 0) goto L5;
        float r108 = 1.0f / r106;
    L6:
        this.f21225k = r108;
        if (r105 == 0) goto L9;
        r107 = 1.0f / r105;
    L9:
        this.f21226l = r107;
        return;
    L5:
        r108 = 0.0f;
        goto L6
    }
}
