package com.bytedance.android.shopping.card_list.utils;

import android.view.View;
import com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HalfPanelHelper f171923a;

    public j(HalfPanelHelper r100) {
        this.f171923a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        HalfPanelHelper r109 = this.f171923a;
        CardListRootFrameLayoutContainer r110 = r109.f171890d;
        if (r110 == null) goto L6;
        r110.setTranslationY(r109.c());
        return;
    }
}
