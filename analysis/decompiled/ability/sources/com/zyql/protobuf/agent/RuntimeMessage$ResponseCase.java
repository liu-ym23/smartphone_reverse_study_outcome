package com.zyql.protobuf.agent;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class RuntimeMessage$ResponseCase {

    /* renamed from: a, reason: collision with root package name */
    public static final RuntimeMessage$ResponseCase f4254a;
    public static final RuntimeMessage$ResponseCase b;
    public static final RuntimeMessage$ResponseCase c;
    public static final /* synthetic */ RuntimeMessage$ResponseCase[] d;

    static {
        RuntimeMessage$ResponseCase runtimeMessage$ResponseCase = new RuntimeMessage$ResponseCase("GET_STORE_RESPONSE", 0);
        f4254a = runtimeMessage$ResponseCase;
        RuntimeMessage$ResponseCase runtimeMessage$ResponseCase2 = new RuntimeMessage$ResponseCase("ERROR", 1);
        b = runtimeMessage$ResponseCase2;
        RuntimeMessage$ResponseCase runtimeMessage$ResponseCase3 = new RuntimeMessage$ResponseCase("RESPONSE_NOT_SET", 2);
        c = runtimeMessage$ResponseCase3;
        d = new RuntimeMessage$ResponseCase[]{runtimeMessage$ResponseCase, runtimeMessage$ResponseCase2, runtimeMessage$ResponseCase3};
    }

    public static RuntimeMessage$ResponseCase valueOf(String str) {
        return (RuntimeMessage$ResponseCase) Enum.valueOf(RuntimeMessage$ResponseCase.class, str);
    }

    public static RuntimeMessage$ResponseCase[] values() {
        return (RuntimeMessage$ResponseCase[]) d.clone();
    }
}
