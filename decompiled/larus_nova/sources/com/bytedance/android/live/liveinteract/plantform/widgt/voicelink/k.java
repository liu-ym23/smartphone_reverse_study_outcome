package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ye0.a f77842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f77843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f77844c;

    public k(ye0.a r100, long r101) {
        this.f77842a = r100;
        this.f77843b = 0;
        this.f77844c = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.live.network.response.a r101 = (com.bytedance.android.live.network.response.a) r100;
        this.f77842a.onSuccess();
        TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
        int r103 = this.f77843b;
        long r104 = this.f77844c;
        Intrinsics.checkNotNull(r101);
        TalkRoomBusinessFullLinkMonitor.d(r102, r103, r104, r101);
    }
}
