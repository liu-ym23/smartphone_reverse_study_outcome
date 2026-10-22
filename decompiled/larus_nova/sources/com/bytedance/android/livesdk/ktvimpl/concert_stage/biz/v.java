package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import android.view.View;

/* JADX INFO: loaded from: classes10.dex */
public final class v extends b7.a {
    public v() {
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        w.b("ConcertStageHybridManager", "loadLynxView success");
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        w.b("ConcertStageHybridManager", "loadLynxView onLoadFail");
    }
}
