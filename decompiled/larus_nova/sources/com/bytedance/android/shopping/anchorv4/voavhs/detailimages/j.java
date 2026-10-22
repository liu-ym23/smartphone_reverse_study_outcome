package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import android.view.MotionEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f168323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f168324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f168325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f168326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f168327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ AnchorV4DetailLargeImageVH f168328f;

    public j(AnchorV4DetailLargeImageVH r100) {
        this.f168328f = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101 == null) goto L43;
        this.f168328f.f168290b.getParent().requestDisallowInterceptTouchEvent(true);
        o r102 = this.f168328f.f168290b.getMDetector();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r102.f168329a == true) goto L15;
        Intrinsics.checkNotNullParameter(r101, "event");
        int r103 = r101.getAction() & 255;
        if (r103 == 0) goto L11;
        if (r103 != 2) goto L27;
        r102.f168334f.b(r102);
        r102.f168329a = true;
    L27:
        int r104 = r101.getAction();
        if (r104 == 0) goto L42;
        if (r104 == 1) goto L34;
        if (r104 != 2) goto L43;
        this.f168326d += Math.abs(r101.getX() - this.f168324b);
        this.f168327e += Math.abs(r101.getY() - this.f168325c);
        this.f168324b = r101.getX();
        this.f168325c = r101.getY();
        goto L43
    L34:
        if ((System.currentTimeMillis() - this.f168323a) >= 150) goto L43;
        float r105 = 20;
        if (this.f168326d >= r105) goto L38;
    L39:
        n r106 = this.f168328f.f168289a;
        if (r106 == null) goto L43;
        r106.c();
        goto L43
    L38:
        if (this.f168327e >= r105) goto L43;
    L42:
        this.f168324b = r101.getX();
        this.f168325c = r101.getY();
        this.f168326d = 0.0f;
        this.f168327e = 0.0f;
        this.f168323a = System.currentTimeMillis();
        goto L43
    L11:
        MotionEvent r107 = r102.f168330b;
        if (r107 == null) goto L14;
        r107.recycle();
    L14:
        r102.f168330b = null;
        r102.f168329a = false;
        r102.f168330b = MotionEvent.obtain(r101);
        r102.b(r101);
        goto L27
    L15:
        Intrinsics.checkNotNullParameter(r101, "event");
        int r108 = r101.getAction() & 255;
        if (r108 == 1) goto L23;
        if (r108 != 2) goto L27;
        r102.b(r101);
        r102.f168334f.a(r102);
        MotionEvent r109 = r102.f168330b;
        if (r109 == null) goto L22;
        r109.recycle();
    L22:
        r102.f168330b = MotionEvent.obtain(r101);
        goto L27
    L23:
        r102.f168334f.c(r102);
        MotionEvent r110 = r102.f168330b;
        if (r110 == null) goto L26;
        r110.recycle();
    L26:
        r102.f168330b = null;
        r102.f168329a = false;
    L43:
        return true;
    }
}
