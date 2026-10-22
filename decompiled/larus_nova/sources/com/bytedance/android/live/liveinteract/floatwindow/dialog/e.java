package com.bytedance.android.live.liveinteract.floatwindow.dialog;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f73335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f73336b;

    public e(Function0 r100, long r101) {
        this.f73335a = r100;
        this.f73336b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f73335a.invoke();
        TalkRoomBusinessFullLinkMonitor r101 = TalkRoomBusinessFullLinkMonitor.f71456a;
        long r102 = this.f73336b;
        TalkRoomBusinessFullLinkMonitor.d(r101, 0, r102, (com.bytedance.android.live.network.response.a) r100);
    }
}
