package okio;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedanceos.common.model.AppInfo;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class Timeout {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final Timeout NONE = null;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public static final class Companion {
        public Companion() {
        }

        public final long a(long r10, long r11) {
            if (r10 == 0) goto L12;
            if (r11 != 0) goto L9;
            return r10;
        L9:
            if (r10 >= r11) goto L12;
            return r10;
        L12:
            return r11;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class a extends Timeout {
        public a() {
        }

        @Override // okio.Timeout
        public Timeout deadlineNanoTime(long r10) {
            return this;
        }

        @Override // okio.Timeout
        public void throwIfReached() {
        }

        @Override // okio.Timeout
        public Timeout timeout(long r10, TimeUnit r11) {
            q.h(r11, "unit");
            return this;
        }
    }

    static {
        Companion = new Companion(null);
        NONE = new a();
    }

    public Timeout() {
    }

    @NotNull
    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    @NotNull
    public Timeout clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    @NotNull
    public final Timeout deadline(long r10, @NotNull TimeUnit r11) {
        q.h(r11, "unit");
        if (r10 <= 0) goto L7;
        return deadlineNanoTime(System.nanoTime() + r11.toNanos(r10));
    L7:
        throw new IllegalArgumentException(("duration <= 0: " + r10).toString());
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline == false) goto L7;
        return this.deadlineNanoTime;
    L7:
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final void intersectWith(@NotNull Timeout r12, @NotNull Function0<Unit> r13) {
        q.h(r12, AppInfo.SEARCH_SOURCE_EXTENAL);
        q.h(r13, "block");
        long r10 = timeoutNanos();
        long r11 = Companion.a(r12.timeoutNanos(), timeoutNanos());
        TimeUnit r14 = TimeUnit.NANOSECONDS;
        timeout(r11, r14);
        if (hasDeadline() == false) goto L19;
        long r15 = deadlineNanoTime();
        if (r12.hasDeadline() == false) goto L35;
        deadlineNanoTime(Math.min(deadlineNanoTime(), r12.deadlineNanoTime()));
    L35:
        r13.invoke();     // Catch: Throwable -> L12
        p.b(1);
        timeout(r10, r14);
        if (r12.hasDeadline() == false) goto L11;
        deadlineNanoTime(r15);
    L11:
        p.a(1);
        return;
    L12:
        th = move-exception;
        p.b(1);
        timeout(r10, TimeUnit.NANOSECONDS);
        if (r12.hasDeadline() == false) goto L16;
        deadlineNanoTime(r15);
    L16:
        p.a(1);
        throw th;
    L19:
        if (r12.hasDeadline() == false) goto L33;
        deadlineNanoTime(r12.deadlineNanoTime());
    L33:
        r13.invoke();     // Catch: Throwable -> L27
        p.b(1);
        timeout(r10, r14);
        if (r12.hasDeadline() == false) goto L25;
        clearDeadline();
    L25:
        p.a(1);
        return;
    L27:
        th = move-exception;
        p.b(1);
        timeout(r10, TimeUnit.NANOSECONDS);
        if (r12.hasDeadline() == false) goto L31;
        clearDeadline();
    L31:
        p.a(1);
        throw th;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted() == false) goto L5;
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    L5:
        if (this.hasDeadline == true) goto L7;
        return;
    L7:
        if ((this.deadlineNanoTime - System.nanoTime()) <= 0) goto L10;
        return;
    L10:
        throw new InterruptedIOException("deadline reached");
    }

    @NotNull
    public Timeout timeout(long r10, @NotNull TimeUnit r11) {
        q.h(r11, "unit");
        if (r10 < 0) goto L7;
        this.timeoutNanos = r11.toNanos(r10);
        return this;
    L7:
        throw new IllegalArgumentException(("timeout < 0: " + r10).toString());
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(@NotNull Object r10) throws InterruptedIOException {
        q.h(r10, "monitor");
        boolean r11 = hasDeadline();     // Catch: InterruptedException -> L24
        long r12 = timeoutNanos();     // Catch: InterruptedException -> L24
        long r13 = 0;
        if (r11 == false) goto L6;
    L9:
        long r14 = System.nanoTime();     // Catch: InterruptedException -> L24
        if (r11 == true) goto L12;
    L14:
        if (r11 == false) goto L17;
        r12 = deadlineNanoTime() - r14;     // Catch: InterruptedException -> L24
    L17:
        if (r12 <= 0) goto L20;
        long r15 = r12 / BatteryFactorConfig.WIFI_BPS;     // Catch: InterruptedException -> L24
        r10.wait(r15, (int) (r12 - (BatteryFactorConfig.WIFI_BPS * r15)));     // Catch: InterruptedException -> L24
        r13 = System.nanoTime() - r14;     // Catch: InterruptedException -> L24
    L20:
        if (r13 >= r12) goto L23;
        return;
    L23:
        throw new InterruptedIOException("timeout");     // Catch: InterruptedException -> L24
    L12:
        if (r12 == 0) goto L14;
        r12 = Math.min(r12, deadlineNanoTime() - r14);     // Catch: InterruptedException -> L24
        goto L17
    L6:
        if (r12 != 0) goto L9;
        r10.wait();     // Catch: InterruptedException -> L24
        return;
    L24:
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }

    @NotNull
    public Timeout deadlineNanoTime(long r10) {
        this.hasDeadline = true;
        this.deadlineNanoTime = r10;
        return this;
    }
}
