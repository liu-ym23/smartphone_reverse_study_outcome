package w7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.task.engine.SubscribeReq$Builder;

/* renamed from: w7.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2107c extends GeneratedMessageLite implements Y1 {
    private static final C2107c DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TASKID_FIELD_NUMBER = 1;
    private String taskId_ = "";

    static {
        C2107c c2107c = new C2107c();
        DEFAULT_INSTANCE = c2107c;
        GeneratedMessageLite.C(C2107c.class, c2107c);
    }

    public static void D(C2107c c2107c) {
        c2107c.getClass();
        c2107c.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void E(C2107c c2107c, String str) {
        c2107c.getClass();
        str.getClass();
        c2107c.taskId_ = str;
    }

    public static void F(C2107c c2107c, ByteString byteString) {
        c2107c.getClass();
        AbstractC0932e.g(byteString);
        c2107c.taskId_ = byteString.q();
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
                return new C2107c();
            case 4:
                return new SubscribeReq$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C2107c.class) {
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
