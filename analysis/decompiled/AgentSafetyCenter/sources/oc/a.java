package oc;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends CancellationException {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object f9361c;

    public a(nc.h hVar) {
        super("Flow was aborted, no more elements needed");
        this.f9361c = hVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
