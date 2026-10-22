package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorShelfDisplayItemViewHolder f84546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a f84547b;

    public e(AnchorShelfDisplayItemViewHolder r100, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r101) {
        this.f84546a = r100;
        this.f84547b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f84546a.f84521m.l50(1, this.f84547b.getCardId());
    }
}
