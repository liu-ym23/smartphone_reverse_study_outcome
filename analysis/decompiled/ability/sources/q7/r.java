package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.HookInvocation$Builder;
import com.zyql.protobuf.common.HookPoint;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class r extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 7;
    private static final r DEFAULT_INSTANCE;
    public static final int HOOK_DATA_FIELD_NUMBER = 8;
    public static final int HOOK_ID_FIELD_NUMBER = 2;
    public static final int HOOK_POINT_FIELD_NUMBER = 3;
    public static final int INVOCATION_ID_FIELD_NUMBER = 1;
    public static final int METADATA_FIELD_NUMBER = 9;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int RUN_ID_FIELD_NUMBER = 6;
    public static final int SESSION_ID_FIELD_NUMBER = 5;
    public static final int TIMESTAMP_FIELD_NUMBER = 4;
    private int hookPoint_;
    private long timestamp_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String invocationId_ = "";
    private String hookId_ = "";
    private String sessionId_ = "";
    private String runId_ = "";
    private String agentId_ = "";
    private ByteString hookData_ = ByteString.b;

    static {
        r rVar = new r();
        DEFAULT_INSTANCE = rVar;
        GeneratedMessageLite.C(r.class, rVar);
    }

    public static void D(r rVar) {
        rVar.getClass();
        rVar.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(r rVar) {
        rVar.getClass();
        rVar.hookData_ = DEFAULT_INSTANCE.hookData_;
    }

    public static void F(r rVar) {
        rVar.getClass();
        rVar.hookId_ = DEFAULT_INSTANCE.hookId_;
    }

    public static void G(r rVar) {
        rVar.hookPoint_ = 0;
    }

    public static void H(r rVar) {
        rVar.getClass();
        rVar.invocationId_ = DEFAULT_INSTANCE.invocationId_;
    }

    public static void I(r rVar) {
        rVar.getClass();
        rVar.runId_ = DEFAULT_INSTANCE.runId_;
    }

    public static void J(r rVar) {
        rVar.getClass();
        rVar.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void K(r rVar) {
        rVar.timestamp_ = 0L;
    }

    public static MapFieldLite L(r rVar) {
        MapFieldLite<String, String> mapFieldLite = rVar.metadata_;
        if (!mapFieldLite.f2856a) {
            rVar.metadata_ = mapFieldLite.h();
        }
        return rVar.metadata_;
    }

    public static void M(r rVar, String str) {
        rVar.getClass();
        str.getClass();
        rVar.agentId_ = str;
    }

    public static void N(r rVar, ByteString byteString) {
        rVar.getClass();
        AbstractC0932e.g(byteString);
        rVar.agentId_ = byteString.q();
    }

    public static void O(r rVar, ByteString byteString) {
        rVar.getClass();
        byteString.getClass();
        rVar.hookData_ = byteString;
    }

    public static void P(r rVar, String str) {
        rVar.getClass();
        str.getClass();
        rVar.hookId_ = str;
    }

    public static void Q(r rVar, ByteString byteString) {
        rVar.getClass();
        AbstractC0932e.g(byteString);
        rVar.hookId_ = byteString.q();
    }

    public static void R(r rVar, HookPoint hookPoint) {
        rVar.getClass();
        rVar.hookPoint_ = hookPoint.getNumber();
    }

    public static void S(r rVar, int i) {
        rVar.hookPoint_ = i;
    }

    public static void T(r rVar, String str) {
        rVar.getClass();
        str.getClass();
        rVar.invocationId_ = str;
    }

    public static void U(r rVar, ByteString byteString) {
        rVar.getClass();
        AbstractC0932e.g(byteString);
        rVar.invocationId_ = byteString.q();
    }

    public static void V(r rVar, String str) {
        rVar.getClass();
        str.getClass();
        rVar.runId_ = str;
    }

    public static void W(r rVar, ByteString byteString) {
        rVar.getClass();
        AbstractC0932e.g(byteString);
        rVar.runId_ = byteString.q();
    }

    public static void X(r rVar, String str) {
        rVar.getClass();
        str.getClass();
        rVar.sessionId_ = str;
    }

    public static void Y(r rVar, ByteString byteString) {
        rVar.getClass();
        AbstractC0932e.g(byteString);
        rVar.sessionId_ = byteString.q();
    }

    public static void Z(r rVar, long j5) {
        rVar.timestamp_ = j5;
    }

    public final String b0() {
        return this.agentId_;
    }

    public final ByteString c0() {
        return ByteString.f(this.agentId_);
    }

    public final ByteString d0() {
        return this.hookData_;
    }

    public final String e0() {
        return this.hookId_;
    }

    public final ByteString f0() {
        return ByteString.f(this.hookId_);
    }

    public final HookPoint g0() {
        HookPoint hookPointA = HookPoint.a(this.hookPoint_);
        return hookPointA == null ? HookPoint.UNRECOGNIZED : hookPointA;
    }

    public final int h0() {
        return this.hookPoint_;
    }

    public final String i0() {
        return this.invocationId_;
    }

    public final ByteString j0() {
        return ByteString.f(this.invocationId_);
    }

    public final Map k0() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final String l0() {
        return this.runId_;
    }

    public final ByteString m0() {
        return ByteString.f(this.runId_);
    }

    public final String n0() {
        return this.sessionId_;
    }

    public final ByteString o0() {
        return ByteString.f(this.sessionId_);
    }

    public final long p0() {
        return this.timestamp_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004\u0002\u0005Ȉ\u0006Ȉ\u0007Ȉ\b\n\t2", new Object[]{"invocationId_", "hookId_", "hookPoint_", "timestamp_", "sessionId_", "runId_", "agentId_", "hookData_", "metadata_", AbstractC1819q.f5594a});
            case 3:
                return new r();
            case 4:
                return new HookInvocation$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (r.class) {
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
