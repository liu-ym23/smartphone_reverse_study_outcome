package com.stepos.ailauncher.taskstore.entity;

import com.google.gson.annotations.SerializedName;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoEventType;", "", "<init>", "(Ljava/lang/String;I)V", "CREATED", "UPDATED", "COMPLETED", "ANSWER", "FAILED", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoEventType {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TaskInfoEventType[] $VALUES;

    @SerializedName("created")
    public static final TaskInfoEventType CREATED = new TaskInfoEventType("CREATED", 0);

    @SerializedName("updated")
    public static final TaskInfoEventType UPDATED = new TaskInfoEventType("UPDATED", 1);

    @SerializedName("completed")
    public static final TaskInfoEventType COMPLETED = new TaskInfoEventType("COMPLETED", 2);

    @SerializedName("answer")
    public static final TaskInfoEventType ANSWER = new TaskInfoEventType("ANSWER", 3);

    @SerializedName("failed")
    public static final TaskInfoEventType FAILED = new TaskInfoEventType("FAILED", 4);

    private static final /* synthetic */ TaskInfoEventType[] $values() {
        return new TaskInfoEventType[]{CREATED, UPDATED, COMPLETED, ANSWER, FAILED};
    }

    static {
        TaskInfoEventType[] taskInfoEventTypeArr$values = $values();
        $VALUES = taskInfoEventTypeArr$values;
        $ENTRIES = a.a(taskInfoEventTypeArr$values);
    }

    private TaskInfoEventType(String str, int i10) {
    }

    public static InterfaceC4149a<TaskInfoEventType> getEntries() {
        return $ENTRIES;
    }

    public static TaskInfoEventType valueOf(String str) {
        return (TaskInfoEventType) Enum.valueOf(TaskInfoEventType.class, str);
    }

    public static TaskInfoEventType[] values() {
        return (TaskInfoEventType[]) $VALUES.clone();
    }
}
