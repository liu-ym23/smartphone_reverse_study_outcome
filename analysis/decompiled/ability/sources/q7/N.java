package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.StoreClearRequest$Builder;
import com.zyql.protobuf.common.StoreScope;

/* loaded from: classes2.dex */
public final class N extends GeneratedMessageLite implements Y1 {
    public static final int APP_ID_FIELD_NUMBER = 4;
    private static final N DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PREFIX_FIELD_NUMBER = 5;
    public static final int SCOPE_FIELD_NUMBER = 1;
    public static final int SESSION_ID_FIELD_NUMBER = 3;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private int scope_;
    private String userId_ = "";
    private String sessionId_ = "";
    private String appId_ = "";
    private String prefix_ = "";

    static {
        N n = new N();
        DEFAULT_INSTANCE = n;
        GeneratedMessageLite.C(N.class, n);
    }

    public static void D(N n) {
        n.getClass();
        n.appId_ = DEFAULT_INSTANCE.appId_;
    }

    public static void E(N n) {
        n.getClass();
        n.prefix_ = DEFAULT_INSTANCE.prefix_;
    }

    public static void F(N n) {
        n.scope_ = 0;
    }

    public static void G(N n) {
        n.getClass();
        n.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void H(N n) {
        n.getClass();
        n.userId_ = DEFAULT_INSTANCE.userId_;
    }

    public static void I(N n, String str) {
        n.getClass();
        str.getClass();
        n.appId_ = str;
    }

    public static void J(N n, ByteString byteString) {
        n.getClass();
        AbstractC0932e.g(byteString);
        n.appId_ = byteString.q();
    }

    public static void K(N n, String str) {
        n.getClass();
        str.getClass();
        n.prefix_ = str;
    }

    public static void L(N n, ByteString byteString) {
        n.getClass();
        AbstractC0932e.g(byteString);
        n.prefix_ = byteString.q();
    }

    public static void M(N n, StoreScope storeScope) {
        n.getClass();
        n.scope_ = storeScope.getNumber();
    }

    public static void N(N n, int i) {
        n.scope_ = i;
    }

    public static void O(N n, String str) {
        n.getClass();
        str.getClass();
        n.sessionId_ = str;
    }

    public static void P(N n, ByteString byteString) {
        n.getClass();
        AbstractC0932e.g(byteString);
        n.sessionId_ = byteString.q();
    }

    public static void Q(N n, String str) {
        n.getClass();
        str.getClass();
        n.userId_ = str;
    }

    public static void R(N n, ByteString byteString) {
        n.getClass();
        AbstractC0932e.g(byteString);
        n.userId_ = byteString.q();
    }

    public final String T() {
        return this.appId_;
    }

    public final ByteString U() {
        return ByteString.f(this.appId_);
    }

    public final String V() {
        return this.prefix_;
    }

    public final ByteString W() {
        return ByteString.f(this.prefix_);
    }

    public final StoreScope X() {
        StoreScope storeScopeA = StoreScope.a(this.scope_);
        return storeScopeA == null ? StoreScope.UNRECOGNIZED : storeScopeA;
    }

    public final int Y() {
        return this.scope_;
    }

    public final String Z() {
        return this.sessionId_;
    }

    public final ByteString a0() {
        return ByteString.f(this.sessionId_);
    }

    public final String b0() {
        return this.userId_;
    }

    public final ByteString c0() {
        return ByteString.f(this.userId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ", new Object[]{"scope_", "userId_", "sessionId_", "appId_", "prefix_"});
            case 3:
                return new N();
            case 4:
                return new StoreClearRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (N.class) {
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
