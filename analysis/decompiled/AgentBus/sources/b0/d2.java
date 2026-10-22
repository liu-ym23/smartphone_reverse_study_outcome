package b0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class d2 {

    /* renamed from: f, reason: collision with root package name */
    public static final d2 f1123f;

    /* renamed from: g, reason: collision with root package name */
    public static final d2 f1124g;

    /* renamed from: h, reason: collision with root package name */
    public static final d2 f1125h;

    /* renamed from: i, reason: collision with root package name */
    public static final d2 f1126i;

    /* renamed from: j, reason: collision with root package name */
    public static final d2 f1127j;

    /* renamed from: k, reason: collision with root package name */
    public static final d2 f1128k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ d2[] f1129l;

    static {
        d2 d2Var = new d2("ShutDown", 0);
        f1123f = d2Var;
        d2 d2Var2 = new d2("ShuttingDown", 1);
        f1124g = d2Var2;
        d2 d2Var3 = new d2("Inactive", 2);
        f1125h = d2Var3;
        d2 d2Var4 = new d2("InactivePendingWork", 3);
        f1126i = d2Var4;
        d2 d2Var5 = new d2("Idle", 4);
        f1127j = d2Var5;
        d2 d2Var6 = new d2("PendingWork", 5);
        f1128k = d2Var6;
        d2[] d2VarArr = {d2Var, d2Var2, d2Var3, d2Var4, d2Var5, d2Var6};
        f1129l = d2VarArr;
        w7.e0.s(d2VarArr);
    }

    public static d2 valueOf(String str) {
        return (d2) Enum.valueOf(d2.class, str);
    }

    public static d2[] values() {
        return (d2[]) f1129l.clone();
    }
}
