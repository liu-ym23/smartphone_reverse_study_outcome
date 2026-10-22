package t;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: c, reason: collision with root package name */
    public static final u0 f13068c;

    /* renamed from: f, reason: collision with root package name */
    public static final u0 f13069f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ u0[] f13070g;

    static {
        u0 u0Var = new u0("Default", 0);
        f13068c = u0Var;
        u0 u0Var2 = new u0("UserInput", 1);
        f13069f = u0Var2;
        f13070g = new u0[]{u0Var, u0Var2, new u0("PreventUserInput", 2)};
    }

    public static u0 valueOf(String str) {
        return (u0) Enum.valueOf(u0.class, str);
    }

    public static u0[] values() {
        return (u0[]) f13070g.clone();
    }
}
