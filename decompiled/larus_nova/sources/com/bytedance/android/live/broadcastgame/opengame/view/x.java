package com.bytedance.android.live.broadcastgame.opengame.view;

import android.view.View;
import com.bytedance.android.live.broadcastgame.opengame.message.m0;
import com.bytedance.android.live.core.gift.IGiftCoreService;

/* JADX INFO: loaded from: classes45.dex */
public final class x implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RewardItemViewHolder f61331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m0 f61332b;

    public x(RewardItemViewHolder r100, m0 r101) {
        this.f61331a = r100;
        this.f61332b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((IGiftCoreService) jc1.k.n(IGiftCoreService.class)).openGiftDialog(5, this.f61332b.f60254d, "0", null, null);
        this.f61331a.f61260c.invoke();
    }
}
