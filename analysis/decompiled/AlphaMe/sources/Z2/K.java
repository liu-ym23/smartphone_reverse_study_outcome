package Z2;

/* loaded from: classes2.dex */
public abstract class K {

    /* renamed from: a, reason: collision with root package name */
    public static final L f2184a;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        String property;
        L l4;
        int i4 = d3.x.f12483a;
        try {
            property = System.getProperty("kotlinx.coroutines.main.delay");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null || !Boolean.parseBoolean(property)) {
            l4 = J.f2181h;
        } else {
            f3.d dVar = Q.f2189a;
            y0 y0Var = d3.q.f12477a;
            y0Var.getImmediate();
            l4 = !(y0Var instanceof L) ? J.f2181h : (L) y0Var;
        }
        f2184a = l4;
    }
}
