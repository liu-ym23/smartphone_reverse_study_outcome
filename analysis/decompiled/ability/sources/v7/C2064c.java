package v7;

import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.AskInput$Builder;
import com.zyql.protobuf.skull.Message$Builder;
import java.util.Collections;
import java.util.Map;

/* renamed from: v7.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2064c extends GeneratedMessageLite implements Y1 {
    private static final C2064c DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER;
    private int bitField0_;
    private i message_;
    private MapFieldLite<String, String> params_ = MapFieldLite.b;

    static {
        C2064c c2064c = new C2064c();
        DEFAULT_INSTANCE = c2064c;
        GeneratedMessageLite.C(C2064c.class, c2064c);
    }

    public static void D(C2064c c2064c) {
        c2064c.message_ = null;
        c2064c.bitField0_ &= -2;
    }

    public static MapFieldLite E(C2064c c2064c) {
        MapFieldLite<String, String> mapFieldLite = c2064c.params_;
        if (!mapFieldLite.f2856a) {
            c2064c.params_ = mapFieldLite.h();
        }
        return c2064c.params_;
    }

    public static void F(C2064c c2064c, i iVar) {
        c2064c.getClass();
        iVar.getClass();
        i iVar2 = c2064c.message_;
        if (iVar2 == null || iVar2 == i.T()) {
            c2064c.message_ = iVar;
        } else {
            c2064c.message_ = (i) ((Message$Builder) i.a0(c2064c.message_).mergeFrom((GeneratedMessageLite) iVar)).m();
        }
        c2064c.bitField0_ |= 1;
    }

    public static void G(C2064c c2064c, i iVar) {
        c2064c.getClass();
        iVar.getClass();
        c2064c.message_ = iVar;
        c2064c.bitField0_ |= 1;
    }

    public static C2064c I() {
        return DEFAULT_INSTANCE;
    }

    public static AskInput$Builder M(C2064c c2064c) {
        return (AskInput$Builder) DEFAULT_INSTANCE.q(c2064c);
    }

    public final i J() {
        i iVar = this.message_;
        return iVar == null ? i.T() : iVar;
    }

    public final Map K() {
        return Collections.unmodifiableMap(this.params_);
    }

    public final boolean L() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0001\u0000\u0000\u00012\u0002ဉ\u0000", new Object[]{"bitField0_", "params_", AbstractC2063b.f6785a, "message_"});
            case 3:
                return new C2064c();
            case 4:
                return new AskInput$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C2064c.class) {
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
