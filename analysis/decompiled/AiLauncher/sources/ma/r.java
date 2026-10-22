package ma;

import E9.InterfaceC0799d;
import E9.InterfaceC0819y;
import E9.b0;
import Z8.C1173v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ya.S;
import ya.v0;

/* loaded from: classes5.dex */
public final class r implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public final long f37202a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0819y f37203b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList<S> f37204c;

    @Override // ya.v0
    public v0 a(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // ya.v0
    public /* bridge */ /* synthetic */ InterfaceC0799d d() {
        return (InterfaceC0799d) h();
    }

    @Override // ya.v0
    public Collection<S> e() {
        return this.f37204c;
    }

    @Override // ya.v0
    public boolean f() {
        return false;
    }

    @Override // ya.v0
    public C9.j g() {
        return this.f37203b.g();
    }

    @Override // ya.v0
    public List<b0> getParameters() {
        return C1173v.m();
    }

    public Void h() {
        return null;
    }

    public String toString() {
        return "IntegerValueType(" + this.f37202a + ')';
    }
}
