package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.StoreSetResponse$Builder;

/* loaded from: classes2.dex */
public final class Y extends GeneratedMessageLite implements Y1 {
    private static final Y DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PREVIOUS_VALUE_FIELD_NUMBER = 3;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    public static final int UPDATED_FIELD_NUMBER = 2;
    private int bitField0_;
    private String previousValue_ = "";
    private boolean success_;
    private boolean updated_;

    static {
        Y y = new Y();
        DEFAULT_INSTANCE = y;
        GeneratedMessageLite.C(Y.class, y);
    }

    public static void D(Y y) {
        y.bitField0_ &= -2;
        y.previousValue_ = DEFAULT_INSTANCE.previousValue_;
    }

    public static void E(Y y) {
        y.success_ = false;
    }

    public static void F(Y y) {
        y.updated_ = false;
    }

    public static void G(Y y, String str) {
        y.getClass();
        str.getClass();
        y.bitField0_ |= 1;
        y.previousValue_ = str;
    }

    public static void H(Y y, ByteString byteString) {
        y.getClass();
        AbstractC0932e.g(byteString);
        y.previousValue_ = byteString.q();
        y.bitField0_ |= 1;
    }

    public static void I(Y y, boolean z10) {
        y.success_ = z10;
    }

    public static void J(Y y, boolean z10) {
        y.updated_ = z10;
    }

    public final String L() {
        return this.previousValue_;
    }

    public final ByteString M() {
        return ByteString.f(this.previousValue_);
    }

    public final boolean N() {
        return this.success_;
    }

    public final boolean O() {
        return this.updated_;
    }

    public final boolean P() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0007\u0002\u0007\u0003ለ\u0000", new Object[]{"bitField0_", "success_", "updated_", "previousValue_"});
            case 3:
                return new Y();
            case 4:
                return new StoreSetResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (Y.class) {
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
