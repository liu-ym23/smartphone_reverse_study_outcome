package com.bytedance.android.shopping.store.home.presenter;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes14.dex */
public final class i implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECShopAutoCollapsePresenter f184189a;

    public i(ECShopAutoCollapsePresenter r100) {
        this.f184189a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        this.f184189a.B = true;
        return false;
    }
}
