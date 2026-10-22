package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes28.dex */
public abstract class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f27911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f27912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected MotionEvent f27913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected MotionEvent f27914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected float f27915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected float f27916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected long f27917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected int f27918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f27919i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f27920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f27921k;

    public abstract void a(int r100, MotionEvent r101);

    public abstract void a(int r100, MotionEvent r101, int r102, int r103);

    public void c() {
        MotionEvent r100 = this.f27913c;
        if (r100 == null) goto L5;
        r100.recycle();
        this.f27913c = null;
    L5:
        MotionEvent r101 = this.f27914d;
        if (r101 == null) goto L8;
        r101.recycle();
        this.f27914d = null;
    L8:
        this.f27912b = false;
    }

    public MotionEvent a() {
        return this.f27914d;
    }

    public long b() {
        return this.f27917g;
    }

    public r0(Context r100) {
        this.f27918h = 0;
        this.f27919i = 0;
        this.f27920j = 0;
        this.f27921k = 0;
        this.f27911a = r100;
    }

    public static PointF a(MotionEvent r100) {
        int r101 = r100.getPointerCount();
        float r102 = 0.0f;
        float r103 = 0.0f;
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        r103 = r103 + r100.getX(r104);
        r102 = r102 + r100.getY(r104);
        r104 = r104 + 1;
        goto L3
    L5:
        float r105 = r101;
        return new PointF(r103 / r105, r102 / r105);
    }

    public void b(MotionEvent r100) {
        MotionEvent r101 = this.f27913c;
        MotionEvent r102 = this.f27914d;
        if (r102 == null) goto L5;
        r102.recycle();
        this.f27914d = null;
    L5:
        this.f27914d = MotionEvent.obtain(r100);
        this.f27917g = r100.getEventTime() - r101.getEventTime();
        this.f27915e = r100.getPressure(r100.getActionIndex());
        this.f27916f = r101.getPressure(r101.getActionIndex());
    }

    public boolean a(MotionEvent r100, int r101, int r102) {
        int r103 = r100.getAction() & 255;
        if (this.f27912b == true) goto L5;
        a(r103, r100, r101, r102);
        return true;
    L5:
        a(r103, r100);
        return true;
    }

    public void a(int r100, int r101, int r102, int r103) {
        this.f27918h = r100;
        this.f27919i = r101;
        this.f27920j = r102;
        this.f27921k = r103;
    }
}
