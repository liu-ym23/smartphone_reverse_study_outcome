package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.MessagePostHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* renamed from: q7.z, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1827z extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 2;
    public static final int CONTENT_FIELD_NUMBER = 4;
    private static final C1827z DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 6;
    public static final int METADATA_FIELD_NUMBER = 7;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int ROLE_FIELD_NUMBER = 3;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    public static final int SUCCESS_FIELD_NUMBER = 5;
    private long durationMs_;
    private boolean success_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String sessionId_ = "";
    private String agentId_ = "";
    private String role_ = "";
    private String content_ = "";

    static {
        C1827z c1827z = new C1827z();
        DEFAULT_INSTANCE = c1827z;
        GeneratedMessageLite.C(C1827z.class, c1827z);
    }

    public static void D(C1827z c1827z) {
        c1827z.getClass();
        c1827z.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(C1827z c1827z) {
        c1827z.getClass();
        c1827z.content_ = DEFAULT_INSTANCE.content_;
    }

    public static void F(C1827z c1827z) {
        c1827z.durationMs_ = 0L;
    }

    public static void G(C1827z c1827z) {
        c1827z.getClass();
        c1827z.role_ = DEFAULT_INSTANCE.role_;
    }

    public static void H(C1827z c1827z) {
        c1827z.getClass();
        c1827z.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void I(C1827z c1827z) {
        c1827z.success_ = false;
    }

    public static MapFieldLite J(C1827z c1827z) {
        MapFieldLite<String, String> mapFieldLite = c1827z.metadata_;
        if (!mapFieldLite.f2856a) {
            c1827z.metadata_ = mapFieldLite.h();
        }
        return c1827z.metadata_;
    }

    public static void K(C1827z c1827z, String str) {
        c1827z.getClass();
        str.getClass();
        c1827z.agentId_ = str;
    }

    public static void L(C1827z c1827z, ByteString byteString) {
        c1827z.getClass();
        AbstractC0932e.g(byteString);
        c1827z.agentId_ = byteString.q();
    }

    public static void M(C1827z c1827z, String str) {
        c1827z.getClass();
        str.getClass();
        c1827z.content_ = str;
    }

    public static void N(C1827z c1827z, ByteString byteString) {
        c1827z.getClass();
        AbstractC0932e.g(byteString);
        c1827z.content_ = byteString.q();
    }

    public static void O(C1827z c1827z, long j5) {
        c1827z.durationMs_ = j5;
    }

    public static void P(C1827z c1827z, String str) {
        c1827z.getClass();
        str.getClass();
        c1827z.role_ = str;
    }

    public static void Q(C1827z c1827z, ByteString byteString) {
        c1827z.getClass();
        AbstractC0932e.g(byteString);
        c1827z.role_ = byteString.q();
    }

    public static void R(C1827z c1827z, String str) {
        c1827z.getClass();
        str.getClass();
        c1827z.sessionId_ = str;
    }

    public static void S(C1827z c1827z, ByteString byteString) {
        c1827z.getClass();
        AbstractC0932e.g(byteString);
        c1827z.sessionId_ = byteString.q();
    }

    public static void T(C1827z c1827z, boolean z10) {
        c1827z.success_ = z10;
    }

    public static C1827z Z() {
        return DEFAULT_INSTANCE;
    }

    public static MessagePostHookData$Builder h0(C1827z c1827z) {
        return (MessagePostHookData$Builder) DEFAULT_INSTANCE.q(c1827z);
    }

    public final String V() {
        return this.agentId_;
    }

    public final ByteString W() {
        return ByteString.f(this.agentId_);
    }

    public final String X() {
        return this.content_;
    }

    public final ByteString Y() {
        return ByteString.f(this.content_);
    }

    public final long a0() {
        return this.durationMs_;
    }

    public final Map b0() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final String c0() {
        return this.role_;
    }

    public final ByteString d0() {
        return ByteString.f(this.role_);
    }

    public final String e0() {
        return this.sessionId_;
    }

    public final ByteString f0() {
        return ByteString.f(this.sessionId_);
    }

    public final boolean g0() {
        return this.success_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0007\u0006\u0002\u00072", new Object[]{"sessionId_", "agentId_", "role_", "content_", "success_", "durationMs_", "metadata_", AbstractC1826y.f5596a});
            case 3:
                return new C1827z();
            case 4:
                return new MessagePostHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1827z.class) {
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
