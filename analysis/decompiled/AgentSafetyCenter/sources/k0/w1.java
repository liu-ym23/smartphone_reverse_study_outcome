package k0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w1 {

    /* renamed from: c, reason: collision with root package name */
    public static final w1 f7100c;

    /* renamed from: f, reason: collision with root package name */
    public static final w1 f7101f;

    /* renamed from: g, reason: collision with root package name */
    public static final w1 f7102g;

    /* renamed from: h, reason: collision with root package name */
    public static final w1 f7103h;
    public static final w1 i;

    /* renamed from: j, reason: collision with root package name */
    public static final w1 f7104j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ w1[] f7105k;

    static {
        w1 w1Var = new w1("ShutDown", 0);
        f7100c = w1Var;
        w1 w1Var2 = new w1("ShuttingDown", 1);
        f7101f = w1Var2;
        w1 w1Var3 = new w1("Inactive", 2);
        f7102g = w1Var3;
        w1 w1Var4 = new w1("InactivePendingWork", 3);
        f7103h = w1Var4;
        w1 w1Var5 = new w1("Idle", 4);
        i = w1Var5;
        w1 w1Var6 = new w1("PendingWork", 5);
        f7104j = w1Var6;
        w1[] w1VarArr = {w1Var, w1Var2, w1Var3, w1Var4, w1Var5, w1Var6};
        f7105k = w1VarArr;
        a.a.p(w1VarArr);
    }

    public static w1 valueOf(String str) {
        return (w1) Enum.valueOf(w1.class, str);
    }

    public static w1[] values() {
        return (w1[]) f7105k.clone();
    }
}
