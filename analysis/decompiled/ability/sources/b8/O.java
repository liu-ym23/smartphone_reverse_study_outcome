package b8;

import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes4.dex */
public final class O extends AbstractC0828A {
    public static final /* synthetic */ Z7.t[] g;
    public final p0 c;
    public final p0 d;
    public final Object e;
    public final Object f;

    static {
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        g = new Z7.t[]{nVar.g(new PropertyReference1Impl(nVar.b(O.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), nVar.g(new PropertyReference1Impl(nVar.b(O.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), nVar.g(new PropertyReference1Impl(nVar.b(O.class), "members", "getMembers()Ljava/util/Collection;"))};
    }

    public O(kotlin.reflect.jvm.internal.b bVar) {
        super(bVar);
        this.c = N9.j.E(null, new C0839L(bVar, 1));
        this.d = N9.j.E(null, new M(this, 0));
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.b;
        this.e = kotlin.a.b(lazyThreadSafetyMode, new N(this, bVar));
        this.f = kotlin.a.b(lazyThreadSafetyMode, new M(this, 1));
        N9.j.E(null, new N(bVar, this));
    }
}
