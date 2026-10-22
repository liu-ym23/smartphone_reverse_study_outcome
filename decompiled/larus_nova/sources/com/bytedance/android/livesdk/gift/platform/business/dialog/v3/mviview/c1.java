package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickTopCloseBtn;

/* JADX INFO: loaded from: classes9.dex */
public final class c1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftMVITopView f127919a;

    public c1(GiftMVITopView r100) {
        this.f127919a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f127919a.o(new ClickTopCloseBtn());
    }
}
