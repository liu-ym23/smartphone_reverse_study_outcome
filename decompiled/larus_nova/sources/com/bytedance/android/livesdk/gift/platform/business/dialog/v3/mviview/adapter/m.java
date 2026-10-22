package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickDIYCard;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f127859a;

    public m(n r100) {
        this.f127859a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        n r101 = this.f127859a;
        r101.o(new ClickDIYCard(r101.p()));
    }
}
