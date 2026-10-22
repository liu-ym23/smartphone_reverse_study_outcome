package K8;

import Q8.o;
import X8.A;
import X8.H;
import X8.K;
import X8.N;
import X8.U;
import X8.w;
import Y8.f;
import Z8.i;
import a9.InterfaceC0309a;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;

/* loaded from: classes4.dex */
public final class a extends A implements InterfaceC0309a {
    public final N b;
    public final c c;
    public final boolean d;
    public final H e;

    public a(N typeProjection, c cVar, boolean z10, H attributes) {
        k.f(typeProjection, "typeProjection");
        k.f(attributes, "attributes");
        this.b = typeProjection;
        this.c = cVar;
        this.d = z10;
        this.e = attributes;
    }

    @Override // X8.w
    public final List L() {
        return EmptyList.f4893a;
    }

    @Override // X8.w
    public final H M() {
        return this.e;
    }

    @Override // X8.w
    public final K Q() {
        return this.c;
    }

    @Override // X8.w
    public final boolean W() {
        return this.d;
    }

    @Override // X8.w
    /* renamed from: Y */
    public final w j0(f kotlinTypeRefiner) {
        k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a(this.b.d(kotlinTypeRefiner), this.c, this.d, this.e);
    }

    @Override // X8.A, X8.U
    public final U f0(boolean z10) {
        if (z10 == this.d) {
            return this;
        }
        return new a(this.b, this.c, z10, this.e);
    }

    @Override // X8.U
    public final U j0(f kotlinTypeRefiner) {
        k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new a(this.b.d(kotlinTypeRefiner), this.c, this.d, this.e);
    }

    @Override // X8.A
    /* renamed from: n0 */
    public final A f0(boolean z10) {
        if (z10 == this.d) {
            return this;
        }
        return new a(this.b, this.c, z10, this.e);
    }

    @Override // X8.A
    /* renamed from: s0 */
    public final A m0(H newAttributes) {
        k.f(newAttributes, "newAttributes");
        return new a(this.b, this.c, this.d, newAttributes);
    }

    @Override // X8.A
    public final String toString() {
        StringBuilder sb = new StringBuilder("Captured(");
        sb.append(this.b);
        sb.append(')');
        sb.append(this.d ? "?" : "");
        return sb.toString();
    }

    @Override // X8.w
    public final o w() {
        return i.a(ErrorScopeKind.b, true, new String[0]);
    }
}
