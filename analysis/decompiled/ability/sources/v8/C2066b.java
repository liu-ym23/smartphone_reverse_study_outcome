package v8;

import X8.K;
import fa.C1449a;
import h8.InterfaceC1507O;
import h8.InterfaceC1524g;
import n8.j;

/* renamed from: v8.b, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2066b implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final A5.c f6791a;
    public final InterfaceC1507O b;
    public final C2065a c;
    public final K d;
    public final j e;

    public C2066b(A5.c cVar, InterfaceC1507O interfaceC1507O, C2065a c2065a, K k, j jVar) {
        this.f6791a = cVar;
        this.b = interfaceC1507O;
        this.c = c2065a;
        this.d = k;
        this.e = jVar;
    }

    @Override // S7.a
    public final Object invoke() {
        C1449a c1449a = (C1449a) this.f6791a.d;
        InterfaceC1524g interfaceC1524gD = this.d.d();
        return c1449a.j(this.b, C2065a.a(C2065a.a(this.c, null, false, null, interfaceC1524gD != null ? interfaceC1524gD.g() : null, 31), null, this.e.d(), null, null, 59));
    }
}
