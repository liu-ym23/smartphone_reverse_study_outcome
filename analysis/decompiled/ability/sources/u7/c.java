package u7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.runtime.CancelRequest$Builder;

/* loaded from: classes2.dex */
public final class c extends GeneratedMessageLite implements Y1 {
    private static final c DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private String sessionId_ = "";
    private String reason_ = "";

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        GeneratedMessageLite.C(c.class, cVar);
    }

    public static void D(c cVar) {
        cVar.getClass();
        cVar.reason_ = DEFAULT_INSTANCE.reason_;
    }

    public static void E(c cVar) {
        cVar.getClass();
        cVar.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void F(c cVar, String str) {
        cVar.getClass();
        str.getClass();
        cVar.reason_ = str;
    }

    public static void G(c cVar, ByteString byteString) {
        cVar.getClass();
        AbstractC0932e.g(byteString);
        cVar.reason_ = byteString.q();
    }

    public static void H(c cVar, String str) {
        cVar.getClass();
        str.getClass();
        cVar.sessionId_ = str;
    }

    public static void I(c cVar, ByteString byteString) {
        cVar.getClass();
        AbstractC0932e.g(byteString);
        cVar.sessionId_ = byteString.q();
    }

    public static c K() {
        return DEFAULT_INSTANCE;
    }

    public static CancelRequest$Builder P(c cVar) {
        return (CancelRequest$Builder) DEFAULT_INSTANCE.q(cVar);
    }

    public final String L() {
        return this.reason_;
    }

    public final ByteString M() {
        return ByteString.f(this.reason_);
    }

    public final String N() {
        return this.sessionId_;
    }

    public final ByteString O() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"sessionId_", "reason_"});
            case 3:
                return new c();
            case 4:
                return new CancelRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (c.class) {
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
