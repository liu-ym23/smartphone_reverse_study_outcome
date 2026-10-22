package ma;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class a extends CancellationException {

    /* renamed from: f, reason: collision with root package name */
    public final transient Object f6475f;

    public a(la.k kVar) {
        super("Flow was aborted, no more elements needed");
        this.f6475f = kVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
