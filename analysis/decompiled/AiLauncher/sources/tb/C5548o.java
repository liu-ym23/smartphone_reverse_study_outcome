package tb;

import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import yb.C6032m;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004R\u00020\u0005H\u0000¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\b\u0018\u00010\u0004R\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J;\u0010\u0017\u001a\u00020\u00072\u000e\b\u0002\u0010\u0014\u001a\b\u0018\u00010\u0004R\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0016\u001a\b\u0018\u00010\u0004R\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R*\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010*\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010,R\u001e\u00100\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00050.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010/R\u001e\u00101\u001a\f\u0012\b\u0012\u00060\u0004R\u00020\u00050.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010/R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010/R\u0011\u00104\u001a\u00020+8G¢\u0006\u0006\u001a\u0004\b$\u00103¨\u00065"}, d2 = {"Ltb/o;", "", "<init>", "()V", "Lyb/m$a;", "Lyb/m;", "call", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lyb/m$a;)V", "", Const.INTENT_KEY_PKGNAME, "(Lyb/m;)Z", "e", "f", "(Lyb/m;)V", "", "host", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Lyb/m$a;", "enqueuedCall", "finishedCall", "finishedAsyncCall", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lyb/m$a;Lyb/m;Lyb/m$a;)V", "", "maxRequests", "I", "getMaxRequests", "()I", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(I)V", "maxRequestsPerHost", "getMaxRequestsPerHost", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/lang/Runnable;", "c", "Ljava/lang/Runnable;", "getIdleCallback", "()Ljava/lang/Runnable;", "setIdleCallback", "(Ljava/lang/Runnable;)V", "idleCallback", "Ljava/util/concurrent/ExecutorService;", "Ljava/util/concurrent/ExecutorService;", "executorServiceOrNull", "Ljava/util/ArrayDeque;", "Ljava/util/ArrayDeque;", "readyAsyncCalls", "runningAsyncCalls", "runningSyncCalls", "()Ljava/util/concurrent/ExecutorService;", "executorService", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: tb.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5548o {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Runnable idleCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public ExecutorService executorServiceOrNull;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int maxRequests = 64;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int maxRequestsPerHost = 5;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final ArrayDeque<C6032m.a> readyAsyncCalls = new ArrayDeque<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final ArrayDeque<C6032m.a> runningAsyncCalls = new ArrayDeque<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final ArrayDeque<C6032m> runningSyncCalls = new ArrayDeque<>();

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003R\u00020\u00040\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR!\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003R\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f¨\u0006\u0010"}, d2 = {"tb/o$a", "", "", "Lyb/m$a;", "Lyb/m;", "callsToExecute", "Ljava/lang/Runnable;", "idleCallbackToRun", "<init>", "(Ljava/util/List;Ljava/lang/Runnable;)V", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Runnable;", "()Ljava/lang/Runnable;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.o$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final List<C6032m.a> callsToExecute;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final Runnable idleCallbackToRun;

        public a(List<C6032m.a> callsToExecute, Runnable runnable) {
            kotlin.jvm.internal.p.i(callsToExecute, "callsToExecute");
            this.callsToExecute = callsToExecute;
            this.idleCallbackToRun = runnable;
        }

        public final List<C6032m.a> a() {
            return this.callsToExecute;
        }

        /* renamed from: b, reason: from getter */
        public final Runnable getIdleCallbackToRun() {
            return this.idleCallbackToRun;
        }
    }

    public static /* synthetic */ void h(C5548o c5548o, C6032m.a aVar, C6032m c6032m, C6032m.a aVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            aVar = null;
        }
        if ((i10 & 2) != 0) {
            c6032m = null;
        }
        if ((i10 & 4) != 0) {
            aVar2 = null;
        }
        c5548o.g(aVar, c6032m, aVar2);
    }

    public final void a(C6032m.a call) {
        kotlin.jvm.internal.p.i(call, "call");
        h(this, call, null, null, 6, null);
    }

    public final synchronized boolean b(C6032m call) {
        kotlin.jvm.internal.p.i(call, "call");
        return this.runningSyncCalls.add(call);
    }

    public final synchronized ExecutorService c() {
        ExecutorService executorService;
        try {
            if (this.executorServiceOrNull == null) {
                this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), ub.q.q(ub.q.f42675c + " Dispatcher", false));
            }
            executorService = this.executorServiceOrNull;
            kotlin.jvm.internal.p.f(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    public final C6032m.a d(String host) {
        Iterator<C6032m.a> it = this.runningAsyncCalls.iterator();
        kotlin.jvm.internal.p.h(it, "iterator(...)");
        while (it.hasNext()) {
            C6032m.a next = it.next();
            if (kotlin.jvm.internal.p.d(next.f(), host)) {
                return next;
            }
        }
        Iterator<C6032m.a> it2 = this.readyAsyncCalls.iterator();
        kotlin.jvm.internal.p.h(it2, "iterator(...)");
        while (it2.hasNext()) {
            C6032m.a next2 = it2.next();
            if (kotlin.jvm.internal.p.d(next2.f(), host)) {
                return next2;
            }
        }
        return null;
    }

    public final void e(C6032m.a call) {
        kotlin.jvm.internal.p.i(call, "call");
        h(this, null, null, call, 3, null);
    }

    public final void f(C6032m call) {
        kotlin.jvm.internal.p.i(call, "call");
        h(this, null, call, null, 5, null);
    }

    public final void g(C6032m.a enqueuedCall, C6032m finishedCall, C6032m.a finishedAsyncCall) {
        a aVar;
        C6032m.a aVarD;
        ub.q.e(this);
        boolean zIsShutdown = c().isShutdown();
        synchronized (this) {
            if (finishedCall != null) {
                try {
                    if (!this.runningSyncCalls.remove(finishedCall)) {
                        throw new IllegalStateException("Call wasn't in-flight!");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (finishedAsyncCall != null) {
                finishedAsyncCall.getCallsPerHost().decrementAndGet();
                if (!this.runningAsyncCalls.remove(finishedAsyncCall)) {
                    throw new IllegalStateException("Call wasn't in-flight!");
                }
            }
            if (enqueuedCall != null) {
                this.readyAsyncCalls.add(enqueuedCall);
                if (!enqueuedCall.getF44234c().getForWebSocket() && (aVarD = d(enqueuedCall.f())) != null) {
                    enqueuedCall.g(aVarD);
                }
            }
            Runnable runnable = (!(finishedCall == null && finishedAsyncCall == null) && (zIsShutdown || this.runningAsyncCalls.isEmpty()) && this.runningSyncCalls.isEmpty()) ? this.idleCallback : null;
            if (zIsShutdown) {
                List listM1 = Z8.F.m1(this.readyAsyncCalls);
                this.readyAsyncCalls.clear();
                aVar = new a(listM1, runnable);
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<C6032m.a> it = this.readyAsyncCalls.iterator();
                kotlin.jvm.internal.p.h(it, "iterator(...)");
                while (it.hasNext()) {
                    C6032m.a next = it.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    }
                    if (next.getCallsPerHost().get() < this.maxRequestsPerHost) {
                        it.remove();
                        next.getCallsPerHost().incrementAndGet();
                        kotlin.jvm.internal.p.f(next);
                        arrayList.add(next);
                        this.runningAsyncCalls.add(next);
                    }
                }
                aVar = new a(arrayList, runnable);
            }
        }
        int size = aVar.a().size();
        boolean z10 = true;
        for (int i10 = 0; i10 < size; i10++) {
            C6032m.a aVar2 = aVar.a().get(i10);
            if (aVar2 == enqueuedCall) {
                z10 = false;
            } else {
                aVar2.getF44234c().getEventListener().l(aVar2.getF44234c(), this);
            }
            if (zIsShutdown) {
                C6032m.a.c(aVar2, null, 1, null);
            } else {
                aVar2.a(c());
            }
        }
        if (z10 && enqueuedCall != null) {
            enqueuedCall.getF44234c().getEventListener().m(enqueuedCall.getF44234c(), this);
        }
        Runnable idleCallbackToRun = aVar.getIdleCallbackToRun();
        if (idleCallbackToRun != null) {
            idleCallbackToRun.run();
        }
    }

    public final void i(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException(("max < 1: " + i10).toString());
        }
        synchronized (this) {
            this.maxRequests = i10;
            Y8.t tVar = Y8.t.f7040a;
        }
        h(this, null, null, null, 7, null);
    }

    public final void j(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException(("max < 1: " + i10).toString());
        }
        synchronized (this) {
            this.maxRequestsPerHost = i10;
            Y8.t tVar = Y8.t.f7040a;
        }
        h(this, null, null, null, 7, null);
    }
}
