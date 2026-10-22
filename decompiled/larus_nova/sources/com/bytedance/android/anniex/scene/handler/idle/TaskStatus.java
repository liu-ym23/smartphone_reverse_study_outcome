package com.bytedance.android.anniex.scene.handler.idle;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/anniex/scene/handler/idle/TaskStatus;", "", "QUEUED", "RUNNING", "SUCCESS", "FAILED", "TIMEOUT", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum TaskStatus extends Enum<TaskStatus> {
    public static final TaskStatus FAILED = null;
    public static final TaskStatus QUEUED = null;
    public static final TaskStatus RUNNING = null;
    public static final TaskStatus SUCCESS = null;
    public static final TaskStatus TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskStatus[] f41194a = null;

    public static TaskStatus valueOf(String r100) {
        return (TaskStatus) r27.a.a(TaskStatus.class, r100);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) f41194a.clone();
    }

    static {
        TaskStatus r100 = new TaskStatus("QUEUED", 0);
        QUEUED = r100;
        TaskStatus r101 = new TaskStatus("RUNNING", 1);
        RUNNING = r101;
        TaskStatus r102 = new TaskStatus("SUCCESS", 2);
        SUCCESS = r102;
        TaskStatus r103 = new TaskStatus("FAILED", 3);
        FAILED = r103;
        TaskStatus r104 = new TaskStatus("TIMEOUT", 4);
        TIMEOUT = r104;
        f41194a = new TaskStatus[]{r100, r101, r102, r103, r104};
    }

    public TaskStatus(String r100, int r101) {
        super(r100, r101);
    }
}
