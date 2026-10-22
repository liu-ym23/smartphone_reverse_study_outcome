package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.HookEvent$Builder;
import com.zyql.protobuf.common.HookPoint;
import java.util.Collections;
import java.util.Map;

/* renamed from: q7.p, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1818p extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 6;
    public static final int BLOCKED_EXECUTION_FIELD_NUMBER = 9;
    private static final C1818p DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 11;
    public static final int ERROR_FIELD_NUMBER = 12;
    public static final int HOOK_ID_FIELD_NUMBER = 1;
    public static final int HOOK_NAME_FIELD_NUMBER = 2;
    public static final int HOOK_POINT_FIELD_NUMBER = 3;
    public static final int INVOCATION_ID_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 13;
    public static final int MODIFIED_DATA_FIELD_NUMBER = 10;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 5;
    public static final int SUCCESS_FIELD_NUMBER = 8;
    public static final int TIMESTAMP_FIELD_NUMBER = 7;
    private boolean blockedExecution_;
    private long durationMs_;
    private int hookPoint_;
    private boolean modifiedData_;
    private boolean success_;
    private long timestamp_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String hookId_ = "";
    private String hookName_ = "";
    private String invocationId_ = "";
    private String sessionId_ = "";
    private String agentId_ = "";
    private String error_ = "";

    static {
        C1818p c1818p = new C1818p();
        DEFAULT_INSTANCE = c1818p;
        GeneratedMessageLite.C(C1818p.class, c1818p);
    }

    public static void D(C1818p c1818p) {
        c1818p.getClass();
        c1818p.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void E(C1818p c1818p) {
        c1818p.blockedExecution_ = false;
    }

    public static void F(C1818p c1818p) {
        c1818p.durationMs_ = 0L;
    }

    public static void G(C1818p c1818p) {
        c1818p.getClass();
        c1818p.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void H(C1818p c1818p) {
        c1818p.getClass();
        c1818p.hookId_ = DEFAULT_INSTANCE.hookId_;
    }

    public static void I(C1818p c1818p) {
        c1818p.getClass();
        c1818p.hookName_ = DEFAULT_INSTANCE.hookName_;
    }

    public static void J(C1818p c1818p) {
        c1818p.hookPoint_ = 0;
    }

    public static void K(C1818p c1818p) {
        c1818p.getClass();
        c1818p.invocationId_ = DEFAULT_INSTANCE.invocationId_;
    }

    public static void L(C1818p c1818p) {
        c1818p.modifiedData_ = false;
    }

    public static void M(C1818p c1818p) {
        c1818p.getClass();
        c1818p.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void N(C1818p c1818p) {
        c1818p.success_ = false;
    }

    public static void O(C1818p c1818p) {
        c1818p.timestamp_ = 0L;
    }

    public static MapFieldLite P(C1818p c1818p) {
        MapFieldLite<String, String> mapFieldLite = c1818p.metadata_;
        if (!mapFieldLite.f2856a) {
            c1818p.metadata_ = mapFieldLite.h();
        }
        return c1818p.metadata_;
    }

    public static void Q(C1818p c1818p, String str) {
        c1818p.getClass();
        str.getClass();
        c1818p.agentId_ = str;
    }

    public static void R(C1818p c1818p, ByteString byteString) {
        c1818p.getClass();
        AbstractC0932e.g(byteString);
        c1818p.agentId_ = byteString.q();
    }

    public static void S(C1818p c1818p, boolean z10) {
        c1818p.blockedExecution_ = z10;
    }

    public static void T(C1818p c1818p, long j5) {
        c1818p.durationMs_ = j5;
    }

    public static void U(C1818p c1818p, String str) {
        c1818p.getClass();
        str.getClass();
        c1818p.error_ = str;
    }

    public static void V(C1818p c1818p, ByteString byteString) {
        c1818p.getClass();
        AbstractC0932e.g(byteString);
        c1818p.error_ = byteString.q();
    }

    public static void W(C1818p c1818p, String str) {
        c1818p.getClass();
        str.getClass();
        c1818p.hookId_ = str;
    }

    public static void X(C1818p c1818p, ByteString byteString) {
        c1818p.getClass();
        AbstractC0932e.g(byteString);
        c1818p.hookId_ = byteString.q();
    }

    public static void Y(C1818p c1818p, String str) {
        c1818p.getClass();
        str.getClass();
        c1818p.hookName_ = str;
    }

    public static void Z(C1818p c1818p, ByteString byteString) {
        c1818p.getClass();
        AbstractC0932e.g(byteString);
        c1818p.hookName_ = byteString.q();
    }

    public static void a0(C1818p c1818p, HookPoint hookPoint) {
        c1818p.getClass();
        c1818p.hookPoint_ = hookPoint.getNumber();
    }

    public static void b0(C1818p c1818p, int i) {
        c1818p.hookPoint_ = i;
    }

    public static void c0(C1818p c1818p, String str) {
        c1818p.getClass();
        str.getClass();
        c1818p.invocationId_ = str;
    }

    public static void d0(C1818p c1818p, ByteString byteString) {
        c1818p.getClass();
        AbstractC0932e.g(byteString);
        c1818p.invocationId_ = byteString.q();
    }

    public static void e0(C1818p c1818p, boolean z10) {
        c1818p.modifiedData_ = z10;
    }

    public static void f0(C1818p c1818p, String str) {
        c1818p.getClass();
        str.getClass();
        c1818p.sessionId_ = str;
    }

    public static void g0(C1818p c1818p, ByteString byteString) {
        c1818p.getClass();
        AbstractC0932e.g(byteString);
        c1818p.sessionId_ = byteString.q();
    }

    public static void h0(C1818p c1818p, boolean z10) {
        c1818p.success_ = z10;
    }

    public static void i0(C1818p c1818p, long j5) {
        c1818p.timestamp_ = j5;
    }

    public final String A0() {
        return this.sessionId_;
    }

    public final ByteString B0() {
        return ByteString.f(this.sessionId_);
    }

    public final boolean C0() {
        return this.success_;
    }

    public final long D0() {
        return this.timestamp_;
    }

    public final String k0() {
        return this.agentId_;
    }

    public final ByteString l0() {
        return ByteString.f(this.agentId_);
    }

    public final boolean m0() {
        return this.blockedExecution_;
    }

    public final long n0() {
        return this.durationMs_;
    }

    public final String o0() {
        return this.error_;
    }

    public final ByteString p0() {
        return ByteString.f(this.error_);
    }

    public final String q0() {
        return this.hookId_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\r\u0000\u0000\u0001\r\r\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002\b\u0007\t\u0007\n\u0007\u000b\u0002\fȈ\r2", new Object[]{"hookId_", "hookName_", "hookPoint_", "invocationId_", "sessionId_", "agentId_", "timestamp_", "success_", "blockedExecution_", "modifiedData_", "durationMs_", "error_", "metadata_", AbstractC1817o.f5593a});
            case 3:
                return new C1818p();
            case 4:
                return new HookEvent$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1818p.class) {
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

    public final ByteString r0() {
        return ByteString.f(this.hookId_);
    }

    public final String s0() {
        return this.hookName_;
    }

    public final ByteString t0() {
        return ByteString.f(this.hookName_);
    }

    public final HookPoint u0() {
        HookPoint hookPointA = HookPoint.a(this.hookPoint_);
        return hookPointA == null ? HookPoint.UNRECOGNIZED : hookPointA;
    }

    public final int v0() {
        return this.hookPoint_;
    }

    public final String w0() {
        return this.invocationId_;
    }

    public final ByteString x0() {
        return ByteString.f(this.invocationId_);
    }

    public final Map y0() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final boolean z0() {
        return this.modifiedData_;
    }
}
