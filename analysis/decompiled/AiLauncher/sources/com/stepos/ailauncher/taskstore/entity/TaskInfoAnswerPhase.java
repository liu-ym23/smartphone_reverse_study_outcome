package com.stepos.ailauncher.taskstore.entity;

import com.google.gson.annotations.SerializedName;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoAnswerPhase;", "", "<init>", "(Ljava/lang/String;I)V", "ACCEPTED", "APPLIED", "REJECTED", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoAnswerPhase {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TaskInfoAnswerPhase[] $VALUES;

    @SerializedName("accepted")
    public static final TaskInfoAnswerPhase ACCEPTED = new TaskInfoAnswerPhase("ACCEPTED", 0);

    @SerializedName("applied")
    public static final TaskInfoAnswerPhase APPLIED = new TaskInfoAnswerPhase("APPLIED", 1);

    @SerializedName("rejected")
    public static final TaskInfoAnswerPhase REJECTED = new TaskInfoAnswerPhase("REJECTED", 2);

    private static final /* synthetic */ TaskInfoAnswerPhase[] $values() {
        return new TaskInfoAnswerPhase[]{ACCEPTED, APPLIED, REJECTED};
    }

    static {
        TaskInfoAnswerPhase[] taskInfoAnswerPhaseArr$values = $values();
        $VALUES = taskInfoAnswerPhaseArr$values;
        $ENTRIES = a.a(taskInfoAnswerPhaseArr$values);
    }

    private TaskInfoAnswerPhase(String str, int i10) {
    }

    public static InterfaceC4149a<TaskInfoAnswerPhase> getEntries() {
        return $ENTRIES;
    }

    public static TaskInfoAnswerPhase valueOf(String str) {
        return (TaskInfoAnswerPhase) Enum.valueOf(TaskInfoAnswerPhase.class, str);
    }

    public static TaskInfoAnswerPhase[] values() {
        return (TaskInfoAnswerPhase[]) $VALUES.clone();
    }
}
