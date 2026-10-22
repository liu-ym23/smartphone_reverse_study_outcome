package com.bytedance.common.utility;

import android.content.Context;
import android.content.IntentFilter;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppLogNetworkStatusMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Context f6681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f6682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    PluginBroadcastReceiver f6683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    i.b f6684d;

    public a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.f6682b = false;
        this.f6684d = i.b.f6737c;
        this.f6681a = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        b();
    }

    private void b() {
        if (this.f6682b == true) goto L6;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        PluginBroadcastReceiver r1 = new AnonymousClass1(this);
        this.f6683c = r1;
        this.f6682b = true;
        ZeusTransformUtils.registerReceiver(this.f6681a, r1, r0, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
    L6:
        this.f6684d = i.e(this.f6681a);
    }

    public i.b a() {
        return this.f6684d;
    }
}
