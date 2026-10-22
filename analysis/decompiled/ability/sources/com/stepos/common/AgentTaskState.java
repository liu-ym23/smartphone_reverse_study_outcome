package com.stepos.common;

import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/common/AgentTaskState;", "", "common_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentTaskState {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AgentTaskState[] f3539a;

    static {
        AgentTaskState[] agentTaskStateArr = {new AgentTaskState("STATE_UNSPECIFIED", 0), new AgentTaskState("STATE_INITIALIZED", 1), new AgentTaskState("STATE_PROCESSING", 2), new AgentTaskState("STATE_COMPLETED", 3), new AgentTaskState("STATE_INTERRUPTED", 4)};
        f3539a = agentTaskStateArr;
        a.a(agentTaskStateArr);
    }

    public static AgentTaskState valueOf(String str) {
        return (AgentTaskState) Enum.valueOf(AgentTaskState.class, str);
    }

    public static AgentTaskState[] values() {
        return (AgentTaskState[]) f3539a.clone();
    }
}
