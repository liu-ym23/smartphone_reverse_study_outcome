package v7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Interrupt$Builder;
import com.zyql.protobuf.skull.Message$Builder;

/* loaded from: classes2.dex */
public final class g extends GeneratedMessageLite implements Y1 {
    private static final g DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER;
    private int bitField0_;
    private i message_;

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        GeneratedMessageLite.C(g.class, gVar);
    }

    public static void D(g gVar) {
        gVar.message_ = null;
        gVar.bitField0_ &= -2;
    }

    public static void E(g gVar, i iVar) {
        gVar.getClass();
        iVar.getClass();
        i iVar2 = gVar.message_;
        if (iVar2 == null || iVar2 == i.T()) {
            gVar.message_ = iVar;
        } else {
            gVar.message_ = (i) ((Message$Builder) i.a0(gVar.message_).mergeFrom((GeneratedMessageLite) iVar)).m();
        }
        gVar.bitField0_ |= 1;
    }

    public static void F(g gVar, i iVar) {
        gVar.getClass();
        iVar.getClass();
        gVar.message_ = iVar;
        gVar.bitField0_ |= 1;
    }

    public static g H() {
        return DEFAULT_INSTANCE;
    }

    public static Interrupt$Builder K(g gVar) {
        return (Interrupt$Builder) DEFAULT_INSTANCE.q(gVar);
    }

    public final i I() {
        i iVar = this.message_;
        return iVar == null ? i.T() : iVar;
    }

    public final boolean J() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public final Object r(GeneratedMessageLite.MethodToInvoke methodToInvoke) {
        InterfaceC0955j2 c0922b1;
        switch (methodToInvoke.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "message_"});
            case 3:
                return new g();
            case 4:
                return new Interrupt$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (g.class) {
                    try {
                        c0922b1 = PARSER;
                        if (c0922b1 == null) {
                            c0922b1 = new C0922b1(DEFAULT_INSTANCE);
                            PARSER = c0922b1;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return c0922b1;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
