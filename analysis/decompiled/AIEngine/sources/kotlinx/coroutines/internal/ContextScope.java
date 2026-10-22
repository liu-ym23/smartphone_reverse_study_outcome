package kotlinx.coroutines.internal;

import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ContextScope implements CoroutineScope {
    private final d coroutineContext;

    public ContextScope(d dVar) {
        this.coroutineContext = dVar;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public d getCoroutineContext() {
        return this.coroutineContext;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + getCoroutineContext() + ')';
    }
}
