package q6;

import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import k4.v;
import kotlin.jvm.internal.p;
import o6.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final d f4873a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4874b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4875c;
    public a d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f4876e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4877f;

    public c(d dVar, String name) {
        p.e(name, "name");
        this.f4873a = dVar;
        this.f4874b = name;
        this.f4876e = new ArrayList();
    }

    public static void b(c cVar, String name, long j4, p5.a block, int i8) {
        if ((i8 & 2) != 0) {
            j4 = 0;
        }
        boolean z = (i8 & 4) != 0;
        cVar.getClass();
        p.e(name, "name");
        p.e(block, "block");
        cVar.c(new b(name, z, block), j4);
    }

    public final boolean a() {
        a aVar = this.d;
        if (aVar != null && aVar.f4869b) {
            this.f4877f = true;
        }
        ArrayList arrayList = this.f4876e;
        boolean z = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((a) arrayList.get(size)).f4869b) {
                Logger logger = this.f4873a.f4881b;
                a aVar2 = (a) arrayList.get(size);
                if (logger.isLoggable(Level.FINE)) {
                    v.c(logger, aVar2, this, "canceled");
                }
                arrayList.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void c(a task, long j4) {
        p.e(task, "task");
        synchronized (this.f4873a) {
            if (!this.f4875c) {
                if (d(task, j4, false)) {
                    this.f4873a.c(this);
                }
            } else if (task.f4869b) {
                Logger logger = this.f4873a.f4881b;
                if (logger.isLoggable(Level.FINE)) {
                    v.c(logger, task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                Logger logger2 = this.f4873a.f4881b;
                if (logger2.isLoggable(Level.FINE)) {
                    v.c(logger2, task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
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
    public final boolean d(q6.a r12, long r13, boolean r15) {
        /*
            r11 = this;
            q6.d r0 = r11.f4873a
            java.util.logging.Logger r0 = r0.f4881b
            java.lang.String r1 = "task"
            kotlin.jvm.internal.p.e(r12, r1)
            q6.c r1 = r12.f4870c
            if (r1 != r11) goto Le
            goto L12
        Le:
            if (r1 != 0) goto L89
            r12.f4870c = r11
        L12:
            long r1 = java.lang.System.nanoTime()
            long r3 = r1 + r13
            java.util.ArrayList r5 = r11.f4876e
            int r6 = r5.indexOf(r12)
            r7 = -1
            r8 = 0
            if (r6 == r7) goto L39
            long r9 = r12.d
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 > 0) goto L36
            java.util.logging.Level r13 = java.util.logging.Level.FINE
            boolean r13 = r0.isLoggable(r13)
            if (r13 == 0) goto L88
            java.lang.String r13 = "already scheduled"
            k4.v.c(r0, r12, r11, r13)
            return r8
        L36:
            r5.remove(r6)
        L39:
            r12.d = r3
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            boolean r6 = r0.isLoggable(r6)
            if (r6 == 0) goto L5f
            if (r15 == 0) goto L51
            long r3 = r3 - r1
            java.lang.String r15 = k4.v.y(r3)
            java.lang.String r3 = "run again after "
            java.lang.String r15 = r3.concat(r15)
            goto L5c
        L51:
            long r3 = r3 - r1
            java.lang.String r15 = k4.v.y(r3)
            java.lang.String r3 = "scheduled after "
            java.lang.String r15 = r3.concat(r15)
        L5c:
            k4.v.c(r0, r12, r11, r15)
        L5f:
            int r11 = r5.size()
            r15 = r8
            r0 = r15
        L65:
            if (r0 >= r11) goto L7a
            java.lang.Object r3 = r5.get(r0)
            int r0 = r0 + 1
            q6.a r3 = (q6.a) r3
            long r3 = r3.d
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
        throw new UnsupportedOperationException("Method not decompiled: q6.c.d(q6.a, long, boolean):boolean");
    }

    public final void e() {
        d dVar = this.f4873a;
        TimeZone timeZone = f.f4330a;
        synchronized (dVar) {
            this.f4875c = true;
            if (a()) {
                this.f4873a.c(this);
            }
        }
    }

    public final String toString() {
        return this.f4874b;
    }
}
