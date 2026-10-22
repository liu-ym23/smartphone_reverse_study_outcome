package o7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.DirSkillLoader$Builder;

/* renamed from: o7.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1771g extends GeneratedMessageLite implements Y1 {
    private static final C1771g DEFAULT_INSTANCE;
    public static final int IS_SEPARATE_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int PATH_FIELD_NUMBER = 1;
    private int bitField0_;
    private boolean isSeparate_;
    private String path_ = "";

    static {
        C1771g c1771g = new C1771g();
        DEFAULT_INSTANCE = c1771g;
        GeneratedMessageLite.C(C1771g.class, c1771g);
    }

    public static void D(C1771g c1771g) {
        c1771g.bitField0_ &= -2;
        c1771g.isSeparate_ = false;
    }

    public static void E(C1771g c1771g) {
        c1771g.getClass();
        c1771g.path_ = DEFAULT_INSTANCE.path_;
    }

    public static void F(C1771g c1771g, boolean z10) {
        c1771g.bitField0_ |= 1;
        c1771g.isSeparate_ = z10;
    }

    public static void G(C1771g c1771g, String str) {
        c1771g.getClass();
        str.getClass();
        c1771g.path_ = str;
    }

    public static void H(C1771g c1771g, ByteString byteString) {
        c1771g.getClass();
        AbstractC0932e.g(byteString);
        c1771g.path_ = byteString.q();
    }

    public static C1771g J() {
        return DEFAULT_INSTANCE;
    }

    public static DirSkillLoader$Builder O(C1771g c1771g) {
        return (DirSkillLoader$Builder) DEFAULT_INSTANCE.q(c1771g);
    }

    public final boolean K() {
        return this.isSeparate_;
    }

    public final String L() {
        return this.path_;
    }

    public final ByteString M() {
        return ByteString.f(this.path_);
    }

    public final boolean N() {
        return (this.bitField0_ & 1) != 0;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဇ\u0000", new Object[]{"bitField0_", "path_", "isSeparate_"});
            case 3:
                return new C1771g();
            case 4:
                return new DirSkillLoader$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1771g.class) {
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
