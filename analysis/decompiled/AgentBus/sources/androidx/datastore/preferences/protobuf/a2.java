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
/* loaded from: classes.dex */
public class a2 {

    /* renamed from: h, reason: collision with root package name */
    public static final w1 f799h;

    /* renamed from: i, reason: collision with root package name */
    public static final x1 f800i;

    /* renamed from: j, reason: collision with root package name */
    public static final y1 f801j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ a2[] f802k;

    /* renamed from: f, reason: collision with root package name */
    public final b2 f803f;

    /* renamed from: g, reason: collision with root package name */
    public final int f804g;

    /* JADX INFO: Fake field, exist only in values array */
    a2 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    a2 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    a2 EF2;

    static {
        a2 a2Var = new a2("DOUBLE", 0, b2.f827i, 1);
        a2 a2Var2 = new a2("FLOAT", 1, b2.f826h, 5);
        b2 b2Var = b2.f825g;
        a2 a2Var3 = new a2("INT64", 2, b2Var, 0);
        a2 a2Var4 = new a2("UINT64", 3, b2Var, 0);
        b2 b2Var2 = b2.f824f;
        a2 a2Var5 = new a2("INT32", 4, b2Var2, 0);
        a2 a2Var6 = new a2("FIXED64", 5, b2Var, 1);
        a2 a2Var7 = new a2("FIXED32", 6, b2Var2, 5);
        a2 a2Var8 = new a2("BOOL", 7, b2.f828j, 0);
        w1 w1Var = new w1("STRING", 8, b2.f829k, 2);
        f799h = w1Var;
        b2 b2Var3 = b2.f832n;
        x1 x1Var = new x1("GROUP", 9, b2Var3, 3);
        f800i = x1Var;
        y1 y1Var = new y1("MESSAGE", 10, b2Var3, 2);
        f801j = y1Var;
        f802k = new a2[]{a2Var, a2Var2, a2Var3, a2Var4, a2Var5, a2Var6, a2Var7, a2Var8, w1Var, x1Var, y1Var, new z1("BYTES", 11, b2.f830l, 2), new a2("UINT32", 12, b2Var2, 0), new a2("ENUM", 13, b2.f831m, 0), new a2("SFIXED32", 14, b2Var2, 5), new a2("SFIXED64", 15, b2Var, 1), new a2("SINT32", 16, b2Var2, 0), new a2("SINT64", 17, b2Var, 0)};
    }

    public a2(String str, int i2, b2 b2Var, int i10) {
        this.f803f = b2Var;
        this.f804g = i10;
    }

    public static a2 valueOf(String str) {
        return (a2) Enum.valueOf(a2.class, str);
    }

    public static a2[] values() {
        return (a2[]) f802k.clone();
    }
}
