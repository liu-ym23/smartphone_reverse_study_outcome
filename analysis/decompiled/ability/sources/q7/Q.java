package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.StoreDeleteResponse$Builder;

/* loaded from: classes2.dex */
public final class Q extends GeneratedMessageLite implements Y1 {
    private static final Q DEFAULT_INSTANCE;
    public static final int DELETED_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PREVIOUS_VALUE_FIELD_NUMBER = 2;
    private int bitField0_;
    private boolean deleted_;
    private String previousValue_ = "";

    static {
        Q q5 = new Q();
        DEFAULT_INSTANCE = q5;
        GeneratedMessageLite.C(Q.class, q5);
    }

    public static void D(Q q5) {
        q5.deleted_ = false;
    }

    public static void E(Q q5) {
        q5.bitField0_ &= -2;
        q5.previousValue_ = DEFAULT_INSTANCE.previousValue_;
    }

    public static void F(Q q5, boolean z10) {
        q5.deleted_ = z10;
    }

    public static void G(Q q5, String str) {
        q5.getClass();
        str.getClass();
        q5.bitField0_ |= 1;
        q5.previousValue_ = str;
    }

    public static void H(Q q5, ByteString byteString) {
        q5.getClass();
        AbstractC0932e.g(byteString);
        q5.previousValue_ = byteString.q();
        q5.bitField0_ |= 1;
    }

    public final boolean J() {
        return this.deleted_;
    }

    public final String K() {
        return this.previousValue_;
    }

    public final ByteString L() {
        return ByteString.f(this.previousValue_);
    }

    public final boolean M() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0007\u0002ለ\u0000", new Object[]{"bitField0_", "deleted_", "previousValue_"});
            case 3:
                return new Q();
            case 4:
                return new StoreDeleteResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (Q.class) {
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
