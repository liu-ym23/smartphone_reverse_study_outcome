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
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Message$Builder;
import java.util.List;

/* loaded from: classes2.dex */
public final class i extends GeneratedMessageLite implements Y1 {
    public static final int CONTENT_FIELD_NUMBER = 2;
    private static final i DEFAULT_INSTANCE;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int RESOURCES_FIELD_NUMBER = 3;
    public static final int ROLE_FIELD_NUMBER = 1;
    private String role_ = "";
    private String content_ = "";
    private InterfaceC0985r1 resources_ = C0967m2.d;

    static {
        i iVar = new i();
        DEFAULT_INSTANCE = iVar;
        GeneratedMessageLite.C(i.class, iVar);
    }

    public static void D(i iVar, Iterable iterable) {
        iVar.Q();
        AbstractC0928d.addAll(iterable, (List) iVar.resources_);
    }

    public static void E(i iVar, int i, l lVar) {
        iVar.getClass();
        lVar.getClass();
        iVar.Q();
        iVar.resources_.add(i, lVar);
    }

    public static void F(i iVar, l lVar) {
        iVar.getClass();
        lVar.getClass();
        iVar.Q();
        iVar.resources_.add(lVar);
    }

    public static void G(i iVar) {
        iVar.getClass();
        iVar.content_ = DEFAULT_INSTANCE.content_;
    }

    public static void H(i iVar) {
        iVar.getClass();
        iVar.resources_ = C0967m2.d;
    }

    public static void I(i iVar) {
        iVar.getClass();
        iVar.role_ = DEFAULT_INSTANCE.role_;
    }

    public static void J(i iVar, int i) {
        iVar.Q();
        iVar.resources_.remove(i);
    }

    public static void K(i iVar, String str) {
        iVar.getClass();
        str.getClass();
        iVar.content_ = str;
    }

    public static void L(i iVar, ByteString byteString) {
        iVar.getClass();
        AbstractC0932e.g(byteString);
        iVar.content_ = byteString.q();
    }

    public static void M(i iVar, int i, l lVar) {
        iVar.getClass();
        lVar.getClass();
        iVar.Q();
        iVar.resources_.set(i, lVar);
    }

    public static void N(i iVar, String str) {
        iVar.getClass();
        str.getClass();
        iVar.role_ = str;
    }

    public static void O(i iVar, ByteString byteString) {
        iVar.getClass();
        AbstractC0932e.g(byteString);
        iVar.role_ = byteString.q();
    }

    public static i T() {
        return DEFAULT_INSTANCE;
    }

    public static Message$Builder Z() {
        return (Message$Builder) DEFAULT_INSTANCE.p();
    }

    public static Message$Builder a0(i iVar) {
        return (Message$Builder) DEFAULT_INSTANCE.q(iVar);
    }

    public final void Q() {
        InterfaceC0985r1 interfaceC0985r1 = this.resources_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.resources_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final String R() {
        return this.content_;
    }

    public final ByteString S() {
        return ByteString.f(this.content_);
    }

    public final l U(int i) {
        return (l) this.resources_.get(i);
    }

    public final int V() {
        return this.resources_.size();
    }

    public final List W() {
        return this.resources_;
    }

    public final String X() {
        return this.role_;
    }

    public final ByteString Y() {
        return ByteString.f(this.role_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b", new Object[]{"role_", "content_", "resources_", l.class});
            case 3:
                return new i();
            case 4:
                return new Message$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (i.class) {
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
