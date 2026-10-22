package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.StoreScope;
import com.zyql.protobuf.common.StoreSetRequest$Builder;

/* loaded from: classes2.dex */
public final class X extends GeneratedMessageLite implements Y1 {
    public static final int APP_ID_FIELD_NUMBER = 6;
    private static final X DEFAULT_INSTANCE;
    public static final int IF_EXISTS_FIELD_NUMBER = 9;
    public static final int IF_NOT_EXISTS_FIELD_NUMBER = 8;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SCOPE_FIELD_NUMBER = 1;
    public static final int SESSION_ID_FIELD_NUMBER = 5;
    public static final int TTL_SECONDS_FIELD_NUMBER = 7;
    public static final int USER_ID_FIELD_NUMBER = 4;
    public static final int VALUE_FIELD_NUMBER = 3;
    private boolean ifExists_;
    private boolean ifNotExists_;
    private int scope_;
    private long ttlSeconds_;
    private String key_ = "";
    private String value_ = "";
    private String userId_ = "";
    private String sessionId_ = "";
    private String appId_ = "";

    static {
        X x10 = new X();
        DEFAULT_INSTANCE = x10;
        GeneratedMessageLite.C(X.class, x10);
    }

    public static void D(X x10) {
        x10.getClass();
        x10.appId_ = DEFAULT_INSTANCE.appId_;
    }

    public static void E(X x10) {
        x10.ifExists_ = false;
    }

    public static void F(X x10) {
        x10.ifNotExists_ = false;
    }

    public static void G(X x10) {
        x10.getClass();
        x10.key_ = DEFAULT_INSTANCE.key_;
    }

    public static void H(X x10) {
        x10.scope_ = 0;
    }

    public static void I(X x10) {
        x10.getClass();
        x10.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void J(X x10) {
        x10.ttlSeconds_ = 0L;
    }

    public static void K(X x10) {
        x10.getClass();
        x10.userId_ = DEFAULT_INSTANCE.userId_;
    }

    public static void L(X x10) {
        x10.getClass();
        x10.value_ = DEFAULT_INSTANCE.value_;
    }

    public static void M(X x10, String str) {
        x10.getClass();
        str.getClass();
        x10.appId_ = str;
    }

    public static void N(X x10, ByteString byteString) {
        x10.getClass();
        AbstractC0932e.g(byteString);
        x10.appId_ = byteString.q();
    }

    public static void O(X x10, boolean z10) {
        x10.ifExists_ = z10;
    }

    public static void P(X x10, boolean z10) {
        x10.ifNotExists_ = z10;
    }

    public static void Q(X x10, String str) {
        x10.getClass();
        str.getClass();
        x10.key_ = str;
    }

    public static void R(X x10, ByteString byteString) {
        x10.getClass();
        AbstractC0932e.g(byteString);
        x10.key_ = byteString.q();
    }

    public static void S(X x10, StoreScope storeScope) {
        x10.getClass();
        x10.scope_ = storeScope.getNumber();
    }

    public static void T(X x10, int i) {
        x10.scope_ = i;
    }

    public static void U(X x10, String str) {
        x10.getClass();
        str.getClass();
        x10.sessionId_ = str;
    }

    public static void V(X x10, ByteString byteString) {
        x10.getClass();
        AbstractC0932e.g(byteString);
        x10.sessionId_ = byteString.q();
    }

    public static void W(X x10, long j5) {
        x10.ttlSeconds_ = j5;
    }

    public static void X(X x10, String str) {
        x10.getClass();
        str.getClass();
        x10.userId_ = str;
    }

    public static void Y(X x10, ByteString byteString) {
        x10.getClass();
        AbstractC0932e.g(byteString);
        x10.userId_ = byteString.q();
    }

    public static void Z(X x10, String str) {
        x10.getClass();
        str.getClass();
        x10.value_ = str;
    }

    public static void a0(X x10, ByteString byteString) {
        x10.getClass();
        AbstractC0932e.g(byteString);
        x10.value_ = byteString.q();
    }

    public final String c0() {
        return this.appId_;
    }

    public final ByteString d0() {
        return ByteString.f(this.appId_);
    }

    public final boolean e0() {
        return this.ifExists_;
    }

    public final boolean f0() {
        return this.ifNotExists_;
    }

    public final String g0() {
        return this.key_;
    }

    public final ByteString h0() {
        return ByteString.f(this.key_);
    }

    public final StoreScope i0() {
        StoreScope storeScopeA = StoreScope.a(this.scope_);
        return storeScopeA == null ? StoreScope.UNRECOGNIZED : storeScopeA;
    }

    public final int j0() {
        return this.scope_;
    }

    public final String k0() {
        return this.sessionId_;
    }

    public final ByteString l0() {
        return ByteString.f(this.sessionId_);
    }

    public final long m0() {
        return this.ttlSeconds_;
    }

    public final String n0() {
        return this.userId_;
    }

    public final ByteString o0() {
        return ByteString.f(this.userId_);
    }

    public final String p0() {
        return this.value_;
    }

    public final ByteString q0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002\b\u0007\t\u0007", new Object[]{"scope_", "key_", "value_", "userId_", "sessionId_", "appId_", "ttlSeconds_", "ifNotExists_", "ifExists_"});
            case 3:
                return new X();
            case 4:
                return new StoreSetRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (X.class) {
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
