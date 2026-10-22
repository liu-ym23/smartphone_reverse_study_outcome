package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 implements CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y0 f21772a = null;

    static {
        f21772a = new y0();
    }

    public y0() {
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
