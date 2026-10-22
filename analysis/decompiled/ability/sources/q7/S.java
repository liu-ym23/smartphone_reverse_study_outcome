package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.StoreEntry$Builder;
import com.zyql.protobuf.common.StoreScope;

/* loaded from: classes2.dex */
public final class S extends GeneratedMessageLite implements Y1 {
    public static final int APP_ID_FIELD_NUMBER = 6;
    public static final int CREATED_AT_FIELD_NUMBER = 7;
    private static final S DEFAULT_INSTANCE;
    public static final int EXPIRES_AT_FIELD_NUMBER = 9;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SCOPE_FIELD_NUMBER = 1;
    public static final int SESSION_ID_FIELD_NUMBER = 5;
    public static final int TTL_SECONDS_FIELD_NUMBER = 10;
    public static final int UPDATED_AT_FIELD_NUMBER = 8;
    public static final int USER_ID_FIELD_NUMBER = 4;
    public static final int VALUE_FIELD_NUMBER = 3;
    private long createdAt_;
    private long expiresAt_;
    private int scope_;
    private long ttlSeconds_;
    private long updatedAt_;
    private String key_ = "";
    private String value_ = "";
    private String userId_ = "";
    private String sessionId_ = "";
    private String appId_ = "";

    static {
        S s5 = new S();
        DEFAULT_INSTANCE = s5;
        GeneratedMessageLite.C(S.class, s5);
    }

    public static void D(S s5) {
        s5.getClass();
        s5.appId_ = DEFAULT_INSTANCE.appId_;
    }

    public static void E(S s5) {
        s5.createdAt_ = 0L;
    }

    public static void F(S s5) {
        s5.expiresAt_ = 0L;
    }

    public static void G(S s5) {
        s5.getClass();
        s5.key_ = DEFAULT_INSTANCE.key_;
    }

    public static void H(S s5) {
        s5.scope_ = 0;
    }

    public static void I(S s5) {
        s5.getClass();
        s5.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void J(S s5) {
        s5.ttlSeconds_ = 0L;
    }

    public static void K(S s5) {
        s5.updatedAt_ = 0L;
    }

    public static void L(S s5) {
        s5.getClass();
        s5.userId_ = DEFAULT_INSTANCE.userId_;
    }

    public static void M(S s5) {
        s5.getClass();
        s5.value_ = DEFAULT_INSTANCE.value_;
    }

    public static void N(S s5, String str) {
        s5.getClass();
        str.getClass();
        s5.appId_ = str;
    }

    public static void O(S s5, ByteString byteString) {
        s5.getClass();
        AbstractC0932e.g(byteString);
        s5.appId_ = byteString.q();
    }

    public static void P(S s5, long j5) {
        s5.createdAt_ = j5;
    }

    public static void Q(S s5, long j5) {
        s5.expiresAt_ = j5;
    }

    public static void R(S s5, String str) {
        s5.getClass();
        str.getClass();
        s5.key_ = str;
    }

    public static void S(S s5, ByteString byteString) {
        s5.getClass();
        AbstractC0932e.g(byteString);
        s5.key_ = byteString.q();
    }

    public static void T(S s5, StoreScope storeScope) {
        s5.getClass();
        s5.scope_ = storeScope.getNumber();
    }

    public static void U(S s5, int i) {
        s5.scope_ = i;
    }

    public static void V(S s5, String str) {
        s5.getClass();
        str.getClass();
        s5.sessionId_ = str;
    }

    public static void W(S s5, ByteString byteString) {
        s5.getClass();
        AbstractC0932e.g(byteString);
        s5.sessionId_ = byteString.q();
    }

    public static void X(S s5, long j5) {
        s5.ttlSeconds_ = j5;
    }

    public static void Y(S s5, long j5) {
        s5.updatedAt_ = j5;
    }

    public static void Z(S s5, String str) {
        s5.getClass();
        str.getClass();
        s5.userId_ = str;
    }

    public static void a0(S s5, ByteString byteString) {
        s5.getClass();
        AbstractC0932e.g(byteString);
        s5.userId_ = byteString.q();
    }

    public static void b0(S s5, String str) {
        s5.getClass();
        str.getClass();
        s5.value_ = str;
    }

    public static void c0(S s5, ByteString byteString) {
        s5.getClass();
        AbstractC0932e.g(byteString);
        s5.value_ = byteString.q();
    }

    public final String e0() {
        return this.appId_;
    }

    public final ByteString f0() {
        return ByteString.f(this.appId_);
    }

    public final long g0() {
        return this.createdAt_;
    }

    public final long h0() {
        return this.expiresAt_;
    }

    public final String i0() {
        return this.key_;
    }

    public final ByteString j0() {
        return ByteString.f(this.key_);
    }

    public final StoreScope k0() {
        StoreScope storeScopeA = StoreScope.a(this.scope_);
        return storeScopeA == null ? StoreScope.UNRECOGNIZED : storeScopeA;
    }

    public final int l0() {
        return this.scope_;
    }

    public final String m0() {
        return this.sessionId_;
    }

    public final ByteString n0() {
        return ByteString.f(this.sessionId_);
    }

    public final long o0() {
        return this.ttlSeconds_;
    }

    public final long p0() {
        return this.updatedAt_;
    }

    public final String q0() {
        return this.userId_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002\b\u0002\t\u0002\n\u0002", new Object[]{"scope_", "key_", "value_", "userId_", "sessionId_", "appId_", "createdAt_", "updatedAt_", "expiresAt_", "ttlSeconds_"});
            case 3:
                return new S();
            case 4:
                return new StoreEntry$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (S.class) {
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

    public final ByteString r0() {
        return ByteString.f(this.userId_);
    }

    public final String s0() {
        return this.value_;
    }

    public final ByteString t0() {
        return ByteString.f(this.value_);
    }
}
