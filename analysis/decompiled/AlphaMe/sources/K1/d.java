package K1;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f1038a;

    /* renamed from: b, reason: collision with root package name */
    public static final H1.a f1039b;

    /* renamed from: c, reason: collision with root package name */
    public static final H1.a f1040c;

    /* renamed from: d, reason: collision with root package name */
    public static final H1.a f1041d;

    static {
        boolean z4;
        try {
            Class.forName("java.sql.Date");
            z4 = true;
        } catch (ClassNotFoundException unused) {
            z4 = false;
        }
        f1038a = z4;
        if (z4) {
            f1039b = a.f1032b;
            f1040c = b.f1034b;
            f1041d = c.f1036b;
        } else {
            f1039b = null;
            f1040c = null;
            f1041d = null;
        }
    }
}
