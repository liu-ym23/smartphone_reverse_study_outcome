package com.bytedance.lego.init.monitor;

import com.bytedance.lego.init.ServiceManagerProxy;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.p;

/* JADX INFO: compiled from: InitMonitor.kt */
/* JADX INFO: loaded from: classes.dex */
final class InitMonitor$launchTraceService$2 extends p implements a<ILaunchTrace> {
    public static final InitMonitor$launchTraceService$2 INSTANCE = null;

    static {
        INSTANCE = new InitMonitor$launchTraceService$2();
    }

    InitMonitor$launchTraceService$2() {
        super(0);
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ ILaunchTrace invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.h.a.a
    public final ILaunchTrace invoke() {
        return (ILaunchTrace) ZeusTransformUtils.preCheckCast(ServiceManagerProxy.INSTANCE.getService(ILaunchTrace.class), ILaunchTrace.class, "com.obric.aiagent.plugin");
    }
}
