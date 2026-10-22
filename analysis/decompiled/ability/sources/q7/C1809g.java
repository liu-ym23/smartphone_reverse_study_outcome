package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.FileData$Builder;

/* renamed from: q7.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1809g extends GeneratedMessageLite implements Y1 {
    private static final C1809g DEFAULT_INSTANCE;
    public static final int DISPLAY_NAME_FIELD_NUMBER = 2;
    public static final int MIME_TYPE_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int URI_FIELD_NUMBER = 1;
    private String uri_ = "";
    private String displayName_ = "";
    private String mimeType_ = "";

    static {
        C1809g c1809g = new C1809g();
        DEFAULT_INSTANCE = c1809g;
        GeneratedMessageLite.C(C1809g.class, c1809g);
    }

    public static void D(C1809g c1809g) {
        c1809g.getClass();
        c1809g.displayName_ = DEFAULT_INSTANCE.displayName_;
    }

    public static void E(C1809g c1809g) {
        c1809g.getClass();
        c1809g.mimeType_ = DEFAULT_INSTANCE.mimeType_;
    }

    public static void F(C1809g c1809g) {
        c1809g.getClass();
        c1809g.uri_ = DEFAULT_INSTANCE.uri_;
    }

    public static void G(C1809g c1809g, String str) {
        c1809g.getClass();
        str.getClass();
        c1809g.displayName_ = str;
    }

    public static void H(C1809g c1809g, ByteString byteString) {
        c1809g.getClass();
        AbstractC0932e.g(byteString);
        c1809g.displayName_ = byteString.q();
    }

    public static void I(C1809g c1809g, String str) {
        c1809g.getClass();
        str.getClass();
        c1809g.mimeType_ = str;
    }

    public static void J(C1809g c1809g, ByteString byteString) {
        c1809g.getClass();
        AbstractC0932e.g(byteString);
        c1809g.mimeType_ = byteString.q();
    }

    public static void K(C1809g c1809g, String str) {
        c1809g.getClass();
        str.getClass();
        c1809g.uri_ = str;
    }

    public static void L(C1809g c1809g, ByteString byteString) {
        c1809g.getClass();
        AbstractC0932e.g(byteString);
        c1809g.uri_ = byteString.q();
    }

    public static C1809g N() {
        return DEFAULT_INSTANCE;
    }

    public static FileData$Builder U() {
        return (FileData$Builder) DEFAULT_INSTANCE.p();
    }

    public static FileData$Builder V(C1809g c1809g) {
        return (FileData$Builder) DEFAULT_INSTANCE.q(c1809g);
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

    public final String S() {
        return this.uri_;
    }

    public final ByteString T() {
        return ByteString.f(this.uri_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"uri_", "displayName_", "mimeType_"});
            case 3:
                return new C1809g();
            case 4:
                return new FileData$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1809g.class) {
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
