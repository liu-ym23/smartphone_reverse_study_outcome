package c3;

import b3.InterfaceC0380i;
import java.util.concurrent.CancellationException;

/* renamed from: c3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0394a extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient InterfaceC0380i f4470a;

    public C0394a(InterfaceC0380i interfaceC0380i) {
        super("Flow was aborted, no more elements needed");
        this.f4470a = interfaceC0380i;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
