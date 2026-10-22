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
import com.zyql.protobuf.runtime.SendInputRequest$Builder;
import java.util.List;
import q7.C1808f;

/* loaded from: classes2.dex */
public final class o extends GeneratedMessageLite implements Y1 {
    private static final o DEFAULT_INSTANCE;
    public static final int MESSAGES_FIELD_NUMBER = 2;
    public static final int METADATA_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 1;
    private int bitField0_;
    private Struct metadata_;
    private String sessionId_ = "";
    private InterfaceC0985r1 messages_ = C0967m2.d;

    static {
        o oVar = new o();
        DEFAULT_INSTANCE = oVar;
        GeneratedMessageLite.C(o.class, oVar);
    }

    public static void D(o oVar, Iterable iterable) {
        oVar.P();
        AbstractC0928d.addAll(iterable, (List) oVar.messages_);
    }

    public static void E(o oVar, int i, C1808f c1808f) {
        oVar.getClass();
        c1808f.getClass();
        oVar.P();
        oVar.messages_.add(i, c1808f);
    }

    public static void F(o oVar, C1808f c1808f) {
        oVar.getClass();
        c1808f.getClass();
        oVar.P();
        oVar.messages_.add(c1808f);
    }

    public static void G(o oVar) {
        oVar.getClass();
        oVar.messages_ = C0967m2.d;
    }

    public static void H(o oVar) {
        oVar.metadata_ = null;
        oVar.bitField0_ &= -2;
    }

    public static void I(o oVar) {
        oVar.getClass();
        oVar.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static void J(o oVar, int i) {
        oVar.P();
        oVar.messages_.remove(i);
    }

    public static void K(o oVar, int i, C1808f c1808f) {
        oVar.getClass();
        c1808f.getClass();
        oVar.P();
        oVar.messages_.set(i, c1808f);
    }

    public static void L(o oVar, Struct struct) {
        oVar.getClass();
        struct.getClass();
        oVar.metadata_ = struct;
        oVar.bitField0_ |= 1;
    }

    public static void M(o oVar, String str) {
        oVar.getClass();
        str.getClass();
        oVar.sessionId_ = str;
    }

    public static void N(o oVar, ByteString byteString) {
        oVar.getClass();
        AbstractC0932e.g(byteString);
        oVar.sessionId_ = byteString.q();
    }

    public static o Q() {
        return DEFAULT_INSTANCE;
    }

    public static SendInputRequest$Builder Z() {
        return (SendInputRequest$Builder) DEFAULT_INSTANCE.p();
    }

    public static SendInputRequest$Builder a0(o oVar) {
        return (SendInputRequest$Builder) DEFAULT_INSTANCE.q(oVar);
    }

    public final void P() {
        InterfaceC0985r1 interfaceC0985r1 = this.messages_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.messages_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final C1808f R(int i) {
        return (C1808f) this.messages_.get(i);
    }

    public final int S() {
        return this.messages_.size();
    }

    public final List T() {
        return this.messages_;
    }

    public final Struct U() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.e : struct;
    }

    public final String V() {
        return this.sessionId_;
    }

    public final ByteString W() {
        return ByteString.f(this.sessionId_);
    }

    public final boolean X() {
        return (this.bitField0_ & 1) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(Struct struct) {
        struct.getClass();
        Struct struct2 = this.metadata_;
        if (struct2 == null || struct2 == Struct.e) {
            this.metadata_ = struct;
        } else {
            this.metadata_ = (Struct) ((C1014y2) Struct.F(struct2).mergeFrom((GeneratedMessageLite) struct)).m();
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u001b\u0003ဉ\u0000", new Object[]{"bitField0_", "sessionId_", "messages_", C1808f.class, "metadata_"});
            case 3:
                return new o();
            case 4:
                return new SendInputRequest$Builder(0);
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
}
