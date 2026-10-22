package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickRechargeView;

/* JADX INFO: loaded from: classes9.dex */
public final class o0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftMVIRechargeView f127960a;

    public o0(GiftMVIRechargeView r100) {
        this.f127960a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f127960a.o(new ClickRechargeView());
    }
}
