package g2;

/* renamed from: g2.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0736f {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f17230a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f17231b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f17232c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f17233d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f17234e;

    static {
        boolean zF = R1.a.f("FG_MOCK_ALL", R1.a.f4965a);
        f17230a = zF;
        boolean z5 = true;
        f17231b = zF || R1.a.f("FG_MOCK_US_LIMIT_TIME", R1.a.f4965a);
        if (!zF && !R1.a.f("FG_MOCK_US_SUSPEND", R1.a.f4965a)) {
            z5 = false;
        }
        f17232c = z5;
        f17233d = R1.a.f("US_WIDGET_BIG_NUMBER_K", R1.a.f4965a);
        f17234e = R1.a.f("US_WIDGET_BIG_NUMBER_W", R1.a.f4965a);
    }
}
