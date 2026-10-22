package com.bytedance.android.live.recharge;

import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;

/* JADX INFO: loaded from: classes47.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomRechargeDialogFragment f89684a;

    public d(CustomRechargeDialogFragment r100) {
        this.f89684a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        CustomRechargeDialogFragment r101 = this.f89684a;
        int r102 = CustomRechargeDialogFragment.G;
        r101.W90((List) r100);
    }
}
