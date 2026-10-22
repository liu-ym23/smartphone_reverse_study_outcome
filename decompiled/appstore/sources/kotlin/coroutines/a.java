package kotlin.coroutines;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements CoroutineContext.Element {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext.Key f21115a;

    public a(CoroutineContext.Key r10) {
        q.g(r10, "key");
        this.f21115a = r10;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public Object fold(Object r10, Function2 r11) {
        return CoroutineContext.Element.a.a(this, r10, r11);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key r10) {
        return CoroutineContext.Element.a.b(this, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key getKey() {
        return this.f21115a;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key r10) {
        return CoroutineContext.Element.a.c(this, r10);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r10) {
        return CoroutineContext.Element.a.d(this, r10);
    }
}
