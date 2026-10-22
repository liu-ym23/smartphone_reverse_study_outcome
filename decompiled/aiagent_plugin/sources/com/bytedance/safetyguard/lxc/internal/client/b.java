package com.bytedance.safetyguard.lxc.internal.client;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.safetyguard.lxc.internal.service.SafetyGuardProxyService;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
final class b implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f9961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f9962b;

    public b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        Context r5 = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
        this.f9961a = r5;
        this.f9962b = new Intent(r5, SafetyGuardProxyService.class);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.client.m
    public boolean a(ServiceConnection r4) {
        ServiceConnection r5 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r4, ServiceConnection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, WsConstants.KEY_CONNECTION);
        return ZeusTransformUtils.bindService(this.f9961a, this.f9962b, r5, 65, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.safetyguard.lxc.internal.client.m
    public void b(ServiceConnection r3) {
        ServiceConnection r4 = (ServiceConnection) ZeusTransformUtils.wrapperContextForParams(r3, ServiceConnection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, WsConstants.KEY_CONNECTION);
        ZeusTransformUtils.unbindService(this.f9961a, r4, "com.obric.aiagent.plugin");
    }
}
