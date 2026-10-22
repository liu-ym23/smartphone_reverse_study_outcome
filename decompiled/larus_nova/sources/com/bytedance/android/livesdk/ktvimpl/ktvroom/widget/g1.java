package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class g1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ye0.a f145798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f145799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f145800c;

    public g1(ye0.a r100, long r101) {
        this.f145798a = r100;
        this.f145799b = 1;
        this.f145800c = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f145798a.onSuccess();
        TalkRoomBusinessFullLinkMonitor r101 = TalkRoomBusinessFullLinkMonitor.f71456a;
        int r102 = this.f145799b;
        long r103 = this.f145800c;
        TalkRoomBusinessFullLinkMonitor.d(r101, r102, r103, (com.bytedance.android.live.network.response.a) r100);
    }
}
