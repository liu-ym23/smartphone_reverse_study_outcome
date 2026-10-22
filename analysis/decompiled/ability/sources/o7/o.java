package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.GetStoreResponse$Builder;

/* loaded from: classes2.dex */
public final class o extends GeneratedMessageLite implements Y1 {
    private static final o DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 5;
    public static final int KEY_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int STORE_ID_FIELD_NUMBER = 2;
    public static final int SUCCESS_FIELD_NUMBER = 1;
    public static final int VALUE_FIELD_NUMBER = 4;
    private boolean success_;
    private String storeId_ = "";
    private String key_ = "";
    private ByteString value_ = ByteString.b;
    private String error_ = "";

    static {
        o oVar = new o();
        DEFAULT_INSTANCE = oVar;
        GeneratedMessageLite.C(o.class, oVar);
    }

    public static void D(o oVar) {
        oVar.getClass();
        oVar.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void E(o oVar) {
        oVar.getClass();
        oVar.key_ = DEFAULT_INSTANCE.key_;
    }

    public static void F(o oVar) {
        oVar.getClass();
        oVar.storeId_ = DEFAULT_INSTANCE.storeId_;
    }

    public static void G(o oVar) {
        oVar.success_ = false;
    }

    public static void H(o oVar) {
        oVar.getClass();
        oVar.value_ = DEFAULT_INSTANCE.value_;
    }

    public static void I(o oVar, String str) {
        oVar.getClass();
        str.getClass();
        oVar.error_ = str;
    }

    public static void J(o oVar, ByteString byteString) {
        oVar.getClass();
        AbstractC0932e.g(byteString);
        oVar.error_ = byteString.q();
    }

    public static void K(o oVar, String str) {
        oVar.getClass();
        str.getClass();
        oVar.key_ = str;
    }

    public static void L(o oVar, ByteString byteString) {
        oVar.getClass();
        AbstractC0932e.g(byteString);
        oVar.key_ = byteString.q();
    }

    public static void M(o oVar, String str) {
        oVar.getClass();
        str.getClass();
        oVar.storeId_ = str;
    }

    public static void N(o oVar, ByteString byteString) {
        oVar.getClass();
        AbstractC0932e.g(byteString);
        oVar.storeId_ = byteString.q();
    }

    public static void O(o oVar, boolean z10) {
        oVar.success_ = z10;
    }

    public static void P(o oVar, ByteString byteString) {
        oVar.getClass();
        byteString.getClass();
        oVar.value_ = byteString;
    }

    public static o R() {
        return DEFAULT_INSTANCE;
    }

    public static GetStoreResponse$Builder a0(o oVar) {
        return (GetStoreResponse$Builder) DEFAULT_INSTANCE.q(oVar);
    }

    public final String S() {
        return this.error_;
    }

    public final ByteString T() {
        return ByteString.f(this.error_);
    }

    public final String U() {
        return this.key_;
    }

    public final ByteString V() {
        return ByteString.f(this.key_);
    }

    public final String W() {
        return this.storeId_;
    }

    public final ByteString X() {
        return ByteString.f(this.storeId_);
    }

    public final boolean Y() {
        return this.success_;
    }

    public final ByteString Z() {
        return this.value_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0007\u0002Ȉ\u0003Ȉ\u0004\n\u0005Ȉ", new Object[]{"success_", "storeId_", "key_", "value_", "error_"});
            case 3:
                return new o();
            case 4:
                return new GetStoreResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (o.class) {
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
