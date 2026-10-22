package w7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.task.engine.TaskStateReq$Builder;

/* loaded from: classes2.dex */
public final class g extends GeneratedMessageLite implements Y1 {
    private static final g DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TASKID_FIELD_NUMBER = 1;
    private String taskId_ = "";

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        GeneratedMessageLite.C(g.class, gVar);
    }

    public static void D(g gVar) {
        gVar.getClass();
        gVar.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void E(g gVar, String str) {
        gVar.getClass();
        str.getClass();
        gVar.taskId_ = str;
    }

    public static void F(g gVar, ByteString byteString) {
        gVar.getClass();
        AbstractC0932e.g(byteString);
        gVar.taskId_ = byteString.q();
    }

    public final String H() {
        return this.taskId_;
    }

    public final ByteString I() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"taskId_"});
            case 3:
                return new g();
            case 4:
                return new TaskStateReq$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (g.class) {
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
