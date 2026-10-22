package androidx.datastore.preferences.protobuf;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF12' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public class H0 {

    /* renamed from: c, reason: collision with root package name */
    public static final D0 f3411c;

    /* renamed from: d, reason: collision with root package name */
    public static final E0 f3412d;

    /* renamed from: e, reason: collision with root package name */
    public static final F0 f3413e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ H0[] f3414f;

    /* renamed from: a, reason: collision with root package name */
    public final I0 f3415a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3416b;

    /* JADX INFO: Fake field, exist only in values array */
    H0 EF10;

    /* JADX INFO: Fake field, exist only in values array */
    H0 EF11;

    /* JADX INFO: Fake field, exist only in values array */
    H0 EF12;

    static {
        H0 h02 = new H0("DOUBLE", 0, I0.f3420e, 1);
        H0 h03 = new H0("FLOAT", 1, I0.f3419d, 5);
        I0 i02 = I0.f3418c;
        H0 h04 = new H0("INT64", 2, i02, 0);
        H0 h05 = new H0("UINT64", 3, i02, 0);
        I0 i03 = I0.f3417b;
        H0 h06 = new H0("INT32", 4, i03, 0);
        H0 h07 = new H0("FIXED64", 5, i02, 1);
        H0 h08 = new H0("FIXED32", 6, i03, 5);
        H0 h09 = new H0("BOOL", 7, I0.f3421f, 0);
        D0 d02 = new D0("STRING", 8, I0.f3422g, 2);
        f3411c = d02;
        I0 i04 = I0.f3425j;
        E0 e02 = new E0("GROUP", 9, i04, 3);
        f3412d = e02;
        F0 f02 = new F0("MESSAGE", 10, i04, 2);
        f3413e = f02;
        f3414f = new H0[]{h02, h03, h04, h05, h06, h07, h08, h09, d02, e02, f02, new G0("BYTES", 11, I0.f3423h, 2), new H0("UINT32", 12, i03, 0), new H0("ENUM", 13, I0.f3424i, 0), new H0("SFIXED32", 14, i03, 5), new H0("SFIXED64", 15, i02, 1), new H0("SINT32", 16, i03, 0), new H0("SINT64", 17, i02, 0)};
    }

    public H0(String str, int i4, I0 i02, int i5) {
        this.f3415a = i02;
        this.f3416b = i5;
    }

    public static H0 valueOf(String str) {
        return (H0) Enum.valueOf(H0.class, str);
    }

    public static H0[] values() {
        return (H0[]) f3414f.clone();
    }
}
