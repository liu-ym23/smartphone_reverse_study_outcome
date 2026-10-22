package S3;

import B3.d;
import D3.c;
import D3.h;
import F3.b;
import R3.e;
import java.util.concurrent.Callable;
import x3.AbstractC1286b;
import x3.InterfaceC1287c;
import x3.f;
import x3.j;
import x3.k;
import x3.m;
import x3.o;
import x3.p;
import x3.q;
import x3.s;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static volatile c<? super Throwable> f5242a;

    /* renamed from: b, reason: collision with root package name */
    static volatile h<? super Runnable, ? extends Runnable> f5243b;

    /* renamed from: c, reason: collision with root package name */
    static volatile h<? super Callable<p>, ? extends p> f5244c;

    /* renamed from: d, reason: collision with root package name */
    static volatile h<? super Callable<p>, ? extends p> f5245d;

    /* renamed from: e, reason: collision with root package name */
    static volatile h<? super Callable<p>, ? extends p> f5246e;

    /* renamed from: f, reason: collision with root package name */
    static volatile h<? super Callable<p>, ? extends p> f5247f;

    /* renamed from: g, reason: collision with root package name */
    static volatile h<? super p, ? extends p> f5248g;

    /* renamed from: h, reason: collision with root package name */
    static volatile h<? super p, ? extends p> f5249h;

    /* renamed from: i, reason: collision with root package name */
    static volatile h<? super p, ? extends p> f5250i;

    /* renamed from: j, reason: collision with root package name */
    static volatile h<? super f, ? extends f> f5251j;

    /* renamed from: k, reason: collision with root package name */
    static volatile h<? super C3.a, ? extends C3.a> f5252k;

    /* renamed from: l, reason: collision with root package name */
    static volatile h<? super m, ? extends m> f5253l;

    /* renamed from: m, reason: collision with root package name */
    static volatile h<? super j, ? extends j> f5254m;

    /* renamed from: n, reason: collision with root package name */
    static volatile h<? super q, ? extends q> f5255n;

    /* renamed from: o, reason: collision with root package name */
    static volatile h<? super AbstractC1286b, ? extends AbstractC1286b> f5256o;

    /* renamed from: p, reason: collision with root package name */
    static volatile boolean f5257p;

    static void A(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    static <T, R> R a(h<T, R> hVar, T t5) {
        try {
            return hVar.apply(t5);
        } catch (Throwable th) {
            throw e.d(th);
        }
    }

    static p b(h<? super Callable<p>, ? extends p> hVar, Callable<p> callable) {
        return (p) b.d(a(hVar, callable), "Scheduler Callable result can't be null");
    }

    static p c(Callable<p> callable) {
        try {
            return (p) b.d(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw e.d(th);
        }
    }

    public static p d(Callable<p> callable) {
        b.d(callable, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> hVar = f5244c;
        return hVar == null ? c(callable) : b(hVar, callable);
    }

    public static p e(Callable<p> callable) {
        b.d(callable, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> hVar = f5246e;
        return hVar == null ? c(callable) : b(hVar, callable);
    }

    public static p f(Callable<p> callable) {
        b.d(callable, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> hVar = f5247f;
        return hVar == null ? c(callable) : b(hVar, callable);
    }

    public static p g(Callable<p> callable) {
        b.d(callable, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> hVar = f5245d;
        return hVar == null ? c(callable) : b(hVar, callable);
    }

    static boolean h(Throwable th) {
        return (th instanceof d) || (th instanceof B3.c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof B3.a);
    }

    public static boolean i() {
        return f5257p;
    }

    public static <T> C3.a<T> j(C3.a<T> aVar) {
        h<? super C3.a, ? extends C3.a> hVar = f5252k;
        return hVar != null ? (C3.a) a(hVar, aVar) : aVar;
    }

    public static AbstractC1286b k(AbstractC1286b abstractC1286b) {
        h<? super AbstractC1286b, ? extends AbstractC1286b> hVar = f5256o;
        return hVar != null ? (AbstractC1286b) a(hVar, abstractC1286b) : abstractC1286b;
    }

    public static <T> f<T> l(f<T> fVar) {
        h<? super f, ? extends f> hVar = f5251j;
        return hVar != null ? (f) a(hVar, fVar) : fVar;
    }

    public static <T> j<T> m(j<T> jVar) {
        h<? super j, ? extends j> hVar = f5254m;
        return hVar != null ? (j) a(hVar, jVar) : jVar;
    }

    public static <T> m<T> n(m<T> mVar) {
        h<? super m, ? extends m> hVar = f5253l;
        return hVar != null ? (m) a(hVar, mVar) : mVar;
    }

    public static <T> q<T> o(q<T> qVar) {
        h<? super q, ? extends q> hVar = f5255n;
        return hVar != null ? (q) a(hVar, qVar) : qVar;
    }

    public static boolean p() {
        return false;
    }

    public static p q(p pVar) {
        h<? super p, ? extends p> hVar = f5248g;
        return hVar == null ? pVar : (p) a(hVar, pVar);
    }

    public static void r(Throwable th) {
        c<? super Throwable> cVar = f5242a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!h(th)) {
            th = new B3.f(th);
        }
        if (cVar != null) {
            try {
                cVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                A(th2);
            }
        }
        th.printStackTrace();
        A(th);
    }

    public static p s(p pVar) {
        h<? super p, ? extends p> hVar = f5250i;
        return hVar == null ? pVar : (p) a(hVar, pVar);
    }

    public static Runnable t(Runnable runnable) {
        b.d(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = f5243b;
        return hVar == null ? runnable : (Runnable) a(hVar, runnable);
    }

    public static p u(p pVar) {
        h<? super p, ? extends p> hVar = f5249h;
        return hVar == null ? pVar : (p) a(hVar, pVar);
    }

    public static <T> Q4.b<? super T> v(f<T> fVar, Q4.b<? super T> bVar) {
        return bVar;
    }

    public static InterfaceC1287c w(AbstractC1286b abstractC1286b, InterfaceC1287c interfaceC1287c) {
        return interfaceC1287c;
    }

    public static <T> k<? super T> x(j<T> jVar, k<? super T> kVar) {
        return kVar;
    }

    public static <T> o<? super T> y(m<T> mVar, o<? super T> oVar) {
        return oVar;
    }

    public static <T> s<? super T> z(q<T> qVar, s<? super T> sVar) {
        return sVar;
    }
}
