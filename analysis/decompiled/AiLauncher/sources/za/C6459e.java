package za;

import E9.b0;
import Z8.C1173v;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import ra.InterfaceC5238k;
import ya.AbstractC5990d0;
import ya.B0;
import ya.K0;
import ya.s0;

/* renamed from: za.e, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C6459e extends AbstractC5990d0 implements Ca.b {

    /* renamed from: b, reason: collision with root package name */
    public final CaptureStatus f45404b;

    /* renamed from: c, reason: collision with root package name */
    public final C6464j f45405c;

    /* renamed from: d, reason: collision with root package name */
    public final K0 f45406d;

    /* renamed from: e, reason: collision with root package name */
    public final s0 f45407e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f45408f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f45409g;

    public C6459e(CaptureStatus captureStatus, C6464j constructor, K0 k02, s0 attributes, boolean z10, boolean z11) {
        kotlin.jvm.internal.p.i(captureStatus, "captureStatus");
        kotlin.jvm.internal.p.i(constructor, "constructor");
        kotlin.jvm.internal.p.i(attributes, "attributes");
        this.f45404b = captureStatus;
        this.f45405c = constructor;
        this.f45406d = k02;
        this.f45407e = attributes;
        this.f45408f = z10;
        this.f45409g = z11;
    }

    @Override // ya.S
    public List<B0> F0() {
        return C1173v.m();
    }

    @Override // ya.S
    public s0 G0() {
        return this.f45407e;
    }

    @Override // ya.S
    public boolean I0() {
        return this.f45408f;
    }

    @Override // ya.K0
    /* renamed from: P0 */
    public AbstractC5990d0 N0(s0 newAttributes) {
        kotlin.jvm.internal.p.i(newAttributes, "newAttributes");
        return new C6459e(this.f45404b, H0(), this.f45406d, newAttributes, I0(), this.f45409g);
    }

    public final CaptureStatus Q0() {
        return this.f45404b;
    }

    @Override // ya.S
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public C6464j H0() {
        return this.f45405c;
    }

    public final K0 S0() {
        return this.f45406d;
    }

    public final boolean T0() {
        return this.f45409g;
    }

    @Override // ya.AbstractC5990d0
    /* renamed from: U0, reason: merged with bridge method [inline-methods] */
    public C6459e L0(boolean z10) {
        return new C6459e(this.f45404b, H0(), this.f45406d, G0(), z10, false, 32, null);
    }

    @Override // ya.K0
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public C6459e R0(kotlin.reflect.jvm.internal.impl.types.checker.c kotlinTypeRefiner) {
        kotlin.jvm.internal.p.i(kotlinTypeRefiner, "kotlinTypeRefiner");
        CaptureStatus captureStatus = this.f45404b;
        C6464j c6464jA = H0().a(kotlinTypeRefiner);
        K0 k02 = this.f45406d;
        return new C6459e(captureStatus, c6464jA, k02 != null ? kotlinTypeRefiner.a(k02).K0() : null, G0(), I0(), false, 32, null);
    }

    @Override // ya.S
    public InterfaceC5238k m() {
        return Aa.i.a(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    public /* synthetic */ C6459e(CaptureStatus captureStatus, C6464j c6464j, K0 k02, s0 s0Var, boolean z10, boolean z11, int i10, kotlin.jvm.internal.i iVar) {
        this(captureStatus, c6464j, k02, (i10 & 8) != 0 ? s0.f44124b.k() : s0Var, (i10 & 16) != 0 ? false : z10, (i10 & 32) != 0 ? false : z11);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C6459e(CaptureStatus captureStatus, K0 k02, B0 projection, b0 typeParameter) {
        this(captureStatus, new C6464j(projection, null, null, typeParameter, 6, null), k02, null, false, false, 56, null);
        kotlin.jvm.internal.p.i(captureStatus, "captureStatus");
        kotlin.jvm.internal.p.i(projection, "projection");
        kotlin.jvm.internal.p.i(typeParameter, "typeParameter");
    }
}
