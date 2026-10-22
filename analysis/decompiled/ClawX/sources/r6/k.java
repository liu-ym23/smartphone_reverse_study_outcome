package r6;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k implements h {

    /* renamed from: a, reason: collision with root package name */
    public final r f5147a;

    /* renamed from: b, reason: collision with root package name */
    public final q6.d f5148b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5149c;
    public long d;

    /* renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList f5150e;

    /* renamed from: f, reason: collision with root package name */
    public final LinkedBlockingDeque f5151f;

    public k(r rVar, q6.d taskRunner) {
        kotlin.jvm.internal.p.e(taskRunner, "taskRunner");
        this.f5147a = rVar;
        this.f5148b = taskRunner;
        this.f5149c = TimeUnit.MILLISECONDS.toNanos(250L);
        this.d = Long.MIN_VALUE;
        this.f5150e = new CopyOnWriteArrayList();
        this.f5151f = new LinkedBlockingDeque();
    }

    @Override // r6.h
    public final p a() throws IOException {
        t tVarD;
        long j4;
        t tVar;
        IOException iOException = null;
        while (true) {
            try {
                if (this.f5150e.isEmpty() && !this.f5147a.a(null)) {
                    c();
                    kotlin.jvm.internal.p.b(iOException);
                    throw iOException;
                }
                if (this.f5147a.f5203l.f5171q) {
                    throw new IOException("Canceled");
                }
                androidx.emoji2.text.m mVar = this.f5148b.f4880a;
                long jNanoTime = System.nanoTime();
                long j8 = this.d - jNanoTime;
                if (this.f5150e.isEmpty() || j8 <= 0) {
                    tVarD = d();
                    j4 = this.f5149c;
                    this.d = jNanoTime + j4;
                } else {
                    j4 = j8;
                    tVarD = null;
                }
                if (tVarD == null) {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    CopyOnWriteArrayList copyOnWriteArrayList = this.f5150e;
                    if (copyOnWriteArrayList.isEmpty() || (tVar = (t) this.f5151f.poll(j4, timeUnit)) == null) {
                        tVarD = null;
                    } else {
                        copyOnWriteArrayList.remove(tVar.f5210a);
                        tVarD = tVar;
                    }
                    if (tVarD == null) {
                    }
                }
                boolean z = false;
                if (tVarD.f5211b == null && tVarD.f5212c == null) {
                    c();
                    if (!tVarD.f5210a.isReady()) {
                        tVarD = tVarD.f5210a.c();
                    }
                    if (tVarD.f5211b == null && tVarD.f5212c == null) {
                        z = true;
                    }
                    if (z) {
                        return tVarD.f5210a.d();
                    }
                }
                Throwable th = tVarD.f5212c;
                if (th != null) {
                    if (!(th instanceof IOException)) {
                        throw th;
                    }
                    if (iOException == null) {
                        iOException = (IOException) th;
                    } else {
                        a.a.a(iOException, th);
                    }
                }
                u uVar = tVarD.f5211b;
                if (uVar != null) {
                    this.f5147a.f5208q.addFirst(uVar);
                }
            } finally {
                c();
            }
        }
    }

    @Override // r6.h
    public final v b() {
        return this.f5147a;
    }

    public final void c() {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f5150e;
        Iterator it = copyOnWriteArrayList.iterator();
        kotlin.jvm.internal.p.d(it, "iterator(...)");
        while (it.hasNext()) {
            u uVar = (u) it.next();
            uVar.cancel();
            u uVarA = uVar.a();
            if (uVarA != null) {
                this.f5147a.f5208q.addLast(uVarA);
            }
        }
        copyOnWriteArrayList.clear();
    }

    public final t d() {
        u iVar;
        r rVar = this.f5147a;
        if (rVar.a(null)) {
            try {
                iVar = rVar.b();
            } catch (Throwable th) {
                iVar = new i(th);
            }
            if (iVar.isReady()) {
                return new t(iVar, (Throwable) null, 6);
            }
            if (iVar instanceof i) {
                return ((i) iVar).f5144a;
            }
            this.f5150e.add(iVar);
            this.f5148b.d().c(new j(o6.f.f4331b + " connect " + rVar.f5201j.f3992h.f(), iVar, this), 0L);
        }
        return null;
    }
}
