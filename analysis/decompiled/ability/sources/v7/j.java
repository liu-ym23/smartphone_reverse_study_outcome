package v7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.MessageDelta$Builder;

/* loaded from: classes2.dex */
public final class j extends GeneratedMessageLite implements Y1 {
    private static final j DEFAULT_INSTANCE;
    public static final int DELTA_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER;
    private String delta_ = "";

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        GeneratedMessageLite.C(j.class, jVar);
    }

    public static void D(j jVar) {
        jVar.getClass();
        jVar.delta_ = DEFAULT_INSTANCE.delta_;
    }

    public static void E(j jVar, String str) {
        jVar.getClass();
        str.getClass();
        jVar.delta_ = str;
    }

    public static void F(j jVar, ByteString byteString) {
        jVar.getClass();
        AbstractC0932e.g(byteString);
        jVar.delta_ = byteString.q();
    }

    public static j H() {
        return DEFAULT_INSTANCE;
    }

    public static MessageDelta$Builder K(j jVar) {
        return (MessageDelta$Builder) DEFAULT_INSTANCE.q(jVar);
    }

    public final String I() {
        return this.delta_;
    }

    public final ByteString J() {
        return ByteString.f(this.delta_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"delta_"});
            case 3:
                return new j();
            case 4:
                return new MessageDelta$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (j.class) {
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
