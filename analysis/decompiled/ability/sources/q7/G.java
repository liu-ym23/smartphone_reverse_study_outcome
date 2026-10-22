package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.Blob$Builder;
import com.zyql.protobuf.common.FileData$Builder;
import com.zyql.protobuf.common.FunctionCall$Builder;
import com.zyql.protobuf.common.FunctionResponse$Builder;
import com.zyql.protobuf.common.Part$Builder;
import com.zyql.protobuf.common.Part$ContentCase;

/* loaded from: classes2.dex */
public final class G extends GeneratedMessageLite implements Y1 {
    private static final G DEFAULT_INSTANCE;
    public static final int FILE_DATA_FIELD_NUMBER = 5;
    public static final int FUNCTION_CALL_FIELD_NUMBER = 3;
    public static final int FUNCTION_RESPONSE_FIELD_NUMBER = 4;
    public static final int INLINE_DATA_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TEXT_FIELD_NUMBER = 1;
    public static final int THOUGHT_FIELD_NUMBER = 10;
    private int contentCase_ = 0;
    private Object content_;
    private boolean thought_;

    static {
        G g = new G();
        DEFAULT_INSTANCE = g;
        GeneratedMessageLite.C(G.class, g);
    }

    public static void D(G g) {
        g.contentCase_ = 0;
        g.content_ = null;
    }

    public static void E(G g) {
        if (g.contentCase_ == 5) {
            g.contentCase_ = 0;
            g.content_ = null;
        }
    }

    public static void F(G g) {
        if (g.contentCase_ == 3) {
            g.contentCase_ = 0;
            g.content_ = null;
        }
    }

    public static void G(G g) {
        if (g.contentCase_ == 4) {
            g.contentCase_ = 0;
            g.content_ = null;
        }
    }

    public static void H(G g) {
        if (g.contentCase_ == 2) {
            g.contentCase_ = 0;
            g.content_ = null;
        }
    }

    public static void I(G g) {
        if (g.contentCase_ == 1) {
            g.contentCase_ = 0;
            g.content_ = null;
        }
    }

    public static void J(G g) {
        g.thought_ = false;
    }

    public static void K(G g, C1809g c1809g) {
        g.getClass();
        c1809g.getClass();
        if (g.contentCase_ != 5 || g.content_ == C1809g.N()) {
            g.content_ = c1809g;
        } else {
            g.content_ = ((FileData$Builder) C1809g.V((C1809g) g.content_).mergeFrom((GeneratedMessageLite) c1809g)).m();
        }
        g.contentCase_ = 5;
    }

    public static void L(G g, C1810h c1810h) {
        g.getClass();
        c1810h.getClass();
        if (g.contentCase_ != 3 || g.content_ == C1810h.N()) {
            g.content_ = c1810h;
        } else {
            g.content_ = ((FunctionCall$Builder) C1810h.U((C1810h) g.content_).mergeFrom((GeneratedMessageLite) c1810h)).m();
        }
        g.contentCase_ = 3;
    }

    public static void M(G g, C1811i c1811i) {
        g.getClass();
        c1811i.getClass();
        if (g.contentCase_ != 4 || g.content_ == C1811i.M()) {
            g.content_ = c1811i;
        } else {
            g.content_ = ((FunctionResponse$Builder) C1811i.U((C1811i) g.content_).mergeFrom((GeneratedMessageLite) c1811i)).m();
        }
        g.contentCase_ = 4;
    }

    public static void N(G g, C1807e c1807e) {
        g.getClass();
        c1807e.getClass();
        if (g.contentCase_ != 2 || g.content_ == C1807e.N()) {
            g.content_ = c1807e;
        } else {
            g.content_ = ((Blob$Builder) C1807e.S((C1807e) g.content_).mergeFrom((GeneratedMessageLite) c1807e)).m();
        }
        g.contentCase_ = 2;
    }

    public static void O(G g, C1809g c1809g) {
        g.getClass();
        c1809g.getClass();
        g.content_ = c1809g;
        g.contentCase_ = 5;
    }

    public static void P(G g, C1810h c1810h) {
        g.getClass();
        c1810h.getClass();
        g.content_ = c1810h;
        g.contentCase_ = 3;
    }

    public static void Q(G g, C1811i c1811i) {
        g.getClass();
        c1811i.getClass();
        g.content_ = c1811i;
        g.contentCase_ = 4;
    }

    public static void R(G g, C1807e c1807e) {
        g.getClass();
        c1807e.getClass();
        g.content_ = c1807e;
        g.contentCase_ = 2;
    }

    public static void S(G g, String str) {
        g.getClass();
        str.getClass();
        g.contentCase_ = 1;
        g.content_ = str;
    }

    public static void T(G g, ByteString byteString) {
        g.getClass();
        AbstractC0932e.g(byteString);
        g.content_ = byteString.q();
        g.contentCase_ = 1;
    }

    public static void U(G g, boolean z10) {
        g.thought_ = z10;
    }

    public static Part$Builder j0() {
        return (Part$Builder) DEFAULT_INSTANCE.p();
    }

    public final Part$ContentCase W() {
        int i = this.contentCase_;
        if (i == 0) {
            return Part$ContentCase.f;
        }
        if (i == 1) {
            return Part$ContentCase.f4266a;
        }
        if (i == 2) {
            return Part$ContentCase.b;
        }
        if (i == 3) {
            return Part$ContentCase.c;
        }
        if (i == 4) {
            return Part$ContentCase.d;
        }
        if (i != 5) {
            return null;
        }
        return Part$ContentCase.e;
    }

    public final C1809g X() {
        return this.contentCase_ == 5 ? (C1809g) this.content_ : C1809g.N();
    }

    public final C1810h Y() {
        return this.contentCase_ == 3 ? (C1810h) this.content_ : C1810h.N();
    }

    public final C1811i Z() {
        return this.contentCase_ == 4 ? (C1811i) this.content_ : C1811i.M();
    }

    public final C1807e a0() {
        return this.contentCase_ == 2 ? (C1807e) this.content_ : C1807e.N();
    }

    public final String b0() {
        return this.contentCase_ == 1 ? (String) this.content_ : "";
    }

    public final ByteString c0() {
        return ByteString.f(this.contentCase_ == 1 ? (String) this.content_ : "");
    }

    public final boolean d0() {
        return this.thought_;
    }

    public final boolean e0() {
        return this.contentCase_ == 5;
    }

    public final boolean f0() {
        return this.contentCase_ == 3;
    }

    public final boolean g0() {
        return this.contentCase_ == 4;
    }

    public final boolean h0() {
        return this.contentCase_ == 2;
    }

    public final boolean i0() {
        return this.contentCase_ == 1;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\n\u0006\u0000\u0000\u0000\u0001Ȼ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\n\u0007", new Object[]{"content_", "contentCase_", C1807e.class, C1810h.class, C1811i.class, C1809g.class, "thought_"});
            case 3:
                return new G();
            case 4:
                return new Part$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (G.class) {
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
