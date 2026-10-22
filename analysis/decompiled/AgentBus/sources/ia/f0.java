package ia;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final j0 f4956a;

    static {
        String property;
        j0 j0Var;
        int i2 = na.u.f6929a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property != null ? Boolean.parseBoolean(property) : false) {
            pa.e eVar = n0.f4982a;
            ja.d dVar = na.o.f6923a;
            ja.d dVar2 = dVar.f5424k;
            j0Var = dVar;
            if (dVar == null) {
                j0Var = e0.f4949o;
            }
        } else {
            j0Var = e0.f4949o;
        }
        f4956a = j0Var;
    }
}
