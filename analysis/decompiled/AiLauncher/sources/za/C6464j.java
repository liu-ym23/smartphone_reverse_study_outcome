package za;

import E9.InterfaceC0799d;
import E9.b0;
import Z8.C1173v;
import Z8.C1174w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import la.InterfaceC4879b;
import p9.InterfaceC5063a;
import ya.B0;
import ya.K0;
import ya.S;

/* renamed from: za.j, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6464j implements InterfaceC4879b {

    /* renamed from: a, reason: collision with root package name */
    public final B0 f45415a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC5063a<? extends List<? extends K0>> f45416b;

    /* renamed from: c, reason: collision with root package name */
    public final C6464j f45417c;

    /* renamed from: d, reason: collision with root package name */
    public final b0 f45418d;

    /* renamed from: e, reason: collision with root package name */
    public final Y8.h f45419e;

    public C6464j(B0 projection, InterfaceC5063a<? extends List<? extends K0>> interfaceC5063a, C6464j c6464j, b0 b0Var) {
        kotlin.jvm.internal.p.i(projection, "projection");
        this.f45415a = projection;
        this.f45416b = interfaceC5063a;
        this.f45417c = c6464j;
        this.f45418d = b0Var;
        this.f45419e = C4848b.a(LazyThreadSafetyMode.PUBLICATION, new C6460f(this));
    }

    public static final List h(List list) {
        return list;
    }

    public static final List i(C6464j c6464j) {
        InterfaceC5063a<? extends List<? extends K0>> interfaceC5063a = c6464j.f45416b;
        if (interfaceC5063a != null) {
            return interfaceC5063a.invoke();
        }
        return null;
    }

    public static final List q(List list) {
        return list;
    }

    public static final List s(C6464j c6464j, kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        List<K0> listE = c6464j.e();
        ArrayList arrayList = new ArrayList(C1174w.x(listE, 10));
        Iterator<T> it = listE.iterator();
        while (it.hasNext()) {
            arrayList.add(((K0) it.next()).R0(cVar));
        }
        return arrayList;
    }

    @Override // la.InterfaceC4879b
    public B0 c() {
        return this.f45415a;
    }

    @Override // ya.v0
    public InterfaceC0799d d() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!kotlin.jvm.internal.p.d(C6464j.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.p.g(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        C6464j c6464j = (C6464j) obj;
        C6464j c6464j2 = this.f45417c;
        if (c6464j2 != null) {
            this = c6464j2;
        }
        C6464j c6464j3 = c6464j.f45417c;
        if (c6464j3 != null) {
            obj = c6464j3;
        }
        return this == obj;
    }

    @Override // ya.v0
    public boolean f() {
        return false;
    }

    @Override // ya.v0
    public C9.j g() {
        S type = c().getType();
        kotlin.jvm.internal.p.h(type, "getType(...)");
        return Da.d.n(type);
    }

    @Override // ya.v0
    public List<b0> getParameters() {
        return C1173v.m();
    }

    public int hashCode() {
        C6464j c6464j = this.f45417c;
        return c6464j != null ? c6464j.hashCode() : super.hashCode();
    }

    @Override // ya.v0
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public List<K0> e() {
        List<K0> listO = o();
        return listO == null ? C1173v.m() : listO;
    }

    public final List<K0> o() {
        return (List) this.f45419e.getValue();
    }

    public final void p(List<? extends K0> supertypes) {
        kotlin.jvm.internal.p.i(supertypes, "supertypes");
        this.f45416b = new C6462h(supertypes);
    }

    @Override // ya.v0
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C6464j a(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        B0 b0A = c().a(kotlinTypeRefiner);
        kotlin.jvm.internal.p.h(b0A, "refine(...)");
        C6463i c6463i = this.f45416b != null ? new C6463i(this, kotlinTypeRefiner) : null;
        C6464j c6464j = this.f45417c;
        if (c6464j == null) {
            c6464j = this;
        }
        return new C6464j(b0A, c6463i, c6464j, this.f45418d);
    }

    public String toString() {
        return "CapturedType(" + c() + ')';
    }

    public /* synthetic */ C6464j(B0 b02, InterfaceC5063a interfaceC5063a, C6464j c6464j, b0 b0Var, int i10, kotlin.jvm.internal.i iVar) {
        this(b02, (i10 & 2) != 0 ? null : interfaceC5063a, (i10 & 4) != 0 ? null : c6464j, (i10 & 8) != 0 ? null : b0Var);
    }

    public /* synthetic */ C6464j(B0 b02, List list, C6464j c6464j, int i10, kotlin.jvm.internal.i iVar) {
        this(b02, list, (i10 & 4) != 0 ? null : c6464j);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C6464j(B0 projection, List<? extends K0> supertypes, C6464j c6464j) {
        this(projection, new C6461g(supertypes), c6464j, null, 8, null);
        kotlin.jvm.internal.p.i(projection, "projection");
        kotlin.jvm.internal.p.i(supertypes, "supertypes");
    }
}
