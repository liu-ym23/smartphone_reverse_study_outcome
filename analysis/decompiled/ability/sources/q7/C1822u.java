package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.HookLayer;
import com.zyql.protobuf.common.HookPoint;
import com.zyql.protobuf.common.ListHooksRequest$Builder;

/* renamed from: q7.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1822u extends GeneratedMessageLite implements Y1 {
    private static final C1822u DEFAULT_INSTANCE;
    public static final int HOOK_POINT_FIELD_NUMBER = 2;
    public static final int LAYER_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 3;
    private int hookPoint_;
    private int layer_;
    private String sessionId_ = "";

    static {
        C1822u c1822u = new C1822u();
        DEFAULT_INSTANCE = c1822u;
        GeneratedMessageLite.C(C1822u.class, c1822u);
    }

    public static void D(C1822u c1822u) {
        c1822u.hookPoint_ = 0;
    }

    public static void E(C1822u c1822u) {
        c1822u.layer_ = 0;
    }

    public static void F(C1822u c1822u) {
        c1822u.getClass();
        c1822u.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void G(C1822u c1822u, HookPoint hookPoint) {
        c1822u.getClass();
        c1822u.hookPoint_ = hookPoint.getNumber();
    }

    public static void H(C1822u c1822u, int i) {
        c1822u.hookPoint_ = i;
    }

    public static void I(C1822u c1822u, HookLayer hookLayer) {
        c1822u.getClass();
        c1822u.layer_ = hookLayer.getNumber();
    }

    public static void J(C1822u c1822u, int i) {
        c1822u.layer_ = i;
    }

    public static void K(C1822u c1822u, String str) {
        c1822u.getClass();
        str.getClass();
        c1822u.sessionId_ = str;
    }

    public static void L(C1822u c1822u, ByteString byteString) {
        c1822u.getClass();
        AbstractC0932e.g(byteString);
        c1822u.sessionId_ = byteString.q();
    }

    public final HookPoint N() {
        HookPoint hookPointA = HookPoint.a(this.hookPoint_);
        return hookPointA == null ? HookPoint.UNRECOGNIZED : hookPointA;
    }

    public final int O() {
        return this.hookPoint_;
    }

    public final HookLayer P() {
        HookLayer hookLayerA = HookLayer.a(this.layer_);
        return hookLayerA == null ? HookLayer.UNRECOGNIZED : hookLayerA;
    }

    public final int Q() {
        return this.layer_;
    }

    public final String R() {
        return this.sessionId_;
    }

    public final ByteString S() {
        return ByteString.f(this.sessionId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003Ȉ", new Object[]{"layer_", "hookPoint_", "sessionId_"});
            case 3:
                return new C1822u();
            case 4:
                return new ListHooksRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1822u.class) {
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
