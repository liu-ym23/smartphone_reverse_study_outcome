package u7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.runtime.CancelAck$Builder;
import com.zyql.protobuf.runtime.RequestAck$AckTypeCase;
import com.zyql.protobuf.runtime.RequestAck$Builder;
import com.zyql.protobuf.runtime.SendInputAck$Builder;
import com.zyql.protobuf.runtime.StartAgentAck$Builder;

/* loaded from: classes2.dex */
public final class m extends GeneratedMessageLite implements Y1 {
    public static final int CANCEL_ACK_FIELD_NUMBER = 6;
    private static final m DEFAULT_INSTANCE;
    public static final int ERROR_CODE_FIELD_NUMBER = 2;
    public static final int ERROR_MESSAGE_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int REQUEST_ID_FIELD_NUMBER = 1;
    public static final int SEND_INPUT_ACK_FIELD_NUMBER = 5;
    public static final int START_AGENT_ACK_FIELD_NUMBER = 4;
    private Object ackType_;
    private int bitField0_;
    private int errorCode_;
    private long requestId_;
    private int ackTypeCase_ = 0;
    private String errorMessage_ = "";

    static {
        m mVar = new m();
        DEFAULT_INSTANCE = mVar;
        GeneratedMessageLite.C(m.class, mVar);
    }

    public static void D(m mVar) {
        mVar.ackTypeCase_ = 0;
        mVar.ackType_ = null;
    }

    public static void E(m mVar) {
        if (mVar.ackTypeCase_ == 6) {
            mVar.ackTypeCase_ = 0;
            mVar.ackType_ = null;
        }
    }

    public static void F(m mVar) {
        mVar.bitField0_ &= -2;
        mVar.errorCode_ = 0;
    }

    public static void G(m mVar) {
        mVar.bitField0_ &= -3;
        mVar.errorMessage_ = DEFAULT_INSTANCE.errorMessage_;
    }

    public static void H(m mVar) {
        mVar.requestId_ = 0L;
    }

    public static void I(m mVar) {
        if (mVar.ackTypeCase_ == 5) {
            mVar.ackTypeCase_ = 0;
            mVar.ackType_ = null;
        }
    }

    public static void J(m mVar) {
        if (mVar.ackTypeCase_ == 4) {
            mVar.ackTypeCase_ = 0;
            mVar.ackType_ = null;
        }
    }

    public static void K(m mVar, b bVar) {
        mVar.getClass();
        bVar.getClass();
        if (mVar.ackTypeCase_ != 6 || mVar.ackType_ == b.H()) {
            mVar.ackType_ = bVar;
        } else {
            mVar.ackType_ = ((CancelAck$Builder) b.L((b) mVar.ackType_).mergeFrom((GeneratedMessageLite) bVar)).m();
        }
        mVar.ackTypeCase_ = 6;
    }

    public static void L(m mVar, n nVar) {
        mVar.getClass();
        nVar.getClass();
        if (mVar.ackTypeCase_ != 5 || mVar.ackType_ == n.E()) {
            mVar.ackType_ = nVar;
        } else {
            mVar.ackType_ = ((SendInputAck$Builder) n.F((n) mVar.ackType_).mergeFrom((GeneratedMessageLite) nVar)).m();
        }
        mVar.ackTypeCase_ = 5;
    }

    public static void M(m mVar, p pVar) {
        mVar.getClass();
        pVar.getClass();
        if (mVar.ackTypeCase_ != 4 || mVar.ackType_ == p.T()) {
            mVar.ackType_ = pVar;
        } else {
            mVar.ackType_ = ((StartAgentAck$Builder) p.a0((p) mVar.ackType_).mergeFrom((GeneratedMessageLite) pVar)).m();
        }
        mVar.ackTypeCase_ = 4;
    }

    public static void N(m mVar, b bVar) {
        mVar.getClass();
        bVar.getClass();
        mVar.ackType_ = bVar;
        mVar.ackTypeCase_ = 6;
    }

    public static void O(m mVar, int i) {
        mVar.bitField0_ |= 1;
        mVar.errorCode_ = i;
    }

    public static void P(m mVar, String str) {
        mVar.getClass();
        str.getClass();
        mVar.bitField0_ |= 2;
        mVar.errorMessage_ = str;
    }

    public static void Q(m mVar, ByteString byteString) {
        mVar.getClass();
        AbstractC0932e.g(byteString);
        mVar.errorMessage_ = byteString.q();
        mVar.bitField0_ |= 2;
    }

    public static void R(m mVar, long j5) {
        mVar.requestId_ = j5;
    }

    public static void S(m mVar, n nVar) {
        mVar.getClass();
        nVar.getClass();
        mVar.ackType_ = nVar;
        mVar.ackTypeCase_ = 5;
    }

    public static void T(m mVar, p pVar) {
        mVar.getClass();
        pVar.getClass();
        mVar.ackType_ = pVar;
        mVar.ackTypeCase_ = 4;
    }

    public static m X() {
        return DEFAULT_INSTANCE;
    }

    public static RequestAck$Builder j0(m mVar) {
        return (RequestAck$Builder) DEFAULT_INSTANCE.q(mVar);
    }

    public final RequestAck$AckTypeCase V() {
        int i = this.ackTypeCase_;
        if (i == 0) {
            return RequestAck$AckTypeCase.d;
        }
        if (i == 4) {
            return RequestAck$AckTypeCase.f4277a;
        }
        if (i == 5) {
            return RequestAck$AckTypeCase.b;
        }
        if (i != 6) {
            return null;
        }
        return RequestAck$AckTypeCase.c;
    }

    public final b W() {
        return this.ackTypeCase_ == 6 ? (b) this.ackType_ : b.H();
    }

    public final int Y() {
        return this.errorCode_;
    }

    public final String Z() {
        return this.errorMessage_;
    }

    public final ByteString a0() {
        return ByteString.f(this.errorMessage_);
    }

    public final long b0() {
        return this.requestId_;
    }

    public final n c0() {
        return this.ackTypeCase_ == 5 ? (n) this.ackType_ : n.E();
    }

    public final p d0() {
        return this.ackTypeCase_ == 4 ? (p) this.ackType_ : p.T();
    }

    public final boolean e0() {
        return this.ackTypeCase_ == 6;
    }

    public final boolean f0() {
        return (this.bitField0_ & 1) != 0;
    }

    public final boolean g0() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean h0() {
        return this.ackTypeCase_ == 5;
    }

    public final boolean i0() {
        return this.ackTypeCase_ == 4;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0003\u0002င\u0000\u0003ለ\u0001\u0004<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"ackType_", "ackTypeCase_", "bitField0_", "requestId_", "errorCode_", "errorMessage_", p.class, n.class, b.class});
            case 3:
                return new m();
            case 4:
                return new RequestAck$Builder(0);
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
