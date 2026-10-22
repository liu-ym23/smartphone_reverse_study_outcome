package la;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: f, reason: collision with root package name */
    public static final m0 f5958f;

    /* renamed from: g, reason: collision with root package name */
    public static final m0 f5959g;

    /* renamed from: h, reason: collision with root package name */
    public static final m0 f5960h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ m0[] f5961i;

    static {
        m0 m0Var = new m0("START", 0);
        f5958f = m0Var;
        m0 m0Var2 = new m0("STOP", 1);
        f5959g = m0Var2;
        m0 m0Var3 = new m0("STOP_AND_RESET_REPLAY_CACHE", 2);
        f5960h = m0Var3;
        m0[] m0VarArr = {m0Var, m0Var2, m0Var3};
        f5961i = m0VarArr;
        w7.e0.s(m0VarArr);
    }

    public static m0 valueOf(String str) {
        return (m0) Enum.valueOf(m0.class, str);
    }

    public static m0[] values() {
        return (m0[]) f5961i.clone();
    }
}
