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
import com.zyql.protobuf.common.FunctionResponse$Builder;

/* renamed from: q7.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1811i extends GeneratedMessageLite implements Y1 {
    private static final C1811i DEFAULT_INSTANCE;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int RESPONSE_FIELD_NUMBER = 3;
    private int bitField0_;
    private String id_ = "";
    private String name_ = "";
    private Struct response_;

    static {
        C1811i c1811i = new C1811i();
        DEFAULT_INSTANCE = c1811i;
        GeneratedMessageLite.C(C1811i.class, c1811i);
    }

    public static void D(C1811i c1811i) {
        c1811i.getClass();
        c1811i.id_ = DEFAULT_INSTANCE.id_;
    }

    public static void E(C1811i c1811i) {
        c1811i.getClass();
        c1811i.name_ = DEFAULT_INSTANCE.name_;
    }

    public static void F(C1811i c1811i) {
        c1811i.response_ = null;
        c1811i.bitField0_ &= -2;
    }

    public static void G(C1811i c1811i, String str) {
        c1811i.getClass();
        str.getClass();
        c1811i.id_ = str;
    }

    public static void H(C1811i c1811i, ByteString byteString) {
        c1811i.getClass();
        AbstractC0932e.g(byteString);
        c1811i.id_ = byteString.q();
    }

    public static void I(C1811i c1811i, String str) {
        c1811i.getClass();
        str.getClass();
        c1811i.name_ = str;
    }

    public static void J(C1811i c1811i, ByteString byteString) {
        c1811i.getClass();
        AbstractC0932e.g(byteString);
        c1811i.name_ = byteString.q();
    }

    public static void K(C1811i c1811i, Struct struct) {
        c1811i.getClass();
        struct.getClass();
        c1811i.response_ = struct;
        c1811i.bitField0_ |= 1;
    }

    public static C1811i M() {
        return DEFAULT_INSTANCE;
    }

    public static FunctionResponse$Builder U(C1811i c1811i) {
        return (FunctionResponse$Builder) DEFAULT_INSTANCE.q(c1811i);
    }

    public final String N() {
        return this.id_;
    }

    public final ByteString O() {
        return ByteString.f(this.id_);
    }

    public final String P() {
        return this.name_;
    }

    public final ByteString Q() {
        return ByteString.f(this.name_);
    }

    public final Struct R() {
        Struct struct = this.response_;
        return struct == null ? Struct.e : struct;
    }

    public final boolean S() {
        return (this.bitField0_ & 1) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void T(Struct struct) {
        struct.getClass();
        Struct struct2 = this.response_;
        if (struct2 == null || struct2 == Struct.e) {
            this.response_ = struct;
        } else {
            this.response_ = (Struct) ((C1014y2) Struct.F(struct2).mergeFrom((GeneratedMessageLite) struct)).m();
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003ဉ\u0000", new Object[]{"bitField0_", "id_", "name_", "response_"});
            case 3:
                return new C1811i();
            case 4:
                return new FunctionResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1811i.class) {
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
