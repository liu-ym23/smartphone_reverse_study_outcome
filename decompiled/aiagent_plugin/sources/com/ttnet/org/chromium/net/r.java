package com.ttnet.org.chromium.net;

import android.content.Context;
import android.content.Intent;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyBroadcastReceiver.java */
/* JADX INFO: loaded from: classes4.dex */
final class r extends PluginBroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProxyChangeListener f38256a;

    r(ProxyChangeListener r1) {
        this.f38256a = r1;
    }

    public void onReceive(Context r3, Intent r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
        this.f38256a.a(r4);
        return;
    }
}
