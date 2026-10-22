package org.apache.http.pool;

import java.util.concurrent.TimeUnit;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
public abstract class PoolEntry<T, C> {
    private final C conn;
    private final long created;
    private long expiry;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f23033id;
    private final T route;
    private volatile Object state;
    private long updated;
    private final long validityDeadline;

    public PoolEntry(String r10, T r11, C r12, long r13, TimeUnit r14) {
        Args.notNull(r11, "Route");
        Args.notNull(r12, "Connection");
        Args.notNull(r14, "Time unit");
        this.f23033id = r10;
        this.route = r11;
        this.conn = r12;
        long r15 = System.currentTimeMillis();
        this.created = r15;
        this.updated = r15;
        long r16 = Long.MAX_VALUE;
        if (r13 <= 0) goto L8;
        long r17 = r15 + r14.toMillis(r13);
        if (r17 <= 0) goto L7;
        r16 = r17;
    L7:
        this.validityDeadline = r16;
    L9:
        this.expiry = this.validityDeadline;
        return;
    L8:
        this.validityDeadline = Long.MAX_VALUE;
        goto L9
    }

    public abstract void close();

    public C getConnection() {
        return this.conn;
    }

    public long getCreated() {
        return this.created;
    }

    public synchronized long getExpiry() {
        monitor-enter(this);
        long r10 = this.expiry;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public String getId() {
        return this.f23033id;
    }

    public T getRoute() {
        return this.route;
    }

    public Object getState() {
        return this.state;
    }

    public synchronized long getUpdated() {
        monitor-enter(this);
        long r10 = this.updated;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public long getValidUnit() {
        return this.validityDeadline;
    }

    public long getValidityDeadline() {
        return this.validityDeadline;
    }

    public abstract boolean isClosed();

    public synchronized boolean isExpired(long r10) {
        monitor-enter(this);
        if (r10 < this.expiry) goto L7;
        boolean r11 = true;
    L8:
        monitor-exit(this);
        return r11;
    L7:
        r11 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public void setState(Object r10) {
        this.state = r10;
    }

    public String toString() {
        return "[id:" + this.f23033id + "][route:" + this.route + "][state:" + this.state + "]";
    }

    public synchronized void updateExpiry(long r10, TimeUnit r11) {
        monitor-enter(this);
        Args.notNull(r11, "Time unit");     // Catch: Throwable -> L6
        long r12 = System.currentTimeMillis();     // Catch: Throwable -> L6
        this.updated = r12;     // Catch: Throwable -> L6
        if (r10 <= 0) goto L8;
        long r13 = r12 + r11.toMillis(r10);     // Catch: Throwable -> L6
    L9:
        this.expiry = Math.min(r13, this.validityDeadline);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L8:
        r13 = Long.MAX_VALUE;
    L6:
        th = move-exception;
        throw th;
    }

    public PoolEntry(String r10, T r11, C r12) {
        this(r10, r11, r12, 0, TimeUnit.MILLISECONDS);
    }
}
