package t7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.omni.AsrResponse$Builder;

/* renamed from: t7.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2019b extends GeneratedMessageLite implements Y1 {
    private static final C2019b DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    private String text_ = "";

    static {
        C2019b c2019b = new C2019b();
        DEFAULT_INSTANCE = c2019b;
        GeneratedMessageLite.C(C2019b.class, c2019b);
    }

    public static void D(C2019b c2019b) {
        c2019b.getClass();
        c2019b.text_ = DEFAULT_INSTANCE.text_;
    }

    public static void E(C2019b c2019b, String str) {
        c2019b.getClass();
        str.getClass();
        c2019b.text_ = str;
    }

    public static void F(C2019b c2019b, ByteString byteString) {
        c2019b.getClass();
        AbstractC0932e.g(byteString);
        c2019b.text_ = byteString.q();
    }

    public final String H() {
        return this.text_;
    }

    public final ByteString I() {
        return ByteString.f(this.text_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"text_"});
            case 3:
                return new C2019b();
            case 4:
                return new AsrResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C2019b.class) {
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
