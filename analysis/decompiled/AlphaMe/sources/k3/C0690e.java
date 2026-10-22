package k3;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: k3.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0690e extends C0683E {

    @NotNull
    public static final C0686a Companion = new C0686a();
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;

    @Nullable
    private static C0690e head;
    private boolean inQueue;

    @Nullable
    private C0690e next;
    private long timeoutAt;

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static final long access$remainingNanos(C0690e c0690e, long j4) {
        return c0690e.timeoutAt - j4;
    }

    @PublishedApi
    @NotNull
    public final IOException access$newTimeoutException(@Nullable IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            Companion.getClass();
            synchronized (C0690e.class) {
                try {
                    if (!(!this.inQueue)) {
                        throw new IllegalStateException("Unbalanced enter/exit".toString());
                    }
                    this.inQueue = true;
                    if (head == null) {
                        head = new C0690e();
                        new C0687b(0).start();
                    }
                    long jNanoTime = System.nanoTime();
                    if (jTimeoutNanos != 0 && zHasDeadline) {
                        this.timeoutAt = Math.min(jTimeoutNanos, deadlineNanoTime() - jNanoTime) + jNanoTime;
                    } else if (jTimeoutNanos != 0) {
                        this.timeoutAt = jTimeoutNanos + jNanoTime;
                    } else {
                        if (!zHasDeadline) {
                            throw new AssertionError();
                        }
                        this.timeoutAt = deadlineNanoTime();
                    }
                    long jAccess$remainingNanos = access$remainingNanos(this, jNanoTime);
                    C0690e c0690e = head;
                    Intrinsics.checkNotNull(c0690e);
                    while (c0690e.next != null) {
                        C0690e c0690e2 = c0690e.next;
                        Intrinsics.checkNotNull(c0690e2);
                        if (jAccess$remainingNanos < access$remainingNanos(c0690e2, jNanoTime)) {
                            break;
                        }
                        c0690e = c0690e.next;
                        Intrinsics.checkNotNull(c0690e);
                    }
                    this.next = c0690e.next;
                    c0690e.next = this;
                    if (c0690e == head) {
                        C0690e.class.notify();
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final boolean exit() {
        Companion.getClass();
        synchronized (C0690e.class) {
            if (!this.inQueue) {
                return false;
            }
            this.inQueue = false;
            for (C0690e c0690e = head; c0690e != null; c0690e = c0690e.next) {
                if (c0690e.next == this) {
                    c0690e.next = this.next;
                    this.next = null;
                    return false;
                }
            }
            return true;
        }
    }

    @NotNull
    public IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @NotNull
    public final z sink(@NotNull z sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return new C0688c(this, sink);
    }

    @NotNull
    public final InterfaceC0680B source(@NotNull InterfaceC0680B source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new C0689d(this, source);
    }

    public void timedOut() {
    }

    public final <T> T withTimeout(@NotNull Function0<? extends T> block) throws IOException {
        Intrinsics.checkNotNullParameter(block, "block");
        enter();
        try {
            try {
                T tInvoke = block.invoke();
                InlineMarker.finallyStart(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                InlineMarker.finallyEnd(1);
                return tInvoke;
            } catch (IOException e4) {
                if (exit()) {
                    throw access$newTimeoutException(e4);
                }
                throw e4;
            }
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            exit();
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }
}
