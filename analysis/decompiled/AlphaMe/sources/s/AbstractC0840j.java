package s;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: s.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0840j implements D1.a {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f14141d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f14142e = Logger.getLogger(AbstractC0840j.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final B0.f f14143f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f14144g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f14145a;

    /* renamed from: b, reason: collision with root package name */
    public volatile C0835e f14146b;

    /* renamed from: c, reason: collision with root package name */
    public volatile C0839i f14147c;

    static {
        B0.f c0838h;
        try {
            c0838h = new C0836f(AtomicReferenceFieldUpdater.newUpdater(C0839i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(C0839i.class, C0839i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC0840j.class, C0839i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractC0840j.class, C0835e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC0840j.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            c0838h = new C0838h();
        }
        f14143f = c0838h;
        if (th != null) {
            f14142e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f14144g = new Object();
    }

    public static void c(AbstractC0840j abstractC0840j) {
        C0839i c0839i;
        C0835e c0835e;
        do {
            c0839i = abstractC0840j.f14147c;
        } while (!f14143f.h(abstractC0840j, c0839i, C0839i.f14138c));
        while (c0839i != null) {
            Thread thread = c0839i.f14139a;
            if (thread != null) {
                c0839i.f14139a = null;
                LockSupport.unpark(thread);
            }
            c0839i = c0839i.f14140b;
        }
        do {
            c0835e = abstractC0840j.f14146b;
        } while (!f14143f.f(abstractC0840j, c0835e, C0835e.f14129d));
        C0835e c0835e2 = null;
        while (c0835e != null) {
            C0835e c0835e3 = c0835e.f14132c;
            c0835e.f14132c = c0835e2;
            c0835e2 = c0835e;
            c0835e = c0835e3;
        }
        while (c0835e2 != null) {
            C0835e c0835e4 = c0835e2.f14132c;
            Runnable runnable = c0835e2.f14130a;
            if (runnable instanceof AbstractRunnableC0837g) {
                throw null;
            }
            d(runnable, c0835e2.f14131b);
            c0835e2 = c0835e4;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e4) {
            f14142e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e4);
        }
    }

    public static Object e(Object obj) throws ExecutionException {
        if (obj instanceof C0832b) {
            Throwable th = ((C0832b) obj).f14127a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof AbstractC0834d) {
            ((AbstractC0834d) obj).getClass();
            throw new ExecutionException((Throwable) null);
        }
        if (obj == f14144g) {
            return null;
        }
        return obj;
    }

    @Override // D1.a
    public final void a(Runnable runnable, Executor executor) {
        executor.getClass();
        C0835e c0835e = this.f14146b;
        C0835e c0835e2 = C0835e.f14129d;
        if (c0835e != c0835e2) {
            C0835e c0835e3 = new C0835e(runnable, executor);
            do {
                c0835e3.f14132c = c0835e;
                if (f14143f.f(this, c0835e, c0835e3)) {
                    return;
                } else {
                    c0835e = this.f14146b;
                }
            } while (c0835e != c0835e2);
        }
        d(runnable, executor);
    }

    public final void b(StringBuilder sb) {
        Object obj;
        boolean z4 = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z4 = true;
                } catch (Throwable th) {
                    if (z4) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (RuntimeException e4) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e4.getClass());
                sb.append(" thrown from get()]");
                return;
            } catch (ExecutionException e5) {
                sb.append("FAILURE, cause=[");
                sb.append(e5.getCause());
                sb.append("]");
                return;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        sb.append(obj == this ? "this future" : String.valueOf(obj));
        sb.append("]");
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        Object obj = this.f14145a;
        if (obj == null) {
            if (f14143f.g(this, obj, f14141d ? new C0832b(new CancellationException("Future.cancel() was called."), z4) : z4 ? C0832b.f14125b : C0832b.f14126c)) {
                c(this);
                return true;
            }
        }
        return false;
    }

    public final void f(C0839i c0839i) {
        c0839i.f14139a = null;
        while (true) {
            C0839i c0839i2 = this.f14147c;
            if (c0839i2 == C0839i.f14138c) {
                return;
            }
            C0839i c0839i3 = null;
            while (c0839i2 != null) {
                C0839i c0839i4 = c0839i2.f14140b;
                if (c0839i2.f14139a != null) {
                    c0839i3 = c0839i2;
                } else if (c0839i3 != null) {
                    c0839i3.f14140b = c0839i4;
                    if (c0839i3.f14139a == null) {
                        break;
                    }
                } else if (!f14143f.h(this, c0839i2, c0839i4)) {
                    break;
                }
                c0839i2 = c0839i4;
            }
            return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ac  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x009f -> B:36:0x006e). Please report as a decompilation issue!!! */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(long r20, java.util.concurrent.TimeUnit r22) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.AbstractC0840j.get(long, java.util.concurrent.TimeUnit):java.lang.Object");
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f14145a instanceof C0832b;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (this.f14145a != null) & true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f14145a instanceof C0832b) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                if (this instanceof ScheduledFuture) {
                    str = "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
                } else {
                    str = null;
                }
            } catch (RuntimeException e4) {
                str = "Exception thrown from implementation: " + e4.getClass();
            }
            if (str != null && !str.isEmpty()) {
                AbstractC0831a.h(sb, "PENDING, info=[", str, "]");
            } else if (isDone()) {
                b(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f14145a;
            if ((obj2 != null) & true) {
                return e(obj2);
            }
            C0839i c0839i = this.f14147c;
            C0839i c0839i2 = C0839i.f14138c;
            if (c0839i != c0839i2) {
                C0839i c0839i3 = new C0839i();
                do {
                    B0.f fVar = f14143f;
                    fVar.g0(c0839i3, c0839i);
                    if (fVar.h(this, c0839i, c0839i3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f14145a;
                            } else {
                                f(c0839i3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & true));
                        return e(obj);
                    }
                    c0839i = this.f14147c;
                } while (c0839i != c0839i2);
            }
            return e(this.f14145a);
        }
        throw new InterruptedException();
    }
}
