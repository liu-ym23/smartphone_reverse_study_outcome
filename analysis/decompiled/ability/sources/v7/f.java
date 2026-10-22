package v7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Handoff$Builder;
import com.zyql.protobuf.skull.Task$Builder;

/* loaded from: classes2.dex */
public final class f extends GeneratedMessageLite implements Y1 {
    private static final f DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TASK_FIELD_NUMBER = 1;
    private int bitField0_;
    private o task_;

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        GeneratedMessageLite.C(f.class, fVar);
    }

    public static void D(f fVar) {
        fVar.task_ = null;
        fVar.bitField0_ &= -2;
    }

    public static void E(f fVar, o oVar) {
        fVar.getClass();
        oVar.getClass();
        o oVar2 = fVar.task_;
        if (oVar2 == null || oVar2 == o.y0()) {
            fVar.task_ = oVar;
        } else {
            fVar.task_ = (o) ((Task$Builder) o.U0(fVar.task_).mergeFrom((GeneratedMessageLite) oVar)).m();
        }
        fVar.bitField0_ |= 1;
    }

    public static void F(f fVar, o oVar) {
        fVar.getClass();
        oVar.getClass();
        fVar.task_ = oVar;
        fVar.bitField0_ |= 1;
    }

    public static f H() {
        return DEFAULT_INSTANCE;
    }

    public static Handoff$Builder K(f fVar) {
        return (Handoff$Builder) DEFAULT_INSTANCE.q(fVar);
    }

    public final o I() {
        o oVar = this.task_;
        return oVar == null ? o.y0() : oVar;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "task_"});
            case 3:
                return new f();
            case 4:
                return new Handoff$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (f.class) {
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
