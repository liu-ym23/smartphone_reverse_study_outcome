package ia;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: f, reason: collision with root package name */
    public static final c0 f4926f;

    /* renamed from: g, reason: collision with root package name */
    public static final c0 f4927g;

    /* renamed from: h, reason: collision with root package name */
    public static final c0 f4928h;

    /* renamed from: i, reason: collision with root package name */
    public static final c0 f4929i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ c0[] f4930j;

    static {
        c0 c0Var = new c0("DEFAULT", 0);
        f4926f = c0Var;
        c0 c0Var2 = new c0("LAZY", 1);
        f4927g = c0Var2;
        c0 c0Var3 = new c0("ATOMIC", 2);
        f4928h = c0Var3;
        c0 c0Var4 = new c0("UNDISPATCHED", 3);
        f4929i = c0Var4;
        c0[] c0VarArr = {c0Var, c0Var2, c0Var3, c0Var4};
        f4930j = c0VarArr;
        w7.e0.s(c0VarArr);
    }

    public static c0 valueOf(String str) {
        return (c0) Enum.valueOf(c0.class, str);
    }

    public static c0[] values() {
        return (c0[]) f4930j.clone();
    }
}
