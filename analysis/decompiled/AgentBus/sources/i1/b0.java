package i1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: f, reason: collision with root package name */
    public static final b0 f4408f;

    /* renamed from: g, reason: collision with root package name */
    public static final b0 f4409g;

    /* renamed from: h, reason: collision with root package name */
    public static final b0 f4410h;

    /* renamed from: i, reason: collision with root package name */
    public static final b0 f4411i;

    /* renamed from: j, reason: collision with root package name */
    public static final b0 f4412j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ b0[] f4413k;

    static {
        b0 b0Var = new b0("Measuring", 0);
        f4408f = b0Var;
        b0 b0Var2 = new b0("LookaheadMeasuring", 1);
        f4409g = b0Var2;
        b0 b0Var3 = new b0("LayingOut", 2);
        f4410h = b0Var3;
        b0 b0Var4 = new b0("LookaheadLayingOut", 3);
        f4411i = b0Var4;
        b0 b0Var5 = new b0("Idle", 4);
        f4412j = b0Var5;
        b0[] b0VarArr = {b0Var, b0Var2, b0Var3, b0Var4, b0Var5};
        f4413k = b0VarArr;
        w7.e0.s(b0VarArr);
    }

    public static b0 valueOf(String str) {
        return (b0) Enum.valueOf(b0.class, str);
    }

    public static b0[] values() {
        return (b0[]) f4413k.clone();
    }
}
