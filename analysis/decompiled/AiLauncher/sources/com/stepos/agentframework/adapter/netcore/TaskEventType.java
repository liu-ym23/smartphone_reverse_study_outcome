package com.stepos.agentframework.adapter.netcore;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/TaskEventType;", "", "<init>", "(Ljava/lang/String;I)V", "CREATED", "UPDATED", "COMPLETED", "ANSWER", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TaskEventType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TaskEventType[] $VALUES;
    public static final TaskEventType CREATED = new TaskEventType("CREATED", 0);
    public static final TaskEventType UPDATED = new TaskEventType("UPDATED", 1);
    public static final TaskEventType COMPLETED = new TaskEventType("COMPLETED", 2);
    public static final TaskEventType ANSWER = new TaskEventType("ANSWER", 3);

    private static final /* synthetic */ TaskEventType[] $values() {
        return new TaskEventType[]{CREATED, UPDATED, COMPLETED, ANSWER};
    }

    static {
        TaskEventType[] taskEventTypeArr$values = $values();
        $VALUES = taskEventTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(taskEventTypeArr$values);
    }

    private TaskEventType(String str, int i10) {
    }

    public static InterfaceC4149a<TaskEventType> getEntries() {
        return $ENTRIES;
    }

    public static TaskEventType valueOf(String str) {
        return (TaskEventType) Enum.valueOf(TaskEventType.class, str);
    }

    public static TaskEventType[] values() {
        return (TaskEventType[]) $VALUES.clone();
    }
}
