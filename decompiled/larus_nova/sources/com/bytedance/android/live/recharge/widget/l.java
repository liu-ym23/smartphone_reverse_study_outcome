package com.bytedance.android.live.recharge.widget;

import android.view.View;

/* JADX INFO: loaded from: classes47.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RechargeNoPasswordWidget f90767a;

    public l(RechargeNoPasswordWidget r100) {
        this.f90767a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RechargeNoPasswordWidget.Fq(this.f90767a, false);
    }
}
