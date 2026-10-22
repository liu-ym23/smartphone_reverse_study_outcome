package c3;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* loaded from: classes2.dex */
public final class j implements CoroutineContext {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f4501a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f4502b;

    public j(CoroutineContext coroutineContext, Throwable th) {
        this.f4501a = th;
        this.f4502b = coroutineContext;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final Object fold(Object obj, Function2 function2) {
        return this.f4502b.fold(obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext, kotlin.coroutines.ContinuationInterceptor
    public final CoroutineContext.Element get(CoroutineContext.Key key) {
        return this.f4502b.get(key);
    }

    @Override // kotlin.coroutines.CoroutineContext, kotlin.coroutines.ContinuationInterceptor
    public final CoroutineContext minusKey(CoroutineContext.Key key) {
        return this.f4502b.minusKey(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.f4502b.plus(coroutineContext);
    }
}
