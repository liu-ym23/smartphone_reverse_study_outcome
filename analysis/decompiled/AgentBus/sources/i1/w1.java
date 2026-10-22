package i1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class w1 {

    /* renamed from: f, reason: collision with root package name */
    public static final w1 f4626f;

    /* renamed from: g, reason: collision with root package name */
    public static final w1 f4627g;

    /* renamed from: h, reason: collision with root package name */
    public static final w1 f4628h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ w1[] f4629i;

    static {
        w1 w1Var = new w1("ContinueTraversal", 0);
        f4626f = w1Var;
        w1 w1Var2 = new w1("SkipSubtreeAndContinueTraversal", 1);
        f4627g = w1Var2;
        w1 w1Var3 = new w1("CancelTraversal", 2);
        f4628h = w1Var3;
        w1[] w1VarArr = {w1Var, w1Var2, w1Var3};
        f4629i = w1VarArr;
        w7.e0.s(w1VarArr);
    }

    public static w1 valueOf(String str) {
        return (w1) Enum.valueOf(w1.class, str);
    }

    public static w1[] values() {
        return (w1[]) f4629i.clone();
    }
}
