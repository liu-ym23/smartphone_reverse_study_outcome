package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.UnregisterHookResponse$Builder;

/* loaded from: classes2.dex */
public final class g0 extends GeneratedMessageLite implements Y1 {
    private static final g0 DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    private String error_ = "";
    private boolean success_;

    static {
        g0 g0Var = new g0();
        DEFAULT_INSTANCE = g0Var;
        GeneratedMessageLite.C(g0.class, g0Var);
    }

    public static void D(g0 g0Var) {
        g0Var.getClass();
        g0Var.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void E(g0 g0Var) {
        g0Var.success_ = false;
    }

    public static void F(g0 g0Var, String str) {
        g0Var.getClass();
        str.getClass();
        g0Var.error_ = str;
    }

    public static void G(g0 g0Var, ByteString byteString) {
        g0Var.getClass();
        AbstractC0932e.g(byteString);
        g0Var.error_ = byteString.q();
    }

    public static void H(g0 g0Var, boolean z10) {
        g0Var.success_ = z10;
    }

    public final String J() {
        return this.error_;
    }

    public final ByteString K() {
        return ByteString.f(this.error_);
    }

    public final boolean L() {
        return this.success_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002Ȉ", new Object[]{"success_", "error_"});
            case 3:
                return new g0();
            case 4:
                return new UnregisterHookResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (g0.class) {
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
