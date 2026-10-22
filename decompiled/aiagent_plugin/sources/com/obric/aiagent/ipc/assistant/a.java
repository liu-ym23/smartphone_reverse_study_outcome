package com.obric.aiagent.ipc.assistant;

import com.obric.aiagent.assistant.idl.IFlowIDL;
import com.obric.aiagent.assistant.idl.ad;
import com.obric.aiagent.assistant.idl.ag;
import com.obric.aiagent.assistant.idl.ak;
import com.obric.aiagent.assistant.idl.am;
import com.obric.aiagent.assistant.idl.aq;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.assistant.idl.aw;
import com.obric.aiagent.assistant.idl.ax;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.assistant.idl.s;
import com.obric.aiagent.assistant.idl.u;
import com.obric.aiagent.assistant.idl.x;
import com.obric.aiagent.assistant.idl.z;
import com.obric.aiagent.flow.applog.idl.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IPCRegistry.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18606a = null;

    static {
        f18606a = new a();
    }

    private a() {
    }

    public final void a(IFlowIDL r4) {
        IFlowIDL r3 = (IFlowIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowIDL.class, "com.obric.aiagent.plugin");
        o.e(r3, "idl");
        IFlowIDL r5 = ag.a(r3, false);
        if (r5 == null) goto L6;
        com.obric.aiagent.ipc.idl.a.a(r5.getFileIDL(), false, 1, null);
        ad.a(r5.getFrontierIDL(), false, 1, null);
        aw.a(r5.getUiIDL(), false, 1, null);
        s.a(r5.getAppStateIDL(), false, 1, null);
        r.a(r5.getAppIntentIDL(), false, 1, null);
        ax.a(r5.getVoiceInteractionIDL(), false, 1, null);
        ak.a(r5.getMessageIDL(), false, 1, null);
        at.a(r5.getSettingsIDL(), false, 1, null);
        u.a(r5.getAssistantStateIDL(), false, 1, null);
        am.a(r5.getFlowNetworkIDL(), false, 1, null);
        aq.a(r5.getFlowPermissionIDL(), false, 1, null);
        z.a(r5.getFlowFeedbackIDL(), false, 1, null);
        x.a(r5.getCocreationReviewIDL(), false, 1, null);
        c.a(r5.getAppLogIDL(), false, 1, null);
        return;
    }
}
