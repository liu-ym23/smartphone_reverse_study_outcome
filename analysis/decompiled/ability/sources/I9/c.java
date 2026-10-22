package I9;

import ca.AbstractC0897f;
import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.jvm.internal.k;
import stepai.android.llm.base.twoway.FlowType;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final e f852a;
    public final String b;
    public boolean c;
    public a d;
    public final ArrayList e;
    public boolean f;

    public c(e eVar, String name) {
        k.f(name, "name");
        this.f852a = eVar;
        this.b = name;
        this.e = new ArrayList();
    }

    public final void a() {
        byte[] bArr = G9.b.f704a;
        synchronized (this.f852a) {
            if (b()) {
                this.f852a.d(this);
            }
        }
    }

    public final boolean b() {
        a aVar = this.d;
        if (aVar != null && aVar.b) {
            this.f = true;
        }
        ArrayList arrayList = this.e;
        boolean z10 = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((a) arrayList.get(size)).b) {
                a aVar2 = (a) arrayList.get(size);
                if (e.i.isLoggable(Level.FINE)) {
                    AbstractC0897f.k(aVar2, this, FlowType.CANCELED);
                }
                arrayList.remove(size);
                z10 = true;
            }
        }
        return z10;
    }

    public final void c(a task, long j5) {
        k.f(task, "task");
        synchronized (this.f852a) {
            if (!this.c) {
                if (d(task, j5, false)) {
                    this.f852a.d(this);
                }
            } else if (task.b) {
                if (e.i.isLoggable(Level.FINE)) {
                    AbstractC0897f.k(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (e.i.isLoggable(Level.FINE)) {
                    AbstractC0897f.k(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(I9.a r11, long r12, boolean r14) {
        /*
            r10 = this;
            java.lang.String r0 = "task"
            kotlin.jvm.internal.k.f(r11, r0)
            I9.c r0 = r11.c
            if (r0 != r10) goto La
            goto Le
        La:
            if (r0 != 0) goto L8a
            r11.c = r10
        Le:
            long r0 = java.lang.System.nanoTime()
            long r2 = r0 + r12
            java.util.ArrayList r4 = r10.e
            int r5 = r4.indexOf(r11)
            r6 = 0
            r7 = -1
            if (r5 == r7) goto L37
            long r8 = r11.d
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 > 0) goto L34
            java.util.logging.Logger r12 = I9.e.i
            java.util.logging.Level r13 = java.util.logging.Level.FINE
            boolean r12 = r12.isLoggable(r13)
            if (r12 == 0) goto L89
            java.lang.String r12 = "already scheduled"
            ca.AbstractC0897f.k(r11, r10, r12)
            return r6
        L34:
            r4.remove(r5)
        L37:
            r11.d = r2
            java.util.logging.Logger r5 = I9.e.i
            java.util.logging.Level r8 = java.util.logging.Level.FINE
            boolean r5 = r5.isLoggable(r8)
            if (r5 == 0) goto L5f
            if (r14 == 0) goto L51
            long r2 = r2 - r0
            java.lang.String r14 = ca.AbstractC0897f.z(r2)
            java.lang.String r2 = "run again after "
            java.lang.String r14 = r2.concat(r14)
            goto L5c
        L51:
            long r2 = r2 - r0
            java.lang.String r14 = ca.AbstractC0897f.z(r2)
            java.lang.String r2 = "scheduled after "
            java.lang.String r14 = r2.concat(r14)
        L5c:
            ca.AbstractC0897f.k(r11, r10, r14)
        L5f:
            java.util.Iterator r10 = r4.iterator()
            r14 = r6
        L64:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L7b
            java.lang.Object r2 = r10.next()
            I9.a r2 = (I9.a) r2
            long r2 = r2.d
            long r2 = r2 - r0
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 <= 0) goto L78
            goto L7c
        L78:
            int r14 = r14 + 1
            goto L64
        L7b:
            r14 = r7
        L7c:
            if (r14 != r7) goto L82
            int r14 = r4.size()
        L82:
            r4.add(r14, r11)
            if (r14 != 0) goto L89
            r10 = 1
            return r10
        L89:
            return r6
        L8a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "task is in multiple queues"
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: I9.c.d(I9.a, long, boolean):boolean");
    }

    public final void e() {
        byte[] bArr = G9.b.f704a;
        synchronized (this.f852a) {
            this.c = true;
            if (b()) {
                this.f852a.d(this);
            }
        }
    }

    public final String toString() {
        return this.b;
    }
}
