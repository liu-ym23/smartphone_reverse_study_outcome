package C0;

import A0.d;
import C0.f;
import H0.n;
import android.util.Log;
import java.util.Collections;
import java.util.List;
import z0.EnumC1335a;
import z0.InterfaceC1338d;
import z0.InterfaceC1340f;

/* loaded from: classes.dex */
class z implements f, d.a<Object>, f.a {

    /* renamed from: a, reason: collision with root package name */
    private final g<?> f512a;

    /* renamed from: b, reason: collision with root package name */
    private final f.a f513b;

    /* renamed from: c, reason: collision with root package name */
    private int f514c;

    /* renamed from: d, reason: collision with root package name */
    private c f515d;

    /* renamed from: e, reason: collision with root package name */
    private Object f516e;

    /* renamed from: f, reason: collision with root package name */
    private volatile n.a<?> f517f;

    /* renamed from: g, reason: collision with root package name */
    private d f518g;

    z(g<?> gVar, f.a aVar) {
        this.f512a = gVar;
        this.f513b = aVar;
    }

    private void g(Object obj) {
        long jB = X0.f.b();
        try {
            InterfaceC1338d<X> interfaceC1338dP = this.f512a.p(obj);
            e eVar = new e(interfaceC1338dP, obj, this.f512a.k());
            this.f518g = new d(this.f517f.f2003a, this.f512a.o());
            this.f512a.d().b(this.f518g, eVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.f518g + ", data: " + obj + ", encoder: " + interfaceC1338dP + ", duration: " + X0.f.a(jB));
            }
            this.f517f.f2005c.b();
            this.f515d = new c(Collections.singletonList(this.f517f.f2003a), this.f512a, this);
        } catch (Throwable th) {
            this.f517f.f2005c.b();
            throw th;
        }
    }

    private boolean h() {
        return this.f514c < this.f512a.g().size();
    }

    @Override // C0.f
    public boolean a() {
        Object obj = this.f516e;
        if (obj != null) {
            this.f516e = null;
            g(obj);
        }
        c cVar = this.f515d;
        if (cVar != null && cVar.a()) {
            return true;
        }
        this.f515d = null;
        this.f517f = null;
        boolean z5 = false;
        while (!z5 && h()) {
            List<n.a<?>> listG = this.f512a.g();
            int i5 = this.f514c;
            this.f514c = i5 + 1;
            this.f517f = listG.get(i5);
            if (this.f517f != null && (this.f512a.e().c(this.f517f.f2005c.d()) || this.f512a.t(this.f517f.f2005c.a()))) {
                this.f517f.f2005c.e(this.f512a.l(), this);
                z5 = true;
            }
        }
        return z5;
    }

    @Override // C0.f.a
    public void b(InterfaceC1340f interfaceC1340f, Exception exc, A0.d<?> dVar, EnumC1335a enumC1335a) {
        this.f513b.b(interfaceC1340f, exc, dVar, this.f517f.f2005c.d());
    }

    @Override // A0.d.a
    public void c(Exception exc) {
        this.f513b.b(this.f518g, exc, this.f517f.f2005c, this.f517f.f2005c.d());
    }

    @Override // C0.f
    public void cancel() {
        n.a<?> aVar = this.f517f;
        if (aVar != null) {
            aVar.f2005c.cancel();
        }
    }

    @Override // C0.f.a
    public void d() {
        throw new UnsupportedOperationException();
    }

    @Override // C0.f.a
    public void e(InterfaceC1340f interfaceC1340f, Object obj, A0.d<?> dVar, EnumC1335a enumC1335a, InterfaceC1340f interfaceC1340f2) {
        this.f513b.e(interfaceC1340f, obj, dVar, this.f517f.f2005c.d(), interfaceC1340f);
    }

    @Override // A0.d.a
    public void f(Object obj) {
        j jVarE = this.f512a.e();
        if (obj == null || !jVarE.c(this.f517f.f2005c.d())) {
            this.f513b.e(this.f517f.f2003a, obj, this.f517f.f2005c, this.f517f.f2005c.d(), this.f518g);
        } else {
            this.f516e = obj;
            this.f513b.d();
        }
    }
}
