package m9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.EmptyCoroutineContext;
import s9.AbstractC1921a;
import s9.C1925e;

/* renamed from: m9.v, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC1729v extends H7.a implements H7.e {
    public static final C1728u Key = new C1728u(H7.d.f758a, new m5.a(1));

    public AbstractC1729v() {
        super(H7.d.f758a);
    }

    public static /* synthetic */ AbstractC1729v limitedParallelism$default(AbstractC1729v abstractC1729v, int i, String str, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
        }
        if ((i6 & 2) != 0) {
            str = null;
        }
        return abstractC1729v.limitedParallelism(i, str);
    }

    public abstract void dispatch(H7.h hVar, Runnable runnable);

    public void dispatchYield(H7.h hVar, Runnable runnable) {
        dispatch(hVar, runnable);
    }

    @Override // H7.a, H7.h
    public <E extends H7.f> E get(H7.g key) {
        E e;
        kotlin.jvm.internal.k.f(key, "key");
        if (key instanceof C1728u) {
            C1728u c1728u = (C1728u) key;
            H7.g key2 = getKey();
            kotlin.jvm.internal.k.f(key2, "key");
            if ((key2 == c1728u || c1728u.b == key2) && (e = (E) c1728u.f5335a.invoke(this)) != null) {
                return e;
            }
        } else if (H7.d.f758a == key) {
            return this;
        }
        return null;
    }

    @Override // H7.e
    public final <T> H7.c<T> interceptContinuation(H7.c<? super T> cVar) {
        return new C1925e(this, cVar);
    }

    public boolean isDispatchNeeded(H7.h hVar) {
        return true;
    }

    public AbstractC1729v limitedParallelism(int i, String str) {
        AbstractC1921a.a(i);
        return new s9.f(this, i, str);
    }

    @Override // H7.a, H7.h
    public H7.h minusKey(H7.g key) {
        kotlin.jvm.internal.k.f(key, "key");
        if (!(key instanceof C1728u)) {
            return H7.d.f758a == key ? EmptyCoroutineContext.f4908a : this;
        }
        C1728u c1728u = (C1728u) key;
        H7.g key2 = getKey();
        kotlin.jvm.internal.k.f(key2, "key");
        return ((key2 == c1728u || c1728u.b == key2) && ((H7.f) c1728u.f5335a.invoke(this)) != null) ? EmptyCoroutineContext.f4908a : this;
    }

    @C7.c
    public final AbstractC1729v plus(AbstractC1729v abstractC1729v) {
        return abstractC1729v;
    }

    @Override // H7.e
    public final void releaseInterceptedContinuation(H7.c<?> cVar) {
        kotlin.jvm.internal.k.d(cVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        C1925e c1925e = (C1925e) cVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1925e.h;
        while (atomicReferenceFieldUpdater.get(c1925e) == AbstractC1921a.c) {
        }
        Object obj = atomicReferenceFieldUpdater.get(c1925e);
        C1718k c1718k = obj instanceof C1718k ? (C1718k) obj : null;
        if (c1718k != null) {
            c1718k.t();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + AbstractC1683A.i(this);
    }

    @C7.c
    public /* synthetic */ AbstractC1729v limitedParallelism(int i) {
        return limitedParallelism(i, null);
    }
}
