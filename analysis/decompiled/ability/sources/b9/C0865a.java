package b9;

import S7.k;
import X8.U;
import h8.InterfaceC1506N;
import h8.InterfaceC1507O;
import h8.InterfaceC1524g;

/* renamed from: b9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0865a implements k {
    public static final C0865a b = new C0865a(0);
    public static final C0865a c = new C0865a(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2065a;

    public /* synthetic */ C0865a(int i) {
        this.f2065a = i;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        U it = (U) obj;
        switch (this.f2065a) {
            case 0:
                kotlin.jvm.internal.k.f(it, "it");
                InterfaceC1524g interfaceC1524gD = it.Q().d();
                return Boolean.valueOf(interfaceC1524gD != null && (interfaceC1524gD instanceof InterfaceC1507O) && (((InterfaceC1507O) interfaceC1524gD).d() instanceof InterfaceC1506N));
            default:
                kotlin.jvm.internal.k.f(it, "it");
                InterfaceC1524g interfaceC1524gD2 = it.Q().d();
                return Boolean.valueOf(interfaceC1524gD2 != null && ((interfaceC1524gD2 instanceof InterfaceC1506N) || (interfaceC1524gD2 instanceof InterfaceC1507O)));
        }
    }
}
