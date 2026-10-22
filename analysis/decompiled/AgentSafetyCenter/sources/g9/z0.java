package g9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: c, reason: collision with root package name */
    public static final z0 f4660c;

    /* renamed from: f, reason: collision with root package name */
    public static final z0 f4661f;

    /* renamed from: g, reason: collision with root package name */
    public static final z0 f4662g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ z0[] f4663h;

    static {
        z0 z0Var = new z0("Allow", 0);
        f4660c = z0Var;
        z0 z0Var2 = new z0("AskOnSensitive", 1);
        f4661f = z0Var2;
        z0 z0Var3 = new z0("AskEveryTime", 2);
        f4662g = z0Var3;
        z0[] z0VarArr = {z0Var, z0Var2, z0Var3, new z0("Off", 3)};
        f4663h = z0VarArr;
        a.a.p(z0VarArr);
    }

    public static z0 valueOf(String str) {
        return (z0) Enum.valueOf(z0.class, str);
    }

    public static z0[] values() {
        return (z0[]) f4663h.clone();
    }
}
