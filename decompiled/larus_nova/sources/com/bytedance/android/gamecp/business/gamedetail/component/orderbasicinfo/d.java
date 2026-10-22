package com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo;

import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrderGameDetailInfoItemWidget f54775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.C0891a f54776b;

    public d(OrderGameDetailInfoItemWidget r100, a.C0891a r101) {
        this.f54775a = r100;
        this.f54776b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f54775a.f54726u == false) goto L5;
        com.bytedance.android.gamecp.host_api.a.b().getActionHandleService().handle(this.f54775a.context, this.f54776b.b());
        return;
    L5:
        com.bytedance.android.gamecp.host_api.a.b().getActionHandleService().handle(this.f54775a.context, this.f54776b.c());
    }
}
