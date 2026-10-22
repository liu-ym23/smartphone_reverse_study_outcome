package S0;

import C0.i;
import C0.t;
import P0.g;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import q.C0933a;

/* loaded from: classes.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private static final t<?, ?, ?> f5212c = new t<>(Object.class, Object.class, Object.class, Collections.singletonList(new i(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new g(), null)), null);

    /* renamed from: a, reason: collision with root package name */
    private final C0933a<X0.i, t<?, ?, ?>> f5213a = new C0933a<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<X0.i> f5214b = new AtomicReference<>();

    private X0.i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        X0.i andSet = this.f5214b.getAndSet(null);
        if (andSet == null) {
            andSet = new X0.i();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> t<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        t<Data, TResource, Transcode> tVar;
        X0.i iVarB = b(cls, cls2, cls3);
        synchronized (this.f5213a) {
            tVar = (t) this.f5213a.get(iVarB);
        }
        this.f5214b.set(iVarB);
        return tVar;
    }

    public boolean c(t<?, ?, ?> tVar) {
        return f5212c.equals(tVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, t<?, ?, ?> tVar) {
        synchronized (this.f5213a) {
            C0933a<X0.i, t<?, ?, ?>> c0933a = this.f5213a;
            X0.i iVar = new X0.i(cls, cls2, cls3);
            if (tVar == null) {
                tVar = f5212c;
            }
            c0933a.put(iVar, tVar);
        }
    }
}
