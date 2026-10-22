package kotlinx.coroutines.android;

import kotlin.coroutines.d;
import kotlin.jvm.internal.e;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class HandlerDispatcher extends MainCoroutineDispatcher implements Delay {
    public /* synthetic */ HandlerDispatcher(e eVar) {
        this();
    }

    public DisposableHandle invokeOnTimeout(long j10, Runnable runnable, d dVar) {
        return Delay.DefaultImpls.invokeOnTimeout(this, j10, runnable, dVar);
    }

    private HandlerDispatcher() {
    }
}
