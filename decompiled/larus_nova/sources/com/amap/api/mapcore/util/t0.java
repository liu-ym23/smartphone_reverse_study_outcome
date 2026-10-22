package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes28.dex */
public class t0 extends q0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final PointF f27978y = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final a f27979s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f27980t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private PointF f27981u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private PointF f27982v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private PointF f27983w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private PointF f27984x;

    public interface a {
        boolean a(t0 r100);

        void b(t0 r100);

        boolean c(t0 r100);
    }

    static {
        f27978y = new PointF();
    }

    @Override // com.amap.api.mapcore.util.r0
    public void c() {
        super.c();
        this.f27980t = false;
    }

    public PointF d() {
        return this.f27984x;
    }

    @Override // com.amap.api.mapcore.util.q0, com.amap.api.mapcore.util.r0
    public void b(MotionEvent r100) {
        super.b(r100);
        MotionEvent r101 = this.f27913c;
        this.f27981u = r0.a(r100);
        this.f27982v = r0.a(r101);
        if (this.f27913c.getPointerCount() == r100.getPointerCount()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        PointF r103 = f27978y;
    L9:
        this.f27984x = r103;
        PointF r104 = this.f27983w;
        r104.x += r103.x;
        r104.y += r103.y;
        return;
    L8:
        PointF r105 = this.f27981u;
        float r106 = r105.x;
        PointF r107 = this.f27982v;
        r103 = new PointF(r106 - r107.x, r105.y - r107.y);
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    public t0(Context r100, a r101) {
        super(r100);
        this.f27983w = new PointF();
        this.f27984x = new PointF();
        this.f27979s = r101;
    }

    @Override // com.amap.api.mapcore.util.r0
    public void a(int r100, MotionEvent r101) {
        if (r100 != 2) goto L5;
        b(r101);
        if ((this.f27915e / this.f27916f) > 0.67f) goto L20;
        return;
    L20:
        if (this.f27979s.a(this) == false) goto L26;
        this.f27913c.recycle();
        this.f27913c = MotionEvent.obtain(r101);
        return;
    L26:
        return;
    L5:
        if (r100 == 3) goto L14;
        if (r100 != 6) goto L27;
        b(r101);
        if (this.f27980t == true) goto L12;
        this.f27979s.b(this);
    L12:
        c();
        return;
    L27:
        return;
    L14:
        if (this.f27980t == true) goto L16;
        this.f27979s.b(this);
    L16:
        c();
    }

    @Override // com.amap.api.mapcore.util.r0
    public void a(int r100, MotionEvent r101, int r102, int r103) {
        if (r100 == 2) goto L11;
        if (r100 != 5) goto L20;
        c();
        this.f27913c = MotionEvent.obtain(r101);
        this.f27917g = 0;
        b(r101);
        boolean r104 = c(r101);
        this.f27980t = r104;
        if (r104 == true) goto L17;
        this.f27912b = this.f27979s.c(this);
        return;
    L17:
        return;
    L20:
        return;
    L11:
        if (this.f27980t == false) goto L21;
        boolean r105 = c(r101);
        this.f27980t = r105;
        if (r105 == true) goto L19;
        this.f27912b = this.f27979s.c(this);
        return;
    L19:
        return;
    }
}
