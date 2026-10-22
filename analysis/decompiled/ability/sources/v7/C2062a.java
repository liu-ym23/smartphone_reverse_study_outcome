package v7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Agent$Builder;

/* renamed from: v7.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2062a extends GeneratedMessageLite implements Y1 {
    private static final C2062a DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private String id_ = "";
    private String version_ = "";
    private String name_ = "";
    private String description_ = "";

    static {
        C2062a c2062a = new C2062a();
        DEFAULT_INSTANCE = c2062a;
        GeneratedMessageLite.C(C2062a.class, c2062a);
    }

    public static void D(C2062a c2062a) {
        c2062a.getClass();
        c2062a.description_ = DEFAULT_INSTANCE.description_;
    }

    public static void E(C2062a c2062a) {
        c2062a.getClass();
        c2062a.id_ = DEFAULT_INSTANCE.id_;
    }

    public static void F(C2062a c2062a) {
        c2062a.getClass();
        c2062a.name_ = DEFAULT_INSTANCE.name_;
    }

    public static void G(C2062a c2062a) {
        c2062a.getClass();
        c2062a.version_ = DEFAULT_INSTANCE.version_;
    }

    public static void H(C2062a c2062a, String str) {
        c2062a.getClass();
        str.getClass();
        c2062a.description_ = str;
    }

    public static void I(C2062a c2062a, ByteString byteString) {
        c2062a.getClass();
        AbstractC0932e.g(byteString);
        c2062a.description_ = byteString.q();
    }

    public static void J(C2062a c2062a, String str) {
        c2062a.getClass();
        str.getClass();
        c2062a.id_ = str;
    }

    public static void K(C2062a c2062a, ByteString byteString) {
        c2062a.getClass();
        AbstractC0932e.g(byteString);
        c2062a.id_ = byteString.q();
    }

    public static void L(C2062a c2062a, String str) {
        c2062a.getClass();
        str.getClass();
        c2062a.name_ = str;
    }

    public static void M(C2062a c2062a, ByteString byteString) {
        c2062a.getClass();
        AbstractC0932e.g(byteString);
        c2062a.name_ = byteString.q();
    }

    public static void N(C2062a c2062a, String str) {
        c2062a.getClass();
        str.getClass();
        c2062a.version_ = str;
    }

    public static void O(C2062a c2062a, ByteString byteString) {
        c2062a.getClass();
        AbstractC0932e.g(byteString);
        c2062a.version_ = byteString.q();
    }

    public static C2062a Q() {
        return DEFAULT_INSTANCE;
    }

    public static Agent$Builder Z(C2062a c2062a) {
        return (Agent$Builder) DEFAULT_INSTANCE.q(c2062a);
    }

    public final String R() {
        return this.description_;
    }

    public final ByteString S() {
        return ByteString.f(this.description_);
    }

    public final String T() {
        return this.id_;
    }

    public final ByteString U() {
        return ByteString.f(this.id_);
    }

    public final String V() {
        return this.name_;
    }

    public final ByteString W() {
        return ByteString.f(this.name_);
    }

    public final String X() {
        return this.version_;
    }

    public final ByteString Y() {
        return ByteString.f(this.version_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ", new Object[]{"id_", "version_", "name_", "description_"});
            case 3:
                return new C2062a();
            case 4:
                return new Agent$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C2062a.class) {
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
