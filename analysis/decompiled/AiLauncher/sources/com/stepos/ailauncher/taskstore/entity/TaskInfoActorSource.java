package com.stepos.ailauncher.taskstore.entity;

import com.google.gson.annotations.SerializedName;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoActorSource;", "", "<init>", "(Ljava/lang/String;I)V", "USER", "MODEL", "SYSTEM", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoActorSource {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TaskInfoActorSource[] $VALUES;

    @SerializedName("user")
    public static final TaskInfoActorSource USER = new TaskInfoActorSource("USER", 0);

    @SerializedName(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL)
    public static final TaskInfoActorSource MODEL = new TaskInfoActorSource("MODEL", 1);

    @SerializedName("system")
    public static final TaskInfoActorSource SYSTEM = new TaskInfoActorSource("SYSTEM", 2);

    private static final /* synthetic */ TaskInfoActorSource[] $values() {
        return new TaskInfoActorSource[]{USER, MODEL, SYSTEM};
    }

    static {
        TaskInfoActorSource[] taskInfoActorSourceArr$values = $values();
        $VALUES = taskInfoActorSourceArr$values;
        $ENTRIES = a.a(taskInfoActorSourceArr$values);
    }

    private TaskInfoActorSource(String str, int i10) {
    }

    public static InterfaceC4149a<TaskInfoActorSource> getEntries() {
        return $ENTRIES;
    }

    public static TaskInfoActorSource valueOf(String str) {
        return (TaskInfoActorSource) Enum.valueOf(TaskInfoActorSource.class, str);
    }

    public static TaskInfoActorSource[] values() {
        return (TaskInfoActorSource[]) $VALUES.clone();
    }
}
