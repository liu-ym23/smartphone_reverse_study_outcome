package P3;

import Q3.g;
import java.util.concurrent.atomic.AtomicReference;
import x3.i;

/* loaded from: classes.dex */
public final class c<T> extends AtomicReference<Q4.c> implements i<T>, Q4.c, A3.c {

    /* renamed from: a, reason: collision with root package name */
    final D3.c<? super T> f4840a;

    /* renamed from: b, reason: collision with root package name */
    final D3.c<? super Throwable> f4841b;

    /* renamed from: c, reason: collision with root package name */
    final D3.a f4842c;

    /* renamed from: d, reason: collision with root package name */
    final D3.c<? super Q4.c> f4843d;

    public c(D3.c<? super T> cVar, D3.c<? super Throwable> cVar2, D3.a aVar, D3.c<? super Q4.c> cVar3) {
        this.f4840a = cVar;
        this.f4841b = cVar2;
        this.f4842c = aVar;
        this.f4843d = cVar3;
    }

    @Override // Q4.b
    public void a() {
        Q4.c cVar = get();
        g gVar = g.CANCELLED;
        if (cVar != gVar) {
            lazySet(gVar);
            try {
                this.f4842c.run();
            } catch (Throwable th) {
                B3.b.b(th);
                S3.a.r(th);
            }
        }
    }

    @Override // Q4.c
    public void cancel() {
        g.b(this);
    }

    @Override // Q4.b
    public void d(T t5) {
        if (g()) {
            return;
        }
        try {
            this.f4840a.accept(t5);
        } catch (Throwable th) {
            B3.b.b(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // A3.c
    public void dispose() {
        cancel();
    }

    @Override // x3.i, Q4.b
    public void e(Q4.c cVar) {
        if (g.j(this, cVar)) {
            try {
                this.f4843d.accept(this);
            } catch (Throwable th) {
                B3.b.b(th);
                cVar.cancel();
                onError(th);
            }
        }
    }

    @Override // A3.c
    public boolean g() {
        return get() == g.CANCELLED;
    }

    @Override // Q4.c
    public void h(long j5) {
        get().h(j5);
    }

    @Override // Q4.b
    public void onError(Throwable th) {
        Q4.c cVar = get();
        g gVar = g.CANCELLED;
        if (cVar == gVar) {
            S3.a.r(th);
            return;
        }
        lazySet(gVar);
        try {
            this.f4841b.accept(th);
        } catch (Throwable th2) {
            B3.b.b(th2);
            S3.a.r(new B3.a(th, th2));
        }
    }
}
