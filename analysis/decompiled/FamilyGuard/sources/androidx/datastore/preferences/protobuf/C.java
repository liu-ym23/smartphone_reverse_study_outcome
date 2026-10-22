package androidx.datastore.preferences.protobuf;

import org.libpag.BuildConfig;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class C {

    /* renamed from: d, reason: collision with root package name */
    public static final C f9911d;

    /* renamed from: e, reason: collision with root package name */
    public static final C f9912e;

    /* renamed from: f, reason: collision with root package name */
    public static final C f9913f;

    /* renamed from: g, reason: collision with root package name */
    public static final C f9914g;

    /* renamed from: h, reason: collision with root package name */
    public static final C f9915h;

    /* renamed from: i, reason: collision with root package name */
    public static final C f9916i;

    /* renamed from: j, reason: collision with root package name */
    public static final C f9917j;

    /* renamed from: k, reason: collision with root package name */
    public static final C f9918k;

    /* renamed from: l, reason: collision with root package name */
    public static final C f9919l;

    /* renamed from: m, reason: collision with root package name */
    public static final C f9920m;

    /* renamed from: n, reason: collision with root package name */
    private static final /* synthetic */ C[] f9921n;

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f9922a;

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f9923b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f9924c;

    static {
        C c6 = new C("VOID", 0, Void.class, Void.class, null);
        f9911d = c6;
        Class cls = Integer.TYPE;
        C c7 = new C("INT", 1, cls, Integer.class, 0);
        f9912e = c7;
        C c8 = new C("LONG", 2, Long.TYPE, Long.class, 0L);
        f9913f = c8;
        C c9 = new C("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f9914g = c9;
        C c10 = new C("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f9915h = c10;
        C c11 = new C("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f9916i = c11;
        C c12 = new C("STRING", 6, String.class, String.class, BuildConfig.FLAVOR);
        f9917j = c12;
        C c13 = new C("BYTE_STRING", 7, AbstractC0488h.class, AbstractC0488h.class, AbstractC0488h.f10009b);
        f9918k = c13;
        C c14 = new C("ENUM", 8, cls, Integer.class, null);
        f9919l = c14;
        C c15 = new C("MESSAGE", 9, Object.class, Object.class, null);
        f9920m = c15;
        f9921n = new C[]{c6, c7, c8, c9, c10, c11, c12, c13, c14, c15};
    }

    private C(String str, int i5, Class cls, Class cls2, Object obj) {
        this.f9922a = cls;
        this.f9923b = cls2;
        this.f9924c = obj;
    }

    public static C valueOf(String str) {
        return (C) Enum.valueOf(C.class, str);
    }

    public static C[] values() {
        return (C[]) f9921n.clone();
    }

    public Class<?> b() {
        return this.f9923b;
    }
}
