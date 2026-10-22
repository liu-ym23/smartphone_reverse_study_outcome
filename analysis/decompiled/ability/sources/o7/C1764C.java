package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Struct;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.ToolProvider$Builder;

/* renamed from: o7.C, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1764C extends GeneratedMessageLite implements Y1 {
    private static final C1764C DEFAULT_INSTANCE;
    public static final int METADATA_FIELD_NUMBER = 5;
    public static final int OVERRIDE_DESCRIPTION_FIELD_NUMBER = 3;
    public static final int OVERRIDE_NAME_FIELD_NUMBER = 2;
    public static final int OVERRIDE_PARAMETERS_SCHEMA_FIELD_NUMBER = 4;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TYPE_FIELD_NUMBER = 1;
    private int bitField0_;
    private Struct metadata_;
    private String type_ = "";
    private String overrideName_ = "";
    private String overrideDescription_ = "";
    private String overrideParametersSchema_ = "";

    static {
        C1764C c1764c = new C1764C();
        DEFAULT_INSTANCE = c1764c;
        GeneratedMessageLite.C(C1764C.class, c1764c);
    }

    public static void D(C1764C c1764c) {
        c1764c.metadata_ = null;
        c1764c.bitField0_ &= -9;
    }

    public static void E(C1764C c1764c) {
        c1764c.bitField0_ &= -3;
        c1764c.overrideDescription_ = DEFAULT_INSTANCE.overrideDescription_;
    }

    public static void F(C1764C c1764c) {
        c1764c.bitField0_ &= -2;
        c1764c.overrideName_ = DEFAULT_INSTANCE.overrideName_;
    }

    public static void G(C1764C c1764c) {
        c1764c.bitField0_ &= -5;
        c1764c.overrideParametersSchema_ = DEFAULT_INSTANCE.overrideParametersSchema_;
    }

    public static void H(C1764C c1764c) {
        c1764c.getClass();
        c1764c.type_ = DEFAULT_INSTANCE.type_;
    }

    public static void I(C1764C c1764c, Struct struct) {
        c1764c.getClass();
        struct.getClass();
        c1764c.metadata_ = struct;
        c1764c.bitField0_ |= 8;
    }

    public static void J(C1764C c1764c, String str) {
        c1764c.getClass();
        str.getClass();
        c1764c.bitField0_ |= 2;
        c1764c.overrideDescription_ = str;
    }

    public static void K(C1764C c1764c, ByteString byteString) {
        c1764c.getClass();
        AbstractC0932e.g(byteString);
        c1764c.overrideDescription_ = byteString.q();
        c1764c.bitField0_ |= 2;
    }

    public static void L(C1764C c1764c, String str) {
        c1764c.getClass();
        str.getClass();
        c1764c.bitField0_ |= 1;
        c1764c.overrideName_ = str;
    }

    public static void M(C1764C c1764c, ByteString byteString) {
        c1764c.getClass();
        AbstractC0932e.g(byteString);
        c1764c.overrideName_ = byteString.q();
        c1764c.bitField0_ |= 1;
    }

    public static void N(C1764C c1764c, String str) {
        c1764c.getClass();
        str.getClass();
        c1764c.bitField0_ |= 4;
        c1764c.overrideParametersSchema_ = str;
    }

    public static void O(C1764C c1764c, ByteString byteString) {
        c1764c.getClass();
        AbstractC0932e.g(byteString);
        c1764c.overrideParametersSchema_ = byteString.q();
        c1764c.bitField0_ |= 4;
    }

    public static void P(C1764C c1764c, String str) {
        c1764c.getClass();
        str.getClass();
        c1764c.type_ = str;
    }

    public static void Q(C1764C c1764c, ByteString byteString) {
        c1764c.getClass();
        AbstractC0932e.g(byteString);
        c1764c.type_ = byteString.q();
    }

    public static C1764C S() {
        return DEFAULT_INSTANCE;
    }

    public static ToolProvider$Builder h0(C1764C c1764c) {
        return (ToolProvider$Builder) DEFAULT_INSTANCE.q(c1764c);
    }

    public final Struct T() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.e : struct;
    }

    public final String U() {
        return this.overrideDescription_;
    }

    public final ByteString V() {
        return ByteString.f(this.overrideDescription_);
    }

    public final String W() {
        return this.overrideName_;
    }

    public final ByteString X() {
        return ByteString.f(this.overrideName_);
    }

    public final String Y() {
        return this.overrideParametersSchema_;
    }

    public final ByteString Z() {
        return ByteString.f(this.overrideParametersSchema_);
    }

    public final String a0() {
        return this.type_;
    }

    public final ByteString b0() {
        return ByteString.f(this.type_);
    }

    public final boolean c0() {
        return (this.bitField0_ & 8) != 0;
    }

    public final boolean d0() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean e0() {
        return (this.bitField0_ & 1) != 0;
    }

    public final boolean f0() {
        return (this.bitField0_ & 4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g0(Struct struct) {
        struct.getClass();
        Struct struct2 = this.metadata_;
        if (struct2 == null || struct2 == Struct.e) {
            this.metadata_ = struct;
        } else {
            this.metadata_ = (Struct) ((C1014y2) Struct.F(struct2).mergeFrom((GeneratedMessageLite) struct)).m();
        }
        this.bitField0_ |= 8;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002ለ\u0000\u0003ለ\u0001\u0004ለ\u0002\u0005ဉ\u0003", new Object[]{"bitField0_", "type_", "overrideName_", "overrideDescription_", "overrideParametersSchema_", "metadata_"});
            case 3:
                return new C1764C();
            case 4:
                return new ToolProvider$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1764C.class) {
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
