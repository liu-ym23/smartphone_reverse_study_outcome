package com.bytedance.android.live.effect.common;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes45.dex */
public final class i implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCommonStickerAdjustBarView f67858a;

    public i(LiveCommonStickerAdjustBarView r100) {
        this.f67858a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f67858a.f67806b.clear();
    }
}
