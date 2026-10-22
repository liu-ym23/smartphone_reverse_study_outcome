package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes14.dex */
public final class q implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f188150a;

    public q(View r100) {
        this.f188150a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        View r100 = this.f188150a;
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }
}
