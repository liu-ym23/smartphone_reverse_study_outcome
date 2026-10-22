package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import android.view.View;

/* JADX INFO: loaded from: classes9.dex */
public final class h0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterestSectionProvider.InterestPanelController f135886a;

    public h0(InterestSectionProvider.InterestPanelController r100) {
        this.f135886a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f135886a.i();
        com.bytedance.android.livesdk.interactivity.comment.utils.i.a(null, false, false);
    }
}
