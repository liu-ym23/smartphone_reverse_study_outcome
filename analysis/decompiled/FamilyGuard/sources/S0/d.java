package S0;

import X0.i;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import q.C0933a;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<i> f5215a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final C0933a<i, List<Class<?>>> f5216b = new C0933a<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        i andSet = this.f5215a.getAndSet(null);
        if (andSet == null) {
            andSet = new i(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f5216b) {
            list = this.f5216b.get(andSet);
        }
        this.f5215a.set(andSet);
        return list;
    }

    public void b(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f5216b) {
            this.f5216b.put(new i(cls, cls2, cls3), list);
        }
    }
}
