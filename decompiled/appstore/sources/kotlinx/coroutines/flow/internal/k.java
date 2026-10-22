package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f21548a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineContext f21549b = null;

    static {
        f21548a = new k();
        f21549b = EmptyCoroutineContext.INSTANCE;
    }

    public k() {
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return f21549b;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
    }
}
