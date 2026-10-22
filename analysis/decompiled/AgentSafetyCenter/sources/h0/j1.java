package h0;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j1 {

    /* renamed from: c, reason: collision with root package name */
    public static final j1 f5031c;

    /* renamed from: f, reason: collision with root package name */
    public static final j1 f5032f;

    /* renamed from: g, reason: collision with root package name */
    public static final j1 f5033g;

    /* renamed from: h, reason: collision with root package name */
    public static final j1 f5034h;
    public static final j1 i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ j1[] f5035j;

    static {
        j1 j1Var = new j1("TopBar", 0);
        f5031c = j1Var;
        j1 j1Var2 = new j1("MainContent", 1);
        f5032f = j1Var2;
        j1 j1Var3 = new j1("Snackbar", 2);
        f5033g = j1Var3;
        j1 j1Var4 = new j1("Fab", 3);
        f5034h = j1Var4;
        j1 j1Var5 = new j1("BottomBar", 4);
        i = j1Var5;
        f5035j = new j1[]{j1Var, j1Var2, j1Var3, j1Var4, j1Var5};
    }

    public static j1 valueOf(String str) {
        return (j1) Enum.valueOf(j1.class, str);
    }

    public static j1[] values() {
        return (j1[]) f5035j.clone();
    }
}
