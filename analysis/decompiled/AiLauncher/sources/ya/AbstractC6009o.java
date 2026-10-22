package ya;

import E9.InterfaceC0799d;
import Z8.C1172u;
import Z8.C1173v;
import java.util.Collection;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import xa.InterfaceC5865h;
import xa.InterfaceC5869l;
import za.C6458d;

/* renamed from: ya.o, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC6009o extends AbstractC6014u {

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5865h<b> f44108b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f44109c;

    /* renamed from: ya.o$a */
    public final class a implements v0 {

        /* renamed from: a, reason: collision with root package name */
        public final kotlin.reflect.jvm.internal.impl.types.checker.c f44110a;

        /* renamed from: b, reason: collision with root package name */
        public final Y8.h f44111b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AbstractC6009o f44112c;

        public a(AbstractC6009o abstractC6009o, kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
            kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
            this.f44112c = abstractC6009o;
            this.f44110a = kotlinTypeRefiner;
            this.f44111b = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6008n(this, abstractC6009o));
        }

        public static final List k(a aVar, AbstractC6009o abstractC6009o) {
            return C6458d.b(aVar.f44110a, abstractC6009o.e());
        }

        @Override // ya.v0
        public v0 a(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
            kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
            return this.f44112c.a(kotlinTypeRefiner);
        }

        @Override // ya.v0
        public InterfaceC0799d d() {
            return this.f44112c.d();
        }

        public boolean equals(Object obj) {
            return this.f44112c.equals(obj);
        }

        @Override // ya.v0
        public boolean f() {
            return this.f44112c.f();
        }

        @Override // ya.v0
        public C9.j g() {
            C9.j jVarG = this.f44112c.g();
            kotlin.jvm.internal.p.h(jVarG, "getBuiltIns(...)");
            return jVarG;
        }

        @Override // ya.v0
        public List<E9.b0> getParameters() {
            List<E9.b0> parameters = this.f44112c.getParameters();
            kotlin.jvm.internal.p.h(parameters, "getParameters(...)");
            return parameters;
        }

        public int hashCode() {
            return this.f44112c.hashCode();
        }

        public final List<S> i() {
            return (List) this.f44111b.getValue();
        }

        @Override // ya.v0
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public List<S> e() {
            return i();
        }

        public String toString() {
            return this.f44112c.toString();
        }
    }

    /* renamed from: ya.o$b */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Collection<S> f44113a;

        /* renamed from: b, reason: collision with root package name */
        public List<? extends S> f44114b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Collection<? extends S> allSupertypes) {
            kotlin.jvm.internal.p.i(allSupertypes, "allSupertypes");
            this.f44113a = allSupertypes;
            this.f44114b = C1172u.e(Aa.i.f1351a.l());
        }

        public final Collection<S> a() {
            return this.f44113a;
        }

        public final List<S> b() {
            return this.f44114b;
        }

        public final void c(List<? extends S> list) {
            kotlin.jvm.internal.p.i(list, "<set-?>");
            this.f44114b = list;
        }
    }

    public AbstractC6009o(InterfaceC5869l storageManager) {
        kotlin.jvm.internal.p.i(storageManager, "storageManager");
        this.f44108b = storageManager.e(new C5995g(this), C5997h.f44089a, new C5999i(this));
    }

    public static final b B(AbstractC6009o abstractC6009o) {
        return new b(abstractC6009o.s());
    }

    public static final b C(boolean z10) {
        return new b(C1172u.e(Aa.i.f1351a.l()));
    }

    public static final Y8.t D(AbstractC6009o abstractC6009o, b supertypes) {
        kotlin.jvm.internal.p.i(supertypes, "supertypes");
        List listA = abstractC6009o.w().a(abstractC6009o, supertypes.a(), new C6001j(abstractC6009o), new C6003k(abstractC6009o));
        if (listA.isEmpty()) {
            S sT = abstractC6009o.t();
            List listE = sT != null ? C1172u.e(sT) : null;
            if (listE == null) {
                listE = C1173v.m();
            }
            listA = listE;
        }
        if (abstractC6009o.v()) {
            abstractC6009o.w().a(abstractC6009o, listA, new C6005l(abstractC6009o), new C6007m(abstractC6009o));
        }
        List<S> listM1 = listA instanceof List ? (List) listA : null;
        if (listM1 == null) {
            listM1 = Z8.F.m1(listA);
        }
        supertypes.c(abstractC6009o.y(listM1));
        return Y8.t.f7040a;
    }

    public static final Iterable E(AbstractC6009o abstractC6009o, v0 it) {
        kotlin.jvm.internal.p.i(it, "it");
        return abstractC6009o.r(it, false);
    }

    public static final Y8.t F(AbstractC6009o abstractC6009o, S it) {
        kotlin.jvm.internal.p.i(it, "it");
        abstractC6009o.A(it);
        return Y8.t.f7040a;
    }

    public static final Iterable G(AbstractC6009o abstractC6009o, v0 it) {
        kotlin.jvm.internal.p.i(it, "it");
        return abstractC6009o.r(it, true);
    }

    public static final Y8.t H(AbstractC6009o abstractC6009o, S it) {
        kotlin.jvm.internal.p.i(it, "it");
        abstractC6009o.z(it);
        return Y8.t.f7040a;
    }

    public void A(S type) {
        kotlin.jvm.internal.p.i(type, "type");
    }

    @Override // ya.v0
    public v0 a(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a(this, kotlinTypeRefiner);
    }

    public final Collection<S> r(v0 v0Var, boolean z10) {
        List listS0;
        AbstractC6009o abstractC6009o = v0Var instanceof AbstractC6009o ? (AbstractC6009o) v0Var : null;
        if (abstractC6009o != null && (listS0 = Z8.F.S0(abstractC6009o.f44108b.invoke().a(), abstractC6009o.u(z10))) != null) {
            return listS0;
        }
        Collection<S> collectionE = v0Var.e();
        kotlin.jvm.internal.p.h(collectionE, "getSupertypes(...)");
        return collectionE;
    }

    public abstract Collection<S> s();

    public S t() {
        return null;
    }

    public Collection<S> u(boolean z10) {
        return C1173v.m();
    }

    public boolean v() {
        return this.f44109c;
    }

    public abstract E9.Z w();

    @Override // ya.v0
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public List<S> e() {
        return this.f44108b.invoke().b();
    }

    public List<S> y(List<S> supertypes) {
        kotlin.jvm.internal.p.i(supertypes, "supertypes");
        return supertypes;
    }

    public void z(S type) {
        kotlin.jvm.internal.p.i(type, "type");
    }
}
