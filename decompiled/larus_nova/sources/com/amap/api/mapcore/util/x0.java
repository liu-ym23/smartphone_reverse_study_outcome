package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes28.dex */
public class x0 extends q0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final PointF f28320y = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final a f28321s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f28322t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private PointF f28323u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private PointF f28324v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private PointF f28325w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private PointF f28326x;

    public interface a {
        void a(x0 r100);
    }

    public static class b implements a {
        @Override // com.amap.api.mapcore.util.x0.a
        public void a(x0 r100) {
        }

        public b() {
        }
    }

    static {
        f28320y = new PointF();
    }

    public float d() {
        return this.f28325w.x;
    }

    public float e() {
        return this.f28325w.y;
    }

    @Override // com.amap.api.mapcore.util.r0
    public void c() {
        super.c();
        this.f28322t = false;
        PointF r100 = this.f28325w;
        r100.x = 0.0f;
        PointF r101 = this.f28326x;
        r101.x = 0.0f;
        r100.y = 0.0f;
        r101.y = 0.0f;
    }

    @Override // com.amap.api.mapcore.util.q0, com.amap.api.mapcore.util.r0
    public void b(MotionEvent r100) {
        super.b(r100);
        MotionEvent r101 = this.f27913c;
        this.f28323u = r0.a(r100);
        this.f28324v = r0.a(r101);
        if (this.f27913c.getPointerCount() == r100.getPointerCount()) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        PointF r103 = f28320y;
    L9:
        this.f28326x = r103;
        PointF r104 = this.f28325w;
        r104.x += r103.x;
        r104.y += r103.y;
        return;
    L8:
        PointF r105 = this.f28323u;
        float r106 = r105.x;
        PointF r107 = this.f28324v;
        r103 = new PointF(r106 - r107.x, r105.y - r107.y);
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    public x0(Context r100, a r101) {
        super(r100);
        this.f28325w = new PointF();
        this.f28326x = new PointF();
        this.f28321s = r101;
    }

    @Override // com.amap.api.mapcore.util.r0
    public void a(int r100, MotionEvent r101) {
        if (r100 != 3) goto L5;
        c();
        return;
    L5:
        if (r100 != 6) goto L14;
        b(r101);
        if (this.f28322t == true) goto L10;
        this.f28321s.a(this);
    L10:
        c();
        return;
    }

    @Override // com.amap.api.mapcore.util.r0
    public void a(int r100, MotionEvent r101, int r102, int r103) {
        if (r100 != 5) goto L10;
        c();
        this.f27913c = MotionEvent.obtain(r101);
        this.f27917g = 0;
        b(r101);
        boolean r104 = c(r101);
        this.f28322t = r104;
        if (r104 == true) goto L9;
        this.f28321s.getClass();
        this.f27912b = true;
        return;
    L9:
        return;
    }
}
