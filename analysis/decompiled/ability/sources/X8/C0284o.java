package X8;

import i8.InterfaceC1561g;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* renamed from: X8.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0284o extends P {
    public final P b;
    public final P c;

    public C0284o(P p, P p3) {
        this.b = p;
        this.c = p3;
    }

    @Override // X8.P
    public final boolean a() {
        return this.b.a() || this.c.a();
    }

    @Override // X8.P
    public final boolean b() {
        return this.b.b() || this.c.b();
    }

    @Override // X8.P
    public final InterfaceC1561g c(InterfaceC1561g annotations) {
        kotlin.jvm.internal.k.f(annotations, "annotations");
        return this.c.c(this.b.c(annotations));
    }

    @Override // X8.P
    public final N d(w wVar) {
        N nD = this.b.d(wVar);
        return nD == null ? this.c.d(wVar) : nD;
    }

    @Override // X8.P
    public final w f(w topLevelType, Variance position) {
        kotlin.jvm.internal.k.f(topLevelType, "topLevelType");
        kotlin.jvm.internal.k.f(position, "position");
        return this.c.f(this.b.f(topLevelType, position), position);
    }
}
