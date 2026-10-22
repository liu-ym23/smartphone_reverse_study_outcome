package r7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.connection.AuthBindResp$Builder;

/* loaded from: classes2.dex */
public final class c extends GeneratedMessageLite implements Y1 {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int CONN_FIELD_NUMBER = 4;
    private static final c DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 2;
    public static final int LOGINED_FIELD_NUMBER = 6;
    public static final int NEW_FIELD_NUMBER = 7;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int UID_FIELD_NUMBER = 5;
    private int code_;
    private int logined_;
    private boolean new_;
    private String error_ = "";
    private String conn_ = "";
    private String uid_ = "";

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        GeneratedMessageLite.C(c.class, cVar);
    }

    public static void D(c cVar) {
        cVar.code_ = 0;
    }

    public static void E(c cVar) {
        cVar.getClass();
        cVar.conn_ = DEFAULT_INSTANCE.conn_;
    }

    public static void F(c cVar) {
        cVar.getClass();
        cVar.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void G(c cVar) {
        cVar.logined_ = 0;
    }

    public static void H(c cVar) {
        cVar.new_ = false;
    }

    public static void I(c cVar) {
        cVar.getClass();
        cVar.uid_ = DEFAULT_INSTANCE.uid_;
    }

    public static void J(c cVar, int i) {
        cVar.code_ = i;
    }

    public static void K(c cVar, String str) {
        cVar.getClass();
        str.getClass();
        cVar.conn_ = str;
    }

    public static void L(c cVar, ByteString byteString) {
        cVar.getClass();
        AbstractC0932e.g(byteString);
        cVar.conn_ = byteString.q();
    }

    public static void M(c cVar, String str) {
        cVar.getClass();
        str.getClass();
        cVar.error_ = str;
    }

    public static void N(c cVar, ByteString byteString) {
        cVar.getClass();
        AbstractC0932e.g(byteString);
        cVar.error_ = byteString.q();
    }

    public static void O(c cVar, int i) {
        cVar.logined_ = i;
    }

    public static void P(c cVar, boolean z10) {
        cVar.new_ = z10;
    }

    public static void Q(c cVar, String str) {
        cVar.getClass();
        str.getClass();
        cVar.uid_ = str;
    }

    public static void R(c cVar, ByteString byteString) {
        cVar.getClass();
        AbstractC0932e.g(byteString);
        cVar.uid_ = byteString.q();
    }

    public static c c0(ByteString byteString) {
        return (c) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString);
    }

    public final int T() {
        return this.code_;
    }

    public final String U() {
        return this.conn_;
    }

    public final ByteString V() {
        return ByteString.f(this.conn_);
    }

    public final String W() {
        return this.error_;
    }

    public final ByteString X() {
        return ByteString.f(this.error_);
    }

    public final int Y() {
        return this.logined_;
    }

    public final boolean Z() {
        return this.new_;
    }

    public final String a0() {
        return this.uid_;
    }

    public final ByteString b0() {
        return ByteString.f(this.uid_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0007\u0006\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0004Ȉ\u0005Ȉ\u0006\u0004\u0007\u0007", new Object[]{"code_", "error_", "conn_", "uid_", "logined_", "new_"});
            case 3:
                return new c();
            case 4:
                return new AuthBindResp$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (c.class) {
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
