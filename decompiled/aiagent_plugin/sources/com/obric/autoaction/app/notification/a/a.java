package com.obric.autoaction.app.notification.a;

import android.content.Context;
import androidx.core.app.j;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AfterRunningChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f24564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24565b;

    public a() {
        this.f24564a = "oauto_channel_after_running";
        this.f24565b = ZeusTransformUtils.mapRes(R.string.oauto_notif_chan_after_running, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_notif_chan_after_running");
    }

    @Override // com.obric.autoaction.app.notification.a.b
    public String a() {
        return this.f24564a;
    }

    @Override // com.obric.autoaction.app.notification.a.b
    public int b() {
        return this.f24565b;
    }

    @Override // com.obric.autoaction.app.notification.a.b
    public j.c a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        o.e(r5, "context");
        j.c r3 = super.a(r5).a(r5.getString(ZeusTransformUtils.mapRes(R.string.oauto_notif_chan_after_running_desc, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oauto_notif_chan_after_running_desc")));
        o.c(r3, "setDescription(...)");
        return r3;
    }
}
