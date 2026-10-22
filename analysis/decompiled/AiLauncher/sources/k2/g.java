package k2;

import l2.InterfaceC4863c;
import m2.InterfaceC4893a;

/* loaded from: classes2.dex */
public final /* synthetic */ class g implements InterfaceC4893a.InterfaceC0472a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC4863c f34606a;

    public g(InterfaceC4863c interfaceC4863c) {
        this.f34606a = interfaceC4863c;
    }

    public static InterfaceC4893a.InterfaceC0472a a(InterfaceC4863c interfaceC4863c) {
        return new g(interfaceC4863c);
    }

    @Override // m2.InterfaceC4893a.InterfaceC0472a
    public Object execute() {
        return Integer.valueOf(this.f34606a.q());
    }
}
