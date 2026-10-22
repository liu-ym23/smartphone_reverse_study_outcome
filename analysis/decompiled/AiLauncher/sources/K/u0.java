package K;

import D.C0761b0;
import K.p0;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: b, reason: collision with root package name */
    public static final t0 f4015b = t0.b();

    /* renamed from: c, reason: collision with root package name */
    public static final u0 f4016c = new u0();

    /* renamed from: a, reason: collision with root package name */
    public final n0<t0> f4017a = n0.h(f4015b);

    public static class a<T> implements p0.a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final B0.a<T> f4018a;

        public a(B0.a<T> aVar) {
            this.f4018a = aVar;
        }

        @Override // K.p0.a
        public void a(T t10) {
            this.f4018a.accept(t10);
        }

        @Override // K.p0.a
        public void onError(Throwable th) {
            C0761b0.d("ObserverToConsumerAdapter", "Unexpected error in Observable", th);
        }
    }

    public static u0 b() {
        return f4016c;
    }

    public t0 a() {
        try {
            return this.f4017a.b().get();
        } catch (InterruptedException | ExecutionException e10) {
            throw new AssertionError("Unexpected error in QuirkSettings StateObservable", e10);
        }
    }

    public void c(Executor executor, B0.a<t0> aVar) {
        this.f4017a.a(executor, new a(aVar));
    }

    public void d(t0 t0Var) {
        this.f4017a.g(t0Var);
    }
}
