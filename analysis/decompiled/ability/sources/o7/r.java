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
import com.zyql.protobuf.agent.InlineSkill$Builder;
import java.util.List;

/* loaded from: classes2.dex */
public final class r extends GeneratedMessageLite implements Y1 {
    private static final r DEFAULT_INSTANCE;
    public static final int DESCRIPTION_FIELD_NUMBER = 2;
    public static final int FILES_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER;
    private String name_ = "";
    private String description_ = "";
    private InterfaceC0985r1 files_ = C0967m2.d;

    static {
        r rVar = new r();
        DEFAULT_INSTANCE = rVar;
        GeneratedMessageLite.C(r.class, rVar);
    }

    public static void D(r rVar, Iterable iterable) {
        rVar.Q();
        AbstractC0928d.addAll(iterable, (List) rVar.files_);
    }

    public static void E(r rVar, int i, k kVar) {
        rVar.getClass();
        kVar.getClass();
        rVar.Q();
        rVar.files_.add(i, kVar);
    }

    public static void F(r rVar, k kVar) {
        rVar.getClass();
        kVar.getClass();
        rVar.Q();
        rVar.files_.add(kVar);
    }

    public static void G(r rVar) {
        rVar.getClass();
        rVar.description_ = DEFAULT_INSTANCE.description_;
    }

    public static void H(r rVar) {
        rVar.getClass();
        rVar.files_ = C0967m2.d;
    }

    public static void I(r rVar) {
        rVar.getClass();
        rVar.name_ = DEFAULT_INSTANCE.name_;
    }

    public static void J(r rVar, int i) {
        rVar.Q();
        rVar.files_.remove(i);
    }

    public static void K(r rVar, String str) {
        rVar.getClass();
        str.getClass();
        rVar.description_ = str;
    }

    public static void L(r rVar, ByteString byteString) {
        rVar.getClass();
        AbstractC0932e.g(byteString);
        rVar.description_ = byteString.q();
    }

    public static void M(r rVar, int i, k kVar) {
        rVar.getClass();
        kVar.getClass();
        rVar.Q();
        rVar.files_.set(i, kVar);
    }

    public static void N(r rVar, String str) {
        rVar.getClass();
        str.getClass();
        rVar.name_ = str;
    }

    public static void O(r rVar, ByteString byteString) {
        rVar.getClass();
        AbstractC0932e.g(byteString);
        rVar.name_ = byteString.q();
    }

    public static r R() {
        return DEFAULT_INSTANCE;
    }

    public static InlineSkill$Builder Z(r rVar) {
        return (InlineSkill$Builder) DEFAULT_INSTANCE.q(rVar);
    }

    public final void Q() {
        InterfaceC0985r1 interfaceC0985r1 = this.files_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.files_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final String S() {
        return this.description_;
    }

    public final ByteString T() {
        return ByteString.f(this.description_);
    }

    public final k U(int i) {
        return (k) this.files_.get(i);
    }

    public final int V() {
        return this.files_.size();
    }

    public final List W() {
        return this.files_;
    }

    public final String X() {
        return this.name_;
    }

    public final ByteString Y() {
        return ByteString.f(this.name_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u001b", new Object[]{"name_", "description_", "files_", k.class});
            case 3:
                return new r();
            case 4:
                return new InlineSkill$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (r.class) {
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
