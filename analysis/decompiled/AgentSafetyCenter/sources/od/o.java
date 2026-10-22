package od;

import java.io.FileNotFoundException;
import java.lang.invoke.VarHandle;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final v f9478a;

    static {
        v vVar;
        try {
            Class.forName("java.nio.file.Files");
            vVar = new w();
        } catch (ClassNotFoundException unused) {
            vVar = new v();
        }
        f9478a = vVar;
        String str = z.f9497f;
        String property = System.getProperty("java.io.tmpdir");
        property.getClass();
        f8.b.n(property);
        ClassLoader classLoader = pd.f.class.getClassLoader();
        classLoader.getClass();
        pd.f fVar = new pd.f();
        fVar.f10010b = classLoader;
        fVar.f10011c = vVar;
        fVar.f10012d = new jb.k(new ad.l(fVar, 18));
        VarHandle.storeStoreFence();
    }

    public abstract g0 a(z zVar);

    public abstract void b(z zVar, z zVar2);

    public abstract void c(z zVar);

    public abstract void d(z zVar);

    public final void e(z zVar) {
        zVar.getClass();
        d(zVar);
    }

    public final boolean f(z zVar) {
        zVar.getClass();
        return i(zVar) != null;
    }

    public abstract List g(z zVar);

    public final n h(z zVar) throws FileNotFoundException {
        zVar.getClass();
        n nVarI = i(zVar);
        if (nVarI != null) {
            return nVarI;
        }
        f.d(zVar, "no such file: ");
        return null;
    }

    public abstract n i(z zVar);

    public abstract u j(z zVar);

    public abstract g0 k(z zVar);

    public abstract i0 l(z zVar);
}
