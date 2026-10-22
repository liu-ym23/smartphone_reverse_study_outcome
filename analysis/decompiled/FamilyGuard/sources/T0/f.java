package T0;

import C0.q;
import android.graphics.drawable.Drawable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public class f<R> implements c<R>, g<R> {

    /* renamed from: k, reason: collision with root package name */
    private static final a f5337k = new a();

    /* renamed from: a, reason: collision with root package name */
    private final int f5338a;

    /* renamed from: b, reason: collision with root package name */
    private final int f5339b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f5340c;

    /* renamed from: d, reason: collision with root package name */
    private final a f5341d;

    /* renamed from: e, reason: collision with root package name */
    private R f5342e;

    /* renamed from: f, reason: collision with root package name */
    private d f5343f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5344g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5345h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5346i;

    /* renamed from: j, reason: collision with root package name */
    private q f5347j;

    static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j5) throws InterruptedException {
            obj.wait(j5);
        }
    }

    public f(int i5, int i6) {
        this(i5, i6, true, f5337k);
    }

    private synchronized R n(Long l5) {
        try {
            if (this.f5340c && !isDone()) {
                X0.k.a();
            }
            if (this.f5344g) {
                throw new CancellationException();
            }
            if (this.f5346i) {
                throw new ExecutionException(this.f5347j);
            }
            if (this.f5345h) {
                return this.f5342e;
            }
            if (l5 == null) {
                this.f5341d.b(this, 0L);
            } else if (l5.longValue() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jLongValue = l5.longValue() + jCurrentTimeMillis;
                while (!isDone() && jCurrentTimeMillis < jLongValue) {
                    this.f5341d.b(this, jLongValue - jCurrentTimeMillis);
                    jCurrentTimeMillis = System.currentTimeMillis();
                }
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            if (this.f5346i) {
                throw new ExecutionException(this.f5347j);
            }
            if (this.f5344g) {
                throw new CancellationException();
            }
            if (!this.f5345h) {
                throw new TimeoutException();
            }
            return this.f5342e;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // Q0.i
    public void a() {
    }

    @Override // U0.e
    public void b(U0.d dVar) {
    }

    @Override // U0.e
    public synchronized void c(d dVar) {
        this.f5343f = dVar;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z5) {
        d dVar;
        if (isDone()) {
            return false;
        }
        this.f5344g = true;
        this.f5341d.a(this);
        if (z5 && (dVar = this.f5343f) != null) {
            dVar.clear();
            this.f5343f = null;
        }
        return true;
    }

    @Override // Q0.i
    public void d() {
    }

    @Override // U0.e
    public void e(U0.d dVar) {
        dVar.d(this.f5338a, this.f5339b);
    }

    @Override // U0.e
    public synchronized void f(Drawable drawable) {
    }

    @Override // Q0.i
    public void g() {
    }

    @Override // java.util.concurrent.Future
    public R get() {
        try {
            return n(null);
        } catch (TimeoutException e6) {
            throw new AssertionError(e6);
        }
    }

    @Override // T0.g
    public synchronized boolean h(q qVar, Object obj, U0.e<R> eVar, boolean z5) {
        this.f5346i = true;
        this.f5347j = qVar;
        this.f5341d.a(this);
        return false;
    }

    @Override // T0.g
    public synchronized boolean i(R r5, Object obj, U0.e<R> eVar, EnumC1335a enumC1335a, boolean z5) {
        this.f5345h = true;
        this.f5342e = r5;
        this.f5341d.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f5344g;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0012  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f5344g     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.f5345h     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L12
            boolean r0 = r1.f5346i     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Le
            goto L12
        Le:
            r0 = 0
            goto L13
        L10:
            r0 = move-exception
            goto L15
        L12:
            r0 = 1
        L13:
            monitor-exit(r1)
            return r0
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L10
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: T0.f.isDone():boolean");
    }

    @Override // U0.e
    public void j(Drawable drawable) {
    }

    @Override // U0.e
    public synchronized d k() {
        return this.f5343f;
    }

    @Override // U0.e
    public synchronized void l(R r5, V0.b<? super R> bVar) {
    }

    @Override // U0.e
    public void m(Drawable drawable) {
    }

    f(int i5, int i6, boolean z5, a aVar) {
        this.f5338a = i5;
        this.f5339b = i6;
        this.f5340c = z5;
        this.f5341d = aVar;
    }

    @Override // java.util.concurrent.Future
    public R get(long j5, TimeUnit timeUnit) {
        return n(Long.valueOf(timeUnit.toMillis(j5)));
    }
}
