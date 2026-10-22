package u7;

import com.google.protobuf.AbstractC0928d;
import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.AbstractC0940g;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0967m2;
import com.google.protobuf.C0971n2;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.InterfaceC0985r1;
import com.google.protobuf.Struct;
import com.google.protobuf.Y1;
import com.zyql.protobuf.runtime.ExecutionOptions$Builder;
import com.zyql.protobuf.runtime.StartAgentRequest$Builder;
import java.util.List;
import q7.C1808f;

/* loaded from: classes2.dex */
public final class q extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    private static final q DEFAULT_INSTANCE;
    public static final int MESSAGES_FIELD_NUMBER = 4;
    public static final int METADATA_FIELD_NUMBER = 5;
    public static final int OPTIONS_FIELD_NUMBER = 6;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 3;
    public static final int USER_ID_FIELD_NUMBER = 2;
    private int bitField0_;
    private Struct metadata_;
    private f options_;
    private String agentId_ = "";
    private String userId_ = "";
    private String sessionId_ = "";
    private InterfaceC0985r1 messages_ = C0967m2.d;

    static {
        q qVar = new q();
        DEFAULT_INSTANCE = qVar;
        GeneratedMessageLite.C(q.class, qVar);
    }

    public static void D(q qVar, Iterable iterable) {
        qVar.Y();
        AbstractC0928d.addAll(iterable, (List) qVar.messages_);
    }

    public static void E(q qVar, int i, C1808f c1808f) {
        qVar.getClass();
        c1808f.getClass();
        qVar.Y();
        qVar.messages_.add(i, c1808f);
    }

    public static void F(q qVar, C1808f c1808f) {
        qVar.getClass();
        c1808f.getClass();
        qVar.Y();
        qVar.messages_.add(c1808f);
    }

    public static void G(q qVar) {
        qVar.getClass();
        qVar.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void H(q qVar) {
        qVar.getClass();
        qVar.messages_ = C0967m2.d;
    }

    public static void I(q qVar) {
        qVar.metadata_ = null;
        qVar.bitField0_ &= -3;
    }

    public static void J(q qVar) {
        qVar.options_ = null;
        qVar.bitField0_ &= -5;
    }

    public static void K(q qVar) {
        qVar.bitField0_ &= -2;
        qVar.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void L(q qVar) {
        qVar.getClass();
        qVar.userId_ = DEFAULT_INSTANCE.userId_;
    }

    public static void M(q qVar, f fVar) {
        qVar.getClass();
        fVar.getClass();
        f fVar2 = qVar.options_;
        if (fVar2 == null || fVar2 == f.P()) {
            qVar.options_ = fVar;
        } else {
            qVar.options_ = (f) ((ExecutionOptions$Builder) f.c0(qVar.options_).mergeFrom((GeneratedMessageLite) fVar)).m();
        }
        qVar.bitField0_ |= 4;
    }

    public static void N(q qVar, int i) {
        qVar.Y();
        qVar.messages_.remove(i);
    }

    public static void O(q qVar, String str) {
        qVar.getClass();
        str.getClass();
        qVar.agentId_ = str;
    }

    public static void P(q qVar, ByteString byteString) {
        qVar.getClass();
        AbstractC0932e.g(byteString);
        qVar.agentId_ = byteString.q();
    }

    public static void Q(q qVar, int i, C1808f c1808f) {
        qVar.getClass();
        c1808f.getClass();
        qVar.Y();
        qVar.messages_.set(i, c1808f);
    }

    public static void R(q qVar, Struct struct) {
        qVar.getClass();
        struct.getClass();
        qVar.metadata_ = struct;
        qVar.bitField0_ |= 2;
    }

    public static void S(q qVar, f fVar) {
        qVar.getClass();
        fVar.getClass();
        qVar.options_ = fVar;
        qVar.bitField0_ |= 4;
    }

    public static void T(q qVar, String str) {
        qVar.getClass();
        str.getClass();
        qVar.bitField0_ |= 1;
        qVar.sessionId_ = str;
    }

    public static void U(q qVar, ByteString byteString) {
        qVar.getClass();
        AbstractC0932e.g(byteString);
        qVar.sessionId_ = byteString.q();
        qVar.bitField0_ |= 1;
    }

    public static void V(q qVar, String str) {
        qVar.getClass();
        str.getClass();
        qVar.userId_ = str;
    }

    public static void W(q qVar, ByteString byteString) {
        qVar.getClass();
        AbstractC0932e.g(byteString);
        qVar.userId_ = byteString.q();
    }

    public static q b0() {
        return DEFAULT_INSTANCE;
    }

    public static StartAgentRequest$Builder p0() {
        return (StartAgentRequest$Builder) DEFAULT_INSTANCE.p();
    }

    public static StartAgentRequest$Builder q0(q qVar) {
        return (StartAgentRequest$Builder) DEFAULT_INSTANCE.q(qVar);
    }

    public final void Y() {
        InterfaceC0985r1 interfaceC0985r1 = this.messages_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.messages_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final String Z() {
        return this.agentId_;
    }

    public final ByteString a0() {
        return ByteString.f(this.agentId_);
    }

    public final C1808f c0(int i) {
        return (C1808f) this.messages_.get(i);
    }

    public final int d0() {
        return this.messages_.size();
    }

    public final List e0() {
        return this.messages_;
    }

    public final Struct f0() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.e : struct;
    }

    public final f g0() {
        f fVar = this.options_;
        return fVar == null ? f.P() : fVar;
    }

    public final String h0() {
        return this.sessionId_;
    }

    public final ByteString i0() {
        return ByteString.f(this.sessionId_);
    }

    public final String j0() {
        return this.userId_;
    }

    public final ByteString k0() {
        return ByteString.f(this.userId_);
    }

    public final boolean l0() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean m0() {
        return (this.bitField0_ & 4) != 0;
    }

    public final boolean n0() {
        return (this.bitField0_ & 1) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void o0(Struct struct) {
        struct.getClass();
        Struct struct2 = this.metadata_;
        if (struct2 == null || struct2 == Struct.e) {
            this.metadata_ = struct;
        } else {
            this.metadata_ = (Struct) ((C1014y2) Struct.F(struct2).mergeFrom((GeneratedMessageLite) struct)).m();
        }
        this.bitField0_ |= 2;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003ለ\u0000\u0004\u001b\u0005ဉ\u0001\u0006ဉ\u0002", new Object[]{"bitField0_", "agentId_", "userId_", "sessionId_", "messages_", C1808f.class, "metadata_", "options_"});
            case 3:
                return new q();
            case 4:
                return new StartAgentRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (q.class) {
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
