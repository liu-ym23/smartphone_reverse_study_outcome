package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class g0 implements CoroutineContext.Key {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal f21592a;

    public g0(ThreadLocal r10) {
        this.f21592a = r10;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof g0) == true) goto L9;
        return false;
    L9:
        if (kotlin.jvm.internal.q.b(this.f21592a, ((g0) r10).f21592a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f21592a.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f21592a + ')';
    }
}
