package com.google.protobuf;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class t4 {

    /* renamed from: f, reason: collision with root package name */
    public static final t4 f2543f;

    /* renamed from: g, reason: collision with root package name */
    public static final t4 f2544g;

    /* renamed from: h, reason: collision with root package name */
    public static final t4 f2545h;

    /* renamed from: i, reason: collision with root package name */
    public static final t4 f2546i;

    /* renamed from: j, reason: collision with root package name */
    public static final t4 f2547j;

    /* renamed from: k, reason: collision with root package name */
    public static final t4 f2548k;

    /* renamed from: l, reason: collision with root package name */
    public static final t4 f2549l;

    /* renamed from: m, reason: collision with root package name */
    public static final t4 f2550m;

    /* renamed from: n, reason: collision with root package name */
    public static final t4 f2551n;

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ t4[] f2552o;

    static {
        t4 t4Var = new t4("INT", 0);
        f2543f = t4Var;
        t4 t4Var2 = new t4("LONG", 1);
        f2544g = t4Var2;
        t4 t4Var3 = new t4("FLOAT", 2);
        f2545h = t4Var3;
        t4 t4Var4 = new t4("DOUBLE", 3);
        f2546i = t4Var4;
        t4 t4Var5 = new t4("BOOLEAN", 4);
        f2547j = t4Var5;
        t4 t4Var6 = new t4("STRING", 5);
        f2548k = t4Var6;
        k kVar = l.f2424g;
        t4 t4Var7 = new t4("BYTE_STRING", 6);
        f2549l = t4Var7;
        t4 t4Var8 = new t4("ENUM", 7);
        f2550m = t4Var8;
        t4 t4Var9 = new t4("MESSAGE", 8);
        f2551n = t4Var9;
        f2552o = new t4[]{t4Var, t4Var2, t4Var3, t4Var4, t4Var5, t4Var6, t4Var7, t4Var8, t4Var9};
    }

    public static t4 valueOf(String str) {
        return (t4) Enum.valueOf(t4.class, str);
    }

    public static t4[] values() {
        return (t4[]) f2552o.clone();
    }
}
