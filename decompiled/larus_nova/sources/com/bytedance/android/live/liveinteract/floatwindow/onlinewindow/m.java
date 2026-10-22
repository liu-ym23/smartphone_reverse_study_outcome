package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f73435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f73436b;

    public m(long r100) {
        this.f73435a = "small_window";
        this.f73436b = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        TalkRoomBusinessFullLinkMonitor r101 = TalkRoomBusinessFullLinkMonitor.f71456a;
        String r102 = this.f73435a;
        long r103 = this.f73436b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "requestSource");
        JSONObject r104 = new JSONObject();
        r104.put("request_source", r102);
        LinkMonitorData r105 = LinkMonitorData.LinkOnlineFloatWindowCheckAudienceLinkers;
        long r106 = TalkRoomBusinessFullLinkMonitor.h(r103);
        TalkRoomBusinessFullLinkMonitor.Y(r105, r106, (Throwable) r100, r104);
    }
}
