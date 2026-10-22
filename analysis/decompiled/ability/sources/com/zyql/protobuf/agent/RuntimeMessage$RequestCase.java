package com.zyql.protobuf.agent;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class RuntimeMessage$RequestCase {

    /* renamed from: a, reason: collision with root package name */
    public static final RuntimeMessage$RequestCase f4253a;
    public static final RuntimeMessage$RequestCase b;
    public static final RuntimeMessage$RequestCase c;
    public static final RuntimeMessage$RequestCase d;
    public static final /* synthetic */ RuntimeMessage$RequestCase[] e;

    static {
        RuntimeMessage$RequestCase runtimeMessage$RequestCase = new RuntimeMessage$RequestCase("GET_AGENT_INFO_REQUEST", 0);
        f4253a = runtimeMessage$RequestCase;
        RuntimeMessage$RequestCase runtimeMessage$RequestCase2 = new RuntimeMessage$RequestCase("EXECUTE_TOOL_TASK", 1);
        b = runtimeMessage$RequestCase2;
        RuntimeMessage$RequestCase runtimeMessage$RequestCase3 = new RuntimeMessage$RequestCase("INVOKE_HOOK_TASK", 2);
        c = runtimeMessage$RequestCase3;
        RuntimeMessage$RequestCase runtimeMessage$RequestCase4 = new RuntimeMessage$RequestCase("REQUEST_NOT_SET", 3);
        d = runtimeMessage$RequestCase4;
        e = new RuntimeMessage$RequestCase[]{runtimeMessage$RequestCase, runtimeMessage$RequestCase2, runtimeMessage$RequestCase3, runtimeMessage$RequestCase4};
    }

    public static RuntimeMessage$RequestCase valueOf(String str) {
        return (RuntimeMessage$RequestCase) Enum.valueOf(RuntimeMessage$RequestCase.class, str);
    }

    public static RuntimeMessage$RequestCase[] values() {
        return (RuntimeMessage$RequestCase[]) e.clone();
    }
}
