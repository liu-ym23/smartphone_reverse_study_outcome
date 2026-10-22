package com.c.a.a;

import android.content.Context;
import android.content.Intent;
import com.bytedance.apm.thread.b;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NetworkBroadcastReceiver.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends PluginBroadcastReceiver {
    public a() {
    }

    public void onReceive(Context r2, Intent r3) {
        final Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        b.a().a(new AnonymousClass1(this, r4));
    }
}
