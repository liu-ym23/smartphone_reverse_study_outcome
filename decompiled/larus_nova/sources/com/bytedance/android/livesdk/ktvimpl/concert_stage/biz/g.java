package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f143740a = null;

    static {
        f143740a = new g();
    }

    public g() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        w.b("ConcertStageComponent", "leaveChorus success");
    }
}
