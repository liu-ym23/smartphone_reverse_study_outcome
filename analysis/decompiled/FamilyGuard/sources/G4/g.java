package G4;

import C4.D;
import C4.F;
import C4.InterfaceC0275e;
import C4.x;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class g implements x.a {

    /* renamed from: a, reason: collision with root package name */
    private final List<x> f1922a;

    /* renamed from: b, reason: collision with root package name */
    private final F4.k f1923b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private final F4.c f1924c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1925d;

    /* renamed from: e, reason: collision with root package name */
    private final D f1926e;

    /* renamed from: f, reason: collision with root package name */
    private final InterfaceC0275e f1927f;

    /* renamed from: g, reason: collision with root package name */
    private final int f1928g;

    /* renamed from: h, reason: collision with root package name */
    private final int f1929h;

    /* renamed from: i, reason: collision with root package name */
    private final int f1930i;

    /* renamed from: j, reason: collision with root package name */
    private int f1931j;

    public g(List<x> list, F4.k kVar, @Nullable F4.c cVar, int i5, D d6, InterfaceC0275e interfaceC0275e, int i6, int i7, int i8) {
        this.f1922a = list;
        this.f1923b = kVar;
        this.f1924c = cVar;
        this.f1925d = i5;
        this.f1926e = d6;
        this.f1927f = interfaceC0275e;
        this.f1928g = i6;
        this.f1929h = i7;
        this.f1930i = i8;
    }

    @Override // C4.x.a
    public D a() {
        return this.f1926e;
    }

    @Override // C4.x.a
    public F b(D d6) {
        return g(d6, this.f1923b, this.f1924c);
    }

    @Override // C4.x.a
    public int c() {
        return this.f1929h;
    }

    @Override // C4.x.a
    public int d() {
        return this.f1930i;
    }

    @Override // C4.x.a
    public int e() {
        return this.f1928g;
    }

    public F4.c f() {
        F4.c cVar = this.f1924c;
        if (cVar != null) {
            return cVar;
        }
        throw new IllegalStateException();
    }

    public F g(D d6, F4.k kVar, @Nullable F4.c cVar) {
        if (this.f1925d >= this.f1922a.size()) {
            throw new AssertionError();
        }
        this.f1931j++;
        F4.c cVar2 = this.f1924c;
        if (cVar2 != null && !cVar2.c().u(d6.i())) {
            throw new IllegalStateException("network interceptor " + this.f1922a.get(this.f1925d - 1) + " must retain the same host and port");
        }
        if (this.f1924c != null && this.f1931j > 1) {
            throw new IllegalStateException("network interceptor " + this.f1922a.get(this.f1925d - 1) + " must call proceed() exactly once");
        }
        g gVar = new g(this.f1922a, kVar, cVar, this.f1925d + 1, d6, this.f1927f, this.f1928g, this.f1929h, this.f1930i);
        x xVar = this.f1922a.get(this.f1925d);
        F fA = xVar.a(gVar);
        if (cVar != null && this.f1925d + 1 < this.f1922a.size() && gVar.f1931j != 1) {
            throw new IllegalStateException("network interceptor " + xVar + " must call proceed() exactly once");
        }
        if (fA == null) {
            throw new NullPointerException("interceptor " + xVar + " returned null");
        }
        if (fA.a() != null) {
            return fA;
        }
        throw new IllegalStateException("interceptor " + xVar + " returned a response with no body");
    }

    public F4.k h() {
        return this.f1923b;
    }
}
