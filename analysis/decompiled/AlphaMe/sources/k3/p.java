package k3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class p extends C0683E {

    /* renamed from: a, reason: collision with root package name */
    public C0683E f13365a;

    public p(C0683E delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f13365a = delegate;
    }

    @Override // k3.C0683E
    public final C0683E clearDeadline() {
        return this.f13365a.clearDeadline();
    }

    @Override // k3.C0683E
    public final C0683E clearTimeout() {
        return this.f13365a.clearTimeout();
    }

    @Override // k3.C0683E
    public final long deadlineNanoTime() {
        return this.f13365a.deadlineNanoTime();
    }

    @Override // k3.C0683E
    public final boolean hasDeadline() {
        return this.f13365a.hasDeadline();
    }

    @Override // k3.C0683E
    public final void throwIfReached() throws IOException {
        this.f13365a.throwIfReached();
    }

    @Override // k3.C0683E
    public final C0683E timeout(long j4, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.f13365a.timeout(j4, unit);
    }

    @Override // k3.C0683E
    public final long timeoutNanos() {
        return this.f13365a.timeoutNanos();
    }

    @Override // k3.C0683E
    public final C0683E deadlineNanoTime(long j4) {
        return this.f13365a.deadlineNanoTime(j4);
    }
}
