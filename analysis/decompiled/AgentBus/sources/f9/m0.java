package f9;

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
public class m0 {

    /* renamed from: h, reason: collision with root package name */
    public static final m0 f3572h;

    /* renamed from: i, reason: collision with root package name */
    public static final m0 f3573i;

    /* renamed from: j, reason: collision with root package name */
    public static final j0 f3574j;

    /* renamed from: k, reason: collision with root package name */
    public static final k0 f3575k;

    /* renamed from: l, reason: collision with root package name */
    public static final m0 f3576l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ m0[] f3577m;

    /* renamed from: f, reason: collision with root package name */
    public final n0 f3578f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3579g;

    /* JADX INFO: Fake field, exist only in values array */
    m0 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    m0 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    m0 EF2;

    static {
        m0 m0Var = new m0("DOUBLE", 0, n0.f3588j, 1);
        m0 m0Var2 = new m0("FLOAT", 1, n0.f3587i, 5);
        n0 n0Var = n0.f3586h;
        m0 m0Var3 = new m0("INT64", 2, n0Var, 0);
        m0 m0Var4 = new m0("UINT64", 3, n0Var, 0);
        n0 n0Var2 = n0.f3585g;
        m0 m0Var5 = new m0("INT32", 4, n0Var2, 0);
        f3572h = m0Var5;
        m0 m0Var6 = new m0("FIXED64", 5, n0Var, 1);
        m0 m0Var7 = new m0("FIXED32", 6, n0Var2, 5);
        m0 m0Var8 = new m0("BOOL", 7, n0.f3589k, 0);
        f3573i = m0Var8;
        i0 i0Var = new i0("STRING", 8, n0.f3590l, 2);
        n0 n0Var3 = n0.f3593o;
        j0 j0Var = new j0("GROUP", 9, n0Var3, 3);
        f3574j = j0Var;
        k0 k0Var = new k0("MESSAGE", 10, n0Var3, 2);
        f3575k = k0Var;
        l0 l0Var = new l0("BYTES", 11, n0.f3591m, 2);
        m0 m0Var9 = new m0("UINT32", 12, n0Var2, 0);
        m0 m0Var10 = new m0("ENUM", 13, n0.f3592n, 0);
        f3576l = m0Var10;
        f3577m = new m0[]{m0Var, m0Var2, m0Var3, m0Var4, m0Var5, m0Var6, m0Var7, m0Var8, i0Var, j0Var, k0Var, l0Var, m0Var9, m0Var10, new m0("SFIXED32", 14, n0Var2, 5), new m0("SFIXED64", 15, n0Var, 1), new m0("SINT32", 16, n0Var2, 0), new m0("SINT64", 17, n0Var, 0)};
    }

    public m0(String str, int i2, n0 n0Var, int i10) {
        this.f3578f = n0Var;
        this.f3579g = i10;
    }

    public static m0 valueOf(String str) {
        return (m0) Enum.valueOf(m0.class, str);
    }

    public static m0[] values() {
        return (m0[]) f3577m.clone();
    }

    public boolean a() {
        return !(this instanceof i0);
    }
}
