package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f145537a;

    public o(long r100) {
        this.f145537a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        pd2.d r101 = pd2.d.f528658n;
        LinkMonitorData r102 = LinkMonitorData.ApiAddSongStatusForRebroadcast;
        long r103 = System.currentTimeMillis() - this.f145537a;
        mb0.c.a.a(r101, r102, r103, (Throwable) r100);
    }
}
