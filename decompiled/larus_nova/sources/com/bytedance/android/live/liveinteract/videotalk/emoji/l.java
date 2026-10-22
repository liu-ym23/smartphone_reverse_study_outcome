package com.bytedance.android.live.liveinteract.videotalk.emoji;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class l<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f79366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.j f79367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f79368c;

    public l(d r100, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r101, long r102) {
        this.f79366a = r100;
        this.f79367b = r101;
        this.f79368c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f79366a.f79347d = false;
        TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
        long r103 = this.f79367b.getEmojiId();
        int r104 = this.f79367b.getEmojiType();
        long r105 = this.f79368c;
        r102.getClass();
        TalkRoomBusinessFullLinkMonitor.t0(r103, r104, r105, r101);
        d.a r106 = (d.a) this.f79366a.f531633a;
        if (r106 == null) goto L6;
        r106.w6(r101);
        return;
    }
}
