package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements CoroutineContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f21546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f21547b;

    public g(Throwable r10, CoroutineContext r11) {
        this.f21546a = r10;
        this.f21547b = r11;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public Object fold(Object r10, Function2 r11) {
        return this.f21547b.fold(r10, r11);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key r10) {
        return this.f21547b.get(r10);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key r10) {
        return this.f21547b.minusKey(r10);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r10) {
        return this.f21547b.plus(r10);
    }
}
