package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.SessionStartHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class M extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 4;
    public static final int APP_ID_FIELD_NUMBER = 2;
    public static final int CREATED_AT_FIELD_NUMBER = 5;
    private static final M DEFAULT_INSTANCE;
    public static final int METADATA_FIELD_NUMBER = 6;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int USER_ID_FIELD_NUMBER = 3;
    private long createdAt_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String sessionId_ = "";
    private String appId_ = "";
    private String userId_ = "";
    private String agentId_ = "";

    static {
        M m = new M();
        DEFAULT_INSTANCE = m;
        GeneratedMessageLite.C(M.class, m);
    }

    public static void D(M m) {
        m.getClass();
        m.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(M m) {
        m.getClass();
        m.appId_ = DEFAULT_INSTANCE.appId_;
    }

    public static void F(M m) {
        m.createdAt_ = 0L;
    }

    public static void G(M m) {
        m.getClass();
        m.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void H(M m) {
        m.getClass();
        m.userId_ = DEFAULT_INSTANCE.userId_;
    }

    public static MapFieldLite I(M m) {
        MapFieldLite<String, String> mapFieldLite = m.metadata_;
        if (!mapFieldLite.f2856a) {
            m.metadata_ = mapFieldLite.h();
        }
        return m.metadata_;
    }

    public static void J(M m, String str) {
        m.getClass();
        str.getClass();
        m.agentId_ = str;
    }

    public static void K(M m, ByteString byteString) {
        m.getClass();
        AbstractC0932e.g(byteString);
        m.agentId_ = byteString.q();
    }

    public static void L(M m, String str) {
        m.getClass();
        str.getClass();
        m.appId_ = str;
    }

    public static void M(M m, ByteString byteString) {
        m.getClass();
        AbstractC0932e.g(byteString);
        m.appId_ = byteString.q();
    }

    public static void N(M m, long j5) {
        m.createdAt_ = j5;
    }

    public static void O(M m, String str) {
        m.getClass();
        str.getClass();
        m.sessionId_ = str;
    }

    public static void P(M m, ByteString byteString) {
        m.getClass();
        AbstractC0932e.g(byteString);
        m.sessionId_ = byteString.q();
    }

    public static void Q(M m, String str) {
        m.getClass();
        str.getClass();
        m.userId_ = str;
    }

    public static void R(M m, ByteString byteString) {
        m.getClass();
        AbstractC0932e.g(byteString);
        m.userId_ = byteString.q();
    }

    public static M Y() {
        return DEFAULT_INSTANCE;
    }

    public static SessionStartHookData$Builder e0(M m) {
        return (SessionStartHookData$Builder) DEFAULT_INSTANCE.q(m);
    }

    public final String T() {
        return this.agentId_;
    }

    public final ByteString U() {
        return ByteString.f(this.agentId_);
    }

    public final String V() {
        return this.appId_;
    }

    public final ByteString W() {
        return ByteString.f(this.appId_);
    }

    public final long X() {
        return this.createdAt_;
    }

    public final Map Z() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final String a0() {
        return this.sessionId_;
    }

    public final ByteString b0() {
        return ByteString.f(this.sessionId_);
    }

    public final String c0() {
        return this.userId_;
    }

    public final ByteString d0() {
        return ByteString.f(this.userId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0002\u00062", new Object[]{"sessionId_", "appId_", "userId_", "agentId_", "createdAt_", "metadata_", L.f5585a});
            case 3:
                return new M();
            case 4:
                return new SessionStartHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (M.class) {
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
