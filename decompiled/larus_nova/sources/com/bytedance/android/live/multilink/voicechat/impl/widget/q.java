package com.bytedance.android.live.multilink.voicechat.impl.widget;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ye0.a f83759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f83760b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f83761c;

    public q(ye0.a r100, long r101) {
        this.f83759a = r100;
        this.f83760b = 1;
        this.f83761c = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f83759a.onSuccess();
        TalkRoomBusinessFullLinkMonitor r101 = TalkRoomBusinessFullLinkMonitor.f71456a;
        int r102 = this.f83760b;
        long r103 = this.f83761c;
        String r104 = ((com.bytedance.android.live.network.response.a) r100).logId;
        r101.getClass();
        TalkRoomBusinessFullLinkMonitor.c(r102, r103, null, r104);
    }
}
