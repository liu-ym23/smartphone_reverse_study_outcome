package p7;

import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.client_agent.ChatCompletionReq$Builder;

/* loaded from: classes2.dex */
public final class a extends GeneratedMessageLite implements Y1 {
    public static final int BODY_FIELD_NUMBER = 1;
    private static final a DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER;
    private ByteString body_ = ByteString.b;

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        GeneratedMessageLite.C(a.class, aVar);
    }

    public static void D(a aVar) {
        aVar.getClass();
        aVar.body_ = DEFAULT_INSTANCE.body_;
    }

    public static void E(a aVar, ByteString byteString) {
        aVar.getClass();
        byteString.getClass();
        aVar.body_ = byteString;
    }

    public static ChatCompletionReq$Builder H() {
        return (ChatCompletionReq$Builder) DEFAULT_INSTANCE.p();
    }

    public final ByteString G() {
        return this.body_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\n", new Object[]{"body_"});
            case 3:
                return new a();
            case 4:
                return new ChatCompletionReq$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (a.class) {
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
