package com.bytedance.android.live.livepkaudience.dialog;

import android.view.View;

/* JADX INFO: loaded from: classes46.dex */
public final class x implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PkWithAudienceFeedbackDialog f81854a;

    public x(PkWithAudienceFeedbackDialog r100) {
        this.f81854a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        PkWithAudienceFeedbackDialog r101 = this.f81854a;
        int r102 = PkWithAudienceFeedbackDialog.f81743m;
        r101.initData();
    }
}
