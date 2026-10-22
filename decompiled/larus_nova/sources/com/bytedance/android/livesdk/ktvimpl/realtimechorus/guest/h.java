package com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes10.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ye0.a f146647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f146648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f146649c;

    public h(ye0.a r100, long r101) {
        this.f146647a = r100;
        this.f146648b = 1;
        this.f146649c = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f146647a.onSuccess();
        TalkRoomBusinessFullLinkMonitor r101 = TalkRoomBusinessFullLinkMonitor.f71456a;
        int r102 = this.f146648b;
        long r103 = this.f146649c;
        String r104 = ((com.bytedance.android.live.network.response.a) r100).logId;
        r101.getClass();
        TalkRoomBusinessFullLinkMonitor.c(r102, r103, null, r104);
    }
}
