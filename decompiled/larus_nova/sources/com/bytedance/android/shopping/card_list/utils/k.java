package com.bytedance.android.shopping.card_list.utils;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes13.dex */
public final class k implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserver f171924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HalfPanelHelper f171925b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        com.bytedance.android.shopping.card_list.components.i r100 = (com.bytedance.android.shopping.card_list.components.i) this.f171925b.f171899m.getValue();
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.g());
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.intValue() > 0) goto L10;
        return;
    L10:
        if (this.f171924a.isAlive() == false) goto L12;
        this.f171924a.removeOnGlobalLayoutListener(this);
    L12:
        LinearLayout r102 = this.f171925b.f171891e;
        if (r102 == null) goto L20;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L21;
        r103.height = r101.intValue();
        return;
    L21:
        return;
    L20:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public k(ViewTreeObserver r100, HalfPanelHelper r101) {
        this.f171924a = r100;
        this.f171925b = r101;
    }
}
