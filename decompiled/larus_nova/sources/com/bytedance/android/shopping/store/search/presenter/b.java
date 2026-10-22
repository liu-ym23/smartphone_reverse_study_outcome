package com.bytedance.android.shopping.store.search.presenter;

import android.view.ViewTreeObserver;
import com.bytedance.android.ec.store.search.history.HistoryChip;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HistoryChip.WrapCard f186072a;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int r100 = this.f186072a.getHeight();
        if (r100 <= 0) goto L6;
        this.f186072a.setRadius(r100 / 2.0f);
        this.f186072a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        return;
    }

    public b(HistoryChip.WrapCard r100) {
        this.f186072a = r100;
    }
}
