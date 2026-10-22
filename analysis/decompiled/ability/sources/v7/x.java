package v7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.ToolCallResult$Builder;

/* loaded from: classes2.dex */
public final class x extends GeneratedMessageLite implements Y1 {
    private static final x DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int RESULT_FIELD_NUMBER = 1;
    private String result_ = "";

    static {
        x xVar = new x();
        DEFAULT_INSTANCE = xVar;
        GeneratedMessageLite.C(x.class, xVar);
    }

    public static void D(x xVar) {
        xVar.getClass();
        xVar.result_ = DEFAULT_INSTANCE.result_;
    }

    public static void E(x xVar, String str) {
        xVar.getClass();
        str.getClass();
        xVar.result_ = str;
    }

    public static void F(x xVar, ByteString byteString) {
        xVar.getClass();
        AbstractC0932e.g(byteString);
        xVar.result_ = byteString.q();
    }

    public static x H() {
        return DEFAULT_INSTANCE;
    }

    public static ToolCallResult$Builder K(x xVar) {
        return (ToolCallResult$Builder) DEFAULT_INSTANCE.q(xVar);
    }

    public final String I() {
        return this.result_;
    }

    public final ByteString J() {
        return ByteString.f(this.result_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"result_"});
            case 3:
                return new x();
            case 4:
                return new ToolCallResult$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (x.class) {
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
