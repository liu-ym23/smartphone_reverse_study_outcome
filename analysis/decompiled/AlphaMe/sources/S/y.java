package S;

import b3.InterfaceC0379h;
import b3.InterfaceC0380i;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes.dex */
public final class y implements InterfaceC0379h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1783a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0379h f1784b;

    public /* synthetic */ y(InterfaceC0379h interfaceC0379h, int i4) {
        this.f1783a = i4;
        this.f1784b = interfaceC0379h;
    }

    @Override // b3.InterfaceC0379h
    public final Object collect(InterfaceC0380i interfaceC0380i, Continuation continuation) {
        int i4 = this.f1783a;
        InterfaceC0379h interfaceC0379h = this.f1784b;
        switch (i4) {
            case 0:
                Object objCollect = interfaceC0379h.collect(new x(interfaceC0380i, 0), continuation);
                if (objCollect != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    break;
                }
                break;
            case 1:
                Object objCollect2 = interfaceC0379h.collect(new x(interfaceC0380i, 1), continuation);
                if (objCollect2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    break;
                }
                break;
            case 2:
                Object objCollect3 = interfaceC0379h.collect(new x(interfaceC0380i, 2), continuation);
                if (objCollect3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    break;
                }
                break;
            case 3:
                Object objCollect4 = interfaceC0379h.collect(new x(interfaceC0380i, 3), continuation);
                if (objCollect4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    break;
                }
                break;
            default:
                Object objCollect5 = interfaceC0379h.collect(new x(interfaceC0380i, 4), continuation);
                if (objCollect5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    break;
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
