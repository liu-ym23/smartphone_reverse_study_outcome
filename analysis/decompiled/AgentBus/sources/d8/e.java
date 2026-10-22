package d8;

import c8.n;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'k' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: h, reason: collision with root package name */
    public static final s9.d f2993h;

    /* renamed from: i, reason: collision with root package name */
    public static final e f2994i;

    /* renamed from: j, reason: collision with root package name */
    public static final e f2995j;

    /* renamed from: k, reason: collision with root package name */
    public static final e f2996k;

    /* renamed from: l, reason: collision with root package name */
    public static final e f2997l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ e[] f2998m;

    /* renamed from: f, reason: collision with root package name */
    public final e9.c f2999f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3000g;

    static {
        e eVar = new e("Function", 0, n.f2066k, "Function");
        f2994i = eVar;
        e eVar2 = new e("SuspendFunction", 1, n.f2060e, "SuspendFunction");
        f2995j = eVar2;
        e9.c cVar = n.f2063h;
        e eVar3 = new e("KFunction", 2, cVar, "KFunction");
        f2996k = eVar3;
        e eVar4 = new e("KSuspendFunction", 3, cVar, "KSuspendFunction");
        f2997l = eVar4;
        f2998m = new e[]{eVar, eVar2, eVar3, eVar4};
        f2993h = new s9.d(16);
    }

    public e(String str, int i2, e9.c cVar, String str2) {
        this.f2999f = cVar;
        this.f3000g = str2;
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f2998m.clone();
    }

    public final e9.f a(int i2) {
        return e9.f.e(this.f3000g + i2);
    }
}
