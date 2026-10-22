package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class u implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceGameDetailInfoWidgetV3 f53751a;

    public u(AudienceGameDetailInfoWidgetV3 r100) {
        this.f53751a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AudienceGameDetailInfoWidgetV3 r101 = this.f53751a;
        if (r101.P0 == true) goto L6;
        r101.L1.invoke();
        return;
    }
}
