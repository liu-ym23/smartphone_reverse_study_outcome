package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stepos/agentbus/generated/AgentBusWakeContract;", "", AppAgent.CONSTRUCT, "()V", "ACTION_BFF_WAKE", "", "EXTRA_SOURCE", "EXTRA_TRACE_ID", "EVENT_CHANNEL_READY", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentBusWakeContract {
    public static final String ACTION_BFF_WAKE = "com.stepos.agentbus.ACTION_BFF_WAKE";
    public static final String EVENT_CHANNEL_READY = "agentbus.channel.ready";
    public static final String EXTRA_SOURCE = "source";
    public static final String EXTRA_TRACE_ID = "traceId";
    public static final AgentBusWakeContract INSTANCE = new AgentBusWakeContract();

    private AgentBusWakeContract() {
    }
}
