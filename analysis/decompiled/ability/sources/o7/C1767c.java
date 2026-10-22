package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.AgentTool$Builder;

/* renamed from: o7.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1767c extends GeneratedMessageLite implements Y1 {
    private static final C1767c DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int PARAMETERS_SCHEMA_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER;
    private String name_ = "";
    private String description_ = "";
    private String parametersSchema_ = "";

    static {
        C1767c c1767c = new C1767c();
        DEFAULT_INSTANCE = c1767c;
        GeneratedMessageLite.C(C1767c.class, c1767c);
    }

    public static void D(C1767c c1767c) {
        c1767c.getClass();
        c1767c.description_ = DEFAULT_INSTANCE.description_;
    }

    public static void E(C1767c c1767c) {
        c1767c.getClass();
        c1767c.name_ = DEFAULT_INSTANCE.name_;
    }

    public static void F(C1767c c1767c) {
        c1767c.getClass();
        c1767c.parametersSchema_ = DEFAULT_INSTANCE.parametersSchema_;
    }

    public static void G(C1767c c1767c, String str) {
        c1767c.getClass();
        str.getClass();
        c1767c.description_ = str;
    }

    public static void H(C1767c c1767c, ByteString byteString) {
        c1767c.getClass();
        AbstractC0932e.g(byteString);
        c1767c.description_ = byteString.q();
    }

    public static void I(C1767c c1767c, String str) {
        c1767c.getClass();
        str.getClass();
        c1767c.name_ = str;
    }

    public static void J(C1767c c1767c, ByteString byteString) {
        c1767c.getClass();
        AbstractC0932e.g(byteString);
        c1767c.name_ = byteString.q();
    }

    public static void K(C1767c c1767c, String str) {
        c1767c.getClass();
        str.getClass();
        c1767c.parametersSchema_ = str;
    }

    public static void L(C1767c c1767c, ByteString byteString) {
        c1767c.getClass();
        AbstractC0932e.g(byteString);
        c1767c.parametersSchema_ = byteString.q();
    }

    public static C1767c N() {
        return DEFAULT_INSTANCE;
    }

    public static AgentTool$Builder U(C1767c c1767c) {
        return (AgentTool$Builder) DEFAULT_INSTANCE.q(c1767c);
    }

    public final String O() {
        return this.description_;
    }

    public final ByteString P() {
        return ByteString.f(this.description_);
    }

    public final String Q() {
        return this.name_;
    }

    public final ByteString R() {
        return ByteString.f(this.name_);
    }

    public final String S() {
        return this.parametersSchema_;
    }

    public final ByteString T() {
        return ByteString.f(this.parametersSchema_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"name_", "description_", "parametersSchema_"});
            case 3:
                return new C1767c();
            case 4:
                return new AgentTool$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1767c.class) {
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
