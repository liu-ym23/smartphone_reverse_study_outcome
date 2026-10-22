package com.bytedance.android.live.recharge.adapter;

import android.view.View;
import com.bytedance.android.live.recharge.platform.business.viewholder.AbsRechargeViewHolder;
import com.bytedance.android.live.recharge.platform.business.viewholder.RechargeItem;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RechargePagerAdapter.RechargeItemAdapter f89636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RechargeItem f89637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbsRechargeViewHolder f89638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f89639d;

    public a(RechargePagerAdapter.RechargeItemAdapter r100, RechargeItem r101, AbsRechargeViewHolder r102, int r103) {
        this.f89636a = r100;
        this.f89637b = r101;
        this.f89638c = r102;
        this.f89639d = r103;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        RechargeItem r101 = this.f89637b;
        if ((r101 instanceof RechargeItem.CustomItem) == false) goto L6;
        this.f89636a.f89634b.f89632g.F7(r101);
        return;
    L6:
        if ((r101 instanceof RechargeItem.a) == true) goto L8;
        return;
    L8:
        if (this.f89638c.itemView.isSelected() == false) goto L10;
        return;
    L10:
        RechargePagerAdapter.f(this.f89636a.f89634b, this.f89638c, false, this.f89639d);
    }
}
