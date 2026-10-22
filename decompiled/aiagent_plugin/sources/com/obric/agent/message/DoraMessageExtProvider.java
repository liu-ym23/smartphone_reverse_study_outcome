package com.obric.agent.message;

import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aikernel.sdk.autotest.AutoTestConstant;
import d.a.ao;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import d.s;
import java.util.Map;

/* JADX INFO: compiled from: DoraMessageExtProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DoraMessageExtProvider implements IAgentMessageExtProvider {
    public static final a Companion = null;
    private static final String KEY_IS_DORA_CONNECTED = "o_is_dora_connected";

    /* JADX INFO: compiled from: DoraMessageExtProvider.kt */
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

    public DoraMessageExtProvider() {
    }

    @Override // com.obric.agent.message.IAgentMessageExtProvider
    public Map<String, String> getExtraForSendMessage(b r2) {
        o.e(r2, AutoTestConstant.PARAM);
        IFlowAppIntentIDL r3 = r.a(aa.b(IFlowAppIntentIDL.class));
        if (r3 == null) goto L5;
        Boolean r4 = Boolean.valueOf(r3.isDoraConnected());
    L7:
        return ao.a(s.a(KEY_IS_DORA_CONNECTED, toNumString(r4)));
    L5:
        r4 = null;
        goto L7
    }

    private final String toNumString(Boolean r1) {
        if (o.a(r1, true) == false) goto L5;
        return "1";
    L5:
        return "0";
    }
}
