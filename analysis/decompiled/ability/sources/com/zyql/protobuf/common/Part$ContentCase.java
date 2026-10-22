package com.zyql.protobuf.common;

import com.stepos.ability.commoninternal.CallType;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class Part$ContentCase {

    /* renamed from: a, reason: collision with root package name */
    public static final Part$ContentCase f4266a;
    public static final Part$ContentCase b;
    public static final Part$ContentCase c;
    public static final Part$ContentCase d;
    public static final Part$ContentCase e;
    public static final Part$ContentCase f;
    public static final /* synthetic */ Part$ContentCase[] g;

    static {
        Part$ContentCase part$ContentCase = new Part$ContentCase("TEXT", 0);
        f4266a = part$ContentCase;
        Part$ContentCase part$ContentCase2 = new Part$ContentCase("INLINE_DATA", 1);
        b = part$ContentCase2;
        Part$ContentCase part$ContentCase3 = new Part$ContentCase(CallType.FUNCTION_CALL, 2);
        c = part$ContentCase3;
        Part$ContentCase part$ContentCase4 = new Part$ContentCase("FUNCTION_RESPONSE", 3);
        d = part$ContentCase4;
        Part$ContentCase part$ContentCase5 = new Part$ContentCase("FILE_DATA", 4);
        e = part$ContentCase5;
        Part$ContentCase part$ContentCase6 = new Part$ContentCase("CONTENT_NOT_SET", 5);
        f = part$ContentCase6;
        g = new Part$ContentCase[]{part$ContentCase, part$ContentCase2, part$ContentCase3, part$ContentCase4, part$ContentCase5, part$ContentCase6};
    }

    public static Part$ContentCase valueOf(String str) {
        return (Part$ContentCase) Enum.valueOf(Part$ContentCase.class, str);
    }

    public static Part$ContentCase[] values() {
        return (Part$ContentCase[]) g.clone();
    }
}
