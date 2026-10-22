package s8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: c, reason: collision with root package name */
    public static final d1 f11539c;

    /* renamed from: f, reason: collision with root package name */
    public static final d1 f11540f;

    /* renamed from: g, reason: collision with root package name */
    public static final d1 f11541g;

    /* renamed from: h, reason: collision with root package name */
    public static final d1 f11542h;
    public static final /* synthetic */ d1[] i;

    static {
        d1 d1Var = new d1("Today", 0);
        f11539c = d1Var;
        d1 d1Var2 = new d1("Week", 1);
        f11540f = d1Var2;
        d1 d1Var3 = new d1("Month", 2);
        f11541g = d1Var3;
        d1 d1Var4 = new d1("All", 3);
        f11542h = d1Var4;
        d1[] d1VarArr = {d1Var, d1Var2, d1Var3, d1Var4};
        i = d1VarArr;
        a.a.p(d1VarArr);
    }

    public static d1 valueOf(String str) {
        return (d1) Enum.valueOf(d1.class, str);
    }

    public static d1[] values() {
        return (d1[]) i.clone();
    }
}
