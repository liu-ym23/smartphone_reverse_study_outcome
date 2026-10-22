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
import com.zyql.protobuf.common.ListHooksResponse$Builder;
import java.util.List;

/* renamed from: q7.v, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1823v extends GeneratedMessageLite implements Y1 {
    private static final C1823v DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 2;
    public static final int HOOKS_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER;
    private InterfaceC0985r1 hooks_ = C0967m2.d;
    private String error_ = "";

    static {
        C1823v c1823v = new C1823v();
        DEFAULT_INSTANCE = c1823v;
        GeneratedMessageLite.C(C1823v.class, c1823v);
    }

    public static void D(C1823v c1823v, Iterable iterable) {
        c1823v.N();
        AbstractC0928d.addAll(iterable, (List) c1823v.hooks_);
    }

    public static void E(C1823v c1823v, int i, C1816n c1816n) {
        c1823v.getClass();
        c1816n.getClass();
        c1823v.N();
        c1823v.hooks_.add(i, c1816n);
    }

    public static void F(C1823v c1823v, C1816n c1816n) {
        c1823v.getClass();
        c1816n.getClass();
        c1823v.N();
        c1823v.hooks_.add(c1816n);
    }

    public static void G(C1823v c1823v) {
        c1823v.getClass();
        c1823v.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void H(C1823v c1823v) {
        c1823v.getClass();
        c1823v.hooks_ = C0967m2.d;
    }

    public static void I(C1823v c1823v, int i) {
        c1823v.N();
        c1823v.hooks_.remove(i);
    }

    public static void J(C1823v c1823v, String str) {
        c1823v.getClass();
        str.getClass();
        c1823v.error_ = str;
    }

    public static void K(C1823v c1823v, ByteString byteString) {
        c1823v.getClass();
        AbstractC0932e.g(byteString);
        c1823v.error_ = byteString.q();
    }

    public static void L(C1823v c1823v, int i, C1816n c1816n) {
        c1823v.getClass();
        c1816n.getClass();
        c1823v.N();
        c1823v.hooks_.set(i, c1816n);
    }

    public final void N() {
        InterfaceC0985r1 interfaceC0985r1 = this.hooks_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.hooks_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final String O() {
        return this.error_;
    }

    public final ByteString P() {
        return ByteString.f(this.error_);
    }

    public final C1816n Q(int i) {
        return (C1816n) this.hooks_.get(i);
    }

    public final int R() {
        return this.hooks_.size();
    }

    public final List S() {
        return this.hooks_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002Ȉ", new Object[]{"hooks_", C1816n.class, "error_"});
            case 3:
                return new C1823v();
            case 4:
                return new ListHooksResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1823v.class) {
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
