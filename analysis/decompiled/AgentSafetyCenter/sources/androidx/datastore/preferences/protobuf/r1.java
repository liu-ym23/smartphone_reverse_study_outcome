package androidx.datastore.preferences.protobuf;

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
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class r1 {

    /* renamed from: g, reason: collision with root package name */
    public static final n1 f1188g;

    /* renamed from: h, reason: collision with root package name */
    public static final o1 f1189h;
    public static final p1 i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ r1[] f1190j;

    /* renamed from: c, reason: collision with root package name */
    public final s1 f1191c;

    /* renamed from: f, reason: collision with root package name */
    public final int f1192f;

    /* JADX INFO: Fake field, exist only in values array */
    r1 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    r1 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    r1 EF2;

    static {
        r1 r1Var = new r1("DOUBLE", 0, s1.DOUBLE, 1);
        r1 r1Var2 = new r1("FLOAT", 1, s1.FLOAT, 5);
        s1 s1Var = s1.LONG;
        r1 r1Var3 = new r1("INT64", 2, s1Var, 0);
        r1 r1Var4 = new r1("UINT64", 3, s1Var, 0);
        s1 s1Var2 = s1.INT;
        r1 r1Var5 = new r1("INT32", 4, s1Var2, 0);
        r1 r1Var6 = new r1("FIXED64", 5, s1Var, 1);
        r1 r1Var7 = new r1("FIXED32", 6, s1Var2, 5);
        r1 r1Var8 = new r1("BOOL", 7, s1.BOOLEAN, 0);
        n1 n1Var = new n1("STRING", 8, s1.STRING, 2);
        f1188g = n1Var;
        s1 s1Var3 = s1.MESSAGE;
        o1 o1Var = new o1("GROUP", 9, s1Var3, 3);
        f1189h = o1Var;
        p1 p1Var = new p1("MESSAGE", 10, s1Var3, 2);
        i = p1Var;
        f1190j = new r1[]{r1Var, r1Var2, r1Var3, r1Var4, r1Var5, r1Var6, r1Var7, r1Var8, n1Var, o1Var, p1Var, new q1("BYTES", 11, s1.BYTE_STRING, 2), new r1("UINT32", 12, s1Var2, 0), new r1("ENUM", 13, s1.ENUM, 0), new r1("SFIXED32", 14, s1Var2, 5), new r1("SFIXED64", 15, s1Var, 1), new r1("SINT32", 16, s1Var2, 0), new r1("SINT64", 17, s1Var, 0)};
    }

    public r1(String str, int i3, s1 s1Var, int i10) {
        this.f1191c = s1Var;
        this.f1192f = i10;
    }

    public static r1 valueOf(String str) {
        return (r1) Enum.valueOf(r1.class, str);
    }

    public static r1[] values() {
        return (r1[]) f1190j.clone();
    }
}
