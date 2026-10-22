package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceGameDetailInfoWidget f53739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a f53740b;

    public n(AudienceGameDetailInfoWidget r100, com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a r101) {
        this.f53739a = r100;
        this.f53740b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f53739a.f53526p == false) goto L5;
        com.bytedance.android.gamecp.host_api.a.b().getActionHandleService().handle(this.f53739a.context, this.f53740b.b());
        return;
    L5:
        com.bytedance.android.gamecp.host_api.a.b().getActionHandleService().handle(this.f53739a.context, this.f53740b.c());
    }
}
