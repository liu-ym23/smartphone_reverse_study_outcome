package com.stepos.ailauncher.taskstore.sync;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/taskstore/sync/TaskSyncOp;", "", "<init>", "(Ljava/lang/String;I)V", "DELETE", "RENAME", "BATCH_DELETE", "RETRY", "CANCEL", "INTERACT", "RESUME", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskSyncOp {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TaskSyncOp[] $VALUES;
    public static final TaskSyncOp DELETE = new TaskSyncOp("DELETE", 0);
    public static final TaskSyncOp RENAME = new TaskSyncOp("RENAME", 1);
    public static final TaskSyncOp BATCH_DELETE = new TaskSyncOp("BATCH_DELETE", 2);
    public static final TaskSyncOp RETRY = new TaskSyncOp("RETRY", 3);
    public static final TaskSyncOp CANCEL = new TaskSyncOp("CANCEL", 4);
    public static final TaskSyncOp INTERACT = new TaskSyncOp("INTERACT", 5);
    public static final TaskSyncOp RESUME = new TaskSyncOp("RESUME", 6);

    private static final /* synthetic */ TaskSyncOp[] $values() {
        return new TaskSyncOp[]{DELETE, RENAME, BATCH_DELETE, RETRY, CANCEL, INTERACT, RESUME};
    }

    static {
        TaskSyncOp[] taskSyncOpArr$values = $values();
        $VALUES = taskSyncOpArr$values;
        $ENTRIES = kotlin.enums.a.a(taskSyncOpArr$values);
    }

    private TaskSyncOp(String str, int i10) {
    }

    public static InterfaceC4149a<TaskSyncOp> getEntries() {
        return $ENTRIES;
    }

    public static TaskSyncOp valueOf(String str) {
        return (TaskSyncOp) Enum.valueOf(TaskSyncOp.class, str);
    }

    public static TaskSyncOp[] values() {
        return (TaskSyncOp[]) $VALUES.clone();
    }
}
