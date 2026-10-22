package S0;

import java.util.ArrayList;
import java.util.List;
import z0.j;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?>> f5222a = new ArrayList();

    private static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f5223a;

        /* renamed from: b, reason: collision with root package name */
        final j<T> f5224b;

        a(Class<T> cls, j<T> jVar) {
            this.f5223a = cls;
            this.f5224b = jVar;
        }

        boolean a(Class<?> cls) {
            return this.f5223a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, j<Z> jVar) {
        this.f5222a.add(new a<>(cls, jVar));
    }

    public synchronized <Z> j<Z> b(Class<Z> cls) {
        int size = this.f5222a.size();
        for (int i5 = 0; i5 < size; i5++) {
            a<?> aVar = this.f5222a.get(i5);
            if (aVar.a(cls)) {
                return (j<Z>) aVar.f5224b;
            }
        }
        return null;
    }
}
