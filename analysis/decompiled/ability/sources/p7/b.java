package p7;

import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.R0;
import com.google.protobuf.Y1;
import com.zyql.protobuf.client_agent.ChatCompletionResponse$Builder;

/* loaded from: classes2.dex */
public final class b extends GeneratedMessageLite implements Y1 {
    public static final int BODY_FIELD_NUMBER = 1;
    private static final b DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER;
    private ByteString body_ = ByteString.b;

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        GeneratedMessageLite.C(b.class, bVar);
    }

    public static void D(b bVar) {
        bVar.getClass();
        bVar.body_ = DEFAULT_INSTANCE.body_;
    }

    public static void E(b bVar, ByteString byteString) {
        bVar.getClass();
        byteString.getClass();
        bVar.body_ = byteString;
    }

    public static b H(byte[] bArr) throws InvalidProtocolBufferException {
        GeneratedMessageLite generatedMessageLiteB = GeneratedMessageLite.B(DEFAULT_INSTANCE, bArr, bArr.length, R0.a());
        GeneratedMessageLite.o(generatedMessageLiteB);
        return (b) generatedMessageLiteB;
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
                return new b();
            case 4:
                return new ChatCompletionResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (b.class) {
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
