package w7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.task.engine.TaskDealReq$Builder;

/* loaded from: classes2.dex */
public final class e extends GeneratedMessageLite implements Y1 {
    public static final int COMMOND_FIELD_NUMBER = 2;
    private static final e DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TASKID_FIELD_NUMBER = 1;
    private String taskId_ = "";
    private String commond_ = "";

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        GeneratedMessageLite.C(e.class, eVar);
    }

    public static void D(e eVar) {
        eVar.getClass();
        eVar.commond_ = DEFAULT_INSTANCE.commond_;
    }

    public static void E(e eVar) {
        eVar.getClass();
        eVar.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void F(e eVar, String str) {
        eVar.getClass();
        str.getClass();
        eVar.commond_ = str;
    }

    public static void G(e eVar, ByteString byteString) {
        eVar.getClass();
        AbstractC0932e.g(byteString);
        eVar.commond_ = byteString.q();
    }

    public static void H(e eVar, String str) {
        eVar.getClass();
        str.getClass();
        eVar.taskId_ = str;
    }

    public static void I(e eVar, ByteString byteString) {
        eVar.getClass();
        AbstractC0932e.g(byteString);
        eVar.taskId_ = byteString.q();
    }

    public final String K() {
        return this.commond_;
    }

    public final ByteString L() {
        return ByteString.f(this.commond_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"taskId_", "commond_"});
            case 3:
                return new e();
            case 4:
                return new TaskDealReq$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (e.class) {
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
