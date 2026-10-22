package d3;

import kotlin.coroutines.CoroutineContext;

/* loaded from: classes2.dex */
public final class h extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final transient CoroutineContext f12453a;

    public h(CoroutineContext coroutineContext) {
        this.f12453a = coroutineContext;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f12453a.toString();
    }
}
