package com.bytedance.android.live.recharge;

import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomRechargeDialogFragment f89666a;

    public c(CustomRechargeDialogFragment r100) {
        this.f89666a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        CustomRechargeDialogFragment r101 = this.f89666a;
        r101.U90((com.bytedance.android.live.recharge.deal.d) r100, r101.D);
    }
}
