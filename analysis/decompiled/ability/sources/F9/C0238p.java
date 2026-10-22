package F9;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: F9.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0238p {
    public ThreadPoolExecutor c;

    /* renamed from: a, reason: collision with root package name */
    public int f653a = 64;
    public int b = 5;
    public final ArrayDeque d = new ArrayDeque();
    public final ArrayDeque e = new ArrayDeque();
    public final ArrayDeque f = new ArrayDeque();

    public final synchronized void a() {
        try {
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((J9.f) it.next()).c.cancel();
            }
            Iterator it2 = this.e.iterator();
            while (it2.hasNext()) {
                ((J9.f) it2.next()).c.cancel();
            }
            Iterator it3 = this.f.iterator();
            while (it3.hasNext()) {
                ((J9.i) it3.next()).cancel();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor;
        try {
            if (this.c == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue synchronousQueue = new SynchronousQueue();
                String name = G9.b.h + " Dispatcher";
                kotlin.jvm.internal.k.f(name, "name");
                this.c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new G9.a(name, false));
            }
            threadPoolExecutor = this.c;
            kotlin.jvm.internal.k.c(threadPoolExecutor);
        } catch (Throwable th) {
            throw th;
        }
        return threadPoolExecutor;
    }

    public final void c(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        e();
    }

    public final void d(J9.f fVar) {
        fVar.b.decrementAndGet();
        c(this.e, fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            r8 = this;
            byte[] r0 = G9.b.f704a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            monitor-enter(r8)
            java.util.ArrayDeque r1 = r8.d     // Catch: java.lang.Throwable -> L44
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L44
            java.lang.String r2 = "readyAsyncCalls.iterator()"
            kotlin.jvm.internal.k.e(r1, r2)     // Catch: java.lang.Throwable -> L44
        L13:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L44
            if (r2 == 0) goto L46
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L44
            J9.f r2 = (J9.f) r2     // Catch: java.lang.Throwable -> L44
            java.util.ArrayDeque r3 = r8.e     // Catch: java.lang.Throwable -> L44
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L44
            int r4 = r8.f653a     // Catch: java.lang.Throwable -> L44
            if (r3 >= r4) goto L46
            java.util.concurrent.atomic.AtomicInteger r3 = r2.b     // Catch: java.lang.Throwable -> L44
            int r3 = r3.get()     // Catch: java.lang.Throwable -> L44
            int r4 = r8.b     // Catch: java.lang.Throwable -> L44
            if (r3 >= r4) goto L13
            r1.remove()     // Catch: java.lang.Throwable -> L44
            java.util.concurrent.atomic.AtomicInteger r3 = r2.b     // Catch: java.lang.Throwable -> L44
            r3.incrementAndGet()     // Catch: java.lang.Throwable -> L44
            r0.add(r2)     // Catch: java.lang.Throwable -> L44
            java.util.ArrayDeque r3 = r8.e     // Catch: java.lang.Throwable -> L44
            r3.add(r2)     // Catch: java.lang.Throwable -> L44
            goto L13
        L44:
            r0 = move-exception
            goto L9b
        L46:
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L44
            java.util.ArrayDeque r1 = r8.e     // Catch: java.lang.Throwable -> L98
            r1.size()     // Catch: java.lang.Throwable -> L98
            java.util.ArrayDeque r1 = r8.f     // Catch: java.lang.Throwable -> L98
            r1.size()     // Catch: java.lang.Throwable -> L98
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L44
            monitor-exit(r8)
            int r1 = r0.size()
            r2 = 0
        L58:
            if (r2 >= r1) goto L97
            java.lang.Object r3 = r0.get(r2)
            J9.f r3 = (J9.f) r3
            java.util.concurrent.ExecutorService r4 = r8.b()
            r3.getClass()
            J9.i r5 = r3.c
            byte[] r6 = G9.b.f704a
            java.util.concurrent.ThreadPoolExecutor r4 = (java.util.concurrent.ThreadPoolExecutor) r4     // Catch: java.util.concurrent.RejectedExecutionException -> L71 java.lang.Throwable -> L8e
            r4.execute(r3)     // Catch: java.util.concurrent.RejectedExecutionException -> L71 java.lang.Throwable -> L8e
            goto L8b
        L71:
            r4 = move-exception
            java.io.InterruptedIOException r6 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L8e
            java.lang.String r7 = "executor rejected"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L8e
            r6.initCause(r4)     // Catch: java.lang.Throwable -> L8e
            r5.j(r6)     // Catch: java.lang.Throwable -> L8e
            F9.g r4 = r3.f895a     // Catch: java.lang.Throwable -> L8e
            r4.j(r5, r6)     // Catch: java.lang.Throwable -> L8e
            F9.F r4 = r5.f897a
            F9.p r4 = r4.f616a
            r4.d(r3)
        L8b:
            int r2 = r2 + 1
            goto L58
        L8e:
            r8 = move-exception
            F9.F r0 = r5.f897a
            F9.p r0 = r0.f616a
            r0.d(r3)
            throw r8
        L97:
            return
        L98:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L98
            throw r0     // Catch: java.lang.Throwable -> L44
        L9b:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: F9.C0238p.e():void");
    }

    public final void f(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(B7.a.h(i, "max < 1: ").toString());
        }
        synchronized (this) {
            this.f653a = i;
        }
        e();
    }

    public final void g(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(B7.a.h(i, "max < 1: ").toString());
        }
        synchronized (this) {
            this.b = i;
        }
        e();
    }
}
