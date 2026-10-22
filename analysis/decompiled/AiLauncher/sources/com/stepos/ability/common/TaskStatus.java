package com.stepos.ability.common;

import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import h9.InterfaceC4149a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ability/common/TaskStatus;", "", "", "code", "<init>", "(Ljava/lang/String;II)V", "I", "getCode", "()I", "Companion", Const.INTENT_KEY_APIKEY, "CREATED", "PENDING", "RUNNING", "PAUSED", "COMPLETED", "FAILED", "CANCELLED", "REMOVED", "TAKE_OVER", "LLM_TAKE_OVER", "RECOVER_FROM_TAKEOVER", "EXPLAIN", "SCREEN_SHOT", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TaskStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TaskStatus[] $VALUES;
    public static final TaskStatus CANCELLED;
    public static final TaskStatus COMPLETED;
    public static final TaskStatus EXPLAIN;
    public static final TaskStatus FAILED;
    public static final TaskStatus LLM_TAKE_OVER;
    public static final TaskStatus PAUSED;
    public static final TaskStatus RECOVER_FROM_TAKEOVER;
    public static final TaskStatus REMOVED;
    public static final TaskStatus RUNNING;
    private static final Set<Integer> RUNNING_CODES;
    public static final TaskStatus SCREEN_SHOT;
    public static final TaskStatus TAKE_OVER;
    private static final Set<Integer> TAKE_OVER_CODES;
    private static final Set<Integer> TERMINAL_CODES;
    private final int code;
    public static final TaskStatus CREATED = new TaskStatus("CREATED", 0, 0);
    public static final TaskStatus PENDING = new TaskStatus("PENDING", 1, 1);

    private static final /* synthetic */ TaskStatus[] $values() {
        return new TaskStatus[]{CREATED, PENDING, RUNNING, PAUSED, COMPLETED, FAILED, CANCELLED, REMOVED, TAKE_OVER, LLM_TAKE_OVER, RECOVER_FROM_TAKEOVER, EXPLAIN, SCREEN_SHOT};
    }

    static {
        TaskStatus taskStatus = new TaskStatus("RUNNING", 2, 2);
        RUNNING = taskStatus;
        PAUSED = new TaskStatus("PAUSED", 3, 3);
        TaskStatus taskStatus2 = new TaskStatus("COMPLETED", 4, 4);
        COMPLETED = taskStatus2;
        TaskStatus taskStatus3 = new TaskStatus("FAILED", 5, 5);
        FAILED = taskStatus3;
        TaskStatus taskStatus4 = new TaskStatus("CANCELLED", 6, 6);
        CANCELLED = taskStatus4;
        TaskStatus taskStatus5 = new TaskStatus("REMOVED", 7, 7);
        REMOVED = taskStatus5;
        TaskStatus taskStatus6 = new TaskStatus("TAKE_OVER", 8, 8);
        TAKE_OVER = taskStatus6;
        TaskStatus taskStatus7 = new TaskStatus("LLM_TAKE_OVER", 9, 9);
        LLM_TAKE_OVER = taskStatus7;
        TaskStatus taskStatus8 = new TaskStatus("RECOVER_FROM_TAKEOVER", 10, 10);
        RECOVER_FROM_TAKEOVER = taskStatus8;
        TaskStatus taskStatus9 = new TaskStatus("EXPLAIN", 11, 11);
        EXPLAIN = taskStatus9;
        TaskStatus taskStatus10 = new TaskStatus("SCREEN_SHOT", 12, 12);
        SCREEN_SHOT = taskStatus10;
        TaskStatus[] taskStatusArr$values = $values();
        $VALUES = taskStatusArr$values;
        $ENTRIES = a.a(taskStatusArr$values);
        INSTANCE = new Companion(null);
        RUNNING_CODES = Y.j(Integer.valueOf(taskStatus.code), Integer.valueOf(taskStatus9.code), Integer.valueOf(taskStatus8.code), Integer.valueOf(taskStatus10.code));
        TAKE_OVER_CODES = Y.j(Integer.valueOf(taskStatus7.code), Integer.valueOf(taskStatus6.code));
        TERMINAL_CODES = Y.j(Integer.valueOf(taskStatus2.code), Integer.valueOf(taskStatus3.code), Integer.valueOf(taskStatus4.code), Integer.valueOf(taskStatus5.code));
    }

    private TaskStatus(String str, int i10, int i11) {
        this.code = i11;
    }

    public static InterfaceC4149a<TaskStatus> getEntries() {
        return $ENTRIES;
    }

    public static TaskStatus valueOf(String str) {
        return (TaskStatus) Enum.valueOf(TaskStatus.class, str);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
