package g9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: c, reason: collision with root package name */
    public static final u0 f4624c;

    /* renamed from: f, reason: collision with root package name */
    public static final u0 f4625f;

    /* renamed from: g, reason: collision with root package name */
    public static final u0 f4626g;

    /* renamed from: h, reason: collision with root package name */
    public static final u0 f4627h;
    public static final /* synthetic */ u0[] i;

    static {
        u0 u0Var = new u0("OpenDialog", 0);
        f4624c = u0Var;
        u0 u0Var2 = new u0("SelectOption", 1);
        f4625f = u0Var2;
        u0 u0Var3 = new u0("ConfirmOption", 2);
        f4626g = u0Var3;
        u0 u0Var4 = new u0("DismissDialog", 3);
        f4627h = u0Var4;
        u0[] u0VarArr = {u0Var, u0Var2, u0Var3, u0Var4};
        i = u0VarArr;
        a.a.p(u0VarArr);
    }

    public static u0 valueOf(String str) {
        return (u0) Enum.valueOf(u0.class, str);
    }

    public static u0[] values() {
        return (u0[]) i.clone();
    }
}
