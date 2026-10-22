package com.stepos.agentframework.chatcore.session;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/AgentMessageType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "IMAGE", "IMAGE_URL", "VIDEO", "AUDIO", "FILE", "FOLDER", "TOOL", "THINKING_TEXT", "TASK", "TASK_PLAN", "TASK_UPDATE", "WORK_ERROR", "WORK_COMPLETE", "TOOL_SHOW", "TOOL_RESULT", "UPDATE_RECOMMEND", "MODERATION", "INQUIRY", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgentMessageType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ AgentMessageType[] $VALUES;
    public static final AgentMessageType TEXT = new AgentMessageType("TEXT", 0);
    public static final AgentMessageType IMAGE = new AgentMessageType("IMAGE", 1);
    public static final AgentMessageType IMAGE_URL = new AgentMessageType("IMAGE_URL", 2);
    public static final AgentMessageType VIDEO = new AgentMessageType("VIDEO", 3);
    public static final AgentMessageType AUDIO = new AgentMessageType("AUDIO", 4);
    public static final AgentMessageType FILE = new AgentMessageType("FILE", 5);
    public static final AgentMessageType FOLDER = new AgentMessageType("FOLDER", 6);
    public static final AgentMessageType TOOL = new AgentMessageType("TOOL", 7);
    public static final AgentMessageType THINKING_TEXT = new AgentMessageType("THINKING_TEXT", 8);
    public static final AgentMessageType TASK = new AgentMessageType("TASK", 9);
    public static final AgentMessageType TASK_PLAN = new AgentMessageType("TASK_PLAN", 10);
    public static final AgentMessageType TASK_UPDATE = new AgentMessageType("TASK_UPDATE", 11);
    public static final AgentMessageType WORK_ERROR = new AgentMessageType("WORK_ERROR", 12);
    public static final AgentMessageType WORK_COMPLETE = new AgentMessageType("WORK_COMPLETE", 13);
    public static final AgentMessageType TOOL_SHOW = new AgentMessageType("TOOL_SHOW", 14);
    public static final AgentMessageType TOOL_RESULT = new AgentMessageType("TOOL_RESULT", 15);
    public static final AgentMessageType UPDATE_RECOMMEND = new AgentMessageType("UPDATE_RECOMMEND", 16);
    public static final AgentMessageType MODERATION = new AgentMessageType("MODERATION", 17);
    public static final AgentMessageType INQUIRY = new AgentMessageType("INQUIRY", 18);

    private static final /* synthetic */ AgentMessageType[] $values() {
        return new AgentMessageType[]{TEXT, IMAGE, IMAGE_URL, VIDEO, AUDIO, FILE, FOLDER, TOOL, THINKING_TEXT, TASK, TASK_PLAN, TASK_UPDATE, WORK_ERROR, WORK_COMPLETE, TOOL_SHOW, TOOL_RESULT, UPDATE_RECOMMEND, MODERATION, INQUIRY};
    }

    static {
        AgentMessageType[] agentMessageTypeArr$values = $values();
        $VALUES = agentMessageTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(agentMessageTypeArr$values);
    }

    private AgentMessageType(String str, int i10) {
    }

    public static InterfaceC4149a<AgentMessageType> getEntries() {
        return $ENTRIES;
    }

    public static AgentMessageType valueOf(String str) {
        return (AgentMessageType) Enum.valueOf(AgentMessageType.class, str);
    }

    public static AgentMessageType[] values() {
        return (AgentMessageType[]) $VALUES.clone();
    }
}
