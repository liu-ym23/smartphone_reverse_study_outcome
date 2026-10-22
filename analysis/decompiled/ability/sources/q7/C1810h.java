package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Struct;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.FunctionCall$Builder;

/* renamed from: q7.h, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1810h extends GeneratedMessageLite implements Y1 {
    public static final int ARGS_FIELD_NUMBER = 3;
    private static final C1810h DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER;
    private Struct args_;
    private int bitField0_;
    private String id_ = "";
    private String name_ = "";

    static {
        C1810h c1810h = new C1810h();
        DEFAULT_INSTANCE = c1810h;
        GeneratedMessageLite.C(C1810h.class, c1810h);
    }

    public static void D(C1810h c1810h) {
        c1810h.args_ = null;
        c1810h.bitField0_ &= -2;
    }

    public static void E(C1810h c1810h) {
        c1810h.getClass();
        c1810h.id_ = DEFAULT_INSTANCE.id_;
    }

    public static void F(C1810h c1810h) {
        c1810h.getClass();
        c1810h.name_ = DEFAULT_INSTANCE.name_;
    }

    public static void G(C1810h c1810h, Struct struct) {
        c1810h.getClass();
        struct.getClass();
        c1810h.args_ = struct;
        c1810h.bitField0_ |= 1;
    }

    public static void H(C1810h c1810h, String str) {
        c1810h.getClass();
        str.getClass();
        c1810h.id_ = str;
    }

    public static void I(C1810h c1810h, ByteString byteString) {
        c1810h.getClass();
        AbstractC0932e.g(byteString);
        c1810h.id_ = byteString.q();
    }

    public static void J(C1810h c1810h, String str) {
        c1810h.getClass();
        str.getClass();
        c1810h.name_ = str;
    }

    public static void K(C1810h c1810h, ByteString byteString) {
        c1810h.getClass();
        AbstractC0932e.g(byteString);
        c1810h.name_ = byteString.q();
    }

    public static C1810h N() {
        return DEFAULT_INSTANCE;
    }

    public static FunctionCall$Builder U(C1810h c1810h) {
        return (FunctionCall$Builder) DEFAULT_INSTANCE.q(c1810h);
    }

    public final Struct M() {
        Struct struct = this.args_;
        return struct == null ? Struct.e : struct;
    }

    public final String O() {
        return this.id_;
    }

    public final ByteString P() {
        return ByteString.f(this.id_);
    }

    public final String Q() {
        return this.name_;
    }

    public final ByteString R() {
        return ByteString.f(this.name_);
    }

    public final boolean S() {
        return (this.bitField0_ & 1) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T(Struct struct) {
        struct.getClass();
        Struct struct2 = this.args_;
        if (struct2 == null || struct2 == Struct.e) {
            this.args_ = struct;
        } else {
            this.args_ = (Struct) ((C1014y2) Struct.F(struct2).mergeFrom((GeneratedMessageLite) struct)).m();
        }
        this.bitField0_ |= 1;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000", new Object[]{"bitField0_", "id_", "name_", "args_"});
            case 3:
                return new C1810h();
            case 4:
                return new FunctionCall$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1810h.class) {
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
