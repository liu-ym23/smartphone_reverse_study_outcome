package com.bytedance.android.shopping.store.home.view;

import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class r implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECStoreXzgLevelView f184742a;

    public r(ECStoreXzgLevelView r100) {
        this.f184742a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        if (this.f184742a.getWidth() >= this.f184742a.f184607a.getMeasuredWidth()) goto L6;
        this.f184742a.f184607a.setVisibility(8);
        return;
    }
}
