package com.stepos.ability.common;

import mb.l;
import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskStatus {

    /* renamed from: b, reason: collision with root package name */
    public static final TaskStatus f5558b;

    /* renamed from: c, reason: collision with root package name */
    public static final TaskStatus f5559c;

    /* renamed from: d, reason: collision with root package name */
    public static final TaskStatus f5560d;

    /* renamed from: e, reason: collision with root package name */
    public static final TaskStatus f5561e;
    public static final TaskStatus h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ TaskStatus[] f5562j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ a f5563k;

    /* renamed from: a, reason: collision with root package name */
    public final int f5564a;

    static {
        TaskStatus taskStatus = new TaskStatus("CREATED", 0, 0);
        f5558b = taskStatus;
        TaskStatus taskStatus2 = new TaskStatus("PENDING", 1, 1);
        TaskStatus taskStatus3 = new TaskStatus("RUNNING", 2, 2);
        f5559c = taskStatus3;
        TaskStatus taskStatus4 = new TaskStatus("PAUSED", 3, 3);
        TaskStatus taskStatus5 = new TaskStatus("COMPLETED", 4, 4);
        f5560d = taskStatus5;
        TaskStatus taskStatus6 = new TaskStatus("FAILED", 5, 5);
        f5561e = taskStatus6;
        TaskStatus taskStatus7 = new TaskStatus("CANCELLED", 6, 6);
        h = taskStatus7;
        TaskStatus[] taskStatusArr = {taskStatus, taskStatus2, taskStatus3, taskStatus4, taskStatus5, taskStatus6, taskStatus7, new TaskStatus("REMOVED", 7, 7), new TaskStatus("TAKE_OVER", 8, 8), new TaskStatus("LLM_TAKE_OVER", 9, 9), new TaskStatus("RECOVER_FROM_TAKEOVER", 10, 10), new TaskStatus("EXPLAIN", 11, 11), new TaskStatus("SCREEN_SHOT", 12, 12)};
        f5562j = taskStatusArr;
        f5563k = kotlin.enums.a.a(taskStatusArr);
        l.s0(new Integer[]{2, 11, 10, 12});
        l.s0(new Integer[]{9, 8});
        l.s0(new Integer[]{4, 5, 6, 7});
    }

    public TaskStatus(String str, int i10, int i11) {
        this.f5564a = i11;
    }

    public static TaskStatus valueOf(String str) {
        return (TaskStatus) Enum.valueOf(TaskStatus.class, str);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) f5562j.clone();
    }
}
