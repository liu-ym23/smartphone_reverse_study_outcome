package u7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.runtime.AgentTaskStateNotification$Builder;
import com.zyql.protobuf.runtime.AgentTaskStateNotification$State;

/* renamed from: u7.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2042a extends GeneratedMessageLite implements Y1 {
    private static final C2042a DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    private int bitField0_;
    private String details_ = "";
    private int state_;

    static {
        C2042a c2042a = new C2042a();
        DEFAULT_INSTANCE = c2042a;
        GeneratedMessageLite.C(C2042a.class, c2042a);
    }

    public static void D(C2042a c2042a) {
        c2042a.bitField0_ &= -2;
        c2042a.details_ = DEFAULT_INSTANCE.details_;
    }

    public static void E(C2042a c2042a) {
        c2042a.state_ = 0;
    }

    public static void F(C2042a c2042a, String str) {
        c2042a.getClass();
        str.getClass();
        c2042a.bitField0_ |= 1;
        c2042a.details_ = str;
    }

    public static void G(C2042a c2042a, ByteString byteString) {
        c2042a.getClass();
        AbstractC0932e.g(byteString);
        c2042a.details_ = byteString.q();
        c2042a.bitField0_ |= 1;
    }

    public static void H(C2042a c2042a, AgentTaskStateNotification$State agentTaskStateNotification$State) {
        c2042a.getClass();
        c2042a.state_ = agentTaskStateNotification$State.getNumber();
    }

    public static void I(C2042a c2042a, int i) {
        c2042a.state_ = i;
    }

    public static C2042a K() {
        return DEFAULT_INSTANCE;
    }

    public static AgentTaskStateNotification$Builder Q(C2042a c2042a) {
        return (AgentTaskStateNotification$Builder) DEFAULT_INSTANCE.q(c2042a);
    }

    public final String L() {
        return this.details_;
    }

    public final ByteString M() {
        return ByteString.f(this.details_);
    }

    public final AgentTaskStateNotification$State N() {
        int i = this.state_;
        AgentTaskStateNotification$State agentTaskStateNotification$State = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? null : AgentTaskStateNotification$State.STATE_INTERRUPTED : AgentTaskStateNotification$State.STATE_COMPLETED : AgentTaskStateNotification$State.STATE_PROCESSING : AgentTaskStateNotification$State.STATE_INITIALIZED : AgentTaskStateNotification$State.STATE_UNSPECIFIED;
        return agentTaskStateNotification$State == null ? AgentTaskStateNotification$State.UNRECOGNIZED : agentTaskStateNotification$State;
    }

    public final int O() {
        return this.state_;
    }

    public final boolean P() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002ለ\u0000", new Object[]{"bitField0_", "state_", "details_"});
            case 3:
                return new C2042a();
            case 4:
                return new AgentTaskStateNotification$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C2042a.class) {
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
