package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class V {

    /* renamed from: c, reason: collision with root package name */
    public static final V f13489c = new V();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentMap<Class<?>, Z<?>> f13491b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final a0 f13490a = new D();

    public static V a() {
        return f13489c;
    }

    public <T> void b(T t10, Y y10, C1351n c1351n) throws IOException {
        e(t10).a(t10, y10, c1351n);
    }

    public Z<?> c(Class<?> cls, Z<?> z10) {
        C1359w.b(cls, "messageType");
        C1359w.b(z10, "schema");
        return this.f13491b.putIfAbsent(cls, z10);
    }

    public <T> Z<T> d(Class<T> cls) {
        C1359w.b(cls, "messageType");
        Z<T> zCreateSchema = (Z) this.f13491b.get(cls);
        if (zCreateSchema == null) {
            zCreateSchema = this.f13490a.createSchema(cls);
            Z<T> z10 = (Z<T>) c(cls, zCreateSchema);
            if (z10 != null) {
                return z10;
            }
        }
        return zCreateSchema;
    }

    public <T> Z<T> e(T t10) {
        return d(t10.getClass());
    }
}
