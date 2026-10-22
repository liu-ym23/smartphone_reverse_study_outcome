package I9;

import A6.l;
import androidx.compose.animation.core.AnimationKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class e {
    public static final e h;
    public static final Logger i;

    /* renamed from: a, reason: collision with root package name */
    public final d f854a;
    public boolean c;
    public long d;
    public int b = 10000;
    public final ArrayList e = new ArrayList();
    public final ArrayList f = new ArrayList();
    public final l g = new l(this, 8);

    static {
        String name = G9.b.h + " TaskRunner";
        k.f(name, "name");
        h = new e(new d(new G9.a(name, true)));
        Logger logger = Logger.getLogger(e.class.getName());
        k.e(logger, "getLogger(TaskRunner::class.java.name)");
        i = logger;
    }

    public e(d dVar) {
        this.f854a = dVar;
    }

    public static final void a(e eVar, a aVar) {
        byte[] bArr = G9.b.f704a;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.f851a);
        try {
            long jA = aVar.a();
            synchronized (eVar) {
                eVar.b(aVar, jA);
            }
            threadCurrentThread.setName(name);
        } catch (Throwable th) {
            synchronized (eVar) {
                eVar.b(aVar, -1L);
                threadCurrentThread.setName(name);
                throw th;
            }
        }
    }

    public final void b(a aVar, long j5) {
        byte[] bArr = G9.b.f704a;
        c cVar = aVar.c;
        k.c(cVar);
        if (cVar.d != aVar) {
            throw new IllegalStateException("Check failed.");
        }
        boolean z10 = cVar.f;
        cVar.f = false;
        cVar.d = null;
        this.e.remove(cVar);
        if (j5 != -1 && !z10 && !cVar.c) {
            cVar.d(aVar, j5, true);
        }
        if (cVar.e.isEmpty()) {
            return;
        }
        this.f.add(cVar);
    }

    public final a c() {
        boolean z10;
        byte[] bArr = G9.b.f704a;
        while (true) {
            ArrayList arrayList = this.f;
            if (arrayList.isEmpty()) {
                break;
            }
            long jNanoTime = System.nanoTime();
            Iterator it = arrayList.iterator();
            long jMin = Long.MAX_VALUE;
            a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z10 = false;
                    break;
                }
                a aVar2 = (a) ((c) it.next()).e.get(0);
                long jMax = Math.max(0L, aVar2.d - jNanoTime);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar != null) {
                        z10 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            ArrayList arrayList2 = this.e;
            if (aVar != null) {
                byte[] bArr2 = G9.b.f704a;
                aVar.d = -1L;
                c cVar = aVar.c;
                k.c(cVar);
                cVar.e.remove(aVar);
                arrayList.remove(cVar);
                cVar.d = aVar;
                arrayList2.add(cVar);
                if (z10 || (!this.c && !arrayList.isEmpty())) {
                    l runnable = this.g;
                    k.f(runnable, "runnable");
                    this.f854a.f853a.execute(runnable);
                }
                return aVar;
            }
            if (!this.c) {
                this.c = true;
                this.d = jNanoTime + jMin;
                try {
                    try {
                        long j5 = jMin / AnimationKt.MillisToNanos;
                        long j6 = jMin - (AnimationKt.MillisToNanos * j5);
                        if (j5 > 0 || jMin > 0) {
                            wait(j5, (int) j6);
                        }
                    } catch (InterruptedException unused) {
                        for (int size = arrayList2.size() - 1; -1 < size; size--) {
                            ((c) arrayList2.get(size)).b();
                        }
                        for (int size2 = arrayList.size() - 1; -1 < size2; size2--) {
                            c cVar2 = (c) arrayList.get(size2);
                            cVar2.b();
                            if (cVar2.e.isEmpty()) {
                                arrayList.remove(size2);
                            }
                        }
                    }
                } finally {
                    this.c = false;
                }
            } else if (jMin < this.d - jNanoTime) {
                notify();
            }
        }
        return null;
    }

    public final void d(c taskQueue) {
        k.f(taskQueue, "taskQueue");
        byte[] bArr = G9.b.f704a;
        if (taskQueue.d == null) {
            boolean zIsEmpty = taskQueue.e.isEmpty();
            ArrayList arrayList = this.f;
            if (zIsEmpty) {
                arrayList.remove(taskQueue);
            } else {
                k.f(arrayList, "<this>");
                if (!arrayList.contains(taskQueue)) {
                    arrayList.add(taskQueue);
                }
            }
        }
        if (this.c) {
            notify();
            return;
        }
        l runnable = this.g;
        k.f(runnable, "runnable");
        this.f854a.f853a.execute(runnable);
    }

    public final c e() {
        int i6;
        synchronized (this) {
            i6 = this.b;
            this.b = i6 + 1;
        }
        return new c(this, B7.a.h(i6, "Q"));
    }
}
