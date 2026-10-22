package o7;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends u {

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Method f9283b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f9284c;

    @Override // o7.u
    public final Object a(Class cls) {
        String strG = p5.c.g(cls);
        if (strG == null) {
            return this.f9283b.invoke(this.f9284c, cls);
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: ".concat(strG));
    }
}
