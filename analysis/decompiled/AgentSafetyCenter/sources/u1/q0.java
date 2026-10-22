package u1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: c, reason: collision with root package name */
    public static final q0 f13906c;

    /* renamed from: f, reason: collision with root package name */
    public static final q0 f13907f;

    /* renamed from: g, reason: collision with root package name */
    public static final q0 f13908g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ q0[] f13909h;

    static {
        q0 q0Var = new q0("IsPlacedInLookahead", 0);
        f13906c = q0Var;
        q0 q0Var2 = new q0("IsPlacedInApproach", 1);
        f13907f = q0Var2;
        q0 q0Var3 = new q0("IsNotPlaced", 2);
        f13908g = q0Var3;
        q0[] q0VarArr = {q0Var, q0Var2, q0Var3};
        f13909h = q0VarArr;
        a.a.p(q0VarArr);
    }

    public static q0 valueOf(String str) {
        return (q0) Enum.valueOf(q0.class, str);
    }

    public static q0[] values() {
        return (q0[]) f13909h.clone();
    }
}
