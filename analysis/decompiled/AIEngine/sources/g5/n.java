package g5;

import com.google.gson.reflect.TypeToken;
import d5.u;
import d5.v;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n<T> extends m<T> {

    /* renamed from: a, reason: collision with root package name */
    public final d5.n<T> f9021a;

    /* renamed from: b, reason: collision with root package name */
    public final d5.i f9022b;

    /* renamed from: c, reason: collision with root package name */
    public final TypeToken<T> f9023c;

    /* renamed from: d, reason: collision with root package name */
    public final v f9024d;

    /* renamed from: e, reason: collision with root package name */
    public final n<T>.a f9025e = new a();

    /* renamed from: f, reason: collision with root package name */
    public final boolean f9026f;

    /* renamed from: g, reason: collision with root package name */
    public volatile u<T> f9027g;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class a implements d5.m {
        public a() {
        }

        public final <R> R a(d5.o oVar, Type type) {
            d5.i iVar = n.this.f9022b;
            iVar.getClass();
            TypeToken<?> typeToken = TypeToken.get(type);
            e eVar = new e(e.f8981w);
            eVar.f8983s = new Object[32];
            eVar.f8984t = 0;
            eVar.f8985u = new String[32];
            eVar.f8986v = new int[32];
            eVar.h1(oVar);
            return (R) iVar.d(eVar, typeToken);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements v {

        /* renamed from: a, reason: collision with root package name */
        public final TypeToken<?> f9029a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f9030b;

        /* renamed from: c, reason: collision with root package name */
        public final d5.n<?> f9031c;

        public b(d5.n nVar, TypeToken typeToken, boolean z) {
            this.f9031c = nVar;
            this.f9029a = typeToken;
            this.f9030b = z;
        }

        @Override // d5.v
        public final <T> u<T> b(d5.i iVar, TypeToken<T> typeToken) {
            TypeToken<?> typeToken2 = this.f9029a;
            if (typeToken2 == null) {
                typeToken.getRawType();
                throw null;
            }
            if (typeToken2.equals(typeToken) || (this.f9030b && typeToken2.getType() == typeToken.getRawType())) {
                return new n(null, this.f9031c, iVar, typeToken, this, true);
            }
            return null;
        }
    }

    public n(d5.s<T> sVar, d5.n<T> nVar, d5.i iVar, TypeToken<T> typeToken, v vVar, boolean z) {
        this.f9021a = nVar;
        this.f9022b = iVar;
        this.f9023c = typeToken;
        this.f9024d = vVar;
        this.f9026f = z;
    }

    @Override // d5.u
    public final T a(k5.a aVar) {
        d5.n<T> nVar = this.f9021a;
        if (nVar == null) {
            u<T> uVarF = this.f9027g;
            if (uVarF == null) {
                uVarF = this.f9022b.f(this.f9024d, this.f9023c);
                this.f9027g = uVarF;
            }
            return uVarF.a(aVar);
        }
        d5.o oVarR = a4.a.r(aVar);
        if (this.f9026f) {
            oVarR.getClass();
            if (oVarR instanceof d5.p) {
                return null;
            }
        }
        return nVar.deserialize(oVarR, this.f9023c.getType(), this.f9025e);
    }

    @Override // d5.u
    public final void b(k5.b bVar, T t8) {
        u<T> uVarF = this.f9027g;
        if (uVarF == null) {
            uVarF = this.f9022b.f(this.f9024d, this.f9023c);
            this.f9027g = uVarF;
        }
        uVarF.b(bVar, t8);
    }

    @Override // g5.m
    public final u<T> c() {
        u<T> uVar = this.f9027g;
        if (uVar != null) {
            return uVar;
        }
        u<T> uVarF = this.f9022b.f(this.f9024d, this.f9023c);
        this.f9027g = uVarF;
        return uVarF;
    }
}
