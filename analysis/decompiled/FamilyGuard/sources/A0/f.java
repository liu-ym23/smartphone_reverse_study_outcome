package A0;

import A0.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static final e.a<?> f7b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f8a = new HashMap();

    class a implements e.a<Object> {
        a() {
        }

        @Override // A0.e.a
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // A0.e.a
        public e<Object> b(Object obj) {
            return new b(obj);
        }
    }

    private static final class b implements e<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f9a;

        b(Object obj) {
            this.f9a = obj;
        }

        @Override // A0.e
        public Object a() {
            return this.f9a;
        }

        @Override // A0.e
        public void b() {
        }
    }

    public synchronized <T> e<T> a(T t5) {
        e.a<?> aVar;
        try {
            X0.j.d(t5);
            aVar = this.f8a.get(t5.getClass());
            if (aVar == null) {
                Iterator<e.a<?>> it = this.f8a.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    e.a<?> next = it.next();
                    if (next.a().isAssignableFrom(t5.getClass())) {
                        aVar = next;
                        break;
                    }
                }
            }
            if (aVar == null) {
                aVar = f7b;
            }
        } catch (Throwable th) {
            throw th;
        }
        return (e<T>) aVar.b(t5);
    }

    public synchronized void b(e.a<?> aVar) {
        this.f8a.put(aVar.a(), aVar);
    }
}
