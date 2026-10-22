package r7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.connection.ErrorResp$Builder;

/* loaded from: classes2.dex */
public final class d extends GeneratedMessageLite implements Y1 {
    public static final int CODE_FIELD_NUMBER = 1;
    private static final d DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    private int code_;
    private String reason_ = "";

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        GeneratedMessageLite.C(d.class, dVar);
    }

    public static void D(d dVar) {
        dVar.code_ = 0;
    }

    public static void E(d dVar) {
        dVar.getClass();
        dVar.reason_ = DEFAULT_INSTANCE.reason_;
    }

    public static void F(d dVar, int i) {
        dVar.code_ = i;
    }

    public static void G(d dVar, String str) {
        dVar.getClass();
        str.getClass();
        dVar.reason_ = str;
    }

    public static void H(d dVar, ByteString byteString) {
        dVar.getClass();
        AbstractC0932e.g(byteString);
        dVar.reason_ = byteString.q();
    }

    public final int J() {
        return this.code_;
    }

    public final String K() {
        return this.reason_;
    }

    public final ByteString L() {
        return ByteString.f(this.reason_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0002Ȉ", new Object[]{"code_", "reason_"});
            case 3:
                return new d();
            case 4:
                return new ErrorResp$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (d.class) {
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
