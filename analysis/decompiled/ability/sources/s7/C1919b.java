package s7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.internetplatform.CallBackResp$Builder;
import com.zyql.protobuf.internetplatform.CallState;

/* renamed from: s7.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1919b extends GeneratedMessageLite implements Y1 {
    private static final C1919b DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    private int state_;

    static {
        C1919b c1919b = new C1919b();
        DEFAULT_INSTANCE = c1919b;
        GeneratedMessageLite.C(C1919b.class, c1919b);
    }

    public static void D(C1919b c1919b) {
        c1919b.state_ = 0;
    }

    public static void E(C1919b c1919b, CallState callState) {
        c1919b.getClass();
        c1919b.state_ = callState.getNumber();
    }

    public static void F(C1919b c1919b, int i) {
        c1919b.state_ = i;
    }

    public final CallState H() {
        int i = this.state_;
        CallState callState = i != 0 ? i != 1 ? null : CallState.FAIL : CallState.OK;
        return callState == null ? CallState.UNRECOGNIZED : callState;
    }

    public final int I() {
        return this.state_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"state_"});
            case 3:
                return new C1919b();
            case 4:
                return new CallBackResp$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1919b.class) {
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
