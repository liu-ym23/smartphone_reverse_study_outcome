package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f81952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.r f81953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f81954c;

    public h(d r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r101, long r102) {
        this.f81952a = r100;
        this.f81953b = r101;
        this.f81954c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f81952a.f81937d = false;
        TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r103 = this.f81953b;
        long r104 = r103.emojiId;
        int r105 = r103.emojiType;
        long r106 = this.f81954c;
        r102.getClass();
        TalkRoomBusinessFullLinkMonitor.t0(r104, r105, r106, r101);
        d.a r107 = (d.a) this.f81952a.f531633a;
        if (r107 == null) goto L6;
        r107.w6(r101);
        return;
    }
}
