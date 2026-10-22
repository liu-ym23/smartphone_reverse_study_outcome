package o7;

import com.google.protobuf.AbstractC0928d;
import com.google.protobuf.AbstractC0940g;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0967m2;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.InterfaceC0985r1;
import com.google.protobuf.Y1;
import com.zyql.protobuf.agent.CompletionRequest$Builder;
import com.zyql.protobuf.agent.ModelConfig$Builder;
import java.util.List;

/* renamed from: o7.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1769e extends GeneratedMessageLite implements Y1 {
    public static final int CONFIG_FIELD_NUMBER = 1;
    private static final C1769e DEFAULT_INSTANCE;
    public static final int MESSAGES_FIELD_NUMBER = 2;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int TOOLS_FIELD_NUMBER = 3;
    private int bitField0_;
    private v config_;
    private InterfaceC0985r1 messages_;
    private InterfaceC0985r1 tools_;

    static {
        C1769e c1769e = new C1769e();
        DEFAULT_INSTANCE = c1769e;
        GeneratedMessageLite.C(C1769e.class, c1769e);
    }

    public C1769e() {
        C0967m2 c0967m2 = C0967m2.d;
        this.messages_ = c0967m2;
        this.tools_ = c0967m2;
    }

    public static void D(C1769e c1769e, Iterable iterable) {
        c1769e.T();
        AbstractC0928d.addAll(iterable, (List) c1769e.messages_);
    }

    public static void E(C1769e c1769e, Iterable iterable) {
        c1769e.U();
        AbstractC0928d.addAll(iterable, (List) c1769e.tools_);
    }

    public static void F(C1769e c1769e, int i, C1768d c1768d) {
        c1769e.getClass();
        c1768d.getClass();
        c1769e.T();
        c1769e.messages_.add(i, c1768d);
    }

    public static void G(C1769e c1769e, C1768d c1768d) {
        c1769e.getClass();
        c1768d.getClass();
        c1769e.T();
        c1769e.messages_.add(c1768d);
    }

    public static void H(C1769e c1769e, int i, z zVar) {
        c1769e.getClass();
        zVar.getClass();
        c1769e.U();
        c1769e.tools_.add(i, zVar);
    }

    public static void I(C1769e c1769e, z zVar) {
        c1769e.getClass();
        zVar.getClass();
        c1769e.U();
        c1769e.tools_.add(zVar);
    }

    public static void J(C1769e c1769e) {
        c1769e.config_ = null;
        c1769e.bitField0_ &= -2;
    }

    public static void K(C1769e c1769e) {
        c1769e.getClass();
        c1769e.messages_ = C0967m2.d;
    }

    public static void L(C1769e c1769e) {
        c1769e.getClass();
        c1769e.tools_ = C0967m2.d;
    }

    public static void M(C1769e c1769e, v vVar) {
        c1769e.getClass();
        vVar.getClass();
        v vVar2 = c1769e.config_;
        if (vVar2 == null || vVar2 == v.X()) {
            c1769e.config_ = vVar;
        } else {
            c1769e.config_ = (v) ((ModelConfig$Builder) v.n0(c1769e.config_).mergeFrom((GeneratedMessageLite) vVar)).m();
        }
        c1769e.bitField0_ |= 1;
    }

    public static void N(C1769e c1769e, int i) {
        c1769e.T();
        c1769e.messages_.remove(i);
    }

    public static void O(C1769e c1769e, int i) {
        c1769e.U();
        c1769e.tools_.remove(i);
    }

    public static void P(C1769e c1769e, v vVar) {
        c1769e.getClass();
        vVar.getClass();
        c1769e.config_ = vVar;
        c1769e.bitField0_ |= 1;
    }

    public static void Q(C1769e c1769e, int i, C1768d c1768d) {
        c1769e.getClass();
        c1768d.getClass();
        c1769e.T();
        c1769e.messages_.set(i, c1768d);
    }

    public static void R(C1769e c1769e, int i, z zVar) {
        c1769e.getClass();
        zVar.getClass();
        c1769e.U();
        c1769e.tools_.set(i, zVar);
    }

    public final void T() {
        InterfaceC0985r1 interfaceC0985r1 = this.messages_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.messages_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final void U() {
        InterfaceC0985r1 interfaceC0985r1 = this.tools_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.tools_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final v V() {
        v vVar = this.config_;
        return vVar == null ? v.X() : vVar;
    }

    public final C1768d W(int i) {
        return (C1768d) this.messages_.get(i);
    }

    public final int X() {
        return this.messages_.size();
    }

    public final List Y() {
        return this.messages_;
    }

    public final z Z(int i) {
        return (z) this.tools_.get(i);
    }

    public final int a0() {
        return this.tools_.size();
    }

    public final List b0() {
        return this.tools_;
    }

    public final boolean c0() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u001b", new Object[]{"bitField0_", "config_", "messages_", C1768d.class, "tools_", z.class});
            case 3:
                return new C1769e();
            case 4:
                return new CompletionRequest$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (C1769e.class) {
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
