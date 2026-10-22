package com.bytedance.android.live.liveinteract.videotalk;

import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.livesdkapi.interact.data.LinkConstant;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f79465a;

    public n(long r100) {
        this.f79465a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        TalkRoomBusinessFullLinkMonitor r102 = TalkRoomBusinessFullLinkMonitor.f71456a;
        long r103 = this.f79465a;
        r102.getClass();
        TalkRoomBusinessFullLinkMonitor.z(r103, r101);
        jy0.b.e(LinkConstant.VIDEO_TALK, "", r101);
    }
}
