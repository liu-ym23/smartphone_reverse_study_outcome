package com.stepos.ability.commoninternal;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stepos/ability/commoninternal/AgentCache;", "", AppAgent.CONSTRUCT, "()V", "AGENT_CACHE_NODE_NAME", "", "AGENT_CACHE_TASK_TYPE_TOOL", "AGENT_CACHE_TASK_TYPE_GUI", "AGENT_CACHE_MSG_TYPE_DOWN_LINK", "AGENT_CACHE_MSG_TYPE_UP_LINK", "commonInternal_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentCache {
    public static final String AGENT_CACHE_MSG_TYPE_DOWN_LINK = "downlink";
    public static final String AGENT_CACHE_MSG_TYPE_UP_LINK = "uplink";
    public static final String AGENT_CACHE_NODE_NAME = "task_exec";
    public static final String AGENT_CACHE_TASK_TYPE_GUI = "gui";
    public static final String AGENT_CACHE_TASK_TYPE_TOOL = "tool";
    public static final AgentCache INSTANCE = new AgentCache();

    private AgentCache() {
    }
}
