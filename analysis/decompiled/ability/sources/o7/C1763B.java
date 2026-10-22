package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.ToolExecutionResult$Builder;
import java.util.Collections;
import java.util.Map;

/* renamed from: o7.B, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1763B extends GeneratedMessageLite implements Y1 {
    public static final int CONTENT_TYPE_FIELD_NUMBER = 6;
    private static final C1763B DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 5;
    public static final int METADATA_FIELD_NUMBER = 7;
    public static final int OUTPUT_FIELD_NUMBER = 4;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 3;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    public static final int TOOL_CALL_ID_FIELD_NUMBER = 2;
    private boolean success_;
    private MapFieldLite<String, String> metadata_ = MapFieldLite.b;
    private String taskId_ = "";
    private String toolCallId_ = "";
    private String output_ = "";
    private String error_ = "";
    private String contentType_ = "";

    static {
        C1763B c1763b = new C1763B();
        DEFAULT_INSTANCE = c1763b;
        GeneratedMessageLite.C(C1763B.class, c1763b);
    }

    public static void D(C1763B c1763b) {
        c1763b.getClass();
        c1763b.contentType_ = DEFAULT_INSTANCE.contentType_;
    }

    public static void E(C1763B c1763b) {
        c1763b.getClass();
        c1763b.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void F(C1763B c1763b) {
        c1763b.getClass();
        c1763b.output_ = DEFAULT_INSTANCE.output_;
    }

    public static void G(C1763B c1763b) {
        c1763b.success_ = false;
    }

    public static void H(C1763B c1763b) {
        c1763b.getClass();
        c1763b.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void I(C1763B c1763b) {
        c1763b.getClass();
        c1763b.toolCallId_ = DEFAULT_INSTANCE.toolCallId_;
    }

    public static MapFieldLite J(C1763B c1763b) {
        MapFieldLite<String, String> mapFieldLite = c1763b.metadata_;
        if (!mapFieldLite.f2856a) {
            c1763b.metadata_ = mapFieldLite.h();
        }
        return c1763b.metadata_;
    }

    public static void K(C1763B c1763b, String str) {
        c1763b.getClass();
        str.getClass();
        c1763b.contentType_ = str;
    }

    public static void L(C1763B c1763b, ByteString byteString) {
        c1763b.getClass();
        AbstractC0932e.g(byteString);
        c1763b.contentType_ = byteString.q();
    }

    public static void M(C1763B c1763b, String str) {
        c1763b.getClass();
        str.getClass();
        c1763b.error_ = str;
    }

    public static void N(C1763B c1763b, ByteString byteString) {
        c1763b.getClass();
        AbstractC0932e.g(byteString);
        c1763b.error_ = byteString.q();
    }

    public static void O(C1763B c1763b, String str) {
        c1763b.getClass();
        str.getClass();
        c1763b.output_ = str;
    }

    public static void P(C1763B c1763b, ByteString byteString) {
        c1763b.getClass();
        AbstractC0932e.g(byteString);
        c1763b.output_ = byteString.q();
    }

    public static void Q(C1763B c1763b, boolean z10) {
        c1763b.success_ = z10;
    }

    public static void R(C1763B c1763b, String str) {
        c1763b.getClass();
        str.getClass();
        c1763b.taskId_ = str;
    }

    public static void S(C1763B c1763b, ByteString byteString) {
        c1763b.getClass();
        AbstractC0932e.g(byteString);
        c1763b.taskId_ = byteString.q();
    }

    public static void T(C1763B c1763b, String str) {
        c1763b.getClass();
        str.getClass();
        c1763b.toolCallId_ = str;
    }

    public static void U(C1763B c1763b, ByteString byteString) {
        c1763b.getClass();
        AbstractC0932e.g(byteString);
        c1763b.toolCallId_ = byteString.q();
    }

    public static C1763B Y() {
        return DEFAULT_INSTANCE;
    }

    public static ToolExecutionResult$Builder j0(C1763B c1763b) {
        return (ToolExecutionResult$Builder) DEFAULT_INSTANCE.q(c1763b);
    }

    public final String W() {
        return this.contentType_;
    }

    public final ByteString X() {
        return ByteString.f(this.contentType_);
    }

    public final String Z() {
        return this.error_;
    }

    public final ByteString a0() {
        return ByteString.f(this.error_);
    }

    public final Map b0() {
        return Collections.unmodifiableMap(this.metadata_);
    }

    public final String c0() {
        return this.output_;
    }

    public final ByteString d0() {
        return ByteString.f(this.output_);
    }

    public final boolean e0() {
        return this.success_;
    }

    public final String f0() {
        return this.taskId_;
    }

    public final ByteString g0() {
        return ByteString.f(this.taskId_);
    }

    public final String h0() {
        return this.toolCallId_;
    }

    public final ByteString i0() {
        return ByteString.f(this.toolCallId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005Ȉ\u0006Ȉ\u00072", new Object[]{"taskId_", "toolCallId_", "success_", "output_", "error_", "contentType_", "metadata_", AbstractC1762A.f5444a});
            case 3:
                return new C1763B();
            case 4:
                return new ToolExecutionResult$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1763B.class) {
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
