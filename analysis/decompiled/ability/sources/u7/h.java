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
import com.zyql.protobuf.runtime.GetAgentInfoResponse$Builder;
import java.util.List;

/* loaded from: classes2.dex */
public final class h extends GeneratedMessageLite implements Y1 {
    public static final int AGENT_ID_FIELD_NUMBER = 1;
    public static final int AGENT_NAME_FIELD_NUMBER = 2;
    public static final int CAPABILITIES_FIELD_NUMBER = 5;
    private static final h DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    public static final int METADATA_FIELD_NUMBER = 6;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 4;
    private int bitField0_;
    private Struct metadata_;
    private String agentId_ = "";
    private String agentName_ = "";
    private String description_ = "";
    private String version_ = "";
    private InterfaceC0985r1 capabilities_ = C0967m2.d;

    static {
        h hVar = new h();
        DEFAULT_INSTANCE = hVar;
        GeneratedMessageLite.C(h.class, hVar);
    }

    public static void D(h hVar, Iterable iterable) {
        hVar.X();
        AbstractC0928d.addAll(iterable, (List) hVar.capabilities_);
    }

    public static void E(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.X();
        hVar.capabilities_.add(str);
    }

    public static void F(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.X();
        hVar.capabilities_.add(byteString.q());
    }

    public static void G(h hVar) {
        hVar.getClass();
        hVar.agentId_ = DEFAULT_INSTANCE.agentId_;
    }

    public static void H(h hVar) {
        hVar.getClass();
        hVar.agentName_ = DEFAULT_INSTANCE.agentName_;
    }

    public static void I(h hVar) {
        hVar.getClass();
        hVar.capabilities_ = C0967m2.d;
    }

    public static void J(h hVar) {
        hVar.bitField0_ &= -2;
        hVar.description_ = DEFAULT_INSTANCE.description_;
    }

    public static void K(h hVar) {
        hVar.metadata_ = null;
        hVar.bitField0_ &= -5;
    }

    public static void L(h hVar) {
        hVar.bitField0_ &= -3;
        hVar.version_ = DEFAULT_INSTANCE.version_;
    }

    public static void M(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.agentId_ = str;
    }

    public static void N(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.agentId_ = byteString.q();
    }

    public static void O(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.agentName_ = str;
    }

    public static void P(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.agentName_ = byteString.q();
    }

    public static void Q(h hVar, int i, String str) {
        hVar.getClass();
        str.getClass();
        hVar.X();
        hVar.capabilities_.set(i, str);
    }

    public static void R(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.bitField0_ |= 1;
        hVar.description_ = str;
    }

    public static void S(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.description_ = byteString.q();
        hVar.bitField0_ |= 1;
    }

    public static void T(h hVar, Struct struct) {
        hVar.getClass();
        struct.getClass();
        hVar.metadata_ = struct;
        hVar.bitField0_ |= 4;
    }

    public static void U(h hVar, String str) {
        hVar.getClass();
        str.getClass();
        hVar.bitField0_ |= 2;
        hVar.version_ = str;
    }

    public static void V(h hVar, ByteString byteString) {
        hVar.getClass();
        AbstractC0932e.g(byteString);
        hVar.version_ = byteString.q();
        hVar.bitField0_ |= 2;
    }

    public final void X() {
        InterfaceC0985r1 interfaceC0985r1 = this.capabilities_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.capabilities_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final String Y() {
        return this.agentId_;
    }

    public final ByteString Z() {
        return ByteString.f(this.agentId_);
    }

    public final String a0() {
        return this.agentName_;
    }

    public final ByteString b0() {
        return ByteString.f(this.agentName_);
    }

    public final String c0(int i) {
        return (String) this.capabilities_.get(i);
    }

    public final ByteString d0(int i) {
        return ByteString.f((String) this.capabilities_.get(i));
    }

    public final int e0() {
        return this.capabilities_.size();
    }

    public final List f0() {
        return this.capabilities_;
    }

    public final String g0() {
        return this.description_;
    }

    public final ByteString h0() {
        return ByteString.f(this.description_);
    }

    public final Struct i0() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.e : struct;
    }

    public final String j0() {
        return this.version_;
    }

    public final ByteString k0() {
        return ByteString.f(this.version_);
    }

    public final boolean l0() {
        return (this.bitField0_ & 1) != 0;
    }

    public final boolean m0() {
        return (this.bitField0_ & 4) != 0;
    }

    public final boolean n0() {
        return (this.bitField0_ & 2) != 0;
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
        this.bitField0_ |= 4;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003ለ\u0000\u0004ለ\u0001\u0005Ț\u0006ဉ\u0002", new Object[]{"bitField0_", "agentId_", "agentName_", "description_", "version_", "capabilities_", "metadata_"});
            case 3:
                return new h();
            case 4:
                return new GetAgentInfoResponse$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (h.class) {
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
