package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.StoreListRequest$Builder;
import com.zyql.protobuf.common.StoreScope;

/* loaded from: classes2.dex */
public final class V extends GeneratedMessageLite implements Y1 {
    public static final int APP_ID_FIELD_NUMBER = 4;
    public static final int COUNT_FIELD_NUMBER = 7;
    public static final int CURSOR_FIELD_NUMBER = 6;
    private static final V DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PREFIX_FIELD_NUMBER = 5;
    public static final int SCOPE_FIELD_NUMBER = 1;
    public static final int SESSION_ID_FIELD_NUMBER = 3;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private int count_;
    private int scope_;
    private String userId_ = "";
    private String sessionId_ = "";
    private String appId_ = "";
    private String prefix_ = "";
    private String cursor_ = "";

    static {
        V v10 = new V();
        DEFAULT_INSTANCE = v10;
        GeneratedMessageLite.C(V.class, v10);
    }

    public static void D(V v10) {
        v10.getClass();
        v10.appId_ = DEFAULT_INSTANCE.appId_;
    }

    public static void E(V v10) {
        v10.count_ = 0;
    }

    public static void F(V v10) {
        v10.getClass();
        v10.cursor_ = DEFAULT_INSTANCE.cursor_;
    }

    public static void G(V v10) {
        v10.getClass();
        v10.prefix_ = DEFAULT_INSTANCE.prefix_;
    }

    public static void H(V v10) {
        v10.scope_ = 0;
    }

    public static void I(V v10) {
        v10.getClass();
        v10.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void J(V v10) {
        v10.getClass();
        v10.userId_ = DEFAULT_INSTANCE.userId_;
    }

    public static void K(V v10, String str) {
        v10.getClass();
        str.getClass();
        v10.appId_ = str;
    }

    public static void L(V v10, ByteString byteString) {
        v10.getClass();
        AbstractC0932e.g(byteString);
        v10.appId_ = byteString.q();
    }

    public static void M(V v10, int i) {
        v10.count_ = i;
    }

    public static void N(V v10, String str) {
        v10.getClass();
        str.getClass();
        v10.cursor_ = str;
    }

    public static void O(V v10, ByteString byteString) {
        v10.getClass();
        AbstractC0932e.g(byteString);
        v10.cursor_ = byteString.q();
    }

    public static void P(V v10, String str) {
        v10.getClass();
        str.getClass();
        v10.prefix_ = str;
    }

    public static void Q(V v10, ByteString byteString) {
        v10.getClass();
        AbstractC0932e.g(byteString);
        v10.prefix_ = byteString.q();
    }

    public static void R(V v10, StoreScope storeScope) {
        v10.getClass();
        v10.scope_ = storeScope.getNumber();
    }

    public static void S(V v10, int i) {
        v10.scope_ = i;
    }

    public static void T(V v10, String str) {
        v10.getClass();
        str.getClass();
        v10.sessionId_ = str;
    }

    public static void U(V v10, ByteString byteString) {
        v10.getClass();
        AbstractC0932e.g(byteString);
        v10.sessionId_ = byteString.q();
    }

    public static void V(V v10, String str) {
        v10.getClass();
        str.getClass();
        v10.userId_ = str;
    }

    public static void W(V v10, ByteString byteString) {
        v10.getClass();
        AbstractC0932e.g(byteString);
        v10.userId_ = byteString.q();
    }

    public final String Y() {
        return this.appId_;
    }

    public final ByteString Z() {
        return ByteString.f(this.appId_);
    }

    public final int a0() {
        return this.count_;
    }

    public final String b0() {
        return this.cursor_;
    }

    public final ByteString c0() {
        return ByteString.f(this.cursor_);
    }

    public final String d0() {
        return this.prefix_;
    }

    public final ByteString e0() {
        return ByteString.f(this.prefix_);
    }

    public final StoreScope f0() {
        StoreScope storeScopeA = StoreScope.a(this.scope_);
        return storeScopeA == null ? StoreScope.UNRECOGNIZED : storeScopeA;
    }

    public final int g0() {
        return this.scope_;
    }

    public final String h0() {
        return this.sessionId_;
    }

    public final ByteString i0() {
        return ByteString.f(this.sessionId_);
    }

    public final String j0() {
        return this.userId_;
    }

    public final ByteString k0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\f\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0004", new Object[]{"scope_", "userId_", "sessionId_", "appId_", "prefix_", "cursor_", "count_"});
            case 3:
                return new V();
            case 4:
                return new StoreListRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (V.class) {
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
