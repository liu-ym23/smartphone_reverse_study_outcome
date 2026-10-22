package okio;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
final class PushableTimeout extends Timeout {
    private long originalDeadlineNanoTime;
    private boolean originalHasDeadline;
    private long originalTimeoutNanos;
    private Timeout pushed;

    PushableTimeout() {
    }

    void push(Timeout r5) {
        this.pushed = r5;
        boolean r0 = r5.hasDeadline();
        this.originalHasDeadline = r0;
        if (r0 == false) goto L5;
        long r1 = r5.deadlineNanoTime();
    L6:
        this.originalDeadlineNanoTime = r1;
        long r2 = r5.timeoutNanos();
        this.originalTimeoutNanos = r2;
        r5.timeout(minTimeout(r2, timeoutNanos()), TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline == false) goto L12;
        if (hasDeadline() == false) goto L12;
        r5.deadlineNanoTime(Math.min(deadlineNanoTime(), this.originalDeadlineNanoTime));
        return;
    L12:
        if (hasDeadline() == false) goto L16;
        r5.deadlineNanoTime(deadlineNanoTime());
        return;
    L16:
        return;
    L5:
        r1 = -1;
        goto L6
    }

    void pop() {
        this.pushed.timeout(this.originalTimeoutNanos, TimeUnit.NANOSECONDS);
        if (this.originalHasDeadline == false) goto L5;
        this.pushed.deadlineNanoTime(this.originalDeadlineNanoTime);
        return;
    L5:
        this.pushed.clearDeadline();
    }
}
