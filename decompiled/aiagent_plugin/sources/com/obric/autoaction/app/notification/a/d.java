package com.obric.autoaction.app.notification.a;

import android.content.Context;
import androidx.core.app.j;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: DuringRunningChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24576b;

    public d() {
        this.f24575a = "oauto_channel_during_running";
        this.f24576b = ZeusTransformUtils.mapRes(R.string.oauto_notif_chan_during_running, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_notif_chan_during_running");
    }

    @Override // com.obric.autoaction.app.notification.a.b
    public String a() {
        return this.f24575a;
    }

    @Override // com.obric.autoaction.app.notification.a.b
    public int b() {
        return this.f24576b;
    }

    @Override // com.obric.autoaction.app.notification.a.b
    public j.c a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        j.c r3 = super.a(r5).a(r5.getString(ZeusTransformUtils.mapRes(R.string.oauto_notif_chan_during_running_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_notif_chan_during_running_desc")));
        o.c(r3, "setDescription(...)");
        return r3;
    }
}
