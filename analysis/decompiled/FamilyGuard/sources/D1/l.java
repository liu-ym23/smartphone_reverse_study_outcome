package D1;

import A1.p;
import A1.q;
import A1.t;
import A1.u;
import java.io.IOException;

/* loaded from: classes.dex */
public final class l<T> extends t<T> {

    /* renamed from: a, reason: collision with root package name */
    private final q<T> f1093a;

    /* renamed from: b, reason: collision with root package name */
    private final A1.i<T> f1094b;

    /* renamed from: c, reason: collision with root package name */
    final A1.e f1095c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.gson.reflect.a<T> f1096d;

    /* renamed from: e, reason: collision with root package name */
    private final u f1097e;

    /* renamed from: f, reason: collision with root package name */
    private final l<T>.b f1098f = new b();

    /* renamed from: g, reason: collision with root package name */
    private t<T> f1099g;

    private final class b implements p, A1.h {
        private b() {
        }
    }

    public l(q<T> qVar, A1.i<T> iVar, A1.e eVar, com.google.gson.reflect.a<T> aVar, u uVar) {
        this.f1093a = qVar;
        this.f1094b = iVar;
        this.f1095c = eVar;
        this.f1096d = aVar;
        this.f1097e = uVar;
    }

    private t<T> e() {
        t<T> tVar = this.f1099g;
        if (tVar != null) {
            return tVar;
        }
        t<T> tVarM = this.f1095c.m(this.f1097e, this.f1096d);
        this.f1099g = tVarM;
        return tVarM;
    }

    @Override // A1.t
    public T b(G1.a aVar) {
        if (this.f1094b == null) {
            return e().b(aVar);
        }
        A1.j jVarA = C1.l.a(aVar);
        if (jVarA.i()) {
            return null;
        }
        return this.f1094b.a(jVarA, this.f1096d.getType(), this.f1098f);
    }

    @Override // A1.t
    public void d(G1.c cVar, T t5) throws IOException {
        q<T> qVar = this.f1093a;
        if (qVar == null) {
            e().d(cVar, t5);
        } else if (t5 == null) {
            cVar.D();
        } else {
            C1.l.b(qVar.a(t5, this.f1096d.getType(), this.f1098f), cVar);
        }
    }
}
