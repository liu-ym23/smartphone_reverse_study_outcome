package t7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.omni.SubscribeTaskRequest$Builder;

/* loaded from: classes2.dex */
public final class k extends GeneratedMessageLite implements Y1 {
    private static final k DEFAULT_INSTANCE;
    public static final int NEED_TTS_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TASK_EVENT_ID_FIELD_NUMBER = 2;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    private boolean needTts_;
    private String taskId_ = "";
    private String taskEventId_ = "";

    static {
        k kVar = new k();
        DEFAULT_INSTANCE = kVar;
        GeneratedMessageLite.C(k.class, kVar);
    }

    public static void D(k kVar) {
        kVar.needTts_ = false;
    }

    public static void E(k kVar) {
        kVar.getClass();
        kVar.taskEventId_ = DEFAULT_INSTANCE.taskEventId_;
    }

    public static void F(k kVar) {
        kVar.getClass();
        kVar.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void G(k kVar, boolean z10) {
        kVar.needTts_ = z10;
    }

    public static void H(k kVar, String str) {
        kVar.getClass();
        str.getClass();
        kVar.taskEventId_ = str;
    }

    public static void I(k kVar, ByteString byteString) {
        kVar.getClass();
        AbstractC0932e.g(byteString);
        kVar.taskEventId_ = byteString.q();
    }

    public static void J(k kVar, String str) {
        kVar.getClass();
        str.getClass();
        kVar.taskId_ = str;
    }

    public static void K(k kVar, ByteString byteString) {
        kVar.getClass();
        AbstractC0932e.g(byteString);
        kVar.taskId_ = byteString.q();
    }

    public final boolean M() {
        return this.needTts_;
    }

    public final String N() {
        return this.taskEventId_;
    }

    public final ByteString O() {
        return ByteString.f(this.taskEventId_);
    }

    public final String P() {
        return this.taskId_;
    }

    public final ByteString Q() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007", new Object[]{"taskId_", "taskEventId_", "needTts_"});
            case 3:
                return new k();
            case 4:
                return new SubscribeTaskRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (k.class) {
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
