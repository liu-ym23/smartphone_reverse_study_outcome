package t7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.omni.Audio$Builder;
import com.zyql.protobuf.omni.TtsResponse$Builder;

/* loaded from: classes2.dex */
public final class m extends GeneratedMessageLite implements Y1 {
    public static final int AUDIO_FIELD_NUMBER = 1;
    private static final m DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER;
    private C2020c audio_;
    private int bitField0_;

    static {
        m mVar = new m();
        DEFAULT_INSTANCE = mVar;
        GeneratedMessageLite.C(m.class, mVar);
    }

    public static void D(m mVar) {
        mVar.audio_ = null;
        mVar.bitField0_ &= -2;
    }

    public static void E(m mVar, C2020c c2020c) {
        mVar.getClass();
        c2020c.getClass();
        C2020c c2020c2 = mVar.audio_;
        if (c2020c2 == null || c2020c2 == C2020c.J()) {
            mVar.audio_ = c2020c;
        } else {
            mVar.audio_ = (C2020c) ((Audio$Builder) C2020c.L(mVar.audio_).mergeFrom((GeneratedMessageLite) c2020c)).m();
        }
        mVar.bitField0_ |= 1;
    }

    public static void F(m mVar, C2020c c2020c) {
        mVar.getClass();
        c2020c.getClass();
        mVar.audio_ = c2020c;
        mVar.bitField0_ |= 1;
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
                return new m();
            case 4:
                return new TtsResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (m.class) {
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
