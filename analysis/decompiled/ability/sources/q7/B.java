package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.MessagePreHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class B extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 2;
    public static final int CONTENT_FIELD_NUMBER = 4;
    private static final B DEFAULT_INSTANCE;
    public static final int METADATA_FIELD_NUMBER = 5;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int ROLE_FIELD_NUMBER = 3;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String sessionId_ = "";
    private String agentId_ = "";
    private String role_ = "";
    private String content_ = "";

    static {
        B b = new B();
        DEFAULT_INSTANCE = b;
        GeneratedMessageLite.C(B.class, b);
    }

    public static void D(B b) {
        b.getClass();
        b.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(B b) {
        b.getClass();
        b.content_ = DEFAULT_INSTANCE.content_;
    }

    public static void F(B b) {
        b.getClass();
        b.role_ = DEFAULT_INSTANCE.role_;
    }

    public static void G(B b) {
        b.getClass();
        b.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static MapFieldLite H(B b) {
        MapFieldLite<String, String> mapFieldLite = b.metadata_;
        if (!mapFieldLite.f2856a) {
            b.metadata_ = mapFieldLite.h();
        }
        return b.metadata_;
    }

    public static void I(B b, String str) {
        b.getClass();
        str.getClass();
        b.agentId_ = str;
    }

    public static void J(B b, ByteString byteString) {
        b.getClass();
        AbstractC0932e.g(byteString);
        b.agentId_ = byteString.q();
    }

    public static void K(B b, String str) {
        b.getClass();
        str.getClass();
        b.content_ = str;
    }

    public static void L(B b, ByteString byteString) {
        b.getClass();
        AbstractC0932e.g(byteString);
        b.content_ = byteString.q();
    }

    public static void M(B b, String str) {
        b.getClass();
        str.getClass();
        b.role_ = str;
    }

    public static void N(B b, ByteString byteString) {
        b.getClass();
        AbstractC0932e.g(byteString);
        b.role_ = byteString.q();
    }

    public static void O(B b, String str) {
        b.getClass();
        str.getClass();
        b.sessionId_ = str;
    }

    public static void P(B b, ByteString byteString) {
        b.getClass();
        AbstractC0932e.g(byteString);
        b.sessionId_ = byteString.q();
    }

    public static B V() {
        return DEFAULT_INSTANCE;
    }

    public static MessagePreHookData$Builder b0(B b) {
        return (MessagePreHookData$Builder) DEFAULT_INSTANCE.q(b);
    }

    public final String R() {
        return this.agentId_;
    }

    public final ByteString S() {
        return ByteString.f(this.agentId_);
    }

    public final String T() {
        return this.content_;
    }

    public final ByteString U() {
        return ByteString.f(this.content_);
    }

    public final Map W() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final String X() {
        return this.role_;
    }

    public final ByteString Y() {
        return ByteString.f(this.role_);
    }

    public final String Z() {
        return this.sessionId_;
    }

    public final ByteString a0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u00052", new Object[]{"sessionId_", "agentId_", "role_", "content_", "metadata_", A.f5581a});
            case 3:
                return new B();
            case 4:
                return new MessagePreHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (B.class) {
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
