package ya;

import E9.InterfaceC0799d;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import p9.InterfaceC5074l;
import ra.InterfaceC5238k;

/* renamed from: ya.Q, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5982Q implements v0, Ca.f {

    /* renamed from: a, reason: collision with root package name */
    public S f44041a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet<S> f44042b;

    /* renamed from: c, reason: collision with root package name */
    public final int f44043c;

    /* renamed from: ya.Q$a */
    public static final class a<T> implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC5074l f44044a;

        public a(InterfaceC5074l interfaceC5074l) {
            this.f44044a = interfaceC5074l;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            S s10 = (S) t10;
            InterfaceC5074l interfaceC5074l = this.f44044a;
            kotlin.jvm.internal.p.f(s10);
            String string = interfaceC5074l.invoke(s10).toString();
            S s11 = (S) t11;
            InterfaceC5074l interfaceC5074l2 = this.f44044a;
            kotlin.jvm.internal.p.f(s11);
            return b9.b.d(string, interfaceC5074l2.invoke(s11).toString());
        }
    }

    public C5982Q(Collection<? extends S> typesToIntersect) {
        kotlin.jvm.internal.p.i(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        LinkedHashSet<S> linkedHashSet = new LinkedHashSet<>(typesToIntersect);
        this.f44042b = linkedHashSet;
        this.f44043c = linkedHashSet.hashCode();
    }

    public static final AbstractC5990d0 m(C5982Q c5982q, kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return c5982q.a(kotlinTypeRefiner).l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String p(C5982Q c5982q, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            interfaceC5074l = C5980O.f44039a;
        }
        return c5982q.o(interfaceC5074l);
    }

    public static final String q(S it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.toString();
    }

    public static final CharSequence r(InterfaceC5074l interfaceC5074l, S s10) {
        kotlin.jvm.internal.p.f(s10);
        return interfaceC5074l.invoke(s10).toString();
    }

    @Override // ya.v0
    public InterfaceC0799d d() {
        return null;
    }

    @Override // ya.v0
    public Collection<S> e() {
        return this.f44042b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C5982Q) {
            return kotlin.jvm.internal.p.d(this.f44042b, ((C5982Q) obj).f44042b);
        }
        return false;
    }

    @Override // ya.v0
    public boolean f() {
        return false;
    }

    @Override // ya.v0
    public C9.j g() {
        C9.j jVarG = this.f44042b.iterator().next().H0().g();
        kotlin.jvm.internal.p.h(jVarG, "getBuiltIns(...)");
        return jVarG;
    }

    @Override // ya.v0
    public List<E9.b0> getParameters() {
        return C1173v.m();
    }

    public int hashCode() {
        return this.f44043c;
    }

    public final InterfaceC5238k k() {
        return ra.x.f38916d.a("member scope for intersection type", this.f44042b);
    }

    public final AbstractC5990d0 l() {
        return V.p(s0.f44124b.k(), this, C1173v.m(), false, k(), new C5981P(this));
    }

    public final S n() {
        return this.f44041a;
    }

    public final String o(InterfaceC5074l<? super S, ? extends Object> getProperTypeRelatedToStringify) {
        kotlin.jvm.internal.p.i(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        return Z8.F.A0(Z8.F.c1(this.f44042b, new a(getProperTypeRelatedToStringify)), " & ", Const.STR_MART_JSON_BEGIN, "}", 0, null, new C5979N(getProperTypeRelatedToStringify), 24, null);
    }

    @Override // ya.v0
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C5982Q a(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        Collection<S> collectionE = e();
        ArrayList arrayList = new ArrayList(C1174w.x(collectionE, 10));
        Iterator<T> it = collectionE.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            arrayList.add(((S) it.next()).R0(kotlinTypeRefiner));
            z10 = true;
        }
        C5982Q c5982qT = null;
        if (z10) {
            S sN = n();
            c5982qT = new C5982Q(arrayList).t(sN != null ? sN.R0(kotlinTypeRefiner) : null);
        }
        return c5982qT == null ? this : c5982qT;
    }

    public final C5982Q t(S s10) {
        return new C5982Q(this.f44042b, s10);
    }

    public String toString() {
        return p(this, null, 1, null);
    }

    public C5982Q(Collection<? extends S> collection, S s10) {
        this(collection);
        this.f44041a = s10;
    }
}
