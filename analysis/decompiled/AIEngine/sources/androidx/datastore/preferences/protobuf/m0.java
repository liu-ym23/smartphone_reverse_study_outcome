package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.q;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m0<T> implements w0<T> {

    /* renamed from: a, reason: collision with root package name */
    public final i0 f1867a;

    /* renamed from: b, reason: collision with root package name */
    public final c1<?, ?> f1868b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1869c;

    /* renamed from: d, reason: collision with root package name */
    public final n<?> f1870d;

    public m0(c1<?, ?> c1Var, n<?> nVar, i0 i0Var) {
        this.f1868b = c1Var;
        this.f1869c = nVar.e(i0Var);
        this.f1870d = nVar;
        this.f1867a = i0Var;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final void a(T t8, v0 v0Var, m mVar) {
        c1 c1Var = this.f1868b;
        d1 d1VarF = c1Var.f(t8);
        n nVar = this.f1870d;
        q<ET> qVarD = nVar.d(t8);
        while (v0Var.D() != Integer.MAX_VALUE) {
            try {
                m0<T> m0Var = this;
                v0 v0Var2 = v0Var;
                m mVar2 = mVar;
                if (!m0Var.j(v0Var2, mVar2, nVar, qVarD, c1Var, d1VarF)) {
                    return;
                }
                this = m0Var;
                v0Var = v0Var2;
                mVar = mVar2;
            } finally {
                c1Var.n(t8, d1VarF);
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final void b(T t8) {
        this.f1868b.j(t8);
        this.f1870d.f(t8);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final int c(a aVar) {
        c1<?, ?> c1Var = this.f1868b;
        int i10 = c1Var.i(c1Var.g(aVar));
        if (this.f1869c) {
            y0 y0Var = this.f1870d.c(aVar).f1876a;
            if (y0Var.f1908b.size() > 0) {
                q.d(y0Var.c(0));
                throw null;
            }
            Iterator<Map.Entry<Object, Object>> it = y0Var.e().iterator();
            if (it.hasNext()) {
                q.d(it.next());
                throw null;
            }
        }
        return i10;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final boolean d(T t8) {
        this.f1870d.c(t8).e();
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final T e() {
        return (T) this.f1867a.d().h();
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final void f(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
        Class<?> cls = x0.f1899a;
        c1<?, ?> c1Var = this.f1868b;
        c1Var.o(generatedMessageLite, c1Var.k(c1Var.g(generatedMessageLite), c1Var.g(generatedMessageLite2)));
        if (this.f1869c) {
            x0.y(this.f1870d, generatedMessageLite, generatedMessageLite2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final int g(GeneratedMessageLite generatedMessageLite) {
        int iHashCode = this.f1868b.g(generatedMessageLite).hashCode();
        if (!this.f1869c) {
            return iHashCode;
        }
        return this.f1870d.c(generatedMessageLite).f1876a.hashCode() + (iHashCode * 53);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final void h(T t8, h1 h1Var) {
        Iterator itG = this.f1870d.c(t8).g();
        if (itG.hasNext()) {
            ((q.a) ((Map.Entry) itG.next()).getKey()).f();
            throw null;
        }
        c1<?, ?> c1Var = this.f1868b;
        c1Var.q(c1Var.g(t8), h1Var);
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final boolean i(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2) {
        c1<?, ?> c1Var = this.f1868b;
        if (!c1Var.g(generatedMessageLite).equals(c1Var.g(generatedMessageLite2))) {
            return false;
        }
        if (!this.f1869c) {
            return true;
        }
        n<?> nVar = this.f1870d;
        return nVar.c(generatedMessageLite).equals(nVar.c(generatedMessageLite2));
    }

    public final <UT, UB, ET extends q.a<ET>> boolean j(v0 v0Var, m mVar, n<ET> nVar, q<ET> qVar, c1<UT, UB> c1Var, UB ub2) throws InvalidProtocolBufferException {
        int tag = v0Var.getTag();
        i0 i0Var = this.f1867a;
        if (tag != 11) {
            if ((tag & 7) != 2) {
                return v0Var.H();
            }
            GeneratedMessageLite.e eVarB = nVar.b(mVar, i0Var, tag >>> 3);
            if (eVarB == null) {
                return c1Var.l(ub2, v0Var);
            }
            nVar.h(eVarB);
            throw null;
        }
        int iH = 0;
        GeneratedMessageLite.e eVarB2 = null;
        ByteString byteStringO = null;
        while (v0Var.D() != Integer.MAX_VALUE) {
            int tag2 = v0Var.getTag();
            if (tag2 == 16) {
                iH = v0Var.h();
                eVarB2 = nVar.b(mVar, i0Var, iH);
            } else if (tag2 == 26) {
                if (eVarB2 != null) {
                    nVar.h(eVarB2);
                    throw null;
                }
                byteStringO = v0Var.o();
            } else if (!v0Var.H()) {
                break;
            }
        }
        if (v0Var.getTag() != 12) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
        if (byteStringO == null) {
            return true;
        }
        if (eVarB2 == null) {
            c1Var.d(ub2, iH, byteStringO);
            return true;
        }
        nVar.i(eVarB2);
        throw null;
    }
}
