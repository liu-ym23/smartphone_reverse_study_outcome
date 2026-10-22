package K;

import K.l0;
import K.p0;
import android.os.SystemClock;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class l0<T> implements p0<T> {

    /* renamed from: a, reason: collision with root package name */
    public final android.view.y<a<T>> f3999a = new android.view.y<>();

    /* renamed from: b, reason: collision with root package name */
    public final Map<p0.a<? super T>, Executor> f4000b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public android.view.z<a<T>> f4001c;

    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final T f4002a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f4003b;

        public a(T t10, Throwable th) {
            this.f4002a = t10;
            this.f4003b = th;
        }

        public static <T> a<T> b(T t10) {
            return new a<>(t10, null);
        }

        public boolean a() {
            return this.f4003b == null;
        }

        public Throwable c() {
            return this.f4003b;
        }

        public T d() {
            if (a()) {
                return this.f4002a;
            }
            throw new IllegalStateException("Result contains an error. Does not contain a value.");
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[Result: <");
            if (a()) {
                str = "Value: " + this.f4002a;
            } else {
                str = "Error: " + this.f4003b;
            }
            sb2.append(str);
            sb2.append(">]");
            return sb2.toString();
        }
    }

    public static /* synthetic */ void d(l0 l0Var, final a aVar) {
        HashMap map;
        synchronized (l0Var.f4000b) {
            map = new HashMap(l0Var.f4000b);
        }
        for (final Map.Entry entry : map.entrySet()) {
            ((Executor) entry.getValue()).execute(new Runnable() { // from class: K.k0
                @Override // java.lang.Runnable
                public final void run() {
                    l0.e(entry, aVar);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(Map.Entry entry, a aVar) {
        p0.a aVar2 = (p0.a) entry.getKey();
        if (aVar.a()) {
            aVar2.a(aVar.d());
        } else {
            B0.h.f(aVar.c());
            aVar2.onError(aVar.c());
        }
    }

    public static /* synthetic */ Object f(final l0 l0Var, final CallbackToFutureAdapter.a aVar) {
        l0Var.getClass();
        N.a.d().execute(new Runnable() { // from class: K.i0
            @Override // java.lang.Runnable
            public final void run() {
                l0.j(this.f3984a, aVar);
            }
        });
        return l0Var + " [fetch@" + SystemClock.uptimeMillis() + "]";
    }

    public static /* synthetic */ void g(final l0 l0Var) {
        if (l0Var.f4001c == null) {
            l0Var.f4001c = new android.view.z() { // from class: K.j0
                @Override // android.view.z
                public final void a(Object obj) {
                    l0.d(this.f3987a, (l0.a) obj);
                }
            };
        }
        l0Var.f3999a.f(l0Var.f4001c);
    }

    public static /* synthetic */ void h(l0 l0Var) {
        android.view.z<a<T>> zVar = l0Var.f4001c;
        if (zVar != null) {
            l0Var.f3999a.j(zVar);
        }
    }

    public static /* synthetic */ void i(l0 l0Var, p0.a aVar) {
        a<T> aVarE = l0Var.f3999a.e();
        if (aVarE == null) {
            return;
        }
        if (aVarE.a()) {
            aVar.a(aVarE.d());
        } else {
            B0.h.f(aVarE.c());
            aVar.onError(aVarE.c());
        }
    }

    public static /* synthetic */ void j(l0 l0Var, CallbackToFutureAdapter.a aVar) {
        a<T> aVarE = l0Var.f3999a.e();
        if (aVarE == null) {
            aVar.f(new IllegalStateException("Observable has not yet been initialized with a value."));
        } else if (aVarE.a()) {
            aVar.c(aVarE.d());
        } else {
            B0.h.f(aVarE.c());
            aVar.f(aVarE.c());
        }
    }

    @Override // K.p0
    public void a(Executor executor, final p0.a<? super T> aVar) {
        synchronized (this.f4000b) {
            try {
                boolean zIsEmpty = this.f4000b.isEmpty();
                this.f4000b.put(aVar, executor);
                if (zIsEmpty) {
                    l();
                } else {
                    executor.execute(new Runnable() { // from class: K.e0
                        @Override // java.lang.Runnable
                        public final void run() {
                            l0.i(this.f3958a, aVar);
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // K.p0
    public InterfaceFutureC4095a<T> b() {
        return CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: K.f0
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return l0.f(this.f3966a, aVar);
            }
        });
    }

    @Override // K.p0
    public void c(p0.a<? super T> aVar) {
        synchronized (this.f4000b) {
            try {
                this.f4000b.remove(aVar);
                if (this.f4000b.isEmpty()) {
                    k();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void k() {
        N.a.d().execute(new Runnable() { // from class: K.g0
            @Override // java.lang.Runnable
            public final void run() {
                l0.h(this.f3971a);
            }
        });
    }

    public final void l() {
        N.a.d().execute(new Runnable() { // from class: K.h0
            @Override // java.lang.Runnable
            public final void run() {
                l0.g(this.f3982a);
            }
        });
    }

    public void m(T t10) {
        this.f3999a.i(a.b(t10));
    }
}
