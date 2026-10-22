package u7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.runtime.TaskError$Builder;

/* loaded from: classes2.dex */
public final class s extends GeneratedMessageLite implements Y1 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final s DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER;
    private int code_;
    private String message_ = "";

    static {
        s sVar = new s();
        DEFAULT_INSTANCE = sVar;
        GeneratedMessageLite.C(s.class, sVar);
    }

    public static void D(s sVar) {
        sVar.code_ = 0;
    }

    public static void E(s sVar) {
        sVar.getClass();
        sVar.message_ = DEFAULT_INSTANCE.message_;
    }

    public static void F(s sVar, int i) {
        sVar.code_ = i;
    }

    public static void G(s sVar, String str) {
        sVar.getClass();
        str.getClass();
        sVar.message_ = str;
    }

    public static void H(s sVar, ByteString byteString) {
        sVar.getClass();
        AbstractC0932e.g(byteString);
        sVar.message_ = byteString.q();
    }

    public static s K() {
        return DEFAULT_INSTANCE;
    }

    public static TaskError$Builder N(s sVar) {
        return (TaskError$Builder) DEFAULT_INSTANCE.q(sVar);
    }

    public final int J() {
        return this.code_;
    }

    public final String L() {
        return this.message_;
    }

    public final ByteString M() {
        return ByteString.f(this.message_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"code_", "message_"});
            case 3:
                return new s();
            case 4:
                return new TaskError$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (s.class) {
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
