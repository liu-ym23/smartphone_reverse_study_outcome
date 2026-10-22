package t7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.omni.AsrRequest$Builder;
import com.zyql.protobuf.omni.Audio$Builder;

/* renamed from: t7.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2018a extends GeneratedMessageLite implements Y1 {
    public static final int AUDIO_FIELD_NUMBER = 1;
    private static final C2018a DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER;
    private C2020c audio_;
    private int bitField0_;

    static {
        C2018a c2018a = new C2018a();
        DEFAULT_INSTANCE = c2018a;
        GeneratedMessageLite.C(C2018a.class, c2018a);
    }

    public static void D(C2018a c2018a) {
        c2018a.audio_ = null;
        c2018a.bitField0_ &= -2;
    }

    public static void E(C2018a c2018a, C2020c c2020c) {
        c2018a.getClass();
        c2020c.getClass();
        C2020c c2020c2 = c2018a.audio_;
        if (c2020c2 == null || c2020c2 == C2020c.J()) {
            c2018a.audio_ = c2020c;
        } else {
            c2018a.audio_ = (C2020c) ((Audio$Builder) C2020c.L(c2018a.audio_).mergeFrom((GeneratedMessageLite) c2020c)).m();
        }
        c2018a.bitField0_ |= 1;
    }

    public static void F(C2018a c2018a, C2020c c2020c) {
        c2018a.getClass();
        c2020c.getClass();
        c2018a.audio_ = c2020c;
        c2018a.bitField0_ |= 1;
    }

    public final C2020c H() {
        C2020c c2020c = this.audio_;
        return c2020c == null ? C2020c.J() : c2020c;
    }

    public final boolean I() {
        return (this.bitField0_ & 1) != 0;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"bitField0_", "audio_"});
            case 3:
                return new C2018a();
            case 4:
                return new AsrRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C2018a.class) {
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
