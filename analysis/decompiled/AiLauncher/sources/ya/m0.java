package ya;

import ra.InterfaceC5238k;
import za.InterfaceC6465k;

/* loaded from: classes5.dex */
public final class m0 extends AbstractC5989d implements Ca.i {

    /* renamed from: f, reason: collision with root package name */
    public final v0 f44100f;

    /* renamed from: g, reason: collision with root package name */
    public final InterfaceC5238k f44101g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(InterfaceC6465k originalTypeVariable, boolean z10, v0 constructor) {
        super(originalTypeVariable, z10);
        kotlin.jvm.internal.p.i(originalTypeVariable, "originalTypeVariable");
        kotlin.jvm.internal.p.i(constructor, "constructor");
        this.f44100f = constructor;
        this.f44101g = originalTypeVariable.g().i().m();
    }

    @Override // ya.S
    public v0 H0() {
        return this.f44100f;
    }

    @Override // ya.AbstractC5989d
    public AbstractC5989d R0(boolean z10) {
        return new m0(Q0(), z10, H0());
    }

    @Override // ya.AbstractC5989d, ya.S
    public InterfaceC5238k m() {
        return this.f44101g;
    }

    @Override // ya.AbstractC5990d0
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Stub (BI): ");
        sb2.append(Q0());
        sb2.append(I0() ? "?" : "");
        return sb2.toString();
    }
}
