package la;

import Aa.i;
import Z8.C1173v;
import java.util.List;
import kotlin.jvm.internal.p;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import ra.InterfaceC5238k;
import ya.AbstractC5990d0;
import ya.B0;
import ya.s0;

/* renamed from: la.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4878a extends AbstractC5990d0 implements Ca.b {

    /* renamed from: b, reason: collision with root package name */
    public final B0 f36997b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC4879b f36998c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f36999d;

    /* renamed from: e, reason: collision with root package name */
    public final s0 f37000e;

    public C4878a(B0 typeProjection, InterfaceC4879b constructor, boolean z10, s0 attributes) {
        p.i(typeProjection, "typeProjection");
        p.i(constructor, "constructor");
        p.i(attributes, "attributes");
        this.f36997b = typeProjection;
        this.f36998c = constructor;
        this.f36999d = z10;
        this.f37000e = attributes;
    }

    @Override // ya.S
    public List<B0> F0() {
        return C1173v.m();
    }

    @Override // ya.S
    public s0 G0() {
        return this.f37000e;
    }

    @Override // ya.S
    public boolean I0() {
        return this.f36999d;
    }

    @Override // ya.K0
    /* renamed from: P0 */
    public AbstractC5990d0 N0(s0 newAttributes) {
        p.i(newAttributes, "newAttributes");
        return new C4878a(this.f36997b, H0(), I0(), newAttributes);
    }

    @Override // ya.S
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public InterfaceC4879b H0() {
        return this.f36998c;
    }

    @Override // ya.AbstractC5990d0
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public C4878a L0(boolean z10) {
        return z10 == I0() ? this : new C4878a(this.f36997b, H0(), z10, G0());
    }

    @Override // ya.K0
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public C4878a R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        B0 b0A = this.f36997b.a(kotlinTypeRefiner);
        p.h(b0A, "refine(...)");
        return new C4878a(b0A, H0(), I0(), G0());
    }

    @Override // ya.S
    public InterfaceC5238k m() {
        return i.a(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    @Override // ya.AbstractC5990d0
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Captured(");
        sb2.append(this.f36997b);
        sb2.append(')');
        sb2.append(I0() ? "?" : "");
        return sb2.toString();
    }

    public /* synthetic */ C4878a(B0 b02, InterfaceC4879b interfaceC4879b, boolean z10, s0 s0Var, int i10, kotlin.jvm.internal.i iVar) {
        this(b02, (i10 & 2) != 0 ? new C4880c(b02) : interfaceC4879b, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? s0.f44124b.k() : s0Var);
    }
}
