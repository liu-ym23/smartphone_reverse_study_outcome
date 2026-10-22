package com.stepos.base.task.data;

import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskState {

    /* renamed from: a, reason: collision with root package name */
    public static final TaskState f6403a;

    /* renamed from: b, reason: collision with root package name */
    public static final TaskState f6404b;

    /* renamed from: c, reason: collision with root package name */
    public static final TaskState f6405c;

    /* renamed from: d, reason: collision with root package name */
    public static final TaskState f6406d;

    /* renamed from: e, reason: collision with root package name */
    public static final TaskState f6407e;
    public static final TaskState h;

    /* renamed from: j, reason: collision with root package name */
    public static final TaskState f6408j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ TaskState[] f6409k;

    static {
        TaskState taskState = new TaskState("PENDING", 0);
        f6403a = taskState;
        TaskState taskState2 = new TaskState("QUEUED", 1);
        f6404b = taskState2;
        TaskState taskState3 = new TaskState("RUNNING", 2);
        f6405c = taskState3;
        TaskState taskState4 = new TaskState("COMPLETED", 3);
        f6406d = taskState4;
        TaskState taskState5 = new TaskState("CANCELLED", 4);
        f6407e = taskState5;
        TaskState taskState6 = new TaskState("FAILED", 5);
        h = taskState6;
        TaskState taskState7 = new TaskState("TIMEOUT", 6);
        f6408j = taskState7;
        TaskState[] taskStateArr = {taskState, taskState2, taskState3, taskState4, taskState5, taskState6, taskState7};
        f6409k = taskStateArr;
        a.a(taskStateArr);
    }

    public TaskState() {
        throw null;
    }

    public static TaskState valueOf(String str) {
        return (TaskState) Enum.valueOf(TaskState.class, str);
    }

    public static TaskState[] values() {
        return (TaskState[]) f6409k.clone();
    }
}
