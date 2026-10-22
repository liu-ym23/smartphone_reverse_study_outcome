package i1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: f, reason: collision with root package name */
    public static final o0 f4553f;

    /* renamed from: g, reason: collision with root package name */
    public static final o0 f4554g;

    /* renamed from: h, reason: collision with root package name */
    public static final o0 f4555h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ o0[] f4556i;

    static {
        o0 o0Var = new o0("IsPlacedInLookahead", 0);
        f4553f = o0Var;
        o0 o0Var2 = new o0("IsPlacedInApproach", 1);
        f4554g = o0Var2;
        o0 o0Var3 = new o0("IsNotPlaced", 2);
        f4555h = o0Var3;
        o0[] o0VarArr = {o0Var, o0Var2, o0Var3};
        f4556i = o0VarArr;
        w7.e0.s(o0VarArr);
    }

    public static o0 valueOf(String str) {
        return (o0) Enum.valueOf(o0.class, str);
    }

    public static o0[] values() {
        return (o0[]) f4556i.clone();
    }
}
