package Z7;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.proguard.bq;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: Z7.h, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1136h {

    /* renamed from: l, reason: collision with root package name */
    public static C1136h f7506l;

    /* renamed from: b, reason: collision with root package name */
    public final Context f7508b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC1135g f7509c;

    /* renamed from: e, reason: collision with root package name */
    public long f7511e;

    /* renamed from: f, reason: collision with root package name */
    public long f7512f;

    /* renamed from: d, reason: collision with root package name */
    public Map<Integer, Long> f7510d = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f7513g = new LinkedBlockingQueue<>();

    /* renamed from: h, reason: collision with root package name */
    public LinkedBlockingQueue<Runnable> f7514h = new LinkedBlockingQueue<>();

    /* renamed from: i, reason: collision with root package name */
    public final Object f7515i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public long f7516j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f7517k = 0;

    /* renamed from: a, reason: collision with root package name */
    public final V f7507a = V.f();

    /* renamed from: Z7.h$a */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f7518a;

        public a(Runnable runnable) {
            this.f7518a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f7518a.run();
            synchronized (C1136h.this.f7515i) {
                C1136h.p(C1136h.this);
            }
        }
    }

    /* renamed from: Z7.h$b */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f7520a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LinkedBlockingQueue f7521b;

        public b(int i10, LinkedBlockingQueue linkedBlockingQueue) {
            this.f7520a = i10;
            this.f7521b = linkedBlockingQueue;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Runnable runnable;
            for (int i10 = 0; i10 < this.f7520a && (runnable = (Runnable) this.f7521b.poll()) != null; i10++) {
                runnable.run();
            }
        }
    }

    public C1136h(Context context) {
        this.f7508b = context;
    }

    public static synchronized C1136h c() {
        return f7506l;
    }

    public static synchronized C1136h d(Context context) {
        try {
            if (f7506l == null) {
                f7506l = new C1136h(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7506l;
    }

    public static void n(LinkedBlockingQueue<Runnable> linkedBlockingQueue, LinkedBlockingQueue<Runnable> linkedBlockingQueue2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            Runnable runnablePeek = linkedBlockingQueue.peek();
            if (runnablePeek == null) {
                return;
            }
            try {
                linkedBlockingQueue2.put(runnablePeek);
                linkedBlockingQueue.poll();
            } catch (Throwable th) {
                C1139k.j("[UploadManager] Failed to add upload task to temp urgent queue: %s", th.getMessage());
            }
        }
    }

    public static /* synthetic */ int p(C1136h c1136h) {
        int i10 = c1136h.f7517k - 1;
        c1136h.f7517k = i10;
        return i10;
    }

    public final synchronized long a(int i10) {
        if (i10 >= 0) {
            Long l10 = this.f7510d.get(Integer.valueOf(i10));
            if (l10 != null) {
                return l10.longValue();
            }
        } else {
            C1139k.j("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i10));
        }
        return 0L;
    }

    public final long b(boolean z10) {
        long jL;
        long jZ = C1143o.z();
        int i10 = z10 ? 5 : 3;
        List<X> listM = this.f7507a.m(i10);
        if (listM == null || listM.size() <= 0) {
            jL = z10 ? this.f7512f : this.f7511e;
        } else {
            jL = 0;
            try {
                X x10 = listM.get(0);
                if (x10.f7412e >= jZ) {
                    jL = C1143o.L(x10.f7414g);
                    if (i10 == 3) {
                        this.f7511e = jL;
                    } else {
                        this.f7512f = jL;
                    }
                    listM.remove(x10);
                }
            } catch (Throwable th) {
                C1139k.e(th);
            }
            if (listM.size() > 0) {
                this.f7507a.p(listM);
            }
        }
        C1139k.h("[UploadManager] Local network consume: %d KB", Long.valueOf(jL / 1024));
        return jL;
    }

    public final void f(int i10, int i11, byte[] bArr, String str, String str2, InterfaceC1135g interfaceC1135g, boolean z10) {
        try {
            m(new RunnableC1137i(this.f7508b, i10, i11, bArr, str, str2, interfaceC1135g, 0, 0, false), z10, false, 0L);
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final synchronized void g(int i10, long j10) {
        if (i10 < 0) {
            C1139k.j("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i10));
            return;
        }
        this.f7510d.put(Integer.valueOf(i10), Long.valueOf(j10));
        X x10 = new X();
        x10.f7409b = i10;
        x10.f7412e = j10;
        x10.f7410c = "";
        x10.f7411d = "";
        x10.f7414g = new byte[0];
        this.f7507a.x(i10);
        this.f7507a.v(x10);
        C1139k.h("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i10), C1143o.h(j10));
    }

    public final void h(int i10, bq bqVar, String str, String str2, InterfaceC1135g interfaceC1135g, long j10, boolean z10) {
        try {
            m(new RunnableC1137i(this.f7508b, i10, bqVar.f31623g, C1133e.f(bqVar), str, str2, interfaceC1135g, z10), true, true, j10);
        } catch (Throwable th) {
            if (C1139k.e(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void i(int i10, bq bqVar, String str, String str2, InterfaceC1135g interfaceC1135g, boolean z10) {
        f(i10, bqVar.f31623g, C1133e.f(bqVar), str, str2, interfaceC1135g, z10);
    }

    public final void j(int i10, LinkedBlockingQueue<Runnable> linkedBlockingQueue) {
        C1138j c1138jA = C1138j.a();
        if (i10 > 0) {
            C1139k.h("[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(i10), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        }
        for (int i11 = 0; i11 < i10; i11++) {
            Runnable runnablePoll = linkedBlockingQueue.poll();
            if (runnablePoll == null) {
                return;
            }
            synchronized (this.f7515i) {
                try {
                    if (this.f7517k < 2 || c1138jA == null) {
                        C1139k.d("[UploadManager] Create and start a new thread to execute a upload task: %s", "BUGLY_ASYNC_UPLOAD");
                        if (C1143o.n(new a(runnablePoll), "BUGLY_ASYNC_UPLOAD") != null) {
                            synchronized (this.f7515i) {
                                this.f7517k++;
                            }
                        } else {
                            C1139k.i("[UploadManager] Failed to start a thread to execute asynchronous upload task,will try again next time.", new Object[0]);
                            o(runnablePoll, true);
                        }
                    } else {
                        c1138jA.b(runnablePoll);
                    }
                } finally {
                }
            }
        }
    }

    public final synchronized void k(long j10, boolean z10) {
        int i10 = z10 ? 5 : 3;
        try {
            X x10 = new X();
            x10.f7409b = i10;
            x10.f7412e = C1143o.z();
            x10.f7410c = "";
            x10.f7411d = "";
            x10.f7414g = C1143o.K(j10);
            this.f7507a.x(i10);
            this.f7507a.v(x10);
            if (z10) {
                this.f7512f = j10;
            } else {
                this.f7511e = j10;
            }
            C1139k.h("[UploadManager] Network total consume: %d KB", Long.valueOf(j10 / 1024));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void l(Runnable runnable, long j10) {
        if (runnable == null) {
            C1139k.i("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        C1139k.h("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread threadN = C1143o.n(runnable, "BUGLY_SYNC_UPLOAD");
        if (threadN == null) {
            C1139k.j("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            o(runnable, true);
            return;
        }
        try {
            threadN.join(j10);
        } catch (Throwable th) {
            C1139k.j("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            o(runnable, true);
            q();
        }
    }

    public final void m(Runnable runnable, boolean z10, boolean z11, long j10) {
        C1139k.h("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z11) {
            l(runnable, j10);
        } else {
            o(runnable, z10);
            q();
        }
    }

    public final boolean o(Runnable runnable, boolean z10) {
        if (runnable == null) {
            C1139k.d("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            C1139k.h("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f7515i) {
                try {
                    if (z10) {
                        this.f7513g.put(runnable);
                    } else {
                        this.f7514h.put(runnable);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return true;
        } catch (Throwable th2) {
            C1139k.j("[UploadManager] Failed to add upload task to queue: %s", th2.getMessage());
            return false;
        }
    }

    public final void q() {
        C1138j c1138jA = C1138j.a();
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();
        LinkedBlockingQueue linkedBlockingQueue2 = new LinkedBlockingQueue();
        synchronized (this.f7515i) {
            try {
                C1139k.h("[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                int size = this.f7513g.size();
                int size2 = this.f7514h.size();
                if (size == 0 && size2 == 0) {
                    C1139k.h("[UploadManager] There is no upload task in queue.", new Object[0]);
                    return;
                }
                if (c1138jA == null || !c1138jA.d()) {
                    size2 = 0;
                }
                n(this.f7513g, linkedBlockingQueue, size);
                n(this.f7514h, linkedBlockingQueue2, size2);
                j(size, linkedBlockingQueue);
                if (size2 > 0) {
                    C1139k.h("[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)", Integer.valueOf(size2), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                }
                C1138j c1138jA2 = C1138j.a();
                if (c1138jA2 != null) {
                    c1138jA2.b(new b(size2, linkedBlockingQueue2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean r(int i10) {
        if (O.f7341c) {
            C1139k.h("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - a(i10);
        C1139k.h("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(jCurrentTimeMillis / 1000), Integer.valueOf(i10));
        if (jCurrentTimeMillis >= 30000) {
            return true;
        }
        C1139k.d("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
        return false;
    }
}
