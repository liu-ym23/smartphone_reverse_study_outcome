package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.Blob$Builder;

/* renamed from: q7.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1807e extends GeneratedMessageLite implements Y1 {
    public static final int DATA_FIELD_NUMBER = 1;
    private static final C1807e DEFAULT_INSTANCE;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
    public static final int MIME_TYPE_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER;
    private ByteString data_ = ByteString.b;
    private String displayName_ = "";
    private String mimeType_ = "";

    static {
        C1807e c1807e = new C1807e();
        DEFAULT_INSTANCE = c1807e;
        GeneratedMessageLite.C(C1807e.class, c1807e);
    }

    public static void D(C1807e c1807e) {
        c1807e.getClass();
        c1807e.data_ = DEFAULT_INSTANCE.data_;
    }

    public static void E(C1807e c1807e) {
        c1807e.getClass();
        c1807e.displayName_ = DEFAULT_INSTANCE.displayName_;
    }

    public static void F(C1807e c1807e) {
        c1807e.getClass();
        c1807e.mimeType_ = DEFAULT_INSTANCE.mimeType_;
    }

    public static void G(C1807e c1807e, ByteString byteString) {
        c1807e.getClass();
        byteString.getClass();
        c1807e.data_ = byteString;
    }

    public static void H(C1807e c1807e, String str) {
        c1807e.getClass();
        str.getClass();
        c1807e.displayName_ = str;
    }

    public static void I(C1807e c1807e, ByteString byteString) {
        c1807e.getClass();
        AbstractC0932e.g(byteString);
        c1807e.displayName_ = byteString.q();
    }

    public static void J(C1807e c1807e, String str) {
        c1807e.getClass();
        str.getClass();
        c1807e.mimeType_ = str;
    }

    public static void K(C1807e c1807e, ByteString byteString) {
        c1807e.getClass();
        AbstractC0932e.g(byteString);
        c1807e.mimeType_ = byteString.q();
    }

    public static C1807e N() {
        return DEFAULT_INSTANCE;
    }

    public static Blob$Builder S(C1807e c1807e) {
        return (Blob$Builder) DEFAULT_INSTANCE.q(c1807e);
    }

    public final ByteString M() {
        return this.data_;
    }

    public final String O() {
        return this.displayName_;
    }

    public final ByteString P() {
        return ByteString.f(this.displayName_);
    }

    public final String Q() {
        return this.mimeType_;
    }

    public final ByteString R() {
        return ByteString.f(this.mimeType_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\n\u0002Ȉ\u0003Ȉ", new Object[]{"data_", "displayName_", "mimeType_"});
            case 3:
                return new C1807e();
            case 4:
                return new Blob$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1807e.class) {
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
