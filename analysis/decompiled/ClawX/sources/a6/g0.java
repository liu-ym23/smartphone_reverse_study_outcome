package a6;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f162a;

    /* renamed from: b, reason: collision with root package name */
    public static final g0 f163b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ g0[] f164c;

    static {
        g0 g0Var = new g0("DEFAULT", 0);
        f162a = g0Var;
        g0 g0Var2 = new g0("LAZY", 1);
        g0 g0Var3 = new g0("ATOMIC", 2);
        f163b = g0Var3;
        g0[] g0VarArr = {g0Var, g0Var2, g0Var3, new g0("UNDISPATCHED", 3)};
        f164c = g0VarArr;
        a.a.F(g0VarArr);
    }

    public static g0 valueOf(String str) {
        return (g0) Enum.valueOf(g0.class, str);
    }

    public static g0[] values() {
        return (g0[]) f164c.clone();
    }
}
