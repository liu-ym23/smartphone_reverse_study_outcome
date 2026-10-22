package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.HandoffPreHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* renamed from: q7.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1815m extends GeneratedMessageLite implements Y1 {
    public static final int CONTEXT_FIELD_NUMBER = 5;
    private static final C1815m DEFAULT_INSTANCE;
    public static final int FROM_AGENT_ID_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int REASON_FIELD_NUMBER = 3;
    public static final int SESSION_ID_FIELD_NUMBER = 4;
    public static final int TO_AGENT_ID_FIELD_NUMBER = 2;
    private MapFieldLite<String, String> context_ = MapFieldLite.b;
    private String fromAgentId_ = "";
    private String toAgentId_ = "";
    private String reason_ = "";
    private String sessionId_ = "";

    static {
        C1815m c1815m = new C1815m();
        DEFAULT_INSTANCE = c1815m;
        GeneratedMessageLite.C(C1815m.class, c1815m);
    }

    public static void D(C1815m c1815m) {
        c1815m.getClass();
        c1815m.fromAgentId_ = DEFAULT_INSTANCE.fromAgentId_;
    }

    public static void E(C1815m c1815m) {
        c1815m.getClass();
        c1815m.reason_ = DEFAULT_INSTANCE.reason_;
    }

    public static void F(C1815m c1815m) {
        c1815m.getClass();
        c1815m.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void G(C1815m c1815m) {
        c1815m.getClass();
        c1815m.toAgentId_ = DEFAULT_INSTANCE.toAgentId_;
    }

    public static MapFieldLite H(C1815m c1815m) {
        MapFieldLite<String, String> mapFieldLite = c1815m.context_;
        if (!mapFieldLite.f2856a) {
            c1815m.context_ = mapFieldLite.h();
        }
        return c1815m.context_;
    }

    public static void I(C1815m c1815m, String str) {
        c1815m.getClass();
        str.getClass();
        c1815m.fromAgentId_ = str;
    }

    public static void J(C1815m c1815m, ByteString byteString) {
        c1815m.getClass();
        AbstractC0932e.g(byteString);
        c1815m.fromAgentId_ = byteString.q();
    }

    public static void K(C1815m c1815m, String str) {
        c1815m.getClass();
        str.getClass();
        c1815m.reason_ = str;
    }

    public static void L(C1815m c1815m, ByteString byteString) {
        c1815m.getClass();
        AbstractC0932e.g(byteString);
        c1815m.reason_ = byteString.q();
    }

    public static void M(C1815m c1815m, String str) {
        c1815m.getClass();
        str.getClass();
        c1815m.sessionId_ = str;
    }

    public static void N(C1815m c1815m, ByteString byteString) {
        c1815m.getClass();
        AbstractC0932e.g(byteString);
        c1815m.sessionId_ = byteString.q();
    }

    public static void O(C1815m c1815m, String str) {
        c1815m.getClass();
        str.getClass();
        c1815m.toAgentId_ = str;
    }

    public static void P(C1815m c1815m, ByteString byteString) {
        c1815m.getClass();
        AbstractC0932e.g(byteString);
        c1815m.toAgentId_ = byteString.q();
    }

    public static C1815m S() {
        return DEFAULT_INSTANCE;
    }

    public static HandoffPreHookData$Builder b0(C1815m c1815m) {
        return (HandoffPreHookData$Builder) DEFAULT_INSTANCE.q(c1815m);
    }

    public final Map R() {
        return Collections.unmodifiableMap(this.context_);
    }

    public final String T() {
        return this.fromAgentId_;
    }

    public final ByteString U() {
        return ByteString.f(this.fromAgentId_);
    }

    public final String V() {
        return this.reason_;
    }

    public final ByteString W() {
        return ByteString.f(this.reason_);
    }

    public final String X() {
        return this.sessionId_;
    }

    public final ByteString Y() {
        return ByteString.f(this.sessionId_);
    }

    public final String Z() {
        return this.toAgentId_;
    }

    public final ByteString a0() {
        return ByteString.f(this.toAgentId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u00052", new Object[]{"fromAgentId_", "toAgentId_", "reason_", "sessionId_", "context_", AbstractC1814l.f5592a});
            case 3:
                return new C1815m();
            case 4:
                return new HandoffPreHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1815m.class) {
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
