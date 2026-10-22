package s7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.internetplatform.CallBackReq$Builder;

/* renamed from: s7.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1918a extends GeneratedMessageLite implements Y1 {
    public static final int BODY_FIELD_NUMBER = 2;
    private static final C1918a DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int REQUESTID_FIELD_NUMBER = 1;
    private String requestId_ = "";
    private String body_ = "";

    static {
        C1918a c1918a = new C1918a();
        DEFAULT_INSTANCE = c1918a;
        GeneratedMessageLite.C(C1918a.class, c1918a);
    }

    public static void D(C1918a c1918a) {
        c1918a.getClass();
        c1918a.body_ = DEFAULT_INSTANCE.body_;
    }

    public static void E(C1918a c1918a) {
        c1918a.getClass();
        c1918a.requestId_ = DEFAULT_INSTANCE.requestId_;
    }

    public static void F(C1918a c1918a, String str) {
        c1918a.getClass();
        str.getClass();
        c1918a.body_ = str;
    }

    public static void G(C1918a c1918a, ByteString byteString) {
        c1918a.getClass();
        AbstractC0932e.g(byteString);
        c1918a.body_ = byteString.q();
    }

    public static void H(C1918a c1918a, String str) {
        c1918a.getClass();
        str.getClass();
        c1918a.requestId_ = str;
    }

    public static void I(C1918a c1918a, ByteString byteString) {
        c1918a.getClass();
        AbstractC0932e.g(byteString);
        c1918a.requestId_ = byteString.q();
    }

    public static CallBackReq$Builder O() {
        return (CallBackReq$Builder) DEFAULT_INSTANCE.p();
    }

    public final String K() {
        return this.body_;
    }

    public final ByteString L() {
        return ByteString.f(this.body_);
    }

    public final String M() {
        return this.requestId_;
    }

    public final ByteString N() {
        return ByteString.f(this.requestId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"requestId_", "body_"});
            case 3:
                return new C1918a();
            case 4:
                return new CallBackReq$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1918a.class) {
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
