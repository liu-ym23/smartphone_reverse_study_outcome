package bolts;

import com.larus.apm.impl.protector.RunnableProtector;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import v.b;
import v.c;

/* JADX INFO: loaded from: classes28.dex */
public class CancellationTokenSource implements Closeable {
    private boolean cancellationRequested;
    private boolean closed;
    private final ScheduledExecutorService executor;
    private final Object lock;
    private final List<c> registrations;
    private ScheduledFuture<?> scheduledCancellation;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationTokenSource f19881a;

        @Override // java.lang.Runnable
        public final void run() {
            Object r100 = CancellationTokenSource.access$000(this.f19881a);     // Catch: Throwable -> L11
            monitor-enter(r100);     // Catch: Throwable -> L11
            CancellationTokenSource.access$102(this.f19881a, null);     // Catch: Throwable -> L8
            monitor-exit(r100);     // Catch: Throwable -> L8
            this.f19881a.cancel();     // Catch: Throwable -> L11
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L15;
            return;
        L15:
            throw th;
        }

        public a(CancellationTokenSource r100) {
            this.f19881a = r100;
        }
    }

    private void cancelScheduledCancellation() {
        ScheduledFuture<?> r100 = this.scheduledCancellation;
        if (r100 == null) goto L6;
        r100.cancel(true);
        this.scheduledCancellation = null;
        return;
    }

    private void throwIfClosed() {
        if (this.closed == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("Object already closed");
    }

    public void cancel() {
        Object r100 = this.lock;
        monitor-enter(r100);
        throwIfClosed();     // Catch: Throwable -> L12
        if (this.cancellationRequested == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L8:
        cancelScheduledCancellation();     // Catch: Throwable -> L12
        this.cancellationRequested = true;     // Catch: Throwable -> L12
        ArrayList r101 = new ArrayList(this.registrations);     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        notifyListeners(r101);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Object r100 = this.lock;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.closed == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L8:
        cancelScheduledCancellation();     // Catch: Throwable -> L15
        Iterator r101 = new ArrayList(this.registrations).iterator();     // Catch: Throwable -> L15
    L10:
        if (r101.hasNext() == false) goto L12;
        ((c) r101.next()).close();     // Catch: Throwable -> L15
        goto L10
    L12:
        this.registrations.clear();     // Catch: Throwable -> L15
        this.closed = true;     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
    }

    public CancellationToken getToken() {
        Object r100 = this.lock;
        monitor-enter(r100);
        throwIfClosed();     // Catch: Throwable -> L7
        CancellationToken r101 = new CancellationToken(this);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isCancellationRequested() {
        Object r100 = this.lock;
        monitor-enter(r100);
        throwIfClosed();     // Catch: Throwable -> L7
        boolean r101 = this.cancellationRequested;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public void throwIfCancellationRequested() throws CancellationException {
        Object r100 = this.lock;
        monitor-enter(r100);
        throwIfClosed();     // Catch: Throwable -> L10
        if (this.cancellationRequested == true) goto L9;
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L9:
        throw new CancellationException();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested())});
    }

    public CancellationTokenSource() {
        this.lock = new Object();
        this.registrations = new ArrayList();
        this.executor = b.f552263d.f552265b;
    }

    public static /* synthetic */ Object access$000(CancellationTokenSource r100) {
        return r100.lock;
    }

    private void notifyListeners(List<c> r100) {
        Iterator<c> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a();
        goto L4
    }

    public void cancelAfter(long r100) {
        cancelAfter(r100, TimeUnit.MILLISECONDS);
    }

    public c register(Runnable r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        throwIfClosed();     // Catch: Throwable -> L10
        c r102 = new c(this, r100);     // Catch: Throwable -> L10
        if (this.cancellationRequested == false) goto L7;
        r102.a();     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return r102;
    L7:
        this.registrations.add(r102);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void unregister(c r100) {
        Object r101 = this.lock;
        monitor-enter(r101);
        throwIfClosed();     // Catch: Throwable -> L7
        this.registrations.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ ScheduledFuture access$102(CancellationTokenSource r100, ScheduledFuture r101) {
        r100.scheduledCancellation = r101;
        return r101;
    }

    private void cancelAfter(long r100, TimeUnit r101) {
        if (r100 < (-1)) goto L23;
        if (r100 != 0) goto L8;
        cancel();
        return;
    L8:
        Object r102 = this.lock;
        monitor-enter(r102);
    L19:
        th = move-exception;
        throw th;
    L11:
        if (this.cancellationRequested == false) goto L14;
        monitor-exit(r102);     // Catch: Throwable -> L19
        return;
    L14:
        cancelScheduledCancellation();     // Catch: Throwable -> L19
        if (r100 == (-1)) goto L17;
        this.scheduledCancellation = this.executor.schedule(new a(this), r100, r101);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r102);     // Catch: Throwable -> L19
        return;
    L23:
        throw new IllegalArgumentException("Delay must be >= -1");
    }
}
