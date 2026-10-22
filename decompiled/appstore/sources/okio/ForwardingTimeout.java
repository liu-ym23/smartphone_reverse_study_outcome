package okio;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public class ForwardingTimeout extends Timeout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Timeout f23031a;

    public ForwardingTimeout(Timeout r10) {
        q.h(r10, "delegate");
        this.f23031a = r10;
    }

    public final Timeout a() {
        return this.f23031a;
    }

    public final ForwardingTimeout b(Timeout r10) {
        q.h(r10, "delegate");
        this.f23031a = r10;
        return this;
    }

    @Override // okio.Timeout
    public Timeout clearDeadline() {
        return this.f23031a.clearDeadline();
    }

    @Override // okio.Timeout
    public Timeout clearTimeout() {
        return this.f23031a.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.f23031a.deadlineNanoTime();
    }

    @Override // okio.Timeout
    public boolean hasDeadline() {
        return this.f23031a.hasDeadline();
    }

    @Override // okio.Timeout
    public void throwIfReached() {
        this.f23031a.throwIfReached();
    }

    @Override // okio.Timeout
    public Timeout timeout(long r10, TimeUnit r11) {
        q.h(r11, "unit");
        return this.f23031a.timeout(r10, r11);
    }

    @Override // okio.Timeout
    public long timeoutNanos() {
        return this.f23031a.timeoutNanos();
    }

    @Override // okio.Timeout
    public Timeout deadlineNanoTime(long r10) {
        return this.f23031a.deadlineNanoTime(r10);
    }
}
