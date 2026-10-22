package w4;

import java.util.concurrent.CancellationException;

/* renamed from: w4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1272a extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient Object f23712a;

    public C1272a(Object obj) {
        super("Flow was aborted, no more elements needed");
        this.f23712a = obj;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
