package com.bytedance.android.shopping.mall.homepage.card;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f177559a;

    public d(c r100) {
        this.f177559a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        boolean r103 = false;
        if (r102 != 0) goto L5;
        c r104 = this.f177559a;
        r104.f177418a.removeCallbacks(r104.f177419b);
        r104.f177420c = false;
        Handler r105 = r104.f177418a;
        c.b r106 = r104.f177419b;
        Object r107 = r104.f177426i.get("long_click_effect_time");
        if ((r107 instanceof Integer) == true) goto L18;
        r107 = null;
    L18:
        Integer r108 = (Integer) r107;
        if (r108 == null) goto L21;
        int r109 = r108.intValue();
    L22:
        r105.postDelayed(r106, r109);
        this.f177559a.f177422e = r101.getRawX();
        this.f177559a.f177423f = r101.getRawY();
    L24:
        return this.f177559a.f177420c;
    L21:
        r109 = ViewConfiguration.getLongPressTimeout();
        goto L22
    L5:
        if (r102 != 1) goto L7;
        c r110 = this.f177559a;
        r110.f177418a.removeCallbacks(r110.f177419b);
        goto L24
    L7:
        if (r102 == 2) goto L9;
        c r111 = this.f177559a;
        r111.f177418a.removeCallbacks(r111.f177419b);
        goto L24
    L9:
        c r112 = this.f177559a;
        float r113 = r101.getRawX();
        float r114 = r101.getRawY();
        float r115 = Math.abs(r113 - r112.f177422e);
        float r116 = Math.abs(r114 - r112.f177423f);
        if (((r115 * r115) + (r116 * r116)) <= (r112.f177421d.getScaledTouchSlop() * r112.f177421d.getScaledTouchSlop())) goto L12;
        r103 = true;
    L12:
        if (r103 == false) goto L24;
        c r117 = this.f177559a;
        r117.f177418a.removeCallbacks(r117.f177419b);
        goto L24
    }
}
