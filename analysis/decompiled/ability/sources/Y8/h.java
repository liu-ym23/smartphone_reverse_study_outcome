package Y8;

import Q8.o;
import X8.A;
import X8.H;
import X8.K;
import X8.N;
import X8.U;
import a9.InterfaceC0309a;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;

/* loaded from: classes4.dex */
public final class h extends A implements InterfaceC0309a {
    public final CaptureStatus b;
    public final i c;
    public final U d;
    public final H e;
    public final boolean f;
    public final boolean g;

    public h(CaptureStatus captureStatus, i constructor, U u, H attributes, boolean z10, boolean z11) {
        kotlin.jvm.internal.k.f(captureStatus, "captureStatus");
        kotlin.jvm.internal.k.f(constructor, "constructor");
        kotlin.jvm.internal.k.f(attributes, "attributes");
        this.b = captureStatus;
        this.c = constructor;
        this.d = u;
        this.e = attributes;
        this.f = z10;
        this.g = z11;
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
        return this.f;
    }

    @Override // X8.A, X8.U
    public final U f0(boolean z10) {
        return new h(this.b, this.c, this.d, this.e, z10, 32);
    }

    @Override // X8.A
    /* renamed from: n0 */
    public final A f0(boolean z10) {
        return new h(this.b, this.c, this.d, this.e, z10, 32);
    }

    @Override // X8.A
    /* renamed from: s0 */
    public final A m0(H newAttributes) {
        kotlin.jvm.internal.k.f(newAttributes, "newAttributes");
        return new h(this.b, this.c, this.d, newAttributes, this.f, this.g);
    }

    @Override // X8.w
    public final o w() {
        return Z8.i.a(ErrorScopeKind.b, true, new String[0]);
    }

    @Override // X8.U
    /* renamed from: y0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final h j0(f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        i iVar = this.c;
        iVar.getClass();
        N nD = iVar.f1576a.d(kotlinTypeRefiner);
        J4.e eVar = iVar.b != null ? new J4.e(5, iVar, kotlinTypeRefiner) : null;
        i iVar2 = iVar.c;
        if (iVar2 == null) {
            iVar2 = iVar;
        }
        i iVar3 = new i(nD, eVar, iVar2, iVar.d);
        U u = this.d;
        return new h(this.b, iVar3, u != null ? u : null, this.e, this.f, 32);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public h(CaptureStatus captureStatus, i iVar, U u, H h, boolean z10, int i) {
        if ((i & 8) != 0) {
            H.b.getClass();
            h = H.c;
        }
        this(captureStatus, iVar, u, h, (i & 16) != 0 ? false : z10, false);
    }
}
