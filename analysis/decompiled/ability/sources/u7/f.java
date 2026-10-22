package u7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.LogLevel;
import com.zyql.protobuf.runtime.ExecutionOptions$Builder;

/* loaded from: classes2.dex */
public final class f extends GeneratedMessageLite implements Y1 {
    private static final f DEFAULT_INSTANCE;
    public static final int INCLUDE_FUNCTION_CALL_OUTPUT_FIELD_NUMBER = 1;
    public static final int INCLUDE_SUB_AGENT_OUTPUT_FIELD_NUMBER = 3;
    public static final int LOG_LEVEL_FIELD_NUMBER = 5;
    public static final int OBSERVER_MODE_FIELD_NUMBER = 4;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SEND_COMPLETE_MESSAGE_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean includeFunctionCallOutput_;
    private boolean includeSubAgentOutput_;
    private int logLevel_;
    private boolean observerMode_;
    private boolean sendCompleteMessage_;

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        GeneratedMessageLite.C(f.class, fVar);
    }

    public static void D(f fVar) {
        fVar.bitField0_ &= -2;
        fVar.includeFunctionCallOutput_ = false;
    }

    public static void E(f fVar) {
        fVar.bitField0_ &= -5;
        fVar.includeSubAgentOutput_ = false;
    }

    public static void F(f fVar) {
        fVar.bitField0_ &= -17;
        fVar.logLevel_ = 0;
    }

    public static void G(f fVar) {
        fVar.bitField0_ &= -9;
        fVar.observerMode_ = false;
    }

    public static void H(f fVar) {
        fVar.bitField0_ &= -3;
        fVar.sendCompleteMessage_ = false;
    }

    public static void I(f fVar, boolean z10) {
        fVar.bitField0_ |= 1;
        fVar.includeFunctionCallOutput_ = z10;
    }

    public static void J(f fVar, boolean z10) {
        fVar.bitField0_ |= 4;
        fVar.includeSubAgentOutput_ = z10;
    }

    public static void K(f fVar, LogLevel logLevel) {
        fVar.getClass();
        fVar.logLevel_ = logLevel.getNumber();
        fVar.bitField0_ |= 16;
    }

    public static void L(f fVar, int i) {
        fVar.bitField0_ |= 16;
        fVar.logLevel_ = i;
    }

    public static void M(f fVar, boolean z10) {
        fVar.bitField0_ |= 8;
        fVar.observerMode_ = z10;
    }

    public static void N(f fVar, boolean z10) {
        fVar.bitField0_ |= 2;
        fVar.sendCompleteMessage_ = z10;
    }

    public static f P() {
        return DEFAULT_INSTANCE;
    }

    public static ExecutionOptions$Builder b0() {
        return (ExecutionOptions$Builder) DEFAULT_INSTANCE.p();
    }

    public static ExecutionOptions$Builder c0(f fVar) {
        return (ExecutionOptions$Builder) DEFAULT_INSTANCE.q(fVar);
    }

    public final boolean Q() {
        return this.includeFunctionCallOutput_;
    }

    public final boolean R() {
        return this.includeSubAgentOutput_;
    }

    public final LogLevel S() {
        LogLevel logLevelA = LogLevel.a(this.logLevel_);
        return logLevelA == null ? LogLevel.UNRECOGNIZED : logLevelA;
    }

    public final int T() {
        return this.logLevel_;
    }

    public final boolean U() {
        return this.observerMode_;
    }

    public final boolean V() {
        return this.sendCompleteMessage_;
    }

    public final boolean W() {
        return (this.bitField0_ & 1) != 0;
    }

    public final boolean X() {
        return (this.bitField0_ & 4) != 0;
    }

    public final boolean Y() {
        return (this.bitField0_ & 16) != 0;
    }

    public final boolean Z() {
        return (this.bitField0_ & 8) != 0;
    }

    public final boolean a0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဌ\u0004", new Object[]{"bitField0_", "includeFunctionCallOutput_", "sendCompleteMessage_", "includeSubAgentOutput_", "observerMode_", "logLevel_"});
            case 3:
                return new f();
            case 4:
                return new ExecutionOptions$Builder(0);
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
