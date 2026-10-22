package C0;

import java.util.HashMap;
import t0.C0917c;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: e, reason: collision with root package name */
    public static final String f330e = s0.t.f("WorkTimer");

    /* renamed from: a, reason: collision with root package name */
    public final C0917c f331a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f332b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f333c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Object f334d = new Object();

    public y(C0917c c0917c) {
        this.f331a = c0917c;
    }

    public final void a(B0.k kVar) {
        synchronized (this.f334d) {
            try {
                if (((x) this.f332b.remove(kVar)) != null) {
                    s0.t.d().a(f330e, "Stopping timer for " + kVar);
                    this.f333c.remove(kVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
