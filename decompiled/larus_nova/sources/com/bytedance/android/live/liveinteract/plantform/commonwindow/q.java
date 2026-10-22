package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.chatroom.model.interact.t0;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class q<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f75856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f75857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f75858c;

    public q(s r100, long r101, long r102) {
        this.f75856a = r100;
        this.f75857b = r101;
        this.f75858c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        com.bytedance.android.live.network.response.e r111 = (com.bytedance.android.live.network.response.e) r110;
        this.f75856a.f75863b = false;
        t0 r100 = (t0) r111.data;
        TalkRoomBusinessFullLinkMonitor r101 = TalkRoomBusinessFullLinkMonitor.f71456a;
        long r102 = this.f75857b;
        long r103 = this.f75858c;
        String r112 = r111.logId;
        r101.getClass();
        TalkRoomBusinessFullLinkMonitor.E0(r102, r103, r112);
        x.N(true, this.f75857b, System.currentTimeMillis() - this.f75858c, null);
    }
}
