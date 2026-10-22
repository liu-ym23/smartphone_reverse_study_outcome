package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes28.dex */
public class u0 extends r0 {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final PointF f28031q = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final a f28032l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private PointF f28033m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private PointF f28034n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private PointF f28035o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private PointF f28036p;

    public interface a {
        boolean a(u0 r100);

        boolean b(u0 r100);

        void c(u0 r100);
    }

    static {
        f28031q = new PointF();
    }

    public PointF d() {
        return this.f28036p;
    }

    @Override // com.amap.api.mapcore.util.r0
    public void b(MotionEvent r100) {
        super.b(r100);
        MotionEvent r101 = this.f27913c;
        this.f28033m = r0.a(r100);
        this.f28034n = r0.a(r101);
        if (this.f27913c.getPointerCount() == r100.getPointerCount()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        PointF r103 = f28031q;
    L9:
        this.f28036p = r103;
        if (r102 == false) goto L12;
        this.f27913c.recycle();
        this.f27913c = MotionEvent.obtain(r100);
    L12:
        PointF r104 = this.f28035o;
        float r105 = r104.x;
        PointF r106 = this.f28036p;
        r104.x = r105 + r106.x;
        r104.y += r106.y;
        return;
    L8:
        PointF r107 = this.f28033m;
        float r108 = r107.x;
        PointF r109 = this.f28034n;
        r103 = new PointF(r108 - r109.x, r107.y - r109.y);
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    public u0(Context r100, a r101) {
        super(r100);
        this.f28035o = new PointF();
        this.f28036p = new PointF();
        this.f28032l = r101;
    }

    @Override // com.amap.api.mapcore.util.r0
    public void a(int r100, MotionEvent r101) {
        if (r100 != 1) goto L5;
    L17:
        this.f28032l.c(this);
        c();
        return;
    L5:
        if (r100 != 2) goto L7;
        b(r101);
        if ((this.f27915e / this.f27916f) > 0.67f) goto L12;
        return;
    L12:
        if (r101.getPointerCount() <= 1) goto L15;
        return;
    L15:
        if (this.f28032l.b(this) == false) goto L20;
        this.f27913c.recycle();
        this.f27913c = MotionEvent.obtain(r101);
        return;
    L20:
        return;
    L7:
        if (r100 == 3) goto L17;
    }

    @Override // com.amap.api.mapcore.util.r0
    public void a(int r100, MotionEvent r101, int r102, int r103) {
        if (r100 != 0) goto L4;
        c();
        this.f27913c = MotionEvent.obtain(r101);
        this.f27917g = 0;
        b(r101);
        return;
    L4:
        if (r100 != 2) goto L6;
        this.f27912b = this.f28032l.a(this);
        return;
    L6:
        if (r100 != 5) goto L17;
        MotionEvent r104 = this.f27913c;
        if (r104 == null) goto L11;
        r104.recycle();
    L11:
        this.f27913c = MotionEvent.obtain(r101);
        b(r101);
        return;
    }
}
