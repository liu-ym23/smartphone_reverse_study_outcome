package X8;

import a9.InterfaceC0310b;
import a9.InterfaceC0311c;

/* loaded from: classes4.dex */
public final class I extends AbstractC0272c {
    public static final I b = new I(0);
    public static final I c = new I(1);
    public static final I d = new I(2);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1523a;

    public /* synthetic */ I(int i) {
        this.f1523a = i;
    }

    @Override // X8.AbstractC0272c
    public final InterfaceC0311c D(J state, InterfaceC0310b type) {
        switch (this.f1523a) {
            case 0:
                kotlin.jvm.internal.k.f(state, "state");
                kotlin.jvm.internal.k.f(type, "type");
                return state.c.X(type);
            case 1:
                kotlin.jvm.internal.k.f(state, "state");
                kotlin.jvm.internal.k.f(type, "type");
                throw new UnsupportedOperationException("Should not be called");
            default:
                kotlin.jvm.internal.k.f(state, "state");
                kotlin.jvm.internal.k.f(type, "type");
                return state.c.A(type);
        }
    }
}
