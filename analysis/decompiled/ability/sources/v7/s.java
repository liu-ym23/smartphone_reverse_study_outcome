package v7;

import com.google.protobuf.AbstractC0928d;
import com.google.protobuf.AbstractC0940g;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0967m2;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.InterfaceC0985r1;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Message$Builder;
import com.zyql.protobuf.skull.TaskOutput$Builder;
import java.util.List;

/* loaded from: classes2.dex */
public final class s extends GeneratedMessageLite implements Y1 {
    public static final int ARTIFACTS_FIELD_NUMBER = 2;
    private static final s DEFAULT_INSTANCE;
    public static final int MESSAGE_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER;
    private InterfaceC0985r1 artifacts_ = C0967m2.d;
    private int bitField0_;
    private i message_;

    static {
        s sVar = new s();
        DEFAULT_INSTANCE = sVar;
        GeneratedMessageLite.C(s.class, sVar);
    }

    public static void D(s sVar, Iterable iterable) {
        sVar.N();
        AbstractC0928d.addAll(iterable, (List) sVar.artifacts_);
    }

    public static void E(s sVar, int i, l lVar) {
        sVar.getClass();
        lVar.getClass();
        sVar.N();
        sVar.artifacts_.add(i, lVar);
    }

    public static void F(s sVar, l lVar) {
        sVar.getClass();
        lVar.getClass();
        sVar.N();
        sVar.artifacts_.add(lVar);
    }

    public static void G(s sVar) {
        sVar.getClass();
        sVar.artifacts_ = C0967m2.d;
    }

    public static void H(s sVar) {
        sVar.message_ = null;
        sVar.bitField0_ &= -2;
    }

    public static void I(s sVar, i iVar) {
        sVar.getClass();
        iVar.getClass();
        i iVar2 = sVar.message_;
        if (iVar2 == null || iVar2 == i.T()) {
            sVar.message_ = iVar;
        } else {
            sVar.message_ = (i) ((Message$Builder) i.a0(sVar.message_).mergeFrom((GeneratedMessageLite) iVar)).m();
        }
        sVar.bitField0_ |= 1;
    }

    public static void J(s sVar, int i) {
        sVar.N();
        sVar.artifacts_.remove(i);
    }

    public static void K(s sVar, int i, l lVar) {
        sVar.getClass();
        lVar.getClass();
        sVar.N();
        sVar.artifacts_.set(i, lVar);
    }

    public static void L(s sVar, i iVar) {
        sVar.getClass();
        iVar.getClass();
        sVar.message_ = iVar;
        sVar.bitField0_ |= 1;
    }

    public static s R() {
        return DEFAULT_INSTANCE;
    }

    public static TaskOutput$Builder U(s sVar) {
        return (TaskOutput$Builder) DEFAULT_INSTANCE.q(sVar);
    }

    public final void N() {
        InterfaceC0985r1 interfaceC0985r1 = this.artifacts_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.artifacts_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final l O(int i) {
        return (l) this.artifacts_.get(i);
    }

    public final int P() {
        return this.artifacts_.size();
    }

    public final List Q() {
        return this.artifacts_;
    }

    public final i S() {
        i iVar = this.message_;
        return iVar == null ? i.T() : iVar;
    }

    public final boolean T() {
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", new Object[]{"bitField0_", "message_", "artifacts_", l.class});
            case 3:
                return new s();
            case 4:
                return new TaskOutput$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (s.class) {
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
