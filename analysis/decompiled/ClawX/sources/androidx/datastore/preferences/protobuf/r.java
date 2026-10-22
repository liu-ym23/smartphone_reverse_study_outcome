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
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: b, reason: collision with root package name */
    public static final r f555b;

    /* renamed from: c, reason: collision with root package name */
    public static final r f556c;
    public static final r[] d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ r[] f557e;

    /* renamed from: a, reason: collision with root package name */
    public final int f558a;

    /* JADX INFO: Fake field, exist only in values array */
    r EF0;

    static {
        a0 a0Var = a0.f443e;
        r rVar = new r("DOUBLE", 0, 0, 1, a0Var);
        a0 a0Var2 = a0.d;
        r rVar2 = new r("FLOAT", 1, 1, 1, a0Var2);
        a0 a0Var3 = a0.f442c;
        r rVar3 = new r("INT64", 2, 2, 1, a0Var3);
        r rVar4 = new r("UINT64", 3, 3, 1, a0Var3);
        a0 a0Var4 = a0.f441b;
        r rVar5 = new r("INT32", 4, 4, 1, a0Var4);
        r rVar6 = new r("FIXED64", 5, 5, 1, a0Var3);
        r rVar7 = new r("FIXED32", 6, 6, 1, a0Var4);
        a0 a0Var5 = a0.f444f;
        r rVar8 = new r("BOOL", 7, 7, 1, a0Var5);
        a0 a0Var6 = a0.f445g;
        r rVar9 = new r("STRING", 8, 8, 1, a0Var6);
        a0 a0Var7 = a0.f448k;
        r rVar10 = new r("MESSAGE", 9, 9, 1, a0Var7);
        a0 a0Var8 = a0.f446h;
        r rVar11 = new r("BYTES", 10, 10, 1, a0Var8);
        r rVar12 = new r("UINT32", 11, 11, 1, a0Var4);
        a0 a0Var9 = a0.f447j;
        r rVar13 = new r("ENUM", 12, 12, 1, a0Var9);
        r rVar14 = new r("SFIXED32", 13, 13, 1, a0Var4);
        r rVar15 = new r("SFIXED64", 14, 14, 1, a0Var3);
        r rVar16 = new r("SINT32", 15, 15, 1, a0Var4);
        r rVar17 = new r("SINT64", 16, 16, 1, a0Var3);
        r rVar18 = new r("GROUP", 17, 17, 1, a0Var7);
        r rVar19 = new r("DOUBLE_LIST", 18, 18, 2, a0Var);
        r rVar20 = new r("FLOAT_LIST", 19, 19, 2, a0Var2);
        r rVar21 = new r("INT64_LIST", 20, 20, 2, a0Var3);
        r rVar22 = new r("UINT64_LIST", 21, 21, 2, a0Var3);
        r rVar23 = new r("INT32_LIST", 22, 22, 2, a0Var4);
        r rVar24 = new r("FIXED64_LIST", 23, 23, 2, a0Var3);
        r rVar25 = new r("FIXED32_LIST", 24, 24, 2, a0Var4);
        r rVar26 = new r("BOOL_LIST", 25, 25, 2, a0Var5);
        r rVar27 = new r("STRING_LIST", 26, 26, 2, a0Var6);
        r rVar28 = new r("MESSAGE_LIST", 27, 27, 2, a0Var7);
        r rVar29 = new r("BYTES_LIST", 28, 28, 2, a0Var8);
        r rVar30 = new r("UINT32_LIST", 29, 29, 2, a0Var4);
        r rVar31 = new r("ENUM_LIST", 30, 30, 2, a0Var9);
        r rVar32 = new r("SFIXED32_LIST", 31, 31, 2, a0Var4);
        r rVar33 = new r("SFIXED64_LIST", 32, 32, 2, a0Var3);
        r rVar34 = new r("SINT32_LIST", 33, 33, 2, a0Var4);
        r rVar35 = new r("SINT64_LIST", 34, 34, 2, a0Var3);
        r rVar36 = new r("DOUBLE_LIST_PACKED", 35, 35, 3, a0Var);
        f555b = rVar36;
        r rVar37 = new r("FLOAT_LIST_PACKED", 36, 36, 3, a0Var2);
        r rVar38 = new r("INT64_LIST_PACKED", 37, 37, 3, a0Var3);
        r rVar39 = new r("UINT64_LIST_PACKED", 38, 38, 3, a0Var3);
        r rVar40 = new r("INT32_LIST_PACKED", 39, 39, 3, a0Var4);
        r rVar41 = new r("FIXED64_LIST_PACKED", 40, 40, 3, a0Var3);
        r rVar42 = new r("FIXED32_LIST_PACKED", 41, 41, 3, a0Var4);
        r rVar43 = new r("BOOL_LIST_PACKED", 42, 42, 3, a0Var5);
        r rVar44 = new r("UINT32_LIST_PACKED", 43, 43, 3, a0Var4);
        r rVar45 = new r("ENUM_LIST_PACKED", 44, 44, 3, a0Var9);
        r rVar46 = new r("SFIXED32_LIST_PACKED", 45, 45, 3, a0Var4);
        r rVar47 = new r("SFIXED64_LIST_PACKED", 46, 46, 3, a0Var3);
        r rVar48 = new r("SINT32_LIST_PACKED", 47, 47, 3, a0Var4);
        r rVar49 = new r("SINT64_LIST_PACKED", 48, 48, 3, a0Var3);
        f556c = rVar49;
        f557e = new r[]{rVar, rVar2, rVar3, rVar4, rVar5, rVar6, rVar7, rVar8, rVar9, rVar10, rVar11, rVar12, rVar13, rVar14, rVar15, rVar16, rVar17, rVar18, rVar19, rVar20, rVar21, rVar22, rVar23, rVar24, rVar25, rVar26, rVar27, rVar28, rVar29, rVar30, rVar31, rVar32, rVar33, rVar34, rVar35, rVar36, rVar37, rVar38, rVar39, rVar40, rVar41, rVar42, rVar43, rVar44, rVar45, rVar46, rVar47, rVar48, rVar49, new r("GROUP_LIST", 49, 49, 2, a0Var7), new r("MAP", 50, 50, 4, a0.f440a)};
        r[] rVarArrValues = values();
        d = new r[rVarArrValues.length];
        for (r rVar50 : rVarArrValues) {
            d[rVar50.f558a] = rVar50;
        }
    }

    public r(String str, int i8, int i9, int i10, a0 a0Var) {
        this.f558a = i9;
        int iA = m.f.a(i10);
        if (iA == 1 || iA == 3) {
            a0Var.getClass();
        }
        if (i10 == 1) {
            a0Var.ordinal();
        }
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f557e.clone();
    }
}
