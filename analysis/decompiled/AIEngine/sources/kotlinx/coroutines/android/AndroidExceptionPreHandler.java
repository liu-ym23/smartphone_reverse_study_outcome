package kotlinx.coroutines.android;

import kotlin.coroutines.a;
import kotlin.coroutines.d;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AndroidExceptionPreHandler extends a implements CoroutineExceptionHandler {
    private volatile Object _preHandler;

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.Key);
        this._preHandler = this;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(d dVar, Throwable th) {
    }
}
