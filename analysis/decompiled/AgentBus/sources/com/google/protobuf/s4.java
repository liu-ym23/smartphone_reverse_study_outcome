package com.google.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public class s4 {

    /* renamed from: h, reason: collision with root package name */
    public static final o4 f2524h;

    /* renamed from: i, reason: collision with root package name */
    public static final p4 f2525i;

    /* renamed from: j, reason: collision with root package name */
    public static final q4 f2526j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ s4[] f2527k;

    /* renamed from: f, reason: collision with root package name */
    public final t4 f2528f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2529g;

    /* JADX INFO: Fake field, exist only in values array */
    s4 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    s4 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    s4 EF2;

    static {
        s4 s4Var = new s4("DOUBLE", 0, t4.f2546i, 1);
        s4 s4Var2 = new s4("FLOAT", 1, t4.f2545h, 5);
        t4 t4Var = t4.f2544g;
        s4 s4Var3 = new s4("INT64", 2, t4Var, 0);
        s4 s4Var4 = new s4("UINT64", 3, t4Var, 0);
        t4 t4Var2 = t4.f2543f;
        s4 s4Var5 = new s4("INT32", 4, t4Var2, 0);
        s4 s4Var6 = new s4("FIXED64", 5, t4Var, 1);
        s4 s4Var7 = new s4("FIXED32", 6, t4Var2, 5);
        s4 s4Var8 = new s4("BOOL", 7, t4.f2547j, 0);
        o4 o4Var = new o4("STRING", 8, t4.f2548k, 2);
        f2524h = o4Var;
        t4 t4Var3 = t4.f2551n;
        p4 p4Var = new p4("GROUP", 9, t4Var3, 3);
        f2525i = p4Var;
        q4 q4Var = new q4("MESSAGE", 10, t4Var3, 2);
        f2526j = q4Var;
        f2527k = new s4[]{s4Var, s4Var2, s4Var3, s4Var4, s4Var5, s4Var6, s4Var7, s4Var8, o4Var, p4Var, q4Var, new r4("BYTES", 11, t4.f2549l, 2), new s4("UINT32", 12, t4Var2, 0), new s4("ENUM", 13, t4.f2550m, 0), new s4("SFIXED32", 14, t4Var2, 5), new s4("SFIXED64", 15, t4Var, 1), new s4("SINT32", 16, t4Var2, 0), new s4("SINT64", 17, t4Var, 0)};
    }

    public s4(String str, int i2, t4 t4Var, int i10) {
        this.f2528f = t4Var;
        this.f2529g = i10;
    }

    public static s4 valueOf(String str) {
        return (s4) Enum.valueOf(s4.class, str);
    }

    public static s4[] values() {
        return (s4[]) f2527k.clone();
    }
}
