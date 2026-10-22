package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.GetStoreRequest$Builder;

/* loaded from: classes2.dex */
public final class n extends GeneratedMessageLite implements Y1 {
    private static final n DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int STORE_ID_FIELD_NUMBER = 1;
    private String storeId_ = "";
    private String key_ = "";

    static {
        n nVar = new n();
        DEFAULT_INSTANCE = nVar;
        GeneratedMessageLite.C(n.class, nVar);
    }

    public static void D(n nVar) {
        nVar.getClass();
        nVar.key_ = DEFAULT_INSTANCE.key_;
    }

    public static void E(n nVar) {
        nVar.getClass();
        nVar.storeId_ = DEFAULT_INSTANCE.storeId_;
    }

    public static void F(n nVar, String str) {
        nVar.getClass();
        str.getClass();
        nVar.key_ = str;
    }

    public static void G(n nVar, ByteString byteString) {
        nVar.getClass();
        AbstractC0932e.g(byteString);
        nVar.key_ = byteString.q();
    }

    public static void H(n nVar, String str) {
        nVar.getClass();
        str.getClass();
        nVar.storeId_ = str;
    }

    public static void I(n nVar, ByteString byteString) {
        nVar.getClass();
        AbstractC0932e.g(byteString);
        nVar.storeId_ = byteString.q();
    }

    public static n K() {
        return DEFAULT_INSTANCE;
    }

    public static GetStoreRequest$Builder P(n nVar) {
        return (GetStoreRequest$Builder) DEFAULT_INSTANCE.q(nVar);
    }

    public final String L() {
        return this.key_;
    }

    public final ByteString M() {
        return ByteString.f(this.key_);
    }

    public final String N() {
        return this.storeId_;
    }

    public final ByteString O() {
        return ByteString.f(this.storeId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"storeId_", "key_"});
            case 3:
                return new n();
            case 4:
                return new GetStoreRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (n.class) {
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
