package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public final class e2 implements CoroutineContext.Element, CoroutineContext.Key {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e2 f21419a = null;

    static {
        f21419a = new e2();
    }

    public e2() {
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
        return this;
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
