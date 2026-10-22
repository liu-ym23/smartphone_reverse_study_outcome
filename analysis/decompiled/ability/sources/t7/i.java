package t7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.omni.Error$Builder;

/* loaded from: classes2.dex */
public final class i extends GeneratedMessageLite implements Y1 {
    private static final i DEFAULT_INSTANCE;
    public static final int ERROR_CODE_FIELD_NUMBER = 1;
    public static final int ERROR_MSG_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER;
    private long errorCode_;
    private String errorMsg_ = "";

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        GeneratedMessageLite.C(i.class, iVar);
    }

    public static void D(i iVar) {
        iVar.errorCode_ = 0L;
    }

    public static void E(i iVar) {
        iVar.getClass();
        iVar.errorMsg_ = DEFAULT_INSTANCE.errorMsg_;
    }

    public static void F(i iVar, long j5) {
        iVar.errorCode_ = j5;
    }

    public static void G(i iVar, String str) {
        iVar.getClass();
        str.getClass();
        iVar.errorMsg_ = str;
    }

    public static void H(i iVar, ByteString byteString) {
        iVar.getClass();
        AbstractC0932e.g(byteString);
        iVar.errorMsg_ = byteString.q();
    }

    public static i J() {
        return DEFAULT_INSTANCE;
    }

    public static Error$Builder N(i iVar) {
        return (Error$Builder) DEFAULT_INSTANCE.q(iVar);
    }

    public final long K() {
        return this.errorCode_;
    }

    public final String L() {
        return this.errorMsg_;
    }

    public final ByteString M() {
        return ByteString.f(this.errorMsg_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002Ȉ", new Object[]{"errorCode_", "errorMsg_"});
            case 3:
                return new i();
            case 4:
                return new Error$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (i.class) {
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
