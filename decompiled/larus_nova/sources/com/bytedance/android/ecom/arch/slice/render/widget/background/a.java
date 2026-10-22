package com.bytedance.android.ecom.arch.slice.render.widget.background;

import android.graphics.DashPathEffect;
import android.graphics.Path;
import android.graphics.RectF;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    public boolean A;
    public RectF B;
    public float[] C;
    public int D;
    public int E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50871d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f50872e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f50873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f50874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f50875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f50876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f50877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f50878k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public DashPathEffect f50879l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RectF f50880m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float[] f50881n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Path f50882o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f50883p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RectF f50884q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float[] f50885r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Path f50886s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f50887t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RectF f50888u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float[] f50889v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Path f50890w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f50891x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public b f50892y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Path f50893z;

    public final b a() {
        b r100 = this.f50892y;
        if (r100 != null) goto L6;
        b r101 = new b();
        this.f50892y = r101;
        return r101;
    L6:
        return r100;
    }

    public final Path b() {
        Path r100 = this.f50882o;
        if (r100 != null) goto L6;
        Path r101 = new Path();
        this.f50882o = r101;
        return r101;
    L6:
        return r100;
    }

    public a() {
        this.f50873f = -1;
        this.f50876i = true;
    }

    public final void c(int r100, int r101, int r110, int r111) {
        if (this.f50891x == false) goto L5;
    L9:
        this.D = r100;
        this.E = r101;
        this.f50891x = false;
        float r102 = this.f50877j;
        Path r103 = this.f50890w;
        if (r103 != null) goto L12;
        r103 = new Path();
        this.f50890w = r103;
    L12:
        r103.reset();
        RectF r104 = this.f50888u;
        if (r104 != null) goto L15;
        r104 = new RectF();
        this.f50888u = r104;
    L15:
        r104.set((r100 + 0) + r102, (r101 + 0) + r102, (r100 + r110) - r102, (r101 + r111) - r102);
        if (this.f50873f != 0) goto L18;
        float r105 = RangesKt.coerceAtLeast(this.f50874g - r102, 0.0f);
        r103.addRoundRect(r104, r105, r105, Path.Direction.CCW);
        return;
    L18:
        float r106 = this.f50868a;
        float r112 = this.f50870c;
        float r113 = this.f50871d;
        float r107 = this.f50869b;
        float[] r108 = this.f50889v;
        if (r108 != null) goto L21;
        r108 = new float[8];
        this.f50889v = r108;
    L21:
        float r109 = r106 - r102;
        r108[0] = RangesKt.coerceAtLeast(r109, 0.0f);
        r108[1] = RangesKt.coerceAtLeast(r109, 0.0f);
        float r114 = r112 - r102;
        r108[2] = RangesKt.coerceAtLeast(r114, 0.0f);
        r108[3] = RangesKt.coerceAtLeast(r114, 0.0f);
        float r115 = r113 - r102;
        r108[4] = RangesKt.coerceAtLeast(r115, 0.0f);
        r108[5] = RangesKt.coerceAtLeast(r115, 0.0f);
        float r116 = r107 - r102;
        r108[6] = RangesKt.coerceAtLeast(r116, 0.0f);
        r108[7] = RangesKt.coerceAtLeast(r116, 0.0f);
        r103.addRoundRect(r104, r108, Path.Direction.CCW);
        return;
    L5:
        if (this.D != r100) goto L9;
        if (this.E != r101) goto L9;
    }

    public final void d(int r100, int r101, int r102, int r103) {
        if (this.f50883p == true) goto L5;
        return;
    L5:
        if (this.f50872e == true) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L12;
    L14:
        this.f50883p = false;
        RectF r105 = this.f50880m;
        if (r105 != null) goto L17;
        r105 = new RectF();
        this.f50880m = r105;
    L17:
        r105.set(r100, r101, r102, r103);
        Path r106 = b();
        r106.reset();
        if (this.f50873f != 0) goto L20;
        float r107 = this.f50874g;
        r106.addRoundRect(r105, r107, r107, Path.Direction.CCW);
        return;
    L20:
        float r108 = this.f50868a;
        float r109 = this.f50870c;
        float r110 = this.f50871d;
        float r111 = this.f50869b;
        float[] r112 = this.f50881n;
        if (r112 != null) goto L23;
        r112 = new float[8];
        this.f50881n = r112;
    L23:
        r112[0] = r108;
        r112[1] = r108;
        r112[2] = r109;
        r112[3] = r109;
        r112[4] = r110;
        r112[5] = r110;
        r112[6] = r111;
        r112[7] = r111;
        r106.addRoundRect(r105, r112, Path.Direction.CCW);
        return;
    L12:
        if (this.f50892y != null) goto L14;
        return;
    L7:
        if (this.f50875h == true) goto L9;
        r104 = true;
        goto L10
    }
}
