package com.bytedance.android.shopping.card_list.utils;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
public final class m implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfPanelHelper f171927a;

    public m(HalfPanelHelper r100) {
        this.f171927a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r100.getVisibility() == 0) goto L7;
        return false;
    L7:
        if (this.f171927a.f171902p.onTouchEvent(r101) == true) goto L32;
        HalfPanelHelper r102 = this.f171927a;
        r102.getClass();
        int r103 = r101.getAction();
        float r104 = 0.0f;
        if (r103 == 0) goto L28;
        if (r103 != 1) goto L12;
    L19:
        CardListRootFrameLayoutContainer r105 = r102.f171890d;
        if (r105 == null) goto L22;
        r104 = r105.getTranslationY();
    L22:
        float r106 = r102.c();
        float r107 = r102.f171898l;
        if (r104 <= (r107 + r106)) goto L26;
        r102.f171904r.a();
        goto L32
    L26:
        if (r104 >= (r106 - r107)) goto L32;
        r102.b();
        goto L32
    L12:
        if (r103 != 2) goto L14;
        float r108 = r102.f171888b - (r102.f171887a - ((int) r101.getRawY()));
        CardListRootFrameLayoutContainer r109 = r102.f171890d;
        if (r109 == null) goto L32;
        r109.setTranslationY(RangesKt.coerceAtLeast(r108, 0.0f));
        goto L32
    L14:
        if (r103 == 3) goto L19;
    L28:
        r102.f171887a = (int) r101.getRawY();
        CardListRootFrameLayoutContainer r110 = r102.f171890d;
        if (r110 == null) goto L31;
        r104 = r110.getTranslationY();
    L31:
        r102.f171888b = r104;
    L32:
        return true;
    }
}
