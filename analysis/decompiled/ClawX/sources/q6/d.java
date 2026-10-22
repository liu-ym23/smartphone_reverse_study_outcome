package q6;

import androidx.emoji2.text.m;
import java.util.ArrayList;
import java.util.TimeZone;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import kotlin.jvm.internal.p;
import o6.e;
import o6.f;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: k, reason: collision with root package name */
    public static final Logger f4878k;

    /* renamed from: l, reason: collision with root package name */
    public static final d f4879l;

    /* renamed from: a, reason: collision with root package name */
    public final m f4880a;

    /* renamed from: b, reason: collision with root package name */
    public final Logger f4881b;

    /* renamed from: c, reason: collision with root package name */
    public int f4882c;
    public boolean d;

    /* renamed from: e, reason: collision with root package name */
    public long f4883e;

    /* renamed from: f, reason: collision with root package name */
    public int f4884f;

    /* renamed from: g, reason: collision with root package name */
    public int f4885g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f4886h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f4887i;

    /* renamed from: j, reason: collision with root package name */
    public final androidx.fragment.app.b f4888j;

    static {
        Logger logger = Logger.getLogger(d.class.getName());
        p.d(logger, "getLogger(...)");
        f4878k = logger;
        String name = f.f4331b + " TaskRunner";
        p.e(name, "name");
        e eVar = new e(name, true);
        m mVar = new m();
        mVar.f621a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), eVar);
        f4879l = new d(mVar);
    }

    public d(m mVar) {
        Logger logger = f4878k;
        p.e(logger, "logger");
        this.f4880a = mVar;
        this.f4881b = logger;
        this.f4882c = 10000;
        this.f4886h = new ArrayList();
        this.f4887i = new ArrayList();
        this.f4888j = new androidx.fragment.app.b(8, this);
    }

    public static final void a(d dVar, a aVar, long j4, boolean z) {
        TimeZone timeZone = f.f4330a;
        c cVar = aVar.f4870c;
        p.b(cVar);
        if (cVar.d != aVar) {
            throw new IllegalStateException("Check failed.");
        }
        boolean z2 = cVar.f4877f;
        cVar.f4877f = false;
        cVar.d = null;
        dVar.f4886h.remove(cVar);
        if (j4 != -1 && !z2 && !cVar.f4875c) {
            cVar.d(aVar, j4, true);
        }
        if (cVar.f4876e.isEmpty()) {
            return;
        }
        dVar.f4887i.add(cVar);
        if (z) {
            return;
        }
        dVar.e();
    }

    public final a b() {
        long j4;
        a aVar;
        boolean z;
        TimeZone timeZone = f.f4330a;
        while (true) {
            ArrayList arrayList = this.f4887i;
            if (arrayList.isEmpty()) {
                return null;
            }
            long jNanoTime = System.nanoTime();
            int size = arrayList.size();
            long jMin = Util.VLI_MAX;
            int i8 = 0;
            a aVar2 = null;
            while (true) {
                if (i8 >= size) {
                    j4 = jNanoTime;
                    aVar = null;
                    z = false;
                    break;
                }
                Object obj = arrayList.get(i8);
                i8++;
                a aVar3 = (a) ((c) obj).f4876e.get(0);
                j4 = jNanoTime;
                aVar = null;
                long jMax = Math.max(0L, aVar3.d - j4);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (aVar2 != null) {
                        z = true;
                        break;
                    }
                    aVar2 = aVar3;
                }
                jNanoTime = j4;
            }
            ArrayList arrayList2 = this.f4886h;
            if (aVar2 != null) {
                TimeZone timeZone2 = f.f4330a;
                aVar2.d = -1L;
                c cVar = aVar2.f4870c;
                p.b(cVar);
                cVar.f4876e.remove(aVar2);
                arrayList.remove(cVar);
                cVar.d = aVar2;
                arrayList2.add(cVar);
                if (z || (!this.d && !arrayList.isEmpty())) {
                    e();
                }
                return aVar2;
            }
            if (this.d) {
                if (jMin >= this.f4883e - j4) {
                    return aVar;
                }
                notify();
                return aVar;
            }
            this.d = true;
            this.f4883e = j4 + jMin;
            try {
                try {
                    TimeZone timeZone3 = f.f4330a;
                    if (jMin > 0) {
                        long j8 = jMin / 1000000;
                        long j9 = jMin - (1000000 * j8);
                        if (j8 > 0 || jMin > 0) {
                            wait(j8, (int) j9);
                        }
                    }
                } catch (InterruptedException unused) {
                    TimeZone timeZone4 = f.f4330a;
                    for (int size2 = arrayList2.size() - 1; -1 < size2; size2--) {
                        ((c) arrayList2.get(size2)).a();
                    }
                    for (int size3 = arrayList.size() - 1; -1 < size3; size3--) {
                        c cVar2 = (c) arrayList.get(size3);
                        cVar2.a();
                        if (cVar2.f4876e.isEmpty()) {
                            arrayList.remove(size3);
                        }
                    }
                }
            } finally {
                this.d = false;
            }
        }
    }

    public final void c(c taskQueue) {
        p.e(taskQueue, "taskQueue");
        TimeZone timeZone = f.f4330a;
        if (taskQueue.d == null) {
            boolean zIsEmpty = taskQueue.f4876e.isEmpty();
            ArrayList arrayList = this.f4887i;
            if (zIsEmpty) {
                arrayList.remove(taskQueue);
            } else {
                byte[] bArr = o6.d.f4327a;
                p.e(arrayList, "<this>");
                if (!arrayList.contains(taskQueue)) {
                    arrayList.add(taskQueue);
                }
            }
        }
        if (this.d) {
            notify();
        } else {
            e();
        }
    }

    public final c d() {
        int i8;
        synchronized (this) {
            i8 = this.f4882c;
            this.f4882c = i8 + 1;
        }
        return new c(this, a8.b.j(i8, "Q"));
    }

    public final void e() {
        TimeZone timeZone = f.f4330a;
        int i8 = this.f4884f;
        if (i8 > this.f4885g) {
            return;
        }
        this.f4884f = i8 + 1;
        androidx.fragment.app.b runnable = this.f4888j;
        p.e(runnable, "runnable");
        ((ThreadPoolExecutor) this.f4880a.f621a).execute(runnable);
    }
}
