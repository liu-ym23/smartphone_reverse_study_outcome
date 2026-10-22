package r7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.connection.AuthBindReq$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b extends GeneratedMessageLite implements Y1 {
    public static final int APP_VERSION_FIELD_NUMBER = 7;
    public static final int CHANNEL_FIELD_NUMBER = 8;
    private static final b DEFAULT_INSTANCE;
    public static final int DEVICE_FIELD_NUMBER = 6;
    public static final int DID_FIELD_NUMBER = 9;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PLATFORM_FIELD_NUMBER = 5;
    public static final int PRODUCT_FIELD_NUMBER = 1;
    public static final int RESERVED_FIELD_NUMBER = 10;
    public static final int TOKEN_FIELD_NUMBER = 3;
    public static final int TOKEN_TYPE_FIELD_NUMBER = 4;
    public static final int UID_FIELD_NUMBER = 2;
    private int platform_;
    private MapFieldLite<String, String> reserved_ = MapFieldLite.b;
    private String product_ = "";
    private String uid_ = "";
    private String token_ = "";
    private String tokenType_ = "";
    private String device_ = "";
    private String appVersion_ = "";
    private String channel_ = "";
    private String did_ = "";

    static {
        b bVar = new b();
        DEFAULT_INSTANCE = bVar;
        GeneratedMessageLite.C(b.class, bVar);
    }

    public static void D(b bVar) {
        bVar.getClass();
        bVar.appVersion_ = DEFAULT_INSTANCE.appVersion_;
    }

    public static void E(b bVar) {
        bVar.getClass();
        bVar.channel_ = DEFAULT_INSTANCE.channel_;
    }

    public static void F(b bVar) {
        bVar.getClass();
        bVar.device_ = DEFAULT_INSTANCE.device_;
    }

    public static void G(b bVar) {
        bVar.getClass();
        bVar.did_ = DEFAULT_INSTANCE.did_;
    }

    public static void H(b bVar) {
        bVar.platform_ = 0;
    }

    public static void I(b bVar) {
        bVar.getClass();
        bVar.product_ = DEFAULT_INSTANCE.product_;
    }

    public static void J(b bVar) {
        bVar.getClass();
        bVar.token_ = DEFAULT_INSTANCE.token_;
    }

    public static void K(b bVar) {
        bVar.getClass();
        bVar.tokenType_ = DEFAULT_INSTANCE.tokenType_;
    }

    public static void L(b bVar) {
        bVar.getClass();
        bVar.uid_ = DEFAULT_INSTANCE.uid_;
    }

    public static MapFieldLite M(b bVar) {
        MapFieldLite<String, String> mapFieldLite = bVar.reserved_;
        if (!mapFieldLite.f2856a) {
            bVar.reserved_ = mapFieldLite.h();
        }
        return bVar.reserved_;
    }

    public static void N(b bVar, String str) {
        bVar.getClass();
        str.getClass();
        bVar.appVersion_ = str;
    }

    public static void O(b bVar, ByteString byteString) {
        bVar.getClass();
        AbstractC0932e.g(byteString);
        bVar.appVersion_ = byteString.q();
    }

    public static void P(b bVar, String str) {
        bVar.getClass();
        str.getClass();
        bVar.channel_ = str;
    }

    public static void Q(b bVar, ByteString byteString) {
        bVar.getClass();
        AbstractC0932e.g(byteString);
        bVar.channel_ = byteString.q();
    }

    public static void R(b bVar, String str) {
        bVar.getClass();
        str.getClass();
        bVar.device_ = str;
    }

    public static void S(b bVar, ByteString byteString) {
        bVar.getClass();
        AbstractC0932e.g(byteString);
        bVar.device_ = byteString.q();
    }

    public static void T(b bVar, String str) {
        bVar.getClass();
        str.getClass();
        bVar.did_ = str;
    }

    public static void U(b bVar, ByteString byteString) {
        bVar.getClass();
        AbstractC0932e.g(byteString);
        bVar.did_ = byteString.q();
    }

    public static void V(b bVar, int i) {
        bVar.platform_ = i;
    }

    public static void W(b bVar, String str) {
        bVar.getClass();
        str.getClass();
        bVar.product_ = str;
    }

    public static void X(b bVar, ByteString byteString) {
        bVar.getClass();
        AbstractC0932e.g(byteString);
        bVar.product_ = byteString.q();
    }

    public static void Y(b bVar, String str) {
        bVar.getClass();
        str.getClass();
        bVar.token_ = str;
    }

    public static void Z(b bVar, ByteString byteString) {
        bVar.getClass();
        AbstractC0932e.g(byteString);
        bVar.token_ = byteString.q();
    }

    public static void a0(b bVar, String str) {
        bVar.getClass();
        str.getClass();
        bVar.tokenType_ = str;
    }

    public static void b0(b bVar, ByteString byteString) {
        bVar.getClass();
        AbstractC0932e.g(byteString);
        bVar.tokenType_ = byteString.q();
    }

    public static void c0(b bVar, String str) {
        bVar.getClass();
        str.getClass();
        bVar.uid_ = str;
    }

    public static void d0(b bVar, ByteString byteString) {
        bVar.getClass();
        AbstractC0932e.g(byteString);
        bVar.uid_ = byteString.q();
    }

    public static AuthBindReq$Builder x0() {
        return (AuthBindReq$Builder) DEFAULT_INSTANCE.p();
    }

    public final String f0() {
        return this.appVersion_;
    }

    public final ByteString g0() {
        return ByteString.f(this.appVersion_);
    }

    public final String h0() {
        return this.channel_;
    }

    public final ByteString i0() {
        return ByteString.f(this.channel_);
    }

    public final String j0() {
        return this.device_;
    }

    public final ByteString k0() {
        return ByteString.f(this.device_);
    }

    public final String l0() {
        return this.did_;
    }

    public final ByteString m0() {
        return ByteString.f(this.did_);
    }

    public final int n0() {
        return this.platform_;
    }

    public final String o0() {
        return this.product_;
    }

    public final ByteString p0() {
        return ByteString.f(this.product_);
    }

    public final Map q0() {
        return Collections.unmodifiableMap(this.reserved_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\n\n\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005\u000b\u0006Ȉ\u0007Ȉ\bȈ\tȈ\n2", new Object[]{"product_", "uid_", "token_", "tokenType_", "platform_", "device_", "appVersion_", "channel_", "did_", "reserved_", a.f5677a});
            case 3:
                return new b();
            case 4:
                return new AuthBindReq$Builder(0);
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

    public final String r0() {
        return this.token_;
    }

    public final ByteString s0() {
        return ByteString.f(this.token_);
    }

    public final String t0() {
        return this.tokenType_;
    }

    public final ByteString u0() {
        return ByteString.f(this.tokenType_);
    }

    public final String v0() {
        return this.uid_;
    }

    public final ByteString w0() {
        return ByteString.f(this.uid_);
    }
}
