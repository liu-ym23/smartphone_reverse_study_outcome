package L8;

import X8.A;
import h8.InterfaceC1522e;
import h8.InterfaceC1540w;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public final class i extends g {
    public final G8.b b;
    public final G8.f c;

    public i(G8.b bVar, G8.f fVar) {
        super(new Pair(bVar, fVar));
        this.b = bVar;
        this.c = fVar;
    }

    @Override // L8.g
    public final X8.w a(InterfaceC1540w module) {
        A aG;
        kotlin.jvm.internal.k.f(module, "module");
        G8.b bVar = this.b;
        InterfaceC1522e interfaceC1522eA = kotlin.reflect.jvm.internal.impl.descriptors.a.a(module, bVar);
        if (interfaceC1522eA != null) {
            int i = J8.e.f883a;
            if (!J8.e.n(interfaceC1522eA, ClassKind.c)) {
                interfaceC1522eA = null;
            }
            if (interfaceC1522eA != null && (aG = interfaceC1522eA.g()) != null) {
                return aG;
            }
        }
        return Z8.i.c(ErrorTypeKind.f5149A, bVar.toString(), this.c.f690a);
    }

    @Override // L8.g
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.f());
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }
}
