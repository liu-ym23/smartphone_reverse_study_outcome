package u7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.runtime.CancelAck$Builder;

/* loaded from: classes2.dex */
public final class b extends GeneratedMessageLite implements Y1 {
    private static final b DEFAULT_INSTANCE;
    public static final int DETAILS_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER;
    private int bitField0_;
    private String details_ = "";

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        GeneratedMessageLite.C(b.class, bVar);
    }

    public static void D(b bVar) {
        bVar.bitField0_ &= -2;
        bVar.details_ = DEFAULT_INSTANCE.details_;
    }

    public static void E(b bVar, String str) {
        bVar.getClass();
        str.getClass();
        bVar.bitField0_ |= 1;
        bVar.details_ = str;
    }

    public static void F(b bVar, ByteString byteString) {
        bVar.getClass();
        AbstractC0932e.g(byteString);
        bVar.details_ = byteString.q();
        bVar.bitField0_ |= 1;
    }

    public static b H() {
        return DEFAULT_INSTANCE;
    }

    public static CancelAck$Builder L(b bVar) {
        return (CancelAck$Builder) DEFAULT_INSTANCE.q(bVar);
    }

    public final String I() {
        return this.details_;
    }

    public final ByteString J() {
        return ByteString.f(this.details_);
    }

    public final boolean K() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ለ\u0000", new Object[]{"bitField0_", "details_"});
            case 3:
                return new b();
            case 4:
                return new CancelAck$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (b.class) {
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
