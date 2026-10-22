package ob;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final v f8022a;

    static {
        v vVar;
        try {
            Class.forName("java.nio.file.Files");
            vVar = new w();
        } catch (ClassNotFoundException unused) {
            vVar = new v();
        }
        f8022a = vVar;
        String str = z.f8042g;
        String property = System.getProperty("java.io.tmpdir");
        q7.k.d(property, "getProperty(...)");
        h4.n.l(property, false);
        ClassLoader classLoader = pb.f.class.getClassLoader();
        q7.k.d(classLoader, "getClassLoader(...)");
        new pb.f(classLoader);
    }

    public abstract void a(z zVar, z zVar2);

    public abstract void b(z zVar);

    public abstract void c(z zVar);

    public final boolean d(z zVar) {
        q7.k.e(zVar, "path");
        return e(zVar) != null;
    }

    public abstract n e(z zVar);

    public abstract u f(z zVar);

    public abstract u g(z zVar);

    public abstract k0 h(z zVar);
}
