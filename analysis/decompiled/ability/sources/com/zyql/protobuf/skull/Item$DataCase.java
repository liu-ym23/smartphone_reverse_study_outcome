package com.zyql.protobuf.skull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class Item$DataCase {

    /* renamed from: a, reason: collision with root package name */
    public static final Item$DataCase f4280a;
    public static final Item$DataCase b;
    public static final Item$DataCase c;
    public static final Item$DataCase d;
    public static final Item$DataCase e;
    public static final Item$DataCase f;
    public static final /* synthetic */ Item$DataCase[] g;

    static {
        Item$DataCase item$DataCase = new Item$DataCase("MESSAGE", 0);
        f4280a = item$DataCase;
        Item$DataCase item$DataCase2 = new Item$DataCase("TOOL_CALL", 1);
        b = item$DataCase2;
        Item$DataCase item$DataCase3 = new Item$DataCase("ASK_INPUT", 2);
        c = item$DataCase3;
        Item$DataCase item$DataCase4 = new Item$DataCase("INTERRUPT", 3);
        d = item$DataCase4;
        Item$DataCase item$DataCase5 = new Item$DataCase("HANDOFF", 4);
        e = item$DataCase5;
        Item$DataCase item$DataCase6 = new Item$DataCase("DATA_NOT_SET", 5);
        f = item$DataCase6;
        g = new Item$DataCase[]{item$DataCase, item$DataCase2, item$DataCase3, item$DataCase4, item$DataCase5, item$DataCase6};
    }

    public static Item$DataCase valueOf(String str) {
        return (Item$DataCase) Enum.valueOf(Item$DataCase.class, str);
    }

    public static Item$DataCase[] values() {
        return (Item$DataCase[]) g.clone();
    }
}
