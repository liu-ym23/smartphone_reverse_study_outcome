package com.bytedance.android.live.livepkaudience.emoji;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f81946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f81947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f81948c;

    public f(d r100, int r101, long r102) {
        this.f81946a = r100;
        this.f81947b = r101;
        this.f81948c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
        int r103 = this.f81947b;
        long r104 = this.f81948c;
        r102.getClass();
        TalkRoomBusinessFullLinkMonitor.y(8, 1, r103, r104, r101);
        d.a r105 = (d.a) this.f81946a.f531633a;
        if (r105 == null) goto L6;
        r105.E3(r101);
        return;
    }
}
