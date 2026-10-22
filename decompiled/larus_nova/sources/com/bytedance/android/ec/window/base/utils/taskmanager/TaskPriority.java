package com.bytedance.android.ec.window.base.utils.taskmanager;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/ec/window/base/utils/taskmanager/TaskPriority;", "", "", "value", "I", "getValue", "()I", "RIGHT_NOW", "AFTER_FIRST_SCREEN", "AFTER_FIRST_SCREEN_IDLE", "DO_EVERYTHING", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TaskPriority extends Enum<TaskPriority> {
    public static final TaskPriority AFTER_FIRST_SCREEN = null;
    public static final TaskPriority AFTER_FIRST_SCREEN_IDLE = null;
    public static final TaskPriority DO_EVERYTHING = null;
    public static final TaskPriority RIGHT_NOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TaskPriority[] f49771a = null;
    private final int value;

    static {
        TaskPriority r100 = new TaskPriority("RIGHT_NOW", 0, 0);
        RIGHT_NOW = r100;
        TaskPriority r101 = new TaskPriority("AFTER_FIRST_SCREEN", 1, 1);
        AFTER_FIRST_SCREEN = r101;
        TaskPriority r102 = new TaskPriority("AFTER_FIRST_SCREEN_IDLE", 2, 2);
        AFTER_FIRST_SCREEN_IDLE = r102;
        TaskPriority r103 = new TaskPriority("DO_EVERYTHING", 3, Integer.MAX_VALUE);
        DO_EVERYTHING = r103;
        f49771a = new TaskPriority[]{r100, r101, r102, r103};
    }

    public static TaskPriority valueOf(String r100) {
        return (TaskPriority) r27.a.a(TaskPriority.class, r100);
    }

    public static TaskPriority[] values() {
        return (TaskPriority[]) f49771a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public TaskPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
