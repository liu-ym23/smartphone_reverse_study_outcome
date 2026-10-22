package com.bytedance.android.shopping.new_cart.widgets;

import android.view.View;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardListCartLoadingView f179466a;

    public a(CardListCartLoadingView r100) {
        this.f179466a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f179466a.getViewAction().f179495b.invoke();
    }
}
