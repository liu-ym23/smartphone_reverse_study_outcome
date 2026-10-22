package com.obric.utilsLib.a;

import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NetworkConnectChangeReceiver.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends PluginBroadcastReceiver {
    public a() {
    }

    public void onReceive(Context r2, Intent r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r3.getAction()) == false) goto L5;
    L8:
        b.a(b.c(r1));
        return;
    L5:
        if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r3.getAction()) == true) goto L8;
        if ("android.net.wifi.STATE_CHANGE".equals(r3.getAction()) == true) goto L8;
    }
}
