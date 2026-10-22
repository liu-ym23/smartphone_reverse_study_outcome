package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class o implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceGameDetailInfoWidgetV2 f53743a;

    public o(AudienceGameDetailInfoWidgetV2 r100) {
        this.f53743a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        AudienceGameDetailInfoWidgetV2 r101 = this.f53743a;
        if (r101.G == true) goto L6;
        r101.Y.invoke();
        return;
    }
}
