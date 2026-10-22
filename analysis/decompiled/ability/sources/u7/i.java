package u7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.runtime.InputMessageStateNotification$Builder;
import com.zyql.protobuf.runtime.InputMessageStateNotification$State;

/* loaded from: classes2.dex */
public final class i extends GeneratedMessageLite implements Y1 {
    private static final i DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    private int bitField0_;
    private String details_ = "";
    private int state_;

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        GeneratedMessageLite.C(i.class, iVar);
    }

    public static void D(i iVar) {
        iVar.bitField0_ &= -2;
        iVar.details_ = DEFAULT_INSTANCE.details_;
    }

    public static void E(i iVar) {
        iVar.state_ = 0;
    }

    public static void F(i iVar, String str) {
        iVar.getClass();
        str.getClass();
        iVar.bitField0_ |= 1;
        iVar.details_ = str;
    }

    public static void G(i iVar, ByteString byteString) {
        iVar.getClass();
        AbstractC0932e.g(byteString);
        iVar.details_ = byteString.q();
        iVar.bitField0_ |= 1;
    }

    public static void H(i iVar, InputMessageStateNotification$State inputMessageStateNotification$State) {
        iVar.getClass();
        iVar.state_ = inputMessageStateNotification$State.getNumber();
    }

    public static void I(i iVar, int i) {
        iVar.state_ = i;
    }

    public static i K() {
        return DEFAULT_INSTANCE;
    }

    public static InputMessageStateNotification$Builder Q(i iVar) {
        return (InputMessageStateNotification$Builder) DEFAULT_INSTANCE.q(iVar);
    }

    public final String L() {
        return this.details_;
    }

    public final ByteString M() {
        return ByteString.f(this.details_);
    }

    public final InputMessageStateNotification$State N() {
        int i = this.state_;
        InputMessageStateNotification$State inputMessageStateNotification$State = i != 0 ? i != 1 ? i != 2 ? null : InputMessageStateNotification$State.STATE_SUBMITTED : InputMessageStateNotification$State.STATE_QUEUED : InputMessageStateNotification$State.STATE_UNSPECIFIED;
        return inputMessageStateNotification$State == null ? InputMessageStateNotification$State.UNRECOGNIZED : inputMessageStateNotification$State;
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
                return new i();
            case 4:
                return new InputMessageStateNotification$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (i.class) {
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
