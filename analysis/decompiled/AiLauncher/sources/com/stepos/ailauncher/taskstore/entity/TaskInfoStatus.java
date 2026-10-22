package com.stepos.ailauncher.taskstore.entity;

import Z5.b;
import Z8.Y;
import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.o0;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "", "<init>", "(Ljava/lang/String;I)V", "CREATED", "PLANNING", "PENDING", "RUNNING", "PAUSED", "WAITING", "IN_PROGRESS", "COMPLETED", "FAILED", "CANCELLED", "SKIPPED", "isTerminal", "", "()Z", "isTerminalFailure", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskInfoStatus {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ TaskInfoStatus[] $VALUES;

    @SerializedName("created")
    public static final TaskInfoStatus CREATED = new TaskInfoStatus("CREATED", 0);

    @SerializedName("planning")
    public static final TaskInfoStatus PLANNING = new TaskInfoStatus("PLANNING", 1);

    @SerializedName(AuthSessionDto.STATUS_PENDING)
    public static final TaskInfoStatus PENDING = new TaskInfoStatus("PENDING", 2);

    @SerializedName("running")
    public static final TaskInfoStatus RUNNING = new TaskInfoStatus("RUNNING", 3);

    @SerializedName(o0.TRACK_STATUS_PAUSED)
    public static final TaskInfoStatus PAUSED = new TaskInfoStatus("PAUSED", 4);

    @SerializedName(b.FALLBACK_STATE_WAITING)
    public static final TaskInfoStatus WAITING = new TaskInfoStatus("WAITING", 5);

    @SerializedName("in_progress")
    public static final TaskInfoStatus IN_PROGRESS = new TaskInfoStatus("IN_PROGRESS", 6);

    @SerializedName("completed")
    public static final TaskInfoStatus COMPLETED = new TaskInfoStatus("COMPLETED", 7);

    @SerializedName("failed")
    public static final TaskInfoStatus FAILED = new TaskInfoStatus("FAILED", 8);

    @SerializedName("cancelled")
    public static final TaskInfoStatus CANCELLED = new TaskInfoStatus("CANCELLED", 9);

    @SerializedName("skipped")
    public static final TaskInfoStatus SKIPPED = new TaskInfoStatus("SKIPPED", 10);

    private static final /* synthetic */ TaskInfoStatus[] $values() {
        return new TaskInfoStatus[]{CREATED, PLANNING, PENDING, RUNNING, PAUSED, WAITING, IN_PROGRESS, COMPLETED, FAILED, CANCELLED, SKIPPED};
    }

    static {
        TaskInfoStatus[] taskInfoStatusArr$values = $values();
        $VALUES = taskInfoStatusArr$values;
        $ENTRIES = a.a(taskInfoStatusArr$values);
    }

    private TaskInfoStatus(String str, int i10) {
    }

    public static InterfaceC4149a<TaskInfoStatus> getEntries() {
        return $ENTRIES;
    }

    public static TaskInfoStatus valueOf(String str) {
        return (TaskInfoStatus) Enum.valueOf(TaskInfoStatus.class, str);
    }

    public static TaskInfoStatus[] values() {
        return (TaskInfoStatus[]) $VALUES.clone();
    }

    public final boolean isTerminal() {
        return Y.j(COMPLETED, FAILED, CANCELLED, SKIPPED).contains(this);
    }

    public final boolean isTerminalFailure() {
        return Y.j(FAILED, CANCELLED).contains(this);
    }
}
