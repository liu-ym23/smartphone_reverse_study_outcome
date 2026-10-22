package com.stepos.ability.common;

import D7.q;
import K7.a;
import java.util.Set;
import kotlin.Metadata;
import w0.C2085f;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/stepos/ability/common/TaskStatus;", "", "w0/f", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskStatus {
    public static final C2085f b;
    public static final Set c;
    public static final Set d;
    public static final Set e;
    public static final TaskStatus f;
    public static final TaskStatus g;
    public static final TaskStatus h;
    public static final TaskStatus i;

    /* renamed from: j, reason: collision with root package name */
    public static final TaskStatus f3076j;
    public static final TaskStatus k;
    public static final TaskStatus l;
    public static final TaskStatus m;
    public static final TaskStatus n;
    public static final TaskStatus o;
    public static final /* synthetic */ TaskStatus[] p;

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ a f3077q;

    /* renamed from: a, reason: collision with root package name */
    public final int f3078a;

    static {
        TaskStatus taskStatus = new TaskStatus("CREATED", 0, 0);
        f = taskStatus;
        TaskStatus taskStatus2 = new TaskStatus("PENDING", 1, 1);
        TaskStatus taskStatus3 = new TaskStatus("RUNNING", 2, 2);
        g = taskStatus3;
        TaskStatus taskStatus4 = new TaskStatus("PAUSED", 3, 3);
        TaskStatus taskStatus5 = new TaskStatus("COMPLETED", 4, 4);
        h = taskStatus5;
        TaskStatus taskStatus6 = new TaskStatus("FAILED", 5, 5);
        i = taskStatus6;
        TaskStatus taskStatus7 = new TaskStatus("CANCELLED", 6, 6);
        f3076j = taskStatus7;
        TaskStatus taskStatus8 = new TaskStatus("REMOVED", 7, 7);
        TaskStatus taskStatus9 = new TaskStatus("TAKE_OVER", 8, 8);
        k = taskStatus9;
        TaskStatus taskStatus10 = new TaskStatus("LLM_TAKE_OVER", 9, 9);
        l = taskStatus10;
        TaskStatus taskStatus11 = new TaskStatus("RECOVER_FROM_TAKEOVER", 10, 10);
        m = taskStatus11;
        TaskStatus taskStatus12 = new TaskStatus("EXPLAIN", 11, 11);
        n = taskStatus12;
        TaskStatus taskStatus13 = new TaskStatus("SCREEN_SHOT", 12, 12);
        o = taskStatus13;
        TaskStatus[] taskStatusArr = {taskStatus, taskStatus2, taskStatus3, taskStatus4, taskStatus5, taskStatus6, taskStatus7, taskStatus8, taskStatus9, taskStatus10, taskStatus11, taskStatus12, taskStatus13, new TaskStatus("WAITING_USER_AUTH", 13, 13)};
        p = taskStatusArr;
        f3077q = kotlin.enums.a.a(taskStatusArr);
        b = new C2085f(3);
        c = q.K0(new Integer[]{2, 11, 10, 12});
        d = q.K0(new Integer[]{9, 8});
        e = q.K0(new Integer[]{4, 5, 6, 7});
    }

    public TaskStatus(String str, int i6, int i10) {
        this.f3078a = i10;
    }

    public static TaskStatus valueOf(String str) {
        return (TaskStatus) Enum.valueOf(TaskStatus.class, str);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[]) p.clone();
    }
}
