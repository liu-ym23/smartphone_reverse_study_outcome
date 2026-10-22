package com.bytedance.android.live.effect.common;

import android.view.View;

/* JADX INFO: loaded from: classes45.dex */
public final class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCommonStickerListView f67871a;

    public q(LiveCommonStickerListView r100) {
        this.f67871a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        LiveCommonStickerDataViewModel r101 = LiveCommonStickerListView.S5(this.f67871a);
        if (r101 == null) goto L6;
        r101.fetchStickerList(this.f67871a.f67838f);
        return;
    }
}
