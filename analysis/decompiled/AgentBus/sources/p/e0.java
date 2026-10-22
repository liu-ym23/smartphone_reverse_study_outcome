package p;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: f, reason: collision with root package name */
    public static final e0 f8081f;

    /* renamed from: g, reason: collision with root package name */
    public static final e0 f8082g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ e0[] f8083h;

    static {
        e0 e0Var = new e0("Vertical", 0);
        f8081f = e0Var;
        e0 e0Var2 = new e0("Horizontal", 1);
        f8082g = e0Var2;
        f8083h = new e0[]{e0Var, e0Var2};
    }

    public static e0 valueOf(String str) {
        return (e0) Enum.valueOf(e0.class, str);
    }

    public static e0[] values() {
        return (e0[]) f8083h.clone();
    }
}
