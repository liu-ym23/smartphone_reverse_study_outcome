package com.bytedance.android.livesdk.commerce;

import android.view.View;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveGoodsDialogFragment.f f119649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f119650b;

    public g(LiveGoodsDialogFragment.f r100, e r101) {
        this.f119649a = r100;
        this.f119650b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f119649a.f119534a.removeBanner(this.f119650b);
    }
}
