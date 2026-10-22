package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.RegisterHookResponse$Builder;

/* loaded from: classes2.dex */
public final class I extends GeneratedMessageLite implements Y1 {
    private static final I DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 3;
    public static final int HOOK_ID_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    private boolean success_;
    private String hookId_ = "";
    private String error_ = "";

    static {
        I i = new I();
        DEFAULT_INSTANCE = i;
        GeneratedMessageLite.C(I.class, i);
    }

    public static void D(I i) {
        i.getClass();
        i.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void E(I i) {
        i.getClass();
        i.hookId_ = DEFAULT_INSTANCE.hookId_;
    }

    public static void F(I i) {
        i.success_ = false;
    }

    public static void G(I i, String str) {
        i.getClass();
        str.getClass();
        i.error_ = str;
    }

    public static void H(I i, ByteString byteString) {
        i.getClass();
        AbstractC0932e.g(byteString);
        i.error_ = byteString.q();
    }

    public static void I(I i, String str) {
        i.getClass();
        str.getClass();
        i.hookId_ = str;
    }

    public static void J(I i, ByteString byteString) {
        i.getClass();
        AbstractC0932e.g(byteString);
        i.hookId_ = byteString.q();
    }

    public static void K(I i, boolean z10) {
        i.success_ = z10;
    }

    public final String M() {
        return this.error_;
    }

    public final ByteString N() {
        return ByteString.f(this.error_);
    }

    public final String O() {
        return this.hookId_;
    }

    public final ByteString P() {
        return ByteString.f(this.hookId_);
    }

    public final boolean Q() {
        return this.success_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002Ȉ\u0003Ȉ", new Object[]{"success_", "hookId_", "error_"});
            case 3:
                return new I();
            case 4:
                return new RegisterHookResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (I.class) {
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
