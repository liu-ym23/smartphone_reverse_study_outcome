package kotlinx.coroutines;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.a;
import kotlin.coroutines.b;
import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LimitedDispatcher;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class CoroutineDispatcher extends a implements c {
    public static final Key Key = new Key(null);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Key extends b<c, CoroutineDispatcher> {
        public /* synthetic */ Key(e eVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CoroutineDispatcher _init_$lambda$0(d.a aVar) {
            if (aVar instanceof CoroutineDispatcher) {
                return (CoroutineDispatcher) aVar;
            }
            return null;
        }

        private Key() {
            super(c.a.f10058a, new com.stepos.core.common.telemetry.b(28));
        }
    }

    public CoroutineDispatcher() {
        super(c.a.f10058a);
    }

    public static /* synthetic */ CoroutineDispatcher limitedParallelism$default(CoroutineDispatcher coroutineDispatcher, int i10, String str, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: limitedParallelism");
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        return coroutineDispatcher.limitedParallelism(i10, str);
    }

    public abstract void dispatch(d dVar, Runnable runnable);

    public void dispatchYield(d dVar, Runnable runnable) {
        dispatch(dVar, runnable);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.d
    public <E extends d.a> E get(d.b<E> key) {
        E e10;
        g.f(key, "key");
        if (!(key instanceof b)) {
            if (c.a.f10058a == key) {
                return this;
            }
            return null;
        }
        b bVar = (b) key;
        if (!bVar.isSubKey$kotlin_stdlib(getKey()) || (e10 = (E) bVar.tryCast$kotlin_stdlib(this)) == null) {
            return null;
        }
        return e10;
    }

    @Override // kotlin.coroutines.c
    public final <T> qb.b<T> interceptContinuation(qb.b<? super T> bVar) {
        return new DispatchedContinuation(this, bVar);
    }

    public boolean isDispatchNeeded(d dVar) {
        return true;
    }

    public CoroutineDispatcher limitedParallelism(int i10, String str) {
        LimitedDispatcherKt.checkParallelism(i10);
        return new LimitedDispatcher(this, i10, str);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.d
    public d minusKey(d.b<?> key) {
        g.f(key, "key");
        if (!(key instanceof b)) {
            return c.a.f10058a == key ? EmptyCoroutineContext.f10057a : this;
        }
        b bVar = (b) key;
        return (!bVar.isSubKey$kotlin_stdlib(getKey()) || bVar.tryCast$kotlin_stdlib(this) == null) ? this : EmptyCoroutineContext.f10057a;
    }

    @Override // kotlin.coroutines.c
    public final void releaseInterceptedContinuation(qb.b<?> bVar) {
        g.d(bVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((DispatchedContinuation) bVar).release$kotlinx_coroutines_core();
    }

    public String toString() {
        return DebugStringsKt.getClassSimpleName(this) + '@' + DebugStringsKt.getHexAddress(this);
    }

    public /* synthetic */ CoroutineDispatcher limitedParallelism(int i10) {
        return limitedParallelism(i10, null);
    }

    public final CoroutineDispatcher plus(CoroutineDispatcher coroutineDispatcher) {
        return coroutineDispatcher;
    }
}
