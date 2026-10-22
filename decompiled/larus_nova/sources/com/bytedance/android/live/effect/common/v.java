package com.bytedance.android.live.effect.common;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes45.dex */
public final class v implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCommonStickerListView f67876a;

    public v(LiveCommonStickerListView r100) {
        this.f67876a = r100;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f67876a.f67835c.clear();
    }
}
