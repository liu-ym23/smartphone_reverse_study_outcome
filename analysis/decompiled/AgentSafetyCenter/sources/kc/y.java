package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f7501a;

    static {
        String property;
        a0 a0Var;
        int i = pc.u.f9986a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            rc.e eVar = e0.f7430a;
            lc.d dVar = pc.n.f9978a;
            lc.d dVar2 = dVar.i;
            a0Var = dVar;
            if (dVar == null) {
                a0Var = x.f7499m;
            }
        } else {
            a0Var = x.f7499m;
        }
        f7501a = a0Var;
    }
}
