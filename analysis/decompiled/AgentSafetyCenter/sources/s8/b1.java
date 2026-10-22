package s8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b1 {

    /* renamed from: c, reason: collision with root package name */
    public static final b1 f11457c;

    /* renamed from: f, reason: collision with root package name */
    public static final b1 f11458f;

    /* renamed from: g, reason: collision with root package name */
    public static final b1 f11459g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ b1[] f11460h;

    static {
        b1 b1Var = new b1("Undecided", 0);
        f11457c = b1Var;
        b1 b1Var2 = new b1("HorizontalScrub", 1);
        f11458f = b1Var2;
        b1 b1Var3 = new b1("VerticalScroll", 2);
        f11459g = b1Var3;
        b1[] b1VarArr = {b1Var, b1Var2, b1Var3};
        f11460h = b1VarArr;
        a.a.p(b1VarArr);
    }

    public static b1 valueOf(String str) {
        return (b1) Enum.valueOf(b1.class, str);
    }

    public static b1[] values() {
        return (b1[]) f11460h.clone();
    }
}
