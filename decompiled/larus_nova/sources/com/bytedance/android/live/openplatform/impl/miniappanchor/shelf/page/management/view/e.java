package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.view.View;
import com.bytedance.android.live.openplatform.api.model.shelf.ShelfCardInfo;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder f84711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ShelfCardInfo f84712b;

    public e(ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder r100, ShelfCardInfo r101) {
        this.f84711a = r100;
        this.f84712b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ShelfManagementCardListAdapter.OnItemClickListener r101 = this.f84711a.f84650l.f84633d;
        if (r101 == null) goto L6;
        r101.a(this.f84712b, ShelfManagementCardListAdapter.OnItemClickListener.ClickPosition.Cover);
        return;
    }
}
