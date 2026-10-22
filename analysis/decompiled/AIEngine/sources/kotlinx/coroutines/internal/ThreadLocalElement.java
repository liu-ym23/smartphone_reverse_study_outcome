package kotlinx.coroutines.internal;

import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.ThreadContextElement;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ThreadLocalElement<T> implements ThreadContextElement<T> {
    private final d.b<?> key;
    private final ThreadLocal<T> threadLocal;
    private final T value;

    public ThreadLocalElement(T t8, ThreadLocal<T> threadLocal) {
        this.value = t8;
        this.threadLocal = threadLocal;
        this.key = new ThreadLocalKey(threadLocal);
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R r, p<? super R, ? super d.a, ? extends R> pVar) {
        return (R) ThreadContextElement.DefaultImpls.fold(this, r, pVar);
    }

    @Override // kotlin.coroutines.d
    public <E extends d.a> E get(d.b<E> bVar) {
        if (g.b(getKey(), bVar)) {
            return this;
        }
        return null;
    }

    @Override // kotlin.coroutines.d.a
    public d.b<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.d
    public d minusKey(d.b<?> bVar) {
        return g.b(getKey(), bVar) ? EmptyCoroutineContext.f10057a : this;
    }

    @Override // kotlin.coroutines.d
    public d plus(d dVar) {
        return ThreadContextElement.DefaultImpls.plus(this, dVar);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public void restoreThreadContext(d dVar, T t8) {
        this.threadLocal.set(t8);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.value + ", threadLocal = " + this.threadLocal + ')';
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public T updateThreadContext(d dVar) {
        T t8 = this.threadLocal.get();
        this.threadLocal.set(this.value);
        return t8;
    }
}
