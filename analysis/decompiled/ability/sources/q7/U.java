package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.StoreGetResponse$Builder;

/* loaded from: classes2.dex */
public final class U extends GeneratedMessageLite implements Y1 {
    private static final U DEFAULT_INSTANCE;
    public static final int FOUND_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TTL_SECONDS_FIELD_NUMBER = 4;
    public static final int UPDATED_AT_FIELD_NUMBER = 3;
    public static final int VALUE_FIELD_NUMBER = 2;
    private boolean found_;
    private long ttlSeconds_;
    private long updatedAt_;
    private String value_ = "";

    static {
        U u = new U();
        DEFAULT_INSTANCE = u;
        GeneratedMessageLite.C(U.class, u);
    }

    public static void D(U u) {
        u.found_ = false;
    }

    public static void E(U u) {
        u.ttlSeconds_ = 0L;
    }

    public static void F(U u) {
        u.updatedAt_ = 0L;
    }

    public static void G(U u) {
        u.getClass();
        u.value_ = DEFAULT_INSTANCE.value_;
    }

    public static void H(U u, boolean z10) {
        u.found_ = z10;
    }

    public static void I(U u, long j5) {
        u.ttlSeconds_ = j5;
    }

    public static void J(U u, long j5) {
        u.updatedAt_ = j5;
    }

    public static void K(U u, String str) {
        u.getClass();
        str.getClass();
        u.value_ = str;
    }

    public static void L(U u, ByteString byteString) {
        u.getClass();
        AbstractC0932e.g(byteString);
        u.value_ = byteString.q();
    }

    public final boolean N() {
        return this.found_;
    }

    public final long O() {
        return this.ttlSeconds_;
    }

    public final long P() {
        return this.updatedAt_;
    }

    public final String Q() {
        return this.value_;
    }

    public final ByteString R() {
        return ByteString.f(this.value_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0007\u0002Ȉ\u0003\u0002\u0004\u0002", new Object[]{"found_", "value_", "updatedAt_", "ttlSeconds_"});
            case 3:
                return new U();
            case 4:
                return new StoreGetResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (U.class) {
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
