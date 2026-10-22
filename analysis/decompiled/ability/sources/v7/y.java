package v7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.User$Builder;

/* loaded from: classes2.dex */
public final class y extends GeneratedMessageLite implements Y1 {
    private static final y DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int USER_ID_FIELD_NUMBER = 1;
    private String userId_ = "";

    static {
        y yVar = new y();
        DEFAULT_INSTANCE = yVar;
        GeneratedMessageLite.C(y.class, yVar);
    }

    public static void D(y yVar) {
        yVar.getClass();
        yVar.userId_ = DEFAULT_INSTANCE.userId_;
    }

    public static void E(y yVar, String str) {
        yVar.getClass();
        str.getClass();
        yVar.userId_ = str;
    }

    public static void F(y yVar, ByteString byteString) {
        yVar.getClass();
        AbstractC0932e.g(byteString);
        yVar.userId_ = byteString.q();
    }

    public static y H() {
        return DEFAULT_INSTANCE;
    }

    public static User$Builder K(y yVar) {
        return (User$Builder) DEFAULT_INSTANCE.q(yVar);
    }

    public final String I() {
        return this.userId_;
    }

    public final ByteString J() {
        return ByteString.f(this.userId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"userId_"});
            case 3:
                return new y();
            case 4:
                return new User$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (y.class) {
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
