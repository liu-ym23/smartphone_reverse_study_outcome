package com.bytedance.applet.debug.view;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f191621a;

    public a0(x r100) {
        this.f191621a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r110, MotionEvent r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "motionEvent");
        int r112 = r111.getAction();
        if (r112 != 0) goto L5;
        x r113 = this.f191621a;
        r113.f191680t = true;
        r113.f191674n = r111.getRawX();
        this.f191621a.f191675o = r111.getRawY();
        this.f191621a.f191678r = System.currentTimeMillis();
        final x r114 = this.f191621a;
        r114.f191673m.postDelayed(new y(r114), r114.f191683w);
        final x r115 = this.f191621a;
        if (r115.f191681u == false) goto L48;
        r115.f191681u = false;
        r115.f191673m.postDelayed(new z(r115), r115.f191684x);
    L48:
        return false;
    L5:
        if (r112 == 1) goto L24;
        if (r112 != 2) goto L48;
        x r116 = this.f191621a;
        float r100 = r111.getRawX();
        float r101 = r111.getRawY();
        WindowManager.LayoutParams r102 = r116.f191669i;
        int r103 = r102.x;
        float r104 = r116.f191676p;
        if (r104 >= 0.0f) goto L11;
        int r105 = 0;
    L12:
        r102.x = r103 + r105;
        int r106 = r102.y;
        float r107 = r116.f191677q;
        if (r107 >= 0.0f) goto L15;
        int r108 = 0;
    L16:
        r102.y = r106 + r108;
        WindowManager r109 = r116.f191670j;
        if (r109 == null) goto L19;
        r109.updateViewLayout(r116.f191662b, r102);
    L19:
        this.f191621a.f191676p = r111.getRawX();
        this.f191621a.f191677q = r111.getRawY();
        x r117 = this.f191621a;
        float r118 = Math.abs(r117.f191674n - r117.f191676p);
        x r119 = this.f191621a;
        if (r118 <= r119.f191671k) goto L22;
    L23:
        this.f191621a.f191680t = false;
        goto L48
    L22:
        if (Math.abs(r119.f191675o - r119.f191677q) <= this.f191621a.f191671k) goto L48;
    L15:
        r108 = (int) (r101 - r107);
        goto L16
    L11:
        r105 = (int) (r100 - r104);
        goto L12
    L24:
        x r120 = this.f191621a;
        r120.f191680t = false;
        r120.f191676p = r111.getRawX();
        this.f191621a.f191677q = r111.getRawY();
        this.f191621a.f191679s = System.currentTimeMillis();
        x r121 = this.f191621a;
        float r122 = Math.abs(r121.f191674n - r121.f191676p);
        x r123 = this.f191621a;
        if (r122 >= r123.f191671k) goto L31;
        float r124 = Math.abs(r123.f191675o - r123.f191677q);
        x r125 = this.f191621a;
        if (r124 >= r125.f191671k) goto L31;
        if ((r125.f191679s - r125.f191678r) >= r125.f191685y) goto L31;
        r125.f191682v++;
    L31:
        final x r126 = this.f191621a;
        if (r126.f191672l == 0) goto L44;
        final int r127 = r126.f191669i.x;
        int r128 = r126.f191664d;
        int r129 = (r126.f191667g - r126.f191662b.getMeasuredWidth()) - r126.f191664d;
        if (r126.f191669i.x <= ((r126.f191667g - r126.f191662b.getMeasuredWidth()) / 2)) goto L36;
        final int r130 = r129;
    L37:
        final int r131 = r126.f191669i.y;
        int r132 = r126.f191665e;
        int r133 = ((r126.f191666f - r126.f191668h) - r126.f191662b.getMeasuredHeight()) - r126.f191665e;
        int r134 = r126.f191669i.y;
        if (r134 <= r133) goto L40;
        final int r135 = r133;
    L43:
        ValueAnimator r136 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r136.setDuration(300);
        r136.addUpdateListener(new w(r126, r127, r130, r131, r135));
        r136.setInterpolator(new AccelerateDecelerateInterpolator());
        r136.start();
        goto L44
    L40:
        if (r134 >= r132) goto L42;
        r135 = r132;
        goto L43
    L42:
        r135 = r134;
        goto L43
    L36:
        r130 = r128;
    L44:
        x r137 = this.f191621a;
        r137.f191676p = -1.0f;
        r137.f191677q = -1.0f;
        goto L48
    }
}
