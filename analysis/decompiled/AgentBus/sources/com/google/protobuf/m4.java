package com.google.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class m4 {

    /* renamed from: f, reason: collision with root package name */
    public static final m4 f2442f;

    /* renamed from: g, reason: collision with root package name */
    public static final m4 f2443g;

    /* renamed from: h, reason: collision with root package name */
    public static final m4 f2444h;

    /* renamed from: i, reason: collision with root package name */
    public static final m4 f2445i;

    /* renamed from: j, reason: collision with root package name */
    public static final m4 f2446j;

    /* renamed from: k, reason: collision with root package name */
    public static final m4 f2447k;

    /* renamed from: l, reason: collision with root package name */
    public static final m4 f2448l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ m4[] f2449m;

    static {
        m4 m4Var = new m4("NULL_VALUE", 0);
        f2442f = m4Var;
        m4 m4Var2 = new m4("NUMBER_VALUE", 1);
        f2443g = m4Var2;
        m4 m4Var3 = new m4("STRING_VALUE", 2);
        f2444h = m4Var3;
        m4 m4Var4 = new m4("BOOL_VALUE", 3);
        f2445i = m4Var4;
        m4 m4Var5 = new m4("STRUCT_VALUE", 4);
        f2446j = m4Var5;
        m4 m4Var6 = new m4("LIST_VALUE", 5);
        f2447k = m4Var6;
        m4 m4Var7 = new m4("KIND_NOT_SET", 6);
        f2448l = m4Var7;
        f2449m = new m4[]{m4Var, m4Var2, m4Var3, m4Var4, m4Var5, m4Var6, m4Var7};
    }

    public static m4 valueOf(String str) {
        return (m4) Enum.valueOf(m4.class, str);
    }

    public static m4[] values() {
        return (m4[]) f2449m.clone();
    }
}
