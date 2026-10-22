package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.view;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AnchorShelfDisplayItemViewHolder f84548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a f84549b;

    public f(AnchorShelfDisplayItemViewHolder r100, com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.display.viewmodel.a r101) {
        this.f84548a = r100;
        this.f84549b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f84548a.f84522n.tW(this.f84549b);
    }
}
