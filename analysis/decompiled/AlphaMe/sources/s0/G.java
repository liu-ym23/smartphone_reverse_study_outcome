package s0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class G {

    /* renamed from: a, reason: collision with root package name */
    public static final G f14153a;

    /* renamed from: b, reason: collision with root package name */
    public static final G f14154b;

    /* renamed from: c, reason: collision with root package name */
    public static final G f14155c;

    /* renamed from: d, reason: collision with root package name */
    public static final G f14156d;

    /* renamed from: e, reason: collision with root package name */
    public static final G f14157e;

    /* renamed from: f, reason: collision with root package name */
    public static final G f14158f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ G[] f14159g;

    static {
        G g4 = new G("ENQUEUED", 0);
        f14153a = g4;
        G g5 = new G("RUNNING", 1);
        f14154b = g5;
        G g6 = new G("SUCCEEDED", 2);
        f14155c = g6;
        G g7 = new G("FAILED", 3);
        f14156d = g7;
        G g8 = new G("BLOCKED", 4);
        f14157e = g8;
        G g9 = new G("CANCELLED", 5);
        f14158f = g9;
        f14159g = new G[]{g4, g5, g6, g7, g8, g9};
    }

    public static G valueOf(String str) {
        return (G) Enum.valueOf(G.class, str);
    }

    public static G[] values() {
        return (G[]) f14159g.clone();
    }

    public final boolean a() {
        return this == f14155c || this == f14156d || this == f14158f;
    }
}
