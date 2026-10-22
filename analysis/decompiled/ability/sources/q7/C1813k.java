package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.HandoffPostHookData$Builder;
import java.util.Collections;
import java.util.Map;

/* renamed from: q7.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1813k extends GeneratedMessageLite implements Y1 {
    private static final C1813k DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 5;
    public static final int FROM_AGENT_ID_FIELD_NUMBER = 1;
    public static final int METADATA_FIELD_NUMBER = 6;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 4;
    public static final int SUCCESS_FIELD_NUMBER = 3;
    public static final int TO_AGENT_ID_FIELD_NUMBER = 2;
    private long durationMs_;
    private boolean success_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String fromAgentId_ = "";
    private String toAgentId_ = "";
    private String sessionId_ = "";

    static {
        C1813k c1813k = new C1813k();
        DEFAULT_INSTANCE = c1813k;
        GeneratedMessageLite.C(C1813k.class, c1813k);
    }

    public static void D(C1813k c1813k) {
        c1813k.durationMs_ = 0L;
    }

    public static void E(C1813k c1813k) {
        c1813k.getClass();
        c1813k.fromAgentId_ = DEFAULT_INSTANCE.fromAgentId_;
    }

    public static void F(C1813k c1813k) {
        c1813k.getClass();
        c1813k.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void G(C1813k c1813k) {
        c1813k.success_ = false;
    }

    public static void H(C1813k c1813k) {
        c1813k.getClass();
        c1813k.toAgentId_ = DEFAULT_INSTANCE.toAgentId_;
    }

    public static MapFieldLite I(C1813k c1813k) {
        MapFieldLite<String, String> mapFieldLite = c1813k.metadata_;
        if (!mapFieldLite.f2856a) {
            c1813k.metadata_ = mapFieldLite.h();
        }
        return c1813k.metadata_;
    }

    public static void J(C1813k c1813k, long j5) {
        c1813k.durationMs_ = j5;
    }

    public static void K(C1813k c1813k, String str) {
        c1813k.getClass();
        str.getClass();
        c1813k.fromAgentId_ = str;
    }

    public static void L(C1813k c1813k, ByteString byteString) {
        c1813k.getClass();
        AbstractC0932e.g(byteString);
        c1813k.fromAgentId_ = byteString.q();
    }

    public static void M(C1813k c1813k, String str) {
        c1813k.getClass();
        str.getClass();
        c1813k.sessionId_ = str;
    }

    public static void N(C1813k c1813k, ByteString byteString) {
        c1813k.getClass();
        AbstractC0932e.g(byteString);
        c1813k.sessionId_ = byteString.q();
    }

    public static void O(C1813k c1813k, boolean z10) {
        c1813k.success_ = z10;
    }

    public static void P(C1813k c1813k, String str) {
        c1813k.getClass();
        str.getClass();
        c1813k.toAgentId_ = str;
    }

    public static void Q(C1813k c1813k, ByteString byteString) {
        c1813k.getClass();
        AbstractC0932e.g(byteString);
        c1813k.toAgentId_ = byteString.q();
    }

    public static C1813k S() {
        return DEFAULT_INSTANCE;
    }

    public static HandoffPostHookData$Builder c0(C1813k c1813k) {
        return (HandoffPostHookData$Builder) DEFAULT_INSTANCE.q(c1813k);
    }

    public final long T() {
        return this.durationMs_;
    }

    public final String U() {
        return this.fromAgentId_;
    }

    public final ByteString V() {
        return ByteString.f(this.fromAgentId_);
    }

    public final Map W() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final String X() {
        return this.sessionId_;
    }

    public final ByteString Y() {
        return ByteString.f(this.sessionId_);
    }

    public final boolean Z() {
        return this.success_;
    }

    public final String a0() {
        return this.toAgentId_;
    }

    public final ByteString b0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0002\u00062", new Object[]{"fromAgentId_", "toAgentId_", "success_", "sessionId_", "durationMs_", "metadata_", AbstractC1812j.f5591a});
            case 3:
                return new C1813k();
            case 4:
                return new HandoffPostHookData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1813k.class) {
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
