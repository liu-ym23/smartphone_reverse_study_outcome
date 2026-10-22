package com.obric.agent.utils;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.assistant.idl.IFlowFrontierIDL;
import com.obric.aiagent.assistant.idl.IFlowNetworkIDL;
import com.obric.aiagent.assistant.idl.ad;
import com.obric.aiagent.assistant.idl.am;
import com.obric.aiagent.ttnet.ITTNet;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import org.json.JSONObject;

/* JADX INFO: compiled from: ClientPhoneEnvInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
final class p extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f16059a = null;

    static {
        f16059a = new p();
    }

    private final String a(int r1) {
        if (r1 != 0) goto L4;
        return "connecting";
    L4:
        if (r1 != 1) goto L6;
        return "connected";
    L6:
        if (r1 == 2) goto L8;
        return SensitiveType.UNKNOWN;
    L8:
        return "disconnected";
    }

    private p() {
        super("flow_network", 2000);
    }

    @Override // com.obric.agent.utils.c
    public void a(JSONObject r2, long r3) {
        d.h.b.o.e(r2, "env");
        JSONObject r1 = new JSONObject();
        IFlowNetworkIDL r4 = am.a(aa.b(IFlowNetworkIDL.class));
        if (r4 == null) goto L5;
        r1.put("flow_status", r4.getCurrentNetworkStatus());
    L5:
        ITTNet r5 = (ITTNet) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITTNet.class), ITTNet.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L8;
        int r6 = r5.getEffectiveConnectionType();
    L9:
        r1.put("ttnet_effective_connection_type", r6);
        IFlowFrontierIDL r7 = ad.a(aa.b(IFlowFrontierIDL.class));
        if (r7 == null) goto L12;
        int r8 = r7.getState();
        r1.put("ws_state", f16059a.a(r8));
    L12:
        r2.put("network", r1);
        return;
    L8:
        r6 = -404;
        goto L9
    }
}
