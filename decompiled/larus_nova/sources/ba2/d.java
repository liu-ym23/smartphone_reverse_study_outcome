package ba2;

import android.view.MotionEvent;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f18388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f18389b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f18390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f18391d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f18392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f18393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f18394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f18395h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float[] f18396i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b<d> f18397j;

    public static final class a {
    }

    static {
    }

    public final void a() {
        b<d> r100 = this.f18397j;
        if (r100 == null) goto L5;
        r100.onGestureEnd(this);
    L5:
        int r101 = 0;
        this.f18388a = 0;
        this.f18389b = 0;
    L7:
        if (r101 >= 2) goto L9;
        this.f18390c[r101] = -1;
        this.f18391d[r101] = 0.0f;
        this.f18392e[r101] = 0.0f;
        this.f18393f[r101] = 0.0f;
        this.f18394g[r101] = 0.0f;
        this.f18395h[r101] = 0.0f;
        this.f18396i[r101] = 0.0f;
        r101 = r101 + 1;
        goto L7
    }

    public d() {
        this.f18390c = new int[2];
        this.f18391d = new float[2];
        this.f18392e = new float[2];
        this.f18393f = new float[2];
        this.f18394g = new float[2];
        this.f18395h = new float[2];
        this.f18396i = new float[2];
    }

    public final void b(MotionEvent r100) {
        r100.getAction();
        this.f18389b = this.f18388a;
        int r101 = 0;
        this.f18388a = 0;
    L4:
        if (r101 >= 2) goto L20;
        int r102 = r100.getPointerCount();
        int r103 = r100.getActionMasked();
        int r104 = r100.getActionIndex();
        if (r103 != 1) goto L8;
    L9:
        if (r101 < r104) goto L11;
        int r105 = r101 + 1;
    L13:
        if (r105 < r102) goto L16;
        r105 = -1;
    L16:
        if (r105 != (-1)) goto L18;
        this.f18390c[r101] = -1;
    L19:
        r101 = r101 + 1;
        goto L4
    L18:
        this.f18390c[r101] = r100.getPointerId(r105);
        this.f18395h[r101] = r100.getX(r105);
        float[] r106 = this.f18391d;
        float r107 = this.f18395h[r101];
        r106[r101] = r107;
        this.f18393f[r101] = r107;
        this.f18396i[r101] = r100.getY(r105);
        float[] r108 = this.f18392e;
        float r109 = this.f18396i[r101];
        r108[r101] = r109;
        this.f18394g[r101] = r109;
        this.f18388a++;
    L11:
        r105 = r101;
        goto L13
    L8:
        if (r103 != 6) goto L11;
    }
}
