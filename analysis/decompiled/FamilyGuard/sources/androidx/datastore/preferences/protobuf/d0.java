package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
final class d0 {

    /* renamed from: c, reason: collision with root package name */
    private static final d0 f9988c = new d0();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, h0<?>> f9990b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final i0 f9989a = new J();

    private d0() {
    }

    public static d0 a() {
        return f9988c;
    }

    public <T> void b(T t5, g0 g0Var, C0496p c0496p) {
        e(t5).b(t5, g0Var, c0496p);
    }

    public h0<?> c(Class<?> cls, h0<?> h0Var) {
        A.b(cls, "messageType");
        A.b(h0Var, "schema");
        return this.f9990b.putIfAbsent(cls, h0Var);
    }

    public <T> h0<T> d(Class<T> cls) {
        A.b(cls, "messageType");
        h0<T> h0VarA = (h0) this.f9990b.get(cls);
        if (h0VarA == null) {
            h0VarA = this.f9989a.a(cls);
            h0<T> h0Var = (h0<T>) c(cls, h0VarA);
            if (h0Var != null) {
                return h0Var;
            }
        }
        return h0VarA;
    }

    public <T> h0<T> e(T t5) {
        return d(t5.getClass());
    }
}
