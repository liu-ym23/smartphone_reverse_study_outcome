package R8;

import G8.f;
import X8.w;
import h8.InterfaceC1519b;
import h8.InterfaceC1522e;
import h8.InterfaceC1528k;
import k8.AbstractC1645n;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class a extends A8.b implements d {
    public final /* synthetic */ int b = 1;
    public final f c;
    public final InterfaceC1528k d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(InterfaceC1519b interfaceC1519b, w receiverType, f fVar) {
        super(receiverType);
        k.f(receiverType, "receiverType");
        this.d = (AbstractC1645n) interfaceC1519b;
        this.c = fVar;
    }

    public final f P0() {
        switch (this.b) {
        }
        return this.c;
    }

    public final String toString() {
        switch (this.b) {
            case 0:
                return getType() + ": Ctx { " + ((InterfaceC1522e) this.d) + " }";
            default:
                return "Cxt { " + ((AbstractC1645n) this.d) + " }";
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(InterfaceC1522e interfaceC1522e, w receiverType, f fVar) {
        super(receiverType);
        k.f(receiverType, "receiverType");
        this.d = interfaceC1522e;
        this.c = fVar;
    }
}
