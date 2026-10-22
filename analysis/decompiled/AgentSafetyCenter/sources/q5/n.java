package q5;

import g5.u;
import java.util.HashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: e, reason: collision with root package name */
    public static final String f10096e = u.f("WorkTimer");

    /* renamed from: a, reason: collision with root package name */
    public a2.i f10097a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap f10098b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap f10099c;

    /* renamed from: d, reason: collision with root package name */
    public Object f10100d;

    public final void a(p5.j jVar) {
        synchronized (this.f10100d) {
            try {
                if (((m) this.f10098b.remove(jVar)) != null) {
                    u.d().a(f10096e, "Stopping timer for " + jVar);
                    this.f10099c.remove(jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
