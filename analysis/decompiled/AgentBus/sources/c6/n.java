package c6;

import ab.e0;
import c7.r;
import ia.d0;
import ia.f1;
import ia.s;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import k5.t;
import la.j0;
import la.k0;

/* loaded from: classes.dex */
public final class n implements l {

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicInteger f1952k = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    public final String f1953a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1954b;

    /* renamed from: c, reason: collision with root package name */
    public final na.d f1955c;

    /* renamed from: d, reason: collision with root package name */
    public final j0 f1956d;

    /* renamed from: e, reason: collision with root package name */
    public final j0 f1957e;

    /* renamed from: f, reason: collision with root package name */
    public final s f1958f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f1959g;

    /* renamed from: h, reason: collision with root package name */
    public volatile e0 f1960h;

    /* renamed from: i, reason: collision with root package name */
    public final la.e0 f1961i;

    /* renamed from: j, reason: collision with root package name */
    public final la.e0 f1962j;

    public n(m mVar, String str, k5.a aVar, t tVar) {
        q7.k.e(mVar, "kind");
        q7.k.e(str, "remoteDescriptor");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(tVar, "logger");
        this.f1953a = str;
        String lowerCase = mVar.name().toLowerCase(Locale.ROOT);
        q7.k.d(lowerCase, "toLowerCase(...)");
        this.f1954b = lowerCase + "-" + f1952k.incrementAndGet();
        this.f1955c = d0.b(f1.plus(d0.c(), aVar.f5616a));
        j0 j0VarB = k0.b(0, 256, 5);
        this.f1956d = j0VarB;
        j0 j0VarB2 = k0.b(1, 0, 6);
        this.f1957e = j0VarB2;
        this.f1958f = d0.a();
        this.f1959g = new AtomicBoolean(false);
        this.f1961i = new la.e0(j0VarB);
        this.f1962j = new la.e0(j0VarB2);
    }

    @Override // c6.l
    public final la.j a() {
        return this.f1961i;
    }

    @Override // c6.l
    public final Object b(String str, i7.c cVar) throws IOException {
        if (this.f1959g.get()) {
            throw new IOException("channel closed");
        }
        e0 e0Var = this.f1960h;
        if (e0Var == null) {
            throw new IOException("ws not bound");
        }
        q7.k.e(str, "text");
        ob.k kVar = ob.k.f7997i;
        if (((nb.g) e0Var).g(1, h4.n.j(str))) {
            return r.f1986a;
        }
        throw new IOException("ws send returned false (queue full or closed)");
    }

    @Override // c6.l
    public final String c() {
        return this.f1953a;
    }

    @Override // c6.l
    public final la.e0 d() {
        return this.f1962j;
    }

    @Override // c6.l
    public final r e(a aVar) {
        r rVar = r.f1986a;
        if (this.f1959g.get()) {
            return rVar;
        }
        try {
            e0 e0Var = this.f1960h;
            if (e0Var != null) {
                int i2 = aVar.f1902a;
                String str = aVar.f1903b;
                if (str == null) {
                    str = "";
                }
                ((nb.g) e0Var).b(i2, str);
            }
        } catch (Throwable th) {
            w7.e0.n(th);
        }
        f(aVar);
        return rVar;
    }

    public final void f(a aVar) {
        q7.k.e(aVar, "reason");
        if (this.f1959g.compareAndSet(false, true)) {
            this.f1957e.M(aVar);
            this.f1958f.X(aVar);
            d0.e(this.f1955c, null);
        }
    }

    @Override // c6.l
    public final String getId() {
        return this.f1954b;
    }
}
