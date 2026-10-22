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
import com.zyql.protobuf.skull.Execution$Builder;
import java.util.List;

/* loaded from: classes2.dex */
public final class e extends GeneratedMessageLite implements Y1 {
    private static final e DEFAULT_INSTANCE;
    public static final int ITEMS_FIELD_NUMBER = 1;
    private static volatile InterfaceC0955j2 PARSER;
    private InterfaceC0985r1 items_ = C0967m2.d;

    static {
        e eVar = new e();
        DEFAULT_INSTANCE = eVar;
        GeneratedMessageLite.C(e.class, eVar);
    }

    public static void D(e eVar, Iterable iterable) {
        eVar.K();
        AbstractC0928d.addAll(iterable, (List) eVar.items_);
    }

    public static void E(e eVar, int i, h hVar) {
        eVar.getClass();
        hVar.getClass();
        eVar.K();
        eVar.items_.add(i, hVar);
    }

    public static void F(e eVar, h hVar) {
        eVar.getClass();
        hVar.getClass();
        eVar.K();
        eVar.items_.add(hVar);
    }

    public static void G(e eVar) {
        eVar.getClass();
        eVar.items_ = C0967m2.d;
    }

    public static void H(e eVar, int i) {
        eVar.K();
        eVar.items_.remove(i);
    }

    public static void I(e eVar, int i, h hVar) {
        eVar.getClass();
        hVar.getClass();
        eVar.K();
        eVar.items_.set(i, hVar);
    }

    public final void K() {
        InterfaceC0985r1 interfaceC0985r1 = this.items_;
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return;
        }
        this.items_ = GeneratedMessageLite.x(interfaceC0985r1);
    }

    public final h L(int i) {
        return (h) this.items_.get(i);
    }

    public final int M() {
        return this.items_.size();
    }

    public final List N() {
        return this.items_;
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"items_", h.class});
            case 3:
                return new e();
            case 4:
                return new Execution$Builder(0);
            case 5:
                return DEFAULT_INSTANCE;
            case 6:
                InterfaceC0955j2 interfaceC0955j2 = PARSER;
                if (interfaceC0955j2 != null) {
                    return interfaceC0955j2;
                }
                synchronized (e.class) {
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
