package q7;

import com.google.protobuf.AbstractC0928d;
import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.AbstractC0940g;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0967m2;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.InterfaceC0985r1;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.Content$Builder;
import java.util.List;

/* renamed from: q7.f, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1808f extends GeneratedMessageLite implements Y1 {
    private static final C1808f DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PARTS_FIELD_NUMBER = 2;
    public static final int ROLE_FIELD_NUMBER = 1;
    private String role_ = "";
    private InterfaceC0985r1 parts_ = C0967m2.d;

    static {
        C1808f c1808f = new C1808f();
        DEFAULT_INSTANCE = c1808f;
        GeneratedMessageLite.C(C1808f.class, c1808f);
    }

    public static void D(C1808f c1808f, Iterable iterable) {
        c1808f.N();
        AbstractC0928d.addAll(iterable, (List) c1808f.parts_);
    }

    public static void E(C1808f c1808f, int i, G g) {
        c1808f.getClass();
        g.getClass();
        c1808f.N();
        c1808f.parts_.add(i, g);
    }

    public static void F(C1808f c1808f, G g) {
        c1808f.getClass();
        g.getClass();
        c1808f.N();
        c1808f.parts_.add(g);
    }

    public static void G(C1808f c1808f) {
        c1808f.getClass();
        c1808f.parts_ = C0967m2.d;
    }

    public static void H(C1808f c1808f) {
        c1808f.getClass();
        c1808f.role_ = DEFAULT_INSTANCE.role_;
    }

    public static void I(int i, C1808f c1808f) {
        c1808f.N();
        c1808f.parts_.remove(i);
    }

    public static void J(C1808f c1808f, int i, G g) {
        c1808f.getClass();
        g.getClass();
        c1808f.N();
        c1808f.parts_.set(i, g);
    }

    public static void K(C1808f c1808f, String str) {
        c1808f.getClass();
        str.getClass();
        c1808f.role_ = str;
    }

    public static void L(C1808f c1808f, ByteString byteString) {
        c1808f.getClass();
        AbstractC0932e.g(byteString);
        c1808f.role_ = byteString.q();
    }

    public static C1808f O() {
        return DEFAULT_INSTANCE;
    }

    public static Content$Builder U() {
        return (Content$Builder) DEFAULT_INSTANCE.p();
    }

    public static Content$Builder V(C1808f c1808f) {
        return (Content$Builder) DEFAULT_INSTANCE.q(c1808f);
    }

    public final void N() {
        InterfaceC0985r1 interfaceC0985r1 = this.parts_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.parts_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final G P(int i) {
        return (G) this.parts_.get(i);
    }

    public final int Q() {
        return this.parts_.size();
    }

    public final List R() {
        return this.parts_;
    }

    public final String S() {
        return this.role_;
    }

    public final ByteString T() {
        return ByteString.f(this.role_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"role_", "parts_", G.class});
            case 3:
                return new C1808f();
            case 4:
                return new Content$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1808f.class) {
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
