package Z8;

import Q8.o;
import X8.A;
import X8.H;
import X8.K;
import X8.U;
import X8.w;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public final class g extends A {
    public final K b;
    public final f c;
    public final ErrorTypeKind d;
    public final List e;
    public final boolean f;
    public final String[] g;
    public final String h;

    public g(K k, f fVar, ErrorTypeKind kind, List arguments, boolean z10, String... formatParams) {
        k.f(kind, "kind");
        k.f(arguments, "arguments");
        k.f(formatParams, "formatParams");
        this.b = k;
        this.c = fVar;
        this.d = kind;
        this.e = arguments;
        this.f = z10;
        this.g = formatParams;
        String str = kind.f5163a;
        Object[] objArrCopyOf = Arrays.copyOf(formatParams, formatParams.length);
        this.h = String.format(str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    @Override // X8.w
    public final List L() {
        return this.e;
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
        return this.f;
    }

    @Override // X8.w
    /* renamed from: Y */
    public final w j0(Y8.f kotlinTypeRefiner) {
        k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // X8.U
    public final U j0(Y8.f kotlinTypeRefiner) {
        k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // X8.A, X8.U
    public final U m0(H newAttributes) {
        k.f(newAttributes, "newAttributes");
        return this;
    }

    @Override // X8.A
    /* renamed from: n0 */
    public final A f0(boolean z10) {
        String[] strArr = this.g;
        return new g(this.b, this.c, this.d, this.e, z10, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @Override // X8.A
    /* renamed from: s0 */
    public final A m0(H newAttributes) {
        k.f(newAttributes, "newAttributes");
        return this;
    }

    @Override // X8.w
    public final o w() {
        return this.c;
    }
}
