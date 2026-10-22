package t7;

import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.omni.Audio$Builder;

/* renamed from: t7.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2020c extends GeneratedMessageLite implements Y1 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final C2020c DEFAULT_INSTANCE;
    public static final int IS_END_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER;
    private ByteString data_ = ByteString.b;
    private boolean isEnd_;

    static {
        C2020c c2020c = new C2020c();
        DEFAULT_INSTANCE = c2020c;
        GeneratedMessageLite.C(C2020c.class, c2020c);
    }

    public static void D(C2020c c2020c) {
        c2020c.getClass();
        c2020c.data_ = DEFAULT_INSTANCE.data_;
    }

    public static void E(C2020c c2020c) {
        c2020c.isEnd_ = false;
    }

    public static void F(C2020c c2020c, ByteString byteString) {
        c2020c.getClass();
        byteString.getClass();
        c2020c.data_ = byteString;
    }

    public static void G(C2020c c2020c, boolean z10) {
        c2020c.isEnd_ = z10;
    }

    public static C2020c J() {
        return DEFAULT_INSTANCE;
    }

    public static Audio$Builder L(C2020c c2020c) {
        return (Audio$Builder) DEFAULT_INSTANCE.q(c2020c);
    }

    public final ByteString I() {
        return this.data_;
    }

    public final boolean K() {
        return this.isEnd_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0002\u0007", new Object[]{"data_", "isEnd_"});
            case 3:
                return new C2020c();
            case 4:
                return new Audio$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C2020c.class) {
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
