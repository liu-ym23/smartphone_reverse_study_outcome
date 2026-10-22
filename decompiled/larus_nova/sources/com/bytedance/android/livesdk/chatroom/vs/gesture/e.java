package com.bytedance.android.livesdk.chatroom.vs.gesture;

import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import jc1.l;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f117713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f117714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f117715c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f117716d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f117717e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f117718f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f117719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f117720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f117721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f117722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f117723k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f117724l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f117725m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f117726n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f117727o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f117728p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f117729q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f117730r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f117731s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f117732t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ViewGroup f117733u;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        return true;
    }

    public final void a(float r100) {
        this.f117732t.setTranslationX(r100);
    }

    public final void b(float r100) {
        this.f117732t.setTranslationY(r100);
    }

    public final void c(float r100) {
        float r101 = 0;
        if (r100 >= r101) goto L7;
        if (Math.abs(this.f117714b + r100) >= this.f117725m) goto L7;
    L10:
        float r102 = this.f117714b + r100;
        this.f117714b = r102;
        a(r102);
        return;
    L7:
        if (r100 > r101) goto L9;
    L11:
        if (r100 >= r101) goto L15;
        float r103 = Math.abs(this.f117714b + r100);
        float r104 = this.f117725m;
        if (r103 <= r104) goto L15;
        this.f117714b = -r104;
        a(-r104);
        return;
    L15:
        if (r100 <= r101) goto L22;
        float r105 = this.f117714b + r100;
        float r106 = this.f117727o;
        if (r105 <= r106) goto L23;
        this.f117714b = r106;
        a(r106);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        if ((this.f117714b + r100) >= this.f117727o) goto L11;
        goto L10
    }

    public final void d(float r100) {
        float r101 = 0;
        if (r100 >= r101) goto L7;
        if (Math.abs(this.f117715c + r100) >= this.f117726n) goto L7;
    L10:
        float r102 = this.f117715c + r100;
        this.f117715c = r102;
        b(r102);
        return;
    L7:
        if (r100 > r101) goto L9;
    L11:
        if (r100 >= r101) goto L15;
        float r103 = Math.abs(this.f117715c + r100);
        float r104 = this.f117726n;
        if (r103 <= r104) goto L15;
        this.f117715c = -r104;
        b(-r104);
        return;
    L15:
        if (r100 <= r101) goto L22;
        float r105 = this.f117715c + r100;
        float r106 = this.f117728p;
        if (r105 <= r106) goto L23;
        this.f117715c = r106;
        b(r106);
        return;
    L23:
        return;
    L22:
        return;
    L9:
        if ((this.f117715c + r100) >= this.f117728p) goto L11;
        goto L10
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        if (this.f117720h == true) goto L5;
        this.f117720h = true;
        this.f117725m = this.f117732t.getLeft();
        this.f117726n = this.f117732t.getTop();
        this.f117727o = this.f117733u.getWidth() - this.f117732t.getRight();
        this.f117728p = this.f117733u.getHeight() - this.f117732t.getBottom();
        this.f117721i = this.f117732t.getWidth();
        int r101 = this.f117732t.getHeight();
        this.f117722j = r101;
        int r102 = this.f117721i;
        this.f117718f = r102;
        this.f117719g = r101;
        this.f117716d = r102;
        this.f117717e = r101;
        this.f117723k = this.f117733u.getWidth();
        this.f117724l = this.f117733u.getHeight();
    L5:
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        float r101 = 0.0f;
        if (this.f117716d <= this.f117723k) goto L5;
        float r102 = 0.0f;
    L7:
        if (this.f117717e > this.f117724l) goto L10;
        r101 = this.f117732t.getTop() - ((this.f117717e - this.f117722j) / 2);
    L10:
        float r103 = this.f117716d;
        int r104 = this.f117723k;
        if (r103 <= r104) goto L13;
        float r105 = r104;
    L14:
        float r106 = this.f117717e;
        int r107 = this.f117724l;
        if (r106 <= r107) goto L17;
        float r108 = r107;
    L19:
        if (new RectF(r102, r101, r105, r108).contains(r100.getX(), r100.getY()) == false) goto L22;
        this.f117732t.performClick();
    L22:
        return super.onSingleTapUp(r100);
    L17:
        r108 = this.f117733u.getHeight() - ((this.f117733u.getHeight() - this.f117732t.getBottom()) - ((this.f117717e - this.f117722j) / 2));
        goto L19
    L13:
        r105 = this.f117733u.getWidth() - ((this.f117733u.getWidth() - this.f117732t.getRight()) - ((this.f117716d - this.f117721i) / 2));
        goto L14
    L5:
        r102 = this.f117732t.getLeft() - ((this.f117716d - this.f117721i) / 2);
        goto L7
    }

    public e(View r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "targetView");
        Intrinsics.checkNotNullParameter(r101, "viewGroup");
        this.f117732t = r100;
        this.f117733u = r101;
        this.f117713a = 1.0f;
        this.f117730r = 1.0f;
        this.f117731s = 1.0f;
    }

    @Override // jc1.l, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r101, "e2");
        float r104 = -r102;
        float r105 = -r103;
        if (this.f117729q == true) goto L9;
        if (this.f117713a > 1) goto L9;
        c(r104);
        d(r105);
    L15:
        return super.onScroll(r100, r101, r104, r105);
    L9:
        if (this.f117716d <= this.f117723k) goto L12;
        c(r104);
    L12:
        if (this.f117717e <= this.f117724l) goto L15;
        d(r105);
        goto L15
    }
}
