package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.StoreDeleteRequest$Builder;
import com.zyql.protobuf.common.StoreScope;

/* loaded from: classes2.dex */
public final class P extends GeneratedMessageLite implements Y1 {
    public static final int APP_ID_FIELD_NUMBER = 5;
    private static final P DEFAULT_INSTANCE;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SCOPE_FIELD_NUMBER = 1;
    public static final int SESSION_ID_FIELD_NUMBER = 4;
    public static final int USER_ID_FIELD_NUMBER = 3;
    private int scope_;
    private String key_ = "";
    private String userId_ = "";
    private String sessionId_ = "";
    private String appId_ = "";

    static {
        P p = new P();
        DEFAULT_INSTANCE = p;
        GeneratedMessageLite.C(P.class, p);
    }

    public static void D(P p) {
        p.getClass();
        p.appId_ = DEFAULT_INSTANCE.appId_;
    }

    public static void E(P p) {
        p.getClass();
        p.key_ = DEFAULT_INSTANCE.key_;
    }

    public static void F(P p) {
        p.scope_ = 0;
    }

    public static void G(P p) {
        p.getClass();
        p.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void H(P p) {
        p.getClass();
        p.userId_ = DEFAULT_INSTANCE.userId_;
    }

    public static void I(P p, String str) {
        p.getClass();
        str.getClass();
        p.appId_ = str;
    }

    public static void J(P p, ByteString byteString) {
        p.getClass();
        AbstractC0932e.g(byteString);
        p.appId_ = byteString.q();
    }

    public static void K(P p, String str) {
        p.getClass();
        str.getClass();
        p.key_ = str;
    }

    public static void L(P p, ByteString byteString) {
        p.getClass();
        AbstractC0932e.g(byteString);
        p.key_ = byteString.q();
    }

    public static void M(P p, StoreScope storeScope) {
        p.getClass();
        p.scope_ = storeScope.getNumber();
    }

    public static void N(P p, int i) {
        p.scope_ = i;
    }

    public static void O(P p, String str) {
        p.getClass();
        str.getClass();
        p.sessionId_ = str;
    }

    public static void P(P p, ByteString byteString) {
        p.getClass();
        AbstractC0932e.g(byteString);
        p.sessionId_ = byteString.q();
    }

    public static void Q(P p, String str) {
        p.getClass();
        str.getClass();
        p.userId_ = str;
    }

    public static void R(P p, ByteString byteString) {
        p.getClass();
        AbstractC0932e.g(byteString);
        p.userId_ = byteString.q();
    }

    public final String T() {
        return this.appId_;
    }

    public final ByteString U() {
        return ByteString.f(this.appId_);
    }

    public final String V() {
        return this.key_;
    }

    public final ByteString W() {
        return ByteString.f(this.key_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ", new Object[]{"scope_", "key_", "userId_", "sessionId_", "appId_"});
            case 3:
                return new P();
            case 4:
                return new StoreDeleteRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (P.class) {
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
