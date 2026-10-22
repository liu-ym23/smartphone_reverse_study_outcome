package r3;

import D2.AbstractC0789a;
import D2.C0790b;
import com.google.android.gms.common.internal.C1669j;
import com.google.mlkit.common.MlKitException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import y2.C5935p;

/* renamed from: r3.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5216j {

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f38770b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f38771c = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public final m f38769a = new m();

    public <T> D2.i<T> a(final Executor executor, final Callable<T> callable, final AbstractC0789a abstractC0789a) {
        C1669j.n(this.f38770b.get() > 0);
        if (abstractC0789a.a()) {
            return D2.l.b();
        }
        final C0790b c0790b = new C0790b();
        final D2.j jVar = new D2.j(c0790b.b());
        this.f38769a.a(new Executor() { // from class: r3.w
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                try {
                    executor.execute(runnable);
                } catch (RuntimeException e10) {
                    if (abstractC0789a.a()) {
                        c0790b.a();
                    } else {
                        jVar.b(e10);
                    }
                    throw e10;
                }
            }
        }, new Runnable() { // from class: r3.x
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f38821a.g(abstractC0789a, c0790b, callable, jVar);
            }
        });
        return jVar.a();
    }

    public abstract void b() throws MlKitException;

    public void c() {
        this.f38770b.incrementAndGet();
    }

    public abstract void d();

    public void e(Executor executor) {
        f(executor);
    }

    public D2.i<Void> f(Executor executor) {
        C1669j.n(this.f38770b.get() > 0);
        final D2.j jVar = new D2.j();
        this.f38769a.a(executor, new Runnable() { // from class: r3.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f38815a.h(jVar);
            }
        });
        return jVar.a();
    }

    public final /* synthetic */ void g(AbstractC0789a abstractC0789a, C0790b c0790b, Callable callable, D2.j jVar) throws Exception {
        try {
            if (abstractC0789a.a()) {
                c0790b.a();
                return;
            }
            try {
                if (!this.f38771c.get()) {
                    b();
                    this.f38771c.set(true);
                }
                if (abstractC0789a.a()) {
                    c0790b.a();
                    return;
                }
                Object objCall = callable.call();
                if (abstractC0789a.a()) {
                    c0790b.a();
                } else {
                    jVar.c(objCall);
                }
            } catch (RuntimeException e10) {
                throw new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e10);
            }
        } catch (Exception e11) {
            if (abstractC0789a.a()) {
                c0790b.a();
            } else {
                jVar.b(e11);
            }
        }
    }

    public final /* synthetic */ void h(D2.j jVar) {
        int iDecrementAndGet = this.f38770b.decrementAndGet();
        C1669j.n(iDecrementAndGet >= 0);
        if (iDecrementAndGet == 0) {
            d();
            this.f38771c.set(false);
        }
        C5935p.a();
        jVar.c(null);
    }
}
