package t7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.omni.MessageDelta$Builder;

/* loaded from: classes2.dex */
public final class j extends GeneratedMessageLite implements Y1 {
    private static final j DEFAULT_INSTANCE;
    public static final int IS_END_FIELD_NUMBER = 2;
    public static final int MESSAGE_ID_FIELD_NUMBER = 4;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int ROLE_FIELD_NUMBER = 3;
    public static final int TEXT_FIELD_NUMBER = 1;
    private boolean isEnd_;
    private String text_ = "";
    private String role_ = "";
    private String messageId_ = "";

    static {
        j jVar = new j();
        DEFAULT_INSTANCE = jVar;
        GeneratedMessageLite.C(j.class, jVar);
    }

    public static void D(j jVar) {
        jVar.isEnd_ = false;
    }

    public static void E(j jVar) {
        jVar.getClass();
        jVar.messageId_ = DEFAULT_INSTANCE.messageId_;
    }

    public static void F(j jVar) {
        jVar.getClass();
        jVar.role_ = DEFAULT_INSTANCE.role_;
    }

    public static void G(j jVar) {
        jVar.getClass();
        jVar.text_ = DEFAULT_INSTANCE.text_;
    }

    public static void H(j jVar, boolean z10) {
        jVar.isEnd_ = z10;
    }

    public static void I(j jVar, String str) {
        jVar.getClass();
        str.getClass();
        jVar.messageId_ = str;
    }

    public static void J(j jVar, ByteString byteString) {
        jVar.getClass();
        AbstractC0932e.g(byteString);
        jVar.messageId_ = byteString.q();
    }

    public static void K(j jVar, String str) {
        jVar.getClass();
        str.getClass();
        jVar.role_ = str;
    }

    public static void L(j jVar, ByteString byteString) {
        jVar.getClass();
        AbstractC0932e.g(byteString);
        jVar.role_ = byteString.q();
    }

    public static void M(j jVar, String str) {
        jVar.getClass();
        str.getClass();
        jVar.text_ = str;
    }

    public static void N(j jVar, ByteString byteString) {
        jVar.getClass();
        AbstractC0932e.g(byteString);
        jVar.text_ = byteString.q();
    }

    public static j P() {
        return DEFAULT_INSTANCE;
    }

    public static MessageDelta$Builder X(j jVar) {
        return (MessageDelta$Builder) DEFAULT_INSTANCE.q(jVar);
    }

    public final boolean Q() {
        return this.isEnd_;
    }

    public final String R() {
        return this.messageId_;
    }

    public final ByteString S() {
        return ByteString.f(this.messageId_);
    }

    public final String T() {
        return this.role_;
    }

    public final ByteString U() {
        return ByteString.f(this.role_);
    }

    public final String V() {
        return this.text_;
    }

    public final ByteString W() {
        return ByteString.f(this.text_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\u0007\u0003Ȉ\u0004Ȉ", new Object[]{"text_", "isEnd_", "role_", "messageId_"});
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
