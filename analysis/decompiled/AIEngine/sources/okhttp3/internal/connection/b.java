package okhttp3.internal.connection;

import bd.l;
import dd.e;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements ed.e {

    /* renamed from: a, reason: collision with root package name */
    public final h f11031a;

    /* renamed from: b, reason: collision with root package name */
    public final dd.e f11032b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11033c;

    /* renamed from: d, reason: collision with root package name */
    public long f11034d;

    /* renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<h.b> f11035e;

    /* renamed from: f, reason: collision with root package name */
    public final BlockingQueue<h.a> f11036f;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends dd.a {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ h.b f11037e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f11038f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, h.b bVar, b bVar2) {
            super(str, true);
            this.f11037e = bVar;
            this.f11038f = bVar2;
        }

        @Override // dd.a
        public final long a() throws InterruptedException {
            h.a aVar;
            h.b bVar = this.f11037e;
            try {
                aVar = bVar.g();
            } catch (Throwable th) {
                aVar = new h.a(bVar, null, th, 2);
            }
            b bVar2 = this.f11038f;
            if (!bVar2.f11035e.contains(bVar)) {
                return -1L;
            }
            bVar2.f11036f.put(aVar);
            return -1L;
        }
    }

    public b(h hVar, dd.e taskRunner) {
        kotlin.jvm.internal.g.f(taskRunner, "taskRunner");
        this.f11031a = hVar;
        this.f11032b = taskRunner;
        this.f11033c = TimeUnit.MILLISECONDS.toNanos(250L);
        this.f11034d = Long.MIN_VALUE;
        this.f11035e = new CopyOnWriteArrayList<>();
        this.f11036f = new LinkedBlockingDeque();
    }

    @Override // ed.e
    public final ed.g a() throws IOException {
        h.a aVarD;
        CopyOnWriteArrayList<h.b> copyOnWriteArrayList = this.f11035e;
        IOException iOException = null;
        while (true) {
            try {
                boolean zIsEmpty = copyOnWriteArrayList.isEmpty();
                h hVar = this.f11031a;
                if (zIsEmpty && !hVar.e(null)) {
                    c();
                    kotlin.jvm.internal.g.c(iOException);
                    throw iOException;
                }
                if (hVar.isCanceled()) {
                    throw new IOException("Canceled");
                }
                e.a aVar = this.f11032b.f8480a;
                long jNanoTime = System.nanoTime();
                long j10 = this.f11034d - jNanoTime;
                if (copyOnWriteArrayList.isEmpty() || j10 <= 0) {
                    aVarD = d();
                    j10 = this.f11033c;
                    this.f11034d = jNanoTime + j10;
                } else {
                    aVarD = null;
                }
                if (aVarD == null) {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    if (copyOnWriteArrayList.isEmpty() || (aVarD = this.f11036f.poll(j10, timeUnit)) == null) {
                        aVarD = null;
                    } else {
                        copyOnWriteArrayList.remove(aVarD.f11085a);
                    }
                    if (aVarD == null) {
                    }
                }
                h.b bVar = aVarD.f11085a;
                boolean z = false;
                if (aVarD.f11086b == null && aVarD.f11087c == null) {
                    c();
                    if (!bVar.isReady()) {
                        aVarD = bVar.c();
                    }
                    if (aVarD.f11086b == null && aVarD.f11087c == null) {
                        z = true;
                    }
                    if (z) {
                        return aVarD.f11085a.a();
                    }
                }
                Throwable th = aVarD.f11087c;
                if (th != null) {
                    if (!(th instanceof IOException)) {
                        throw th;
                    }
                    if (iOException == null) {
                        iOException = (IOException) th;
                    } else {
                        jd.b.c(iOException, th);
                    }
                }
                h.b bVar2 = aVarD.f11086b;
                if (bVar2 != null) {
                    hVar.b().addFirst(bVar2);
                }
            } finally {
                c();
            }
        }
    }

    @Override // ed.e
    public final h b() {
        return this.f11031a;
    }

    public final void c() {
        CopyOnWriteArrayList<h.b> copyOnWriteArrayList = this.f11035e;
        Iterator<h.b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            h.b next = it.next();
            next.cancel();
            h.b bVarE = next.e();
            if (bVarE != null) {
                this.f11031a.b().addLast(bVarE);
            }
        }
        copyOnWriteArrayList.clear();
    }

    public final h.a d() {
        h.b aVar;
        h hVar = this.f11031a;
        if (hVar.e(null)) {
            try {
                aVar = hVar.c();
            } catch (Throwable th) {
                aVar = new okhttp3.internal.connection.a(th);
            }
            if (aVar.isReady()) {
                return new h.a(aVar, null, null, 6);
            }
            if (aVar instanceof okhttp3.internal.connection.a) {
                return ((okhttp3.internal.connection.a) aVar).f11030a;
            }
            this.f11035e.add(aVar);
            this.f11032b.e().d(new a(l.f3239c + " connect " + hVar.a().h.h(), aVar, this), 0L);
        }
        return null;
    }
}
