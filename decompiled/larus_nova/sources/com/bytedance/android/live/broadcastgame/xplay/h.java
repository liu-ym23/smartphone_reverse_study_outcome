package com.bytedance.android.live.broadcastgame.xplay;

import android.view.View;

/* JADX INFO: loaded from: classes45.dex */
public final class h implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OPMoreDialogAdapter f62168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f62169b;

    public h(OPMoreDialogAdapter r100, i r101) {
        this.f62168a = r100;
        this.f62169b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        i r101 = this.f62169b;
        r101.f62175d.a(this.f62168a.f61856a, r100, r101);
    }
}
