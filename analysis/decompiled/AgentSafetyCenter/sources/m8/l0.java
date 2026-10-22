package m8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: c, reason: collision with root package name */
    public static final l0 f8440c;

    /* renamed from: f, reason: collision with root package name */
    public static final l0 f8441f;

    /* renamed from: g, reason: collision with root package name */
    public static final l0 f8442g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ l0[] f8443h;

    static {
        l0 l0Var = new l0("PENDING", 0);
        f8440c = l0Var;
        l0 l0Var2 = new l0("SECURITY_LOG_API", 1);
        f8441f = l0Var2;
        l0 l0Var3 = new l0("LOCAL_DB", 2);
        f8442g = l0Var3;
        l0[] l0VarArr = {l0Var, l0Var2, l0Var3, new l0("ACCEPTANCE_PREVIEW", 3)};
        f8443h = l0VarArr;
        a.a.p(l0VarArr);
    }

    public static l0 valueOf(String str) {
        return (l0) Enum.valueOf(l0.class, str);
    }

    public static l0[] values() {
        return (l0[]) f8443h.clone();
    }
}
