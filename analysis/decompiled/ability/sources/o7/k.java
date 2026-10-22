package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.FileContent$Builder;

/* loaded from: classes2.dex */
public final class k extends GeneratedMessageLite implements Y1 {
    public static final int CONTENT_FIELD_NUMBER = 2;
    private static final k DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PATH_FIELD_NUMBER = 1;
    private String path_ = "";
    private ByteString content_ = ByteString.b;

    static {
        k kVar = new k();
        DEFAULT_INSTANCE = kVar;
        GeneratedMessageLite.C(k.class, kVar);
    }

    public static void D(k kVar) {
        kVar.getClass();
        kVar.content_ = DEFAULT_INSTANCE.content_;
    }

    public static void E(k kVar) {
        kVar.getClass();
        kVar.path_ = DEFAULT_INSTANCE.path_;
    }

    public static void F(k kVar, ByteString byteString) {
        kVar.getClass();
        byteString.getClass();
        kVar.content_ = byteString;
    }

    public static void G(k kVar, String str) {
        kVar.getClass();
        str.getClass();
        kVar.path_ = str;
    }

    public static void H(k kVar, ByteString byteString) {
        kVar.getClass();
        AbstractC0932e.g(byteString);
        kVar.path_ = byteString.q();
    }

    public final ByteString J() {
        return this.content_;
    }

    public final String K() {
        return this.path_;
    }

    public final ByteString L() {
        return ByteString.f(this.path_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\n", new Object[]{"path_", "content_"});
            case 3:
                return new k();
            case 4:
                return new FileContent$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (k.class) {
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
