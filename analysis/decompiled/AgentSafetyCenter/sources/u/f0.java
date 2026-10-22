package u;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: c, reason: collision with root package name */
    public static final f0 f13453c;

    /* renamed from: f, reason: collision with root package name */
    public static final f0 f13454f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ f0[] f13455g;

    static {
        f0 f0Var = new f0("Vertical", 0);
        f13453c = f0Var;
        f0 f0Var2 = new f0("Horizontal", 1);
        f13454f = f0Var2;
        f13455g = new f0[]{f0Var, f0Var2};
    }

    public static f0 valueOf(String str) {
        return (f0) Enum.valueOf(f0.class, str);
    }

    public static f0[] values() {
        return (f0[]) f13455g.clone();
    }
}
