package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.UnregisterHookRequest$Builder;

/* loaded from: classes2.dex */
public final class f0 extends GeneratedMessageLite implements Y1 {
    private static final f0 DEFAULT_INSTANCE;
    public static final int HOOK_ID_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 2;
    private String hookId_ = "";
    private String sessionId_ = "";

    static {
        f0 f0Var = new f0();
        DEFAULT_INSTANCE = f0Var;
        GeneratedMessageLite.C(f0.class, f0Var);
    }

    public static void D(f0 f0Var) {
        f0Var.getClass();
        f0Var.hookId_ = DEFAULT_INSTANCE.hookId_;
    }

    public static void E(f0 f0Var) {
        f0Var.getClass();
        f0Var.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void F(f0 f0Var, String str) {
        f0Var.getClass();
        str.getClass();
        f0Var.hookId_ = str;
    }

    public static void G(f0 f0Var, ByteString byteString) {
        f0Var.getClass();
        AbstractC0932e.g(byteString);
        f0Var.hookId_ = byteString.q();
    }

    public static void H(f0 f0Var, String str) {
        f0Var.getClass();
        str.getClass();
        f0Var.sessionId_ = str;
    }

    public static void I(f0 f0Var, ByteString byteString) {
        f0Var.getClass();
        AbstractC0932e.g(byteString);
        f0Var.sessionId_ = byteString.q();
    }

    public final String K() {
        return this.hookId_;
    }

    public final ByteString L() {
        return ByteString.f(this.hookId_);
    }

    public final String M() {
        return this.sessionId_;
    }

    public final ByteString N() {
        return ByteString.f(this.sessionId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"hookId_", "sessionId_"});
            case 3:
                return new f0();
            case 4:
                return new UnregisterHookRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (f0.class) {
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
