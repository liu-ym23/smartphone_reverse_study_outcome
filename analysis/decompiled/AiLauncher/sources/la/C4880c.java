package la;

import C9.j;
import E9.InterfaceC0799d;
import E9.b0;
import Z8.C1172u;
import Z8.C1173v;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import ya.B0;
import ya.S;
import za.C6464j;

/* renamed from: la.c, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4880c implements InterfaceC4879b {

    /* renamed from: a, reason: collision with root package name */
    public final B0 f37001a;

    /* renamed from: b, reason: collision with root package name */
    public C6464j f37002b;

    public C4880c(B0 projection) {
        p.i(projection, "projection");
        this.f37001a = projection;
        c().c();
        Variance variance = Variance.INVARIANT;
    }

    @Override // la.InterfaceC4879b
    public B0 c() {
        return this.f37001a;
    }

    @Override // ya.v0
    public /* bridge */ /* synthetic */ InterfaceC0799d d() {
        return (InterfaceC0799d) h();
    }

    @Override // ya.v0
    public Collection<S> e() {
        S type = c().c() == Variance.OUT_VARIANCE ? c().getType() : g().J();
        p.f(type);
        return C1172u.e(type);
    }

    @Override // ya.v0
    public boolean f() {
        return false;
    }

    @Override // ya.v0
    public j g() {
        j jVarG = c().getType().H0().g();
        p.h(jVarG, "getBuiltIns(...)");
        return jVarG;
    }

    @Override // ya.v0
    public List<b0> getParameters() {
        return C1173v.m();
    }

    public Void h() {
        return null;
    }

    public final C6464j i() {
        return this.f37002b;
    }

    @Override // ya.v0
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C4880c a(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        B0 b0A = c().a(kotlinTypeRefiner);
        p.h(b0A, "refine(...)");
        return new C4880c(b0A);
    }

    public final void k(C6464j c6464j) {
        this.f37002b = c6464j;
    }

    public String toString() {
        return "CapturedTypeConstructor(" + c() + ')';
    }
}
