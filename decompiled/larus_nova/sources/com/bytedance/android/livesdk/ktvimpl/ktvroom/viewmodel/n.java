package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f145536a;

    public n(long r100) {
        this.f145536a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        mb0.c.a.b(pd2.d.f528658n, LinkMonitorData.ApiAddSongStatusForRebroadcast, System.currentTimeMillis() - this.f145536a, ((com.bytedance.android.live.network.response.a) r100).logId);
    }
}
