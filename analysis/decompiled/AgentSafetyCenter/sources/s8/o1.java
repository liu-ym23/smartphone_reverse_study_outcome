package s8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o1 {

    /* renamed from: c, reason: collision with root package name */
    public static final o1 f11836c;

    /* renamed from: f, reason: collision with root package name */
    public static final o1 f11837f;

    /* renamed from: g, reason: collision with root package name */
    public static final o1 f11838g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ o1[] f11839h;

    static {
        o1 o1Var = new o1("Safe", 0);
        f11836c = o1Var;
        o1 o1Var2 = new o1("Running", 1);
        f11837f = o1Var2;
        o1 o1Var3 = new o1("Attention", 2);
        f11838g = o1Var3;
        o1[] o1VarArr = {o1Var, o1Var2, o1Var3};
        f11839h = o1VarArr;
        a.a.p(o1VarArr);
    }

    public static o1 valueOf(String str) {
        return (o1) Enum.valueOf(o1.class, str);
    }

    public static o1[] values() {
        return (o1[]) f11839h.clone();
    }
}
