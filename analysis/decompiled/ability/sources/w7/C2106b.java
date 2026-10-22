package w7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.task.engine.InvokeResp$Builder;
import com.zyql.protobuf.task.engine.InvokeState;

/* renamed from: w7.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2106b extends GeneratedMessageLite implements Y1 {
    private static final C2106b DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 2;
    public static final int TASKID_FIELD_NUMBER = 1;
    private int state_;
    private String taskId_ = "";

    static {
        C2106b c2106b = new C2106b();
        DEFAULT_INSTANCE = c2106b;
        GeneratedMessageLite.C(C2106b.class, c2106b);
    }

    public static void D(C2106b c2106b) {
        c2106b.state_ = 0;
    }

    public static void E(C2106b c2106b) {
        c2106b.getClass();
        c2106b.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void F(C2106b c2106b, InvokeState invokeState) {
        c2106b.getClass();
        c2106b.state_ = invokeState.getNumber();
    }

    public static void G(C2106b c2106b, int i) {
        c2106b.state_ = i;
    }

    public static void H(C2106b c2106b, String str) {
        c2106b.getClass();
        str.getClass();
        c2106b.taskId_ = str;
    }

    public static void I(C2106b c2106b, ByteString byteString) {
        c2106b.getClass();
        AbstractC0932e.g(byteString);
        c2106b.taskId_ = byteString.q();
    }

    public final InvokeState K() {
        InvokeState invokeStateA = InvokeState.a(this.state_);
        return invokeStateA == null ? InvokeState.UNRECOGNIZED : invokeStateA;
    }

    public final int L() {
        return this.state_;
    }

    public final String M() {
        return this.taskId_;
    }

    public final ByteString N() {
        return ByteString.f(this.taskId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\f", new Object[]{"taskId_", "state_"});
            case 3:
                return new C2106b();
            case 4:
                return new InvokeResp$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C2106b.class) {
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
