package v7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Message$Builder;
import com.zyql.protobuf.skull.TaskContext$Builder;
import com.zyql.protobuf.skull.TaskInput$Builder;

/* loaded from: classes2.dex */
public final class r extends GeneratedMessageLite implements Y1 {
    public static final int CONTEXT_FIELD_NUMBER = 1;
    private static final r DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER;
    private int bitField0_;
    private q context_;
    private i message_;

    static {
        r rVar = new r();
        DEFAULT_INSTANCE = rVar;
        GeneratedMessageLite.C(r.class, rVar);
    }

    public static void D(r rVar) {
        rVar.context_ = null;
        rVar.bitField0_ &= -2;
    }

    public static void E(r rVar) {
        rVar.message_ = null;
        rVar.bitField0_ &= -3;
    }

    public static void F(r rVar, q qVar) {
        rVar.getClass();
        qVar.getClass();
        q qVar2 = rVar.context_;
        if (qVar2 == null || qVar2 == q.N()) {
            rVar.context_ = qVar;
        } else {
            rVar.context_ = (q) ((TaskContext$Builder) q.R(rVar.context_).mergeFrom((GeneratedMessageLite) qVar)).m();
        }
        rVar.bitField0_ |= 1;
    }

    public static void G(r rVar, i iVar) {
        rVar.getClass();
        iVar.getClass();
        i iVar2 = rVar.message_;
        if (iVar2 == null || iVar2 == i.T()) {
            rVar.message_ = iVar;
        } else {
            rVar.message_ = (i) ((Message$Builder) i.a0(rVar.message_).mergeFrom((GeneratedMessageLite) iVar)).m();
        }
        rVar.bitField0_ |= 2;
    }

    public static void H(r rVar, q qVar) {
        rVar.getClass();
        qVar.getClass();
        rVar.context_ = qVar;
        rVar.bitField0_ |= 1;
    }

    public static void I(r rVar, i iVar) {
        rVar.getClass();
        iVar.getClass();
        rVar.message_ = iVar;
        rVar.bitField0_ |= 2;
    }

    public static r L() {
        return DEFAULT_INSTANCE;
    }

    public static TaskInput$Builder P(r rVar) {
        return (TaskInput$Builder) DEFAULT_INSTANCE.q(rVar);
    }

    public final q K() {
        q qVar = this.context_;
        return qVar == null ? q.N() : qVar;
    }

    public final i M() {
        i iVar = this.message_;
        return iVar == null ? i.T() : iVar;
    }

    public final boolean N() {
        return (this.bitField0_ & 1) != 0;
    }

    public final boolean O() {
        return (this.bitField0_ & 2) != 0;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"bitField0_", "context_", "message_"});
            case 3:
                return new r();
            case 4:
                return new TaskInput$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (r.class) {
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
