package com.stepos.common;

import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/common/AgentTaskState;", "", UxipConstants.f30680s, "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STATE_UNSPECIFIED", "STATE_INITIALIZED", "STATE_PROCESSING", "STATE_COMPLETED", "STATE_INTERRUPTED", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentTaskState {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ AgentTaskState[] $VALUES;
    private final int value;
    public static final AgentTaskState STATE_UNSPECIFIED = new AgentTaskState("STATE_UNSPECIFIED", 0, 0);
    public static final AgentTaskState STATE_INITIALIZED = new AgentTaskState("STATE_INITIALIZED", 1, 1);
    public static final AgentTaskState STATE_PROCESSING = new AgentTaskState("STATE_PROCESSING", 2, 2);
    public static final AgentTaskState STATE_COMPLETED = new AgentTaskState("STATE_COMPLETED", 3, 3);
    public static final AgentTaskState STATE_INTERRUPTED = new AgentTaskState("STATE_INTERRUPTED", 4, 4);

    private static final /* synthetic */ AgentTaskState[] $values() {
        return new AgentTaskState[]{STATE_UNSPECIFIED, STATE_INITIALIZED, STATE_PROCESSING, STATE_COMPLETED, STATE_INTERRUPTED};
    }

    static {
        AgentTaskState[] agentTaskStateArr$values = $values();
        $VALUES = agentTaskStateArr$values;
        $ENTRIES = a.a(agentTaskStateArr$values);
    }

    private AgentTaskState(String str, int i10, int i11) {
        this.value = i11;
    }

    public static InterfaceC4149a<AgentTaskState> getEntries() {
        return $ENTRIES;
    }

    public static AgentTaskState valueOf(String str) {
        return (AgentTaskState) Enum.valueOf(AgentTaskState.class, str);
    }

    public static AgentTaskState[] values() {
        return (AgentTaskState[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
