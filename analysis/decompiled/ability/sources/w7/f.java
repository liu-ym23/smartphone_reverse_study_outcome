package w7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.task.engine.InvokeState;
import com.zyql.protobuf.task.engine.TaskDealResp$Builder;

/* loaded from: classes2.dex */
public final class f extends GeneratedMessageLite implements Y1 {
    private static final f DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    private int state_;

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        GeneratedMessageLite.C(f.class, fVar);
    }

    public static void D(f fVar) {
        fVar.state_ = 0;
    }

    public static void E(f fVar, InvokeState invokeState) {
        fVar.getClass();
        fVar.state_ = invokeState.getNumber();
    }

    public static void F(f fVar, int i) {
        fVar.state_ = i;
    }

    public final InvokeState H() {
        InvokeState invokeStateA = InvokeState.a(this.state_);
        return invokeStateA == null ? InvokeState.UNRECOGNIZED : invokeStateA;
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
                return new f();
            case 4:
                return new TaskDealResp$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (f.class) {
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
