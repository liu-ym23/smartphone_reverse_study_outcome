package Mb;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0002#\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0010\u0010\u0003J\u0019\u0010\u0013\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014¢\u0006\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018R$\u0010!\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n8\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"LMb/b;", "LMb/J;", "<init>", "()V", "LY8/t;", "t", "", "u", "()Z", Const.INTENT_KEY_APIKEY, "", "now", "x", "(J)J", "y", "(J)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/io/IOException;", "cause", "q", "(Ljava/io/IOException;)Ljava/io/IOException;", "w", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "I", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "index", UxipConstants.f30680s, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "J", "v", "()J", "timeoutAt", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_PKGNAME, "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: Mb.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C0964b extends J {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: collision with root package name */
    public static final B f4706k = new B();

    /* renamed from: l, reason: collision with root package name */
    public static C0964b f4707l;

    /* renamed from: m, reason: collision with root package name */
    public static final ReentrantLock f4708m;

    /* renamed from: n, reason: collision with root package name */
    public static final Condition f4709n;

    /* renamed from: o, reason: collision with root package name */
    public static final long f4710o;

    /* renamed from: p, reason: collision with root package name */
    public static final long f4711p;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public int state;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int index = -1;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public long timeoutAt;

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\nR\u0017\u0010\u0015\u001a\u00020\u00148\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u0014\u0010%\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010 R\u0014\u0010&\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010 R\u0014\u0010'\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010 R\u0014\u0010(\u001a\u00020\u001e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010 ¨\u0006)"}, d2 = {"LMb/b$a;", "", "<init>", "()V", "LMb/b;", Const.INTENT_KEY_PKGNAME, "()LMb/b;", "node", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/b;)V", "LMb/B;", "queue", "LMb/B;", "f", "()LMb/B;", "idleSentinel", "LMb/b;", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "e", "()Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/Condition;", "condition", "Ljava/util/concurrent/locks/Condition;", "c", "()Ljava/util/concurrent/locks/Condition;", "", "TIMEOUT_WRITE_SIZE", "I", "", "IDLE_TIMEOUT_MILLIS", "J", "IDLE_TIMEOUT_NANOS", "STATE_IDLE", "STATE_IN_QUEUE", "STATE_TIMED_OUT", "STATE_CANCELED", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Mb.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C0964b b() throws InterruptedException {
            C0964b c0964bB = f().b();
            if (c0964bB == null) {
                long jNanoTime = System.nanoTime();
                c().await(C0964b.f4710o, TimeUnit.MILLISECONDS);
                if (f().b() != null || System.nanoTime() - jNanoTime < C0964b.f4711p) {
                    return null;
                }
                return d();
            }
            long jX = c0964bB.x(System.nanoTime());
            if (jX > 0) {
                c().await(jX, TimeUnit.NANOSECONDS);
                return null;
            }
            f().e(c0964bB);
            c0964bB.state = 2;
            return c0964bB;
        }

        public final Condition c() {
            return C0964b.f4709n;
        }

        public final C0964b d() {
            return C0964b.f4707l;
        }

        public final ReentrantLock e() {
            return C0964b.f4708m;
        }

        public final B f() {
            return C0964b.f4706k;
        }

        public final void g(C0964b node) {
            if (d() == null) {
                h(new C0964b());
                new C0083b().start();
            }
            C0964b.z(node, 0L, 1, null);
            f().a(node);
            if (node.index == 1) {
                c().signal();
            }
        }

        public final void h(C0964b c0964b) {
            C0964b.f4707l = c0964b;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"LMb/b$b;", "Ljava/lang/Thread;", "<init>", "()V", "LY8/t;", "run", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: Mb.b$b, reason: collision with other inner class name */
    public static final class C0083b extends Thread {
        public C0083b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock reentrantLockE;
            C0964b c0964bB;
            while (true) {
                try {
                    reentrantLockE = C0964b.INSTANCE.e();
                    reentrantLockE.lock();
                    try {
                        c0964bB = C0964b.INSTANCE.b();
                    } finally {
                        reentrantLockE.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (c0964bB == C0964b.INSTANCE.d()) {
                    C0964b.INSTANCE.h(null);
                    return;
                }
                Y8.t tVar = Y8.t.f7040a;
                reentrantLockE.unlock();
                if (c0964bB != null) {
                    c0964bB.A();
                }
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f4708m = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.p.h(conditionNewCondition, "newCondition(...)");
        f4709n = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f4710o = millis;
        f4711p = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public static /* synthetic */ void z(C0964b c0964b, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTimeoutAt");
        }
        if ((i10 & 1) != 0) {
            j10 = System.nanoTime();
        }
        c0964b.y(j10);
    }

    public void A() {
    }

    @Override // Mb.J
    public void a() {
        super.a();
        ReentrantLock reentrantLock = f4708m;
        reentrantLock.lock();
        try {
            if (this.state == 1) {
                f4706k.e(this);
                this.state = 3;
            }
            Y8.t tVar = Y8.t.f7040a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final IOException q(IOException cause) {
        return w(cause);
    }

    public final void t() {
        long timeoutNanos = getTimeoutNanos();
        boolean hasDeadline = getHasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            ReentrantLock reentrantLock = f4708m;
            reentrantLock.lock();
            try {
                if (this.state != 0) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                this.state = 1;
                INSTANCE.g(this);
                Y8.t tVar = Y8.t.f7040a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final boolean u() {
        ReentrantLock reentrantLock = f4708m;
        reentrantLock.lock();
        try {
            int i10 = this.state;
            this.state = 0;
            if (i10 != 1) {
                return i10 == 2;
            }
            f4706k.e(this);
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: v, reason: from getter */
    public final long getTimeoutAt() {
        return this.timeoutAt;
    }

    public IOException w(IOException cause) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (cause != null) {
            interruptedIOException.initCause(cause);
        }
        return interruptedIOException;
    }

    public final long x(long now) {
        return this.timeoutAt - now;
    }

    public final void y(long now) {
        long timeoutNanos = getTimeoutNanos();
        boolean hasDeadline = getHasDeadline();
        if (getTimeoutNanos() != 0 && getHasDeadline()) {
            this.timeoutAt = now + Math.min(timeoutNanos, d() - now);
        } else if (timeoutNanos != 0) {
            this.timeoutAt = now + timeoutNanos;
        } else {
            if (!hasDeadline) {
                throw new AssertionError();
            }
            this.timeoutAt = d();
        }
    }
}
