package com.google.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class c2 {

    /* renamed from: g, reason: collision with root package name */
    public static final c2 f2322g;

    /* renamed from: h, reason: collision with root package name */
    public static final c2 f2323h;

    /* renamed from: i, reason: collision with root package name */
    public static final c2[] f2324i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ c2[] f2325j;

    /* renamed from: f, reason: collision with root package name */
    public final int f2326f;

    /* JADX INFO: Fake field, exist only in values array */
    c2 EF0;

    static {
        t2 t2Var = t2.f2536j;
        c2 c2Var = new c2("DOUBLE", 0, 0, 1, t2Var);
        t2 t2Var2 = t2.f2535i;
        c2 c2Var2 = new c2("FLOAT", 1, 1, 1, t2Var2);
        t2 t2Var3 = t2.f2534h;
        c2 c2Var3 = new c2("INT64", 2, 2, 1, t2Var3);
        c2 c2Var4 = new c2("UINT64", 3, 3, 1, t2Var3);
        t2 t2Var4 = t2.f2533g;
        c2 c2Var5 = new c2("INT32", 4, 4, 1, t2Var4);
        c2 c2Var6 = new c2("FIXED64", 5, 5, 1, t2Var3);
        c2 c2Var7 = new c2("FIXED32", 6, 6, 1, t2Var4);
        t2 t2Var5 = t2.f2537k;
        c2 c2Var8 = new c2("BOOL", 7, 7, 1, t2Var5);
        t2 t2Var6 = t2.f2538l;
        c2 c2Var9 = new c2("STRING", 8, 8, 1, t2Var6);
        t2 t2Var7 = t2.f2541o;
        c2 c2Var10 = new c2("MESSAGE", 9, 9, 1, t2Var7);
        t2 t2Var8 = t2.f2539m;
        c2 c2Var11 = new c2("BYTES", 10, 10, 1, t2Var8);
        c2 c2Var12 = new c2("UINT32", 11, 11, 1, t2Var4);
        t2 t2Var9 = t2.f2540n;
        c2 c2Var13 = new c2("ENUM", 12, 12, 1, t2Var9);
        c2 c2Var14 = new c2("SFIXED32", 13, 13, 1, t2Var4);
        c2 c2Var15 = new c2("SFIXED64", 14, 14, 1, t2Var3);
        c2 c2Var16 = new c2("SINT32", 15, 15, 1, t2Var4);
        c2 c2Var17 = new c2("SINT64", 16, 16, 1, t2Var3);
        c2 c2Var18 = new c2("GROUP", 17, 17, 1, t2Var7);
        c2 c2Var19 = new c2("DOUBLE_LIST", 18, 18, 2, t2Var);
        c2 c2Var20 = new c2("FLOAT_LIST", 19, 19, 2, t2Var2);
        c2 c2Var21 = new c2("INT64_LIST", 20, 20, 2, t2Var3);
        c2 c2Var22 = new c2("UINT64_LIST", 21, 21, 2, t2Var3);
        c2 c2Var23 = new c2("INT32_LIST", 22, 22, 2, t2Var4);
        c2 c2Var24 = new c2("FIXED64_LIST", 23, 23, 2, t2Var3);
        c2 c2Var25 = new c2("FIXED32_LIST", 24, 24, 2, t2Var4);
        c2 c2Var26 = new c2("BOOL_LIST", 25, 25, 2, t2Var5);
        c2 c2Var27 = new c2("STRING_LIST", 26, 26, 2, t2Var6);
        c2 c2Var28 = new c2("MESSAGE_LIST", 27, 27, 2, t2Var7);
        c2 c2Var29 = new c2("BYTES_LIST", 28, 28, 2, t2Var8);
        c2 c2Var30 = new c2("UINT32_LIST", 29, 29, 2, t2Var4);
        c2 c2Var31 = new c2("ENUM_LIST", 30, 30, 2, t2Var9);
        c2 c2Var32 = new c2("SFIXED32_LIST", 31, 31, 2, t2Var4);
        c2 c2Var33 = new c2("SFIXED64_LIST", 32, 32, 2, t2Var3);
        c2 c2Var34 = new c2("SINT32_LIST", 33, 33, 2, t2Var4);
        c2 c2Var35 = new c2("SINT64_LIST", 34, 34, 2, t2Var3);
        c2 c2Var36 = new c2("DOUBLE_LIST_PACKED", 35, 35, 3, t2Var);
        f2322g = c2Var36;
        c2 c2Var37 = new c2("FLOAT_LIST_PACKED", 36, 36, 3, t2Var2);
        c2 c2Var38 = new c2("INT64_LIST_PACKED", 37, 37, 3, t2Var3);
        c2 c2Var39 = new c2("UINT64_LIST_PACKED", 38, 38, 3, t2Var3);
        c2 c2Var40 = new c2("INT32_LIST_PACKED", 39, 39, 3, t2Var4);
        c2 c2Var41 = new c2("FIXED64_LIST_PACKED", 40, 40, 3, t2Var3);
        c2 c2Var42 = new c2("FIXED32_LIST_PACKED", 41, 41, 3, t2Var4);
        c2 c2Var43 = new c2("BOOL_LIST_PACKED", 42, 42, 3, t2Var5);
        c2 c2Var44 = new c2("UINT32_LIST_PACKED", 43, 43, 3, t2Var4);
        c2 c2Var45 = new c2("ENUM_LIST_PACKED", 44, 44, 3, t2Var9);
        c2 c2Var46 = new c2("SFIXED32_LIST_PACKED", 45, 45, 3, t2Var4);
        c2 c2Var47 = new c2("SFIXED64_LIST_PACKED", 46, 46, 3, t2Var3);
        c2 c2Var48 = new c2("SINT32_LIST_PACKED", 47, 47, 3, t2Var4);
        c2 c2Var49 = new c2("SINT64_LIST_PACKED", 48, 48, 3, t2Var3);
        f2323h = c2Var49;
        f2325j = new c2[]{c2Var, c2Var2, c2Var3, c2Var4, c2Var5, c2Var6, c2Var7, c2Var8, c2Var9, c2Var10, c2Var11, c2Var12, c2Var13, c2Var14, c2Var15, c2Var16, c2Var17, c2Var18, c2Var19, c2Var20, c2Var21, c2Var22, c2Var23, c2Var24, c2Var25, c2Var26, c2Var27, c2Var28, c2Var29, c2Var30, c2Var31, c2Var32, c2Var33, c2Var34, c2Var35, c2Var36, c2Var37, c2Var38, c2Var39, c2Var40, c2Var41, c2Var42, c2Var43, c2Var44, c2Var45, c2Var46, c2Var47, c2Var48, c2Var49, new c2("GROUP_LIST", 49, 49, 2, t2Var7), new c2("MAP", 50, 50, 4, t2.f2532f)};
        c2[] c2VarArrValues = values();
        f2324i = new c2[c2VarArrValues.length];
        for (c2 c2Var50 : c2VarArrValues) {
            f2324i[c2Var50.f2326f] = c2Var50;
        }
    }

    public c2(String str, int i2, int i10, int i11, t2 t2Var) {
        this.f2326f = i10;
        int iD = n.f.d(i11);
        if (iD == 1 || iD == 3) {
            t2Var.getClass();
        }
        if (i11 == 1) {
            t2Var.ordinal();
        }
    }

    public static c2 valueOf(String str) {
        return (c2) Enum.valueOf(c2.class, str);
    }

    public static c2[] values() {
        return (c2[]) f2325j.clone();
    }
}
