package com.bytedance.android.ecom.arch.slice.background;

import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f50039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f50040f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f50041g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f50042h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f50043i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f50044j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Path f50045k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f50046l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.ecom.arch.slice.render.widget.background.b f50047m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Path f50048n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f50049o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public RectF f50050p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float[] f50051q;

    public c() {
        this.f50040f = -1;
    }

    public final void a(int r100, int r101, int r102, int r103) {
        if (this.f50046l == true) goto L5;
        return;
    L5:
        if (this.f50039e == true) goto L7;
    L9:
        boolean r104 = false;
    L10:
        if (r104 == false) goto L12;
    L14:
        this.f50046l = false;
        RectF r105 = this.f50043i;
        if (r105 != null) goto L17;
        r105 = new RectF();
        this.f50043i = r105;
    L17:
        r105.set(r100, r101, r102, r103);
        Path r106 = this.f50045k;
        if (r106 != null) goto L20;
        r106 = new Path();
        this.f50045k = r106;
    L20:
        r106.reset();
        if (this.f50040f != 0) goto L23;
        float r107 = this.f50041g;
        r106.addRoundRect(r105, r107, r107, Path.Direction.CCW);
        return;
    L23:
        float r108 = this.f50035a;
        float r109 = this.f50037c;
        float r110 = this.f50038d;
        float r111 = this.f50036b;
        float[] r112 = this.f50044j;
        if (r112 != null) goto L26;
        r112 = new float[8];
        this.f50044j = r112;
    L26:
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
        if (this.f50047m != null) goto L14;
        return;
    L7:
        if (this.f50042h == true) goto L9;
        r104 = true;
        goto L10
    }
}
