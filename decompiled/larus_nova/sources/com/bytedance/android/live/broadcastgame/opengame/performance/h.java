package com.bytedance.android.live.broadcastgame.opengame.performance;

import io.reactivex.functions.Consumer;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes45.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f60739a;

    public h(c r100) {
        this.f60739a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        c r102 = this.f60739a;
        r102.f60729d = new JSONArray();
    }
}
