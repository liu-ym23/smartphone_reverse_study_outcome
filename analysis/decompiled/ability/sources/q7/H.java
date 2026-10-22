package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.HookDefinition$Builder;
import com.zyql.protobuf.common.RegisterHookRequest$Builder;

/* loaded from: classes2.dex */
public final class H extends GeneratedMessageLite implements Y1 {
    private static final H DEFAULT_INSTANCE;
    public static final int HOOK_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private C1816n hook_;
    private String sessionId_ = "";

    static {
        H h = new H();
        DEFAULT_INSTANCE = h;
        GeneratedMessageLite.C(H.class, h);
    }

    public static void D(H h) {
        h.hook_ = null;
        h.bitField0_ &= -2;
    }

    public static void E(H h) {
        h.getClass();
        h.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void F(H h, C1816n c1816n) {
        h.getClass();
        c1816n.getClass();
        C1816n c1816n2 = h.hook_;
        if (c1816n2 == null || c1816n2 == C1816n.Y()) {
            h.hook_ = c1816n;
        } else {
            h.hook_ = (C1816n) ((HookDefinition$Builder) C1816n.n0(h.hook_).mergeFrom((GeneratedMessageLite) c1816n)).m();
        }
        h.bitField0_ |= 1;
    }

    public static void G(H h, C1816n c1816n) {
        h.getClass();
        c1816n.getClass();
        h.hook_ = c1816n;
        h.bitField0_ |= 1;
    }

    public static void H(H h, String str) {
        h.getClass();
        str.getClass();
        h.sessionId_ = str;
    }

    public static void I(H h, ByteString byteString) {
        h.getClass();
        AbstractC0932e.g(byteString);
        h.sessionId_ = byteString.q();
    }

    public final C1816n K() {
        C1816n c1816n = this.hook_;
        return c1816n == null ? C1816n.Y() : c1816n;
    }

    public final String L() {
        return this.sessionId_;
    }

    public final ByteString M() {
        return ByteString.f(this.sessionId_);
    }

    public final boolean N() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ", new Object[]{"bitField0_", "hook_", "sessionId_"});
            case 3:
                return new H();
            case 4:
                return new RegisterHookRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (H.class) {
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
