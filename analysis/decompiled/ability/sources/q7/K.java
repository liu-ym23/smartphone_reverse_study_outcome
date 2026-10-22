package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.SessionEndHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class K extends GeneratedMessageLite implements Y1 {
    private static final K DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 4;
    public static final int MESSAGE_COUNT_FIELD_NUMBER = 3;
    public static final int METADATA_FIELD_NUMBER = 5;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 2;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private long durationMs_;
    private int messageCount_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String sessionId_ = "";
    private String reason_ = "";

    static {
        K k = new K();
        DEFAULT_INSTANCE = k;
        GeneratedMessageLite.C(K.class, k);
    }

    public static void D(K k) {
        k.durationMs_ = 0L;
    }

    public static void E(K k) {
        k.messageCount_ = 0;
    }

    public static void F(K k) {
        k.getClass();
        k.reason_ = DEFAULT_INSTANCE.reason_;
    }

    public static void G(K k) {
        k.getClass();
        k.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static MapFieldLite H(K k) {
        MapFieldLite<String, String> mapFieldLite = k.metadata_;
        if (!mapFieldLite.f2856a) {
            k.metadata_ = mapFieldLite.h();
        }
        return k.metadata_;
    }

    public static void I(K k, long j5) {
        k.durationMs_ = j5;
    }

    public static void J(K k, int i) {
        k.messageCount_ = i;
    }

    public static void K(K k, String str) {
        k.getClass();
        str.getClass();
        k.reason_ = str;
    }

    public static void L(K k, ByteString byteString) {
        k.getClass();
        AbstractC0932e.g(byteString);
        k.reason_ = byteString.q();
    }

    public static void M(K k, String str) {
        k.getClass();
        str.getClass();
        k.sessionId_ = str;
    }

    public static void N(K k, ByteString byteString) {
        k.getClass();
        AbstractC0932e.g(byteString);
        k.sessionId_ = byteString.q();
    }

    public static K P() {
        return DEFAULT_INSTANCE;
    }

    public static SessionEndHookData$Builder X(K k) {
        return (SessionEndHookData$Builder) DEFAULT_INSTANCE.q(k);
    }

    public final long Q() {
        return this.durationMs_;
    }

    public final int R() {
        return this.messageCount_;
    }

    public final Map S() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final String T() {
        return this.reason_;
    }

    public final ByteString U() {
        return ByteString.f(this.reason_);
    }

    public final String V() {
        return this.sessionId_;
    }

    public final ByteString W() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004\u0002\u00052", new Object[]{"sessionId_", "reason_", "messageCount_", "durationMs_", "metadata_", J.f5584a});
            case 3:
                return new K();
            case 4:
                return new SessionEndHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (K.class) {
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
