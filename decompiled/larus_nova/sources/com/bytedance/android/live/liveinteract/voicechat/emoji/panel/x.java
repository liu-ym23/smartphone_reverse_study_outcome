package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class x<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f80257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f80258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f80259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f80260d;

    public x(s r100, int r101, int r102, long r103) {
        this.f80257a = r100;
        this.f80258b = r101;
        this.f80259c = r102;
        this.f80260d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
        int r103 = this.f80258b;
        int r104 = this.f80259c;
        long r105 = this.f80260d;
        r102.getClass();
        TalkRoomBusinessFullLinkMonitor.y(r103, 2, r104, r105, r101);
        s.a r106 = (s.a) this.f80257a.f531633a;
        if (r106 == null) goto L6;
        r106.j8(r101);
        return;
    }
}
