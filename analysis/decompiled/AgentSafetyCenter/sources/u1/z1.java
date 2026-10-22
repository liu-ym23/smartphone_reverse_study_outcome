package u1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z1 {

    /* renamed from: c, reason: collision with root package name */
    public static final z1 f13977c;

    /* renamed from: f, reason: collision with root package name */
    public static final z1 f13978f;

    /* renamed from: g, reason: collision with root package name */
    public static final z1 f13979g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ z1[] f13980h;

    static {
        z1 z1Var = new z1("ContinueTraversal", 0);
        f13977c = z1Var;
        z1 z1Var2 = new z1("SkipSubtreeAndContinueTraversal", 1);
        f13978f = z1Var2;
        z1 z1Var3 = new z1("CancelTraversal", 2);
        f13979g = z1Var3;
        z1[] z1VarArr = {z1Var, z1Var2, z1Var3};
        f13980h = z1VarArr;
        a.a.p(z1VarArr);
    }

    public static z1 valueOf(String str) {
        return (z1) Enum.valueOf(z1.class, str);
    }

    public static z1[] values() {
        return (z1[]) f13980h.clone();
    }
}
