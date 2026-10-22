package com.zyql.protobuf.agent;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class InvokeHookTask$HookDataCase {

    /* renamed from: a, reason: collision with root package name */
    public static final InvokeHookTask$HookDataCase f4251a;
    public static final InvokeHookTask$HookDataCase b;
    public static final InvokeHookTask$HookDataCase c;
    public static final InvokeHookTask$HookDataCase d;
    public static final InvokeHookTask$HookDataCase e;
    public static final InvokeHookTask$HookDataCase f;
    public static final InvokeHookTask$HookDataCase g;
    public static final InvokeHookTask$HookDataCase h;
    public static final InvokeHookTask$HookDataCase i;

    /* renamed from: j, reason: collision with root package name */
    public static final InvokeHookTask$HookDataCase f4252j;
    public static final InvokeHookTask$HookDataCase k;
    public static final InvokeHookTask$HookDataCase l;
    public static final InvokeHookTask$HookDataCase m;
    public static final InvokeHookTask$HookDataCase n;
    public static final /* synthetic */ InvokeHookTask$HookDataCase[] o;

    static {
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase = new InvokeHookTask$HookDataCase("SESSION_START", 0);
        f4251a = invokeHookTask$HookDataCase;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase2 = new InvokeHookTask$HookDataCase("SESSION_END", 1);
        b = invokeHookTask$HookDataCase2;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase3 = new InvokeHookTask$HookDataCase("TOOL_CALL_PRE", 2);
        c = invokeHookTask$HookDataCase3;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase4 = new InvokeHookTask$HookDataCase("TOOL_CALL_POST", 3);
        d = invokeHookTask$HookDataCase4;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase5 = new InvokeHookTask$HookDataCase("TOOL_CALL_ERROR", 4);
        e = invokeHookTask$HookDataCase5;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase6 = new InvokeHookTask$HookDataCase("MODEL_CALL_PRE", 5);
        f = invokeHookTask$HookDataCase6;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase7 = new InvokeHookTask$HookDataCase("MODEL_CALL_POST", 6);
        g = invokeHookTask$HookDataCase7;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase8 = new InvokeHookTask$HookDataCase("AGENT_START", 7);
        h = invokeHookTask$HookDataCase8;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase9 = new InvokeHookTask$HookDataCase("AGENT_COMPLETE", 8);
        i = invokeHookTask$HookDataCase9;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase10 = new InvokeHookTask$HookDataCase("HANDOFF_PRE", 9);
        f4252j = invokeHookTask$HookDataCase10;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase11 = new InvokeHookTask$HookDataCase("HANDOFF_POST", 10);
        k = invokeHookTask$HookDataCase11;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase12 = new InvokeHookTask$HookDataCase("MESSAGE_PRE", 11);
        l = invokeHookTask$HookDataCase12;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase13 = new InvokeHookTask$HookDataCase("MESSAGE_POST", 12);
        m = invokeHookTask$HookDataCase13;
        InvokeHookTask$HookDataCase invokeHookTask$HookDataCase14 = new InvokeHookTask$HookDataCase("HOOKDATA_NOT_SET", 13);
        n = invokeHookTask$HookDataCase14;
        o = new InvokeHookTask$HookDataCase[]{invokeHookTask$HookDataCase, invokeHookTask$HookDataCase2, invokeHookTask$HookDataCase3, invokeHookTask$HookDataCase4, invokeHookTask$HookDataCase5, invokeHookTask$HookDataCase6, invokeHookTask$HookDataCase7, invokeHookTask$HookDataCase8, invokeHookTask$HookDataCase9, invokeHookTask$HookDataCase10, invokeHookTask$HookDataCase11, invokeHookTask$HookDataCase12, invokeHookTask$HookDataCase13, invokeHookTask$HookDataCase14};
    }

    public static InvokeHookTask$HookDataCase valueOf(String str) {
        return (InvokeHookTask$HookDataCase) Enum.valueOf(InvokeHookTask$HookDataCase.class, str);
    }

    public static InvokeHookTask$HookDataCase[] values() {
        return (InvokeHookTask$HookDataCase[]) o.clone();
    }
}
