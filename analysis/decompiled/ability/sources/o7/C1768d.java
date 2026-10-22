package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.ChatMessage$Builder;

/* renamed from: o7.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1768d extends GeneratedMessageLite implements Y1 {
    public static final int CONTENT_FIELD_NUMBER = 2;
    private static final C1768d DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int ROLE_FIELD_NUMBER = 1;
    private int bitField0_;
    private String role_ = "";
    private String content_ = "";
    private String name_ = "";

    static {
        C1768d c1768d = new C1768d();
        DEFAULT_INSTANCE = c1768d;
        GeneratedMessageLite.C(C1768d.class, c1768d);
    }

    public static void D(C1768d c1768d) {
        c1768d.getClass();
        c1768d.content_ = DEFAULT_INSTANCE.content_;
    }

    public static void E(C1768d c1768d) {
        c1768d.bitField0_ &= -2;
        c1768d.name_ = DEFAULT_INSTANCE.name_;
    }

    public static void F(C1768d c1768d) {
        c1768d.getClass();
        c1768d.role_ = DEFAULT_INSTANCE.role_;
    }

    public static void G(C1768d c1768d, String str) {
        c1768d.getClass();
        str.getClass();
        c1768d.content_ = str;
    }

    public static void H(C1768d c1768d, ByteString byteString) {
        c1768d.getClass();
        AbstractC0932e.g(byteString);
        c1768d.content_ = byteString.q();
    }

    public static void I(C1768d c1768d, String str) {
        c1768d.getClass();
        str.getClass();
        c1768d.bitField0_ |= 1;
        c1768d.name_ = str;
    }

    public static void J(C1768d c1768d, ByteString byteString) {
        c1768d.getClass();
        AbstractC0932e.g(byteString);
        c1768d.name_ = byteString.q();
        c1768d.bitField0_ |= 1;
    }

    public static void K(C1768d c1768d, String str) {
        c1768d.getClass();
        str.getClass();
        c1768d.role_ = str;
    }

    public static void L(C1768d c1768d, ByteString byteString) {
        c1768d.getClass();
        AbstractC0932e.g(byteString);
        c1768d.role_ = byteString.q();
    }

    public static C1768d P() {
        return DEFAULT_INSTANCE;
    }

    public static ChatMessage$Builder V(C1768d c1768d) {
        return (ChatMessage$Builder) DEFAULT_INSTANCE.q(c1768d);
    }

    public final String N() {
        return this.content_;
    }

    public final ByteString O() {
        return ByteString.f(this.content_);
    }

    public final String Q() {
        return this.name_;
    }

    public final ByteString R() {
        return ByteString.f(this.name_);
    }

    public final String S() {
        return this.role_;
    }

    public final ByteString T() {
        return ByteString.f(this.role_);
    }

    public final boolean U() {
        return (this.bitField0_ & 1) != 0;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ለ\u0000", new Object[]{"bitField0_", "role_", "content_", "name_"});
            case 3:
                return new C1768d();
            case 4:
                return new ChatMessage$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1768d.class) {
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
