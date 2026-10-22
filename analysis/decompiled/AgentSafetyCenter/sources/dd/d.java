package dd;

import a1.g;
import androidx.fragment.app.r;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: h, reason: collision with root package name */
    public static final d f3311h;
    public static final Logger i;

    /* renamed from: a, reason: collision with root package name */
    public g f3312a;

    /* renamed from: b, reason: collision with root package name */
    public int f3313b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3314c;

    /* renamed from: d, reason: collision with root package name */
    public long f3315d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f3316e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f3317f;

    /* renamed from: g, reason: collision with root package name */
    public r f3318g;

    static {
        String strN = androidx.activity.b.n(new StringBuilder(), bd.b.f2080g, " TaskRunner");
        bd.a aVar = new bd.a();
        aVar.f2072c = strN;
        aVar.f2073f = true;
        VarHandle.storeStoreFence();
        g gVar = new g(7, false);
        gVar.f19f = new ThreadPoolExecutor(0, Reader.READ_DONE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), aVar);
        VarHandle.storeStoreFence();
        d dVar = new d();
        dVar.f3312a = gVar;
        dVar.f3313b = 10000;
        dVar.f3316e = new ArrayList();
        dVar.f3317f = new ArrayList();
        r rVar = new r(5);
        rVar.f1301f = dVar;
        VarHandle.storeStoreFence();
        dVar.f3318g = rVar;
        VarHandle.storeStoreFence();
        f3311h = dVar;
        Logger logger = Logger.getLogger(d.class.getName());
        logger.getClass();
        i = logger;
    }

    public static final void a(d dVar, a aVar) {
        byte[] bArr = bd.b.f2074a;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(aVar.f3299a);
        try {
            long jA = aVar.a();
            synchronized (dVar) {
                dVar.b(aVar, jA);
            }
            threadCurrentThread.setName(name);
        } catch (Throwable th) {
            synchronized (dVar) {
                dVar.b(aVar, -1L);
                threadCurrentThread.setName(name);
                throw th;
            }
        }
    }

    public final void b(a aVar, long j10) {
        byte[] bArr = bd.b.f2074a;
        c cVar = aVar.f3301c;
        cVar.getClass();
        if (cVar.f3308d != aVar) {
            f.e("Check failed.");
            return;
        }
        boolean z10 = cVar.f3310f;
        cVar.f3310f = false;
        cVar.f3308d = null;
        this.f3316e.remove(cVar);
        if (j10 != -1 && !z10 && !cVar.f3307c) {
            cVar.d(aVar, j10, true);
        }
        if (cVar.f3309e.isEmpty()) {
            return;
        }
        this.f3317f.add(cVar);
    }

    /* JADX WARN: Finally extract failed */
    public final a c() {
        long j10;
        a aVar;
        long j11;
        boolean z10;
        ArrayList arrayList = this.f3316e;
        g gVar = this.f3312a;
        ArrayList arrayList2 = this.f3317f;
        byte[] bArr = bd.b.f2074a;
        while (!arrayList2.isEmpty()) {
            long jNanoTime = System.nanoTime();
            int size = arrayList2.size();
            int i3 = 0;
            long jMin = Long.MAX_VALUE;
            int i10 = 0;
            a aVar2 = null;
            while (true) {
                if (i10 >= size) {
                    j10 = 0;
                    aVar = null;
                    j11 = jMin;
                    z10 = false;
                    break;
                }
                Object obj = arrayList2.get(i10);
                i10++;
                aVar = null;
                a aVar3 = (a) ((c) obj).f3309e.get(i3);
                long j12 = jMin;
                long jMax = Math.max(0L, aVar3.f3302d - jNanoTime);
                if (jMax > 0) {
                    jMin = Math.min(jMax, j12);
                } else {
                    j10 = 0;
                    j11 = j12;
                    if (aVar2 != null) {
                        z10 = true;
                        break;
                    }
                    aVar2 = aVar3;
                    jMin = j11;
                }
                i3 = 0;
            }
            if (aVar2 != null) {
                byte[] bArr2 = bd.b.f2074a;
                aVar2.f3302d = -1L;
                c cVar = aVar2.f3301c;
                cVar.getClass();
                cVar.f3309e.remove(aVar2);
                arrayList2.remove(cVar);
                cVar.f3308d = aVar2;
                arrayList.add(cVar);
                if (z10 || (!this.f3314c && !arrayList2.isEmpty())) {
                    r rVar = this.f3318g;
                    rVar.getClass();
                    ((ThreadPoolExecutor) gVar.f19f).execute(rVar);
                }
                return aVar2;
            }
            if (this.f3314c) {
                if (j11 >= this.f3315d - jNanoTime) {
                    return aVar;
                }
                notify();
                return aVar;
            }
            this.f3314c = true;
            this.f3315d = jNanoTime + j11;
            try {
                try {
                    long j13 = j11 / 1000000;
                    long j14 = j11 - (1000000 * j13);
                    if (j13 > j10 || j11 > j10) {
                        wait(j13, (int) j14);
                    }
                } catch (InterruptedException unused) {
                    for (int size2 = arrayList.size() - 1; -1 < size2; size2--) {
                        ((c) arrayList.get(size2)).b();
                    }
                    for (int size3 = arrayList2.size() - 1; -1 < size3; size3--) {
                        c cVar2 = (c) arrayList2.get(size3);
                        cVar2.b();
                        if (cVar2.f3309e.isEmpty()) {
                            arrayList2.remove(size3);
                        }
                    }
                }
                this.f3314c = false;
            } catch (Throwable th) {
                this.f3314c = false;
                throw th;
            }
        }
        return null;
    }

    public final void d(c cVar) {
        cVar.getClass();
        byte[] bArr = bd.b.f2074a;
        if (cVar.f3308d == null) {
            boolean zIsEmpty = cVar.f3309e.isEmpty();
            ArrayList arrayList = this.f3317f;
            if (zIsEmpty) {
                arrayList.remove(cVar);
            } else {
                arrayList.getClass();
                if (!arrayList.contains(cVar)) {
                    arrayList.add(cVar);
                }
            }
        }
        boolean z10 = this.f3314c;
        g gVar = this.f3312a;
        if (z10) {
            notify();
            return;
        }
        r rVar = this.f3318g;
        rVar.getClass();
        ((ThreadPoolExecutor) gVar.f19f).execute(rVar);
    }

    public final c e() {
        int i3;
        synchronized (this) {
            i3 = this.f3313b;
            this.f3313b = i3 + 1;
        }
        String strJ = k0.a.j(i3, "Q");
        c cVar = new c();
        cVar.f3305a = this;
        cVar.f3306b = strJ;
        cVar.f3309e = new ArrayList();
        VarHandle.storeStoreFence();
        return cVar;
    }
}
