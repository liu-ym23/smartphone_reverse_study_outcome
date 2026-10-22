package X8;

import java.util.List;

/* loaded from: classes4.dex */
public final class B extends A {
    public final K b;
    public final List c;
    public final boolean d;
    public final Q8.o e;
    public final S7.k f;

    public B(K constructor, List arguments, boolean z10, Q8.o memberScope, S7.k kVar) {
        kotlin.jvm.internal.k.f(constructor, "constructor");
        kotlin.jvm.internal.k.f(arguments, "arguments");
        kotlin.jvm.internal.k.f(memberScope, "memberScope");
        this.b = constructor;
        this.c = arguments;
        this.d = z10;
        this.e = memberScope;
        this.f = kVar;
        if (!(memberScope instanceof Z8.f) || (memberScope instanceof Z8.j)) {
            return;
        }
        throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + memberScope + '\n' + constructor);
    }

    @Override // X8.w
    public final List L() {
        return this.c;
    }

    @Override // X8.w
    public final H M() {
        H.b.getClass();
        return H.c;
    }

    @Override // X8.w
    public final K Q() {
        return this.b;
    }

    @Override // X8.w
    public final boolean W() {
        return this.d;
    }

    @Override // X8.w
    /* renamed from: Y */
    public final w j0(Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        A a3 = (A) this.f.invoke(kotlinTypeRefiner);
        return a3 == null ? this : a3;
    }

    @Override // X8.U
    public final U j0(Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        A a3 = (A) this.f.invoke(kotlinTypeRefiner);
        return a3 == null ? this : a3;
    }

    @Override // X8.A
    /* renamed from: n0 */
    public final A f0(boolean z10) {
        return z10 == this.d ? this : z10 ? new z(this, 1) : new z(this, 0);
    }

    @Override // X8.A
    /* renamed from: s0 */
    public final A m0(H newAttributes) {
        kotlin.jvm.internal.k.f(newAttributes, "newAttributes");
        return newAttributes.isEmpty() ? this : new C(this, newAttributes);
    }

    @Override // X8.w
    public final Q8.o w() {
        return this.e;
    }
}
