package v7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Resource$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class l extends GeneratedMessageLite implements Y1 {
    public static final int CONTENT_FIELD_NUMBER = 3;
    private static final l DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 5;
    public static final int EXTRA_FIELD_NUMBER = 7;
    public static final int MIME_TYPE_FIELD_NUMBER = 6;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TITLE_FIELD_NUMBER = 2;
    public static final int TYPE_FIELD_NUMBER = 1;
    public static final int URI_FIELD_NUMBER = 4;
    private MapFieldLite<String, String> extra_ = MapFieldLite.b;
    private String type_ = "";
    private String title_ = "";
    private String content_ = "";
    private String uri_ = "";
    private String description_ = "";
    private String mimeType_ = "";

    static {
        l lVar = new l();
        DEFAULT_INSTANCE = lVar;
        GeneratedMessageLite.C(l.class, lVar);
    }

    public static void D(l lVar) {
        lVar.getClass();
        lVar.content_ = DEFAULT_INSTANCE.content_;
    }

    public static void E(l lVar) {
        lVar.getClass();
        lVar.description_ = DEFAULT_INSTANCE.description_;
    }

    public static void F(l lVar) {
        lVar.getClass();
        lVar.mimeType_ = DEFAULT_INSTANCE.mimeType_;
    }

    public static void G(l lVar) {
        lVar.getClass();
        lVar.title_ = DEFAULT_INSTANCE.title_;
    }

    public static void H(l lVar) {
        lVar.getClass();
        lVar.type_ = DEFAULT_INSTANCE.type_;
    }

    public static void I(l lVar) {
        lVar.getClass();
        lVar.uri_ = DEFAULT_INSTANCE.uri_;
    }

    public static MapFieldLite J(l lVar) {
        MapFieldLite<String, String> mapFieldLite = lVar.extra_;
        if (!mapFieldLite.f2856a) {
            lVar.extra_ = mapFieldLite.h();
        }
        return lVar.extra_;
    }

    public static void K(l lVar, String str) {
        lVar.getClass();
        str.getClass();
        lVar.content_ = str;
    }

    public static void L(l lVar, ByteString byteString) {
        lVar.getClass();
        AbstractC0932e.g(byteString);
        lVar.content_ = byteString.q();
    }

    public static void M(l lVar, String str) {
        lVar.getClass();
        str.getClass();
        lVar.description_ = str;
    }

    public static void N(l lVar, ByteString byteString) {
        lVar.getClass();
        AbstractC0932e.g(byteString);
        lVar.description_ = byteString.q();
    }

    public static void O(l lVar, String str) {
        lVar.getClass();
        str.getClass();
        lVar.mimeType_ = str;
    }

    public static void P(l lVar, ByteString byteString) {
        lVar.getClass();
        AbstractC0932e.g(byteString);
        lVar.mimeType_ = byteString.q();
    }

    public static void Q(l lVar, String str) {
        lVar.getClass();
        str.getClass();
        lVar.title_ = str;
    }

    public static void R(l lVar, ByteString byteString) {
        lVar.getClass();
        AbstractC0932e.g(byteString);
        lVar.title_ = byteString.q();
    }

    public static void S(l lVar, String str) {
        lVar.getClass();
        str.getClass();
        lVar.type_ = str;
    }

    public static void T(l lVar, ByteString byteString) {
        lVar.getClass();
        AbstractC0932e.g(byteString);
        lVar.type_ = byteString.q();
    }

    public static void U(l lVar, String str) {
        lVar.getClass();
        str.getClass();
        lVar.uri_ = str;
    }

    public static void V(l lVar, ByteString byteString) {
        lVar.getClass();
        AbstractC0932e.g(byteString);
        lVar.uri_ = byteString.q();
    }

    public static Resource$Builder k0() {
        return (Resource$Builder) DEFAULT_INSTANCE.p();
    }

    public final String X() {
        return this.content_;
    }

    public final ByteString Y() {
        return ByteString.f(this.content_);
    }

    public final String Z() {
        return this.description_;
    }

    public final ByteString a0() {
        return ByteString.f(this.description_);
    }

    public final Map b0() {
        return Collections.unmodifiableMap(this.extra_);
    }

    public final String c0() {
        return this.mimeType_;
    }

    public final ByteString d0() {
        return ByteString.f(this.mimeType_);
    }

    public final String e0() {
        return this.title_;
    }

    public final ByteString f0() {
        return ByteString.f(this.title_);
    }

    public final String g0() {
        return this.type_;
    }

    public final ByteString h0() {
        return ByteString.f(this.type_);
    }

    public final String i0() {
        return this.uri_;
    }

    public final ByteString j0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u00072", new Object[]{"type_", "title_", "content_", "uri_", "description_", "mimeType_", "extra_", k.f6786a});
            case 3:
                return new l();
            case 4:
                return new Resource$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (l.class) {
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
