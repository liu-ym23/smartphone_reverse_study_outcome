package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes4.dex */
public final class f0 implements ThreadContextElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadLocal f21589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineContext.Key f21590c;

    public f0(Object r10, ThreadLocal r11) {
        this.f21588a = r10;
        this.f21589b = r11;
        this.f21590c = new g0(r11);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public Object fold(Object r10, Function2 r11) {
        return ThreadContextElement.a.a(this, r10, r11);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key r10) {
        if (kotlin.jvm.internal.q.b(getKey(), r10) == false) goto L5;
        kotlin.jvm.internal.q.e(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    L5:
        return null;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key getKey() {
        return this.f21590c;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key r10) {
        if (kotlin.jvm.internal.q.b(getKey(), r10) == true) goto L5;
        return this;
    L5:
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r10) {
        return ThreadContextElement.a.b(this, r10);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public void restoreThreadContext(CoroutineContext r10, Object r11) {
        this.f21589b.set(r11);
    }

    public String toString() {
        return "ThreadLocal(value=" + this.f21588a + ", threadLocal = " + this.f21589b + ')';
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public Object updateThreadContext(CoroutineContext r10) {
        Object r11 = this.f21589b.get();
        this.f21589b.set(this.f21588a);
        return r11;
    }
}
