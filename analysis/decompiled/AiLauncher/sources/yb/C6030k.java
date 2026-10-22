package yb;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import xb.AbstractC5870a;
import xb.C5872c;
import xb.C5873d;
import yb.InterfaceC6039t;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\"R\"\u0010'\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010\u000b0\u000b0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010&¨\u0006("}, d2 = {"Lyb/k;", "Lyb/i;", "Lyb/t;", "routePlanner", "Lxb/d;", "taskRunner", "<init>", "(Lyb/t;Lxb/d;)V", "Lyb/n;", Const.INTENT_KEY_APIKEY, "()Lyb/n;", "Lyb/t$a;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Lyb/t$a;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "e", "(JLjava/util/concurrent/TimeUnit;)Lyb/t$a;", "LY8/t;", "f", "()V", "Lyb/t;", Const.INTENT_KEY_PKGNAME, "()Lyb/t;", "Lxb/d;", "c", "J", "connectDelayNanos", Const.INTENT_KEY_UMID, "nextTcpConnectAtNanos", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lyb/t$b;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "tcpConnectsInFlight", "Ljava/util/concurrent/BlockingQueue;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/BlockingQueue;", "connectResults", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: yb.k, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6030k implements InterfaceC6028i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC6039t routePlanner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final C5873d taskRunner;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long connectDelayNanos;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public long nextTcpConnectAtNanos;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final CopyOnWriteArrayList<InterfaceC6039t.b> tcpConnectsInFlight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final BlockingQueue<InterfaceC6039t.ConnectResult> connectResults;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"yb/k$a", "Lxb/a;", "", "f", "()J", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: yb.k$a */
    public static final class a extends AbstractC5870a {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ InterfaceC6039t.b f44207e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ C6030k f44208f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, InterfaceC6039t.b bVar, C6030k c6030k) {
            super(str, false, 2, null);
            this.f44207e = bVar;
            this.f44208f = c6030k;
        }

        @Override // xb.AbstractC5870a
        public long f() throws InterruptedException {
            InterfaceC6039t.ConnectResult connectResult;
            try {
                connectResult = this.f44207e.g();
            } catch (Throwable th) {
                connectResult = new InterfaceC6039t.ConnectResult(this.f44207e, null, th, 2, null);
            }
            if (!this.f44208f.tcpConnectsInFlight.contains(this.f44207e)) {
                return -1L;
            }
            this.f44208f.connectResults.put(connectResult);
            return -1L;
        }
    }

    public C6030k(InterfaceC6039t routePlanner, C5873d taskRunner) {
        kotlin.jvm.internal.p.i(routePlanner, "routePlanner");
        kotlin.jvm.internal.p.i(taskRunner, "taskRunner");
        this.routePlanner = routePlanner;
        this.taskRunner = taskRunner;
        this.connectDelayNanos = TimeUnit.MILLISECONDS.toNanos(250L);
        this.nextTcpConnectAtNanos = Long.MIN_VALUE;
        this.tcpConnectsInFlight = new CopyOnWriteArrayList<>();
        this.connectResults = taskRunner.getBackend().a(new LinkedBlockingDeque());
    }

    @Override // yb.InterfaceC6028i
    public C6033n a() throws IOException {
        InterfaceC6039t.ConnectResult connectResultG;
        long j10;
        IOException iOException = null;
        while (true) {
            try {
                if (this.tcpConnectsInFlight.isEmpty() && !InterfaceC6039t.f(getRoutePlanner(), null, 1, null)) {
                    f();
                    kotlin.jvm.internal.p.f(iOException);
                    throw iOException;
                }
                if (getRoutePlanner().e()) {
                    throw new IOException("Canceled");
                }
                long jE = this.taskRunner.getBackend().e();
                long j11 = this.nextTcpConnectAtNanos - jE;
                if (this.tcpConnectsInFlight.isEmpty() || j11 <= 0) {
                    connectResultG = g();
                    j10 = this.connectDelayNanos;
                    this.nextTcpConnectAtNanos = jE + j10;
                } else {
                    j10 = j11;
                    connectResultG = null;
                }
                if (connectResultG != null || (connectResultG = e(j10, TimeUnit.NANOSECONDS)) != null) {
                    if (connectResultG.f()) {
                        f();
                        if (!connectResultG.getPlan().getIsReady()) {
                            connectResultG = connectResultG.getPlan().getResult();
                        }
                        if (connectResultG.f()) {
                            return connectResultG.getPlan().getConnection();
                        }
                    }
                    Throwable thE = connectResultG.e();
                    if (thE != null) {
                        if (!(thE instanceof IOException)) {
                            throw thE;
                        }
                        if (iOException == null) {
                            iOException = (IOException) thE;
                        } else {
                            Y8.d.a(iOException, thE);
                        }
                    }
                    InterfaceC6039t.b bVarC = connectResultG.c();
                    if (bVarC != null) {
                        getRoutePlanner().c().addFirst(bVarC);
                    }
                }
            } finally {
                f();
            }
        }
    }

    @Override // yb.InterfaceC6028i
    /* renamed from: b, reason: from getter */
    public InterfaceC6039t getRoutePlanner() {
        return this.routePlanner;
    }

    public final InterfaceC6039t.ConnectResult e(long timeout, TimeUnit unit) {
        InterfaceC6039t.ConnectResult connectResultPoll;
        if (this.tcpConnectsInFlight.isEmpty() || (connectResultPoll = this.connectResults.poll(timeout, unit)) == null) {
            return null;
        }
        this.tcpConnectsInFlight.remove(connectResultPoll.getPlan());
        return connectResultPoll;
    }

    public final void f() {
        Iterator<InterfaceC6039t.b> it = this.tcpConnectsInFlight.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            InterfaceC6039t.b next = it.next();
            next.cancel();
            InterfaceC6039t.b bVarF = next.f();
            if (bVarF != null) {
                getRoutePlanner().c().addLast(bVarF);
            }
        }
        this.tcpConnectsInFlight.clear();
    }

    public final InterfaceC6039t.ConnectResult g() throws IOException {
        InterfaceC6039t.b c6029j;
        if (InterfaceC6039t.f(getRoutePlanner(), null, 1, null)) {
            try {
                c6029j = getRoutePlanner().d();
            } catch (Throwable th) {
                c6029j = new C6029j(th);
            }
            if (c6029j.getIsReady()) {
                return new InterfaceC6039t.ConnectResult(c6029j, null, null, 6, null);
            }
            if (c6029j instanceof C6029j) {
                return ((C6029j) c6029j).d();
            }
            this.tcpConnectsInFlight.add(c6029j);
            C5872c.m(this.taskRunner.k(), new a(ub.q.f42675c + " connect " + getRoutePlanner().getAddress().getUrl().r(), c6029j, this), 0L, 2, null);
        }
        return null;
    }
}
