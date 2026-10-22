package u7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.runtime.ChatResponse$Builder;
import com.zyql.protobuf.runtime.ChatResponse$ContentCase;
import com.zyql.protobuf.runtime.RequestAck$Builder;
import com.zyql.protobuf.runtime.Task$Builder;

/* loaded from: classes2.dex */
public final class e extends GeneratedMessageLite implements Y1 {
    public static final int ACK_FIELD_NUMBER = 1;
    private static final e DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 10;
    public static final int TASK_FIELD_NUMBER = 2;
    private int bitField0_;
    private Object content_;
    private int contentCase_ = 0;
    private String sessionId_ = "";

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        GeneratedMessageLite.C(e.class, eVar);
    }

    public static void D(e eVar) {
        if (eVar.contentCase_ == 1) {
            eVar.contentCase_ = 0;
            eVar.content_ = null;
        }
    }

    public static void E(e eVar) {
        eVar.contentCase_ = 0;
        eVar.content_ = null;
    }

    public static void F(e eVar) {
        eVar.bitField0_ &= -2;
        eVar.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void G(e eVar) {
        if (eVar.contentCase_ == 2) {
            eVar.contentCase_ = 0;
            eVar.content_ = null;
        }
    }

    public static void H(e eVar, m mVar) {
        eVar.getClass();
        mVar.getClass();
        if (eVar.contentCase_ != 1 || eVar.content_ == m.X()) {
            eVar.content_ = mVar;
        } else {
            eVar.content_ = ((RequestAck$Builder) m.j0((m) eVar.content_).mergeFrom((GeneratedMessageLite) mVar)).m();
        }
        eVar.contentCase_ = 1;
    }

    public static void I(e eVar, r rVar) {
        eVar.getClass();
        rVar.getClass();
        if (eVar.contentCase_ != 2 || eVar.content_ == r.a0()) {
            eVar.content_ = rVar;
        } else {
            eVar.content_ = ((Task$Builder) r.o0((r) eVar.content_).mergeFrom((GeneratedMessageLite) rVar)).m();
        }
        eVar.contentCase_ = 2;
    }

    public static void J(e eVar, m mVar) {
        eVar.getClass();
        mVar.getClass();
        eVar.content_ = mVar;
        eVar.contentCase_ = 1;
    }

    public static void K(e eVar, String str) {
        eVar.getClass();
        str.getClass();
        eVar.bitField0_ |= 1;
        eVar.sessionId_ = str;
    }

    public static void L(e eVar, ByteString byteString) {
        eVar.getClass();
        AbstractC0932e.g(byteString);
        eVar.sessionId_ = byteString.q();
        eVar.bitField0_ |= 1;
    }

    public static void M(e eVar, r rVar) {
        eVar.getClass();
        rVar.getClass();
        eVar.content_ = rVar;
        eVar.contentCase_ = 2;
    }

    public static e W(ByteString byteString) {
        return (e) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString);
    }

    public final m O() {
        return this.contentCase_ == 1 ? (m) this.content_ : m.X();
    }

    public final ChatResponse$ContentCase P() {
        int i = this.contentCase_;
        if (i == 0) {
            return ChatResponse$ContentCase.c;
        }
        if (i == 1) {
            return ChatResponse$ContentCase.f4275a;
        }
        if (i != 2) {
            return null;
        }
        return ChatResponse$ContentCase.b;
    }

    public final String Q() {
        return this.sessionId_;
    }

    public final ByteString R() {
        return ByteString.f(this.sessionId_);
    }

    public final r S() {
        return this.contentCase_ == 2 ? (r) this.content_ : r.a0();
    }

    public final boolean T() {
        return this.contentCase_ == 1;
    }

    public final boolean U() {
        return (this.bitField0_ & 1) != 0;
    }

    public final boolean V() {
        return this.contentCase_ == 2;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0001\u0001\n\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\nለ\u0000", new Object[]{"content_", "contentCase_", "bitField0_", m.class, r.class, "sessionId_"});
            case 3:
                return new e();
            case 4:
                return new ChatResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (e.class) {
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
