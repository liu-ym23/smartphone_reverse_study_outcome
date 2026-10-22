package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.HookResult$Builder;
import com.zyql.protobuf.common.PostToolCallMode;
import com.zyql.protobuf.common.PreToolCallMode;
import java.util.Collections;
import java.util.Map;

/* renamed from: q7.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1821t extends GeneratedMessageLite implements Y1 {
    public static final int BLOCK_REASON_FIELD_NUMBER = 5;
    public static final int CONTINUE_EXECUTION_FIELD_NUMBER = 4;
    private static final C1821t DEFAULT_INSTANCE;
    public static final int DURATION_MS_FIELD_NUMBER = 8;
    public static final int ERROR_FIELD_NUMBER = 9;
    public static final int HOOK_ID_FIELD_NUMBER = 2;
    public static final int INVOCATION_ID_FIELD_NUMBER = 1;
    public static final int METADATA_FIELD_NUMBER = 10;
    public static final int MODIFIED_DATA_FIELD_NUMBER = 7;
    public static final int MODIFIED_FIELD_NUMBER = 6;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int POST_MODE_FIELD_NUMBER = 12;
    public static final int PRE_MODE_FIELD_NUMBER = 11;
    public static final int REASON_FIELD_NUMBER = 13;
    public static final int SUCCESS_FIELD_NUMBER = 3;
    private boolean continueExecution_;
    private long durationMs_;
    private boolean modified_;
    private int postMode_;
    private int preMode_;
    private boolean success_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String invocationId_ = "";
    private String hookId_ = "";
    private String blockReason_ = "";
    private String reason_ = "";
    private ByteString modifiedData_ = ByteString.b;
    private String error_ = "";

    static {
        C1821t c1821t = new C1821t();
        DEFAULT_INSTANCE = c1821t;
        GeneratedMessageLite.C(C1821t.class, c1821t);
    }

    public static void D(C1821t c1821t) {
        c1821t.getClass();
        c1821t.blockReason_ = DEFAULT_INSTANCE.blockReason_;
    }

    public static void E(C1821t c1821t) {
        c1821t.continueExecution_ = false;
    }

    public static void F(C1821t c1821t) {
        c1821t.durationMs_ = 0L;
    }

    public static void G(C1821t c1821t) {
        c1821t.getClass();
        c1821t.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void H(C1821t c1821t) {
        c1821t.getClass();
        c1821t.hookId_ = DEFAULT_INSTANCE.hookId_;
    }

    public static void I(C1821t c1821t) {
        c1821t.getClass();
        c1821t.invocationId_ = DEFAULT_INSTANCE.invocationId_;
    }

    public static void J(C1821t c1821t) {
        c1821t.modified_ = false;
    }

    public static void K(C1821t c1821t) {
        c1821t.getClass();
        c1821t.modifiedData_ = DEFAULT_INSTANCE.modifiedData_;
    }

    public static void L(C1821t c1821t) {
        c1821t.postMode_ = 0;
    }

    public static void M(C1821t c1821t) {
        c1821t.preMode_ = 0;
    }

    public static void N(C1821t c1821t) {
        c1821t.getClass();
        c1821t.reason_ = DEFAULT_INSTANCE.reason_;
    }

    public static void O(C1821t c1821t) {
        c1821t.success_ = false;
    }

    public static MapFieldLite P(C1821t c1821t) {
        MapFieldLite<String, String> mapFieldLite = c1821t.metadata_;
        if (!mapFieldLite.f2856a) {
            c1821t.metadata_ = mapFieldLite.h();
        }
        return c1821t.metadata_;
    }

    public static void Q(C1821t c1821t, String str) {
        c1821t.getClass();
        str.getClass();
        c1821t.blockReason_ = str;
    }

    public static void R(C1821t c1821t, ByteString byteString) {
        c1821t.getClass();
        AbstractC0932e.g(byteString);
        c1821t.blockReason_ = byteString.q();
    }

    public static void S(C1821t c1821t, boolean z10) {
        c1821t.continueExecution_ = z10;
    }

    public static void T(C1821t c1821t, long j5) {
        c1821t.durationMs_ = j5;
    }

    public static void U(C1821t c1821t, String str) {
        c1821t.getClass();
        str.getClass();
        c1821t.error_ = str;
    }

    public static void V(C1821t c1821t, ByteString byteString) {
        c1821t.getClass();
        AbstractC0932e.g(byteString);
        c1821t.error_ = byteString.q();
    }

    public static void W(C1821t c1821t, String str) {
        c1821t.getClass();
        str.getClass();
        c1821t.hookId_ = str;
    }

    public static void X(C1821t c1821t, ByteString byteString) {
        c1821t.getClass();
        AbstractC0932e.g(byteString);
        c1821t.hookId_ = byteString.q();
    }

    public static void Y(C1821t c1821t, String str) {
        c1821t.getClass();
        str.getClass();
        c1821t.invocationId_ = str;
    }

    public static void Z(C1821t c1821t, ByteString byteString) {
        c1821t.getClass();
        AbstractC0932e.g(byteString);
        c1821t.invocationId_ = byteString.q();
    }

    public static void a0(C1821t c1821t, boolean z10) {
        c1821t.modified_ = z10;
    }

    public static void b0(C1821t c1821t, ByteString byteString) {
        c1821t.getClass();
        byteString.getClass();
        c1821t.modifiedData_ = byteString;
    }

    public static void c0(C1821t c1821t, PostToolCallMode postToolCallMode) {
        c1821t.getClass();
        c1821t.postMode_ = postToolCallMode.getNumber();
    }

    public static void d0(C1821t c1821t, int i) {
        c1821t.postMode_ = i;
    }

    public static void e0(C1821t c1821t, PreToolCallMode preToolCallMode) {
        c1821t.getClass();
        c1821t.preMode_ = preToolCallMode.getNumber();
    }

    public static void f0(C1821t c1821t, int i) {
        c1821t.preMode_ = i;
    }

    public static void g0(C1821t c1821t, String str) {
        c1821t.getClass();
        str.getClass();
        c1821t.reason_ = str;
    }

    public static void h0(C1821t c1821t, ByteString byteString) {
        c1821t.getClass();
        AbstractC0932e.g(byteString);
        c1821t.reason_ = byteString.q();
    }

    public static void i0(C1821t c1821t, boolean z10) {
        c1821t.success_ = z10;
    }

    public final int A0() {
        return this.preMode_;
    }

    public final String B0() {
        return this.reason_;
    }

    public final ByteString C0() {
        return ByteString.f(this.reason_);
    }

    public final boolean D0() {
        return this.success_;
    }

    public final String k0() {
        return this.blockReason_;
    }

    public final ByteString l0() {
        return ByteString.f(this.blockReason_);
    }

    public final boolean m0() {
        return this.continueExecution_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\r\u0000\u0000\u0001\r\r\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004\u0007\u0005Ȉ\u0006\u0007\u0007\n\b\u0002\tȈ\n2\u000b\f\f\f\rȈ", new Object[]{"invocationId_", "hookId_", "success_", "continueExecution_", "blockReason_", "modified_", "modifiedData_", "durationMs_", "error_", "metadata_", AbstractC1820s.f5595a, "preMode_", "postMode_", "reason_"});
            case 3:
                return new C1821t();
            case 4:
                return new HookResult$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1821t.class) {
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
        return this.invocationId_;
    }

    public final ByteString t0() {
        return ByteString.f(this.invocationId_);
    }

    public final Map u0() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final boolean v0() {
        return this.modified_;
    }

    public final ByteString w0() {
        return this.modifiedData_;
    }

    public final PostToolCallMode x0() {
        int i = this.postMode_;
        PostToolCallMode postToolCallMode = i != 0 ? i != 1 ? i != 2 ? null : PostToolCallMode.POST_TOOL_CALL_MODE_BLOCK : PostToolCallMode.POST_TOOL_CALL_MODE_IGNORE : PostToolCallMode.POST_TOOL_CALL_MODE_UNSPECIFIED;
        return postToolCallMode == null ? PostToolCallMode.UNRECOGNIZED : postToolCallMode;
    }

    public final int y0() {
        return this.postMode_;
    }

    public final PreToolCallMode z0() {
        int i = this.preMode_;
        PreToolCallMode preToolCallMode = i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : PreToolCallMode.PRE_TOOL_CALL_MODE_ASK : PreToolCallMode.PRE_TOOL_CALL_MODE_DENY : PreToolCallMode.PRE_TOOL_CALL_MODE_ALLOW : PreToolCallMode.PRE_TOOL_CALL_MODE_UNSPECIFIED;
        return preToolCallMode == null ? PreToolCallMode.UNRECOGNIZED : preToolCallMode;
    }
}
