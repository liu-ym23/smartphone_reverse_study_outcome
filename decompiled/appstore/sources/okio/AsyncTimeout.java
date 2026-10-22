package okio;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import fg.p;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class AsyncTimeout extends Timeout {
    public static final Companion Companion = null;
    private static final long IDLE_TIMEOUT_MILLIS = 0;
    private static final long IDLE_TIMEOUT_NANOS = 0;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    public static final class Companion {
        public Companion() {
        }

        public static final /* synthetic */ boolean a(Companion r10, AsyncTimeout r11) {
            return r10.d(r11);
        }

        public static final /* synthetic */ void b(Companion r10, AsyncTimeout r11, long r12, boolean r13) {
            r10.e(r11, r12, r13);
        }

        public final AsyncTimeout c() {
            AsyncTimeout r10 = AsyncTimeout.access$getHead$cp();
            if (r10 != null) goto L5;
            q.s();
        L5:
            AsyncTimeout r11 = AsyncTimeout.access$getNext$p(r10);
            if (r11 != null) goto L16;
            long r12 = System.nanoTime();
            AsyncTimeout.class.wait(AsyncTimeout.access$getIDLE_TIMEOUT_MILLIS$cp());
            AsyncTimeout r13 = AsyncTimeout.access$getHead$cp();
            if (r13 != null) goto L11;
            q.s();
        L11:
            if (AsyncTimeout.access$getNext$p(r13) == null) goto L13;
            return null;
        L13:
            if ((System.nanoTime() - r12) >= AsyncTimeout.access$getIDLE_TIMEOUT_NANOS$cp()) goto L15;
            return null;
        L15:
            return AsyncTimeout.access$getHead$cp();
        L16:
            long r14 = AsyncTimeout.access$remainingNanos(r11, System.nanoTime());
            if (r14 <= 0) goto L20;
            long r15 = r14 / BatteryFactorConfig.WIFI_BPS;
            AsyncTimeout.class.wait(r15, (int) (r14 - (BatteryFactorConfig.WIFI_BPS * r15)));
            return null;
        L20:
            AsyncTimeout r16 = AsyncTimeout.access$getHead$cp();
            if (r16 != null) goto L23;
            q.s();
        L23:
            AsyncTimeout.access$setNext$p(r16, AsyncTimeout.access$getNext$p(r11));
            AsyncTimeout.access$setNext$p(r11, null);
            return r11;
        }

        public final boolean d(AsyncTimeout r10) {
            monitor-enter(AsyncTimeout.class);
            AsyncTimeout r11 = AsyncTimeout.access$getHead$cp();     // Catch: Throwable -> L12
        L5:
            if (r11 == null) goto L16;
            if (AsyncTimeout.access$getNext$p(r11) == r10) goto L8;
            r11 = AsyncTimeout.access$getNext$p(r11);     // Catch: Throwable -> L12
            goto L5
        L8:
            AsyncTimeout.access$setNext$p(r11, AsyncTimeout.access$getNext$p(r10));     // Catch: Throwable -> L12
            AsyncTimeout.access$setNext$p(r10, null);     // Catch: Throwable -> L12
            monitor-exit(AsyncTimeout.class);
            return false;
        L16:
            monitor-exit(AsyncTimeout.class);
            return true;
        L12:
            th = move-exception;
            throw th;
        }

        public final void e(AsyncTimeout r10, long r11, boolean r12) {
            monitor-enter(AsyncTimeout.class);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (AsyncTimeout.access$getHead$cp() != null) goto L9;
            AsyncTimeout.access$setHead$cp(new AsyncTimeout());     // Catch: Throwable -> L7
            new a().start();     // Catch: Throwable -> L7
        L9:
            long r13 = System.nanoTime();     // Catch: Throwable -> L7
            if (r11 == 0) goto L13;
            if (r12 == false) goto L13;
            AsyncTimeout.access$setTimeoutAt$p(r10, Math.min(r11, r10.deadlineNanoTime() - r13) + r13);     // Catch: Throwable -> L7
        L17:
            long r14 = AsyncTimeout.access$remainingNanos(r10, r13);     // Catch: Throwable -> L7
            AsyncTimeout r15 = AsyncTimeout.access$getHead$cp();     // Catch: Throwable -> L7
            if (r15 != null) goto L21;
            q.s();     // Catch: Throwable -> L7
        L21:
            if (AsyncTimeout.access$getNext$p(r15) == null) goto L31;
            AsyncTimeout r16 = AsyncTimeout.access$getNext$p(r15);     // Catch: Throwable -> L7
            if (r16 != null) goto L26;
            q.s();     // Catch: Throwable -> L7
        L26:
            if (r14 < AsyncTimeout.access$remainingNanos(r16, r13)) goto L31;
            r15 = AsyncTimeout.access$getNext$p(r15);     // Catch: Throwable -> L7
            if (r15 != null) goto L21;
            q.s();     // Catch: Throwable -> L7
        L31:
            AsyncTimeout.access$setNext$p(r10, AsyncTimeout.access$getNext$p(r15));     // Catch: Throwable -> L7
            AsyncTimeout.access$setNext$p(r15, r10);     // Catch: Throwable -> L7
            if (r15 != AsyncTimeout.access$getHead$cp()) goto L34;
            AsyncTimeout.class.notify();     // Catch: Throwable -> L7
        L34:
            Unit r17 = Unit.f21064a;     // Catch: Throwable -> L7
            monitor-exit(AsyncTimeout.class);
            return;
        L13:
            if (r11 == 0) goto L15;
            AsyncTimeout.access$setTimeoutAt$p(r10, r11 + r13);     // Catch: Throwable -> L7
            goto L17
        L15:
            if (r12 == false) goto L38;
            AsyncTimeout.access$setTimeoutAt$p(r10, r10.deadlineNanoTime());     // Catch: Throwable -> L7
            goto L17
        L38:
            throw new AssertionError();     // Catch: Throwable -> L7
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class a extends Thread {
        public a() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
        L20:
            monitor-enter(AsyncTimeout.class);     // Catch: InterruptedException -> L17
            AsyncTimeout r10 = AsyncTimeout.Companion.c();     // Catch: Throwable -> L9
            if (r10 != AsyncTimeout.access$getHead$cp()) goto L11;
            AsyncTimeout.access$setHead$cp(null);     // Catch: Throwable -> L9
            goto L20
        L7:
            monitor-exit(AsyncTimeout.class);     // Catch: InterruptedException -> L17
            return;
        L11:
            Unit r11 = Unit.f21064a;     // Catch: Throwable -> L9
            monitor-exit(AsyncTimeout.class);     // Catch: InterruptedException -> L17
            if (r10 == null) goto L20;
            r10.timedOut();     // Catch: InterruptedException -> L17
        L9:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L17
        }
    }

    public static final class b implements Sink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncTimeout f23014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Sink f23015b;

        public b(AsyncTimeout r10, Sink r11) {
            this.f23014a = r10;
            this.f23015b = r11;
        }

        public AsyncTimeout a() {
            return this.f23014a;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f23014a.enter();
            this.f23015b.close();     // Catch: Throwable -> L6 IOException -> L8
            this.f23014a.exit$jvm(true);
            return;
        L6:
            th = move-exception;
            this.f23014a.exit$jvm(false);
            throw th;
        L8:
            e = move-exception;
            throw this.f23014a.exit$jvm(e);     // Catch: Throwable -> L6
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            this.f23014a.enter();
            this.f23015b.flush();     // Catch: Throwable -> L6 IOException -> L8
            this.f23014a.exit$jvm(true);
            return;
        L6:
            th = move-exception;
            this.f23014a.exit$jvm(false);
            throw th;
        L8:
            e = move-exception;
            throw this.f23014a.exit$jvm(e);     // Catch: Throwable -> L6
        }

        @Override // okio.Sink
        public /* bridge */ /* synthetic */ Timeout timeout() {
            return a();
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f23015b + ')';
        }

        @Override // okio.Sink
        public void write(Buffer r10, long r11) {
            q.h(r10, "source");
            fg.c.b(r10.size(), 0, r11);
        L3:
            long r12 = 0;
            if (r11 <= 0) goto L26;
            p r13 = r10.f23020a;
            if (r13 != null) goto L9;
            q.s();
        L9:
            if (r12 >= 65536) goto L16;
            r12 = r12 + ((long) (r13.f19718c - r13.f19717b));
            if (r12 >= r11) goto L12;
            r13 = r13.f19721f;
            if (r13 != null) goto L9;
            q.s();
            goto L9
        L12:
            r12 = r11;
        L16:
            this.f23014a.enter();
            this.f23015b.write(r10, r12);     // Catch: Throwable -> L19 IOException -> L21
            r11 = r11 - r12;
            this.f23014a.exit$jvm(true);
            goto L3
        L19:
            th = move-exception;
            this.f23014a.exit$jvm(false);
            throw th;
        L21:
            e = move-exception;
            throw this.f23014a.exit$jvm(e);     // Catch: Throwable -> L19
        }
    }

    public static final class c implements Source {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsyncTimeout f23016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Source f23017b;

        public c(AsyncTimeout r10, Source r11) {
            this.f23016a = r10;
            this.f23017b = r11;
        }

        public AsyncTimeout a() {
            return this.f23016a;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f23016a.enter();
            this.f23017b.close();     // Catch: Throwable -> L6 IOException -> L8
            this.f23016a.exit$jvm(true);
            return;
        L6:
            th = move-exception;
            this.f23016a.exit$jvm(false);
            throw th;
        L8:
            e = move-exception;
            throw this.f23016a.exit$jvm(e);     // Catch: Throwable -> L6
        }

        @Override // okio.Source
        public long read(Buffer r10, long r11) {
            q.h(r10, "sink");
            this.f23016a.enter();
            long r12 = this.f23017b.read(r10, r11);     // Catch: Throwable -> L6 IOException -> L8
            this.f23016a.exit$jvm(true);
            return r12;
        L8:
            e = move-exception;
            throw this.f23016a.exit$jvm(e);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            this.f23016a.exit$jvm(false);
            throw th;
        }

        @Override // okio.Source
        public /* bridge */ /* synthetic */ Timeout timeout() {
            return a();
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f23017b + ')';
        }
    }

    static {
        Companion = new Companion(null);
        long r10 = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = r10;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(r10);
    }

    public AsyncTimeout() {
    }

    @Nullable
    public static final /* synthetic */ AsyncTimeout access$getHead$cp() {
        return head;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_MILLIS$cp() {
        return IDLE_TIMEOUT_MILLIS;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_NANOS$cp() {
        return IDLE_TIMEOUT_NANOS;
    }

    @Nullable
    public static final /* synthetic */ AsyncTimeout access$getNext$p(AsyncTimeout r10) {
        return r10.next;
    }

    public static final /* synthetic */ long access$getTimeoutAt$p(AsyncTimeout r10) {
        return r10.timeoutAt;
    }

    public static final /* synthetic */ long access$remainingNanos(AsyncTimeout r10, long r11) {
        return r10.a(r11);
    }

    public static final /* synthetic */ void access$setHead$cp(@Nullable AsyncTimeout r10) {
        head = r10;
    }

    public static final /* synthetic */ void access$setNext$p(AsyncTimeout r10, @Nullable AsyncTimeout r11) {
        r10.next = r11;
    }

    public static final /* synthetic */ void access$setTimeoutAt$p(AsyncTimeout r10, long r11) {
        r10.timeoutAt = r11;
    }

    public final long a(long r10) {
        return this.timeoutAt - r10;
    }

    public final void enter() {
        if (this.inQueue == true) goto L11;
        long r10 = timeoutNanos();
        boolean r11 = hasDeadline();
        if (r10 != 0) goto L8;
        if (r11 == true) goto L8;
        return;
    L8:
        this.inQueue = true;
        Companion.b(Companion, this, r10, r11);
        return;
    L11:
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        if (this.inQueue == true) goto L5;
        return false;
    L5:
        this.inQueue = false;
        return Companion.a(Companion, this);
    }

    public final void exit$jvm(boolean r10) {
        if (exit() == false) goto L8;
        if (r10 == true) goto L7;
        return;
    L7:
        throw newTimeoutException(null);
    }

    public IOException newTimeoutException(IOException r10) {
        InterruptedIOException r11 = new InterruptedIOException("timeout");
        if (r10 == null) goto L5;
        r11.initCause(r10);
    L5:
        return r11;
    }

    @NotNull
    public final Sink sink(@NotNull Sink r10) {
        q.h(r10, "sink");
        return new b(this, r10);
    }

    @NotNull
    public final Source source(@NotNull Source r10) {
        q.h(r10, "source");
        return new c(this, r10);
    }

    public void timedOut() {
    }

    @NotNull
    public final IOException exit$jvm(@NotNull IOException r10) {
        q.h(r10, "cause");
        if (exit() == true) goto L6;
        return r10;
    L6:
        return newTimeoutException(r10);
    }
}
