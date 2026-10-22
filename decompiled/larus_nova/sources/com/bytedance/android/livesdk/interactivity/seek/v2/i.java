package com.bytedance.android.livesdk.interactivity.seek.v2;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.ss.ugc.live.sdk.msg.network.e f140836a;

    public i(lmc.a.f r100) {
        this.f140836a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.ss.ugc.live.sdk.msg.network.e r101 = this.f140836a;
        int r102 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        r101.a(com.ss.ugc.live.sdk.msg.utils.g.a.a(new Exception((Throwable) r100)));
    }
}
