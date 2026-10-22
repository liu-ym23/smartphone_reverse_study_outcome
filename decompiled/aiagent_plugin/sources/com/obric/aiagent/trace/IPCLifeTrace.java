package com.obric.aiagent.trace;

import android.content.Intent;
import androidx.core.os.e;
import com.obric.aiagent.applog.IAppLog;
import com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.m;
import d.s;

/* JADX INFO: compiled from: IPCLifeTrace.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IPCLifeTrace implements IAgentIPCLifecycleDispatchSPI {
    public static final a Companion = null;
    private static final String EVENT_NAME = "ipc_lifecycle";
    private static final String PARAM_ACTION = "intent_action";
    private static final String PARAM_LIFEEVENT = "event";
    private static final String PARAM_PKG = "package_name";
    private static final String VALUE_LIFEEVENT_APPRESET = "app_reset";
    private static final String VALUE_LIFEEVENT_BIND = "bind";
    private static final String VALUE_LIFEEVENT_UNBIND = "unbind";

    /* JADX INFO: compiled from: IPCLifeTrace.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onUnbind(String r1, Intent r2) {
        o.e(r1, "pkg");
        o.e(r2, MemorySourceLinkType.INTENT);
    }

    public IPCLifeTrace() {
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onBind(String r4, Intent r5) {
        o.e(r4, "pkg");
        o.e(r5, MemorySourceLinkType.INTENT);
        IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.report(EVENT_NAME, e.a(new m[]{s.a(PARAM_LIFEEVENT, VALUE_LIFEEVENT_BIND), s.a(PARAM_ACTION, r5.getAction())}));
        return;
    }

    @Override // com.obric.aiagent.ipc.notifier.IAgentIPCLifecycleDispatchSPI
    public void onAppReset(String r4, Intent r5) {
        o.e(r4, "pkg");
        o.e(r5, MemorySourceLinkType.INTENT);
        IAppLog r3 = (IAppLog) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IAppLog.class), IAppLog.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        r3.report(EVENT_NAME, e.a(new m[]{s.a(PARAM_LIFEEVENT, VALUE_LIFEEVENT_APPRESET), s.a(PARAM_PKG, r4)}));
        return;
    }
}
