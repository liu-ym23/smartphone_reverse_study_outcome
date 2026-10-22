package K8;

import X8.N;
import X8.P;
import X8.w;
import h8.InterfaceC1507O;
import h8.InterfaceC1524g;
import i8.InterfaceC1561g;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes4.dex */
public final class d extends P {
    public final /* synthetic */ int b;
    public final P c;

    public /* synthetic */ d(P p, int i) {
        this.b = i;
        this.c = p;
    }

    @Override // X8.P
    public boolean a() {
        switch (this.b) {
            case 0:
                return this.c.a();
            default:
                return super.a();
        }
    }

    @Override // X8.P
    public boolean b() {
        switch (this.b) {
            case 0:
                return true;
            default:
                return super.b();
        }
    }

    @Override // X8.P
    public final InterfaceC1561g c(InterfaceC1561g annotations) {
        switch (this.b) {
            case 0:
                k.f(annotations, "annotations");
                break;
            default:
                k.f(annotations, "annotations");
                break;
        }
        return this.c.c(annotations);
    }

    @Override // X8.P
    public final N d(w wVar) {
        switch (this.b) {
            case 0:
                N nD = this.c.d(wVar);
                if (nD == null) {
                    return null;
                }
                InterfaceC1524g interfaceC1524gD = wVar.Q().d();
                return M.a.L(nD, interfaceC1524gD instanceof InterfaceC1507O ? (InterfaceC1507O) interfaceC1524gD : null);
            default:
                return this.c.d(wVar);
        }
    }

    @Override // X8.P
    public final boolean e() {
        switch (this.b) {
        }
        return this.c.e();
    }

    @Override // X8.P
    public final w f(w topLevelType, Variance position) {
        switch (this.b) {
            case 0:
                k.f(topLevelType, "topLevelType");
                k.f(position, "position");
                break;
            default:
                k.f(topLevelType, "topLevelType");
                k.f(position, "position");
                break;
        }
        return this.c.f(topLevelType, position);
    }
}
