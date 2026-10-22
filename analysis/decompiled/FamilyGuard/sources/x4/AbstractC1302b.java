package x4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: x4.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1302b<T> extends y {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f23849a = AtomicReferenceFieldUpdater.newUpdater(AbstractC1302b.class, Object.class, "_consensus$volatile");
    private volatile /* synthetic */ Object _consensus$volatile = C1301a.f23848a;

    private final Object c(Object obj) {
        Object obj2 = f23849a.get(this);
        Object obj3 = C1301a.f23848a;
        return obj2 != obj3 ? obj2 : f23849a.compareAndSet(this, obj3, obj) ? obj : f23849a.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // x4.y
    public final Object a(Object obj) {
        Object objC = f23849a.get(this);
        if (objC == C1301a.f23848a) {
            objC = c(e(obj));
        }
        b(obj, objC);
        return objC;
    }

    public abstract void b(T t5, Object obj);

    public abstract Object e(T t5);
}
