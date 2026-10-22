package androidx.datastore.preferences.protobuf;

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
public final class s {

    /* renamed from: g, reason: collision with root package name */
    public static final s f942g;

    /* renamed from: h, reason: collision with root package name */
    public static final s f943h;

    /* renamed from: i, reason: collision with root package name */
    public static final s[] f944i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ s[] f945j;

    /* renamed from: f, reason: collision with root package name */
    public final int f946f;

    /* JADX INFO: Fake field, exist only in values array */
    s EF0;

    static {
        b0 b0Var = b0.f810j;
        s sVar = new s("DOUBLE", 0, 0, 1, b0Var);
        b0 b0Var2 = b0.f809i;
        s sVar2 = new s("FLOAT", 1, 1, 1, b0Var2);
        b0 b0Var3 = b0.f808h;
        s sVar3 = new s("INT64", 2, 2, 1, b0Var3);
        s sVar4 = new s("UINT64", 3, 3, 1, b0Var3);
        b0 b0Var4 = b0.f807g;
        s sVar5 = new s("INT32", 4, 4, 1, b0Var4);
        s sVar6 = new s("FIXED64", 5, 5, 1, b0Var3);
        s sVar7 = new s("FIXED32", 6, 6, 1, b0Var4);
        b0 b0Var5 = b0.f811k;
        s sVar8 = new s("BOOL", 7, 7, 1, b0Var5);
        b0 b0Var6 = b0.f812l;
        s sVar9 = new s("STRING", 8, 8, 1, b0Var6);
        b0 b0Var7 = b0.f815o;
        s sVar10 = new s("MESSAGE", 9, 9, 1, b0Var7);
        b0 b0Var8 = b0.f813m;
        s sVar11 = new s("BYTES", 10, 10, 1, b0Var8);
        s sVar12 = new s("UINT32", 11, 11, 1, b0Var4);
        b0 b0Var9 = b0.f814n;
        s sVar13 = new s("ENUM", 12, 12, 1, b0Var9);
        s sVar14 = new s("SFIXED32", 13, 13, 1, b0Var4);
        s sVar15 = new s("SFIXED64", 14, 14, 1, b0Var3);
        s sVar16 = new s("SINT32", 15, 15, 1, b0Var4);
        s sVar17 = new s("SINT64", 16, 16, 1, b0Var3);
        s sVar18 = new s("GROUP", 17, 17, 1, b0Var7);
        s sVar19 = new s("DOUBLE_LIST", 18, 18, 2, b0Var);
        s sVar20 = new s("FLOAT_LIST", 19, 19, 2, b0Var2);
        s sVar21 = new s("INT64_LIST", 20, 20, 2, b0Var3);
        s sVar22 = new s("UINT64_LIST", 21, 21, 2, b0Var3);
        s sVar23 = new s("INT32_LIST", 22, 22, 2, b0Var4);
        s sVar24 = new s("FIXED64_LIST", 23, 23, 2, b0Var3);
        s sVar25 = new s("FIXED32_LIST", 24, 24, 2, b0Var4);
        s sVar26 = new s("BOOL_LIST", 25, 25, 2, b0Var5);
        s sVar27 = new s("STRING_LIST", 26, 26, 2, b0Var6);
        s sVar28 = new s("MESSAGE_LIST", 27, 27, 2, b0Var7);
        s sVar29 = new s("BYTES_LIST", 28, 28, 2, b0Var8);
        s sVar30 = new s("UINT32_LIST", 29, 29, 2, b0Var4);
        s sVar31 = new s("ENUM_LIST", 30, 30, 2, b0Var9);
        s sVar32 = new s("SFIXED32_LIST", 31, 31, 2, b0Var4);
        s sVar33 = new s("SFIXED64_LIST", 32, 32, 2, b0Var3);
        s sVar34 = new s("SINT32_LIST", 33, 33, 2, b0Var4);
        s sVar35 = new s("SINT64_LIST", 34, 34, 2, b0Var3);
        s sVar36 = new s("DOUBLE_LIST_PACKED", 35, 35, 3, b0Var);
        f942g = sVar36;
        s sVar37 = new s("FLOAT_LIST_PACKED", 36, 36, 3, b0Var2);
        s sVar38 = new s("INT64_LIST_PACKED", 37, 37, 3, b0Var3);
        s sVar39 = new s("UINT64_LIST_PACKED", 38, 38, 3, b0Var3);
        s sVar40 = new s("INT32_LIST_PACKED", 39, 39, 3, b0Var4);
        s sVar41 = new s("FIXED64_LIST_PACKED", 40, 40, 3, b0Var3);
        s sVar42 = new s("FIXED32_LIST_PACKED", 41, 41, 3, b0Var4);
        s sVar43 = new s("BOOL_LIST_PACKED", 42, 42, 3, b0Var5);
        s sVar44 = new s("UINT32_LIST_PACKED", 43, 43, 3, b0Var4);
        s sVar45 = new s("ENUM_LIST_PACKED", 44, 44, 3, b0Var9);
        s sVar46 = new s("SFIXED32_LIST_PACKED", 45, 45, 3, b0Var4);
        s sVar47 = new s("SFIXED64_LIST_PACKED", 46, 46, 3, b0Var3);
        s sVar48 = new s("SINT32_LIST_PACKED", 47, 47, 3, b0Var4);
        s sVar49 = new s("SINT64_LIST_PACKED", 48, 48, 3, b0Var3);
        f943h = sVar49;
        f945j = new s[]{sVar, sVar2, sVar3, sVar4, sVar5, sVar6, sVar7, sVar8, sVar9, sVar10, sVar11, sVar12, sVar13, sVar14, sVar15, sVar16, sVar17, sVar18, sVar19, sVar20, sVar21, sVar22, sVar23, sVar24, sVar25, sVar26, sVar27, sVar28, sVar29, sVar30, sVar31, sVar32, sVar33, sVar34, sVar35, sVar36, sVar37, sVar38, sVar39, sVar40, sVar41, sVar42, sVar43, sVar44, sVar45, sVar46, sVar47, sVar48, sVar49, new s("GROUP_LIST", 49, 49, 2, b0Var7), new s("MAP", 50, 50, 4, b0.f806f)};
        s[] sVarArrValues = values();
        f944i = new s[sVarArrValues.length];
        for (s sVar50 : sVarArrValues) {
            f944i[sVar50.f946f] = sVar50;
        }
    }

    public s(String str, int i2, int i10, int i11, b0 b0Var) {
        this.f946f = i10;
        int iD = n.f.d(i11);
        if (iD == 1 || iD == 3) {
            b0Var.getClass();
        }
        if (i11 == 1) {
            b0Var.ordinal();
        }
    }

    public static s valueOf(String str) {
        return (s) Enum.valueOf(s.class, str);
    }

    public static s[] values() {
        return (s[]) f945j.clone();
    }
}
