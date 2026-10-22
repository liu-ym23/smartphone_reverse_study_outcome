package yb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import xb.AbstractC5870a;
import xb.C5872c;
import xb.C5873d;
import yb.C6032m;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u00013\u0018\u0000 $2\u00020\u0001:\u0001\u0019B1\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJA\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u001c¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010(R\u001a\u0010\u000b\u001a\u00020\n8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010/\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001f\u0010,\u001a\u0004\b-\u0010.R\u0014\u00102\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u00104R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0018068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u00107¨\u00069"}, d2 = {"Lyb/o;", "", "Lxb/d;", "taskRunner", "", "maxIdleConnections", "", "keepAliveDuration", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "Lyb/g;", "connectionListener", "<init>", "(Lxb/d;IJLjava/util/concurrent/TimeUnit;Lyb/g;)V", "", "doExtensiveHealthChecks", "Ltb/a;", Const.JSON_KEY_ADDRESS, "Lyb/m;", "call", "", "Ltb/E;", "routes", "requireMultiplexed", "Lyb/n;", Const.INTENT_KEY_APIKEY, "(ZLtb/a;Lyb/m;Ljava/util/List;Z)Lyb/n;", "connection", "LY8/t;", "f", "(Lyb/n;)V", "c", "(Lyb/n;)Z", "now", Const.INTENT_KEY_PKGNAME, "(J)J", Const.INTENT_KEY_BACKGROUND_COMMAND, "()V", "e", "(Lyb/n;J)I", "I", "Lyb/g;", Const.INTENT_KEY_UMID, "()Lyb/g;", "J", "getKeepAliveDurationNs$okhttp", "()J", "keepAliveDurationNs", "Lxb/c;", "Lxb/c;", "cleanupQueue", "yb/o$b", "Lyb/o$b;", "cleanupTask", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "connections", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6034o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int maxIdleConnections;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AbstractC6026g connectionListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long keepAliveDurationNs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final C5872c cleanupQueue;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final b cleanupTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final ConcurrentLinkedQueue<C6033n> connections;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"yb/o$b", "Lxb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.o$b */
    public static final class b extends AbstractC5870a {
        public b(String str) {
            super(str, false, 2, null);
        }

        @Override // xb.AbstractC5870a
        public long f() {
            return C6034o.this.b(System.nanoTime());
        }
    }

    public C6034o(C5873d taskRunner, int i10, long j10, TimeUnit timeUnit, AbstractC6026g connectionListener) {
        kotlin.jvm.internal.p.i(taskRunner, "taskRunner");
        kotlin.jvm.internal.p.i(timeUnit, "timeUnit");
        kotlin.jvm.internal.p.i(connectionListener, "connectionListener");
        this.maxIdleConnections = i10;
        this.connectionListener = connectionListener;
        this.keepAliveDurationNs = timeUnit.toNanos(j10);
        this.cleanupQueue = taskRunner.k();
        this.cleanupTask = new b(ub.q.f42675c + " ConnectionPool connection closer");
        this.connections = new ConcurrentLinkedQueue<>();
        if (j10 > 0) {
            return;
        }
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j10).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[Catch: all -> 0x0030, TryCatch #0 {all -> 0x0030, blocks: (B:9:0x0029, B:14:0x0032, B:17:0x0039), top: B:38:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final yb.C6033n a(boolean r6, tb.C5534a r7, yb.C6032m r8, java.util.List<tb.C5532E> r9, boolean r10) throws java.io.IOException {
        /*
            r5 = this;
            java.lang.String r0 = "address"
            kotlin.jvm.internal.p.i(r7, r0)
            java.lang.String r0 = "call"
            kotlin.jvm.internal.p.i(r8, r0)
            java.util.concurrent.ConcurrentLinkedQueue<yb.n> r0 = r5.connections
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r1 = "iterator(...)"
            kotlin.jvm.internal.p.h(r0, r1)
        L15:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L6c
            java.lang.Object r1 = r0.next()
            yb.n r1 = (yb.C6033n) r1
            kotlin.jvm.internal.p.f(r1)
            monitor-enter(r1)
            r2 = 1
            r3 = 0
            if (r10 == 0) goto L32
            boolean r4 = r1.r()     // Catch: java.lang.Throwable -> L30
            if (r4 != 0) goto L32
            goto L3d
        L30:
            r5 = move-exception
            goto L6a
        L32:
            boolean r4 = r1.p(r7, r9)     // Catch: java.lang.Throwable -> L30
            if (r4 != 0) goto L39
            goto L3d
        L39:
            r8.f(r1)     // Catch: java.lang.Throwable -> L30
            r3 = r2
        L3d:
            monitor-exit(r1)
            if (r3 == 0) goto L15
            boolean r3 = r1.q(r6)
            if (r3 == 0) goto L47
            return r1
        L47:
            monitor-enter(r1)
            boolean r3 = r1.getNoNewExchanges()     // Catch: java.lang.Throwable -> L67
            r1.x(r2)     // Catch: java.lang.Throwable -> L67
            java.net.Socket r2 = r8.B()     // Catch: java.lang.Throwable -> L67
            monitor-exit(r1)
            if (r2 == 0) goto L5f
            ub.q.h(r2)
            yb.g r2 = r5.connectionListener
            r2.f(r1)
            goto L15
        L5f:
            if (r3 != 0) goto L15
            yb.g r2 = r5.connectionListener
            r2.h(r1)
            goto L15
        L67:
            r5 = move-exception
            monitor-exit(r1)
            throw r5
        L6a:
            monitor-exit(r1)
            throw r5
        L6c:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: yb.C6034o.a(boolean, tb.a, yb.m, java.util.List, boolean):yb.n");
    }

    public final long b(long now) throws IOException {
        long j10 = (now - this.keepAliveDurationNs) + 1;
        Iterator<C6033n> it = this.connections.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        C6033n c6033n = null;
        long j11 = Long.MAX_VALUE;
        int i10 = 0;
        C6033n c6033n2 = null;
        C6033n c6033n3 = null;
        int i11 = 0;
        while (it.hasNext()) {
            C6033n next = it.next();
            kotlin.jvm.internal.p.f(next);
            synchronized (next) {
                if (e(next, now) > 0) {
                    i11++;
                } else {
                    long idleAtNs = next.getIdleAtNs();
                    if (idleAtNs < j10) {
                        c6033n2 = next;
                        j10 = idleAtNs;
                    }
                    i10++;
                    if (idleAtNs < j11) {
                        c6033n3 = next;
                        j11 = idleAtNs;
                    }
                }
                Y8.t tVar = Y8.t.f7040a;
            }
        }
        if (c6033n2 != null) {
            c6033n = c6033n2;
        } else if (i10 > this.maxIdleConnections) {
            j10 = j11;
            c6033n = c6033n3;
        } else {
            j10 = -1;
        }
        if (c6033n == null) {
            if (c6033n3 != null) {
                return (j11 + this.keepAliveDurationNs) - now;
            }
            if (i11 > 0) {
                return this.keepAliveDurationNs;
            }
            return -1L;
        }
        synchronized (c6033n) {
            if (!c6033n.i().isEmpty()) {
                return 0L;
            }
            if (c6033n.getIdleAtNs() != j10) {
                return 0L;
            }
            c6033n.x(true);
            this.connections.remove(c6033n);
            ub.q.h(c6033n.getJavaNetSocket());
            this.connectionListener.f(c6033n);
            if (this.connections.isEmpty()) {
                this.cleanupQueue.a();
            }
            return 0L;
        }
    }

    public final boolean c(C6033n connection) {
        kotlin.jvm.internal.p.i(connection, "connection");
        if (ub.q.f42674b && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        if (!connection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            g();
            return false;
        }
        connection.x(true);
        this.connections.remove(connection);
        if (this.connections.isEmpty()) {
            this.cleanupQueue.a();
        }
        return true;
    }

    /* renamed from: d, reason: from getter */
    public final AbstractC6026g getConnectionListener() {
        return this.connectionListener;
    }

    public final int e(C6033n connection, long now) {
        if (ub.q.f42674b && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
        }
        List<Reference<C6032m>> listI = connection.i();
        int i10 = 0;
        while (i10 < listI.size()) {
            Reference<C6032m> reference = listI.get(i10);
            if (reference.get() != null) {
                i10++;
            } else {
                kotlin.jvm.internal.p.g(reference, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
                okhttp3.internal.platform.c.INSTANCE.e().logCloseableLeak("A connection to " + connection.u().getAddress().getUrl() + " was leaked. Did you forget to close a response body?", ((C6032m.b) reference).getCallStackTrace());
                listI.remove(i10);
                if (listI.isEmpty()) {
                    connection.w(now - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return listI.size();
    }

    public final void f(C6033n connection) {
        kotlin.jvm.internal.p.i(connection, "connection");
        if (!ub.q.f42674b || Thread.holdsLock(connection)) {
            this.connections.add(connection);
            g();
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + connection);
    }

    public final void g() {
        C5872c.m(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }
}
