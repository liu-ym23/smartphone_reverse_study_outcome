package com.stepos.agentframework.adapter.agentbus;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannel;", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannel;)Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "", "TAG", "Ljava/lang/String;", "protocol_agentbus_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ClawChannelAgentBusKt {
    private static final String TAG = "ClawChannelAgentBus";

    public static final ClawChannelAgentBusBinding a(ClawChannel clawChannel) {
        kotlin.jvm.internal.p.i(clawChannel, "<this>");
        C4148a.k(TAG, "connectAgentBus: start binding + onMessage", false, 4, null);
        ClawChannelAgentBusBinding clawChannelAgentBusBindingA = G.a(clawChannel);
        clawChannelAgentBusBindingA.Q();
        clawChannelAgentBusBindingA.getChat().e(new ClawChannelAgentBusKt$connectAgentBus$1(clawChannel, null));
        return clawChannelAgentBusBindingA;
    }
}
