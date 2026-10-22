package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.view.View;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder f84715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShelfCardInfo f84716b;

    public g(ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder r100, ShelfCardInfo r101) {
        this.f84715a = r100;
        this.f84716b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ShelfManagementCardListAdapter.a r101 = this.f84715a.f84650l.f84630a;
        if (r101 == null) goto L6;
        r101.a(this.f84716b);
        return;
    }
}
