package z7;

import java.util.function.Predicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final rd.b f16468a = rd.d.b(a.class);

    /* renamed from: b, reason: collision with root package name */
    public static final Predicate f16469b;

    static {
        a8.e eVar;
        try {
            Class.forName("com.ethlo.time.ITU", false, a.class.getClassLoader());
            eVar = new a8.e(24);
        } catch (ClassNotFoundException unused) {
            eVar = new a8.e(25);
        }
        f16469b = eVar;
    }

    @Override // z7.d
    public final String a() {
        return "format.date-time";
    }

    @Override // z7.d
    public final String getName() {
        return "date-time";
    }

    @Override // z7.d
    public final boolean matches(String str) {
        try {
            return f16469b.test(str);
        } catch (Exception e10) {
            f16468a.a("Invalid {}: {}", "date-time", e10.getMessage());
            return false;
        }
    }
}
