package com.stepos.agentframework.chatcore.session.bean;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/bean/AgentTaskEventType;", "", "<init>", "(Ljava/lang/String;I)V", "CREATED", "UPDATED", "COMPLETED", "ANSWER", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentTaskEventType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ AgentTaskEventType[] $VALUES;
    public static final AgentTaskEventType CREATED = new AgentTaskEventType("CREATED", 0);
    public static final AgentTaskEventType UPDATED = new AgentTaskEventType("UPDATED", 1);
    public static final AgentTaskEventType COMPLETED = new AgentTaskEventType("COMPLETED", 2);
    public static final AgentTaskEventType ANSWER = new AgentTaskEventType("ANSWER", 3);

    private static final /* synthetic */ AgentTaskEventType[] $values() {
        return new AgentTaskEventType[]{CREATED, UPDATED, COMPLETED, ANSWER};
    }

    static {
        AgentTaskEventType[] agentTaskEventTypeArr$values = $values();
        $VALUES = agentTaskEventTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(agentTaskEventTypeArr$values);
    }

    private AgentTaskEventType(String str, int i10) {
    }

    public static InterfaceC4149a<AgentTaskEventType> getEntries() {
        return $ENTRIES;
    }

    public static AgentTaskEventType valueOf(String str) {
        return (AgentTaskEventType) Enum.valueOf(AgentTaskEventType.class, str);
    }

    public static AgentTaskEventType[] values() {
        return (AgentTaskEventType[]) $VALUES.clone();
    }
}
