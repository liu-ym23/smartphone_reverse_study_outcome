package b0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: f, reason: collision with root package name */
    public static final t0 f1370f;

    /* renamed from: g, reason: collision with root package name */
    public static final t0 f1371g;

    /* renamed from: h, reason: collision with root package name */
    public static final t0 f1372h;

    /* renamed from: i, reason: collision with root package name */
    public static final t0 f1373i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ t0[] f1374j;

    static {
        t0 t0Var = new t0("IGNORED", 0);
        f1370f = t0Var;
        t0 t0Var2 = new t0("SCHEDULED", 1);
        f1371g = t0Var2;
        t0 t0Var3 = new t0("DEFERRED", 2);
        f1372h = t0Var3;
        t0 t0Var4 = new t0("IMMINENT", 3);
        f1373i = t0Var4;
        t0[] t0VarArr = {t0Var, t0Var2, t0Var3, t0Var4};
        f1374j = t0VarArr;
        w7.e0.s(t0VarArr);
    }

    public static t0 valueOf(String str) {
        return (t0) Enum.valueOf(t0.class, str);
    }

    public static t0[] values() {
        return (t0[]) f1374j.clone();
    }
}
