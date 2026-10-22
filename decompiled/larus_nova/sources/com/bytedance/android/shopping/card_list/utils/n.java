package com.bytedance.android.shopping.card_list.utils;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class n implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfPanelHelper f171928a;

    public n(HalfPanelHelper r100) {
        this.f171928a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r100.getVisibility() == 0) goto L7;
        return false;
    L7:
        if (this.f171928a.f171902p.onTouchEvent(r101) == true) goto L19;
        HalfPanelHelper r102 = this.f171928a;
        r102.getClass();
        int r103 = r101.getAction();
        if (r103 == 0) goto L18;
        if (r103 != 1) goto L19;
        int r104 = ((int) r101.getRawY()) - r102.f171887a;
        if (r104 <= (r102.f171904r.f171547g.x20() / 2)) goto L16;
        r102.f171904r.a();
        goto L19
    L16:
        if (r104 <= r102.f171898l) goto L19;
        r102.e();
        goto L19
    L18:
        r102.f171887a = (int) r101.getRawY();
    L19:
        return true;
    }
}
