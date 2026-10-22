package L8;

import X8.A;
import h8.InterfaceC1522e;
import h8.InterfaceC1540w;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes4.dex */
public final class y extends o {
    public final /* synthetic */ int b = 0;

    public y(byte b) {
        super(Byte.valueOf(b));
    }

    @Override // L8.g
    public final X8.w a(InterfaceC1540w module) {
        A aG;
        A aG2;
        A aG3;
        A aG4;
        switch (this.b) {
            case 0:
                kotlin.jvm.internal.k.f(module, "module");
                InterfaceC1522e interfaceC1522eA = kotlin.reflect.jvm.internal.impl.descriptors.a.a(module, e8.n.f4405S);
                return (interfaceC1522eA == null || (aG = interfaceC1522eA.g()) == null) ? Z8.i.c(ErrorTypeKind.f5162z, "UByte") : aG;
            case 1:
                kotlin.jvm.internal.k.f(module, "module");
                InterfaceC1522e interfaceC1522eA2 = kotlin.reflect.jvm.internal.impl.descriptors.a.a(module, e8.n.f4407U);
                return (interfaceC1522eA2 == null || (aG2 = interfaceC1522eA2.g()) == null) ? Z8.i.c(ErrorTypeKind.f5162z, "UInt") : aG2;
            case 2:
                kotlin.jvm.internal.k.f(module, "module");
                InterfaceC1522e interfaceC1522eA3 = kotlin.reflect.jvm.internal.impl.descriptors.a.a(module, e8.n.f4408V);
                return (interfaceC1522eA3 == null || (aG3 = interfaceC1522eA3.g()) == null) ? Z8.i.c(ErrorTypeKind.f5162z, "ULong") : aG3;
            default:
                kotlin.jvm.internal.k.f(module, "module");
                InterfaceC1522e interfaceC1522eA4 = kotlin.reflect.jvm.internal.impl.descriptors.a.a(module, e8.n.f4406T);
                return (interfaceC1522eA4 == null || (aG4 = interfaceC1522eA4.g()) == null) ? Z8.i.c(ErrorTypeKind.f5162z, "UShort") : aG4;
        }
    }

    @Override // L8.g
    public final String toString() {
        switch (this.b) {
            case 0:
                return ((Number) this.f939a).intValue() + ".toUByte()";
            case 1:
                return ((Number) this.f939a).intValue() + ".toUInt()";
            case 2:
                return ((Number) this.f939a).longValue() + ".toULong()";
            default:
                return ((Number) this.f939a).intValue() + ".toUShort()";
        }
    }

    public y(short s5) {
        super(Short.valueOf(s5));
    }

    public y(int i) {
        super(Integer.valueOf(i));
    }

    public y(long j5) {
        super(Long.valueOf(j5));
    }
}
