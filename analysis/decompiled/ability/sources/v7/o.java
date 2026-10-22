package v7;

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
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Agent$Builder;
import com.zyql.protobuf.skull.Task$Builder;
import com.zyql.protobuf.skull.TaskInput$Builder;
import com.zyql.protobuf.skull.TaskOutput$Builder;
import com.zyql.protobuf.skull.User$Builder;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class o extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_FIELD_NUMBER = 8;
    public static final int CHILD_TASK_IDS_FIELD_NUMBER = 3;
    private static final o DEFAULT_INSTANCE;
    public static final int ERROR_FIELD_NUMBER = 10;
    public static final int EXECUTION_FIELD_NUMBER = 13;
    public static final int INPUT_FIELD_NUMBER = 11;
    public static final int META_DATA_FIELD_NUMBER = 103;
    public static final int ORIGIN_TASK_ID_FIELD_NUMBER = 4;
    public static final int OUTPUT_FIELD_NUMBER = 12;
    public static final int PARENT_TASK_ID_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int STATUS_FIELD_NUMBER = 9;
    public static final int TASK_ID_FIELD_NUMBER = 1;
    public static final int USER_FIELD_NUMBER = 7;
    private C2062a agent_;
    private int bitField0_;
    private InterfaceC0985r1 childTaskIds_;
    private String error_;
    private InterfaceC0985r1 execution_;
    private r input_;
    private String originTaskId_;
    private s output_;
    private String status_;
    private y user_;
    private MapFieldLite<String, String> metaData_ = MapFieldLite.b;
    private String taskId_ = "";
    private String parentTaskId_ = "";

    static {
        o oVar = new o();
        DEFAULT_INSTANCE = oVar;
        GeneratedMessageLite.C(o.class, oVar);
    }

    public o() {
        C0967m2 c0967m2 = C0967m2.d;
        this.childTaskIds_ = c0967m2;
        this.originTaskId_ = "";
        this.status_ = "";
        this.error_ = "";
        this.execution_ = c0967m2;
    }

    public static void D(o oVar, Iterable iterable) {
        oVar.r0();
        AbstractC0928d.addAll(iterable, (List) oVar.childTaskIds_);
    }

    public static void E(o oVar, Iterable iterable) {
        oVar.s0();
        AbstractC0928d.addAll(iterable, (List) oVar.execution_);
    }

    public static void F(o oVar, String str) {
        oVar.getClass();
        str.getClass();
        oVar.r0();
        oVar.childTaskIds_.add(str);
    }

    public static void G(o oVar, ByteString byteString) {
        oVar.getClass();
        AbstractC0932e.g(byteString);
        oVar.r0();
        oVar.childTaskIds_.add(byteString.q());
    }

    public static void H(o oVar, int i, h hVar) {
        oVar.getClass();
        hVar.getClass();
        oVar.s0();
        oVar.execution_.add(i, hVar);
    }

    public static void I(o oVar, h hVar) {
        oVar.getClass();
        hVar.getClass();
        oVar.s0();
        oVar.execution_.add(hVar);
    }

    public static void J(o oVar) {
        oVar.agent_ = null;
        oVar.bitField0_ &= -3;
    }

    public static void K(o oVar) {
        oVar.getClass();
        oVar.childTaskIds_ = C0967m2.d;
    }

    public static void L(o oVar) {
        oVar.getClass();
        oVar.error_ = DEFAULT_INSTANCE.error_;
    }

    public static void M(o oVar) {
        oVar.getClass();
        oVar.execution_ = C0967m2.d;
    }

    public static void N(o oVar) {
        oVar.input_ = null;
        oVar.bitField0_ &= -5;
    }

    public static void O(o oVar) {
        oVar.getClass();
        oVar.originTaskId_ = DEFAULT_INSTANCE.originTaskId_;
    }

    public static void P(o oVar) {
        oVar.output_ = null;
        oVar.bitField0_ &= -9;
    }

    public static void Q(o oVar) {
        oVar.getClass();
        oVar.parentTaskId_ = DEFAULT_INSTANCE.parentTaskId_;
    }

    public static void R(o oVar) {
        oVar.getClass();
        oVar.status_ = DEFAULT_INSTANCE.status_;
    }

    public static void S(o oVar) {
        oVar.getClass();
        oVar.taskId_ = DEFAULT_INSTANCE.taskId_;
    }

    public static void T(o oVar) {
        oVar.user_ = null;
        oVar.bitField0_ &= -2;
    }

    public static MapFieldLite U(o oVar) {
        MapFieldLite<String, String> mapFieldLite = oVar.metaData_;
        if (!mapFieldLite.f2856a) {
            oVar.metaData_ = mapFieldLite.h();
        }
        return oVar.metaData_;
    }

    public static Task$Builder U0(o oVar) {
        return (Task$Builder) DEFAULT_INSTANCE.q(oVar);
    }

    public static void V(o oVar, C2062a c2062a) {
        oVar.getClass();
        c2062a.getClass();
        C2062a c2062a2 = oVar.agent_;
        if (c2062a2 == null || c2062a2 == C2062a.Q()) {
            oVar.agent_ = c2062a;
        } else {
            oVar.agent_ = (C2062a) ((Agent$Builder) C2062a.Z(oVar.agent_).mergeFrom((GeneratedMessageLite) c2062a)).m();
        }
        oVar.bitField0_ |= 2;
    }

    public static void W(o oVar, r rVar) {
        oVar.getClass();
        rVar.getClass();
        r rVar2 = oVar.input_;
        if (rVar2 == null || rVar2 == r.L()) {
            oVar.input_ = rVar;
        } else {
            oVar.input_ = (r) ((TaskInput$Builder) r.P(oVar.input_).mergeFrom((GeneratedMessageLite) rVar)).m();
        }
        oVar.bitField0_ |= 4;
    }

    public static void X(o oVar, s sVar) {
        oVar.getClass();
        sVar.getClass();
        s sVar2 = oVar.output_;
        if (sVar2 == null || sVar2 == s.R()) {
            oVar.output_ = sVar;
        } else {
            oVar.output_ = (s) ((TaskOutput$Builder) s.U(oVar.output_).mergeFrom((GeneratedMessageLite) sVar)).m();
        }
        oVar.bitField0_ |= 8;
    }

    public static void Y(o oVar, y yVar) {
        oVar.getClass();
        yVar.getClass();
        y yVar2 = oVar.user_;
        if (yVar2 == null || yVar2 == y.H()) {
            oVar.user_ = yVar;
        } else {
            oVar.user_ = (y) ((User$Builder) y.K(oVar.user_).mergeFrom((GeneratedMessageLite) yVar)).m();
        }
        oVar.bitField0_ |= 1;
    }

    public static void Z(o oVar, int i) {
        oVar.s0();
        oVar.execution_.remove(i);
    }

    public static void a0(o oVar, C2062a c2062a) {
        oVar.getClass();
        c2062a.getClass();
        oVar.agent_ = c2062a;
        oVar.bitField0_ |= 2;
    }

    public static void b0(o oVar, int i, String str) {
        oVar.getClass();
        str.getClass();
        oVar.r0();
        oVar.childTaskIds_.set(i, str);
    }

    public static void c0(o oVar, String str) {
        oVar.getClass();
        str.getClass();
        oVar.error_ = str;
    }

    public static void d0(o oVar, ByteString byteString) {
        oVar.getClass();
        AbstractC0932e.g(byteString);
        oVar.error_ = byteString.q();
    }

    public static void e0(o oVar, int i, h hVar) {
        oVar.getClass();
        hVar.getClass();
        oVar.s0();
        oVar.execution_.set(i, hVar);
    }

    public static void f0(o oVar, r rVar) {
        oVar.getClass();
        rVar.getClass();
        oVar.input_ = rVar;
        oVar.bitField0_ |= 4;
    }

    public static void g0(o oVar, String str) {
        oVar.getClass();
        str.getClass();
        oVar.originTaskId_ = str;
    }

    public static void h0(o oVar, ByteString byteString) {
        oVar.getClass();
        AbstractC0932e.g(byteString);
        oVar.originTaskId_ = byteString.q();
    }

    public static void i0(o oVar, s sVar) {
        oVar.getClass();
        sVar.getClass();
        oVar.output_ = sVar;
        oVar.bitField0_ |= 8;
    }

    public static void j0(o oVar, String str) {
        oVar.getClass();
        str.getClass();
        oVar.parentTaskId_ = str;
    }

    public static void k0(o oVar, ByteString byteString) {
        oVar.getClass();
        AbstractC0932e.g(byteString);
        oVar.parentTaskId_ = byteString.q();
    }

    public static void l0(o oVar, String str) {
        oVar.getClass();
        str.getClass();
        oVar.status_ = str;
    }

    public static void m0(o oVar, ByteString byteString) {
        oVar.getClass();
        AbstractC0932e.g(byteString);
        oVar.status_ = byteString.q();
    }

    public static void n0(o oVar, String str) {
        oVar.getClass();
        str.getClass();
        oVar.taskId_ = str;
    }

    public static void o0(o oVar, ByteString byteString) {
        oVar.getClass();
        AbstractC0932e.g(byteString);
        oVar.taskId_ = byteString.q();
    }

    public static void p0(o oVar, y yVar) {
        oVar.getClass();
        yVar.getClass();
        oVar.user_ = yVar;
        oVar.bitField0_ |= 1;
    }

    public static o y0() {
        return DEFAULT_INSTANCE;
    }

    public final ByteString A0() {
        return ByteString.f(this.error_);
    }

    public final h B0(int i) {
        return (h) this.execution_.get(i);
    }

    public final int C0() {
        return this.execution_.size();
    }

    public final List D0() {
        return this.execution_;
    }

    public final r E0() {
        r rVar = this.input_;
        return rVar == null ? r.L() : rVar;
    }

    public final Map F0() {
        return Collections.unmodifiableMap(this.metaData_);
    }

    public final String G0() {
        return this.originTaskId_;
    }

    public final ByteString H0() {
        return ByteString.f(this.originTaskId_);
    }

    public final s I0() {
        s sVar = this.output_;
        return sVar == null ? s.R() : sVar;
    }

    public final String J0() {
        return this.parentTaskId_;
    }

    public final ByteString K0() {
        return ByteString.f(this.parentTaskId_);
    }

    public final String L0() {
        return this.status_;
    }

    public final ByteString M0() {
        return ByteString.f(this.status_);
    }

    public final String N0() {
        return this.taskId_;
    }

    public final ByteString O0() {
        return ByteString.f(this.taskId_);
    }

    public final y P0() {
        y yVar = this.user_;
        return yVar == null ? y.H() : yVar;
    }

    public final boolean Q0() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean R0() {
        return (this.bitField0_ & 4) != 0;
    }

    public final boolean S0() {
        return (this.bitField0_ & 8) != 0;
    }

    public final boolean T0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\f\u0000\u0001\u0001g\f\u0001\u0002\u0000\u0001Ȉ\u0002Ȉ\u0003Ț\u0004Ȉ\u0007ဉ\u0000\bဉ\u0001\tȈ\nȈ\u000bဉ\u0002\fဉ\u0003\r\u001bg2", new Object[]{"bitField0_", "taskId_", "parentTaskId_", "childTaskIds_", "originTaskId_", "user_", "agent_", "status_", "error_", "input_", "output_", "execution_", h.class, "metaData_", n.f6787a});
            case 3:
                return new o();
            case 4:
                return new Task$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (o.class) {
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

    public final void r0() {
        InterfaceC0985r1 interfaceC0985r1 = this.childTaskIds_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.childTaskIds_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final void s0() {
        InterfaceC0985r1 interfaceC0985r1 = this.execution_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.execution_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final C2062a t0() {
        C2062a c2062a = this.agent_;
        return c2062a == null ? C2062a.Q() : c2062a;
    }

    public final String u0(int i) {
        return (String) this.childTaskIds_.get(i);
    }

    public final ByteString v0(int i) {
        return ByteString.f((String) this.childTaskIds_.get(i));
    }

    public final int w0() {
        return this.childTaskIds_.size();
    }

    public final List x0() {
        return this.childTaskIds_;
    }

    public final String z0() {
        return this.error_;
    }
}
