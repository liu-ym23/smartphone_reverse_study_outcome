package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.ExecuteToolTask$Builder;

/* renamed from: o7.j, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1774j extends GeneratedMessageLite implements Y1 {
    public static final int ARGUMENTS_JSON_FIELD_NUMBER = 4;
    private static final C1774j DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    public static final int TIMEOUT_SECONDS_FIELD_NUMBER = 5;
    public static final int TOOL_CALL_ID_FIELD_NUMBER = 2;
    public static final int TOOL_NAME_FIELD_NUMBER = 3;
    private int timeoutSeconds_;
    private String taskId_ = "";
    private String toolCallId_ = "";
    private String toolName_ = "";
    private String argumentsJson_ = "";

    static {
        C1774j c1774j = new C1774j();
        DEFAULT_INSTANCE = c1774j;
        GeneratedMessageLite.C(C1774j.class, c1774j);
    }

    public static void D(C1774j c1774j) {
        c1774j.getClass();
        c1774j.argumentsJson_ = DEFAULT_INSTANCE.argumentsJson_;
    }

    public static void E(C1774j c1774j) {
        c1774j.getClass();
        c1774j.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void F(C1774j c1774j) {
        c1774j.timeoutSeconds_ = 0;
    }

    public static void G(C1774j c1774j) {
        c1774j.getClass();
        c1774j.toolCallId_ = DEFAULT_INSTANCE.toolCallId_;
    }

    public static void H(C1774j c1774j) {
        c1774j.getClass();
        c1774j.toolName_ = DEFAULT_INSTANCE.toolName_;
    }

    public static void I(C1774j c1774j, String str) {
        c1774j.getClass();
        str.getClass();
        c1774j.argumentsJson_ = str;
    }

    public static void J(C1774j c1774j, ByteString byteString) {
        c1774j.getClass();
        AbstractC0932e.g(byteString);
        c1774j.argumentsJson_ = byteString.q();
    }

    public static void K(C1774j c1774j, String str) {
        c1774j.getClass();
        str.getClass();
        c1774j.taskId_ = str;
    }

    public static void L(C1774j c1774j, ByteString byteString) {
        c1774j.getClass();
        AbstractC0932e.g(byteString);
        c1774j.taskId_ = byteString.q();
    }

    public static void M(C1774j c1774j, int i) {
        c1774j.timeoutSeconds_ = i;
    }

    public static void N(C1774j c1774j, String str) {
        c1774j.getClass();
        str.getClass();
        c1774j.toolCallId_ = str;
    }

    public static void O(C1774j c1774j, ByteString byteString) {
        c1774j.getClass();
        AbstractC0932e.g(byteString);
        c1774j.toolCallId_ = byteString.q();
    }

    public static void P(C1774j c1774j, String str) {
        c1774j.getClass();
        str.getClass();
        c1774j.toolName_ = str;
    }

    public static void Q(C1774j c1774j, ByteString byteString) {
        c1774j.getClass();
        AbstractC0932e.g(byteString);
        c1774j.toolName_ = byteString.q();
    }

    public static C1774j U() {
        return DEFAULT_INSTANCE;
    }

    public static ExecuteToolTask$Builder c0(C1774j c1774j) {
        return (ExecuteToolTask$Builder) DEFAULT_INSTANCE.q(c1774j);
    }

    public final String S() {
        return this.argumentsJson_;
    }

    public final ByteString T() {
        return ByteString.f(this.argumentsJson_);
    }

    public final String V() {
        return this.taskId_;
    }

    public final ByteString W() {
        return ByteString.f(this.taskId_);
    }

    public final int X() {
        return this.timeoutSeconds_;
    }

    public final String Y() {
        return this.toolCallId_;
    }

    public final ByteString Z() {
        return ByteString.f(this.toolCallId_);
    }

    public final String a0() {
        return this.toolName_;
    }

    public final ByteString b0() {
        return ByteString.f(this.toolName_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u0004", new Object[]{"taskId_", "toolCallId_", "toolName_", "argumentsJson_", "timeoutSeconds_"});
            case 3:
                return new C1774j();
            case 4:
                return new ExecuteToolTask$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1774j.class) {
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
