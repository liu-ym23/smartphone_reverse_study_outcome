package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: OkHttp3AppMonitor.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements LifeCycleMonitor.a {
    private static final String TAG = "h";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LifeCycleMonitor f8484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PluginBroadcastReceiver f8485b;

    static {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor.a
    public void b() {
    }

    public h() {
        this.f8484a = new LifeCycleMonitor();
        this.f8485b = new AnonymousClass1(this);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util.LifeCycleMonitor.a
    public void a() {
        com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.e.getService().g();
    }

    public void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        b(r4);
        c(r4);
    }

    private void b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L8;
        IntentFilter r0 = new IntentFilter();
        r0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ZeusTransformUtils.registerReceiver(r5, this.f8485b, r0, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "register network state changed completed");
        return;
    L9:
        return;
    }

    private void c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "register activity forground and background switch Callback");
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Application.class) == false) goto L11;
        Application r6 = (Application) ZeusTransformUtils.preCheckCast(r5, Application.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L12;
        this.f8484a.setAppStateChangedListener(this);
        r6.registerActivityLifecycleCallbacks(this.f8484a);
        return;
    L12:
        return;
    }
}
