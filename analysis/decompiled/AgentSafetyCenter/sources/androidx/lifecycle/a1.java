package androidx.lifecycle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface a1 {
    default y0 a(Class cls) {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }

    default y0 b(yb.e eVar, h4.c cVar) {
        Class cls = eVar.f16088a;
        cls.getClass();
        return c(cls, cVar);
    }

    default y0 c(Class cls, h4.c cVar) {
        return a(cls);
    }
}
