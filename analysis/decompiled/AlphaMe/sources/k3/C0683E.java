package k3;

import androidx.room.AbstractC0351g;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* renamed from: k3.E, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0683E {

    @NotNull
    public static final C0682D Companion = new C0682D();

    @JvmField
    @NotNull
    public static final C0683E NONE = new C0681C();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    @NotNull
    public C0683E clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    @NotNull
    public C0683E clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    @NotNull
    public final C0683E deadline(long j4, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j4 <= 0) {
            throw new IllegalArgumentException(AbstractC0351g.n("duration <= 0: ", j4).toString());
        }
        return deadlineNanoTime(unit.toNanos(j4) + System.nanoTime());
    }

    @NotNull
    public C0683E deadlineNanoTime(long j4) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j4;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(@NotNull C0683E other, @NotNull Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(block, "block");
        long jTimeoutNanos = timeoutNanos();
        C0682D c0682d = Companion;
        long jTimeoutNanos2 = other.timeoutNanos();
        long jTimeoutNanos3 = timeoutNanos();
        c0682d.getClass();
        if (jTimeoutNanos2 == 0 || (jTimeoutNanos3 != 0 && jTimeoutNanos2 >= jTimeoutNanos3)) {
            jTimeoutNanos2 = jTimeoutNanos3;
        }
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout(jTimeoutNanos2, timeUnit);
        if (!hasDeadline()) {
            if (other.hasDeadline()) {
                deadlineNanoTime(other.deadlineNanoTime());
            }
            try {
                T tInvoke = block.invoke();
                InlineMarker.finallyStart(1);
                timeout(jTimeoutNanos, timeUnit);
                if (other.hasDeadline()) {
                    clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                return tInvoke;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
                if (other.hasDeadline()) {
                    clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        long jDeadlineNanoTime = deadlineNanoTime();
        if (other.hasDeadline()) {
            deadlineNanoTime(Math.min(deadlineNanoTime(), other.deadlineNanoTime()));
        }
        try {
            T tInvoke2 = block.invoke();
            InlineMarker.finallyStart(1);
            timeout(jTimeoutNanos, timeUnit);
            if (other.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            InlineMarker.finallyEnd(1);
            return tInvoke2;
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            if (other.hasDeadline()) {
                deadlineNanoTime(jDeadlineNanoTime);
            }
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    @NotNull
    public C0683E timeout(long j4, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j4 < 0) {
            throw new IllegalArgumentException(AbstractC0351g.n("timeout < 0: ", j4).toString());
        }
        this.timeoutNanos = unit.toNanos(j4);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(@NotNull Object monitor) throws InterruptedException, InterruptedIOException {
        Intrinsics.checkNotNullParameter(monitor, "monitor");
        try {
            boolean zHasDeadline = hasDeadline();
            long jTimeoutNanos = timeoutNanos();
            long jNanoTime = 0;
            if (!zHasDeadline && jTimeoutNanos == 0) {
                monitor.wait();
                return;
            }
            long jNanoTime2 = System.nanoTime();
            if (zHasDeadline && jTimeoutNanos != 0) {
                jTimeoutNanos = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime2);
            } else if (zHasDeadline) {
                jTimeoutNanos = deadlineNanoTime() - jNanoTime2;
            }
            if (jTimeoutNanos > 0) {
                long j4 = jTimeoutNanos / 1000000;
                monitor.wait(j4, (int) (jTimeoutNanos - (1000000 * j4)));
                jNanoTime = System.nanoTime() - jNanoTime2;
            }
            if (jNanoTime >= jTimeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline".toString());
    }
}
