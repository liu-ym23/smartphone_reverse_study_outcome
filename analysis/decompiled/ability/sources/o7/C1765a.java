package o7;

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
import com.zyql.protobuf.agent.AgentInfo$Builder;
import com.zyql.protobuf.agent.ModelConfig$Builder;
import java.util.List;
import q7.C1816n;

/* renamed from: o7.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1765a extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    private static final C1765a DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 4;
    public static final int HOOKS_FIELD_NUMBER = 10;
    public static final int INSTRUCTIONS_FIELD_NUMBER = 6;
    public static final int MODEL_CONFIG_FIELD_NUMBER = 5;
    public static final int NAME_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SKILLS_FIELD_NUMBER = 11;
    public static final int SUB_AGENTS_FIELD_NUMBER = 7;
    public static final int TOOLS_FIELD_NUMBER = 8;
    public static final int VERSION_FIELD_NUMBER = 3;
    private int bitField0_;
    private InterfaceC0985r1 hooks_;
    private v modelConfig_;
    private InterfaceC0985r1 skills_;
    private InterfaceC0985r1 subAgents_;
    private InterfaceC0985r1 tools_;
    private String agentId_ = "";
    private String name_ = "";
    private String version_ = "";
    private String description_ = "";
    private String instructions_ = "";

    static {
        C1765a c1765a = new C1765a();
        DEFAULT_INSTANCE = c1765a;
        GeneratedMessageLite.C(C1765a.class, c1765a);
    }

    public C1765a() {
        C0967m2 c0967m2 = C0967m2.d;
        this.subAgents_ = c0967m2;
        this.tools_ = c0967m2;
        this.hooks_ = c0967m2;
        this.skills_ = c0967m2;
    }

    public static C1765a A0() {
        return DEFAULT_INSTANCE;
    }

    public static void D(C1765a c1765a, Iterable iterable) {
        c1765a.u0();
        AbstractC0928d.addAll(iterable, (List) c1765a.hooks_);
    }

    public static void E(C1765a c1765a, Iterable iterable) {
        c1765a.v0();
        AbstractC0928d.addAll(iterable, (List) c1765a.skills_);
    }

    public static void F(C1765a c1765a, Iterable iterable) {
        c1765a.w0();
        AbstractC0928d.addAll(iterable, (List) c1765a.subAgents_);
    }

    public static void G(C1765a c1765a, Iterable iterable) {
        c1765a.x0();
        AbstractC0928d.addAll(iterable, (List) c1765a.tools_);
    }

    public static void H(C1765a c1765a, int i, C1816n c1816n) {
        c1765a.getClass();
        c1816n.getClass();
        c1765a.u0();
        c1765a.hooks_.add(i, c1816n);
    }

    public static void I(C1765a c1765a, C1816n c1816n) {
        c1765a.getClass();
        c1816n.getClass();
        c1765a.u0();
        c1765a.hooks_.add(c1816n);
    }

    public static void J(C1765a c1765a, int i, x xVar) {
        c1765a.getClass();
        xVar.getClass();
        c1765a.v0();
        c1765a.skills_.add(i, xVar);
    }

    public static void K(C1765a c1765a, x xVar) {
        c1765a.getClass();
        xVar.getClass();
        c1765a.v0();
        c1765a.skills_.add(xVar);
    }

    public static void L(C1765a c1765a, int i, C1765a c1765a2) {
        c1765a.getClass();
        c1765a2.getClass();
        c1765a.w0();
        c1765a.subAgents_.add(i, c1765a2);
    }

    public static void M(C1765a c1765a, C1765a c1765a2) {
        c1765a.getClass();
        c1765a2.getClass();
        c1765a.w0();
        c1765a.subAgents_.add(c1765a2);
    }

    public static void N(C1765a c1765a, int i, z zVar) {
        c1765a.getClass();
        zVar.getClass();
        c1765a.x0();
        c1765a.tools_.add(i, zVar);
    }

    public static void O(C1765a c1765a, z zVar) {
        c1765a.getClass();
        zVar.getClass();
        c1765a.x0();
        c1765a.tools_.add(zVar);
    }

    public static void P(C1765a c1765a) {
        c1765a.getClass();
        c1765a.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void Q(C1765a c1765a) {
        c1765a.getClass();
        c1765a.description_ = DEFAULT_INSTANCE.description_;
    }

    public static void R(C1765a c1765a) {
        c1765a.getClass();
        c1765a.hooks_ = C0967m2.d;
    }

    public static void S(C1765a c1765a) {
        c1765a.getClass();
        c1765a.instructions_ = DEFAULT_INSTANCE.instructions_;
    }

    public static void T(C1765a c1765a) {
        c1765a.modelConfig_ = null;
        c1765a.bitField0_ &= -2;
    }

    public static void U(C1765a c1765a) {
        c1765a.getClass();
        c1765a.name_ = DEFAULT_INSTANCE.name_;
    }

    public static void V(C1765a c1765a) {
        c1765a.getClass();
        c1765a.skills_ = C0967m2.d;
    }

    public static void W(C1765a c1765a) {
        c1765a.getClass();
        c1765a.subAgents_ = C0967m2.d;
    }

    public static void X(C1765a c1765a) {
        c1765a.getClass();
        c1765a.tools_ = C0967m2.d;
    }

    public static AgentInfo$Builder X0(C1765a c1765a) {
        return (AgentInfo$Builder) DEFAULT_INSTANCE.q(c1765a);
    }

    public static void Y(C1765a c1765a) {
        c1765a.getClass();
        c1765a.version_ = DEFAULT_INSTANCE.version_;
    }

    public static void Z(C1765a c1765a, v vVar) {
        c1765a.getClass();
        vVar.getClass();
        v vVar2 = c1765a.modelConfig_;
        if (vVar2 == null || vVar2 == v.X()) {
            c1765a.modelConfig_ = vVar;
        } else {
            c1765a.modelConfig_ = (v) ((ModelConfig$Builder) v.n0(c1765a.modelConfig_).mergeFrom((GeneratedMessageLite) vVar)).m();
        }
        c1765a.bitField0_ |= 1;
    }

    public static void a0(int i, C1765a c1765a) {
        c1765a.u0();
        c1765a.hooks_.remove(i);
    }

    public static void b0(int i, C1765a c1765a) {
        c1765a.v0();
        c1765a.skills_.remove(i);
    }

    public static void c0(int i, C1765a c1765a) {
        c1765a.w0();
        c1765a.subAgents_.remove(i);
    }

    public static void d0(int i, C1765a c1765a) {
        c1765a.x0();
        c1765a.tools_.remove(i);
    }

    public static void e0(C1765a c1765a, String str) {
        c1765a.getClass();
        str.getClass();
        c1765a.agentId_ = str;
    }

    public static void f0(C1765a c1765a, ByteString byteString) {
        c1765a.getClass();
        AbstractC0932e.g(byteString);
        c1765a.agentId_ = byteString.q();
    }

    public static void g0(C1765a c1765a, String str) {
        c1765a.getClass();
        str.getClass();
        c1765a.description_ = str;
    }

    public static void h0(C1765a c1765a, ByteString byteString) {
        c1765a.getClass();
        AbstractC0932e.g(byteString);
        c1765a.description_ = byteString.q();
    }

    public static void i0(C1765a c1765a, int i, C1816n c1816n) {
        c1765a.getClass();
        c1816n.getClass();
        c1765a.u0();
        c1765a.hooks_.set(i, c1816n);
    }

    public static void j0(C1765a c1765a, String str) {
        c1765a.getClass();
        str.getClass();
        c1765a.instructions_ = str;
    }

    public static void k0(C1765a c1765a, ByteString byteString) {
        c1765a.getClass();
        AbstractC0932e.g(byteString);
        c1765a.instructions_ = byteString.q();
    }

    public static void l0(C1765a c1765a, v vVar) {
        c1765a.getClass();
        vVar.getClass();
        c1765a.modelConfig_ = vVar;
        c1765a.bitField0_ |= 1;
    }

    public static void m0(C1765a c1765a, String str) {
        c1765a.getClass();
        str.getClass();
        c1765a.name_ = str;
    }

    public static void n0(C1765a c1765a, ByteString byteString) {
        c1765a.getClass();
        AbstractC0932e.g(byteString);
        c1765a.name_ = byteString.q();
    }

    public static void o0(C1765a c1765a, int i, x xVar) {
        c1765a.getClass();
        xVar.getClass();
        c1765a.v0();
        c1765a.skills_.set(i, xVar);
    }

    public static void p0(C1765a c1765a, int i, C1765a c1765a2) {
        c1765a.getClass();
        c1765a2.getClass();
        c1765a.w0();
        c1765a.subAgents_.set(i, c1765a2);
    }

    public static void q0(C1765a c1765a, int i, z zVar) {
        c1765a.getClass();
        zVar.getClass();
        c1765a.x0();
        c1765a.tools_.set(i, zVar);
    }

    public static void r0(C1765a c1765a, String str) {
        c1765a.getClass();
        str.getClass();
        c1765a.version_ = str;
    }

    public static void s0(C1765a c1765a, ByteString byteString) {
        c1765a.getClass();
        AbstractC0932e.g(byteString);
        c1765a.version_ = byteString.q();
    }

    public final String B0() {
        return this.description_;
    }

    public final ByteString C0() {
        return ByteString.f(this.description_);
    }

    public final C1816n D0(int i) {
        return (C1816n) this.hooks_.get(i);
    }

    public final int E0() {
        return this.hooks_.size();
    }

    public final List F0() {
        return this.hooks_;
    }

    public final String G0() {
        return this.instructions_;
    }

    public final ByteString H0() {
        return ByteString.f(this.instructions_);
    }

    public final v I0() {
        v vVar = this.modelConfig_;
        return vVar == null ? v.X() : vVar;
    }

    public final String J0() {
        return this.name_;
    }

    public final ByteString K0() {
        return ByteString.f(this.name_);
    }

    public final x L0(int i) {
        return (x) this.skills_.get(i);
    }

    public final int M0() {
        return this.skills_.size();
    }

    public final List N0() {
        return this.skills_;
    }

    public final C1765a O0(int i) {
        return (C1765a) this.subAgents_.get(i);
    }

    public final int P0() {
        return this.subAgents_.size();
    }

    public final List Q0() {
        return this.subAgents_;
    }

    public final z R0(int i) {
        return (z) this.tools_.get(i);
    }

    public final int S0() {
        return this.tools_.size();
    }

    public final List T0() {
        return this.tools_;
    }

    public final String U0() {
        return this.version_;
    }

    public final ByteString V0() {
        return ByteString.f(this.version_);
    }

    public final boolean W0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\n\u0000\u0001\u0001\u000b\n\u0000\u0004\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005ဉ\u0000\u0006Ȉ\u0007\u001b\b\u001b\n\u001b\u000b\u001b", new Object[]{"bitField0_", "agentId_", "name_", "version_", "description_", "modelConfig_", "instructions_", "subAgents_", C1765a.class, "tools_", z.class, "hooks_", C1816n.class, "skills_", x.class});
            case 3:
                return new C1765a();
            case 4:
                return new AgentInfo$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1765a.class) {
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

    public final void u0() {
        InterfaceC0985r1 interfaceC0985r1 = this.hooks_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.hooks_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final void v0() {
        InterfaceC0985r1 interfaceC0985r1 = this.skills_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.skills_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final void w0() {
        InterfaceC0985r1 interfaceC0985r1 = this.subAgents_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.subAgents_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final void x0() {
        InterfaceC0985r1 interfaceC0985r1 = this.tools_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.tools_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final String y0() {
        return this.agentId_;
    }

    public final ByteString z0() {
        return ByteString.f(this.agentId_);
    }
}
