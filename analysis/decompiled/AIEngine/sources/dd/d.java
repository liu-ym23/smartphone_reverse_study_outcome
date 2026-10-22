package dd;

import bd.l;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.g;
import lb.n;
import okhttp3.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final e f8472a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8473b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8474c;

    /* renamed from: d, reason: collision with root package name */
    public a f8475d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f8476e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8477f;

    public d(e eVar, String name) {
        g.f(name, "name");
        this.f8472a = eVar;
        this.f8473b = name;
        new ReentrantLock();
        this.f8476e = new ArrayList();
    }

    public static void c(d dVar, String name, long j10, zb.a block, int i10) {
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        boolean z = (i10 & 4) != 0;
        dVar.getClass();
        g.f(name, "name");
        g.f(block, "block");
        dVar.d(new b(name, z, block), j10);
    }

    public final void a() {
        f fVar = l.f3237a;
        e eVar = this.f8472a;
        ReentrantLock reentrantLock = eVar.f8482c;
        reentrantLock.lock();
        try {
            if (b()) {
                eVar.d(this);
            }
            n nVar = n.f10413a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean b() {
        a aVar = this.f8475d;
        if (aVar != null && aVar.f8467b) {
            this.f8477f = true;
        }
        ArrayList arrayList = this.f8476e;
        boolean z = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((a) arrayList.get(size)).f8467b) {
                Logger logger = this.f8472a.f8481b;
                a aVar2 = (a) arrayList.get(size);
                if (logger.isLoggable(Level.FINE)) {
                    a4.a.b(logger, aVar2, this, "canceled");
                }
                arrayList.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void d(a task, long j10) {
        g.f(task, "task");
        e eVar = this.f8472a;
        Logger logger = eVar.f8481b;
        ReentrantLock reentrantLock = eVar.f8482c;
        reentrantLock.lock();
        try {
            if (!this.f8474c) {
                if (e(task, j10, false)) {
                    eVar.d(this);
                }
                n nVar = n.f10413a;
            } else if (task.f8467b) {
                if (logger.isLoggable(Level.FINE)) {
                    a4.a.b(logger, task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (logger.isLoggable(Level.FINE)) {
                    a4.a.b(logger, task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0086 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(dd.a r12, long r13, boolean r15) {
        /*
            r11 = this;
            dd.e r0 = r11.f8472a
            java.util.logging.Logger r0 = r0.f8481b
            java.lang.String r1 = "task"
            kotlin.jvm.internal.g.f(r12, r1)
            dd.d r1 = r12.f8468c
            if (r1 != r11) goto Le
            goto L12
        Le:
            if (r1 != 0) goto L89
            r12.f8468c = r11
        L12:
            long r1 = java.lang.System.nanoTime()
            long r3 = r1 + r13
            java.util.ArrayList r5 = r11.f8476e
            int r6 = r5.indexOf(r12)
            r7 = -1
            r8 = 0
            if (r6 == r7) goto L39
            long r9 = r12.f8469d
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 > 0) goto L36
            java.util.logging.Level r13 = java.util.logging.Level.FINE
            boolean r13 = r0.isLoggable(r13)
            if (r13 == 0) goto L88
            java.lang.String r13 = "already scheduled"
            a4.a.b(r0, r12, r11, r13)
            return r8
        L36:
            r5.remove(r6)
        L39:
            r12.f8469d = r3
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            boolean r6 = r0.isLoggable(r6)
            if (r6 == 0) goto L5f
            if (r15 == 0) goto L51
            long r3 = r3 - r1
            java.lang.String r15 = a4.a.l(r3)
            java.lang.String r3 = "run again after "
            java.lang.String r15 = r3.concat(r15)
            goto L5c
        L51:
            long r3 = r3 - r1
            java.lang.String r15 = a4.a.l(r3)
            java.lang.String r3 = "scheduled after "
            java.lang.String r15 = r3.concat(r15)
        L5c:
            a4.a.b(r0, r12, r11, r15)
        L5f:
            int r11 = r5.size()
            r15 = r8
            r0 = r15
        L65:
            if (r0 >= r11) goto L7a
            java.lang.Object r3 = r5.get(r0)
            int r0 = r0 + 1
            dd.a r3 = (dd.a) r3
            long r3 = r3.f8469d
            long r3 = r3 - r1
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 <= 0) goto L77
            goto L7b
        L77:
            int r15 = r15 + 1
            goto L65
        L7a:
            r15 = r7
        L7b:
            if (r15 != r7) goto L81
            int r15 = r5.size()
        L81:
            r5.add(r15, r12)
            if (r15 != 0) goto L88
            r11 = 1
            return r11
        L88:
            return r8
        L89:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "task is in multiple queues"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: dd.d.e(dd.a, long, boolean):boolean");
    }

    public final void f() {
        f fVar = l.f3237a;
        e eVar = this.f8472a;
        ReentrantLock reentrantLock = eVar.f8482c;
        reentrantLock.lock();
        try {
            this.f8474c = true;
            if (b()) {
                eVar.d(this);
            }
            n nVar = n.f10413a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final String toString() {
        return this.f8473b;
    }
}
