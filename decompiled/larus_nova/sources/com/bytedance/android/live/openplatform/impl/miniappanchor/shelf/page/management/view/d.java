package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder f84709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f84710b;

    public d(ShelfManagementCardListAdapter.ShelfManagementCardItemViewHolder r100, int r101) {
        this.f84709a = r100;
        this.f84710b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f84709a.f84639a.isChecked() == false) goto L7;
        ShelfManagementCardListAdapter r101 = this.f84709a.f84650l;
        Boolean[] r102 = r101.f84636g;
        int r103 = this.f84710b;
        r102[r103] = Boolean.TRUE;
        ShelfManagementCardListAdapter.c r104 = r101.f84631b;
        if (r104 == null) goto L11;
        r104.a(r103);
        return;
    L11:
        return;
    L7:
        ShelfManagementCardListAdapter r105 = this.f84709a.f84650l;
        Boolean[] r106 = r105.f84636g;
        int r107 = this.f84710b;
        r106[r107] = Boolean.FALSE;
        ShelfManagementCardListAdapter.c r108 = r105.f84631b;
        if (r108 == null) goto L13;
        r108.b(r107);
        return;
    }
}
