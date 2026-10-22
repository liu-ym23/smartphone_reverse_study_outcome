package v7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Tool$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class u extends GeneratedMessageLite implements Y1 {
    private static final u DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 3;
    public static final int PARAMETERS_FIELD_NUMBER = 5;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 2;
    private MapFieldLite<String, String> parameters_ = MapFieldLite.b;
    private String id_ = "";
    private String version_ = "";
    private String name_ = "";
    private String description_ = "";

    static {
        u uVar = new u();
        DEFAULT_INSTANCE = uVar;
        GeneratedMessageLite.C(u.class, uVar);
    }

    public static void D(u uVar) {
        uVar.getClass();
        uVar.description_ = DEFAULT_INSTANCE.description_;
    }

    public static void E(u uVar) {
        uVar.getClass();
        uVar.id_ = DEFAULT_INSTANCE.id_;
    }

    public static void F(u uVar) {
        uVar.getClass();
        uVar.name_ = DEFAULT_INSTANCE.name_;
    }

    public static void G(u uVar) {
        uVar.getClass();
        uVar.version_ = DEFAULT_INSTANCE.version_;
    }

    public static MapFieldLite H(u uVar) {
        MapFieldLite<String, String> mapFieldLite = uVar.parameters_;
        if (!mapFieldLite.f2856a) {
            uVar.parameters_ = mapFieldLite.h();
        }
        return uVar.parameters_;
    }

    public static void I(u uVar, String str) {
        uVar.getClass();
        str.getClass();
        uVar.description_ = str;
    }

    public static void J(u uVar, ByteString byteString) {
        uVar.getClass();
        AbstractC0932e.g(byteString);
        uVar.description_ = byteString.q();
    }

    public static void K(u uVar, String str) {
        uVar.getClass();
        str.getClass();
        uVar.id_ = str;
    }

    public static void L(u uVar, ByteString byteString) {
        uVar.getClass();
        AbstractC0932e.g(byteString);
        uVar.id_ = byteString.q();
    }

    public static void M(u uVar, String str) {
        uVar.getClass();
        str.getClass();
        uVar.name_ = str;
    }

    public static void N(u uVar, ByteString byteString) {
        uVar.getClass();
        AbstractC0932e.g(byteString);
        uVar.name_ = byteString.q();
    }

    public static void O(u uVar, String str) {
        uVar.getClass();
        str.getClass();
        uVar.version_ = str;
    }

    public static void P(u uVar, ByteString byteString) {
        uVar.getClass();
        AbstractC0932e.g(byteString);
        uVar.version_ = byteString.q();
    }

    public static u R() {
        return DEFAULT_INSTANCE;
    }

    public static Tool$Builder b0(u uVar) {
        return (Tool$Builder) DEFAULT_INSTANCE.q(uVar);
    }

    public final String S() {
        return this.description_;
    }

    public final ByteString T() {
        return ByteString.f(this.description_);
    }

    public final String U() {
        return this.id_;
    }

    public final ByteString V() {
        return ByteString.f(this.id_);
    }

    public final String W() {
        return this.name_;
    }

    public final ByteString X() {
        return ByteString.f(this.name_);
    }

    public final Map Y() {
        return Collections.unmodifiableMap(this.parameters_);
    }

    public final String Z() {
        return this.version_;
    }

    public final ByteString a0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u00052", new Object[]{"id_", "version_", "name_", "description_", "parameters_", t.f6789a});
            case 3:
                return new u();
            case 4:
                return new Tool$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (u.class) {
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
