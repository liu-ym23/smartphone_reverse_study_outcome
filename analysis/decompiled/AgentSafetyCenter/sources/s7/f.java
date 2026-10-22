package s7;

import s7.a;
import s7.b;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f11415a;

    /* renamed from: b, reason: collision with root package name */
    public static final a.C0012a f11416b;

    /* renamed from: c, reason: collision with root package name */
    public static final b.a f11417c;

    /* renamed from: d, reason: collision with root package name */
    public static final c f11418d;

    static {
        boolean z10;
        try {
            Class.forName("java.sql.Date");
            z10 = true;
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        f11415a = z10;
        if (z10) {
            f11416b = a.f11408b;
            f11417c = b.f11410b;
            f11418d = d.f11412b;
        } else {
            f11416b = null;
            f11417c = null;
            f11418d = null;
        }
    }
}
