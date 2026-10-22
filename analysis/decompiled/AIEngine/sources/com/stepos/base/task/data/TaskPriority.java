package com.stepos.base.task.data;

import kotlin.NoWhenBranchMatchedException;
import mb.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TaskPriority {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6396b;

    /* renamed from: c, reason: collision with root package name */
    public static final TaskPriority f6397c;

    /* renamed from: d, reason: collision with root package name */
    public static final TaskPriority f6398d;

    /* renamed from: e, reason: collision with root package name */
    public static final TaskPriority f6399e;
    public static final TaskPriority h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ TaskPriority[] f6400j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ sb.a f6401k;

    /* renamed from: a, reason: collision with root package name */
    public final int f6402a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static TaskPriority a(int i10) {
            Object next;
            c cVar = (c) TaskPriority.f6401k;
            cVar.getClass();
            c.b bVar = new c.b();
            while (true) {
                if (!bVar.hasNext()) {
                    next = null;
                    break;
                }
                next = bVar.next();
                if (((TaskPriority) next).f6402a == i10) {
                    break;
                }
            }
            TaskPriority taskPriority = (TaskPriority) next;
            return taskPriority == null ? TaskPriority.f6399e : taskPriority;
        }
    }

    static {
        TaskPriority taskPriority = new TaskPriority("P0_ULTRA_HIGH", 0, 0);
        f6397c = taskPriority;
        TaskPriority taskPriority2 = new TaskPriority("P1_HIGH", 1, 1);
        f6398d = taskPriority2;
        TaskPriority taskPriority3 = new TaskPriority("P2_NORMAL", 2, 2);
        f6399e = taskPriority3;
        TaskPriority taskPriority4 = new TaskPriority("P3_LOW", 3, 3);
        h = taskPriority4;
        TaskPriority[] taskPriorityArr = {taskPriority, taskPriority2, taskPriority3, taskPriority4};
        f6400j = taskPriorityArr;
        f6401k = kotlin.enums.a.a(taskPriorityArr);
        f6396b = new a();
    }

    public TaskPriority(String str, int i10, int i11) {
        this.f6402a = i11;
    }

    public static TaskPriority valueOf(String str) {
        return (TaskPriority) Enum.valueOf(TaskPriority.class, str);
    }

    public static TaskPriority[] values() {
        return (TaskPriority[]) f6400j.clone();
    }

    public final int a() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return 1000;
        }
        if (iOrdinal == 1) {
            return 100;
        }
        if (iOrdinal == 2) {
            return 10;
        }
        if (iOrdinal == 3) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }
}
