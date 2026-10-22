package v7;

import com.google.protobuf.AbstractC0932e;
import com.google.protobuf.ByteString;
import com.google.protobuf.C0922b1;
import com.google.protobuf.C0971n2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InterfaceC0955j2;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.TaskContext$Builder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class q extends GeneratedMessageLite implements Y1 {
    public static final int CONTEXT_ID_FIELD_NUMBER = 1;
    private static final q DEFAULT_INSTANCE;
    public static final int META_FIELD_NUMBER = 3;
    private static volatile InterfaceC0955j2 PARSER = null;
    public static final int SESSION_ID_FIELD_NUMBER = 2;
    private MapFieldLite<String, String> meta_ = MapFieldLite.b;
    private String contextId_ = "";
    private String sessionId_ = "";

    static {
        q qVar = new q();
        DEFAULT_INSTANCE = qVar;
        GeneratedMessageLite.C(q.class, qVar);
    }

    public static void D(q qVar) {
        qVar.getClass();
        qVar.contextId_ = DEFAULT_INSTANCE.contextId_;
    }

    public static void E(q qVar) {
        qVar.getClass();
        qVar.sessionId_ = DEFAULT_INSTANCE.sessionId_;
    }

    public static MapFieldLite F(q qVar) {
        MapFieldLite<String, String> mapFieldLite = qVar.meta_;
        if (!mapFieldLite.f2856a) {
            qVar.meta_ = mapFieldLite.h();
        }
        return qVar.meta_;
    }

    public static void G(q qVar, String str) {
        qVar.getClass();
        str.getClass();
        qVar.contextId_ = str;
    }

    public static void H(q qVar, ByteString byteString) {
        qVar.getClass();
        AbstractC0932e.g(byteString);
        qVar.contextId_ = byteString.q();
    }

    public static void I(q qVar, String str) {
        qVar.getClass();
        str.getClass();
        qVar.sessionId_ = str;
    }

    public static void J(q qVar, ByteString byteString) {
        qVar.getClass();
        AbstractC0932e.g(byteString);
        qVar.sessionId_ = byteString.q();
    }

    public static q N() {
        return DEFAULT_INSTANCE;
    }

    public static TaskContext$Builder R(q qVar) {
        return (TaskContext$Builder) DEFAULT_INSTANCE.q(qVar);
    }

    public final String L() {
        return this.contextId_;
    }

    public final ByteString M() {
        return ByteString.f(this.contextId_);
    }

    public final Map O() {
        return Collections.unmodifiableMap(this.meta_);
    }

    public final String P() {
        return this.sessionId_;
    }

    public final ByteString Q() {
        return ByteString.f(this.sessionId_);
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
                return new C0971n2(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u00032", new Object[]{"contextId_", "sessionId_", "meta_", p.f6788a});
            case 3:
                return new q();
            case 4:
                return new TaskContext$Builder(0);
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
