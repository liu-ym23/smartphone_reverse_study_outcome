package com.bytedance.applog.collector;

import android.content.Context;
import android.content.Intent;
import com.bytedance.applog.b;
import com.bytedance.applog.log.m;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class Collector extends PluginBroadcastReceiver {
    public Collector() {
    }

    public void onReceive(Context r2, Intent r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        String[] r4 = r3.getStringArrayExtra("K_DATA");
        if (r4 != null) goto L5;
    L7:
        m.a().e("Collector onReceive empty", new Object[0]);
        return;
    L5:
        if (r4.length <= 0) goto L7;
        b.a(r4);
    }
}
