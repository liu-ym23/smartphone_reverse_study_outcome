package k0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n1 {

    /* renamed from: c, reason: collision with root package name */
    public static final n1 f6982c;

    /* renamed from: f, reason: collision with root package name */
    public static final n1 f6983f;

    /* renamed from: g, reason: collision with root package name */
    public static final n1 f6984g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ n1[] f6985h;

    static {
        n1 n1Var = new n1("Invalid", 0);
        n1 n1Var2 = new n1("Cancelled", 1);
        f6982c = n1Var2;
        n1 n1Var3 = new n1("InitialPending", 2);
        n1 n1Var4 = new n1("RecomposePending", 3);
        n1 n1Var5 = new n1("Recomposing", 4);
        f6983f = n1Var5;
        n1 n1Var6 = new n1("ApplyPending", 5);
        f6984g = n1Var6;
        n1[] n1VarArr = {n1Var, n1Var2, n1Var3, n1Var4, n1Var5, n1Var6, new n1("Applied", 6)};
        f6985h = n1VarArr;
        a.a.p(n1VarArr);
    }

    public static n1 valueOf(String str) {
        return (n1) Enum.valueOf(n1.class, str);
    }

    public static n1[] values() {
        return (n1[]) f6985h.clone();
    }
}
