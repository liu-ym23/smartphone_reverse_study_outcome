package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class r<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f81988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f81989b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f81990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f81991d;

    public r(p r100, int r101, long r102) {
        this.f81988a = r100;
        this.f81989b = 8;
        this.f81990c = r101;
        this.f81991d = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
        int r103 = this.f81989b;
        int r104 = this.f81990c;
        long r105 = this.f81991d;
        r102.getClass();
        TalkRoomBusinessFullLinkMonitor.y(r103, 2, r104, r105, r101);
        p.a r106 = (p.a) this.f81988a.f531633a;
        if (r106 == null) goto L6;
        r106.j8(r101);
        return;
    }
}
