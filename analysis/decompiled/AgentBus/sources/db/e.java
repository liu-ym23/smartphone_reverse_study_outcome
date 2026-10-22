package db;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;
import n.f;
import q7.k;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: h, reason: collision with root package name */
    public static final e f3030h;

    /* renamed from: i, reason: collision with root package name */
    public static final Logger f3031i;

    /* renamed from: a, reason: collision with root package name */
    public final a7.d f3032a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3034c;

    /* renamed from: d, reason: collision with root package name */
    public long f3035d;

    /* renamed from: b, reason: collision with root package name */
    public int f3033b = 10000;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f3036e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f3037f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final d f3038g = new d(0, this);

    static {
        String str = bb.b.f1665g + " TaskRunner";
        k.e(str, "name");
        f3030h = new e(new a7.d(new bb.a(str, true)));
        Logger logger = Logger.getLogger(e.class.getName());
        k.d(logger, "getLogger(TaskRunner::class.java.name)");
        f3031i = logger;
    }

    public e(a7.d dVar) {
        this.f3032a = dVar;
    }

    public static final void a(e eVar, a aVar) {
        byte[] bArr = bb.b.f1659a;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.f3016a);
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

    public final void b(a aVar, long j2) {
        byte[] bArr = bb.b.f1659a;
        c cVar = aVar.f3018c;
        k.b(cVar);
        if (cVar.f3025d != aVar) {
            throw new IllegalStateException("Check failed.");
        }
        boolean z4 = cVar.f3027f;
        cVar.f3027f = false;
        cVar.f3025d = null;
        this.f3036e.remove(cVar);
        if (j2 != -1 && !z4 && !cVar.f3024c) {
            cVar.d(aVar, j2, true);
        }
        if (cVar.f3026e.isEmpty()) {
            return;
        }
        this.f3037f.add(cVar);
    }

    public final a c() {
        boolean z4;
        byte[] bArr = bb.b.f1659a;
        while (true) {
            ArrayList arrayList = this.f3037f;
            if (arrayList.isEmpty()) {
                break;
            }
            long jNanoTime = System.nanoTime();
            Iterator it = arrayList.iterator();
            long jMin = Long.MAX_VALUE;
            a aVar = null;
            while (true) {
                if (!it.hasNext()) {
                    z4 = false;
                    break;
                }
                a aVar2 = (a) ((c) it.next()).f3026e.get(0);
                long jMax = Math.max(0L, aVar2.f3019d - jNanoTime);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar != null) {
                        z4 = true;
                        break;
                    }
                    aVar = aVar2;
                }
            }
            ArrayList arrayList2 = this.f3036e;
            if (aVar != null) {
                byte[] bArr2 = bb.b.f1659a;
                aVar.f3019d = -1L;
                c cVar = aVar.f3018c;
                k.b(cVar);
                cVar.f3026e.remove(aVar);
                arrayList.remove(cVar);
                cVar.f3025d = aVar;
                arrayList2.add(cVar);
                if (z4 || (!this.f3034c && !arrayList.isEmpty())) {
                    d dVar = this.f3038g;
                    k.e(dVar, "runnable");
                    ((ThreadPoolExecutor) this.f3032a.f411g).execute(dVar);
                }
                return aVar;
            }
            if (!this.f3034c) {
                this.f3034c = true;
                this.f3035d = jNanoTime + jMin;
                try {
                    try {
                        long j2 = jMin / 1000000;
                        long j4 = jMin - (1000000 * j2);
                        if (j2 > 0 || jMin > 0) {
                            wait(j2, (int) j4);
                        }
                    } catch (InterruptedException unused) {
                        for (int size = arrayList2.size() - 1; -1 < size; size--) {
                            ((c) arrayList2.get(size)).b();
                        }
                        for (int size2 = arrayList.size() - 1; -1 < size2; size2--) {
                            c cVar2 = (c) arrayList.get(size2);
                            cVar2.b();
                            if (cVar2.f3026e.isEmpty()) {
                                arrayList.remove(size2);
                            }
                        }
                    }
                } finally {
                    this.f3034c = false;
                }
            } else if (jMin < this.f3035d - jNanoTime) {
                notify();
            }
        }
        return null;
    }

    public final void d(c cVar) {
        k.e(cVar, "taskQueue");
        byte[] bArr = bb.b.f1659a;
        if (cVar.f3025d == null) {
            boolean zIsEmpty = cVar.f3026e.isEmpty();
            ArrayList arrayList = this.f3037f;
            if (zIsEmpty) {
                arrayList.remove(cVar);
            } else {
                k.e(arrayList, "<this>");
                if (!arrayList.contains(cVar)) {
                    arrayList.add(cVar);
                }
            }
        }
        if (this.f3034c) {
            notify();
            return;
        }
        d dVar = this.f3038g;
        k.e(dVar, "runnable");
        ((ThreadPoolExecutor) this.f3032a.f411g).execute(dVar);
    }

    public final c e() {
        int i2;
        synchronized (this) {
            i2 = this.f3033b;
            this.f3033b = i2 + 1;
        }
        return new c(this, f.c(i2, "Q"));
    }
}
