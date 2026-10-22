package u1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: c, reason: collision with root package name */
    public static final c0 f13736c;

    /* renamed from: f, reason: collision with root package name */
    public static final c0 f13737f;

    /* renamed from: g, reason: collision with root package name */
    public static final c0 f13738g;

    /* renamed from: h, reason: collision with root package name */
    public static final c0 f13739h;
    public static final c0 i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ c0[] f13740j;

    static {
        c0 c0Var = new c0("Measuring", 0);
        f13736c = c0Var;
        c0 c0Var2 = new c0("LookaheadMeasuring", 1);
        f13737f = c0Var2;
        c0 c0Var3 = new c0("LayingOut", 2);
        f13738g = c0Var3;
        c0 c0Var4 = new c0("LookaheadLayingOut", 3);
        f13739h = c0Var4;
        c0 c0Var5 = new c0("Idle", 4);
        i = c0Var5;
        c0[] c0VarArr = {c0Var, c0Var2, c0Var3, c0Var4, c0Var5};
        f13740j = c0VarArr;
        a.a.p(c0VarArr);
    }

    public static c0 valueOf(String str) {
        return (c0) Enum.valueOf(c0.class, str);
    }

    public static c0[] values() {
        return (c0[]) f13740j.clone();
    }
}
