package nc;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 {

    /* renamed from: c, reason: collision with root package name */
    public static final m0 f8883c;

    /* renamed from: f, reason: collision with root package name */
    public static final m0 f8884f;

    /* renamed from: g, reason: collision with root package name */
    public static final m0 f8885g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ m0[] f8886h;

    static {
        m0 m0Var = new m0("START", 0);
        f8883c = m0Var;
        m0 m0Var2 = new m0("STOP", 1);
        f8884f = m0Var2;
        m0 m0Var3 = new m0("STOP_AND_RESET_REPLAY_CACHE", 2);
        f8885g = m0Var3;
        m0[] m0VarArr = {m0Var, m0Var2, m0Var3};
        f8886h = m0VarArr;
        a.a.p(m0VarArr);
    }

    public static m0 valueOf(String str) {
        return (m0) Enum.valueOf(m0.class, str);
    }

    public static m0[] values() {
        return (m0[]) f8886h.clone();
    }
}
