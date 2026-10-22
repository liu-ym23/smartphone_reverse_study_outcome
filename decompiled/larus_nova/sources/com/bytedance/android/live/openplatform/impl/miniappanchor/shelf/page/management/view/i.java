package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShelfManagementCardListAdapterV2.ShelfManagementCardItemViewHolder f84719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f84720b;

    public i(ShelfManagementCardListAdapterV2.ShelfManagementCardItemViewHolder r100, int r101) {
        this.f84719a = r100;
        this.f84720b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f84719a.f84661b.isChecked() == false) goto L7;
        ShelfManagementCardListAdapterV2.d r101 = this.f84719a.f84673n.f84652b;
        if (r101 == null) goto L11;
        r101.a(this.f84720b);
        return;
    L11:
        return;
    L7:
        ShelfManagementCardListAdapterV2.d r102 = this.f84719a.f84673n.f84652b;
        if (r102 == null) goto L13;
        r102.b(this.f84720b);
        return;
    }
}
