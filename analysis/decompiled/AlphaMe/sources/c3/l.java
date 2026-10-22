package c3;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: classes2.dex */
public final class l implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    public static final l f4503a = new l();

    /* renamed from: b, reason: collision with root package name */
    public static final EmptyCoroutineContext f4504b = EmptyCoroutineContext.INSTANCE;

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return f4504b;
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
    }
}
