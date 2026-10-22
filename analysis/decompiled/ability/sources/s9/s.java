package s9;

import kotlin.coroutines.EmptyCoroutineContext;
import m9.s0;

/* loaded from: classes4.dex */
public final class s implements s0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6008a;
    public final ThreadLocal b;
    public final t c;

    public s(ThreadLocal threadLocal, Object obj) {
        this.f6008a = obj;
        this.b = threadLocal;
        this.c = new t(threadLocal);
    }

    @Override // H7.h
    public final Object fold(Object obj, S7.n nVar) {
        return nVar.invoke(obj, this);
    }

    @Override // H7.h
    public final H7.f get(H7.g gVar) {
        if (this.c.equals(gVar)) {
            return this;
        }
        return null;
    }

    @Override // H7.f
    public final H7.g getKey() {
        return this.c;
    }

    @Override // H7.h
    public final H7.h minusKey(H7.g gVar) {
        return this.c.equals(gVar) ? EmptyCoroutineContext.f4908a : this;
    }

    @Override // H7.h
    public final H7.h plus(H7.h hVar) {
        return z2.l.H(this, hVar);
    }

    @Override // m9.s0
    public final void restoreThreadContext(H7.h hVar, Object obj) {
        this.b.set(obj);
    }

    public final String toString() {
        return "ThreadLocal(value=" + this.f6008a + ", threadLocal = " + this.b + ')';
    }

    @Override // m9.s0
    public final Object updateThreadContext(H7.h hVar) {
        ThreadLocal threadLocal = this.b;
        Object obj = threadLocal.get();
        threadLocal.set(this.f6008a);
        return obj;
    }
}
