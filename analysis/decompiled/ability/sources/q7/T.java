package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.StoreGetRequest$Builder;
import com.zyql.protobuf.common.StoreScope;

/* loaded from: classes2.dex */
public final class T extends GeneratedMessageLite implements Y1 {
    public static final int APP_ID_FIELD_NUMBER = 5;
    private static final T DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 6;
    public static final int KEY_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SCOPE_FIELD_NUMBER = 1;
    public static final int SESSION_ID_FIELD_NUMBER = 4;
    public static final int USER_ID_FIELD_NUMBER = 3;
    private int bitField0_;
    private int scope_;
    private String key_ = "";
    private String userId_ = "";
    private String sessionId_ = "";
    private String appId_ = "";
    private String defaultValue_ = "";

    static {
        T t9 = new T();
        DEFAULT_INSTANCE = t9;
        GeneratedMessageLite.C(T.class, t9);
    }

    public static void D(T t9) {
        t9.getClass();
        t9.appId_ = DEFAULT_INSTANCE.appId_;
    }

    public static void E(T t9) {
        t9.bitField0_ &= -2;
        t9.defaultValue_ = DEFAULT_INSTANCE.defaultValue_;
    }

    public static void F(T t9) {
        t9.getClass();
        t9.key_ = DEFAULT_INSTANCE.key_;
    }

    public static void G(T t9) {
        t9.scope_ = 0;
    }

    public static void H(T t9) {
        t9.getClass();
        t9.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void I(T t9) {
        t9.getClass();
        t9.userId_ = DEFAULT_INSTANCE.userId_;
    }

    public static void J(T t9, String str) {
        t9.getClass();
        str.getClass();
        t9.appId_ = str;
    }

    public static void K(T t9, ByteString byteString) {
        t9.getClass();
        AbstractC0932e.g(byteString);
        t9.appId_ = byteString.q();
    }

    public static void L(T t9, String str) {
        t9.getClass();
        str.getClass();
        t9.bitField0_ |= 1;
        t9.defaultValue_ = str;
    }

    public static void M(T t9, ByteString byteString) {
        t9.getClass();
        AbstractC0932e.g(byteString);
        t9.defaultValue_ = byteString.q();
        t9.bitField0_ |= 1;
    }

    public static void N(T t9, String str) {
        t9.getClass();
        str.getClass();
        t9.key_ = str;
    }

    public static void O(T t9, ByteString byteString) {
        t9.getClass();
        AbstractC0932e.g(byteString);
        t9.key_ = byteString.q();
    }

    public static void P(T t9, StoreScope storeScope) {
        t9.getClass();
        t9.scope_ = storeScope.getNumber();
    }

    public static void Q(T t9, int i) {
        t9.scope_ = i;
    }

    public static void R(T t9, String str) {
        t9.getClass();
        str.getClass();
        t9.sessionId_ = str;
    }

    public static void S(T t9, ByteString byteString) {
        t9.getClass();
        AbstractC0932e.g(byteString);
        t9.sessionId_ = byteString.q();
    }

    public static void T(T t9, String str) {
        t9.getClass();
        str.getClass();
        t9.userId_ = str;
    }

    public static void U(T t9, ByteString byteString) {
        t9.getClass();
        AbstractC0932e.g(byteString);
        t9.userId_ = byteString.q();
    }

    public final String W() {
        return this.appId_;
    }

    public final ByteString X() {
        return ByteString.f(this.appId_);
    }

    public final String Y() {
        return this.defaultValue_;
    }

    public final ByteString Z() {
        return ByteString.f(this.defaultValue_);
    }

    public final String a0() {
        return this.key_;
    }

    public final ByteString b0() {
        return ByteString.f(this.key_);
    }

    public final StoreScope c0() {
        StoreScope storeScopeA = StoreScope.a(this.scope_);
        return storeScopeA == null ? StoreScope.UNRECOGNIZED : storeScopeA;
    }

    public final int d0() {
        return this.scope_;
    }

    public final String e0() {
        return this.sessionId_;
    }

    public final ByteString f0() {
        return ByteString.f(this.sessionId_);
    }

    public final String g0() {
        return this.userId_;
    }

    public final ByteString h0() {
        return ByteString.f(this.userId_);
    }

    public final boolean i0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006ለ\u0000", new Object[]{"bitField0_", "scope_", "key_", "userId_", "sessionId_", "appId_", "defaultValue_"});
            case 3:
                return new T();
            case 4:
                return new StoreGetRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (T.class) {
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
