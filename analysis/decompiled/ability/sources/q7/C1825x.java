package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.LogMessage$Builder;
import com.zyql.protobuf.common.LogNotification$Builder;

/* renamed from: q7.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1825x extends GeneratedMessageLite implements Y1 {
    private static final C1825x DEFAULT_INSTANCE;
    public static final int LOG_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private C1824w log_;
    private String sessionId_ = "";

    static {
        C1825x c1825x = new C1825x();
        DEFAULT_INSTANCE = c1825x;
        GeneratedMessageLite.C(C1825x.class, c1825x);
    }

    public static void D(C1825x c1825x) {
        c1825x.log_ = null;
        c1825x.bitField0_ &= -2;
    }

    public static void E(C1825x c1825x) {
        c1825x.getClass();
        c1825x.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void F(C1825x c1825x, C1824w c1824w) {
        c1825x.getClass();
        c1824w.getClass();
        C1824w c1824w2 = c1825x.log_;
        if (c1824w2 == null || c1824w2 == C1824w.R()) {
            c1825x.log_ = c1824w;
        } else {
            c1825x.log_ = (C1824w) ((LogMessage$Builder) C1824w.X(c1825x.log_).mergeFrom((GeneratedMessageLite) c1824w)).m();
        }
        c1825x.bitField0_ |= 1;
    }

    public static void G(C1825x c1825x, C1824w c1824w) {
        c1825x.getClass();
        c1824w.getClass();
        c1825x.log_ = c1824w;
        c1825x.bitField0_ |= 1;
    }

    public static void H(C1825x c1825x, String str) {
        c1825x.getClass();
        str.getClass();
        c1825x.sessionId_ = str;
    }

    public static void I(C1825x c1825x, ByteString byteString) {
        c1825x.getClass();
        AbstractC0932e.g(byteString);
        c1825x.sessionId_ = byteString.q();
    }

    public static C1825x K() {
        return DEFAULT_INSTANCE;
    }

    public static LogNotification$Builder P(C1825x c1825x) {
        return (LogNotification$Builder) DEFAULT_INSTANCE.q(c1825x);
    }

    public final C1824w L() {
        C1824w c1824w = this.log_;
        return c1824w == null ? C1824w.R() : c1824w;
    }

    public final String M() {
        return this.sessionId_;
    }

    public final ByteString N() {
        return ByteString.f(this.sessionId_);
    }

    public final boolean O() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"bitField0_", "sessionId_", "log_"});
            case 3:
                return new C1825x();
            case 4:
                return new LogNotification$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1825x.class) {
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
