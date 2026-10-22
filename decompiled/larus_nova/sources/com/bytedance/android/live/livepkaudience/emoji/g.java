package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f81949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.r f81950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f81951c;

    public g(d r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r101, long r102) {
        this.f81949a = r100;
        this.f81950b = r101;
        this.f81951c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.e r101 = (com.bytedance.android.live.network.response.e) r100;
        this.f81949a.f81937d = false;
        TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.r r103 = this.f81950b;
        long r104 = r103.emojiId;
        int r105 = r103.emojiType;
        long r106 = this.f81951c;
        String r107 = r101.logId;
        r102.getClass();
        TalkRoomBusinessFullLinkMonitor.u0(r104, r105, r106, r107);
        d.a r108 = (d.a) this.f81949a.f531633a;
        if (r108 == null) goto L6;
        r108.w2((com.bytedance.android.live.liveinteract.voicechat.model.a) r101.data);
        return;
    }
}
