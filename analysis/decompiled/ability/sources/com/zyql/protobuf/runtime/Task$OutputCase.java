package com.zyql.protobuf.runtime;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class Task$OutputCase {

    /* renamed from: a, reason: collision with root package name */
    public static final Task$OutputCase f4278a;
    public static final Task$OutputCase b;
    public static final Task$OutputCase c;
    public static final Task$OutputCase d;
    public static final Task$OutputCase e;
    public static final Task$OutputCase f;
    public static final /* synthetic */ Task$OutputCase[] g;

    static {
        Task$OutputCase task$OutputCase = new Task$OutputCase("LLM_RESPONSE", 0);
        f4278a = task$OutputCase;
        Task$OutputCase task$OutputCase2 = new Task$OutputCase("AGENT_TASK_STATE", 1);
        b = task$OutputCase2;
        Task$OutputCase task$OutputCase3 = new Task$OutputCase("INPUT_MESSAGE_STATE", 2);
        c = task$OutputCase3;
        Task$OutputCase task$OutputCase4 = new Task$OutputCase("TASK_ERROR", 3);
        d = task$OutputCase4;
        Task$OutputCase task$OutputCase5 = new Task$OutputCase("LOG_NOTIFICATION", 4);
        e = task$OutputCase5;
        Task$OutputCase task$OutputCase6 = new Task$OutputCase("OUTPUT_NOT_SET", 5);
        f = task$OutputCase6;
        g = new Task$OutputCase[]{task$OutputCase, task$OutputCase2, task$OutputCase3, task$OutputCase4, task$OutputCase5, task$OutputCase6};
    }

    public static Task$OutputCase valueOf(String str) {
        return (Task$OutputCase) Enum.valueOf(Task$OutputCase.class, str);
    }

    public static Task$OutputCase[] values() {
        return (Task$OutputCase[]) g.clone();
    }
}
