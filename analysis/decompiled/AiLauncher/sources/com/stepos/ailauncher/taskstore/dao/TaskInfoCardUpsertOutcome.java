package com.stepos.ailauncher.taskstore.dao;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardUpsertOutcome;", "", "<init>", "(Ljava/lang/String;I)V", "WRITTEN", "UNCHANGED", "STALE", "isPersisted", "", "()Z", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoCardUpsertOutcome {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TaskInfoCardUpsertOutcome[] $VALUES;
    public static final TaskInfoCardUpsertOutcome WRITTEN = new TaskInfoCardUpsertOutcome("WRITTEN", 0);
    public static final TaskInfoCardUpsertOutcome UNCHANGED = new TaskInfoCardUpsertOutcome("UNCHANGED", 1);
    public static final TaskInfoCardUpsertOutcome STALE = new TaskInfoCardUpsertOutcome("STALE", 2);

    private static final /* synthetic */ TaskInfoCardUpsertOutcome[] $values() {
        return new TaskInfoCardUpsertOutcome[]{WRITTEN, UNCHANGED, STALE};
    }

    static {
        TaskInfoCardUpsertOutcome[] taskInfoCardUpsertOutcomeArr$values = $values();
        $VALUES = taskInfoCardUpsertOutcomeArr$values;
        $ENTRIES = kotlin.enums.a.a(taskInfoCardUpsertOutcomeArr$values);
    }

    private TaskInfoCardUpsertOutcome(String str, int i10) {
    }

    public static InterfaceC4149a<TaskInfoCardUpsertOutcome> getEntries() {
        return $ENTRIES;
    }

    public static TaskInfoCardUpsertOutcome valueOf(String str) {
        return (TaskInfoCardUpsertOutcome) Enum.valueOf(TaskInfoCardUpsertOutcome.class, str);
    }

    public static TaskInfoCardUpsertOutcome[] values() {
        return (TaskInfoCardUpsertOutcome[]) $VALUES.clone();
    }

    public final boolean isPersisted() {
        return this == WRITTEN || this == UNCHANGED;
    }
}
