package com.bytedance.lego.init.monitor;

import com.bytedance.lego.init.ServiceManagerProxy;
import com.bytedance.services.apm.api.IApmAgent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.a;
import d.h.b.p;

/* JADX INFO: compiled from: IdleTaskMonitor.kt */
/* JADX INFO: loaded from: classes.dex */
final class IdleTaskMonitor$iApmAgent$2 extends p implements a<IApmAgent> {
    public static final IdleTaskMonitor$iApmAgent$2 INSTANCE = null;

    static {
        INSTANCE = new IdleTaskMonitor$iApmAgent$2();
    }

    IdleTaskMonitor$iApmAgent$2() {
        super(0);
    }

    @Override // d.h.a.a
    public /* bridge */ /* synthetic */ IApmAgent invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d.h.a.a
    public final IApmAgent invoke() {
        return (IApmAgent) ZeusTransformUtils.preCheckCast(ServiceManagerProxy.INSTANCE.getService(IApmAgent.class), IApmAgent.class, "com.obric.aiagent.plugin");
    }
}
