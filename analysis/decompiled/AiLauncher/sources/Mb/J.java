package Mb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u00112\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001d¨\u0006\u001f"}, d2 = {"LMb/J;", "", "<init>", "()V", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(JLjava/util/concurrent/TimeUnit;)LMb/J;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()J", "", "f", "()Z", Const.INTENT_KEY_UMID, "deadlineNanoTime", "e", "(J)LMb/J;", "c", "()LMb/J;", Const.INTENT_KEY_PKGNAME, "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_APIKEY, "Z", "hasDeadline", "J", "timeoutNanos", "Ljava/lang/Object;", "cancelMark", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class J {

    /* renamed from: f, reason: collision with root package name */
    public static final J f4694f = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean hasDeadline;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public long deadlineNanoTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public long timeoutNanos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public volatile Object cancelMark;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Mb/J$a", "LMb/J;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(JLjava/util/concurrent/TimeUnit;)LMb/J;", "deadlineNanoTime", "e", "(J)LMb/J;", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "okio"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends J {
        @Override // Mb.J
        public J e(long deadlineNanoTime) {
            return this;
        }

        @Override // Mb.J
        public void g() {
        }

        @Override // Mb.J
        public J h(long timeout, TimeUnit unit) {
            kotlin.jvm.internal.p.i(unit, "unit");
            return this;
        }
    }

    public void a() {
        this.cancelMark = new Object();
    }

    public J b() {
        this.hasDeadline = false;
        return this;
    }

    public J c() {
        this.timeoutNanos = 0L;
        return this;
    }

    public long d() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public J e(long deadlineNanoTime) {
        this.hasDeadline = true;
        this.deadlineNanoTime = deadlineNanoTime;
        return this;
    }

    /* renamed from: f, reason: from getter */
    public boolean getHasDeadline() {
        return this.hasDeadline;
    }

    public void g() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException(com.stepos.ailauncher.chat.trace.g.END_INTERRUPTED);
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public J h(long timeout, TimeUnit unit) {
        kotlin.jvm.internal.p.i(unit, "unit");
        if (timeout >= 0) {
            this.timeoutNanos = unit.toNanos(timeout);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + timeout).toString());
    }

    /* renamed from: i, reason: from getter */
    public long getTimeoutNanos() {
        return this.timeoutNanos;
    }
}
