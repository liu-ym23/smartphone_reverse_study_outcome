package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CoroutineDispatcher extends kotlin.coroutines.a implements ContinuationInterceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Key f21279b = null;

    public static final class Key extends kotlin.coroutines.b {
        public /* synthetic */ Key(DefaultConstructorMarker r10) {
            this();
        }

        public Key() {
            super(ContinuationInterceptor.Key, AnonymousClass1.INSTANCE);
        }
    }

    static {
        f21279b = new Key(null);
    }

    public CoroutineDispatcher() {
        super(ContinuationInterceptor.Key);
    }

    public abstract void a(CoroutineContext r10, Runnable r11);

    public void b(CoroutineContext r10, Runnable r11) {
        a(r10, r11);
    }

    public boolean c(CoroutineContext r10) {
        return true;
    }

    public CoroutineDispatcher d(int r10) {
        kotlinx.coroutines.internal.m.a(r10);
        return new kotlinx.coroutines.internal.l(this, r10);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key r10) {
        return ContinuationInterceptor.a.a(this, r10);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final Continuation interceptContinuation(Continuation r10) {
        return new kotlinx.coroutines.internal.i(this, r10);
    }

    @Override // kotlin.coroutines.a, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key r10) {
        return ContinuationInterceptor.a.b(this, r10);
    }

    @Override // kotlin.coroutines.ContinuationInterceptor
    public final void releaseInterceptedContinuation(Continuation r10) {
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((kotlinx.coroutines.internal.i) r10).m();
    }

    public String toString() {
        return e0.a(this) + '@' + e0.b(this);
    }
}
