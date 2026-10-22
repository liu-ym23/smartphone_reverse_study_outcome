package x3;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import java.util.function.Predicate;

/* loaded from: classes3.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC0315b f6873a = AbstractC0317d.b(b.class);
    public static final Predicate b;

    static {
        S6.c cVar;
        try {
            Class.forName("com.ethlo.time.ITU", false, b.class.getClassLoader());
            cVar = new S6.c(13);
        } catch (ClassNotFoundException unused) {
            cVar = new S6.c(14);
        }
        b = cVar;
    }

    @Override // x3.d
    public final String a() {
        return "format.date-time";
    }

    @Override // x3.d
    public final String getName() {
        return "date-time";
    }

    @Override // x3.d
    public final boolean matches(String str) {
        try {
            return b.test(str);
        } catch (Exception e) {
            f6873a.a("Invalid {}: {}", "date-time", e.getMessage());
            return false;
        }
    }
}
