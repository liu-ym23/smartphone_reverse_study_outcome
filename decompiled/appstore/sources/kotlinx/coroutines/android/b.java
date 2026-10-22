package kotlinx.coroutines.android;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends kotlin.coroutines.a implements CoroutineExceptionHandler {

    @Nullable
    private volatile Object _preHandler;

    public b() {
        super(CoroutineExceptionHandler.Key);
        this._preHandler = this;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(CoroutineContext r10, Throwable r11) {
    }
}
