package w7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.task.engine.InvokeReq$Builder;

/* renamed from: w7.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2105a extends GeneratedMessageLite implements Y1 {
    public static final int BODY_FIELD_NUMBER = 4;
    public static final int COMMAND_FIELD_NUMBER = 2;
    private static final C2105a DEFAULT_INSTANCE;
    public static final int MODULE_FIELD_NUMBER = 1;
    public static final int MSGID_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER;
    private String module_ = "";
    private String command_ = "";
    private String msgId_ = "";
    private ByteString body_ = ByteString.b;

    static {
        C2105a c2105a = new C2105a();
        DEFAULT_INSTANCE = c2105a;
        GeneratedMessageLite.C(C2105a.class, c2105a);
    }

    public static void D(C2105a c2105a) {
        c2105a.getClass();
        c2105a.body_ = DEFAULT_INSTANCE.body_;
    }

    public static void E(C2105a c2105a) {
        c2105a.getClass();
        c2105a.command_ = DEFAULT_INSTANCE.command_;
    }

    public static void F(C2105a c2105a) {
        c2105a.getClass();
        c2105a.module_ = DEFAULT_INSTANCE.module_;
    }

    public static void G(C2105a c2105a) {
        c2105a.getClass();
        c2105a.msgId_ = DEFAULT_INSTANCE.msgId_;
    }

    public static void H(C2105a c2105a, ByteString byteString) {
        c2105a.getClass();
        byteString.getClass();
        c2105a.body_ = byteString;
    }

    public static void I(C2105a c2105a, String str) {
        c2105a.getClass();
        str.getClass();
        c2105a.command_ = str;
    }

    public static void J(C2105a c2105a, ByteString byteString) {
        c2105a.getClass();
        AbstractC0932e.g(byteString);
        c2105a.command_ = byteString.q();
    }

    public static void K(C2105a c2105a, String str) {
        c2105a.getClass();
        str.getClass();
        c2105a.module_ = str;
    }

    public static void L(C2105a c2105a, ByteString byteString) {
        c2105a.getClass();
        AbstractC0932e.g(byteString);
        c2105a.module_ = byteString.q();
    }

    public static void M(C2105a c2105a, String str) {
        c2105a.getClass();
        str.getClass();
        c2105a.msgId_ = str;
    }

    public static void N(C2105a c2105a, ByteString byteString) {
        c2105a.getClass();
        AbstractC0932e.g(byteString);
        c2105a.msgId_ = byteString.q();
    }

    public static InvokeReq$Builder W() {
        return (InvokeReq$Builder) DEFAULT_INSTANCE.p();
    }

    public final ByteString P() {
        return this.body_;
    }

    public final String Q() {
        return this.command_;
    }

    public final ByteString R() {
        return ByteString.f(this.command_);
    }

    public final String S() {
        return this.module_;
    }

    public final ByteString T() {
        return ByteString.f(this.module_);
    }

    public final String U() {
        return this.msgId_;
    }

    public final ByteString V() {
        return ByteString.f(this.msgId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\n", new Object[]{"module_", "command_", "msgId_", "body_"});
            case 3:
                return new C2105a();
            case 4:
                return new InvokeReq$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C2105a.class) {
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
