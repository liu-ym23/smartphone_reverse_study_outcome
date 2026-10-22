package v7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Tool$Builder;
import com.zyql.protobuf.skull.ToolCall$Builder;
import com.zyql.protobuf.skull.ToolCallParams$Builder;
import com.zyql.protobuf.skull.ToolCallResult$Builder;

/* loaded from: classes2.dex */
public final class v extends GeneratedMessageLite implements Y1 {
    public static final int CALL_ID_FIELD_NUMBER = 1;
    private static final v DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int RESULT_FIELD_NUMBER = 4;
    public static final int TOOL_FIELD_NUMBER = 2;
    private int bitField0_;
    private String callId_ = "";
    private w params_;
    private x result_;
    private u tool_;

    static {
        v vVar = new v();
        DEFAULT_INSTANCE = vVar;
        GeneratedMessageLite.C(v.class, vVar);
    }

    public static void D(v vVar) {
        vVar.getClass();
        vVar.callId_ = DEFAULT_INSTANCE.callId_;
    }

    public static void E(v vVar) {
        vVar.params_ = null;
        vVar.bitField0_ &= -3;
    }

    public static void F(v vVar) {
        vVar.result_ = null;
        vVar.bitField0_ &= -5;
    }

    public static void G(v vVar) {
        vVar.tool_ = null;
        vVar.bitField0_ &= -2;
    }

    public static void H(v vVar, w wVar) {
        vVar.getClass();
        wVar.getClass();
        w wVar2 = vVar.params_;
        if (wVar2 == null || wVar2 == w.H()) {
            vVar.params_ = wVar;
        } else {
            vVar.params_ = (w) ((ToolCallParams$Builder) w.K(vVar.params_).mergeFrom((GeneratedMessageLite) wVar)).m();
        }
        vVar.bitField0_ |= 2;
    }

    public static void I(v vVar, x xVar) {
        vVar.getClass();
        xVar.getClass();
        x xVar2 = vVar.result_;
        if (xVar2 == null || xVar2 == x.H()) {
            vVar.result_ = xVar;
        } else {
            vVar.result_ = (x) ((ToolCallResult$Builder) x.K(vVar.result_).mergeFrom((GeneratedMessageLite) xVar)).m();
        }
        vVar.bitField0_ |= 4;
    }

    public static void J(v vVar, u uVar) {
        vVar.getClass();
        uVar.getClass();
        u uVar2 = vVar.tool_;
        if (uVar2 == null || uVar2 == u.R()) {
            vVar.tool_ = uVar;
        } else {
            vVar.tool_ = (u) ((Tool$Builder) u.b0(vVar.tool_).mergeFrom((GeneratedMessageLite) uVar)).m();
        }
        vVar.bitField0_ |= 1;
    }

    public static void K(String str, v vVar) {
        vVar.getClass();
        str.getClass();
        vVar.callId_ = str;
    }

    public static void L(v vVar, ByteString byteString) {
        vVar.getClass();
        AbstractC0932e.g(byteString);
        vVar.callId_ = byteString.q();
    }

    public static void M(v vVar, w wVar) {
        vVar.getClass();
        wVar.getClass();
        vVar.params_ = wVar;
        vVar.bitField0_ |= 2;
    }

    public static void N(v vVar, x xVar) {
        vVar.getClass();
        xVar.getClass();
        vVar.result_ = xVar;
        vVar.bitField0_ |= 4;
    }

    public static void O(v vVar, u uVar) {
        vVar.getClass();
        uVar.getClass();
        vVar.tool_ = uVar;
        vVar.bitField0_ |= 1;
    }

    public static v S() {
        return DEFAULT_INSTANCE;
    }

    public static ToolCall$Builder Z(v vVar) {
        return (ToolCall$Builder) DEFAULT_INSTANCE.q(vVar);
    }

    public static v a0(ByteString byteString) {
        return (v) GeneratedMessageLite.z(DEFAULT_INSTANCE, byteString);
    }

    public final String Q() {
        return this.callId_;
    }

    public final ByteString R() {
        return ByteString.f(this.callId_);
    }

    public final w T() {
        w wVar = this.params_;
        return wVar == null ? w.H() : wVar;
    }

    public final x U() {
        x xVar = this.result_;
        return xVar == null ? x.H() : xVar;
    }

    public final u V() {
        u uVar = this.tool_;
        return uVar == null ? u.R() : uVar;
    }

    public final boolean W() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean X() {
        return (this.bitField0_ & 4) != 0;
    }

    public final boolean Y() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002", new Object[]{"bitField0_", "callId_", "tool_", "params_", "result_"});
            case 3:
                return new v();
            case 4:
                return new ToolCall$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (v.class) {
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
