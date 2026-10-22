package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: Atomic.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b<T> extends ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f39387a = null;
    private volatile /* synthetic */ Object _consensus$volatile;

    static {
        f39387a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus$volatile");
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater a() {
        return f39387a;
    }

    public abstract Object a(T r1);

    public abstract void a(T r1, Object r2);

    public b() {
        this._consensus$volatile = a.f39351a;
    }

    private final Object c(Object r3) {
        if (kotlinx.coroutines.aq.a() == true) goto L5;
    L12:
        Object r0 = a().get(this);
        if (r0 == a.f39351a) goto L16;
        return r0;
    L16:
        if (a().compareAndSet(this, a.f39351a, r3) == false) goto L19;
        return r3;
    L19:
        return a().get(this);
    L5:
        if (r3 == a.f39351a) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        throw new AssertionError();
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.internal.ae
    public final Object b(Object r3) {
        Object r0 = a().get(this);
        if (r0 != a.f39351a) goto L5;
        r0 = c(a(r3));
    L5:
        a(r3, r0);
        return r0;
    }
}
