package q7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.common.HookDefinition$Builder;
import com.zyql.protobuf.common.HookExecutionMode;
import com.zyql.protobuf.common.HookLayer;
import com.zyql.protobuf.common.HookPoint;

/* renamed from: q7.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1816n extends GeneratedMessageLite implements Y1 {
    private static final C1816n DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int HOOK_POINT_FIELD_NUMBER = 4;
    public static final int LAYER_FIELD_NUMBER = 3;
    public static final int MODE_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TIMEOUT_MS_FIELD_NUMBER = 7;
    public static final int TOOL_NAME_PATTERN_FIELD_NUMBER = 6;
    private int bitField0_;
    private int hookPoint_;
    private int layer_;
    private int mode_;
    private int timeoutMs_;
    private String name_ = "";
    private String description_ = "";
    private String toolNamePattern_ = "";

    static {
        C1816n c1816n = new C1816n();
        DEFAULT_INSTANCE = c1816n;
        GeneratedMessageLite.C(C1816n.class, c1816n);
    }

    public static void D(C1816n c1816n) {
        c1816n.getClass();
        c1816n.description_ = DEFAULT_INSTANCE.description_;
    }

    public static void E(C1816n c1816n) {
        c1816n.hookPoint_ = 0;
    }

    public static void F(C1816n c1816n) {
        c1816n.layer_ = 0;
    }

    public static void G(C1816n c1816n) {
        c1816n.mode_ = 0;
    }

    public static void H(C1816n c1816n) {
        c1816n.getClass();
        c1816n.name_ = DEFAULT_INSTANCE.name_;
    }

    public static void I(C1816n c1816n) {
        c1816n.timeoutMs_ = 0;
    }

    public static void J(C1816n c1816n) {
        c1816n.bitField0_ &= -2;
        c1816n.toolNamePattern_ = DEFAULT_INSTANCE.toolNamePattern_;
    }

    public static void K(C1816n c1816n, String str) {
        c1816n.getClass();
        str.getClass();
        c1816n.description_ = str;
    }

    public static void L(C1816n c1816n, ByteString byteString) {
        c1816n.getClass();
        AbstractC0932e.g(byteString);
        c1816n.description_ = byteString.q();
    }

    public static void M(C1816n c1816n, HookPoint hookPoint) {
        c1816n.getClass();
        c1816n.hookPoint_ = hookPoint.getNumber();
    }

    public static void N(int i, C1816n c1816n) {
        c1816n.hookPoint_ = i;
    }

    public static void O(C1816n c1816n, HookLayer hookLayer) {
        c1816n.getClass();
        c1816n.layer_ = hookLayer.getNumber();
    }

    public static void P(int i, C1816n c1816n) {
        c1816n.layer_ = i;
    }

    public static void Q(C1816n c1816n, HookExecutionMode hookExecutionMode) {
        c1816n.getClass();
        c1816n.mode_ = hookExecutionMode.getNumber();
    }

    public static void R(int i, C1816n c1816n) {
        c1816n.mode_ = i;
    }

    public static void S(C1816n c1816n, String str) {
        c1816n.getClass();
        str.getClass();
        c1816n.name_ = str;
    }

    public static void T(C1816n c1816n, ByteString byteString) {
        c1816n.getClass();
        AbstractC0932e.g(byteString);
        c1816n.name_ = byteString.q();
    }

    public static void U(int i, C1816n c1816n) {
        c1816n.timeoutMs_ = i;
    }

    public static void V(C1816n c1816n, String str) {
        c1816n.getClass();
        str.getClass();
        c1816n.bitField0_ |= 1;
        c1816n.toolNamePattern_ = str;
    }

    public static void W(C1816n c1816n, ByteString byteString) {
        c1816n.getClass();
        AbstractC0932e.g(byteString);
        c1816n.toolNamePattern_ = byteString.q();
        c1816n.bitField0_ |= 1;
    }

    public static C1816n Y() {
        return DEFAULT_INSTANCE;
    }

    public static HookDefinition$Builder n0(C1816n c1816n) {
        return (HookDefinition$Builder) DEFAULT_INSTANCE.q(c1816n);
    }

    public final String Z() {
        return this.description_;
    }

    public final ByteString a0() {
        return ByteString.f(this.description_);
    }

    public final HookPoint b0() {
        HookPoint hookPointA = HookPoint.a(this.hookPoint_);
        return hookPointA == null ? HookPoint.UNRECOGNIZED : hookPointA;
    }

    public final int c0() {
        return this.hookPoint_;
    }

    public final HookLayer d0() {
        HookLayer hookLayerA = HookLayer.a(this.layer_);
        return hookLayerA == null ? HookLayer.UNRECOGNIZED : hookLayerA;
    }

    public final int e0() {
        return this.layer_;
    }

    public final HookExecutionMode f0() {
        int i = this.mode_;
        HookExecutionMode hookExecutionMode = i != 0 ? i != 1 ? i != 2 ? null : HookExecutionMode.HOOK_EXECUTION_MODE_ASYNC : HookExecutionMode.HOOK_EXECUTION_MODE_SYNC : HookExecutionMode.HOOK_EXECUTION_MODE_UNSPECIFIED;
        return hookExecutionMode == null ? HookExecutionMode.UNRECOGNIZED : hookExecutionMode;
    }

    public final int g0() {
        return this.mode_;
    }

    public final String h0() {
        return this.name_;
    }

    public final ByteString i0() {
        return ByteString.f(this.name_);
    }

    public final int j0() {
        return this.timeoutMs_;
    }

    public final String k0() {
        return this.toolNamePattern_;
    }

    public final ByteString l0() {
        return ByteString.f(this.toolNamePattern_);
    }

    public final boolean m0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\f\u0004\f\u0005\f\u0006ለ\u0000\u0007\u0004", new Object[]{"bitField0_", "name_", "description_", "layer_", "hookPoint_", "mode_", "toolNamePattern_", "timeoutMs_"});
            case 3:
                return new C1816n();
            case 4:
                return new HookDefinition$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1816n.class) {
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
