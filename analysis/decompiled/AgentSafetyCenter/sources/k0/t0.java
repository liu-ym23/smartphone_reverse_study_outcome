package k0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: c, reason: collision with root package name */
    public static final t0 f7068c;

    /* renamed from: f, reason: collision with root package name */
    public static final t0 f7069f;

    /* renamed from: g, reason: collision with root package name */
    public static final t0 f7070g;

    /* renamed from: h, reason: collision with root package name */
    public static final t0 f7071h;
    public static final /* synthetic */ t0[] i;

    static {
        t0 t0Var = new t0("IGNORED", 0);
        f7068c = t0Var;
        t0 t0Var2 = new t0("SCHEDULED", 1);
        f7069f = t0Var2;
        t0 t0Var3 = new t0("DEFERRED", 2);
        f7070g = t0Var3;
        t0 t0Var4 = new t0("IMMINENT", 3);
        f7071h = t0Var4;
        t0[] t0VarArr = {t0Var, t0Var2, t0Var3, t0Var4};
        i = t0VarArr;
        a.a.p(t0VarArr);
    }

    public static t0 valueOf(String str) {
        return (t0) Enum.valueOf(t0.class, str);
    }

    public static t0[] values() {
        return (t0[]) i.clone();
    }
}
