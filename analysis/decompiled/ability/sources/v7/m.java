package v7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Agent$Builder;
import com.zyql.protobuf.skull.Task$From$Builder;
import com.zyql.protobuf.skull.User$Builder;

/* loaded from: classes2.dex */
public final class m extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_FIELD_NUMBER = 6;
    private static final m DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int USER_FIELD_NUMBER = 5;
    private C2062a agent_;
    private int bitField0_;
    private y user_;

    static {
        m mVar = new m();
        DEFAULT_INSTANCE = mVar;
        GeneratedMessageLite.C(m.class, mVar);
    }

    public static void D(m mVar) {
        mVar.agent_ = null;
        mVar.bitField0_ &= -3;
    }

    public static void E(m mVar) {
        mVar.user_ = null;
        mVar.bitField0_ &= -2;
    }

    public static void F(m mVar, C2062a c2062a) {
        mVar.getClass();
        c2062a.getClass();
        C2062a c2062a2 = mVar.agent_;
        if (c2062a2 == null || c2062a2 == C2062a.Q()) {
            mVar.agent_ = c2062a;
        } else {
            mVar.agent_ = (C2062a) ((Agent$Builder) C2062a.Z(mVar.agent_).mergeFrom((GeneratedMessageLite) c2062a)).m();
        }
        mVar.bitField0_ |= 2;
    }

    public static void G(m mVar, y yVar) {
        mVar.getClass();
        yVar.getClass();
        y yVar2 = mVar.user_;
        if (yVar2 == null || yVar2 == y.H()) {
            mVar.user_ = yVar;
        } else {
            mVar.user_ = (y) ((User$Builder) y.K(mVar.user_).mergeFrom((GeneratedMessageLite) yVar)).m();
        }
        mVar.bitField0_ |= 1;
    }

    public static void H(m mVar, C2062a c2062a) {
        mVar.getClass();
        c2062a.getClass();
        mVar.agent_ = c2062a;
        mVar.bitField0_ |= 2;
    }

    public static void I(m mVar, y yVar) {
        mVar.getClass();
        yVar.getClass();
        mVar.user_ = yVar;
        mVar.bitField0_ |= 1;
    }

    public final C2062a K() {
        C2062a c2062a = this.agent_;
        return c2062a == null ? C2062a.Q() : c2062a;
    }

    public final y L() {
        y yVar = this.user_;
        return yVar == null ? y.H() : yVar;
    }

    public final boolean M() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean N() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0005\u0006\u0002\u0000\u0000\u0000\u0005ဉ\u0000\u0006ဉ\u0001", new Object[]{"bitField0_", "user_", "agent_"});
            case 3:
                return new m();
            case 4:
                return new Task$From$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (m.class) {
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
