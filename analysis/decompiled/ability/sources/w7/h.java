package w7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.task.engine.TaskState;
import com.zyql.protobuf.task.engine.TaskStateResp$Builder;

/* loaded from: classes2.dex */
public final class h extends GeneratedMessageLite implements Y1 {
    private static final h DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int STATE_FIELD_NUMBER = 1;
    private int state_;

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        GeneratedMessageLite.C(h.class, hVar);
    }

    public static void D(h hVar) {
        hVar.state_ = 0;
    }

    public static void E(h hVar, TaskState taskState) {
        hVar.getClass();
        hVar.state_ = taskState.getNumber();
    }

    public static void F(h hVar, int i) {
        hVar.state_ = i;
    }

    public final TaskState H() {
        int i = this.state_;
        TaskState taskState = i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? null : TaskState.Canceled : TaskState.Failed : TaskState.Complete : TaskState.Pending : TaskState.Stop : TaskState.Running;
        return taskState == null ? TaskState.UNRECOGNIZED : taskState;
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
                return new h();
            case 4:
                return new TaskStateResp$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (h.class) {
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
