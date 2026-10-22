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
import com.zyql.protobuf.common.StoreListResponse$Builder;
import java.util.List;

/* loaded from: classes2.dex */
public final class W extends GeneratedMessageLite implements Y1 {
    private static final W DEFAULT_INSTANCE;
    public static final int KEYS_FIELD_NUMBER = 1;
    public static final int NEXT_CURSOR_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER;
    private InterfaceC0985r1 keys_ = C0967m2.d;
    private String nextCursor_ = "";

    static {
        W w8 = new W();
        DEFAULT_INSTANCE = w8;
        GeneratedMessageLite.C(W.class, w8);
    }

    public static void D(W w8, Iterable iterable) {
        w8.M();
        AbstractC0928d.addAll(iterable, (List) w8.keys_);
    }

    public static void E(W w8, String str) {
        w8.getClass();
        str.getClass();
        w8.M();
        w8.keys_.add(str);
    }

    public static void F(W w8, ByteString byteString) {
        w8.getClass();
        AbstractC0932e.g(byteString);
        w8.M();
        w8.keys_.add(byteString.q());
    }

    public static void G(W w8) {
        w8.getClass();
        w8.keys_ = C0967m2.d;
    }

    public static void H(W w8) {
        w8.getClass();
        w8.nextCursor_ = DEFAULT_INSTANCE.nextCursor_;
    }

    public static void I(W w8, int i, String str) {
        w8.getClass();
        str.getClass();
        w8.M();
        w8.keys_.set(i, str);
    }

    public static void J(W w8, String str) {
        w8.getClass();
        str.getClass();
        w8.nextCursor_ = str;
    }

    public static void K(W w8, ByteString byteString) {
        w8.getClass();
        AbstractC0932e.g(byteString);
        w8.nextCursor_ = byteString.q();
    }

    public final void M() {
        InterfaceC0985r1 interfaceC0985r1 = this.keys_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.keys_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final String N(int i) {
        return (String) this.keys_.get(i);
    }

    public final ByteString O(int i) {
        return ByteString.f((String) this.keys_.get(i));
    }

    public final int P() {
        return this.keys_.size();
    }

    public final List Q() {
        return this.keys_;
    }

    public final String R() {
        return this.nextCursor_;
    }

    public final ByteString S() {
        return ByteString.f(this.nextCursor_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ț\u0002Ȉ", new Object[]{"keys_", "nextCursor_"});
            case 3:
                return new W();
            case 4:
                return new StoreListResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (W.class) {
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
